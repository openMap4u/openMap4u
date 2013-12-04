package org.openmap4u.style;

/**
 * The ImageStyleable implementation.
 * 
 * @author Michael Hadrbolec
 * 
 */
public final class ImageStyle extends Style<ImageStyleable> implements ImageStyleable  {

    /**
     * {@inheritDoc}
     * @throws java.lang.CloneNotSupportedException
     */
    public ImageStyle clone()  throws CloneNotSupportedException {
        return (ImageStyle) super.clone();
    }

}
