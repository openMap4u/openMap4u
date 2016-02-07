package org.openmap4u.builder;

import java.awt.geom.Point2D;

import org.openmap4u.common.Plugable;
import org.openmap4u.draw.Drawable;
import org.openmap4u.geom.Point;
import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Style;
import org.openmap4u.style.StyleBuildable;
import org.openmap4u.transform.PrimitiveTransformBuildable;
import org.openmap4u.transform.HorizontalAlign;
import org.openmap4u.transform.VerticalAlign;


/**
 * 
 * @author Michael hadbrbolec
 *
 * @param <D>
 * @param <P>
 * @param <S>
 * @param <B>
 */
abstract class AbstractBuilder<D extends Drawable<P,S>,P extends Primitive<P>,S extends Style<S>, B extends AbstractBuilder<D,P,S,B>>
		implements DrawableBuilder<D, P,S> , PrimitiveTransformBuildable<B>, StyleBuildable<B> {



	private D drawable;

	public AbstractBuilder(D drawable) {
		this.setDrawable(drawable);
	}

	public final D getDrawable() {
		return drawable;
	}

	protected final void setDrawable(D drawable) {
		this.drawable = drawable;
	}

	public D build() {
		return drawable;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B alpha(double alpha) {
		this.getDrawable().getStyle().alpha(alpha);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B visible(boolean visible) {
		this.getDrawable().getStyle().visible(visible);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B rotate(double rotation) {
		this.getDrawable().getTransform().rotate(rotation);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B scale(double scaleFactor) {
		this.getDrawable().getTransform().scale(scaleFactor);
		return (B) this;
	}


	@SuppressWarnings("unchecked")
	@Override
	public B scaleX(double scaleX) {
		this.getDrawable().getTransform().scaleX(scaleX);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B scaleY(double scaleY) {
		this.getDrawable().getTransform().scaleY(scaleY);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B offset(Point offset) {
		this.getDrawable().getTransform().offset(offset);
		return (B) this;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public B verticalAlign(VerticalAlign verticalAlign) {
		this.getDrawable().getTransform().verticalAlign(verticalAlign);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B horizontalAlign(HorizontalAlign horizontalAlign) {
		this.getDrawable().getTransform().horizontalAlign(horizontalAlign);
		return (B) this;
	}
	
	@SuppressWarnings("unchecked")
	public B center(Point  point) {
		this.getDrawable().getPrimitive().center(point);
		return (B) this;
		
	}

}
