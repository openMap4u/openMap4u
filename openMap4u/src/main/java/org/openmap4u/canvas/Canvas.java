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
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openmap4u.commons.AreaOfInterestTransformable;
import org.openmap4u.Globals;
import org.openmap4u.builder.Buildable;
import org.openmap4u.commons.Plugable;
import org.openmap4u.commons.TransformHelper;
import org.openmap4u.commons.TransformUtil;
import org.openmap4u.commons.Util;
import org.openmap4u.format.Outputable;
import org.openmap4u.plugin.format.graphics2d.Png;
import org.openmap4u.style.ImageStyle;
import org.openmap4u.style.ShapeStyle;
import org.openmap4u.style.Style;
import org.openmap4u.style.TextStyle;
import org.openmap4u.unit.Angle;
import org.openmap4u.unit.Length;

/**
 * Default implementation of the Canvas interface.
 *
 * @author Michael Hadrbolec
 *
 */
public class Canvas implements Plugable, SetUp, DrawOrWrite,
        SetAreaOfInterestOrDrawOrWrite {

    /**
     * The name of the plugin.
     */
    public static final String PLUGIN_NAME = "DrawPlugin";
    private Length mWorldUnits = Globals.DEFEAULT_WORLD_UNIT;
    private Length mDrawingUnits = Globals.DEFEAULT_DRAWING_UNIT;
    private Length mStrokeUnits = Globals.DEFEAULT_STROKE_UNIT;
    private Angle mAngleUnits = Globals.DEFAULT_ANGLE_UNIT;
    private Outputable mOutputFormat = new Png(); 
    
    /**
     * Stores the area of interest parameters.
     */
    private AreaOfInterestTransformable mAreaOfInterest = new AreaOfInterestTransfrom();
    
    /**
     * Stores the global transformation.
     */
    private AffineTransform mGlobalTransform = new AffineTransform();

   
    
    private Canvas() {
    }

    /**
     * Creates a new Canvas instance.
     *
     * @return The new creates Canvas instance.
     */
    public static SetUp create() {
        return new Canvas();
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
     * Gets the angle units.
     *
     * @return The angle units.
     */
    protected final Angle getAngleUnits() {
        return this.mAngleUnits;
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
    public final SetUp worldUnits(Length worldUnits) {
        this.mWorldUnits = worldUnits;
        return this;
    }

    @Override
    public final SetUp drawingUnits(Length drawingUnits) {
        this.mDrawingUnits = drawingUnits;
        return this;
    }

    @Override
    public final SetUp strokeUnits(Length strokeUnits) {
        this.mStrokeUnits = strokeUnits;
        return this;
    }

    @Override
    public final SetUp angleUnits(Angle angleUnits) {
        this.mAngleUnits = angleUnits;
        return this;
    }

    @Override
    public SetAreaOfInterestOrDrawOrWrite size(double width, double height) {
       this.mAreaOfInterest.setShape(new Rectangle2D.Double(width,height ));
        return this;
    }

    @Override
    public SetAreaOfInterestOrDrawOrWrite scale(double scaleFactor) {
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
    public SetAreaOfInterestOrDrawOrWrite scale(double scaleXFactor,
            double scaleYFactor) {
        this.mTransformHelper.setScaleX(scaleXFactor);
        this.mTransformHelper.setScaleY(scaleYFactor);
        return this;
    }

    @Override
    public SetAreaOfInterestOrDrawOrWrite center(double centerX, double centerY) {
        this.mTransformHelper.setX(centerX);
        this.mTransformHelper.setY(centerY);
        return this;
    }

    @Override
    public SetAreaOfInterestOrDrawOrWrite rotate(double rotation) {
        this.mTransformHelper.setRotate(rotation);
        return this;
    }

    @Override
    public <T extends Outputable> SetUp outputFormat(Class<T> outputFormat) {
        this.mDrawablePlugin = Util.get().getPlugin(outputFormat);
        return this;
    }

    void initializeOuputFormat() {
    }

 

    @Override
    public DrawOrWrite draw(
            Buildable<?, ? extends Style, ?> builder) {
        /* check wethter the ouptputable format has been initialized */
        if (!this.mDrawablePlugin.isInitialized()) {
            /* Initialize the global transformation */
            this.mGlobalTransform = this.mTranformUtil.getGlobalTransform(this.mAreaOfInterest, getWorldUnits(),
                    getDrawingUnits());
            /* setup the ouptut format */
            this.mDrawablePlugin.setUp(getWidth(), getHeight(),
                    getWorldUnits(), getDrawingUnits(), getStrokeUnits(),
                    getGlobalTransform());
        }
        /* Shape */
        /* iterate over all primitives */
        /*   if (this.mShape != null) {
         if (primitive.getAnchorX() != null && primitive.getAnchorY() != null) {
         try {
         primitive.getPoints().clear();
         Point2D.Double point = getAnchorPoint(primitive, this.mShape);
         primitive.addPoint(mWidth, mWidth);
         } catch (NoninvertibleTransformException ex) {
         Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         } */

        /* only in the case the primitive is visible */
        if (builder.getPrimitive().getStyle().isVisible()) {
            /* perform setup tasks */
            this.mDrawablePlugin.before();
            /* process in the case it is a point based primitive */
            if (builder.getPrimitive().isPoint()) {

                for (Object point : builder.getPrimitive().getPoints()) {
                    if (point instanceof Point2D) {
                        /* create the individual transformation */
                        this.mShape = draw((Point2D) point, builder.getPrimitive());
                    } else {
                    }
                }
            } else {
                this.mShape = draw(null, builder.getPrimitive());
            }
            /* perform the cleanup tasks */
            this.mDrawablePlugin.after();
        }

        return this;
    }

    /**
     * Draws the primitive.
     *
     * @param <>> The type of the primitive.
     * @param <>> The style of the primitive to be drawn.
     * @param primitive The primitiveto be drawn.
     */
    final <T, S extends Style<S>> Shape draw(Point2D point,
            Buildable builder) {
        /* process the shape primitive */
        if (builder instanceof ShapeBuilder) {
            return this.mDrawablePlugin.drawShape((Shape) primitive.getPrimitive(),
                    point, primitive.getIndividualTransform(),
                    (ShapeBuilder) primitive.getStyle());
            /* process the image primitive */
        } else if (primitive instanceof ImageBuilder) {
            return this.mDrawablePlugin.drawImage( point,() primitive.getIndividualTransform(),
                    (ImageStyle) primitive.getStyle());
            /* process the text primitive */
        } else if (primitive instanceof TextBuilder) {
            return this.mDrawablePlugin.drawText(
                    point, primitive.getIndividualTransform(),
                    (TextStyle) primitive.getStyle());
        } else {
            throw new java.lang.IllegalArgumentException(primitive.getClass()
                    .toString());
        }
    }

    /**
     * Gets a cloned  global transformation.
     *
     * @return The clonded global transformation.
     */
    final AffineTransform getGlobalTransform() {
        return (AffineTransform) this.mGlobalTransform.clone();
    }

    @Override
    public void write(Path out) throws IOException {
        write(Files.newOutputStream(out));
    }

    /*  Point2D.Double getAnchorPoint(Primitive primitive, Shape shape) throws NoninvertibleTransformException {
     if (primitive.getAnchorX() != null && primitive.getAnchorY() != null) {
     double x = 0;
     double y = 0;
     switch (primitive.getAnchorX()) {
     case MinX:
     shape.getBounds2D().getMinX();
     break;
     case MaxX:
     shape.getBounds2D().getMaxX();
     break;
     case CenterX:
     shape.getBounds2D().getCenterX();
     break;
     default:
     x = 0;
     break;
     }
     switch (primitive.getAnchorY()) {
     case MinY:
     shape.getBounds2D().getMinY();
     break;
     case MaxY:
     shape.getBounds2D().getMaxY();
     break;
     case CenterY:
     shape.getBounds2D().getCenterY();
     break;
     default:
     x = 0;
     break;
     }
     Point2D.Double point = null;
     getGlobalTransform().createInverse().transform(new Point2D.Double(x, y), point);
     return point;
     } else {
     return null;
     }
     } */
}
