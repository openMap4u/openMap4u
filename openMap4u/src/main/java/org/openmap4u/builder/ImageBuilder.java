package org.openmap4u.builder;

import java.nio.file.Path;

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

}
