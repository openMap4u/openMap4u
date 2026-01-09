package org.openmap4u.builder;

import java.awt.Paint;
import java.awt.Shape;

import org.openmap4u.commons.FontStyle;
import org.openmap4u.commons.TextOnPath;
import org.openmap4u.commons.TextStyle;
import org.openmap4u.commons.TextStyleable;

/**
 * Builder for drawing text along a path.
 */
public class TextOnPathBuilder extends Builder<TextStyleable, TextOnPathBuilder, TextOnPath> {

    private String text;
    private Shape path;

    public TextOnPathBuilder() {
        this.getDrawable().setStyle(new TextStyle());
    }

    /**
     * Sets the font color.
     *
     * @param fontColor The font color.
     * @return Method chaining pattern.
     */
    public TextOnPathBuilder setFontColor(Paint fontColor) {
        this.getDrawable().getStyle().fontColor(fontColor);
        return self();
    }

    /**
     * Sets the font family.
     *
     * @param fontFamily The font size.
     * @return The builder itself (method chaining pattern).
     */
    public TextOnPathBuilder family(String fontFamily) {
        this.getDrawable().getStyle().fontFamily(fontFamily);
        return self();
    }

    /**
     * Sets the font size in drawing units.
     *
     * @param fontSize The font size.
     * @return The builder itself (method chaining pattern).
     */
    public TextOnPathBuilder size(double fontSize) {
        this.getDrawable().getStyle().fontSize(fontSize);
        return self();
    }

    /**
     * Sets the font style.
     *
     * @param fontStyle The font size.
     * @return The builder itself (method chaining pattern).
     */
    public TextOnPathBuilder style(FontStyle fontStyle) {
        this.getDrawable().getStyle().fontStyle(fontStyle);
        return self();
    }

    /**
     * Sets the text.
     *
     * @param text The text.
     * @return The builder itself.
     */
    public TextOnPathBuilder text(String text) {
        this.text = text;
        updatePrimitive();
        return self();
    }

    /**
     * Sets the path.
     *
     * @param path The path.
     * @return The builder itself.
     */
    public TextOnPathBuilder path(Shape path) {
        this.path = path;
        updatePrimitive();
        return self();
    }

    private void updatePrimitive() {
        if (text != null && path != null) {
            this.getDrawable().setPrimitive(new TextOnPath(text, path));
        }
    }

    @Override
    protected TextOnPathBuilder self() {
        return this;
    }
}
