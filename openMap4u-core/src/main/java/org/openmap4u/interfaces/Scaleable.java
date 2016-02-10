/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.interfaces;

/**
 * 
 * @author Michael Hadrbolec
 */
public interface Scaleable<B extends Scaleable<B>> {
    
    B scale(double scaleFactor);
    
    B scaleX(double yScaleFactor);
    
    B scaleY(double xScaleFactor);
    
}
