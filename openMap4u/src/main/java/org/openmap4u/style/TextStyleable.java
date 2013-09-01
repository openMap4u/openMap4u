/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.style;

import java.awt.Paint;

import org.openmap4u.commons.FontStyle;
import org.openmap4u.commons.FontWeight;

/**
 * 
 * @author hadrbolec
 */
public interface TextStyleable extends Cloneable, Styleable<TextStyleable> {

    /**
     * @param size
     *            the size to set
     */
    TextStyleable setFontSize(double size);

    /**
     * @return the size
     */
    double getFontSize();

    /**
     * @return the fontFamily
     */
    String getFontFamily();

    /**
     * @return the fontStyle
     */
    FontStyle getFontStyle();

    /**
     * @param fontFamily
     *            the fontFamily to set
     */
    TextStyleable setFontFamily(String fontFamily);

    /**
     * @param fontStyle
     *            the fontStyle to set
     */
    TextStyleable setFontStyle(FontStyle fontStyle);

    /**
     * Sets the font color.
     * 
     * @param fontColor
     *            The font color.
     */
    TextStyleable setFontColor(Paint fontColor);

    /**
     * Gets the font color.
     * 
     * @return The font color.
     */
    Paint getFontColor();

    /**
     * Sets the font weight.
     * 
     * @param fontWeight
     *            The font weight.
     */
    TextStyleable setFontWeight(FontWeight fontWeight);

    /**
     * Gets the font weight.
     * 
     * @return The font weight.
     */
    FontWeight getFontWeight();

}
