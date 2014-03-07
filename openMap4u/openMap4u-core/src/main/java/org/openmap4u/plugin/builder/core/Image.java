package org.openmap4u.plugin.builder.core;

import java.net.URI;
import java.nio.file.Path;
import org.openmap4u.builder.ImageBuilder;

/**
 *
 * @author Michael Hadrbolec
 */
public final class Image extends ImageBuilder<Image> {

    /**
     * Sets the image.
     *
     * @param imagePath The image path.
     * @return The Image itself (method chaining pattern).
     */
    @Override
    public Image path(Path imagePath) {
        return super.path(imagePath);
    }

    /**
     * Sets the image.
     *
     * @param imageURI The image URI.
     * @return The Image itself (method chaining pattern).
     */
    @Override
    public Image uri(URI imageURI) {
        return super.uri(imageURI);
    }

}
