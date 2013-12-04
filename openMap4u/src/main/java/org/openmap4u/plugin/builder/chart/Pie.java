/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.unit.Angle;

/**
 * Represents a pie ord a donut.
 *
 * @author Michael Hadrbolec.
 */
public class Pie extends ShapeBuilder<Pie> {

    /**
     * Stores the outer radius in drawing units.
     */
    private double mOuterRadius = 1;

    /**
     * Stores the inner radius in drawing units.
     */
    private double mInnerRadius = Double.NaN;

    /**
     * Stores the start angle in degrees.
     */
    private double mStartAngle = 0d;

    /**
     * Stores the end angle in degrees.
     */
    private double mEndAngle = 360d;

    /**
     * Stores the angle unit.
     */
    private Angle mAngularUnit = Angle.PERCENT;

    /**
     * Gets the end angle in radiant.
     *
     * @return The end andgle in radiant.
     */
    double getEnd() {
        return this.mEndAngle;
    }

    /**
     * Gets the start angle in radiant.
     *
     * @return The start angle in radiant.
     */
    double getStart() {
        return this.mStartAngle;
    }

    /**
     * Sets the stroke color.
     *
     * @param strokeColor The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Pie color(Paint strokeColor) {
        return super.color(strokeColor);
    }

    /**
     * Sets the sroke fill.
     *
     * @param strokeFill The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Pie fill(Paint strokeFill) {
        return super.fill(strokeFill);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Pie size(double strokeSize) {
        return super.size(strokeSize);
    }

    public Pie radius(double radius) {
        this.mOuterRadius = radius;
        return this;
    }

    public Pie innerRadius(double radius) {
        this.mInnerRadius = radius;
        return this;
    }

    public Pie outerRadius(double radius) {
        this.mOuterRadius = radius;
        return this;
    }

    public Pie diameter(double diameter) {
        return radius(diameter / 2d);
    }

    public Pie start(double startAngle) {
        this.mStartAngle = getAngularUnit().convert(startAngle, Angle.DEGREE);
        return this;
    }

    public Pie end(double endAngle) {
        this.mEndAngle = getAngularUnit().convert(endAngle, Angle.DEGREE);
        return this;
    }

    /**
     * Sets the unit that will be used.
     *
     * @param angularUnit The unit to be used.
     * @return
     */
    public Pie unit(Angle angularUnit) {
        this.mAngularUnit = angularUnit;
        return this;
    }

    /**
     * Adds a new value in percent of the whole circle.
     *
     * @param value The value in percent of the whole circle. e.g.: 0.1 (=10%)
     * is represented as 36 degrees., 0.25 (=25%) is represented as 90 degrees.
     * @return The builder itself (method chaining pattern).
     */
    public Pie add(double value) {
        /* add the value */
        this.mEndAngle = this.getStart() + getAngularUnit().convert(value, Angle.DEGREE);
        return this;
    }

    /**
     * Gets the units.
     *
     * @return The units.
     */
    Angle getAngularUnit() {
        return this.mAngularUnit;
    }

    @Override
    public Shape  getShape() {
        /* first reset the path */
        resetPath();
        /* determine wheter it is a pie or a donut */
        if (Double.isNaN(getInnerRadius())) {
            super.shape(getArc(getOuterRadius(), getStart(), getEnd(), Arc2D.PIE));
        } else {
            super.shape(new Area(getArc(getOuterRadius(), getStart(), getEnd(), Arc2D.PIE))).subtract(new Ellipse2D.Double(-getInnerRadius() / 2, -getInnerRadius() / 2, getInnerRadius(), getInnerRadius()));
        }
        /* set the new start angle to the last en angle */
        this.mStartAngle = getEnd();
        return super.getShape();
    }

    /**
     * Gets an arc shape.
     *
     * @param radius The radius of the arc.
     * @param start The start angle in degrees.
     * @param end The end angle in degrees.
     * @param arcType The arc type.
     * @return The arc shape.
     */
    Shape getArc(double radius, double start, double end, int arcType) {
        Path2D.Double arc = new Path2D.Double(new Arc2D.Double(-radius, -radius, radius * 2d, radius * 2d, getStart(), end - start, arcType));
        arc.transform(new AffineTransform(1, 0, 0, -1, 0, 0));
        return arc;
    }

    /**
     * Gets the inner radius (or Double.NaN in the case ist is a pie).
     *
     * @return The inner radius (or Double.NaN in the case ist is a pie).
     */
    double getInnerRadius() {
        return this.mInnerRadius;
    }

    /**
     * Gets the outer radius.
     *
     * @return The outer radius.
     */
    double getOuterRadius() {
        return this.mOuterRadius;
    }

}
