/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Paint;
import java.awt.geom.Path2D;
import org.openmap4u.builder.ShapeBuilder;

/**
 * Represents a area chart
 *
 * @author Michael Hadrbolec
 */
public class Area extends ShapeBuilder<Area>  {

    private boolean mStackX = false;

    private boolean mStackY = false;
    
    /* stores the prevoius path */
    private Path2D.Double mPreviousPath= null;

     public Area stackX() {
        this.mStackX = true;
        return this;
    }

     public Area stackY() {
        this.mStackY = true;
        return this;
    }
    
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
     * @return The Area itself (method chaining pattern).
     */
    public Area moveTo(double toX, double toY) {
        return super.moveTo(toX, toY);
    }

    /**
     * Draws a straight line from the last path point to the given point.
     * 
     * @param toX
     *            The x coordinate where to draw to.
     * @param toY
     *            The y coordinate where to draw to.
     * @return The Area itself (method chaining pattern).
     */
    public Area lineTo(double toX, double toY) {
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
     * @return The Area itself (method chaining pattern).
     */
    public Area quadTo(double cpX, double cpY, double toX, double toY) {
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
     * @return The Area itself (method chaining pattern).
     */
    public Area bezierTo(double cp1X, double cp1Y, double cp2X,
            double cp2Y, double toX, double toY) {
        return super.bezierTo(cp1X, cp1Y, cp2X, cp2Y, toY, toY);
    }

    /**
     * Sets an awt shape geometry.
     * 
     * @param shape
     *            The awt shape geometry.
     * @return The Area itself (method chaining pattern).
     */
    public Area shape(java.awt.Shape shape) {
              return super.shape(shape);
    }

	/**
	 * Sets the stroke color.
	 * 
	 * @param strokeColor
	 *            The stroke color.
	 * @return The builder itself (method chaining pattern).
	 */
	public Area color(Paint strokeColor) {
	   return super.color(strokeColor);
	}

	/**
	 * Sets the stroke size in stroke units.
	 * 
	 * @param strokeSize
	 *            The stroke size in stroke units.
	 * @return The builder itself (method chaining pattern).
	 */
	public Area size(double strokeSize) {
	      return super.size(strokeSize);
	}
        
        


}
