package org.openmap4u.builder;

import org.openmap4u.commons.FontStyle;

/**
 * 
 * @author Michel Hadrbolec
 */
public final class Text extends TextBuilder<Text> {

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            The text.
	 * @return The Text itself (method chaining pattern).
	 */
	public Text setText(String text) {
		return super.setText(text);
	}

	/**
	 * Formats the arguments with the given format template.
	 * 
	 * @param format
	 *            The format template.
	 * @param args
	 *            The arguments.
	 * @return The Text itself (method chaining pattern).
	 */
	public Text setText(String format, Object... args) {
		return super.setText(String.format(format, args));
	}

	/**
	 * Sets the font size in drawing units.
	 * 
	 * @param fontSize
	 *            The font size.
	 * @return The Text itself (method chaining pattern).
	 */
	public Text setFontSize(double fontSize) {
		return super.setFontSize(fontSize);
	}

	/**
	 * Sets the font style.
	 * 
	 * @param fontStyle
	 *            The font size.
	 * @return The Text itself (method chaining pattern).
	 */
	public Text setFontStyle(FontStyle fontStyle) {
		return super.setFontStyle(fontStyle);
	}

	/**
	 * Sets the font family.
	 * 
	 * @param fontFamily
	 *            The font size.
	 * @return The Text itself (method chaining pattern).
	 */
	public Text setFontFamily(String fontFamily) {
		return super.setFontFamily(fontFamily);
	}
}
