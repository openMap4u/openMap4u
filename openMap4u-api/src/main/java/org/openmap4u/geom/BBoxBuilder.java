package org.openmap4u.geom;

import java.awt.geom.Rectangle2D;

import org.openmap4u.builder.Buildable;

public class BBoxBuilder implements  Buildable<BBox> {
	
	private static class BBoxImpl extends Rectangle2D.Double implements BBox {
		 	 
		 BBoxImpl(double minX,double minY, double maxX, double maxY) {
			super(minX,minY,maxX-minX,maxY-minY);
		 }
	}
	
	private double minX,minY,maxX,maxY;

	public BBoxBuilder minX(double minX){
		this.minX= minX;
		return this;
	}
	
	public BBoxBuilder minY(double minY){
		this.minY= minY;
		return this;
	}
	
	
	public BBoxBuilder maxX(double maxX){
		this.maxX= maxX;
		return this;
	}
	
	public BBoxBuilder maxY(double maxY){
		this.maxY= maxY;
		return this;
	}
	
	
	
	@Override
	public BBox build() {
		return  new BBoxImpl(minX,minY,maxX,maxY);
	}

}
