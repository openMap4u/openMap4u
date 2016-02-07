package org.openmap4u.style;

import java.awt.Paint;

public final class ShapeStyle extends AbstractLineStringStyle<ShapeStyle>implements ShapeStyleable, ShapeStyleBuildable<ShapeStyle> {

	private Paint fill=null;
	
	public ShapeStyle() {
		super();
	}

 	
	@Override
	public ShapeStyle strokeFill(Paint fill) {
		this.fill = fill;
		return this;
	}

	@Override
	public Paint getStrokeFill() {
		return this.fill;
	}

	public boolean equals(Object object) {
		if (object instanceof ShapeStyle) {
			ShapeStyle obj = (ShapeStyle) object;
			return super.equals(object) && this.getStrokeFill() == obj.getStrokeFill();
		} else {
			return false;
		}
	}

}
