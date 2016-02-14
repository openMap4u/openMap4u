package org.openmap4u.plugin.format.graphics2d;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.imageio.ImageIO;

import org.openmap4u.commons.Angle;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Globals;
import org.openmap4u.commons.ImageStyleable;
import org.openmap4u.interfaces.Drawable;
import org.openmap4u.commons.Length;
import org.openmap4u.commons.ShapeStyle;
import org.openmap4u.commons.ShapeStyleable;
import org.openmap4u.commons.TextStyleable;
import org.openmap4u.commons.ImageStyleable;
import org.openmap4u.commons.TransformUtil;
import org.openmap4u.commons.Util;
import org.openmap4u.format.Outputable;
import org.openmap4u.plugin.builder.core.Polygon;

/**
 * All 2D Plugins are drived from this base class.
 *
 * @author Michael Hadrbolec
 */
abstract class AbstractJava2dPlugin implements Outputable {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(
			AbstractJava2dPlugin.class.getName(),
			Globals.DEFAULT_RESSOURCE_BUNDLE);

	private AffineTransform mFontSCaleBack = new AffineTransform(.01, 0, 0,
			.01, 0, 0);

	private static final int DPI = 96;

	private static final double DOT = 72;

	private static final double ZERO_POINT_5 = 0.5;

	private double mStrokeUnits2DrawingUnits = 0;

	/**
	 * Each output fromat relies heavily on affine transformations, and has
	 * therefore an own instance of the Transform Util class.
	 */
	private final TransformUtil mTransformUtil = new TransformUtil();

	/**
	 * Stores the raster quality in dots per inch.
	 */
	private int mDPI = DPI;

	/**
	 * Stores the font render context.
	 */
	private FontRenderContext mFontRenderContext = null;
	/**
	 * The font transformation.
	 */
	private AffineTransform mFontTransformation = null;

	/**
	 * Stores the buffered image on which will be drawn.
	 */
	private BufferedImage mBufferedImage = null;
	/**
	 *
	 * Stores the reference to the graphics2D context.
	 */
	private Graphics2D mG2D = null;
	/**
	 * Stores the global transformation.
	 */
	private AffineTransform mGlobalTransform = null;
	private double mDrawingUnit2PixelFactor = Double.NaN;
	private double mStrokeUnit2PixelFactor = Double.NaN;
	private MimeType mMimeType = null;

	protected AbstractJava2dPlugin(MimeType mimeType) {
		this.mMimeType = mimeType;
	}

	/**
	 * Gets the affine transformation.
	 *
	 * @param point
	 *            The point (optional).
	 * @param individual
	 *            The individual transformation.
	 * @param shape
	 *            The shape.
	 * @return The resulting affine transformation.
	 */
	final AffineTransform getTransform(Point2D point,
			DrawableTransformable individual, Shape shape) {
		AffineTransform global = getGlobalTransform();
		return this.mTransformUtil.transform(global, point,
				1 / global.getScaleX() * this.mDrawingUnit2PixelFactor, -1
						/ global.getScaleY() * this.mDrawingUnit2PixelFactor,
				individual, shape);
	}

