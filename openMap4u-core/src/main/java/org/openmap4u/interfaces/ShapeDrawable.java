/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.interfaces;

import java.awt.Shape;
import org.openmap4u.commons.ShapeStyleable;

/**
 * A shape primitive.
 * @author Michael Hadrbolec.
 */
public interface ShapeDrawable extends Drawable<ShapeStyleable> {
    
    /**
     * Gets the shape.
     * @return THe shape.
     */
    Shape getPrimitive();
    
    
}
