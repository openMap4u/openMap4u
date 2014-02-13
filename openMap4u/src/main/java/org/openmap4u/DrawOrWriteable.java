/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import org.openmap4u.builder.Buildable;

/**
 * Allow either to draw another primitive on the canvas, or to write the result
 * to the provided output stream.
 *
 * @author Michael Hadrbolec
 */
public interface DrawOrWriteable extends Consumer<Buildable> {

    /**
     * Draws a single primitive.
     *
     * @param buildable The primitive(s) to draw.
     * @return Allow by applying the method chaining pattern either to draw more
     * primitive(s) or to write the resulting map.
     */
    DrawOrWriteable draw(Buildable buildable);

    /**
     * Draws a stream of buildables.
     *
     * @param stream The buildables to draw.
     * @return The DrawOrWriteable itself (fluent interface pattern). Allows
     * either to draw further Buildables or to write the result.
     */
    DrawOrWriteable draw(Stream<Buildable> stream);

    /**
     * Draws a stream of values mapped via a function into a Buildable.
     *
     * @param <T> The type of the values.
     * @param stream The stream of values.
     * @param map The mapping function.
     * @return The DrawOrWriteable itself (fluent interface pattern). Allows
     * either to draw further Buildables or to write the result.
     */
    <T> DrawOrWriteable draw(Stream<T> stream, Function<T, Buildable> map);

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
