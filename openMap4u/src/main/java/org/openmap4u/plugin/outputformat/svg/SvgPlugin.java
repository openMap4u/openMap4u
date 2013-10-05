/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.outputformat.svg;

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
import java.nio.file.Path;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.openmap4u.Globals;
import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.Util;
import org.openmap4u.commons.VerticalAlign;
import org.openmap4u.outputformat.OutputFormat;
import org.openmap4u.style.ImageStyleable;
import org.openmap4u.style.ShapeStyleable;
import org.openmap4u.style.TextStyleable;
import org.openmap4u.unit.Length;

/**
 * 
 * @author hadrbolec
 */
public class SvgPlugin extends OutputFormat {

    /**
     * The logger.
     */
    private static final Logger LOGGER = Logger.getLogger(
            SvgPlugin.class.getName(), Globals.DEFAULT_RESSOURCE_BUNDLE);

    private boolean mIsInitialized = false;

    private AffineTransform mGlobalTransform = null;

    private File mTmpFile;
    private XMLStreamWriter mWriter = null;
    private double mPixel2DrawingUnitsFactor;
    
    private static final int ZERO =0;
    private static final int ONE =1;
    private static final int TWO =2;
    private static final int THREE =3;
    private static final int FOUR =4;
    private static final int FIVE =5;
    private static final int SIX=6;
    

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

    public SvgPlugin() {
        super(Util.get().getMimeType("image", "svg"));
    }

    @Override
    public void drawShape(Shape shape, Point2D.Double point,
            AffineTransform individualTransform, ShapeStyleable style) {

        /* first get the global transformation */
        AffineTransform transform = getTransform(point, individualTransform,
                style.getHorizontalAlign(), style.getVerticalAlign(), shape);
        /* create the transformed shape that will be drawn */
        Shape tshape = transform.createTransformedShape(shape);

        try {
            mWriter.writeStartElement(Constants.PATH);
            mWriter.writeAttribute("d", getSvgPathAttributeValue(tshape));
            mWriter.writeAttribute(
                    "style",
                    new StyleBuilder()
                            .writeStrokeWidth(
                                    style.getStrokeSize()
                                            * this.mStrokeUnit2DrawingUnitFactor)
                            .writeStroke(style.getStrokeColor())
                            .writeFill(style.getStrokeFill()).writeOpacity(style.getAlpha()).toString());
            mWriter.writeEndElement();
        } catch (XMLStreamException e) {
            LOGGER.log(Level.WARNING, "", e);
        }
    }

    AffineTransform getTransform(Point2D.Double point,
            AffineTransform individualTransform) {
        /* first get teh global transformation */
        AffineTransform transform = (AffineTransform) this.mGlobalTransform
                .clone();
        double scaleX = transform.getScaleX();
        double scaleY = transform.getScaleY();
        /* translate inf necessary */
        if (point != null) {
            transform.translate(point.x, point.y);
            /* compensate world units */
            individualTransform.preConcatenate(new AffineTransform(1 / scaleX,
                    0, 0, -1 / scaleY, 0, 0));
        }
        transform.concatenate(individualTransform);
        return transform;

    }

    AffineTransform getTransform(Point2D.Double point,
            AffineTransform individualTransform,
            HorizontalAlign horizontalAlign, VerticalAlign verticalAlign,
            Shape shape) {
        AffineTransform transform = getTransform(point, individualTransform);
        transform.concatenate(Util.get().getAlignTransform(horizontalAlign,
                verticalAlign, shape));
        return transform;
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
    public void drawImage(Path path2image, Point2D.Double point,
            AffineTransform individualTransform, ImageStyleable style) {
        try {
            mWriter.writeStartElement("image");
            mWriter.writeAttribute("x", "0");
            mWriter.writeAttribute("y", "0");
            mWriter.writeAttribute("http://www.w3.org/1999/xlink", "href",
                    path2image.toUri().toString());
            Rectangle2D.Double imageSize = Util.get().getImageSize(path2image);
            mWriter.writeAttribute(
                    "width",
                    String.valueOf(imageSize.getWidth()
                            / mPixel2DrawingUnitsFactor));
            mWriter.writeAttribute(
                    "height",
                    String.valueOf(imageSize.getHeight()
                            / mPixel2DrawingUnitsFactor));
            individualTransform.preConcatenate(new AffineTransform(1, 0, 0, -1,
                    0, imageSize.getHeight() / mPixel2DrawingUnitsFactor));
            mWriter.writeAttribute(
                    Constants.TRANSFORM,
                    new SvgUtil().getTransform(Util.get().getTransform(
                            mGlobalTransform, point, individualTransform,
                            style.getHorizontalAlign(),
                            style.getVerticalAlign(),
                            Util.get().getImageSize(path2image))));
            mWriter.writeEndElement();
        } catch (XMLStreamException e) {
            LOGGER.log(Level.WARNING, "", e);

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "", e);

        }
    }

    @Override
    public void drawText(String text, Point2D.Double point,
            AffineTransform individualTransform, TextStyleable style) {
        try {
            mWriter.writeStartElement("text");
            mWriter.writeAttribute("x", "0");
            mWriter.writeAttribute("y", "0");

            individualTransform.preConcatenate(new AffineTransform(1, 0, 0, -1,
                    0, 0));
            mWriter.writeAttribute(
                    Constants.TRANSFORM,
                    new SvgUtil().getTransform(Util.get().getTransform(
                            mGlobalTransform, point, individualTransform)));
            mWriter.writeAttribute("style", getFontStyle(style));
            mWriter.writeCharacters(text);
            mWriter.writeEndElement();
        } catch (XMLStreamException e) {
            LOGGER.log(Level.WARNING, "", e);

        }
    }

    String getFontStyle(TextStyleable style) {
        StyleBuilder sb = new StyleBuilder();
        sb.setFontSize(style.getFontSize() * this.mStrokeUnit2DrawingUnitFactor);
        sb.setTextVerticalAlign(style.getVerticalAlign());
        sb.setTextHorizontalAlign(style.getHorizontalAlign());
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
    public void setUp(double width, double height, Length worldUnits,
            Length drawingUnits, Length strokeUnits,
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
                -mWorldUnit2DrawingUnitFactor, 0, height));
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
            mWriter.writeAttribute("width", width + "cm");
            mWriter.writeAttribute("height", height + "cm");
            mWriter.writeAttribute("viewBox", "0 0 " + width + " " + height);

            /* write the defaults */
            mWriter.writeStartElement("defs");
            mWriter.writeStartElement("style");
            mWriter.writeAttribute("type", "text/css");
            mWriter.writeCData("path {fill:none;fill-rule:evenodd;font-size:0.5cm;}");
            mWriter.writeEndElement();
            mWriter.writeEndElement();

            this.mIsInitialized = true;
        } catch (FileNotFoundException | XMLStreamException
                | FactoryConfigurationError e) {
            Logger.getLogger(SvgPlugin.class.getName()).log(Level.SEVERE, null,
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
            Logger.getLogger(SvgPlugin.class.getName()).log(Level.SEVERE, null,
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
            Logger.getLogger(SvgPlugin.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    @Override
    public boolean isInitialized() {
        return this.mIsInitialized;
    }

}
