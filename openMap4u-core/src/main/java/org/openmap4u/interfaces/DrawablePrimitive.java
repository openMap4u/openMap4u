/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.interfaces;

import java.awt.geom.AffineTransform;
import org.openmap4u.commons.Styleable;

/**
 *
 * @author Michael Hadrbolec
 */
public interface DrawablePrimitive<P,S extends Styleable<S>> {
    
    AffineTransform getTransformation();
    
    Styleable<S> getStyle();
    
    P getPrimitive();
    
}
