package org.openmap4u.plugin.builder.symbol;

import java.awt.Paint;
import java.awt.geom.Ellipse2D;

import org.openmap4u.Globals;
import org.openmap4u.builder.ShapeBuilder;

/**
 * Circle symbol.
 *
 * @author Michael Hadrbolec
 */
public class Circle extends ShapeBuilder<Circle> {

    private static final Ellipse2D.Double DEFAULT_ELLIPSE_SYMBOL = getEllipse(
            Globals.DEFAULT_SYMBOL_SIZE, Globals.DEFAULT_SYMBOL_SIZE);

    /**
     * Creates a new circle symbol.
     */
    public Circle() {
        this.setPrimitive(DEFAULT_ELLIPSE_SYMBOL);
    }

    /**
     * Sets the diameter of the circle.
     *
     * @param diameter The diameter of the circle symbol.
     * @return The Buildable itself (method chaining pattern).
     */
    public Circle diameter(double diameter) {
        this.setPrimitive(getEllipse(diameter, diameter));
        return this;
    }

    /**
     * Sets the radius of the circle symbol.
     *
     * @param radius The radius of the circle symbol.
     * @return The Buildable itself (method chaining pattern).
     */
    public Circle radius(double radius) {
        return this.diameter(radius * 2);
    }

    @Override
    public Circle strokeColor(Paint strokeColor) {
        return super.strokeColor(strokeColor);
    }

    @Override
    public Circle strokeFill(Paint strokeFill) {
        return super.strokeFill(strokeFill);
    }

    @Override
    public Circle strokeSize(double strokeSize) {
        return super.strokeSize(strokeSize);
    }

    /**
     * Internal Helper to create a ellipse.
     *
     * @param width The width.
     * @param height The height.
     * @return The ellipse.
     */
    static Ellipse2D.Double getEllipse(double width, double height) {
        return new Ellipse2D.Double(-width / 2, -height / 2, width, height);
    }
}
