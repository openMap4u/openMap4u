package org.openmap4u.plugin.outputformat.svg;

import java.awt.Color;
import java.awt.geom.AffineTransform;

class SvgUtil {

    /**
     * Converts a awt affine transform in a svg transform matrix.
     * 
     * @param transform
     *            The affine transformation to be convertet.
     * @return The svg transform matrix.
     */
    public String getTransform(AffineTransform transform) {
        return new StringBuilder("matrix(").append(transform.getScaleX())
                .append(",").append(transform.getShearY()).append(",")
                .append(transform.getShearX()).append(",")
                .append(transform.getScaleY()).append(",")
                .append(transform.getTranslateX()).append(",")
                .append(transform.getTranslateY()).append(")").toString();
    }

    /**
     * Converts the color into a svg hex value.
     * 
     * @param color
     *            The color.
     * @return The svg color as hex value.
     */
    public String getColor(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(),
                color.getBlue());
    }

}
