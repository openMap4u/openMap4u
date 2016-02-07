package org.openmap4u.primitive;

import java.net.URI;
import java.nio.file.Path;

public interface ImageBuildable<T extends ImageBuildable<T>> extends
		PrimitiveBuildable<T> {

	/**
	 * Sets the image.
	 *
	 * @param imagePath
	 *            The image path.
	 * @return The Image itself (method chaining pattern).
	 */
 	T path(Path imagePath);

	T path(String first, String... more);

	/**
	 * Sets the image.
	 *
	 * @param imageURI
	 *            The image URI.
	 * @return The Image itself (method chaining pattern).
	 */
	T path(URI imageURI);
}
