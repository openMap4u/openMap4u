/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.draw;

import org.openmap4u.primitive.ShapePrimitive;
import org.openmap4u.style.ShapeStyle;

/**
 * Represents a drawable shape.
 * @author Michael Hadrbolec.
 */
public class ShapeDrawable extends AbstractDrawable<ShapePrimitive,ShapeStyle> {
    
 	 
    public ShapeDrawable( ) {
		super(new ShapePrimitive(),new ShapeStyle());
	}

	 
    
    
}
