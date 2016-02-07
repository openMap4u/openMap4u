package org.openmap4u.transform;

import java.awt.geom.AffineTransform;

import org.openmap4u.geom.Point;

public class PrimitiveTransformBuilder extends AbstractTransformBuilder {
	
	private double offsetX = 0;
	private double offsetY = 0;

	
	public PrimitiveTransformBuilder offsetX(double offsetX) {
		this.offsetX = offsetX;
		return this;
	}
	
	public PrimitiveTransformBuilder offsetY(double offsetY) {
		this.offsetY = offsetY;
		return this;
	}
	
	
	public AffineTransform build() {
		return null;
	}

}
