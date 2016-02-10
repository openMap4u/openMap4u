/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.interfaces;

import org.openmap4u.commons.Angle;

/**
 *
 * @author zwotti
 */
public interface Rotateable<B extends Rotateable<B>> {
    
    B rotate(double angle);
    
    B angularUnits(Angle angularUnits);
    
}
