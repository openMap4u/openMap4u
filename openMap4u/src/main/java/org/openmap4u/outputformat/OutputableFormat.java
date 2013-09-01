/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.outputformat;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

import javax.activation.MimeType;

import org.openmap4u.commons.BeforeAfter;
import org.openmap4u.commons.Plugable;
import org.openmap4u.style.ImageStyleable;
import org.openmap4u.style.ShapeStyleable;
import org.openmap4u.style.TextStyleable;
import org.openmap4u.unit.Length;

/**
 * This interface has to be implemented for every output format.
 * 
 * @author Michael Hadrbolec
 */
public interface OutputableFormat extends Plugable, BeforeAfter {

    /**
     * Draws a shape (=vector). After drawing the the primitive the after method
     * is called.
     * 
     * @param shape
     *            The shape primitive to draw.
     * @param point
     * @param individualTransform
     *            The individual transformation of the shape primitive.
     * @param style
     *            The style of the shape primitive.
     */
    void drawShape(Shape shape, Point2D.Double point,
            AffineTransform individualTransform, ShapeStyleable style);

    /**
     * Draws an image. After drawing the the primitive the after method is
     * called.
     * 
     * @param image
     *            The image primitive to draw.
     * @param point
     * @param individualTransform
     *            The individual transformation of the image primitive.
     * @param style
     *            The style of the image primitive.
     */
    void drawImage(Path image, Point2D.Double point,
            AffineTransform individualTransform, ImageStyleable style);

    /**
     * Draws a text. Before drawing the primitive the before method is calles.
     * After drawing the the primitive the after method is called.
     * 
     * @param text
     *            The text primitive to drawn.
     * @param point
     * @param individualTransform
     *            The individual transformation of the text primitive.
     * @param style
     *            The style of the text primitive.
     */
    void drawText(String text, Point2D.Double point,
            AffineTransform individualTransform, TextStyleable style);

    /**
     * Is only called once, before anything is drawn.
     * 
     * @param width
     *            The canvas width in drawing units.
     * @param heigth
     *            The canvas height in drawing units.
     * @param worldUnits
     *            The world units.
     * @param drawingUnits
     *            The drawing units.
     * @param strokeUnits
     *            The stroke units.
     * @param globalTransform
     *            The global transformation.
     */
    void setUp(double width, double heigth, Length worldUnits,
            Length drawingUnits, Length strokeUnits,
            AffineTransform globalTransform);

    /**
     * Is called before each primitive is drawn.
     */
    void before();

    /**
     * Is called after each primitive is drawn.
     */
    void after();

    /**
     * Is calles only once after everithing is drawn, and before the result
     */
    void tearDown();

    /**
     * Writes the drawing to the given output stream.
     * 
     * @param out
     *            The output stream into which the drawing will be drawn.
     * @throws IOException
     *             Is thrown in the case an error occurs.
     */
    void write(OutputStream out) throws IOException;

    /**
     * Wheter the outputable format was allready initialzed or not.
     * 
     * @return <code>true</code> if allready initialzed, <code>false</code> if
     *         not iniatialized.
     */
    boolean isInitialized();

    /**
     * Gets the mime type of the output format.
     * 
     * @return The mime type of the output format.
     */
    MimeType getMimeType();

}
