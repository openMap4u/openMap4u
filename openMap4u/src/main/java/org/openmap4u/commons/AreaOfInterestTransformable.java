/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.commons;

import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 *
 * @author zwotti
 */
public interface AreaOfInterestTransformable extends Transformable {
    
    /**
     * Gets the the canvas center.
     * @return The canvas center.
     */
    Point2D getCenter();
    
    /**
     * Sets the center.
     * @param center The center.
     */
    void setCenter(Point2D center);
    
    /**
     * Gets the shape.
     * @return The shape.
     */
    Shape getShape();
    
    /**
     * Sets the shape.
     * @param shape The shape.
     */
    void setShape(Shape shape);
    
}
