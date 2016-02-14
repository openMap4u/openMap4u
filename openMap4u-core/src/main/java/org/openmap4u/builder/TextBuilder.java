package org.openmap4u.builder;

import java.awt.Paint;

import org.openmap4u.commons.FontStyle;
import org.openmap4u.commons.TextStyleable;

/**
 * All text builder plugins are derifed from this abstract base class. The
 * protected methods can be exposed by the respective implementation of this
 * abstract base template class.
 *
 * @author Michael Hadrbolec
 * @param <B> The type of the text builder.
 */
public abstract class TextBuilder<B extends TextBuilder<B>> extends
        Builder<TextStyleable, B,String>  {
     

    
   
    
    
    /**
     * Sets the font color.
     *
     * @param fontColor The font color.
     * @return Method chaining pattern.
     */
    @SuppressWarnings("unchecked")
    protected B setFontColor(Paint fontColor) {
        this.getDrawable().getStyle().fontColor(fontColor);
        return (B) this;
    }

    /**
     * Sets the font family.
     *
     * @param fontFamily The font size.
     * @return The Text itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B family(String fontFamily) {
        this.getDrawable().getStyle().fontFamily(fontFamily);
        return (B) this;
    }

    /**
     * Sets the font size in drawing units.
     *
     * @param fontSize The font size.
     * @return The Text itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B size(double fontSize) {
        this.getDrawable().getStyle().fontSize(fontSize);
        return (B) this;
    }

    /**
     * Sets the font style.
     *
     * @param fontStyle The font size.
     * @return The Text itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B style(FontStyle fontStyle) {
        this.getDrawable().getStyle().fontStyle(fontStyle);
        return (B) this;
    }

    /**
     * Sets the text.
     *
     * @param text The text.
     * @return The Text itself (method chaining pattern).
     */
    @SuppressWarnings("unchecked")
    protected B text(String text) {
        this.getDrawable().setPrimitive(text);
        return (B) this;
    }

    /**
     * Formats the arguments with the given format template.
     *
     * @param format The format template.
     * @param args The arguments.
     * @return The Text itself (method chaining pattern).
     */
    protected B text(String format, Object... args) {
        return text(String.format(format, args));
    }
    
   
}
