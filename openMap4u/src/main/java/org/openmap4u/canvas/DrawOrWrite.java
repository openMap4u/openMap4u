/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Styleable;

/**
 * Allow either to draw another primitive on the canvas, or to write the result
 * to the provided output stream.
 *
 * @author Michael Hadrbolec
 */
public interface DrawOrWrite {

    /**
     * Draws a single primitive.
     *
     * @param primitive The shape primitive to draw.
     * @return Allow by applying the method chaining pattern either to draw more
     * primitive(s) or to write the resulting map.
     */
    DrawOrWrite draw(Primitive<?, ? extends Styleable> primitive);

    /**
     * Writes the drawing result to the given output stream. If no primitives
     * have been drawn the canvas is empty.
     *
     * @param out The output stream into which the drawing result will be
     * written.
     * @throws IOException Is thrown in the case an error occurs.
     */
    void write(OutputStream out) throws IOException;

    /**
     * Writes the drawing result to the given path. If no primitives have been
     * drawn the canvas is empty.
     *
     * @param out The path into which the drawing result will be written.
     * @throws IOException Is thrown in the case an error occurs.
     */
    void write(Path out) throws IOException;

}
