/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;


import org.openmap4u.format.Outputable;
import org.openmap4u.commons.Angle;
import org.openmap4u.commons.Length;

/**
 * Allows optional to override default values ({@link org.openmap4u.OpenMap4u#getDefaults()}) for world-, drawing-, stroke and angle
 * units, as well as to specify the size of the drawing container.
 *
 * @author Michael Hadrbolec
 */
public interface SetUp {

    /**
     * Allows to ovveride the default world units.
     *
     * @param worldUnits The world units.
     * @return Allows to setup additional parameters.
     */
    SetUp worldUnits(Length worldUnits);

    /**
     * Allows to overide the default drawing units.
     *
     * @param drawingUnits The drawing units.
     * @return Allows to override other default values (Fluent interface
     * pattern).
     */
    SetUp drawingUnits(Length drawingUnits);

    /**
     * Allows to override the default stroke units.
     *
     * @param strokeUnits The stroke units.
     * @return Allows to override other default values (Fluent interface
     * pattern).
     */
    SetUp strokeUnits(Length strokeUnits);

    /**
     * Allows to override the default the angle units.
     *
     * @param angleUnits The angle units.
     * @return Allows to override other default values (Fluent interface pattern).
     */
    SetUp angleUnits(Angle angleUnits);

    /**
     * Allows to override the default output format.
     *
     * @param <T> The output format type.
     * @param outputFormat The output format.
     * @return Allows to override other default values (Fluent interface
     * pattern).
     */
    <T extends Outputable> SetUp outputFormat(Class<T> outputFormat);

    /**
     * Sets the shape of the output canvas to a rectangle with the given width and height.
      *
     * @param width The width of the drawing container in drawing units.
     * @param height The height of the drawing container in drawing units.
     * @return Allows either to set the area of interest or to directly add
     * primitives.
     */
    SetAreaOfInterestOrDrawOrWrite size(double width, double height);

    /**
     * Sets the shape of the canvas in drawing units.
     *
     * @param shape The shape of the canvas in drawing units.
     * @return Allows either to set the area of interest or to directly add
     * primitives.
     */
    //SetAreaOfInterestOrDrawOrWrite size(Shape shape);
}
