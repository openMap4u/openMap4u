package org.openmap4u.plugin.builder.core;

import java.net.URI;
import java.nio.file.Path;

import org.openmap4u.builder.ImageBuilder;
import org.openmap4u.primitive.ImageBuildable;

public class Image extends ImageBuilder<Image> implements ImageBuildable<Image>  {

 
	@Override
	public Image path(Path imagePath) {
		this.getDrawable().getPrimitive().path(imagePath);
		return this;
	}

	@Override
	public Image path(String first, String... more) {
		this.getDrawable().getPrimitive().path(first,more);
		return this;
	}

	@Override
	public Image path(URI imageURI) {
		this.getDrawable().getPrimitive().path(imageURI);
		return this;
	}

}
