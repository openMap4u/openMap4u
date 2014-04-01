package org.openmap4u;

/*
 * #%L
 * m4u the ultimative visulisation library
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2012 VillaBunterHund
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
import java.awt.Shape;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openmap4u.builder.Buildable;
import org.openmap4u.commons.Angle;
import org.openmap4u.commons.AreaOfInterestTransformable;
import org.openmap4u.commons.Globals;
import org.openmap4u.commons.ImageDrawable;
import org.openmap4u.commons.Length;
import org.openmap4u.commons.Plugable;
import org.openmap4u.commons.Point;
import org.openmap4u.commons.ShapeDrawable;
import org.openmap4u.commons.TextDrawable;
import org.openmap4u.commons.TransformUtil;
import org.openmap4u.commons.Util;
import org.openmap4u.format.Outputable;
import org.openmap4u.plugin.format.graphics2d.Png;

/**
 * Default implementation of the Canvas interface.
 *
 * @author Michael Hadrbolec
 *
 */
 class Canvas implements Plugable, DrawOrWriteable,
        OverrideDrawOrWriteable, AreaOfInterestTransformable {

    /**
     * The name of the plugin.
     */
    public static final String PLUGIN_NAME = "DrawPlugin";
    private Outputable mOutputFormat = new Png();

    /**
     * The default value for the previous drawn shape is an rectangle with the
     * width and height = 0 and positioned on the point 0,0.
     */
    private Shape previousDrawnShape = new Rectangle2D.Double(0, 0, 0, 0);

    /**
     * Whether the output format has been initialized.
     */
    private boolean isInitialized = false;

    /**
     * Stores the world units.
     */
    private Length mWorldUnits = Globals.DEFEAULT_WORLD_UNIT;

    /**
     * Stores the drawing units.
     */
    private Length mDrawingUnits = Globals.DEFEAULT_DRAWING_UNIT;

    /**
     * Stores the stroke units.
     */
    private Length mStrokeUnits = Globals.DEFEAULT_STROKE_UNIT;

    /**
     * Stores the angle units.
     */
    private Angle mAngleUnits = Globals.DEFAULT_ANGLE_UNIT;

    /**
     * Stores the viewport.
     */
    private Shape mViewportShape = null;

    /**
     * Stores the default scale x factor.
     */
    private double mScaleX = Globals.DEFAULT_SCALE;

    /**
     * Stores the dfeault scale y factor.
     */
    private double mScaleY = Globals.DEFAULT_SCALE;

    /**
     * Stores the viewport center.
     */
    private Point2D mCenter = null;

    private double mRotate = Globals.DEFAULT_ROTATE;

    Canvas(Length worldUnits, Length drawingUnits, Length strokeUnits, Angle angleUnits) {
        this.mWorldUnits = worldUnits;
        this.mDrawingUnits = drawingUnits;
        this.mStrokeUnits = strokeUnits;
        this.mAngleUnits = angleUnits;
    }

    /**
     * Writes the rendering result into the given output stream.
     *
     * @param out The output stream into which the rendering result will be
     * written.
     * @throws IOException Is thrown in the case an error occurs.
     */
    @Override
    public void write(OutputStream out) throws IOException {
        this.mOutputFormat.write(out);
        this.mOutputFormat.tearDown();
    }

    public final Overrideable worldUnits(Length worldUnits) {
        this.mWorldUnits = worldUnits;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Length getWorldUnits() {
        return this.mWorldUnits;
    }

    @Override
    public final Length getDrawingUnits() {
        return this.mDrawingUnits;
    }

    /**
     * Gets the stroke units.
     *
     * @return The stroke units.
     */
    public final Length getStrokeUnits() {
        return this.mStrokeUnits;
    }

    @Override
    public final Angle getAngleUnits() {
        return this.mAngleUnits;
    }

    @Override
    public final Shape getShape() {
        return this.mViewportShape;
    }

    @Override
    public final Point2D getCenter() {
        return this.mCenter;
    }

    @Override
    public final double getScaleX() {
        return this.mScaleX;
    }

    @Override
    public final double getScaleY() {
        return this.mScaleY;
    }

    @Override
    public final double getRotate() {
        return this.mRotate;
    }

    public OverrideDrawOrWriteable size(double width, double height) {
        this.mViewportShape = new Rectangle2D.Double(0, 0, width, height);
        return this;
    }

    @Override
    public OverrideDrawOrWriteable scale(double scaleFactor) {
        this.scale(scaleFactor, scaleFactor);
        return this;
    }

    /**
     * Currently only internal. Allows to set different scale factors in x and y
     * direction.
     *
     * @param scaleXFactor The scaleFactor in x direction.
     * @param scaleYFactor The scaleFactor in y direction.
     * @return Allows to change the area of interest.
     */
    public OverrideDrawOrWriteable scale(double scaleXFactor,
            double scaleYFactor) {
        this.mScaleX = scaleXFactor;
        this.mScaleY = scaleYFactor;
        return this;
    }

    @Override
    public OverrideDrawOrWriteable center(double centerX, double centerY) {
        this.mCenter = new Point2D.Double(centerX, centerY);
        return this;
    }

    @Override
    public OverrideDrawOrWriteable rotate(double rotation) {
        this.mRotate = getAngleUnits().convert(rotation);
        return this;
    }

    @Override
    public <T extends Outputable> Canvas outputFormat(Class<T> outputFormat) {
        this.mOutputFormat = Util.get().getPlugin(outputFormat);
        return this;
    }

    @Override
    public DrawOrWriteable draw(
            Buildable builder) {
        /* check wethter the ouptputable format has been initialized */
        if (!this.isInitialized) {
            /* Initialize the global transformation */
            this.mOutputFormat.setUp(this.getShape(),
                    this.getWorldUnits(), this.getDrawingUnits(), getStrokeUnits(), getAngleUnits(),
                    new TransformUtil().getGlobalTransform(this));
            /* set initialzed true */
            this.isInitialized = true;
        }

        /* only in the case the primitive is visible */
        if (builder.getStyle().isVisible()) {
            /* perform setup tasks */
            this.mOutputFormat.before();
            /* process in the case it is a point based primitive */

            if (builder.isPoint()) {
                for (Object point : builder.getPoints()) {
                    try {
                        previousDrawnShape = draw(new TransformUtil().transform((Point<?, ?>) point, previousDrawnShape, this.mOutputFormat.getGlobalTransform()), builder, previousDrawnShape);
                    } catch (Exception ex) {
                        Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                previousDrawnShape = draw(null, builder, previousDrawnShape);
            }
            /* perform the cleanup tasks */
            this.mOutputFormat.after();
        }

        return this;
    }

    /**
     * Draws the primitive.
     *
     * @param point The point (optional) if it is a point.
     * @param builder The builder to draw.
     * @param previousDrawnShape The previous drawn shape.
     */
    final Shape draw(Point2D point,
            Buildable builder, Shape previousDrawnShape) {
        Shape drawnShape = null;
        builder.setUp(this.previousDrawnShape);
        /* process the shape primitive */
        if (builder instanceof ShapeDrawable) {
            drawnShape = this.mOutputFormat.drawShape(
                    point, (ShapeDrawable) builder);
            /* process the image primitive */
        } else if (builder instanceof ImageDrawable) {
            drawnShape = this.mOutputFormat.drawImage(point, (ImageDrawable) builder);
            /* process the text primitive */
        } else if (builder instanceof TextDrawable) {
            drawnShape = this.mOutputFormat.drawText(point, (TextDrawable) builder);
        } else {
            throw new java.lang.IllegalArgumentException(builder.getClass()
                    .toString());
        }
        /* celanup */
        builder.tearDown();
        return drawnShape;
    }

    @Override
    public void write(Path out) throws IOException {
        write(Files.newOutputStream(out));
    }

}
