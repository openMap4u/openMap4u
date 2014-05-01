/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.commons;

/**
 * A text primitive.
 * @author hadrbolec
 */
public interface TextDrawable extends Drawable<TextStyleable> {
    
    /**
     * Gets the text.
     * @return The text.
     */
    String getText();
    
   
    
}
