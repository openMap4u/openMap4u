/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.style;

import java.io.Serializable;

import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.VerticalAlign;

/**
 * 
 * @author hadrbolec
 * @param <T>
 */
public interface Styleable<T extends Styleable<T>> extends Serializable,Cloneable {

    /**
     * @return the alpha
     */
    double getAlpha();

    /**
     * @return the visible
     */
    boolean isVisible();

    /**
     * @param alpha
     *            the alpha to set
     * @return 
     */
    T setAlpha(double alpha);

    /**
     * @param visible
     *            the visible to set
     * @return 
     */
    T setVisible(boolean visible);

    /**
     * Sets the vertical alignment.
     * 
     * @param verticalAlign
     *            The vertical alignment.
     * @return The styleable itself (method chaining pattern).
     */
    T setVerticalAlign(VerticalAlign verticalAlign);

    /**
     * Gets the vertical alignment.
     * 
     * @return The vertical alignment.
     */
    VerticalAlign getVerticalAlign();

    /**
     * Sets the horizontal alignment.
     * 
     * @param horizontalAlign
     *            The horizontal alignment.
     * @return The styleable itself (method chaining pattern).
     */
    T setHorizontalAlign(HorizontalAlign horizontalAlign);

    /**
     * Gets the horizontal alignment.
     * 
     * @return The horizontal alignment.
     */
    HorizontalAlign getHorizontalAlign();

    /**
     * Clones the style.
     * 
     * @return The colend style.
     * @throws CloneNotSupportedException
     */
    T clone()  throws CloneNotSupportedException;

}
