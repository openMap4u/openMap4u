package org.openmap4u.builder;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import org.openmap4u.commons.ShapeDrawable;

import org.openmap4u.commons.ShapeStyle;
import org.openmap4u.commons.ShapeStyleable;

/**
 * All shape builder plugins are derifed from this abstract base class.
 *
 * @author Michael Hadrbolec
 * @param <B> The type of the shape builder.
 */
public abstract class ShapeBuilder<B extends ShapeBuilder<B>> extends
        Builder<  ShapeStyleable, B> implements ShapeDrawable {

    /**
     * Stores a reference to the path.
     */
    private Path2D.Double mPath = null;

    /**
     * Creates a new ShapeBuilder instance.
     */
    public ShapeBuilder() {
        setStyle(new ShapeStyle());
        resetPath();
    }

    /**
     * {@inheritDoc}
     * @return The builder itself (method chaining pattern).
      */
    @Override
    public Shape getShape() {
        return this.mPath;
    }

    /**
     * Sets the shape.
     * @param shape The shape.
     */
    protected void setShape(Shape shape) {
        this.mPath = new Path2D.Double(shape);
    }

    /**
     * Sets the stroke size in stroke units.<img alt="" src="./doc-files/stroke_size.png">
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
     * Sets the stroke color. <img alt="" src="./doc-files/stroke_color.png">
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
     * <img alt="" src="./doc-files/bezier1.png"><img alt="" src="./doc-files/bezier2.png"><img alt="" src="./doc-files/bezier3.png">
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
        this.mPath.curveTo(cp1X, cp1Y, cp2X, cp2Y, toX, toY);
        return (B) this;
    }

    /**
     * Draws a straight line from the last path point (red) to the given point (blue). <img alt="" src="./doc-files/lineTo.png">
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
     * Draws a quadratic curve from the last drawn (red) -,  with the help of a control (gray) -, to the end point (blue). <img alt="" src="./doc-files/quadTo.png">
     *
     * @param cpX The x coordinate of the control point (gray).
     * @param cpY The y coordinate of the control point (gray).
     * @param toX The end x coordinate (blue).
     * @param toY The end y coordinate (blue).
     * @return The Shape itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B quadTo(double cpX, double cpY, double toX, double toY) {
        this.mPath.quadTo(cpX, cpY, toX, toY);
        return (B) this;
    }

    /**
     * Sets the shape (and overrides every allready existing shapes).
     *
     * @param shape The awt shape geometry. E.g.: <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">) = <img alt="" src="./doc-files/c_rectangle.png"></code>
     * @return The Shape itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B shape(java.awt.Shape shape) {
        this.mPath= new Path2D.Double(shape);
        return (B) this;
    }

    Area getArea( ) {
       return new Area(this.mPath);
    }

    /**
     * Adds the provided shape to the primitive.
     *
     * @param shape The shape to add. E.g.: <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).add(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_add.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    protected B add(java.awt.Shape shape) {
        Area area = getArea();
        area.add(new Area(shape));
        this.setShape(area);
        return (B) this;
    }

    /**
     * Intersects the primitive with the provided shape.
     *
     * @param shape The shape to intersetct. E.g.: <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).intersect(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_intersect.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    protected B intersect(java.awt.Shape shape) {
        Area area = getArea();
        area.intersect(new Area(shape));
        this.shape(area);
        return (B) this;
    }

    /**
     * Subtract the primitive with the provided shape.
     *
     * @param shape The shape to subtract. E.g.: <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).subtract(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_subtract.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    protected B subtract(java.awt.Shape shape) {
        Area area = getArea( );
        area.subtract(new Area(shape));
        this.shape(area);
          return (B) this;
    }

    /**
     * Exclusive or the primiive with thegiven shape.
     *
     * @param shape The shape to exclusive or. E.g.: <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).eclusiveOr.(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_exclusiveOr.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    protected B exclusiveOr(java.awt.Shape shape) {
        Area area = getArea( );
        area.exclusiveOr(new Area(shape));
        this.shape(area);
        return (B) this;
    }

    /**
     * For extension developer only (resets the path).
     * @return 
     */
     final B resetPath() {
        this.mPath = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        setShape(mPath);
        return (B) this;
    }

    

}
