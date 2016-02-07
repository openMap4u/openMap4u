package org.openmap4u.style;

import java.awt.Paint;

public interface ShapeStyleBuildable<T extends ShapeStyleBuildable<T>> extends LineStringStyleBuildable<T> {
	
	/**
	 * The default fill (is null ... no fill).
	 */
	Paint DEFAULT_FILL = null;


	/**
	 * Sets the shape fill color.
	 *
	 * @param fill The shape fill color.
	 * @return The method chaining pattern.
	 */
	T strokeFill(Paint fill);

}
