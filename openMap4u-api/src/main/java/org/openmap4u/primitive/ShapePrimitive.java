package org.openmap4u.primitive;

import java.awt.Shape;
import java.awt.geom.Area;

public final class ShapePrimitive extends AbstractLineStringPrimitive<ShapePrimitive> implements
		ShapeBuildable<ShapePrimitive>, Shapeable {

 

 

	@Override
	public ShapePrimitive add(Shape shape) {
		Area area = getArea();
		area.add(new Area(shape));
		this.shape(area);
		return this;
	}

	Area getArea() {
		return new Area(this.getPath2D());
	}

	@Override
	public ShapePrimitive intersect(Shape shape) {
		Area area = getArea();
		area.intersect(new Area(shape));
		this.shape(area);
		return this;
	}

	@Override
	public ShapePrimitive subtract(Shape shape) {
		Area area = getArea();
		area.subtract(new Area(shape));
		this.shape(area);
		return this;
	}

	@Override
	public ShapePrimitive exclusiveOr(Shape shape) {
		Area area = getArea();
		area.exclusiveOr(new Area(shape));
		this.shape(area);
		return this;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return new ShapePrimitive().shape((Shape) this.getPath2D().clone());
	}

}
