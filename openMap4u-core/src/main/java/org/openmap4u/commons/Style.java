package org.openmap4u.commons;

/**
 * Implementation of the different styles in one class.
 *
 * @author Michael Hadrbolec
 * @param <T> The style type.
 */
abstract class Style<T extends Styleable<T>>  implements Styleable<T>, Cloneable {

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
     * {@inheritDoc}
     */
    @Override
    public final double getAlpha() {
        return alpha;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final T alpha(double alpha) {
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
    @SuppressWarnings("unchecked")
	@Override
    public final T visible(boolean visible) {
        this.visible = visible;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T clone() throws CloneNotSupportedException {
        return (T) super.clone();
    }

    /**
     * For internal use only.
     * @return A string representation of the style.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("visible:").append(isVisible()).append(",alpha:").append(getAlpha()) ;
        return sb.toString();
    }

}
