/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.style;

import java.awt.Paint;

/**
 * 
 * @author hadrbolec
 */
public interface ShapeStyleable extends Cloneable, Styleable<ShapeStyleable> {

    /**
     * @param size
     *            the size to set
     * @return 
     */
    ShapeStyleable setStrokeSize(double size);

    /**
     * @return the size
     */
    double getStrokeSize();

    /**
     * @param fill
     *            the fill to set
     * @return 
     */
    ShapeStyleable setStrokeFill(Paint fill);

    /**
     * @return the fill
     */
    Paint getStrokeFill();

    /**
     * @return the color
     */
    Paint getStrokeColor();

    /**
     * @param color
     *            the color to set
     * @return 
     */
    ShapeStyleable setStrokeColor(Paint color);

}
