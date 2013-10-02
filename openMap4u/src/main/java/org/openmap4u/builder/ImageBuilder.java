package org.openmap4u.builder;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openmap4u.primitive.ImagePrimitive;
import org.openmap4u.style.ImageStyleable;

/**
 * All image builder plugins are derifed from this abstract base class.
 * 
 * @author Michael Hadrbolec
 * @param <B>
 */
public abstract class ImageBuilder<B extends ImageBuilder<B>> extends
        AbstractBuilderPlugin<Path, ImageStyleable, B> implements
        ImagePrimitive {
	
	  /**
     * Sets the image.
     * 
     * @param imagePath
     *            The image path.
     * @return The Image itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
	protected B setImage(Path imagePath) {
        this.setPrimitive(imagePath);
        return (B)this;
    }

    /**
     * Sets the image.
     * 
     * @param imageURI
     *            The image URI.
     * @return The Image itself (method chaining pattern).
     */
    protected B setImage(URI imageURI) {
        return (B)this.setImage(Paths.get(imageURI));
    }

}
