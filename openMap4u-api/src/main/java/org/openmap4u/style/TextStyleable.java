package org.openmap4u.style;

import java.awt.Paint;

 
public interface TextStyleable extends Styleable {

	/**
	 * Gets the font color.
	 * @return The fomnt color.
	 */
	Paint getFontColor();

	/**
	 * Gets the font family.
	 * @return The font family.
	 */
	String getFontFamily();

	/**
	 * Gets the font size in drawing units.
	 * @return The font size in drawing units.
	 */
	double getFontSize();

	/**
	 * Gets the font weight.
	 * @return The font weight.
	 */
	FontWeight getFontWeight();

	/**
	 * Gets the font style.
	 * @return The font style.
	 */
	FontStyle getFontStyle();

}
