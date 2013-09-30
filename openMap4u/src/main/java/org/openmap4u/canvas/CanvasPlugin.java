package org.openmap4u.canvas;

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
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.openmap4u.Globals;
import org.openmap4u.commons.TransformHelper;
import org.openmap4u.commons.Util;
import org.openmap4u.outputformat.OutputableFormat;
import org.openmap4u.plugin.outputformat.graphics2d.PngPlugin;
import org.openmap4u.primitive.Primitive;
import org.openmap4u.primitive.ImagePrimitive;
import org.openmap4u.primitive.ShapePrimitive;
import org.openmap4u.primitive.TextPrimitive;
import org.openmap4u.style.ImageStyleable;
import org.openmap4u.style.ShapeStyleable;
import org.openmap4u.style.Styleable;
import org.openmap4u.style.TextStyleable;
import org.openmap4u.unit.Length;

/**
 * Default implementation of the Canvas interface.
 *
 * @author Michael Hadrbolec
 *
 */
public class CanvasPlugin  implements Canvas   {

    /**
     *
     */
    public static final String PLUGIN_NAME = "DrawPlugin";
    private Length mWorldUnits = Globals.DEFEAULT_WORLD_UNIT;
    private Length mDrawingUnits = Globals.DEFEAULT_DRAWING_UNIT;
    private Length mStrokeUnits = Globals.DEFEAULT_STROKE_UNIT;
    private OutputableFormat mDrawablePlugin = new PngPlugin();
    private TransformHelper mTransformHelper = new TransformHelper();
    private AffineTransform mGlobalTransform = new AffineTransform();
    /**
     * Stores the width of the canvas.
     */
    private double mWidth;
    /**
     * Stores the height of the canvas.
     */
    private double mHeight;

    /**
     * Gets the width of the drawing canvas in drawing units {@link
     * AbstractCanvas.getDrawingUnits()}.
     *
     * @return Gets the width of the drawing canvas in drawing units.
     */
    protected final double getWidth() {
        return this.mWidth;
    }

    /**
     * Gets the height of the drawing canvas in drawing units {@link
     * AbstractCanvas.getDrawingUnits()}.
     *
     * @return Gets the height of the drawing canvas in drawing units.
     */
    protected final double getHeight() {
        return this.mHeight;
    }

    /**
     * Gets the world units.
     *
     * @return The drawing units.
     */
    protected final Length getWorldUnits() {
        return this.mWorldUnits;
    }

    /**
     * Gets the drawing units.
     *
     * @return The drawing units.
     */
    protected final Length getDrawingUnits() {
        return this.mDrawingUnits;
    }

    /**
     * Gets the stroke units.
     *
     * @return The stroke units.
     */
    protected final Length getStrokeUnits() {
        return this.mStrokeUnits;
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
        this.mDrawablePlugin.tearDown();
        this.mDrawablePlugin.write(out);
    }

    @Override
    public final SetUp setWorldUnits(Length worldUnits) {
        this.mWorldUnits = worldUnits;
        return this;
    }

    @Override
    public final SetUp setDrawingUnits(Length drawingUnits) {
        this.mDrawingUnits = drawingUnits;
        return this;
    }

    @Override
    public final SetUp setStrokeUnits(Length strokeUnits) {
        this.mStrokeUnits = strokeUnits;
        return this;
    }

    @Override
    public SetAreaOfInterestOrDraw  setSize(double width, double height) {
        this.mWidth = width;
        this.mHeight = height;

        return this;
    }

    @Override
    public SetAreaOfInterestOrDraw  setScale(double scaleFactor) {
        this.setScale(scaleFactor, scaleFactor);
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
    public SetAreaOfInterestOrDraw  setScale(double scaleXFactor,
            double scaleYFactor) {
        this.mTransformHelper.setScaleX(scaleXFactor);
        this.mTransformHelper.setScaleY(scaleYFactor);
        return this;
    }

    @Override
    public SetAreaOfInterestOrDraw  setCenter(double centerX, double centerY) {
        this.mTransformHelper.setX(centerX);
        this.mTransformHelper.setY(centerY);
        return this;
    }

    @Override
    public SetAreaOfInterestOrDraw  setRotate(double rotation) {
        this.mTransformHelper.setRotate(rotation);
        return this;
    }

    @Override
    public <T extends OutputableFormat> SetUp setOutputFormat(Class<T> outputFormat) {
        this.mDrawablePlugin = Util.get().getPlugin(outputFormat);
        return this;
    }

    void initializeOuputFormat() {
    }

    @Override
    public DrawOrWrite  setDraw(
            Primitive<?, ? extends Styleable> primitive) {
        /* check wethter the ouptputable format has been initialized */
        if (!this.mDrawablePlugin.isInitialized()) {
            /* Initialize the global transformation */
            this.mGlobalTransform = Util.get().getGlobalTransform(getWidth(),
                    getHeight(), this.mTransformHelper, getWorldUnits(),
                    getDrawingUnits());
            /* setup the ouptut format */
            this.mDrawablePlugin.setUp(getWidth(), getHeight(),
                    getWorldUnits(), getDrawingUnits(), getStrokeUnits(),
                    getGlobalTransform());
        }
        /* perform setup tasks */
        this.mDrawablePlugin.before();
        /* process in the case it is a point based primitive */
        if (primitive.isPoint()) {
            for (Point2D.Double point : primitive.getPoints()) {
                /* create the individual transformation */
                draw(point, primitive);
            }
        } else {
            draw(null, primitive);
        }
        /* perform the cleanup tasks */
        this.mDrawablePlugin.after();
        return this;
    }

    @Override
    public DrawOrWrite setDraw(Stream<Primitive<?, ? extends Styleable>> primitives2Draw) {
        primitives2Draw.forEach(primitive -> this.setDraw(primitive));
        return this;
    }

    /**
     * Draws the primitive.
     *
     * @param <T> The type of the primitive.
     * @param <S> The style of the primitive to be drawn.
     * @param primitive The primitiveto be drawn.
     */
    final <T, S extends Styleable<S>> void draw(Point2D.Double point,
            Primitive<T, S> primitive) {
        /* process the shape primitive */
        if (primitive instanceof ShapePrimitive) {
            this.mDrawablePlugin.drawShape((Shape) primitive.getPrimitive(),
                    point, primitive.getIndividualTransform(),
                    (ShapeStyleable) primitive.getStyle());
            /* process the image primitive */
        } else if (primitive instanceof ImagePrimitive) {
            this.mDrawablePlugin.drawImage((Path) primitive.getPrimitive(),
                    point, primitive.getIndividualTransform(),
                    (ImageStyleable) primitive.getStyle());
            /* process the text primitive */
        } else if (primitive instanceof TextPrimitive) {
            this.mDrawablePlugin.drawText((String) primitive.getPrimitive(),
                    point, primitive.getIndividualTransform(),
                    (TextStyleable) primitive.getStyle());
        } else {
            throw new java.lang.IllegalArgumentException(primitive.getClass()
                    .toString());
        }
    }

    /**
     * Gets the global transformation.
     *
     * @return The global transformation.
     */
    final AffineTransform getGlobalTransform() {
        return (AffineTransform) this.mGlobalTransform.clone();
    }

    @Override
    public void write(Path out) throws IOException {
        write(Files.newOutputStream(out));
    }

}
