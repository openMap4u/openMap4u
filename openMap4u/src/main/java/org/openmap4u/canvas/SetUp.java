/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

import java.awt.Shape;

import org.openmap4u.format.Outputable;
import org.openmap4u.unit.Angle;
import org.openmap4u.unit.Length;

/**
 * 
 * @author Michael Hadrbolec
 */
public interface SetUp {

    /**
     * Sets the world units.
     * 
     * @param worldUnits
     *            The world units.
     * @return Allows to setup additional parameters.
     */
    SetUp worldUnits(Length worldUnits);

    /**
     * Sets the drawing units.
     * 
     * @param drawingUnits
     *            The drawing units.
     * @return Allows to setup additional parameters.
     */
    SetUp drawingUnits(Length drawingUnits);

    /**
     * Sets the stroke units.
     * 
     * @param strokeUnits
     *            The stroke units.
     * @return Allows to setup additional parameters.
     */
    SetUp strokeUnits(Length strokeUnits);
    
    /**
     * Sets the angle units.
     * @param angleUnits The angle units.
     * @return Fluent builder pattern.
     */
    SetUp angleUnits(Angle angleUnits);

    /**
     * 
     * @param <>>
     *            Every class that implements the outputableFormat interface.
     * @param outputFormat
     *            The class that implements the outputableFormat interface.
     * @return Allows to setup additional parameters.
     */
    <T extends Outputable> SetUp outputFormat(Class<T> outputFormat);

    /**
     * Creates the drawing canvas based on the provided unit and output format
     * parameters and or its default values.
     * 
     * @param width
     *            The width of the drawing container in drawing units.
     * @param height
     *            The height of the drawing container in drawing units.
     * @return Allows either to set the area of interest or to directly add
     *         primitives.
     */
    SetAreaOfInterestOrDrawOrWrite size(double width, double height);
    
    /**
     * Sets the shape of the canvas in drawing units.
     * @param shape The shape of the canvas in drawing units.
     * @return Allows either to set the area of interest or to directly add
     *         primitives.
     */
    //SetAreaOfInterestOrDrawOrWrite size(Shape shape);
    
    
    
}
