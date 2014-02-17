package org.openmap4u.plugin.builder.core;

import java.awt.Paint;
import org.openmap4u.builder.TextBuilder;
import org.openmap4u.commons.FontStyle;

/**
 *
 * @author Michel Hadrbolec
 */
public final class Text extends TextBuilder<Text> {

    /**
     * Sets the text.
     *
     * @param value2display The text value to display.
     * @return The text itself (fluent interface pattern).
      */
    @Override
    public Text text(String value2display) {
        return super.text(value2display);
    }

    /**
     * Sets the numeric value to display.
     *
     * @param value2display The numeric value to display.
     * @return The text itself (fluent interface pattern).
     */
    public Text text(Number value2display) {
        return text(value2display.toString());
    }

    /**
     * Sets the boolean value to display.
     *
     * @param value2display The boolean value to display.
     * @return The text itself (fluent interface pattern).
     */
    public Text text(Boolean value2display) {
        return text(value2display.toString());
    }

    /**
     * Formats the arguments with the given format template.
     *
     * @param format The format template.
     * @param args The arguments.
     * @return The text itself (fluent interface pattern).
     */
    @Override
    public Text text(String format, Object... args) {
        return super.text(format, args);
    }

    /**
     * Sets the text color.
     *
     * @param color The text color.
     * @return The text itself (fluent interface pattern).
     */
    public Text color(Paint color) {
        return super.setFontColor(color);
    }

    /**
     * Sets the font size in drawing units.
     *
     * @param fontSize The font size.
     * @return The text itself (fluent interface pattern).
     */
    @Override
    public Text size(double fontSize) {
        return super.size(fontSize);
    }

    /**
     * Sets the font style.
     *
     * @param fontStyle The font size.
     * @return The text itself (fluent interface pattern).
     */
    @Override
    public Text style(FontStyle fontStyle) {
        return super.style(fontStyle);
    }

    /**
     * Sets the font family.
     *
     * @param fontFamily The font size.
     * @return The text itself (fluent interface pattern).
     */
    @Override
    public Text family(String fontFamily) {
        return super.family(fontFamily);
    }
}
