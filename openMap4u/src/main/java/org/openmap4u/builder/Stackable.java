/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

/**
 *
 * @author Michael Hadrbolec
 * @param <T> The stackable type.
 */
public interface Stackable<T extends Stackable<T>> {

    /**
     * Stacks in x axis direction.
     *
     * @return The builder itself (method chaining pattern).
     */
    T stackX();
    
    /**
     * Stacks in x axis direction with the given offset in drawing units.
     * @param stackXOffset The stack offset in x axis direction.
     * @return The builder itself (method chaining pattern).
     */
    T stackX(double stackXOffset);

    /**
     * Stacks in y axis direction.
     *
     * @return The builder itself (method chaining pattern).
     */
    T stackY(); 
    
    /**
     * Stacks in y axis direction with the given offset in drawing units.
     * @param stackYOffset The stack offset in y axis direction.
     * @return The builder itself (method chaining pattern).
     */
    T stackY(double stackYOffset);

}
