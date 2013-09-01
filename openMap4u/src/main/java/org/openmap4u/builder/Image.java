package org.openmap4u.builder;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        this.setPrimitive(imagePath);
        return this;
    }

    /**
     * Sets the image.
     * 
     * @param imageURI
     *            The image URI.
     * @return The Image itself (method chaining pattern).
     */
    public Image setImage(URI imageURI) {
        return this.setImage(Paths.get(imageURI));
    }

}
