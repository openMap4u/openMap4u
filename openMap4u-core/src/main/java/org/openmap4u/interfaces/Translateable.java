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
public interface Translateable<B extends Translateable<B>> {
    
    B translate(double translate);
    
    B tranlateX(double translateX);
    
    B translateY(double translateY);
    
}
