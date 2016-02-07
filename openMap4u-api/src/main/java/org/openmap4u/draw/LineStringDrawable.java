/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.draw;

import org.openmap4u.primitive.LineStringPrimitive;
import org.openmap4u.style.LineStringStyle;

/**
 * Represents a drawable lineString.
 * @author Michael Hadrbolec.
 */
public final class LineStringDrawable extends AbstractDrawable<LineStringPrimitive,LineStringStyle> {
    
 	
    public LineStringDrawable( ) {
		super(new LineStringPrimitive(),new LineStringStyle());
 	}

 
    
    
}
