package org.openmap4u.plugin.builder.symbol;

import java.awt.geom.Ellipse2D;

import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.defaults.Globals;

/**
 * Circle symbol.
 * 
 * @author Michael Hadrbolec
 */
public class Circle extends ShapeBuilder<Circle> {

    private static final Ellipse2D.Double DEFAULT_ELLIPSE_SYMBOL = getEllipse(
            Globals.DEFAULT_SYMBOL_SIZE, Globals.DEFAULT_SYMBOL_SIZE);

    /**
     *
     */
    public Circle() {
        this.setPrimitive(DEFAULT_ELLIPSE_SYMBOL);
    }

    /**
     * Sets the diameter of the circle.
     * 
     * @param diameter
     *            The diameter of the circle symbol.
     * @return The Buildable itself (method chaining pattern).
     */
    public Circle setDiameter(double diameter) {
        this.setPrimitive(getEllipse(diameter, diameter));
        return this;
    }

    /**
     * Sets the radius of the circle symbol.
     * 
     * @param radius
     *            The radius of the circle symbol.
     * @return The Buildable itself (method chaining pattern).
     */
    public Circle setRadius(double radius) {
        return this.setDiameter(radius * 2);
    }

    /**
     * Internal Helper to create a ellipse.
     * @param width The width.
     * @param height The height.
     * @return The ellipse.
     */
    static Ellipse2D.Double getEllipse(double width, double height) {
        return new Ellipse2D.Double(-width / 2, -height / 2, width, height);
    }
}
