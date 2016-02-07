/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.transform;

import java.awt.geom.AffineTransform;

/**
 * 
 * @author Michael Hadrbolec
 */
public interface Transformable extends  Cloneable {
   
    
    /**
     * Gets the affine transformation.
     * @return The affine transformation.
     */
    AffineTransform getTransformation();
      
}
