/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Point2D;
import org.openmap4u.builder.ShapeBuilder;
 
/**
 *
 * @author Michael Hadrbolec
 */
public class Line extends ShapeBuilder<Line> {

    private Point2D.Double mFrom = null;

    private Point2D.Double mTo = null;

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
     * Sets the sroke fill.
     *
     * @param strokeFill The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Line fill(Paint strokeFill) {
        return super.fill(strokeFill);
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

    /**
     * Sets the start point of the line.
     *
     * @param fromX The start point x coordinate.
     * @param fromY The start point y coordinate.
     * @return The builder itself (method chaining pattern).
     */
    public Line from(double fromX, double fromY) {
        this.mFrom = new Point2D.Double(fromX, fromY);
        return this;
    }

    /**
     * Sets the end point of the line.
     *
     * @param toX The line end point x coordinate.
     * @param toY The lien end point y coordinate.
     * @return The builder itself (method chaining pattern).
     */
    public Line to(double toX, double toY) {
        this.mTo = new Point2D.Double(toX, toY);
        return this;
    }

    /**
     * Gets the primitive.
     * @return The primitive.
     */
    @Override
    public Shape   getShape() {
          moveTo(mFrom.x, mFrom.y).lineTo(mTo.x, mTo.y);
        /* determine wheter it is a pie or a donut */
        return super.getShape();
    }

}
