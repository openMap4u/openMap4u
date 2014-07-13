package org.openmap4u.builder;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

import org.openmap4u.commons.ShapeDrawable;
import org.openmap4u.commons.ShapeStyle;
import org.openmap4u.commons.ShapeStyleable;

/**
 * All shape builder plugins are derived from this abstract base class. The
 * protected methods can be exposed by the respective implementation of this
 * abstract base template class.
 *
 * @author Michael Hadrbolec
 * @param <B> The type of the shape builder.
 */
public abstract class ShapeBuilder<B extends ShapeBuilder<B>> extends
        Builder<ShapeStyleable, B> implements ShapeDrawable {

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
     *
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public Shape getShape() {
        return this.mPath;
    }

    /**
     * Sets the shape.
     *
     * @param shape The shape.
     */
    protected final void setShape(Shape shape) {
        this.mPath = new Path2D.Double(shape);
    }

    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.<br>
     * <br>
     * Example:<br>
     * <table summary="">
     * <tr>
     * <td><code>myBuilder.size(.5)</code>=</td>
     * <td><img alt="" src="./doc-files/lineSize_1.png"></td>
     * <td><code>myBuilder.size(1)</code>=</td>
     * <td><img alt="" src="./doc-files/lineSize_2.png"></td>
     * <td><code>myBuilder.size(1.5)</code>=</td>
     * <td><img alt="" src="./doc-files/lineSize_3.png"></td>
     * </tr>
     * </table>
     * @return The builder itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B size(double strokeSize) {
        this.getStyle().strokeSize(strokeSize);
        return (B) this;
    }

    /**
     * Sets the primitives stroke color.
     *
     * @param strokeColor The primitives stroke color.<br>
     * <br>
     * Example:<br>
     * <table summary="">
     * <tr>
     * <td><code>myBuilder.color(Color.RED)</code>=</td>
     * <td><img alt="" src="./doc-files/lineColor_red.png"></td>
     * <td><code>myBuilder.color(Color.GREEN)</code>=</td>
     * <td><img alt="" src="./doc-files/lineColor_green.png"></td>
     * <td><code>myBuilder.color(Color.BLUE)</code>=</td>
     * <td><img alt="" src="./doc-files/lineColor_blue.png"></td>
     * </tr>
     * </table>
     * @return The builder itself (fluent interface pattern).
     */
    @SuppressWarnings("unchecked")
    protected B color(Paint strokeColor) {
        this.getStyle().strokeColor(strokeColor);
        return (B) this;
    }

    /**
     * Sets the primitives fill.
     *
     * @param fill The stroke fill.<br>
     * <br>
     * Example:<br>
     * <table summary="">
     * <tr>
     * <td><code>myBuilder.fill(Color.RED)</code>=</td>
     * <td><img alt="" src="./doc-files/b_fillRed.png"></td>
     * <td><code>myBuilder.fill(Color.GREEN)</code>=</td>
     * <td><img alt="" src="./doc-files/b_fillGreen.png"></td>
     * <td><code>myBuilder.fill(Color.BLUE)</code>=</td>
     * <td><img alt="" src="./doc-files/b_fillBlue.png"></td>
     * </tr>
     * </table>
     * @return The builder itself (fluent interface pattern).
     */
    @SuppressWarnings("unchecked")
    protected B fill(Paint fill) {
        this.getStyle().strokeFill(fill);
        return (B) this;
    }

    /**
     * Draws a bezier curve to the given point based on two control points.
     *
     * @param cp1X The x coordinate of the first control point (red).
     * @param cp1Y The y coordinate of the first control point (red).
     * @param cp2X The x coordinate of the second control point (blue).
     * @param cp2Y The y coordinate of the second control point (blue).
     * @param toX The x coordinate (blue).
     * @param toY The y coordinate (blue).
     * <br><br>Example: Draws from the last point (red) via two controll points
     * (red = from, blue = to), to the given point(blue).<br>
     * <table summary="">
     * <tr><td>
     * <code>myBuilder.bezierTo(0.75, 1.375,1.0, .125,1.25, 0.75)</code>=</td><td>
     * <img alt="" src="./doc-files/bezier1.png">
     * </td><td>... other example <img alt="" src="./doc-files/bezier2.png"></td><td> and another example <img
     * alt="" src="./doc-files/bezier3.png"></td></tr></table>
   * @return The builder itself (fluent interface pattern).
       */
    @SuppressWarnings("unchecked")
    protected B bezierTo(double cp1X, double cp1Y, double cp2X, double cp2Y,
            double toX, double toY) {
        this.mPath.curveTo(cp1X, cp1Y, cp2X, cp2Y, toX, toY);
        return (B) this;
    }

    /**
     * Draws a straight line from the last path point to the provided point in
     * map units.
     *
     * @param toX The x coordinate where to draw to.
     * @param toY The y coordinate where to draw to.<br><br>Example: Draws from
     * the last point (red) to the given point(blue).<br>
     * <code>myBuilder.lineTo(1.0,1.1)</code>= <img alt=""
     * src="./doc-files/lineTo.png">
     * @return The builder itself (fluent interface pattern).
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
     * <br><br>Example: <br>
     * <code>myBuilder.moveTo(1.0,1.1)</code>= displays nothing (just moves the
     * pen).
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
     * Draws a quadratic curve from the last drawn (red) -, with the help of a
     * control (gray) -, to the end point (blue).
     *
     * @param cpX The x coordinate of the control point (gray).
     * @param cpY The y coordinate of the control point (gray).
     * @param toX The end x coordinate (blue).
     * @param toY The end y coordinate (blue).
     * <br><br>Example: Draws from the last point (red) to the given point(blue)
     * using te controll point (gray).<br>
     * <code>myBuilder.quadTo(.5,1.0,1.0,0.7)</code>= <img alt=""
     * src="./doc-files/quadTo.png">
     * @return The builder itself (fluent interface pattern).
     */
    @SuppressWarnings("unchecked")
    protected B quadTo(double cpX, double cpY, double toX, double toY) {
        this.mPath.quadTo(cpX, cpY, toX, toY);
        return (B) this;
    }

    /**
     * Sets the primitive shape (and overrides every already existing shapes).
     *
     * @param shape The awt shape geometry.<br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">) = <img alt="" src="./doc-files/c_rectangle.png"></code>
     * @return The Shape itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B shape(Shape shape) {
        this.mPath = new Path2D.Double(shape);
        return (B) this;
    }

    Area getArea() {
        return new Area(this.mPath);
    }

    /**
     * Adds the provided shape to the primitive.
     *
     * @param shape The shape to add.<br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).add(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_add.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    protected B add(Shape shape) {
        Area area = getArea();
        area.add(new Area(shape));
        this.setShape(area);
        return (B) this;
    }

    /**
     * Intersects the primitive with the provided shape.
     *
     * @param shape The shape to intersect.<br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).intersect(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_intersect.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B intersect(Shape shape) {
        Area area = getArea();
        area.intersect(new Area(shape));
        this.shape(area);
        return (B) this;
    }

    /**
     * Subtracts the primitive with the provided shape.
     *
     * @param shape The shape to subtract.<br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).subtract(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_subtract.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B subtract(Shape shape) {
        Area area = getArea();
        area.subtract(new Area(shape));
        this.shape(area);
        return (B) this;
    }

    /**
     * Exclusive or the primitive with the given shape.
     *
     * @param shape The shape to exclusive or. <br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).eclusiveOr.(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_exclusiveOr.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    protected B exclusiveOr(Shape shape) {
        Area area = getArea();
        area.exclusiveOr(new Area(shape));
        this.shape(area);
        return (B) this;
    }

    /**
     * For extension developer only (resets the path).
     *
     * @return
     */
    final B resetPath() {
        this.mPath = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        setShape(mPath);
        return (B) this;
    }

}
