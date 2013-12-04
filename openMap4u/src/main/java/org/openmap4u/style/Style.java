package org.openmap4u.style;

/**
 * Implementation of the different styles in one class.
 *
 * @author Michael Hadrbolec
 * @param <T>
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
    @Override
    public final T setVisible(boolean visible) {
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
     * 
     * @return 
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("visible:").append(isVisible()).append(",alpha:").append(getAlpha()) ;
        return sb.toString();
    }

}
