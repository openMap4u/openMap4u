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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.commons.Angle;

/**
 * Represents a pie ord a donut.
 *
 * @author Michael Hadrbolec.
 */
public class PieChart extends ShapeBuilder<PieChart> {

    /**
     * Stores the outer radius in drawing units.
     */
    private double mOuterRadius = 1;

    /**
     * Stores the inner radius in drawing units.
     */
    private double mInnerRadius = Double.NaN;

    /**
     * Stores the start angle in degree.
     */
    private double mStartAngle = 0d;

    /**
     * Stores the end angle in degrees.
     */
    private double mExtent = 0d;

    /**
     * Gets the end angle in radiant.
     *
     * @return The end andgle in radiant.
     */
    double getExtent() {
        return this.mExtent;
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
    public PieChart color(Paint strokeColor) {
        return super.color(strokeColor);
    }

    /**
     * Sets the sroke fill.
     *
     * @param strokeFill The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public PieChart fill(Paint strokeFill) {
        return super.fill(strokeFill);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
    * @return The piechart itself (fluent interface pattern).
     */
    @Override
    public PieChart size(double strokeSize) {
        return super.size(strokeSize);
    }

    /**
     * Sets the radius (=outer radius of an donut).
     * @param radius The radius in darwing units.
    * @return The piechart itself (fluent interface pattern).
       */
    public PieChart radius(double radius) {
        this.mOuterRadius = radius;
        return this;
    }

    /**
     * Sets the inner radius (in the case it is a donut).
     * @param innerRadius The inner radius (in the case it is a donut).
     * @return The piechart itself (fluent interface pattern).
     */
    public PieChart innerRadius(double innerRadius) {
        this.mInnerRadius = innerRadius;
        return this;
    }

    /**
     * Sets the outer radius (in the case it is a donut).
     * @param radius The outer radius in darawing units..
    * @return The piechart itself (fluent interface pattern).
      */
    public PieChart outerRadius(double radius) {
        this.mOuterRadius = radius;
        return this;
    }

    /**
     * Sets the diameter (or in the case of an donut the outer diameter).
     * @param diameter The diameter.
    * @return The piechart itself (fluent interface pattern).
      */
    public PieChart diameter(double diameter) {
        return radius(diameter / 2d);
    }

    /**
     * Sets the start angle.
     * @param startAngle The start angle.
   * @return The piechart itself (fluent interface pattern).
       */
    public PieChart start(double startAngle) {
        this.mStartAngle = this.getTransform().getAngleUnits().convert(startAngle);
        return this;
    }

    /**
     * Sets the end angle.
     * @param endAngle The end angle.
    * @return The piechart itself (fluent interface pattern).
      */
    public PieChart end(double endAngle) {
        this.mExtent = this.getTransform().getAngleUnits().convert(endAngle) - getStart();
        return this;
    }

    /**
     * Adds a new value in percent of the whole circle.
     *
     * @param value The value in percent of the whole circle. e.g.: 0.1 (=10%)
     * is represented as 36 degrees., 0.25 (=25%) is represented as 90 degrees.
    * @return The piechart itself (fluent interface pattern).
      */
    public PieChart add(double value) {
        /* add the value */
        this.mExtent = this.getTransform().getAngleUnits().convert(value);
        return this;
    }

    @Override
    public Shape getShape() {
        /* determine wheter it is a pie or a donut */
        if (Double.isNaN(getInnerRadius())) {
            super.shape(getArc(getOuterRadius(), getStart(), getExtent(), Arc2D.PIE));
        } else {
            super.shape(getArc(getOuterRadius(), getStart(), getExtent(), Arc2D.PIE)).subtract(new Ellipse2D.Double(-getInnerRadius(),-getInnerRadius(), getInnerRadius()*2, getInnerRadius()*2));
        }
        return super.getShape();
    }

    /**
     * Gets an arc shape.
     *
     * @param radius The radius of the arc.
     * @param start The start angle in radiand.
     * @param end The end angle in radiand.
     * @param arcType The arc type.
     * @return The arc shape.
     */
    Shape getArc(double radius, double start, double extent, int arcType) {
        Path2D.Double arc = new Path2D.Double(new Arc2D.Double(-radius, -radius, radius * 2d, radius * 2d, convert2Deg(start), convert2Deg(extent), arcType));
        arc.transform(new AffineTransform(1, 0, 0, -1, 0, 0));
        return arc;
    }

    double convert2Deg(double radiant) {
        return Angle.DEGREE.convertFromSI(radiant);
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

    @Override
    public void tearDown() {
        super.tearDown();
        this.mStartAngle = getStart() + getExtent();
    }

}
