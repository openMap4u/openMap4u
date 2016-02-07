package org.openmap4u.style;

import java.awt.Paint;

public interface LineStringStyleBuildable<T extends LineStringStyleBuildable<T>> extends StyleBuildable<T> {

	/**
	 * Sets the shape stroke color.
	 *
	 * @param color The shape stroke color.
	 * @return The method chaining pattern.
	 */
	T strokeColor(Paint color);

	/**
	 * Sets the stroke size in drawing units.
	 *
	 * @param strokeSize The stroke size in drawing units.
	 * @return The method chaining pattern.
	 */
	T strokeSize(double strokeSize);

}
