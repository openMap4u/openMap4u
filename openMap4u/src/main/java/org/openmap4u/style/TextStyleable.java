/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.style;

import java.awt.Paint;

/**
 *
 * @author zwotti
 */
public interface TextStyleable extends Styleable<TextStyleable> {

    Paint getFontColor();

    String getFontFamily();

    double getFontSize();

    FontStyle getFontStyle();

    FontWeight getFontWeight();

    TextStyleable setFontColor(Paint fontColor);

    TextStyleable setFontFamily(String fontFamily);

    TextStyleable setFontSize(double fontSize);

    TextStyleable setFontStyle(FontStyle fontStyle);

    TextStyleable setFontWeight(FontWeight fontWeight);

    TextStyleable clone() throws CloneNotSupportedException;

}
