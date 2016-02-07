package org.openmap4u.primitive;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;


public final class ImagePrimitive extends Primitive<ImagePrimitive> implements ImageBuildable<ImagePrimitive>,Imageable {

	
	private Path path;
	
	@Override
	public Path getPath() {
		return this.path;
	}

	@Override
	public ImagePrimitive path(Path imagePath) {
		this.path=imagePath; 
		return this;
	}

	@Override
	public ImagePrimitive path(String first, String... more) {
		return this.path(FileSystems.getDefault().getPath(first, more));
	}

	@Override
	public ImagePrimitive path(URI imageURI) {
		return this.path(Paths.get(imageURI));
	}

}
