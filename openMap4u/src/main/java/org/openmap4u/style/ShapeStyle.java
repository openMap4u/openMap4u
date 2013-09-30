package org.openmap4u.style;

import java.awt.Color;
import java.awt.Paint;

import org.openmap4u.Globals;

/**
 * The ShapeStyleable implementation.
 * 
 * @author Michael Hadrbolec
 * 
 */
public class ShapeStyle extends AbstractStyle<ShapeStyleable> implements
        ShapeStyleable, Cloneable {

    /**
     * The generated serialVersionUID.
     */
    private static final long serialVersionUID = -5551084353680995188L;
    /**
     * Stores the fill.
     */
    private Paint fill = null;

    /**
     * Stores the stroke size.
     */
    private double strokeSize = Globals.DEFAULT_STROKE_SIZE;

    /**
     * Stores the stroke color.
     */
    private Paint mStrokeColor = Color.BLACK;

    /**
     * {@inheritDoc}
     */
    @Override
    public Paint getStrokeColor() {
        return mStrokeColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Paint getStrokeFill() {
        return fill;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getStrokeSize() {
        return strokeSize;
    }

    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public ShapeStyle setStrokeColor(Paint color) {
        this.mStrokeColor = color;
        return this;
    }

    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public ShapeStyle setStrokeFill(Paint fill) {
        this.fill = fill;
        return this;
    }

    /**
     * {@inheritDoc}
     * @param strokeSize
     * @return 
     */
    @Override
    public ShapeStyle setStrokeSize(double strokeSize) {
        this.strokeSize = strokeSize;
        return this;
    }

    /**
     * {@inheritDoc}
     * @throws java.lang.CloneNotSupportedException
     */
    public ShapeStyleable clone()  throws CloneNotSupportedException {
        return (ShapeStyleable) super.clone();
    }

}
