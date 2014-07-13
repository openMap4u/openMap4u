/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import java.io.Serializable;

/**
 *
 * @author Michael Hadrbolec.
 * @param <T> The style type (used for the method chaining pattern).
 */
public interface Styleable<T extends Styleable<T>> extends Cloneable, Serializable {

    /**
     * Gets the alpha value.
     * @return The alpha value.
     */
    double getAlpha();

    /**
     * Sets the alpha value.
     * @param alpha The alpha value.
     * @return Method chaining pattern.
     */
    T alpha(double alpha);

    /**
     * Gets the visibility.
     * @return The visibility (true ... visible, false ... not visible).
     */
    boolean isVisible();

    /**
     * Sets the visibility.
     * @param visible The visibility (true ... visible, false ... not visible).
     * @return Method chaining pattern.
     */
    T visible(boolean visible);

  
}
