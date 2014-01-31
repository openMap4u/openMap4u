/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.commons;

/**
 *
 * @author hadrbolec
 */
public interface ImageStyleable extends Styleable<ImageStyleable> {

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    ImageStyleable clone() throws CloneNotSupportedException;
    
}
