/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.primitive;

import java.util.List;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Set;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Position;
import org.openmap4u.interact.Interactable;
import org.openmap4u.style.Styleable;

/**
 *
 * @author hadrbolec
 * @param <S> The style type for the drawable.
 */
public interface Drawable<S extends Styleable<S>>   {

    
    /**
     * Gets the style.
     *
     * @return The style.
     */
    S getStyle();
    
    /**
     * Gets the individual transformation parameters.
     * @return The individual transformation parameters.
     */ 
    DrawableTransformable getTransform();

}
