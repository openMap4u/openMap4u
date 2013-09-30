/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

import java.util.function.Consumer;
import java.util.stream.Stream;
import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Styleable;

/**
 * Allows to draw a primitive.
 *
 * @author Michael Hadrbolec
 */
public interface Draw   {

    /**
     * Draws a single primitive.
     *
     * @param primitive The shape primitive to draw.
     * @return Allow by applying the method chaining pattern either to draw more
     * primitive(s) or to write the resulting map.
     */
    DrawOrWrite setDraw(Primitive<?, ? extends Styleable> primitive);

    /**
     * Draws multiple primitives.
     *
     * @param primitives2Draw A stream containing the primitives to draw.
     * @return Allow by applying the method chaining pattern either to draw more
     * primitive(s) or to write the resulting map.
     */
    DrawOrWrite setDraw(Stream<Primitive<?, ? extends Styleable>> primitives2Draw);

}
