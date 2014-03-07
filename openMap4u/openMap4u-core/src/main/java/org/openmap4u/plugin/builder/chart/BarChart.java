/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import org.openmap4u.builder.ShapeBuilder;

/**
 *
 * @author zwotti
 */
public class BarChart extends ShapeBuilder<BarChart> {

    private double mRadius = Double.NaN;

    private double mWidth = 0;
    private double mHeight = 0;

    /**
     * Sets the stroke color.
     *
     * @param strokeColor The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public BarChart color(Paint strokeColor) {
        return super.color(strokeColor);
    }

    /**
     * Sets the sroke fill.
     *
     * @param strokeFill The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public BarChart fill(Paint strokeFill) {
        return super.fill(strokeFill);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public BarChart size(double strokeSize) {
        return super.size(strokeSize);
    }

    /**
     * The radius.
     *
     * @param radius The radius.
     * @return The builder itself (method chaining pattern).
     */
    public BarChart radius(double radius) {
        this.mRadius = radius;
        return this;
    }

    /**
     * The bar width in drawing units.
     *
     * @param width The bar width in drawing units.
     * @return The builder itself (method chaining pattern).
     */
    public BarChart width(double width) {
        this.mWidth = width;
        return this;
    }

    /**
     * The bar height in drawing units.
     *
     * @param height THe bar height in drawing units.
     * @return The builder itself (method chaining pattern).
     */
    public BarChart height(double height) {
        this.mHeight = height;
        return this;
    }

    /**
     * Sets the bar size.
     *
     * @param width The bar width in drawing units.
     * @param height The bar height in drawing units.
     * @return The builder itself (method chaining pattern).
     */
    public BarChart setSize(double width, double height) {
        return width(width).height(height);
    }

    @Override
    public Shape getShape() {
        if (Double.isNaN(getRadius())) {
            shape(new Rectangle2D.Double(-getWidth() / 2, -getHeight() / 2, getWidth(), getHeight()));
        } else {
            shape(new RoundRectangle2D.Double(-getWidth() / 2, -getHeight() / 2, getWidth(), getHeight(), getRadius(), getRadius()));
        }
        return super.getShape();
    }

    double getWidth() {
        return this.mWidth;
    }

    double getHeight() {
        return this.mHeight;
    }

    double getRadius() {
        return this.mRadius;
    }

}
