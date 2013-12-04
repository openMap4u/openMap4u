/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import org.openmap4u.builder.ShapeBuilder;
 
/**
 *
 * @author zwotti
 */
public class Bar extends ShapeBuilder<Bar> {

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
    public Bar color(Paint strokeColor) {
        return super.color(strokeColor);
    }

    /**
     * Sets the sroke fill.
     *
     * @param strokeFill The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Bar fill(Paint strokeFill) {
        return super.fill(strokeFill);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Bar size(double strokeSize) {
        return super.size(strokeSize);
    }

    public Bar radius(double radius) {
        this.mRadius = radius;
        return this;
    }

    public Bar width(double width) {
        this.mWidth = width;
        return this;
    }

    public Bar height(double height) {
        this.mHeight = height;
        return this;
    }
    
  public Bar setSize(double width,double height) {
      return width(width).height(height);
     }
    
  

    @Override
    public Shape getShape() {
        shape( new RoundRectangle2D.Double(-getWidth() / 2, -getHeight() / 2, getWidth(), getHeight(), getRadius(), getRadius()));
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
