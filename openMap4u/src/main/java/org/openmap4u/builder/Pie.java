/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import java.awt.Paint;
import java.awt.Point;
import org.openmap4u.unit.Angle;

/**
 *
 * @author zwotti
 */
public class Pie extends ShapeBuilder<Pie> {

    private double mOuterRadius;
    private double mInnerRadius = Double.NaN;

    private double mStartAngle;
    private double mEndAngle;

    private Angle mAngularUnit = Angle.DEGREE;

    /**
     * Sets the stroke color.
     *
     * @param strokeColor The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Pie strokeColor(Paint strokeColor) {
        return super.strokeColor(strokeColor);
    }

    /**
     * Sets the sroke fill.
     *
     * @param strokeFill The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Pie strokeFill(Paint strokeFill) {
        return super.strokeFill(strokeFill);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Pie strokeSize(double strokeSize) {
        return super.strokeSize(strokeSize);
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

    public Pie startAngle(double startAngle) {
        this.mStartAngle = getAngularUnit().convert(startAngle);
        return this;
    }

    public Pie endAngle(double endAngle) {
        this.mEndAngle = getAngularUnit().convert(endAngle);
        return this;
    }

    public Pie angularUnit(Angle angularUnit) {
        this.mAngularUnit = angularUnit;
        return this;
    }

    Angle getAngularUnit() {
        return this.mAngularUnit;
    }

    @Override
    public java.awt.Shape getPrimitive() {
        /* determine wheter it is a pie or a donut */
        if (Double.isNaN(this.mInnerRadius)) {
            initPie(getPoint(this.mStartAngle, this.mOuterRadius), getControlPoint(this.mStartAngle, this.mEndAngle, this.mOuterRadius), getPoint(this.mEndAngle, this.mOuterRadius));
        } else {
            initDonut(getPoint(this.mStartAngle, this.mInnerRadius), getControlPoint(this.mStartAngle, this.mEndAngle, this.mInnerRadius), getPoint(this.mEndAngle, this.mInnerRadius), getPoint(this.mStartAngle, this.mOuterRadius), getControlPoint(this.mStartAngle, this.mEndAngle, this.mOuterRadius), getPoint(this.mEndAngle, this.mOuterRadius));
        }
        return super.getPrimitive();
    }

    Point.Double getPoint(double angle, double radius) {
        return new Point.Double(radius * Math.cos(angle), radius * Math.sin(angle));
    }

    Point.Double getControlPoint(double startAngle, double endAngle, double radius) {
        double h = radius / (Math.cos((endAngle - startAngle) / 2));
        return new Point.Double(h * Math.cos((startAngle + endAngle) / 2), h * Math.sin((startAngle + endAngle) / 2));
    }

    void initDonut(Point.Double innerStart, Point.Double innerCp, Point.Double innerEnd, Point.Double outerStart, Point.Double outerCp, Point.Double outerEnd) {
        System.out.println(innerEnd);
        moveTo(innerStart.x, innerStart.y).lineTo(outerStart.x, outerStart.y).quadTo(outerCp.x, outerCp.y, outerEnd.x, outerEnd.y).lineTo(innerEnd.x, innerEnd.y).moveTo(innerStart.x, innerStart.y).quadTo(innerCp.x, innerCp.y, innerEnd.x, innerEnd.y);
    }

    /**
     * Creates a pie shape.
     *
     * @param start The start point of the pie.
     * @param cp The control poit of the pie.
     * @param end The end point of the pie.
     */
    void initPie(Point.Double start, Point.Double cp, Point.Double end) {
        moveTo(0, 0).lineTo(start.x, start.y).quadTo(cp.x, cp.y, end.x, end.y).lineTo(0, 0);
    }

}
