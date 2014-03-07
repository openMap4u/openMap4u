/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.format;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.OutputStream;

import org.openmap4u.commons.Plugable;
import org.openmap4u.commons.ImageDrawable;
import org.openmap4u.commons.ShapeDrawable;
import org.openmap4u.commons.TextDrawable;
import org.openmap4u.commons.Angle;
import org.openmap4u.commons.Length;

/**
 * This interface has to be implemented for every output format.<br> 
 * <img alt="" src="./doc-files/outputable.png">
  *
 * @author Michael Hadrbolec
 */
public interface Outputable extends Plugable {

    /**
     * Draws a shape (=vector). After drawing the the primitive the after method
     * is called.
     *
     * @param point The point (optional or null).
     * @param shape The shape.
     * @return The bounds of the shape primitive.
     */
    Shape drawShape(Point2D point,
            ShapeDrawable shape);

    /**
     * Draws an image. After drawing the the primitive the after method is
     * called.
     *
     * @param point The point (optional or null).
     * @param image The image.
     * @return The bounds of the image primitive.
     */
    Shape drawImage(Point2D point, ImageDrawable image);

    /**
     * Draws a text. Before drawing the primitive the before method is calles.
     * After drawing the the primitive the after method is called.
     *
     * @param point The point where to draw the text.
     * @param text The text primitive.
     * @return The bounds of the text primitive.
     */
    Shape drawText(Point2D point, TextDrawable text);

    /**
     * Is only called once, before anything is drawn.
     *
     * @param shape The canvas sshape in drawing units.
     * @param worldUnits The world units.
     * @param drawingUnits The drawing units.
     * @param strokeUnits The stroke units.
     * @param angleUnits The angle units.
     * @param globalTransform The global transformation.
     */
    void setUp(Shape shape, Length worldUnits,
            Length drawingUnits, Length strokeUnits, Angle angleUnits,
            AffineTransform globalTransform);

    /**
     * Gets the global transformation from world units into ouputformat units.
     *
     * @return The global transformation from world units into ouputformat
     * units.
     */
    AffineTransform getGlobalTransform();

    /**
     * Is called before drawing each primitive (eg. a shape, or a text or an image).
     */
    void before();

    /**
     * Is called after drawing each primitive (eg. a shape, or a text or an image).
     */
    void after();

    /**
     * Is calles only once after everything is drawn, and the result is written
     * into the given output stream. It is used for cleanup.
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
  //  boolean isInitialized();

}
