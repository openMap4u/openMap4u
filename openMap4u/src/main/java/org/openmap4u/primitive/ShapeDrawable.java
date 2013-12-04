/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.primitive;

import java.awt.Shape;
import org.openmap4u.style.ShapeStyleable;

/**
 *
 * @author zwotti
 */
public interface ShapeDrawable extends Drawable<ShapeStyleable> {
    
    
    Shape getShape();
    
    
}
