package org.openmap4u.builder;

import org.openmap4u.draw.ShapeDrawable;
import org.openmap4u.geom.Path2DBuildable;
import org.openmap4u.primitive.ShapePrimitive;
import org.openmap4u.style.ShapeStyle;

public abstract class ShapeBuilder<T extends ShapeBuilder<T>> extends AbstractBuilder<ShapeDrawable,ShapePrimitive,ShapeStyle,T > {

	public ShapeBuilder() {
		super(new ShapeDrawable());
	}
	
	protected Path2DBuildable getPath2DBuilder() {
	
		return null;
	}

}