	public Shape draw(Point2D point, Drawable<ShapeStyleable,Path2D> shape, Shape shapeBounds) {
		/* set the alphaValue */
		this.mG2D.setComposite(AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, (float) shape.getStyle().getAlpha()));
		/* set the stroke size */
		this.mG2D.setStroke(new BasicStroke((float) (shape.getStyle()
				.getStrokeSize() * this.mStrokeUnit2PixelFactor),
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		/* first get teh global transformation */
		AffineTransform transform = getTransform(point, shape.getTransform(),
				shapeBounds);
		/* create the trasnformed shape that will be drawn */
		Shape tshape = transform.createTransformedShape(shape.getPrimitive());
		/* fill the shape if a fill value was provided */
		if (shape.getStyle().getStrokeFill() != null) {
			this.mG2D.setPaint(shape.getStyle().getStrokeFill());
			this.mG2D.fill(tshape);
		}
		/* draw the outline of the shape if a value was provided */
		if (shape.getStyle().getStrokeColor() != null) {
			this.mG2D.setPaint(shape.getStyle().getStrokeColor());
			this.mG2D.draw(tshape);
		}
		return tshape;
	}

	@Override
	public Shape drawShape(Point2D point, Drawable<ShapeStyleable,Path2D> shape) {
		return draw(point, shape, shape.getPrimitive());
	}

	@Override
	public Shape drawImage(Point2D point, Drawable<ImageStyleable,Path> image) {
		Shape imageOutline = null;
		try {
			/* get the image */
			BufferedImage img = Util.get().getImage(image.getPrimitive());
			/* set the alphaValue */
			this.mG2D.setComposite(AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, (float) image.getStyle()
							.getAlpha()));
			/*
			 * take the multiplication factor into acount, as well as the
			 * coordinate system
			 */
			AffineTransform transform = getTransform(point,
					image.getTransform(),
					new Rectangle2D.Double(0, 0, img.getWidth()
							/ this.mDrawingUnit2PixelFactor, img.getHeight()
							/ this.mDrawingUnit2PixelFactor));
			transform.concatenate(new AffineTransform(
					1 / this.mDrawingUnit2PixelFactor, 0, 0, -1
							/ this.mDrawingUnit2PixelFactor, 0, img.getHeight()
							/ this.mDrawingUnit2PixelFactor));
			this.mG2D.drawImage(img, transform, null);
			imageOutline = transform
					.createTransformedShape(new Rectangle2D.Double(0, 0, img
							.getWidth(), img.getHeight()));
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "", e);
		}
		return imageOutline;
	}

	@Override
	public Shape drawText(Point2D point, Drawable<TextStyleable,String> text) {
		/*
		 * derive the path from the glyph vector so that the transformation can
		 * be applied
		 */
		Font font = getFont(text.getStyle());
		GlyphVector glyphVector = font.createGlyphVector(
				this.mFontRenderContext, text.getPrimitive());
		Shape fontPath = this.mFontSCaleBack.createTransformedShape(glyphVector
				.getOutline());
		// TODO default style for font
		Polygon shape2Draw = new Polygon().style(new ShapeStyle()).fill(text.getStyle().getFontColor())
				.color(null).transparence(text.getStyle().getAlpha())
				.shape(fontPath);
		if (text.getTransform().getAlign() != null) {
			shape2Draw.align(text.getTransform().getAlign().getX(), text
					.getTransform().getAlign().getY());
		}
		shape2Draw.build().setTransform( text.getTransform());
		Shape outline = new Rectangle2D.Double(0, 0, fontPath.getBounds2D()
				.getWidth(), text.getStyle().getFontSize()
				* mStrokeUnits2DrawingUnits);
	draw( point, shape2Draw.build(), outline);
		return outline;

	}

	/**
	 * Gets the font.
	 *
	 * @param style
	 *            The font style.
	 * @return The resulting font.
	 */
	Font getFont(TextStyleable style) {
		String fontFamily = Font.SANS_SERIF;
		int fontStyle = Font.PLAIN;
		if (style.getFontFamily() != null) {
			fontFamily = style.getFontFamily();
		}
		if (style.getFontStyle() != null) {
			switch (style.getFontStyle()) {
			case ITALIC:
				fontStyle = Font.ITALIC;
				break;
			default:
				fontStyle = Font.PLAIN;
				break;
			}
		}
		return new Font(fontFamily, fontStyle,
				(int) (style.getFontSize() * this.mStrokeUnits2DrawingUnits
						* 100 * DPI / DOT + ZERO_POINT_5))
				.deriveFont(mFontTransformation);
	}

	@Override
	public final void setUp(Shape shape, final Length worldUnits,
			final Length drawingUnits, final Length strokeUnits,
			Angle angleUnits, final AffineTransform globalTransform) {
		/*
		 * first calculate the multiplication factore with which world, drawing
		 * and stroke units have to be multiplied in order to get pixel.
		 */
		double mWorldUnit2PixelFactor = worldUnits.convert(1, Length.PIXEL);
		this.mDrawingUnit2PixelFactor = drawingUnits.convert(1, Length.PIXEL);
		this.mStrokeUnit2PixelFactor = strokeUnits.convert(1, Length.PIXEL);
		this.mStrokeUnits2DrawingUnits = strokeUnits.convert(1, drawingUnits);
		/* create the buffered image */
		Dimension canvasDimension = getCanvasSize(shape,drawingUnits);
		this.mBufferedImage = new BufferedImage(canvasDimension.width,
				canvasDimension.height, BufferedImage.TYPE_4BYTE_ABGR);
		/* generate the global transformation */
		/* first change the orientation of the coordinate system */
		globalTransform.preConcatenate(new AffineTransform(
				mWorldUnit2PixelFactor, 0, 0, -mWorldUnit2PixelFactor, 0,
				mBufferedImage.getHeight()));
		this.mGlobalTransform = globalTransform;
		/* set the font render context */
		this.mFontTransformation = new AffineTransform(1d, 0, 0, -1d, 0, 0);
		this.mFontRenderContext = new FontRenderContext(this.mGlobalTransform,
				true, true);
	}

	/**
	 * Gets the canvas size in pixel.
	 * 
	 * @param canvasShape
	 *            The shape of the canvas.
	 * @param drawingUnits
	 *            The drawing units.
	 * @return The canvas size in pixel.
	 */
	final Dimension getCanvasSize(Shape canvasShape, Length drawingUnits) {
		return new Dimension((int) drawingUnits.convert(canvasShape
				.getBounds2D().getWidth(), Length.PIXEL),
				(int) drawingUnits.convert(
						canvasShape.getBounds2D().getHeight(), Length.PIXEL));
	}

	@Override
	public void before() {
		/* Gets a refernece to the graphics instance */
		this.mG2D = (Graphics2D) this.mBufferedImage.getGraphics();
		/* set the rendering hints */
		this.mG2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}

	@Override
	public void after() {
		/* free resources */
		this.mG2D.dispose();
	}

	@Override
	public void tearDown() {

	}

	@Override
	public void write(OutputStream out) throws IOException {
		ImageIO.write(this.mBufferedImage, this.mMimeType.getSubType(), out);
	}

	/**
	 * Gets the dots per inch.
	 *
	 * @return The dots per inch.
	 */
	final int getDPI() {
		return this.mDPI;
	}

	/**
	 * Gets the cloned global affine transformation.
	 *
	 * @return The cloned global affine transformation.
	 */
	@Override
	public final AffineTransform getGlobalTransform() {
		return (AffineTransform) this.mGlobalTransform.clone();
	}

}
