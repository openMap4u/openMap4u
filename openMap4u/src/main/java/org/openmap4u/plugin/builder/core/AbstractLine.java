/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.core;

import java.awt.Paint;
import org.openmap4u.builder.ShapeBuilder;

/**
 *
 * @author Michel Hadrbolec
 * @param <T> The line type.
 */
 class AbstractLine<T extends AbstractLine<T>> extends ShapeBuilder<T> {

    /**
     * Sets the stroke color.
     *
     * @param strokeColor The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public T color(Paint strokeColor) {
        return (T)super.color(strokeColor);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public T size(double strokeSize) {
        return (T)super.size(strokeSize);
    }

   
    
 

}
