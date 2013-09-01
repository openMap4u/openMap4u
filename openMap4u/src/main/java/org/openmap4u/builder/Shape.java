package org.openmap4u.builder;

import java.awt.geom.Path2D;

 
/**
 * 
 * @author Michael Hadrbolec
 * @param <F>
 */
public final class Shape  extends ShapeBuilder<Shape >   {

    /**
     * Stores a reference to the path.
     */
    private Path2D.Double mPath = null;

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
        if (this.mPath == null) {
            this.mPath = new Path2D.Double(Path2D.WIND_EVEN_ODD);
            this.setPrimitive(mPath);
        }
        this.mPath.moveTo(toX, toY);
        return this;
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
        this.mPath.lineTo(toX, toY);
        return this;
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
        this.mPath.quadTo(cpX, cpY, toY, toY);
        return this;
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
        this.mPath.curveTo(cp1X, cp1Y, cp2X, cp2Y, toY, toY);
        return this;
    }

    /**
     * Sets an awt shape geometry.
     * 
     * @param awtShape
     *            The awt shape geometry.
     * @return The Shape itself (method chaining pattern).
     */
    public Shape setShape(java.awt.Shape awtShape) {
        this.mPath = new Path2D.Double(awtShape);
        return this;
    }

	 

}
