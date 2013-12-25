package org.openmap4u.plugin.format.graphics2d;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.imageio.ImageIO;

import org.openmap4u.Globals;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.TransformUtil;
import org.openmap4u.commons.Util;
import org.openmap4u.format.Outputable;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.primitive.ImageDrawable;
import org.openmap4u.primitive.ShapeDrawable;
import org.openmap4u.primitive.TextDrawable;
import org.openmap4u.style.TextStyleable;
import org.openmap4u.unit.Angle;
import org.openmap4u.unit.Length;

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

    /**
     * Stores wheter initialized or not.
     */
    private boolean mIsInitialized = false;
    
    private static final int DPI = 96;
    
    private static final double DOT = 72;
    
    private static final double ZERO_POINT_5 = 0.5;

    /**
     * Each output fromat relies heavily on affine transformations, and has
     * therefore an own instance of the Transform Util class.
     */
    private TransformUtil mTransformUtil = new TransformUtil();

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
     * @param point The point (optional).
     * @param individual The individual transformation.
     * @param shape The shape.
     * @return The resulting affine transformation.
     */
    AffineTransform getTransform(Point2D point, DrawableTransformable individual, Shape shape) {
        AffineTransform global = getGlobalTransform();
        return this.mTransformUtil.transform(global, point, 1 / global.getScaleX()
                * this.mDrawingUnit2PixelFactor, -1 / global.getScaleY()
                * this.mDrawingUnit2PixelFactor, individual, shape);
    }
    
    @Override
    public Shape drawShape(Point2D point,
            ShapeDrawable shape) {
        /* set the alphaValue */
        this.mG2D.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, (float) shape.getStyle().getAlpha()));
        /* set the stroke size */
        this.mG2D
                .setStroke(new BasicStroke(
                                (float) (shape.getStyle().getStrokeSize() * this.mStrokeUnit2PixelFactor), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        /* first get teh global transformation */
        AffineTransform transform = getTransform(point, shape.getTransform(), shape.getShape());
        /* create the trasnformed shape that will be drawn */
        Shape tshape = transform.createTransformedShape(shape.getShape());
        /* fill the shape if a fill value was provided */
        if (shape.getStyle().getStrokeFill() != null) {
            this.mG2D.setPaint(shape.getStyle().getStrokeFill());
            this.mG2D.fill(tshape);
        }
        /* draw the outline of the shape if a value was provided */
        if (shape.getStyle().getStrokeColor() != null) {
            this.mG2D.setPaint(Color.RED);
            this.mG2D.setPaint(shape.getStyle().getStrokeColor());
            this.mG2D.draw(tshape);
        }
        return tshape;
    }
    
    @Override
    public Shape drawImage(Point2D point,
            ImageDrawable image) {
        Shape imageOutline = null;
        try {
            /* get the image */
            BufferedImage img = Util.get().getImage(image.getPath());
            /* set the alphaValue */
            this.mG2D.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, (float) image.getStyle().getAlpha()));
            /*
             * take the multiplication factor into acount, as well as the
             * coordinate system
             */
            AffineTransform transform = getTransform(point,
                    image.getTransform(),
                    new Rectangle2D.Double(0, 0,
                            img.getWidth(), img.getHeight()));
            transform.concatenate(new AffineTransform(
                    1 / this.mDrawingUnit2PixelFactor,0,0, -1 / this.mDrawingUnit2PixelFactor,0,img.getHeight()/this.mDrawingUnit2PixelFactor));
            this.mG2D.drawImage(img, transform, null);
            imageOutline = transform.createTransformedShape(new Rectangle2D.Double(0, 0, img.getWidth(), img.getHeight()));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "", e);
        }
        // TODOD 
        return imageOutline;
    }
    
    @Override
    public Shape drawText(Point2D point, TextDrawable text) {
        /*
         * derive the path from the glyph vector so that the transformation can
         * be applied
         */
        Font font = getFont(text.getStyle());
        
        Path2D.Double path = new Path2D.Double(font.createGlyphVector(
                this.mFontRenderContext, text.getText()).getOutline());
        double scaleFactor = 1 / this.mDrawingUnit2PixelFactor;
        
        path.transform(new AffineTransform(scaleFactor, 0, 0, scaleFactor, 0, 0));
        Polygon polygon = new Polygon().fill(text.getStyle().getFontColor()).color(null).transparence(text.getStyle().getAlpha()).align(text.getTransform().getAlign()).offset(text.getTransform().getOffset().getX(), text.getTransform().getOffset().getY()).rotate(text.getTransform().getRotate()).scale(text.getTransform().getScaleX(), text.getTransform().getScaleY()).shape(path);

        //  Polygon polygon = new Polygon().fill(text.getStyle().getFontColor()).color(null).transparence(text.getStyle().getAlpha()).align(text.getTransform().getAlign()).offset(text.getTransform().getOffset().getX(), text.getTransform().getOffset().getY()).rotate(text.getTransform().getRotate()).scale(text.getTransform().getScaleX(), text.getTransform().getScaleX());
        return drawShape(point, polygon);
    }

    /**
     * Gets the font.
     *
     * @param style The font style.
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
        return new Font(fontFamily, fontStyle, (int) (style.getFontSize()
                * mStrokeUnit2PixelFactor * DPI / DOT + ZERO_POINT_5))
                .deriveFont(mFontTransformation);
    }
    
    @Override
    public final void setUp(Shape shape,
            final Length worldUnits, final Length drawingUnits,
            final Length strokeUnits, Angle angleUnits, final AffineTransform globalTransform) {
        /*
         * first calculate the multiplication factore with which world, drawing
         * and stroke units have to be multiplied in order to get pixel.
         */
        double mWorldUnit2PixelFactor = worldUnits.convert(1, Length.PIXEL);
        this.mDrawingUnit2PixelFactor = drawingUnits.convert(1, Length.PIXEL);
        this.mStrokeUnit2PixelFactor = strokeUnits.convert(1, Length.PIXEL);
        /* create the buffered image */
        this.mBufferedImage = new BufferedImage((int) drawingUnits.convert(
                shape.getBounds().getWidth(), Length.PIXEL), (int) drawingUnits.convert(shape.getBounds().getHeight(),
                        Length.PIXEL), BufferedImage.TYPE_4BYTE_ABGR);
        this.mIsInitialized = true;
        /* generate the global transformation */
        /* first change the orientation of the coordinate system */
        globalTransform.preConcatenate(new AffineTransform(
                mWorldUnit2PixelFactor, 0, 0,
                -mWorldUnit2PixelFactor, 0, mBufferedImage.getHeight()));
        this.mGlobalTransform = globalTransform;
        this.mIsInitialized = true;
        /* set the font render context */
        this.mFontTransformation = new AffineTransform(1d, 0, 0, -1d, 0, 0);
        this.mFontRenderContext = new FontRenderContext(this.mGlobalTransform,
                true, true);
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
        this.mIsInitialized = false;
        
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
    
    @Override
    public boolean isInitialized() {
        return this.mIsInitialized;
    }
}
