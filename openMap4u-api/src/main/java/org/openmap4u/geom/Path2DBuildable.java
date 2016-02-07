package org.openmap4u.geom;

import java.awt.Shape;
import java.awt.geom.Path2D;

import org.openmap4u.builder.Buildable;

public interface Path2DBuildable<T extends Path2DBuildable<T>> extends Buildable<Path2D.Double> {

	/**
	 * Adds a path to the current path.
	 * 
	 * @return
	 */
	T addPath(Path2DBuildable<T> path2dBuilder);

	/**
	 * Causes the point of the pen to move back to the start of the current
	 * sub-path. It tries to draw a straight line from the current point to the
	 * start. If the shape has already been closed or has only one point, this
	 * function does nothing.
	 * 
	 * @return
	 */
	T closePath();

	/**
	 * Moves the starting point of a new sub-path to the position.
	 * 
	 * @param toPoint
	 * @return Method chaining pattern.
	 */
	T moveTo(Point toPoint);

	/**
	 * Connects the last point in the subpath to the point with a straight line.
	 * 
	 * @param toPoint
	 * @return Method chaining pattern.
	 */
	T lineTo(Point toPoint);

	/**
	 * Adds a cubic Bezier curve to the path. It requires three points. The
	 * first two points are control points and the third one is the end point.
	 * The starting point is the last point in the current path.
	 * 
	 * @param controlPoint1
	 * @param controlPoint2
	 * @param toPoint
	 * @return Method chaining pattern.
	 */
	T bezierCurveTo(Point controlPoint1, Point controlPoint2, Point toPoint);

	/**
	 * Adds a quadratic Bezier curve to the current path.The first point is the
	 * control point and the second one is the end point. The starting point is
	 * the last point in the current path.
	 * 
	 * @param controlPoint
	 * @param toPoint
	 * @return Method chaining pattern.
	 */
	T quadraticCurveTo(Point controlPoint, Point toPoint);

	/**
	 * Adds an arc to the path which is centered at the position with radius
	 * starting at startAngle and ending at endAngle going in the given
	 * direction by anticlockwise (defaulting to clockwise).
	 * 
	 * @param position
	 * @param radius
	 * @param startAngle
	 * @param endAngle
	 * @return Method chaining pattern.
	 */
	T arc(Point position, double radius, double startAngle, double endAngle);

	/**
	 * Adds an arc to the path with the given control points and radius,
	 * connected to the previous point by a straight line.
	 * 
	 * @param controlPoint1
	 * @param controlPoint2
	 * @param radiusX
	 *            radiusX
	 * @param radiusY
	 *            radiusY
	 * @param rotation
	 * @return Method chaining pattern.
	 */
	T arcTo(Point controlPoint1, Point controlPoint2, double radiusX,
			double radiusY, double rotation);

	/**
	 * Adds an ellipse to the path which is centered at (x, y) position with the
	 * radii radiusX and radiusY starting at startAngle and ending at endAngle
	 * going in the given direction by anticlockwise (defaulting to clockwise).
	 * 
	 * @param position
	 *            centered
	 * @param radiusX
	 *            radiusX
	 * @param radiusY
	 *            radiusY
	 * @return Method chaining pattern.
	 */
	T ellipse(Point position, double radiusX, double radiusY);

	/**
	 * Creates a path for a rectangle at position with a size that is determined
	 * by width and height.
	 * 
	 * @param position
	 * @param width
	 *            width
	 * @param height
	 *            height
	 * @return Method chaining pattern.
	 */
	T rect(Point position, double width, double height);

}
