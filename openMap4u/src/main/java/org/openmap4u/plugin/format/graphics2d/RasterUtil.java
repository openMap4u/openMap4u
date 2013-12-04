/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.format.graphics2d;

import org.openmap4u.unit.Length;

/**
 * 
 * @author hadrbolec
 */
public class RasterUtil {

    double getMultuplicationFactor(int dpi, Length drawingUnits) {
        return drawingUnits.convert(1, Length.INCH) * dpi;
    }

}
