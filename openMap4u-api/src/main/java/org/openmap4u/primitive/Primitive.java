package org.openmap4u.primitive;

import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

import org.openmap4u.geom.BBox;
import org.openmap4u.geom.Point;

/**
 * 
 * @author Michael Hadrbolec
 *
 * @param <P>
 *            The primitive type.
 */
public abstract class Primitive<P extends Primitive<P>> implements
		Primitiveable, PrimitiveBuildable<P> {

	private Set<Point> points = null;
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	public Set<Point> getPoints() {
		return points;
	}
	
	@SuppressWarnings("unchecked")
	public P center(Point point) {
		if(points==null) {
			points= new HashSet<>();
		}
		return (P)this;
	}
	
	public boolean isPoint() {
		return getPoints()==null;
	}
	
	public abstract BBox getBBox();

}
