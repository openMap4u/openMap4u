package org.openmap4u.builder;

import java.awt.Paint;

import org.openmap4u.commons.FontStyle;
import org.openmap4u.primitive.TextPrimitive;
import org.openmap4u.style.TextStyleable;

/**
 * All text builder plugins are derifed from this abstract base class.
 * 
 * @author Michael Hadrbolec
 * @param <B>
 */
public abstract class TextBuilder<B extends TextBuilder<B>> extends
        AbstractBuilderPlugin<String, TextStyleable, B> implements
        TextPrimitive {

    /**
     * Sets the font color.
     * @param fontColor The font color.
     * @return Method chaining pattern.
     */
    @SuppressWarnings("unchecked")
	protected B setFontColor(Paint fontColor) {
        this.getStyle().setFontColor(fontColor);
        return (B) this;
    }

	/**
	 * Sets the font family.
	 * 
	 * @param fontFamily
	 *            The font size.
	 * @return The Text itself (method chaining pattern).
	 */
	@SuppressWarnings("unchecked")
	protected B setFontFamily(String fontFamily) {
	    this.getStyle().setFontFamily(fontFamily);
	    return (B)this;
	}

	/**
	 * Sets the font size in drawing units.
	 * 
	 * @param fontSize
	 *            The font size.
	 * @return The Text itself (method chaining pattern).
	 */
	@SuppressWarnings("unchecked")
	protected B setFontSize(double fontSize) {
	    this.getStyle().setFontSize(fontSize);
	    return (B)this;
	}

	/**
	 * Sets the font style.
	 * 
	 * @param fontStyle
	 *            The font size.
	 * @return The Text itself (method chaining pattern).
	 */
	@SuppressWarnings("unchecked")
	protected B setFontStyle(FontStyle fontStyle) {
	    this.getStyle().setFontStyle(fontStyle);
	    return (B)this;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            The text.
	 * @return The Text itself (method chaining pattern).
	 */
	@SuppressWarnings("unchecked")
	protected B setText(String text) {
	    this.setPrimitive(text);
	    return (B)this;
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
	protected B setText(String format, Object... args) {
	    return setText(String.format(format, args));
	}
}
