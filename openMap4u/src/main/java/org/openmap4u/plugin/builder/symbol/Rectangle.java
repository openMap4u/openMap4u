package org.openmap4u.plugin.builder.symbol;

import java.awt.geom.Rectangle2D;

import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.defaults.Globals;

/**
 * Rectangle symbol
 * 
 * @author Michael Hadrbolec
 */
public final class Rectangle extends ShapeBuilder<Rectangle> {

    private static final Rectangle2D.Double DEFAULT_RECTANGLE_SYMBOL = getRectangle(
            Globals.DEFAULT_SYMBOL_SIZE, Globals.DEFAULT_SYMBOL_SIZE);

    /**
     * Creates a new Rectangle symbol and initialzes it with the default
     * rectangle symbol.
     */
    public Rectangle() {
        this.setPrimitive(DEFAULT_RECTANGLE_SYMBOL);
    }

    /**
     * Creates a rectangle with the given width and height.
     * 
     * @param width
     *            The width of the rectangle.
     * @param height
     *            The height of the rectangle.
     * @return The rectangle itself (method chaining pattern).
     */
    public Rectangle setSize(double width, double height) {
        this.setPrimitive(getRectangle(width, height));
        return this;
    }

    /**
     * Creates a quadratic rectangle with the given size.
     * 
     * @param size
     *            The size of the quadratic rectangle.
     * @return The rectangle itself (method chaining pattern).
     */
    public Rectangle setSize(double size) {
        return setSize(size, size);
    }

    /**
     * Creates a rectangle with the given width and height.
     * 
     * @param width
     *            The width of the rectangle.
     * @param height
     *            The height of the rectangle.
     * @return The rectangle.
     */
    static Rectangle2D.Double getRectangle(double width, double height) {
        return new Rectangle2D.Double(-width / 2d, -height / 2d, width, height);
    }
}
