/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.commons;

/**
 *
 * @author Michael Hadrbolec
 */
public interface Transformable {
    
    /**
     * Gets the rotation.
     * @return The rotation.
     */
    double getRotate();
    
    /**
     * Gets the x scale factor.
     * @return The x scale factor.
     */
    double getScaleX();
    
    /**
     * Gets the y scale factor.
     * @return The y scale factor.
     */
    double getScaleY();
    
    /**
     * Gets the angle units.
     * @return The unge units.
     */
    Angle getAngleUnits();
      
      
}
