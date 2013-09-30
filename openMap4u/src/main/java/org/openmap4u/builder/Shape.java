package org.openmap4u.builder;

import java.awt.Paint;
import java.awt.geom.Path2D;

 
/**
 * 
 * @author Michael Hadrbolec
 * @param <F>
 */
public final class Shape  extends ShapeBuilder<Shape >   {

    /**
     * Moves the path to the given point without drawing anything. It is used to
     * move the "pencil" to the point, where you want to start-, or where you
     * want to continue to draw.
     * 
     * @param toX
     *            The x coordinate, where you start -, or where you continue to
     *            draw.
     * @param toY
     *            The y coordinate, where you start -, or where you continue to
     *            draw.
     * @return The Shape itself (method chaining pattern).
     */
    public Shape setMoveTo(double toX, double toY) {
        return super.setMoveTo(toX, toY);
    }

    /**
     * Draws a straight line from the last path point to the given point.
     * 
     * @param toX
     *            The x coordinate where to draw to.
     * @param toY
     *            The y coordinate where to draw to.
     * @return The Shape itself (method chaining pattern).
     */
    public Shape setLineTo(double toX, double toY) {
        return super.setLineTo(toX, toY);
    }

    /**
     * Sets a quadratic curve to the given point.
     * 
     * @param cpX
     *            The x coordinate of the control point.
     * @param cpY
     *            The y coordinate of the control point.
     * @param toX
     *            The x coordinate.
     * @param toY
     *            The y coordinate.
     * @return The Shape itself (method chaining pattern).
     */
    public Shape setQuadTo(double cpX, double cpY, double toX, double toY) {
        return super.setQuadTo(cpX, cpY, toY, toY);
    }

    /**
     * Sets a bezier curve to the given point based on two control points.
     * 
     * @param cp1X
     *            The x coordinate of the first control point.
     * @param cp1Y
     *            The y coordinate of the first control point.
     * @param cp2X
     *            The x coordinate of the second control point.
     * @param cp2Y
     *            The y coordinate of the second control point.
     * @param toX
     *            The x coordinate.
     * @param toY
     *            The y coordinate.
     * @return The Shape itself (method chaining pattern).
     */
    public Shape setBezierTo(double cp1X, double cp1Y, double cp2X,
            double cp2Y, double toX, double toY) {
        return super.setBezierTo(cp1X, cp1Y, cp2X, cp2Y, toY, toY);
    }

    /**
     * Sets an awt shape geometry.
     * 
     * @param shape
     *            The awt shape geometry.
     * @return The Shape itself (method chaining pattern).
     */
    public Shape setShape(java.awt.Shape shape) {
              return super.setShape(shape);
    }

	 
	 

}
