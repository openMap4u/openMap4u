/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Styleable;

/**
 * Allows to draw a primitive.
 * 
 * @author Michael Hadrbolec
 * @param <V>
 */
public interface Draw<V> extends AddFunction<V> {

    /**
     * Draws a shape primitive.
     * 
     * @param primitive
     *            The shape primitive to draw.
     * @return Allows either to draw an adidtional primitive or to write the
     *         result into the given output stream.
     */
    DrawOrWrite setDraw(Primitive<?, ? extends Styleable> primitive);

}
