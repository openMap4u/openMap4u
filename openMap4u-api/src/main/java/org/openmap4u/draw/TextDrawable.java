/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.draw;

import org.openmap4u.primitive.TextPrimitive;
import org.openmap4u.style.TextStyle;

/**
 * Represents a drawable text.
 * @author hadrbolec
 */
public final class TextDrawable extends AbstractDrawable<TextPrimitive,TextStyle> {
    
	public TextDrawable() {
		super(new TextPrimitive(),new TextStyle());
	}

	 
    
   
    
}
