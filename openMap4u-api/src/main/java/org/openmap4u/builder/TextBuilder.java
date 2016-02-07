package org.openmap4u.builder;

import org.openmap4u.draw.TextDrawable;
import org.openmap4u.primitive.TextPrimitive;
import org.openmap4u.style.TextStyle;

public class TextBuilder<T extends TextBuilder<T>> extends AbstractBuilder<TextDrawable,TextPrimitive,TextStyle,T> {

	public TextBuilder() {
		super(new TextDrawable());
	}

 

}
