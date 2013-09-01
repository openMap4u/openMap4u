/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

/**
 * Writes the result into the given output stream.
 * 
 * @author Michael Hadrbolec
 */
public interface Write {

    /**
     * Writes the drawing result to the given output stream.
     * 
     * @param out
     *            The output stream into which the drawing result will be
     *            written.
     * @throws IOException
     *             Is thrown in the case an error occurs.
     */
    void write(OutputStream out) throws IOException;

    /**
     * Writes the drawing result to the given path.
     * 
     * @param out
     *            The path into which the drawing result will be written.
     * @throws IOException
     *             Is thrown in the case an error occurs.
     */
    void write(Path out) throws IOException;

}
