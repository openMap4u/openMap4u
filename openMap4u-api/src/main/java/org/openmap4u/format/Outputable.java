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

import org.openmap4u.common.Angle;
import org.openmap4u.common.Length;
import org.openmap4u.common.Plugable;
import org.openmap4u.draw.ImageDrawable;
import org.openmap4u.draw.LineStringDrawable;
import org.openmap4u.draw.ShapeDrawable;
import org.openmap4u.draw.TextDrawable;

/**
 * This interface has to be implemented for every output format.<br>
 * <img alt="" src="./doc-files/outputable.png">
 *
 * @author Michael Hadrbolec
 */
public interface Outputable extends Plugable {

	/**
	 * Draws a shape (=vector) primitive.
	 *
	 * @param shape
	 *            The shape.
	 * @return The bounds of the shape primitive.
	 */
	Shape drawShape(ShapeDrawable shape);

	/**
	 * Draws a shape (=vector) primitive.
	 *
	 * @param shape
	 *            The shape.
	 * @return The bounds of the shape primitive.
	 */
	Shape drawLineString(LineStringDrawable shape);

	/**
	 * Draws an image primitive.
	 *
	 * @param image
	 *            The image.
	 * @return The bounds of the image primitive.
	 */
	Shape drawImage(ImageDrawable image);

	/**
	 * Draws a text primitive.
	 *
	 * @param text
	 *            The text primitive.
	 * @return The bounds of the text primitive.
	 */
	Shape drawText(TextDrawable text);

	/**
	 * Is only called once, before anything is drawn. It acts as initial setup.
	 *
	 * @param shape
	 *            The canvas shape in drawing units.
	 * @param worldUnits
	 *            The world units.
	 * @param drawingUnits
	 *            The drawing units.
	 * @param strokeUnits
	 *            The stroke units.
	 * @param angleUnits
	 *            The angle units.
	 * @param globalTransform
	 *            The global transformation.
	 */
	void setUp(Shape shape, Length worldUnits, Length drawingUnits, Length strokeUnits, Angle angleUnits, AffineTransform globalTransform);

	/**
	 * Gets the global transformation from world units into ouputformat units.
	 *
	 * @return The global transformation from world units into ouputformat
	 *         units.
	 */
	AffineTransform getGlobalTransform();

	/**
	 * Is called before a primitive (eg. a shape, or a text or an image) is
	 * drawn.
	 */
	void before();

	/**
	 * Is called after drawing a primitive (eg. a shape, or a text or an image)
	 * is drawn.
	 */
	void after();

	/**
	 * Is called only once after everything is drawn, and the result is written
	 * into the given output stream. It is used for cleanup.
	 */
	void tearDown();

	/**
	 * Writes the map into the given output stream.
	 *
	 * @param out
	 *            The output stream into which the map will be drawn.
	 * @throws IOException
	 *             Is thrown in the case an error occurs.
	 */
	void write(OutputStream out) throws IOException;

}
