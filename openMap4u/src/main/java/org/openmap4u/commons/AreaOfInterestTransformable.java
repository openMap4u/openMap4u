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
     * Gets the shape.
     * @return The shape.
     */
    Shape getShape();
    
     
    /**
     * Gets the world units.
     * @return The world units.
     */ 
    Length getWorldUnits();
    
    /**
     * Gets the drawing units.
     * @return  The darwing units.
     */
    Length getDrawingUnits();
    
    /**
     * Gets the angle units.
     * @return The angle units.
     */
    Angle getAngleUnits();
    
      
}
