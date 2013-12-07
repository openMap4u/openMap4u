/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.format.svg;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.openmap4u.Globals;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Position;
import org.openmap4u.commons.TransformUtil;
import org.openmap4u.commons.Util;
import org.openmap4u.format.Outputable;
import org.openmap4u.primitive.ImageDrawable;
import org.openmap4u.primitive.ShapeDrawable;
import org.openmap4u.primitive.TextDrawable;
import org.openmap4u.style.TextStyle;
import org.openmap4u.style.TextStyleable;
import org.openmap4u.unit.Angle;
import org.openmap4u.unit.Length;

/**
 *
 * @author hadrbolec
 */
public class Svg implements Outputable {

    /**
     * The logger.
     */
    private static final Logger LOGGER = Logger.getLogger(
            Svg.class.getName(), Globals.DEFAULT_RESSOURCE_BUNDLE);

    private boolean mIsInitialized = false;

    private AffineTransform mGlobalTransform = null;

    private File mTmpFile;
    private XMLStreamWriter mWriter = null;
    private double mPixel2DrawingUnitsFactor;

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    private TransformUtil mTransformUtil = new TransformUtil();

    interface Constants {

        String SVG = "svg";
        String DTD = "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">";
        String PATH = "path";
        /* The svg namespace. */
        String NAMESPACE_URI = "http://www.w3.org/2000/svg";
        String TRANSFORM = "transform";

    }

    private double mStrokeUnit2DrawingUnitFactor;

    /**
     * The DTD.
     */
    public Svg() {
    }

    @Override
    public Rectangle2D drawShape(Point2D point,
            ShapeDrawable shape) {

        /* first get the global transformation */
        AffineTransform transform = getTransform(point, shape.getTransform(), shape.getShape());
        /* create the transformed shape that will be drawn */
        Shape tshape = transform.createTransformedShape(shape.getShape());

        try {
            mWriter.writeStartElement(Constants.PATH);
            mWriter.writeAttribute("d", getSvgPathAttributeValue(tshape));
            mWriter.writeAttribute(
                    "style",
                    new StyleBuilder()
                    .writeStrokeWidth(
                            shape.getStyle().getStrokeSize()
                            * this.mStrokeUnit2DrawingUnitFactor)
                    .writeStroke(shape.getStyle().getStrokeColor())
                    .writeFill(shape.getStyle().getStrokeFill()).writeOpacity(shape.getStyle().getAlpha()).toString());
            mWriter.writeEndElement();
        } catch (XMLStreamException e) {
            LOGGER.log(Level.WARNING, "", e);
        }
        return tshape.getBounds2D();
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
        return this.mTransformUtil.transform(getGlobalTransform(), point, 1,1,individual, shape);
    }

    final AffineTransform getGlobalTransform() {
        return (AffineTransform) this.mGlobalTransform.clone();
    }

    String getSvgPathAttributeValue(Shape shape) {
        StringBuilder sb = new StringBuilder();
        PathIterator pi = shape.getPathIterator(null);
        double[] coords = new double[SIX];
        while (!pi.isDone()) {
            int type = pi.currentSegment(coords);
            switch (type) {
                case PathIterator.SEG_MOVETO:
                    sb.append("M").append(getCoordinatePair(coords[ZERO], coords[ONE]));
                    break;
                case PathIterator.SEG_LINETO:
                    sb.append("L").append(getCoordinatePair(coords[ZERO], coords[ONE]));
                    break;
                case PathIterator.SEG_QUADTO:
                    sb.append("Q").append(getCoordinatePair(coords[ZERO], coords[ONE]))
                            .append(getCoordinatePair(coords[TWO], coords[THREE]));
                    break;
                case PathIterator.SEG_CUBICTO:
                    sb.append("C").append(getCoordinatePair(coords[ZERO], coords[ONE]))
                            .append(getCoordinatePair(coords[TWO], coords[THREE]))
                            .append(getCoordinatePair(coords[FOUR], coords[FIVE]));
                    break;
                default:
                    break;
            }
            pi.next();
        }
        return sb.toString();
    }

    String getCoordinatePair(double x, double y) {
        return new StringBuilder().append(x).append(",").append(y).append(" ")
                .toString();
    }

    @Override
    public Rectangle2D drawImage(Point2D point,
            ImageDrawable image) {
//        try {
//            mWriter.writeStartElement("image");
//            mWriter.writeAttribute("x", "0");
//            mWriter.writeAttribute("y", "0");
//            mWriter.writeAttribute("http://www.w3.org/1999/xlink", "href",
//                    path2image.toUri().toString());
//            Rectangle2D.Double imageSize = Util.get().getImageSize(path2image);
//            mWriter.writeAttribute(
//                    "width",
//                    String.valueOf(imageSize.getWidth()
//                            / mPixel2DrawingUnitsFactor));
//            mWriter.writeAttribute(
//                    "height",
//                    String.valueOf(imageSize.getHeight()
//                            / mPixel2DrawingUnitsFactor));
//            individualTransform.preConcatenate(new AffineTransform(1, 0, 0, -1,
//                    0, imageSize.getHeight() / mPixel2DrawingUnitsFactor));
//            mWriter.writeAttribute(
//                    Constants.TRANSFORM,
//                    new SvgUtil().getTransform(Util.get().getTransform(
//                                    mGlobalTransform, point, individualTransform,
//                                    style.getHorizontalAlign(),
//                                    style.getVerticalAlign(),
//                                    Util.get().getImageSize(path2image))));
//            mWriter.writeEndElement();
//        } catch (XMLStreamException e) {
//            LOGGER.log(Level.WARNING, "", e);
//
//        } catch (IOException e) {
//            LOGGER.log(Level.WARNING, "", e);
//
//        }
        // TODOD
        return null;
    }

