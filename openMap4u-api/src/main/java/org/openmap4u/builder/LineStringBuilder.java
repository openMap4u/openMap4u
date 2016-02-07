package org.openmap4u.builder;

import org.openmap4u.draw.LineStringDrawable;
import org.openmap4u.primitive.LineStringPrimitive;
import org.openmap4u.style.LineStringStyle;

public abstract class LineStringBuilder<T extends LineStringBuilder<T>> extends AbstractBuilder<LineStringDrawable,LineStringPrimitive,LineStringStyle,T>  {

	public LineStringBuilder( ) {
		super(new LineStringDrawable());
 	}

}
