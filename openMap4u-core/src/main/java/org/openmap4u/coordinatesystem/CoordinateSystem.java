package org.openmap4u.coordinatesystem;

import java.awt.geom.Point2D.Double;

public abstract class CoordinateSystem {
	
	/**
	 * The previous x coordinate.
	 */
	private double mPx=0;
	
	/**
	 * The previous y coordinate.
	 */
	private double mPy=0;
	
	
    protected abstract double transformX(double x, double y);
	
	protected abstract double transformY(double x, double y);
	
	
	/**
	 * Nothing to convert (is absolute).
	 * @param x The absolute x coordinate.
	 * @param y The absolute y coordinate.
	 * @return The resulting point.
	 */
	public Double convert(double x, double y ) {
	return create(transformX(x,y),transformY(x,y));
	}
	
	/**
	 * Converts a relative x and and absolute y coordinate into a point.
	 * @param x The relative x coordinate.
	 * @param y The absolute y coordinate.
	 * @return The resulting absolute point.
	 */
	public Double convert(String x, double y ) {
		return convert(convertX(x),y);
	}
	
	
	/**
	 * Converts an absolute x and a relative y coordinate into an absolute point.
	 * @param x The absolute x coordinate.
	 * @param y The relative y coordinate.
	 * @return The resulting absolute point.
	 */
	public Double convert(double x, String y ) {
		return convert(x,convertY(y));
	}
	
	/**
	 * Converts a realtive x and a relative y coordinate into an absolute point.
	 * @param x The relative x coordinate.
	 * @param y The relative y coordinate.
	 * @return The resulting absolute point.
	 */
	public Double convert(String x, String y ) {
		return convert(convertX(x),convertY(y));
	}
	
	/**
	 * Converts a relative x coordinate.
	 * @param x The relative x coordinate.
	 * @return The absolute x coordinate.
	 */
	double convertX(String x) { 
		return mPx+java.lang.Double.valueOf(x.substring(1));
	}
	
	/**
	 * Converts a relative y coordinate.
	 * @param y The relative y coordinate.
	 * @return The absolute y coordinate.
	 */
	double convertY(String y) { 
		return mPy+java.lang.Double.valueOf(y.substring(1));
	}
	
 
	
	/**
	 * Sets the previous point to the given point and also returns it.
	 * @param x The absolute x coordinate.
	 * @param y The absolute y coordinate.
	 * @return The point.
	 */
	Double create(double x,double y) {
		this.mPx=x;
		this.mPy=y;
		return new Double(x,y);
	}

}
