package org.openmap4u.draw;

import org.openmap4u.geom.BBox;
import org.openmap4u.interact.Interact;
import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Style;
import org.openmap4u.transform.DrawTransform;

/**
 * 
 * @author Michael Hadrbolec
 *
 * @param
 * 			<P>
 *            The primitive type.
 * @param <S>
 *            The style type.
 */
public interface Drawable<P extends Primitive<P>, S extends Style<S>> {

	S getStyle();
	
	void setStyle(S style);

	P getPrimitive();
	
	void setPrimitive(P primitive);

	Interact getInteract();
	
	void setInteract(Interact interact);

	DrawTransform getTransform();
	
	/**
	 * Gets the enclosing bounding box.
	 * @return The enclosing bounding box.
	 */
	BBox getBBox();
}
