package org.openmap4u.style;

public interface Styleable extends Cloneable {

	/**
	 * Gets the alpha value.
	 * @return The alpha value.
	 */
	double getAlpha();

	/**
	 * Gets the visibility.
	 * @return The visibility (true ... visible, false ... not visible).
	 */
	boolean isVisible();

}
