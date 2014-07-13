package org.openmap4u.commons;

import java.awt.Color;
import java.awt.Paint;


/**
 * The ShapeStyleable implementation.
 *
 * @author Michael Hadrbolec
 *
 */
public class ShapeStyle extends Style<ShapeStyleable> implements ShapeStyleable  {

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
     *
      */
    @Override
     public ShapeStyleable strokeColor(Paint color) {
        this.mStrokeColor = color;
        return this;
    }

    /**
     * {@inheritDoc}
     *
      */
    @Override
    public ShapeStyleable strokeFill(Paint fill) {
        this.fill = fill;
        return this;
    }

    /**
     * Sets the stroke size in drawing units.
     *
     * @param strokeSize The stroke size in drawing units.
     * @return The method chaining pattern.
     */
    @Override
    public ShapeStyle strokeSize(double strokeSize) {
        this.strokeSize = strokeSize;
        return this;
    }

    /**
     * {@inheritDoc}
     *@throws CloneNotSupportedException Is thrown in the case cloning is not supported.
      */
    @Override
    public ShapeStyleable clone() throws CloneNotSupportedException {
          return  super.clone(); 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(",strokeColor:").append(getStrokeColor()).append(",fillColor:").append(getStrokeFill()).append(",strokeSize:").append(getStrokeSize());
        return sb.toString();
    }

}
