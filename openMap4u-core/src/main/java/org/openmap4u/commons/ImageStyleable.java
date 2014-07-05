/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.commons;

/**
 *
 * @author Michale Hadrbolec
 */
public interface ImageStyleable extends Styleable<ImageStyleable> {

    /**
     * Clones the image styleable.
     * @return The cloned image styleable.
     * @throws CloneNotSupportedException Is thrown in the case cloning is not supported.
     */
    ImageStyleable clone() throws CloneNotSupportedException;
    
}
