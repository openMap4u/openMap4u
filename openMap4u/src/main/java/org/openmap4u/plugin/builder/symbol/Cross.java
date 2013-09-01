package org.openmap4u.plugin.builder.symbol;

import java.awt.Shape;
import java.awt.geom.Path2D;

import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.defaults.Globals;

/**
 * Cross symbol.
 * 
 * @author Michael Hadrbolec
 */
public class Cross extends ShapeBuilder<Cross> {

    private static final Shape DEFAULT_CROSS_SYMBOL = getCross(
            Globals.DEFAULT_SYMBOL_SIZE, Globals.DEFAULT_SYMBOL_SIZE);

    /**
     *
     */
    public Cross() {
        setPrimitive(DEFAULT_CROSS_SYMBOL);
    }

    /**
     * Creates a quadratic cross with the given size.
     * 
     * @param size
     *            The size of the quadratic cross.
     * @return The cross itself (method chaining pattern).
     */
    public final Cross setSize(double size) {
        setPrimitive(getCross(size, size));
        return this;
    }

    /**
     * Creates a rectangle with the given width and height size.
     * 
     * @param width
     *            The width of the cross.
     * @param height
     *            The height of the cross.
     * @return The cross itself (method chaining pattern).
     */
    public final Cross setSize(double width, double height) {
        setPrimitive(getCross(width, height));
        return this;
    }

    static final Shape getCross(double width, double height) {
        Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        path.moveTo(-width / 2, 0);
        path.lineTo(width / 2, 0);
        path.moveTo(0, height / 2);
        path.lineTo(0, -height / 2);
        return path;
    }
}
