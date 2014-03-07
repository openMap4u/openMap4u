package org.openmap4u.commons;

/**
 * The ImageStyleable implementation.
 * 
 * @author Michael Hadrbolec
 * 
 */
public final class ImageStyle extends Style<ImageStyleable> implements ImageStyleable  {

    /**
     * {@inheritDoc}
     * @throws java.lang.CloneNotSupportedException Is thrown in the case cloning is not supported.
     */
    public ImageStyle clone()  throws CloneNotSupportedException {
        return (ImageStyle) super.clone();
    }

}
