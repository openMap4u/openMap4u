package org.openmap4u.plugin.builder.core;

import org.openmap4u.builder.ShapeBuilder;
import java.awt.Paint;


 
/**
 * Builds a polyline.
 * 
 * @author Michael Hadrbolec
 */
public final class Polyline  extends ShapeBuilder<Polyline >   {

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
     * @return The Polyline itself (method chaining pattern).
     */
    public Polyline moveTo(double toX, double toY) {
        return super.moveTo(toX, toY);
    }

    /**
     * Draws a straight line from the last path point (red) to the given point (blue). <img alt="" src="./doc-files/lineTo.png">
     * 
     * @param toX
     *            The x coordinate where to draw to.
     * @param toY
     *            The y coordinate where to draw to.
     * @return The Polyline itself (method chaining pattern).
     */
    public Polyline lineTo(double toX, double toY) {
         return super.lineTo(toX, toY);
    }


    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public Polyline quadTo(double cpX, double cpY, double toX, double toY) {
        return super.quadTo(cpX, cpY, toX, toY);
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
     * @return The Polyline itself (method chaining pattern).
     */
    public Polyline bezierTo(double cp1X, double cp1Y, double cp2X,
            double cp2Y, double toX, double toY) {
        return super.bezierTo(cp1X, cp1Y, cp2X, cp2Y, toX, toY);
    }

    /**
     * Sets an awt shape geometry.
     * 
     * @param shape
     *            The awt shape geometry.
     * @return The Polyline itself (method chaining pattern).
     */
    public Polyline shape(java.awt.Shape shape) {
              return super.shape(shape);
    }

	/**
	 * Sets the stroke color.
	 * 
	 * @param strokeColor
	 *            The stroke color.
	 * @return The builder itself (method chaining pattern).
	 */
	public Polyline color(Paint strokeColor) {
	   return super.color(strokeColor);
	}

	/**
	 * Sets the stroke size in stroke units.
	 * 
	 * @param strokeSize
	 *            The stroke size in stroke units.
	 * @return The builder itself (method chaining pattern).
	 */
	public Polyline size(double strokeSize) {
	      return super.size(strokeSize);
	}

	 
	 

}
