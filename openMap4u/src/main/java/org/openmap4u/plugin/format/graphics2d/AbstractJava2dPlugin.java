package org.openmap4u.plugin.format.graphics2d;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
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

import org.openmap4u.Globals;
import org.openmap4u.commons.Position;
import org.openmap4u.commons.TransformUtilBackup;
import org.openmap4u.commons.Util;
import org.openmap4u.format.OutputFormat;
import org.openmap4u.style.ImageStyle;
import org.openmap4u.style.ShapeStyle;
import org.openmap4u.style.TextStyle;
import org.openmap4u.unit.Length;

/**
 * 
 * @author Michael Hadrbolec
 */
abstract class AbstractJava2dPlugin extends OutputFormat {

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
    
    private TransformUtilBackup mTransformUtil = new TransformUtilBackup();

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

    protected AbstractJava2dPlugin(MimeType mimeType) {
        super(mimeType);
    }

    @Override
    public Shape drawShape(Shape shape, Point2D point,
            AffineTransform individualTransform, ShapeStyle style) {
        /* set the alphaValue */
        this.mG2D.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, (float) style.getAlpha()));
        /* set the stroke size */
        this.mG2D
                .setStroke(new BasicStroke(
                        (float) (style.getStrokeSize() * this.mStrokeUnit2PixelFactor),BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        /* first get teh global transformation */
        AffineTransform transform = getTransform(point, individualTransform,
                style.getAlign(), shape);
        /* create the trasnformed shape that will be drawn */
        Shape tshape = transform.createTransformedShape(shape);
        /* fill the shape if a fill value was provided */
        if (style.getStrokeFill() != null) {
            this.mG2D.setPaint(style.getStrokeFill());
            this.mG2D.fill(tshape);
        }
        /* draw the outline of the shape if a value was provided */
        if (style.getStrokeColor() != null) {
            this.mG2D.setPaint(Color.RED);
            this.mG2D.setPaint(style.getStrokeColor());
            this.mG2D.draw(tshape);
        }
        return tshape;
      }

    AffineTransform getTransform(Point2D point,
            AffineTransform individualTransform) {
        /* first get teh global transformation */
        AffineTransform transform = (AffineTransform) this.mGlobalTransform
                .clone();
        double scaleX = transform.getScaleX();
        double scaleY = transform.getScaleY();
        /* translate inf necessary */
        if (point != null) {
            transform.translate(point.getX(), point.getY());
            /* compensate world units */
            individualTransform.preConcatenate(new AffineTransform(1 / scaleX
                    * this.mDrawingUnit2PixelFactor, 0, 0, -1 / scaleY
                    * this.mDrawingUnit2PixelFactor, 0, 0));
        }
        transform.concatenate(individualTransform);
        return transform;

    }

    AffineTransform getTransform(Point2D point,
            AffineTransform individualTransform,
            Position align,
            Shape shape) {
        AffineTransform transform = getTransform(point, individualTransform);
        transform.concatenate(mTransformUtil.getAlignTransform(align, shape));
        return transform;
    }

    @Override
    public Shape drawImage(Path path2Image, Point2D point,
            AffineTransform individualTransform, ImageStyle style) {
        Shape imageOutline = null;
        try {
            /* get the image */
            BufferedImage image = Util.get().getImage(path2Image);
            /* set the alphaValue */
            this.mG2D.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, (float) style.getAlpha()));
            /*
             * take the multiplication factor into acount, as well as the
             * coordinate system
             */
            individualTransform.concatenate(new AffineTransform(
                    1 / this.mDrawingUnit2PixelFactor, 0, 0, -1
                            / this.mDrawingUnit2PixelFactor, 0, 0));
            AffineTransform transform = getTransform(point,
                    individualTransform, style.getAlign(),
                     new Rectangle2D.Double(0, 0,
                            image.getWidth(), image.getHeight()));
            this.mG2D.drawImage(image, transform, null);
            imageOutline = transform.createTransformedShape(new Rectangle2D.Double(0,0,image.getWidth(),image.getHeight()));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "", e);
        }
        // TODOD 
        return imageOutline;
    }

    @Override
    public Shape drawText(String text, Point2D point,
            AffineTransform individualTransform, TextStyle style) {
        /*
         * derive the path from the glyph vector so that the transformation can
         * be applied
         */
        ShapeStyle shapeStyle = new ShapeStyle()
                .setStrokeFill(style.getFontColor()).setStrokeColor(null)
                .setAlign(style.getAlign())
                 .setAlpha(style.getAlpha());
        Font font = getFont(style);
        Path2D.Double path = new Path2D.Double(font.createGlyphVector(
                this.mFontRenderContext, text).getOutline());
        double scaleFactor = 1 / this.mDrawingUnit2PixelFactor;

        path.transform(new AffineTransform(scaleFactor, 0, 0, scaleFactor, 0, 0));
        return drawShape(path, point, individualTransform, shapeStyle);
   }

    /**
     * Gets the font.
     * 
     * @param style
     *            The font style.
     * @return The resulting font.
     */
    Font getFont(TextStyle style) {
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
    public final void setUp(final double width, final double height,
            final Length worldUnits, final Length drawingUnits,
            final Length strokeUnits, final AffineTransform globalTransform) {
        /*
         * first calculate the multiplication factore with which world, drawing
         * and stroke units have to be multiplied in order to get pixel.
         */
        double mWorldUnit2PixelFactor = worldUnits.convert(1, Length.PIXEL);
        this.mDrawingUnit2PixelFactor = drawingUnits.convert(1, Length.PIXEL);
        this.mStrokeUnit2PixelFactor = strokeUnits.convert(1, Length.PIXEL);
        /* create the buffered image */
        this.mBufferedImage = new BufferedImage((int) drawingUnits.convert(
                width, Length.PIXEL), (int) drawingUnits.convert(height,
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
        ImageIO.write(this.mBufferedImage, getMimeType().getSubType(), out);
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
    final AffineTransform getGlobalTransformation() {
        return (AffineTransform) this.mGlobalTransform.clone();
    }

    @Override
    public boolean isInitialized() {
        return this.mIsInitialized;
    }
}
