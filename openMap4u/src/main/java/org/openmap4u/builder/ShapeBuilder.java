package org.openmap4u.builder;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Path2D;

import org.openmap4u.primitive.ShapePrimitive;
import org.openmap4u.style.ShapeStyleable;

/**
 * All shape builder plugins are derifed from this abstract base class.
 * 
 * @author Michael Hadrbolec
 * @param <B> The type of the shape builder.
 */
public abstract class ShapeBuilder<B extends ShapeBuilder<B>> extends
        AbstractBuilderPlugin<Shape, ShapeStyleable, B> implements
        ShapePrimitive {

    /**
	 * Stores a reference to the path.
	 */
	private Path2D.Double mPath = null;

	/**
     * Sets the stroke size in stroke units.
     * 
     * @param strokeSize
     *            The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
	public final B setStrokeSize(double strokeSize) {
        this.getStyle().setStrokeSize(strokeSize);
          return (B) this;
    }

    /**
     * Sets the stroke color.
     * 
     * @param strokeColor
     *            The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
	public final B setStrokeColor(Paint strokeColor) {
        this.getStyle().setStrokeColor(strokeColor);
        return (B) this;
    }

    /**
     * Sets the sroke fill.
     * 
     * @param strokeFill
     *            The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
	public final B setStrokeFill(Paint strokeFill) {
        this.getStyle().setStrokeFill(strokeFill);
        return (B) this;
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
	@SuppressWarnings("unchecked")
	protected B bezierTo(double cp1X, double cp1Y, double cp2X,
	        double cp2Y, double toX, double toY) {
	    this.mPath.curveTo(cp1X, cp1Y, cp2X, cp2Y, toY, toY);
	    return (B)this;
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
	@SuppressWarnings("unchecked")
	protected B lineTo(double toX, double toY) {
	    this.mPath.lineTo(toX, toY);
	    return (B)this;
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
	 * @return The Shape itself (method chaining pattern).
	 */
	@SuppressWarnings("unchecked")
	protected B moveTo(double toX, double toY) {
	    if (this.mPath == null) {
	        this.mPath = new Path2D.Double(Path2D.WIND_EVEN_ODD);
	        this.setPrimitive(mPath);
	    }
	    this.mPath.moveTo(toX, toY);
	    return (B)this;
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
	@SuppressWarnings("unchecked")
	protected B quadTo(double cpX, double cpY, double toX, double toY) {
	    this.mPath.quadTo(cpX, cpY, toY, toY);
	    return (B)this;
	}

	/**
	 * Sets an awt shape geometry.
	 * 
	 * @param awtShape
	 *            The awt shape geometry.
	 * @return The Shape itself (method chaining pattern).
	 */
	@SuppressWarnings("unchecked")
	protected B setShape(java.awt.Shape awtShape) {
	    this.mPath = new Path2D.Double(awtShape);
	    return (B)this;
	}

}
