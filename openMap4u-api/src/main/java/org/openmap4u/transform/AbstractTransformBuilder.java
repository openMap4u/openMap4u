package org.openmap4u.transform;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.Serializable;

import org.openmap4u.builder.Buildable;
import org.openmap4u.geom.BBox;

abstract class AbstractTransformBuilder<T extends AbstractTransformBuilder<T>> implements TransformBuildable<T>, Buildable<AffineTransform>, Serializable, Cloneable {
	
		/**
	 * The default offset in x and y axis direction is <code>0</code> (= no
	 * offset).
	 */
	public static final double DEFAULT_TRANSLATE =0;
	/**
	 * The default rotation angle is <code>0</code> degrees (= no rotation at
	 * all).
	 */
	public static final double DEFAULT_ROTATE = 0;
	/**
	 * The default scale factor in x an y axis direction is <code>1</code>.
	 */
	public static final double DEFAULT_SCALE = 1;
	 
	
	private double translateX= DEFAULT_TRANSLATE;
	private double translateY=DEFAULT_TRANSLATE;
	private double scaleX=DEFAULT_SCALE;
	private double scaleY=DEFAULT_SCALE;
	private double rotate=DEFAULT_ROTATION;
	private Shape shape = null;
	
	private BBox bBox = null;


 	public AbstractTransformBuilder translate(double translateX,double translateY) {
		this.translateX=translateX;
		this.translateY=translateY;
		return this;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public T rotate(double rotation) {
		this.rotate=rotation;
		return (T)this;
	}

	@Override
	public T scale(double scaleFactor) {
		this.scaleX(scaleFactor).scaleY(scaleFactor);
		return (T)this;
	}

	@Override
	public T scaleX(double scaleX) {
		this.scaleX=scaleX;
		return (T)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T scaleY(double scaleY) {
		this.scaleY=scaleY;
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T bBox(BBox bBox) {
		this.bBox= bBox;
		return (T)this;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	




	protected double getScaleX() {
		return scaleX;
	}



	protected double getScaleY() {
		return scaleY;
	}



	protected double getRotate() {
		return rotate;
	}



	 
	
	protected BBox getBBox() {
		return bBox;
	}
	
	


}
