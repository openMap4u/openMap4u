package org.openmap4u.style;

/**
 * The ImageStyleable implementation.
 * 
 * @author Michael Hadrbolec
 * 
 */
public final class ImageStyle extends AbstractStyle<ImageStyleable> implements
        Cloneable, ImageStyleable {

    /**
     * {@inheritDoc}
     */
    public ImageStyleable clone()  throws CloneNotSupportedException {
        return (ImageStyleable) super.clone();
    }

}
