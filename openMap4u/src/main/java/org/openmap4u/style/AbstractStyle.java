package org.openmap4u.style;

import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.VerticalAlign;

/**
 * Implementation of the different styles in one class.
 * 
 * @author Michael Hadrbolec
 */
@SuppressWarnings("unchecked")
abstract class AbstractStyle<T extends Styleable<T>> implements Cloneable,
        Styleable<T> {

    /**
     * The generated serialVersionUID.
     */
    private static final long serialVersionUID = -7734050391559261210L;

    /**
     * The alpha value.
     */
    private double alpha = 1;

    /**
     * Stores the visibility.
     */
    private boolean visible = true;

    /**
     * Stores the horizontal alignment.
     */
    private HorizontalAlign mHorizontalAlign = null;

    /**
     * Stores the vertical alignment.
     */
    private VerticalAlign mVerticalAlign = null;

    /**
     * {@inheritDoc}
     */
    @Override
    public final double getAlpha() {
        return alpha;
    }

    /**
     * {@inheritDoc}
     */
    public final T setAlpha(double alpha) {
        this.alpha = alpha;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isVisible() {
        return visible;
    }

    /**
     * {@inheritDoc}
     */
    public final T setVisible(boolean visible) {
        this.visible = visible;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public final T setVerticalAlign(VerticalAlign verticalAlign) {
        this.mVerticalAlign = verticalAlign;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public final VerticalAlign getVerticalAlign() {
        return this.mVerticalAlign;
    }

    /**
     * {@inheritDoc}
     */
    public final T setHorizontalAlign(HorizontalAlign horizontalAlign) {
        this.mHorizontalAlign = horizontalAlign;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public final HorizontalAlign getHorizontalAlign() {
        return this.mHorizontalAlign;
    }

    /**
     * {@inheritDoc}
     */
    public T clone() throws CloneNotSupportedException {
              return (T) super.clone();
    }

 
}
