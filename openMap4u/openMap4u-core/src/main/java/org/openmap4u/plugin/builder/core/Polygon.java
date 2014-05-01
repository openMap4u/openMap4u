package org.openmap4u.plugin.builder.core;

import java.awt.Paint;
import java.awt.Shape;
import org.openmap4u.builder.ShapeBuilder;

/**
 * Builds a polygon (= area).
 *
 * @author Michael Hadrbolec
 */
public final class Polygon extends ShapeBuilder<Polygon> {

    /**
     * Moves the path to the given point without drawing anything. It is used to
     * move the "pencil" to the point, where you want to start-, or where you
     * want to continue to draw.
     *
     * @param toX The x coordinate, where you start -, or where you continue to
     * draw.
     * @param toY The y coordinate, where you start -, or where you continue to
     * draw.
     * @return The Polygon itself (method chaining pattern).
     */
    public Polygon moveTo(double toX, double toY) {
        return super.moveTo(toX, toY);
    }

    /**
     * Draws a straight line from the last path point to the given point.
     *
     * @param toX The x coordinate where to draw to.
     * @param toY The y coordinate where to draw to.
     * @return The Polygon itself (method chaining pattern).
     */
    public Polygon lineTo(double toX, double toY) {
        return super.lineTo(toX, toY);
    }

    /**
     * Sets a quadratic curve to the given point.
     *
     * @param cpX The x coordinate of the control point.
     * @param cpY The y coordinate of the control point.
     * @param toX The x coordinate.
     * @param toY The y coordinate.
     * @return The Polygon itself (method chaining pattern).
     */
    public Polygon quadTo(double cpX, double cpY, double toX, double toY) {
        return super.quadTo(cpX, cpY, toY, toY);
    }

    /**
     * Sets a bezier curve to the given point based on two control points.
     *
     * @param cp1X The x coordinate of the first control point.
     * @param cp1Y The y coordinate of the first control point.
     * @param cp2X The x coordinate of the second control point.
     * @param cp2Y The y coordinate of the second control point.
     * @param toX The x coordinate.
     * @param toY The y coordinate.
     * @return The Polygon itself (method chaining pattern).
     */
    public Polygon bezierTo(double cp1X, double cp1Y, double cp2X,
            double cp2Y, double toX, double toY) {
        return super.bezierTo(cp1X, cp1Y, cp2X, cp2Y, toY, toY);
    }

    /**
     * Sets an awt shape geometry.
     *
     * @param shape The awt shape geometry.
     * @return The Polygon itself (method chaining pattern).
     */
    @Override
    public Polygon shape(Shape shape) {
        return super.shape(shape);
    }

    @Override
    public Polygon add(Shape shape) {
        return super.add(shape);
    }

    @Override
    public Polygon subtract(Shape shape) {
        return super.subtract(shape);
    }

    @Override
    public Polygon intersect(Shape shape) {
        return super.intersect(shape);
    }

    @Override
    public Polygon exclusiveOr(Shape shape) {
        return super.exclusiveOr(shape);
    }

    /**
     * Sets the stroke color.
     *
     * @param strokeColor The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    public Polygon color(Paint strokeColor) {
        return super.color(strokeColor);
    }

    /**
     * Sets the sroke fill.
     *
     * @param strokeFill The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    public Polygon fill(Paint strokeFill) {
        return super.fill(strokeFill);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    public Polygon size(double strokeSize) {
        return super.size(strokeSize);
    }

}