    @Override
    public Rectangle2D drawText(Point2D point,
            TextDrawable text) {
//        try {
//            mWriter.writeStartElement("text");
//            mWriter.writeAttribute("x", "0");
//            mWriter.writeAttribute("y", "0");
//
//            individualTransform.preConcatenate(new AffineTransform(1, 0, 0, -1,
//                    0, 0));
//            mWriter.writeAttribute(
//                    Constants.TRANSFORM,
//                    new SvgUtil().getTransform(Util.get().getTransform(
//                                    mGlobalTransform, point, individualTransform)));
//            mWriter.writeAttribute("style", getFontStyle(text.getTransform().getAlign(), text.getStyle()));
//            mWriter.writeCharacters(text.getText());
//            mWriter.writeEndElement();
//        } catch (XMLStreamException e) {
//            LOGGER.log(Level.WARNING, "", e);
//
//        }
// TODO
        return null;
    }

    String getFontStyle(Position align, TextStyleable style) {
        StyleBuilder sb = new StyleBuilder();
        sb.setFontSize(style.getFontSize() * this.mStrokeUnit2DrawingUnitFactor);
        sb.setTextAlign(align);
        sb.setTextColor(style.getFontColor());
        sb.writeOpacity(style.getAlpha());
        sb.setFontStyle(style.getFontStyle());
        sb.setFontFamily(style.getFontFamily());
        return sb.toString();
    }

    /**
     *
     * @param unit
     * @param drawingUnits
     * @return
     */
    protected static double getMultiplicationFactor(Length unit,
            Length drawingUnits) {
        return unit.convert(1, drawingUnits);
    }

    @Override
    public void setUp(Shape shape, Length worldUnits,
            Length drawingUnits, Length strokeUnits, Angle angleUnits,
            AffineTransform globalTransform) {
        /*
         * prepare first calculate the multiplication factore with which world,
         * drawing and stroke units have to be multiplied in order to get pixel.
         */
        double mWorldUnit2DrawingUnitFactor = getMultiplicationFactor(worldUnits,
                drawingUnits);
        this.mStrokeUnit2DrawingUnitFactor = getMultiplicationFactor(
                strokeUnits, drawingUnits);

        this.mPixel2DrawingUnitsFactor = drawingUnits.convert(1, Length.PIXEL);
        globalTransform.preConcatenate(new AffineTransform(
                mWorldUnit2DrawingUnitFactor, 0, 0,
                -mWorldUnit2DrawingUnitFactor, 0, shape.getBounds2D().getHeight()));
        this.mGlobalTransform = globalTransform;

        try {
            mTmpFile = new File(System.getProperty("java.io.tmpdir"),
                    new StringBuilder(UUID.randomUUID().toString())
                    .append(File.pathSeparator).append(Constants.SVG)
                    .toString());
            mWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(
                    new FileOutputStream(this.mTmpFile), "UTF-8");

            mWriter.writeStartDocument("UTF-8", "1.0");
            mWriter.writeDTD(Constants.DTD);
            mWriter.writeStartElement(Constants.SVG);
            mWriter.writeNamespace("xmlns", Constants.NAMESPACE_URI);
            mWriter.writeNamespace("xlink", "http://www.w3.org/1999/xlink");
            mWriter.writeAttribute("version", "1.1");
            Rectangle2D bounds = shape.getBounds2D();
            mWriter.writeAttribute("width", drawingUnits.convert(bounds.getWidth(), Length.CM) + "cm");
            mWriter.writeAttribute("height", drawingUnits.convert(bounds.getHeight(), Length.CM) + "cm");
            mWriter.writeAttribute("viewBox", "0 0 " + drawingUnits.convert(bounds.getWidth(), Length.CM) + " " + drawingUnits.convert(bounds.getHeight(), Length.CM));

            /* write the defaults */
            mWriter.writeStartElement("defs");
            mWriter.writeStartElement("style");
            mWriter.writeAttribute("type", "text/css");
            mWriter.writeCData("path {fill:none;fill-rule:evenodd;font-size:0.5cm;}");
            mWriter.writeEndElement();
            mWriter.writeEndElement();

            this.mIsInitialized = true;
        } catch (FileNotFoundException | XMLStreamException | FactoryConfigurationError e) {
            Logger.getLogger(Svg.class.getName()).log(Level.SEVERE, null,
                    e);
        }
    }

    @Override
    public void before() {
    }

    @Override
    public void after() {
    }

    @Override
    public void tearDown() {
        /* remove the temporary svg file */
        try {
            this.mTmpFile.delete();
        } catch (Exception e) {
            Logger.getLogger(Svg.class.getName()).log(Level.SEVERE, null,
                    e);
        }
    }

    @Override
    public void write(OutputStream out) throws IOException {
        try {
            mWriter.writeEndElement();
            mWriter.writeEndDocument();
            mWriter.close();
            /* Stream the file to thegiven output stream */
            Files.copy(this.mTmpFile.toPath(), out);
        } catch (XMLStreamException ex) {
            Logger.getLogger(Svg.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    @Override
    public boolean isInitialized() {
        return this.mIsInitialized;
    }

}
