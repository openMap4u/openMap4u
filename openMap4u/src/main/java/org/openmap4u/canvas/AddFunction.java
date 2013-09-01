package org.openmap4u.canvas;

 
import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Styleable;

import com.google.common.base.Function;
 

 
/**
 * Adds a new function.
 * 
 * @author Michael Hadrbolec
 * 
 * @param <V>
 */
public interface AddFunction<V> {

    /**
     * Adds a new function.
     * 
     * @param function
     *            The function to be added.
     * @return Allows either to add another function or to process all already
     *         so far provided functions.
     */
    AddFunctionOrProcess<V> setFunction(
            Function<V, Primitive<?, ? extends Styleable>> function);

}
