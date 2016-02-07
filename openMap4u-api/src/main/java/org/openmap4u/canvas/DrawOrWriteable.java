/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

import org.openmap4u.builder.Buildable;
import org.openmap4u.builder.ImageBuilder;
import org.openmap4u.builder.LineStringBuilder;
import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.builder.TextBuilder;
import org.openmap4u.primitive.Primitiveable;

/**
 * Allow either to draw another primitive on the canvas, or to write the result
 * to the provided output stream.
 *
 * @author Michael Hadrbolec
 */
public interface DrawOrWriteable  {

    /**
     * Draws a single primitive.
     *
     * @param buildable The primitive(s) to draw.
     * @return Allow by applying the method chaining pattern either to draw more
     * primitive(s) or to write the resulting map.
     */
   <T extends ImageBuilder<T>> DrawOrWriteable draw(ImageBuilder<T> imageBuilder);

   <T extends TextBuilder<T>> DrawOrWriteable draw(TextBuilder<T> textBuilder);
   <T extends LineStringBuilder<T>> DrawOrWriteable draw(LineStringBuilder<T> lineStringBuilder);
   <T extends ShapeBuilder<T>> DrawOrWriteable draw(ShapeBuilder<T> shapeBuilder);

    
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
    
    void write(String first , String ... more) throws IOException;

}