package org.openmap4u.style;



public interface StyleBuildable<T extends StyleBuildable<T >>   {
	
	/**
	 * The default alpha (= transparency) value.
	 */
	double DEFAULT_ALPHA = 1;
	
	/**
	 * The default visibility of a primitive is <code>true</code>.
	 */
	boolean DEFAULT_VISIBILITY = true;



	/**
	 * Sets the alpha value.
	 * @param alpha The alpha value.
	 * @return Method chaining pattern.
	 */
	T alpha(double alpha);

	/**
	 * Sets the visibility.
	 * @param visible The visibility (true ... visible, false ... not visible).
	 * @return Method chaining pattern.
	 */
	T visible(boolean visible);

	 
}
