package org.openmap4u.primitive;

 import java.awt.Shape;
import java.awt.geom.Path2D;

import org.openmap4u.geom.Point;

abstract class AbstractLineStringPrimitive<T extends AbstractLineStringPrimitive<T>> extends Primitive<T> implements
		LineStringBuildable<T>, LineStringable {

	/**
	 * Stores a reference to the path.
	 */
	private Path2D.Double  mPath ;

	public AbstractLineStringPrimitive() {
		this.mPath = new Path2D.Double(Path2D.WIND_EVEN_ODD);
	}
	
	
 
	@Override
	public Path2D getPath2D() {
		return this.mPath;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T bezierTo(Point controlPoint1, Point controlPoint2, Point toPoint) {
		this.mPath.curveTo(controlPoint1.getX(), controlPoint1.getY(), controlPoint2.getX(), controlPoint2.getY(), toPoint.getX(), toPoint.getY());
		return (T)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T lineTo(Point toPoint) {
		if (this.mPath.getCurrentPoint() == null) {
			this.moveTo(toPoint);
		} else {
			this.mPath.lineTo(toPoint.getX(), toPoint.getY());
		}
		return (T)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T moveTo(Point toPoint) {
		
		this.mPath.moveTo(toPoint.getX(), toPoint.getY());
		return (T)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T quadTo(Point controlPoint, Point toPoint) {
		this.mPath.quadTo(controlPoint.getX(), controlPoint.getY(), toPoint.getX(), toPoint.getY());
		return (T)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T shape(Shape shape) {
		this.mPath = new Path2D.Double(shape);
		return (T)this;
	}

	
	 


}
