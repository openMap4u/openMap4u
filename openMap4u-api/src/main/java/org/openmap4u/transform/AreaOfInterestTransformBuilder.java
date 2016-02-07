package org.openmap4u.transform;

import java.awt.geom.AffineTransform;

import org.openmap4u.geom.Point;

public final class AreaOfInterestTransformBuilder extends AbstractTransformBuilder {
	
	private Point point = null;
	
	public AreaOfInterestTransformBuilder center(Point point) {
		this.point = point;
		return this;
	}
	
	
	public AffineTransform build() {
		return null;
	}
	

}
