package org.openmap4u.builder;

import org.openmap4u.common.Plugable;
import org.openmap4u.draw.Drawable;
import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Style;

/**
 * All drawable are derived from this base class.
 * 
 * @author hadrbolec
 *
 * @param <D> The drawable type.
 * @param <P> The primitive type.
 * @param <S> The style type.
 */
public interface DrawableBuilder<D extends Drawable<P,S>,P extends Primitive<P>, S extends Style<S>>  extends  Buildable<D>, Plugable {

	
 
	 
}
