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
public interface Centerable<B extends Centerable<B>> {
    
    B center(double x , double y);
    
}
