package org.openmap4u.builder;

import java.awt.Paint;
import java.awt.Shape;

import org.openmap4u.primitive.ShapePrimitive;
import org.openmap4u.style.ShapeStyleable;

/**
 * All shape builder plugins are derifed from this abstract base class.
 * 
 * @author Michael Hadrbolec
 * @param <B> The type of the shape builder.
 */
public abstract class ShapeBuilder<B extends ShapeBuilder<B>> extends
        AbstractBuilderPlugin<Shape, ShapeStyleable, B> implements
        ShapePrimitive {

    /**
     * Sets the stroke size in stroke units.
     * 
     * @param strokeSize
     *            The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    public B setStrokeSize(double strokeSize) {
        this.getStyle().setStrokeSize(strokeSize);
          return (B) this;
    }

    /**
     * Sets the stroke color.
     * 
     * @param strokeColor
     *            The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    public B setStrokeColor(Paint strokeColor) {
        this.getStyle().setStrokeColor(strokeColor);
        return (B) this;
    }

    /**
     * Sets the sroke fill.
     * 
     * @param strokeFill
     *            The stroke fill.
     * @return The builder itself (method chaining pattern).
     */
    public B setStrokeFill(Paint strokeFill) {
        this.getStyle().setStrokeFill(strokeFill);
        return (B) this;
    }

}
