package org.openmap4u.style;

import java.awt.Color;
import java.awt.Paint;

abstract class AbstractLineStringStyle<T extends AbstractLineStringStyle<T>> extends Style<T> implements LineStringStyleable,LineStringStyleBuildable<T> {

	public static double DEFAULT_STROKE_SIZE = 0.5;
	public static Paint DEFAULT_STROKE_COLOR = Color.BLACK;
	
	private Paint strokeColor;
	
	private double strokeSize;
	
	public AbstractLineStringStyle() {
		super();
		this.strokeColor(DEFAULT_STROKE_COLOR).strokeSize(DEFAULT_STROKE_SIZE);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T strokeColor(Paint strokeColor) {
		this.strokeColor=strokeColor;
 		return (T)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T strokeSize(double strokeSize) {
		this.strokeSize=strokeSize;
 		return (T)this;
	}

	@Override
	public Paint getStrokeColor() {
 		return this.strokeColor;
	}

	@Override
	public double getStrokeSize() {
 		return this.strokeSize;
	}
	
	public boolean equals(Object object) {
		boolean equals = false;
		if (object instanceof AbstractLineStringStyle) {
			AbstractLineStringStyle obj = (AbstractLineStringStyle) object;
			return super.equals(object) && this.getStrokeColor() == obj.getStrokeColor() && this.getStrokeSize() == obj.getStrokeSize();
		}
		return equals;

	}

}
