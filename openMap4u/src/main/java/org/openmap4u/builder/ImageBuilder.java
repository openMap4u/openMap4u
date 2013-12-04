package org.openmap4u.builder;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openmap4u.style.ImageStyle;

/**
 * All image builder plugins are derifed from this abstract base class.
 *
 * @author Michael Hadrbolec
 * @param <B> The type of the image builder.
 */
public abstract class ImageBuilder<B extends ImageBuilder<B>> extends
        Buildable<ImageStyle, B> {

    private Path mPath = null;

    public ImageBuilder() {
    }

    public Path getPath() {
        return this.mPath;
    }

    

    /**
     * Sets the image.
     *
     * @param imagePath The image path.
     * @return The Image itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B path(Path imagePath) {
        this.mPath =imagePath;
        return (B) this;
    }

    /**
     * Sets the image.
     *
     * @param imageURI The image URI.
     * @return The Image itself (method chaining pattern).
     */
    protected B uri(URI imageURI) {
        return this.path(Paths.get(imageURI));
    }

}
