/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.style;

import org.openmap4u.commons.Position;

/**
 *
 * @author Michael Hadrbolec.
 * @param <T> The style type (used for the method chaining pattern).
 */
public interface Styleable<T extends Styleable<T>> extends Cloneable {

    /**
     * {@inheritDoc}
     */
    double getAlpha();

    /**
     * {@inheritDoc}
     */
    T setAlpha(double alpha);

    /**
     * {@inheritDoc}
     */
    boolean isVisible();

    /**
     * {@inheritDoc}
     */
    T setVisible(boolean visible);

  
}
