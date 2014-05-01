/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import org.openmap4u.format.Outputable;

/**
 * Sets the area of interest on the drawing canvas.
 *
 * @author Michael Hadrbolec
 */
interface Overrideable {

    /**
     * Sets the center of the drawing canvas.
     *
     * @param x The x coordinate of the center.
     * @param y The y coordinate of the center.
     * @return Allows to setup the area of interest of the drawing canvas.
     */
    OverrideDrawOrWriteable center(double x, double y);

    /**
     * Sets the scale of the area of interest of the drawing canvas.
     *
     * @param scaleFactor The scale factor of the area of interest.
     * @return Allows to setup the area of interest of the drawing canvas.
     */
    OverrideDrawOrWriteable scale(double scaleFactor);

    /**
     * Sets the roation of the area of interest of the drawing canvas.
     *
     * @param rotation The rotation angle.
     * @return Allows to setup the area of interest of the drawing canvas.
     */
    OverrideDrawOrWriteable rotate(double rotation);

    <T extends Outputable> OverrideDrawOrWriteable outputFormat(Class<T> outputFormat);

  
}
