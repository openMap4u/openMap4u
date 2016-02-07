package org.openmap4u.builder;

import org.openmap4u.draw.ImageDrawable;
import org.openmap4u.primitive.ImagePrimitive;
import org.openmap4u.style.ImageStyle;
 

public class ImageBuilder<B extends ImageBuilder<B>>  extends AbstractBuilder<ImageDrawable,ImagePrimitive,ImageStyle,B>  {

	public ImageBuilder() {
		super(new ImageDrawable());
	}

}
