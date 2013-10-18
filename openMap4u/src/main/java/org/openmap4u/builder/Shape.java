package org.openmap4u.builder;

import java.awt.Paint;


 
/**
 * 
 * @author Michael Hadrbolec
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
    public Shape moveTo(double toX, double toY) {
        return super.moveTo(toX, toY);
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
    public Shape lineTo(double toX, double toY) {
        return super.lineTo(toX, toY);
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
    public Shape quadTo(double cpX, double cpY, double toX, double toY) {
        return super.quadTo(cpX, cpY, toY, toY);
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
    public Shape bezierTo(double cp1X, double cp1Y, double cp2X,
            double cp2Y, double toX, double toY) {
        return super.bezierTo(cp1X, cp1Y, cp2X, cp2Y, toY, toY);
    }

    /**
     * Sets an awt shape geometry.
     * 
     * @param shape
     *            The awt shape geometry.
     * @return The Shape itself (method chaining pattern).
     */
    public Shape shape(java.awt.Shape shape) {
              return super.shape(shape);
    }

	/**
	 * Sets the stroke color.
	 * 
	 * @param strokeColor
	 *            The stroke color.
	 * @return The builder itself (method chaining pattern).
	 */
	public Shape strokeColor(Paint strokeColor) {
	   return super.strokeColor(strokeColor);
	}

	/**
	 * Sets the sroke fill.
	 * 
	 * @param strokeFill
	 *            The stroke fill.
	 * @return The builder itself (method chaining pattern).
	 */
	public Shape strokeFill(Paint strokeFill) {
	    return super.strokeFill(strokeFill);
	}

	/**
	 * Sets the stroke size in stroke units.
	 * 
	 * @param strokeSize
	 *            The stroke size in stroke units.
	 * @return The builder itself (method chaining pattern).
	 */
	public Shape strokeSize(double strokeSize) {
	      return super.strokeSize(strokeSize);
	}

	 
	 

}
