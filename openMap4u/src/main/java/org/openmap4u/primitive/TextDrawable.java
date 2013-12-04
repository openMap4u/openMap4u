/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.primitive;

import org.openmap4u.style.TextStyleable;

/**
 *
 * @author hadrbolec
 */
public interface TextDrawable extends Drawable<TextStyleable> {
    
    String getText();
    
   
    
}
