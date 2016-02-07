package org.openmap4u.style;

import java.awt.Color;
import java.awt.Paint;

public interface TextStyleBuildable<T extends TextStyleBuildable<T>> extends
		StyleBuildable<T> {

	/**
	 * The default font type.
	 */
	public static String DEFAULT_FONT_FAMILY = "";
	/**
	 * The default font size in stroke units.
	 */
	public static double DEFAULT_FONT_SIZE = 5;
 
  
	public static Paint DEFAULT_FONT_COLOR = Color.BLACK;
 
	/**
	 * Sets the font color.
	 * 
	 * @param fontColor
	 *            The font color.
	 * @return Method chaining pattern.
	 */
	T fontColor(Paint fontColor);

	/**
	 * Sets the font family.
	 * 
	 * @param fontFamily
	 *            The font family.
	 * @return Method chaining pattern.
	 */
	T fontFamily(String fontFamily);

	/**
	 * Sets the font size in drawing units.
	 * 
	 * @param fontSize
	 *            The font size in drawing units.
	 * @return Method chaining pattern.
	 */
	T fontSize(double fontSize);

	/**
	 * Sets the font style.
	 * 
	 * @param fontStyle
	 *            The font style.
	 * @return Method chaining pattern.
	 */
	T fontStyle(FontStyle fontStyle);

	/**
	 * Sets the font weight.
	 * 
	 * @param fontWeight
	 *            The font weight.
	 * @return Method chaining pattern.
	 */
	T fontWeight(FontWeight fontWeight);

}
