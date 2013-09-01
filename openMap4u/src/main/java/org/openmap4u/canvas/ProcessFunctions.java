package org.openmap4u.canvas;

/**
 * Processes the provided functions.
 * 
 * @author Michael Hadrbolec
 * 
 * @param <V>
 *            The type of data to be processed.
 */
public interface ProcessFunctions<V> {

    /**
     * Processes the provided function(s).
     * 
     * @param values
     *            The values to process.
     * @return Allows either to draw or add functions or to write the result
     *         into the configured output format.
     */
    DrawOrWrite<V> setProcess(Iterable<V> values);

}
