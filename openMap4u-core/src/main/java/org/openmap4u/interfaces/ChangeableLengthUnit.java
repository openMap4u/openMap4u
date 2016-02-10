/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.interfaces;

import org.openmap4u.commons.Length;

/**
 *
 * @author MIchael Hadrbolec
 */
public interface ChangeableLengthUnit<B extends ChangeableLengthUnit<B>>  {
    
    B unit(Length lengthUnit);
    
}
