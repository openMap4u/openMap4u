/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.commons.ShapeStyleable;
import org.openmap4u.interfaces.Drawable;

/**
 * Represents a area chart
 *
 * @author Michael Hadrbolec
 * @param <T> The area chart type.
 */
public abstract class AreaChart<T extends AreaChart<T>> extends ShapeBuilder<T> {

    protected Point2D.Double mStart = null;
    protected Point2D.Double mEnd = null;

    /**
     * Draws a straight line from the last path point to the given point.
     *
     * @param toX The x coordinate where to draw to.
     * @param toY The y coordinate where to draw to.
     * @return The Area itself (method chaining pattern).
     */
    @Override
    public T lineTo(double toX, double toY) {
        if (mStart == null) {
            this.mStart = new Point2D.Double(toX, toY);
        } else {
            this.mEnd = new Point2D.Double(toX, toY);
        }
        return super.lineTo(toX, toY);
    }

    /**
     * Sets the stroke color.
     *
     * @param strokeColor The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public T color(Paint strokeColor) {
        return super.color(strokeColor);
    }

    @Override
    public T fill(Paint fillColor) {
        return super.fill(fillColor);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public T size(double strokeSize) {
        return super.size(strokeSize);
    }

    public static class Vertical extends AreaChart<Vertical> {

        @Override
        public Drawable<ShapeStyleable,Path2D> build() {
        	Drawable<ShapeStyleable, Path2D> drawable =super.build();
        	drawable.getPrimitive().lineTo(mEnd.x, 0);
        	drawable.getPrimitive().lineTo(mStart.x, 0);
        	drawable.getPrimitive().lineTo(mStart.x, mStart.y);
             return this.getDrawable();
        }

    }

    public static class Horizontal extends AreaChart<Horizontal> {

        @Override
        public Drawable<ShapeStyleable,Path2D> build() {
        	Drawable<ShapeStyleable, Path2D> drawable =super.build();
        	drawable.getPrimitive().lineTo(0, mEnd.y);
        	drawable.getPrimitive().lineTo(0, mStart.y);
        	drawable.getPrimitive().lineTo(mStart.x, mStart.y);
            return drawable;
        }

    }
}
