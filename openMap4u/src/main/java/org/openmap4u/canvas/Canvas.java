/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

import org.openmap4u.commons.Plugable;

/**
 * 
 * @author Michael Hadrbolec
 * @param <V>
 */
public interface Canvas<V> extends Plugable, SetUp, DrawOrWrite<V>,
        SetAreaOfInterestOrDraw<V>, AddFunctionOrProcess<V> {

}
