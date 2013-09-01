/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

/**
 * Allow either to draw another primitive on the canvas, or to write the result
 * to the provided output stream.
 * 
 * @author Michael Hadrbolec
 * @param <V>
 */
public interface DrawOrWrite<V> extends Draw<V>, Write, AddFunction<V> {

}
