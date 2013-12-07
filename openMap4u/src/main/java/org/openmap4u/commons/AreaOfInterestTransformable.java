/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.commons;

import java.awt.Shape;
import java.awt.geom.Point2D;
import org.openmap4u.unit.Angle;
import org.openmap4u.unit.Length;

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
     * Gets the shape.
     * @return The shape.
     */
    Shape getShape();
    
     
     
    Length getWorldUnits();
    
    Length getDrawingUnits();
    
    Angle getAngleUnits();
    
      
}
