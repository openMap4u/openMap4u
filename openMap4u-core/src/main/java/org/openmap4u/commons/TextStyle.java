package org.openmap4u.commons;

import java.awt.Color;
import java.awt.Paint;


/**
 * The TextStyleable implementation.
 * 
 * @author Michael Hadrbolec
 * 
 */
public final class TextStyle extends Style<TextStyleable> implements TextStyleable  {

    /**
     * The genertated serialVersionUID.
     */
    private static final long serialVersionUID = -2447493082639910133L;

    /**
     * Stores the font family.
     */
    private String mFontFamily;

    /**
     * Stores the font size.
     */
    private double mFontSize = Globals.DEFAULT_FONT_SIZE;

    /**
     * Stores the font style.
     */
    private FontStyle mFontStyle;

    /**
     * Stores the font weight.
     */
    private FontWeight mFontWeight = null;

    /**
     * Stores the font color.
     */
    private Paint mFontColor = Color.BLACK;

    /**
     * {@inheritDoc}
     */
    public Paint getFontColor() {
        return this.mFontColor;
    }

    /**
     * {@inheritDoc}
     */
    public String getFontFamily() {
        return mFontFamily;
    }

    /**
     * {@inheritDoc}
     */
     public double getFontSize() {
        return mFontSize;
    }

    /**
     * {@inheritDoc}
     */
    public FontStyle getFontStyle() {
        return mFontStyle;
    }

    /**
     * {@inheritDoc}
     */
    public FontWeight getFontWeight() {
        return this.mFontWeight;
    }

    /**
     * {@inheritDoc}
     */
    public TextStyle fontColor(Paint fontColor) {
        this.mFontColor = fontColor;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public TextStyle fontFamily(String fontFamily) {
        this.mFontFamily = fontFamily;
        return this;
    }

    /**
     * {@inheritDoc}
      */
    public TextStyle fontSize(double fontSize) {
        this.mFontSize = fontSize;
        return this;
    }

    /**
     * {@inheritDoc}
     */
     public TextStyle fontStyle(FontStyle fontStyle) {
        this.mFontStyle = fontStyle;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public TextStyle fontWeight(FontWeight fontWeight) {
        this.mFontWeight = fontWeight;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public TextStyle clone() throws CloneNotSupportedException {
        return (TextStyle) super.clone();
    }
}
