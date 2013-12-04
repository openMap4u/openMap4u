package org.openmap4u.builder;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import org.openmap4u.primitive.ShapeDrawable;

import org.openmap4u.style.ShapeStyle;
import org.openmap4u.style.ShapeStyleable;

/**
 * All shape builder plugins are derifed from this abstract base class.
 *
 * @author Michael Hadrbolec
 * @param <>> The type of the shape builder.
 */
public abstract class ShapeBuilder<B extends ShapeBuilder<B>> extends
        Buildable<  ShapeStyleable, B> implements ShapeDrawable {

    /**
     * Stores a reference to the path.
     */
    private Path2D.Double mPath = null;

    public ShapeBuilder() {
        resetPath();
    }

    public Shape getShape() {
        return this.mPath;
    }

    protected void setShape(Shape shape) {
        this.mPath = new Path2D.Double(shape);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B size(double strokeSize) {
        this.getStyle().setStrokeSize(strokeSize);
        return (B) this;
    }

    /**
     * Sets the stroke color.
     *
     * @param strokeColor The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B color(Paint strokeColor) {
        this.getStyle().setStrokeColor(strokeColor);
        return (B) this;
    }

    /**
     * Sets the sroke fill.
     *
     * @param strokeFill The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B fill(Paint strokeFill) {
        this.getStyle().setStrokeFill(strokeFill);
        return (B) this;
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
     * @return The Shape itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B bezierTo(double cp1X, double cp1Y, double cp2X,
            double cp2Y, double toX, double toY) {
        this.mPath.curveTo(cp1X, cp1Y, cp2X, cp2Y, toY, toY);
        return (B) this;
    }

    /**
     * Draws a straight line from the last path point to the given point.
     *
     * @param toX The x coordinate where to draw to.
     * @param toY The y coordinate where to draw to.
     * @return The Shape itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B lineTo(double toX, double toY) {
        if (this.mPath.getCurrentPoint() == null) {
            this.moveTo(toX, toY);
        } else {
            this.mPath.lineTo(toX, toY);
        }
        return (B) this;
    }

    /**
     * Moves the path to the given point without drawing anything. It is used to
     * move the "pencil" to the point, where you want to start-, or where you
     * want to continue to draw.
     *
     * @param toX The x coordinate, where you start -, or where you continue to
     * draw.
     * @param toY The y coordinate, where you start -, or where you continue to
     * draw.
     * @return The Shape itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B moveTo(double toX, double toY) {
        if (this.mPath == null) {
            resetPath();
        }
        this.mPath.moveTo(toX, toY);
        return (B) this;
    }

    /**
     * Sets a quadratic curve to the given point.
     *
     * @param cpX The x coordinate of the control point.
     * @param cpY The y coordinate of the control point.
     * @param toX The x coordinate.
     * @param toY The y coordinate.
     * @return The Shape itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B quadTo(double cpX, double cpY, double toX, double toY) {
        this.mPath.quadTo(cpX, cpY, toY, toY);
        return (B) this;
    }

    /**
     * Sets an awt shape geometry.
     *
     * @param awtShape The awt shape geometry.
     * @return The Shape itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B shape(java.awt.Shape awtShape) {
        this.mPath.append(awtShape, true);
        return (B) this;
    }

    Area getArea(java.awt.Shape shape) {
        return new Area(shape);
    }

    /**
     * Adds the provided shape to the primitive.
     *
     * @param shape The shape to add.
     * @return The builder itself (method chaining pattern).
     */
    protected B add(java.awt.Shape shape) {
        Area area = getArea(getShape());
        area.add(getArea(shape));
        setShape(area);
        return (B) this;
    }

    /**
     * Intersects the primitive with the provided shape.
     *
     * @param shape The shape to add.
     * @return The builder itself (method chaining pattern).
     */
    protected B intersect(java.awt.Shape shape) {
        Area area = getArea(getShape());
        area.intersect(getArea(shape));
        this.setShape(area);
        return (B) this;
    }

    /**
     * Subtract the primitive with the provided shape.
     *
     * @param shape The shape to add.
     * @return The builder itself (method chaining pattern).
     */
    protected B subtract(java.awt.Shape shape) {
        Area area = getArea(this.mPath);
        area.subtract(getArea(shape));
        this.mPath.reset();
        this.mPath.append(area, false);
        return (B) this;
    }

    /**
     * Exclusive or the primiive with thegiven shape.
     *
     * @param shape The shape to exclusive or.
     * @return The builder itself (method chaining pattern).
     */
    protected B exclusiveOr(java.awt.Shape shape) {
        Area area = getArea(getShape());
        area.exclusiveOr(getArea(shape));
        setShape(area);
        return (B) this;
    }

    protected B resetPath() {
        this.mPath = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        setShape(mPath);
        return (B) this;
    }

    protected Path2D.Double getPath2D() {
        return new Path2D.Double(this.getShape());
    }

}
