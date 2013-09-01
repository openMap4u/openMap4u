package org.openmap4u.canvas;

/**
 * Allows either to add another function or to process the already provided
 * ones.
 * 
 * @author Michael Hadrbolec
 * 
 * @param <V>
 */
public interface AddFunctionOrProcess<V> extends ProcessFunctions<V>,
        AddFunction<V> {
}
