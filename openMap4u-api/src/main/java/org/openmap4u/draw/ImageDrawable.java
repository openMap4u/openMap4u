/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.draw;

import org.openmap4u.primitive.ImagePrimitive;
import org.openmap4u.style.ImageStyle;

/**
 * Represents a drawable raster image.
 * @author Michael Hadrbolec.
 */
public final class ImageDrawable extends AbstractDrawable<ImagePrimitive,ImageStyle> {
	
     
    public ImageDrawable( ) {
		super(new ImagePrimitive(),new ImageStyle());
	}

	 
    
}
