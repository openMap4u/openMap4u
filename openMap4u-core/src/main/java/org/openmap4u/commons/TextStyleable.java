/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import java.awt.Paint;

/**
 *
 * @author Michael Hadrbolec
 */
public interface TextStyleable extends Styleable<TextStyleable> {

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
     * Gets the font style.
     * @return The font style.
     */
    FontStyle getFontStyle();

    /**
     * Gets the font weight.
     * @return The font weight.
     */
    FontWeight getFontWeight();

    /**
     * Sets the font color.
     * @param fontColor The font color.
     * @return Method chaining pattern.
     */
    TextStyleable fontColor(Paint fontColor);

    /**
     * Sets the font family.
     * @param fontFamily The font family.
     * @return Method chaining pattern.
     */
    TextStyleable fontFamily(String fontFamily);

    /**
     * Sets the font size in drawing units.
     * @param fontSize The font size in drawing units.
     * @return Method chaining pattern.
     */
    TextStyleable fontSize(double fontSize);

    /**
     * Sets the font style.
     * @param fontStyle The font style.
     * @return Method chaining pattern.
     */
    TextStyleable fontStyle(FontStyle fontStyle);

    /**
     * Sets the font weight.
     * @param fontWeight The font weight.
     * @return Method chaining pattern.
     */
    TextStyleable fontWeight(FontWeight fontWeight);

    /**
     * Clones the TextStyleable.
     * @return The cloned TextStyleable.
     * @throws CloneNotSupportedException Is thrown in the case cloning is not supported.
     */
    TextStyleable clone() throws CloneNotSupportedException;

}
