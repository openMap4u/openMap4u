package org.openmap4u.style;

import java.awt.Color;
import java.awt.Paint;

import org.openmap4u.Globals;
import org.openmap4u.commons.FontStyle;
import org.openmap4u.commons.FontWeight;

/**
 * The TextStyleable implementation.
 * 
 * @author Michael Hadrbolec
 * 
 */
public final class TextStyle extends AbstractStyle<TextStyleable> implements
        TextStyleable, Cloneable {

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
    @Override
    public Paint getFontColor() {
        return this.mFontColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFontFamily() {
        return mFontFamily;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getFontSize() {
        return mFontSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FontStyle getFontStyle() {
        return mFontStyle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FontWeight getFontWeight() {
        return this.mFontWeight;
    }

    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public TextStyleable setFontColor(Paint fontColor) {
        this.mFontColor = fontColor;
        return this;
    }

    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public TextStyleable setFontFamily(String fontFamily) {
        this.mFontFamily = fontFamily;
        return this;
    }

    /**
     * {@inheritDoc}
     * @param fontSize
     * @return 
     */
    @Override
    public TextStyleable setFontSize(double fontSize) {
        this.mFontSize = fontSize;
        return this;
    }

    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public TextStyleable setFontStyle(FontStyle fontStyle) {
        this.mFontStyle = fontStyle;
        return this;
    }

    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public TextStyleable setFontWeight(FontWeight fontWeight) {
        this.mFontWeight = fontWeight;
        return this;
    }

    /**
     * {@inheritDoc}
     * @throws java.lang.CloneNotSupportedException
     */
    public TextStyleable clone() throws CloneNotSupportedException {
        return (TextStyleable) super.clone();
    }
}
