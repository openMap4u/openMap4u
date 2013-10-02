package org.openmap4u.builder;

import java.net.URI;
import java.nio.file.Path;

/**
 * 
 * @author Michael Hadrbolec
 */
public final class Image extends ImageBuilder<Image> {

	/**
	 * Sets the image.
	 * 
	 * @param imagePath
	 *            The image path.
	 * @return The Image itself (method chaining pattern).
	 */
	public Image setImage(Path imagePath) {
		return super.setImage(imagePath);
	}

	/**
	 * Sets the image.
	 * 
	 * @param imageURI
	 *            The image URI.
	 * @return The Image itself (method chaining pattern).
	 */
	public Image setImage(URI imageURI) {
		return super.setImage(imageURI);
	}

}
