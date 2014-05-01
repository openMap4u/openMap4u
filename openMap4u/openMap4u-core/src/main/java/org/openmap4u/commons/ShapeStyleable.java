/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import java.awt.Paint;

/**
 *
 * @author Michael Hadrbolec
 */
public interface ShapeStyleable extends Styleable<ShapeStyleable> {

    /**
     * Gets the stroke color.
     *
     * @return The stroke color.
     */
    Paint getStrokeColor();

    /**
     * Gets the fill color.
     *
     * @return The fill color.
     */
    Paint getStrokeFill();

    /**
     * Gets the stroke size in stroke units.
     *
     * @return The stroke size in stroke units.
     */
    double getStrokeSize();

    /**
     * Sets the shape stroke color.
     *
     * @param color The shape stroke color.
     * @return The method chaining pattern.
     */
    ShapeStyleable setStrokeColor(Paint color);

    /**
     * Sets the shape fill color.
     *
     * @param fill The shape fill color.
     * @return The method chaining pattern.
     */
    ShapeStyleable setStrokeFill(Paint fill);

    /**
     * Sets the stroke size in drawing units.
     *
     * @param strokeSize The stroke size in drawing units.
     * @return The method chaining pattern.
     */
    ShapeStyleable setStrokeSize(double strokeSize);

    /**
     * Clones the shape style.
     *
     * @return The cloned ShapeStyleable.
     * @throws java.lang.CloneNotSupportedException Is thrown in the case cloning is not supported.
     */
    ShapeStyleable clone() throws CloneNotSupportedException;

}
