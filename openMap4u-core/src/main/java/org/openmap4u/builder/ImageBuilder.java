package org.openmap4u.builder;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openmap4u.commons.ImageStyleable;

/**
 * All image builder plugins are derifed from this abstract base class. The
 * protected methods can be exposed by the respective implementation of this
 * abstract base template class.
 *
 * @author Michael Hadrbolec
 * @param <B> The type of the image builder.
 */
public abstract class ImageBuilder<B extends ImageBuilder<B>> extends
        Builder<ImageStyleable, B,Path>  {

	

	
	
    /**
     * Sets the image.
     *
     * @param imagePath The image path.
     * @return The Image itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B path(Path imagePath) {
        this.getDrawable().setPrimitive(imagePath);
        return (B) this;
    }

    protected B path(String first, String... more) {
        return path(FileSystems.getDefault().getPath(first, more));
    }

    /**
     * Sets the image.
     *
     * @param imageURI The image URI.
     * @return The Image itself (method chaining pattern).
     */
    protected B path(URI imageURI) {
        return this.path(Paths.get(imageURI));
    }
    
    
  
    
    

}
