/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.format;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

import javax.activation.MimeType;

import org.openmap4u.commons.BeforeAfter;
import org.openmap4u.commons.Plugable;
import org.openmap4u.style.ImageStyle;
import org.openmap4u.style.ShapeStyle;
import org.openmap4u.style.TextStyle;
import org.openmap4u.unit.Length;

/**
 * This interface has to be implemented for every output format.
 *
 * @author Michael Hadrbolec
 */
public interface Outputable extends Plugable, BeforeAfter {

    /**
     * Draws a shape (=vector). After drawing the the primitive the after method
     * is called.
     *
     * @param shape The shape primitive to draw.
     * @param point
     * @param individualTransform The individual transformation of the shape
     * primitive.
     * @param style The style of the shape primitive.
     * @return The bounds of the shape primitive.
     */
    Shape drawShape(Shape shape, Point2D point,
            AffineTransform individualTransform, ShapeStyle style);

    /**
     * Draws an image. After drawing the the primitive the after method is
     * called.
     *
     * @param image The image primitive to draw.
     * @param point
     * @param individualTransform The individual transformation of the image
     * primitive.
     * @param style The style of the image primitive.
     * @return The bounds of the image primitive.
     */
    Shape drawImage(Path image, Point2D point,
            AffineTransform individualTransform, ImageStyle style);

    /**
     * Draws a text. Before drawing the primitive the before method is calles.
     * After drawing the the primitive the after method is called.
     *
     * @param text The text primitive to drawn.
     * @param point
     * @param individualTransform The individual transformation of the text
     * primitive.
     * @param style The style of the text primitive.
     * @return The bounds of the text primitive.
     */
    Shape drawText(String text, Point2D point,
            AffineTransform individualTransform, TextStyle style);

    /**
     * Is only called once, before anything is drawn.
     *
     * @param width The canvas width in drawing units.
     * @param heigth The canvas height in drawing units.
     * @param worldUnits The world units.
     * @param drawingUnits The drawing units.
     * @param strokeUnits The stroke units.
     * @param globalTransform The global transformation.
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
     * @param out The output stream into which the drawing will be drawn.
     * @throws IOException Is thrown in the case an error occurs.
     */
    void write(OutputStream out) throws IOException;

    /**
     * Wheter the outputable format was allready initialzed or not.
     *
     * @return <code>true</code> if allready initialzed, <code>false</code> if
     * not iniatialized.
     */
    boolean isInitialized();

    /**
     * Gets the mime type of the output format.
     *
     * @return The mime type of the output format.
     */
    MimeType getMimeType();

    /**
     * Takes the individual coordinate system of the output format
     * into account and calculates therefore the global transformation.
     *
     * @param globalTransform The global transromation.
     * @return The global transfromation for the output format.
     */
    AffineTransform getGlobalTransform(AffineTransform globalTransform);

    /**
     * Takes the individual coordinate system of the output format
     * into account and calculates therefore the individual transformation.
     * @param individualTransform The individual transfromation.
     * @return The individual transformation for the output format.
     */
    AffineTransform getIndividualTransfrom(AffineTransform individualTransform);

}
