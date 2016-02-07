package org.openmap4u.draw;

import org.openmap4u.interact.Interact;
import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Style;
import org.openmap4u.transform.DrawTransform;

/**
 * 
 * @author Michael Hadrbolec
 *
 * @param <P> The primitive type.
 * @param <S> The style type.
 */
abstract class  AbstractDrawable<P extends Primitive<P> ,S extends Style<S> > implements Drawable<P,S> {
	
	private S style;
	
	private P primitive;
	
	private Interact interact;
	
	private DrawTransform transform;
	
	public AbstractDrawable(P primitive,S style, DrawTransform transform,Interact interact) {
		this.primitive=primitive;
		this.style=style;
		this.transform=transform;
		this.interact=interact;
	}
	
	public AbstractDrawable(P primitive,S style ) {
		this(primitive,style,new DrawTransform(),new Interact());
		this.style=style;
	}
	
	
	public final S getStyle() {
		return style;
	}
	
	public final P getPrimitive(){
		return primitive;
	}
	public final Interact getInteract() {
		return interact;
	};
	
	public final DrawTransform getTransform() {
		return transform;
	}

	public void setStyle(S style) {
		this.style = style;
	}

	public void setPrimitive(P primitive) {
		this.primitive = primitive;
	}

	public void setInteract(Interact interact) {
		this.interact = interact;
	}

	public void setTransform(DrawTransform transform) {
		this.transform = transform;
	}
}
