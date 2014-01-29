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
 */
public class Line extends ShapeBuilder<Line> {

    /**
     * Sets the stroke color.
     *
     * @param strokeColor The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Line color(Paint strokeColor) {
        return super.color(strokeColor);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Line size(double strokeSize) {
        return super.size(strokeSize);
    }

    public Line line(double fromX, double fromY, double toX, double toY) {
        super.moveTo(fromX, fromY).lineTo(toX, toY);
        return this;
    }

}
