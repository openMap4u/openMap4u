package org.openmap4u.primitive;

import java.awt.Shape;

import org.openmap4u.geom.Point;

public interface LineStringBuildable<T extends LineStringBuildable<T>> extends PrimitiveBuildable<T> {

	/**
	 * Draws a bezier curve to the given point based on two control points.
	 *
	 * @param controlPoint1
	 *            The first control point (red).
	 * @param controlPoint2
	 *            The the second control point (blue).
	 * @param topoint
	 *            The point to draw to (blue).
	 * <br>
	 *            Example: Draws from the last point (red) via two controll
	 *            points (red = from, blue = to), to the given point(blue).<br>
	 *            <table summary="">
	 *            <tr>
	 *            <td>
	 *            <code>myBuilder.bezierTo(new Point(0.75, 1.375), new Point(1.0, .125), new Point(1.25, 0.75))</code>=
	 *            </td>
	 *            <td>
	 *            <img alt="" src="./doc-files/bezier1.png"></td>
	 *            <td>... other example <img alt=""
	 *            src="./doc-files/bezier2.png"></td>
	 *            <td>and another example <img alt=""
	 *            src="./doc-files/bezier3.png"></td>
	 *            </tr>
	 *            </table>
	 * @return The builder itself (fluent interface pattern).
	 */
	T bezierTo(Point controlPoint1, Point controlPoint2, Point toPoint);

	/**
	 * Draws a straight line from the last path point to the provided point in
	 * map units.
	 *
	 * @param toPoint
	 *            The point where to draw to.
	 * <br>
	 *            Example: Draws from the last point (red) to the given
	 *            point(blue).<br>
	 *            <code>myBuilder.lineTo(new Point(1.0,1.1))</code>= <img alt=""
	 *            src="./doc-files/lineTo.png">
	 * @return The builder itself (fluent interface pattern).
	 */
	T lineTo(Point toPoint);

	/**
	 * Moves the path to the given point without drawing anything. It is used to
	 * move the "pencil" to the point, where you want to start-, or where you
	 * want to continue to draw.
	 *
	 * @param toPoint
	 *            The point, where you start -, or where you continue to
	 *            draw.
	 * <br>
	 *            Example: <br>
	 *            <code>myBuilder.moveTo(new Point(1.0,1.1))</code>= displays nothing (just
	 *            moves the pen).
	 */
	T moveTo(Point toPoint);

	/**
	 * Draws a quadratic curve from the last drawn (red) -, with the help of a
	 * control (gray) -, to the end point (blue).
	 *
	 * @param controlPoint The the control point (gray).
 	 * @param toPoint
	 *            The end point (blue).
 	 * <br>
	 *            Example: Draws from the last point (red) to the given
	 *            point(blue) using te controll point (gray).<br>
	 *            <code>myBuilder.quadTo(new point(.5,1.0),new Point(1.0,0.7))</code>= <img alt=""
	 *            src="./doc-files/quadTo.png">
	 * @return The builder itself (fluent interface pattern).
	 */
	T quadTo(Point controlPoint, Point toPoint);

	/**
	 * Sets the primitive shape (and overrides every already existing shapes).
	 *
	 * @param shape
	 *            The awt shape geometry.<br>
	 * <br>
	 *            Example:<br>
	 *            <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">) = <img alt="" src="./doc-files/c_rectangle.png"></code>
	 * @return The Shape itself (method chaining pattern).
	 */
	T shape(Shape shape);
}