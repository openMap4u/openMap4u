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
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openmap4u.builder.Buildable;
import org.openmap4u.builder.ImageBuilder;
import org.openmap4u.builder.LineStringBuilder;
import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.builder.TextBuilder;
import org.openmap4u.canvas.AreaOfInterestTransformable;
import org.openmap4u.canvas.DrawOrWriteable;
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWriteable;
import org.openmap4u.common.Angle;
import org.openmap4u.common.Length;
import org.openmap4u.common.Plugable;
import org.openmap4u.common.Util;
import org.openmap4u.format.Outputable;
import org.openmap4u.geom.Point;
import org.openmap4u.transform.AffineTransformBuilder;
import org.openmap4u.transform.TransformBuildable;
import org.openmap4u.transform.Transformable;

/**
 * Default implementation of the Canvas interface.
 *
 * @author Michael Hadrbolec
 *
 */
class Canvas implements Plugable, DrawOrWriteable, SetAreaOfInterestOrDrawOrWriteable,
        AreaOfInterestTransformable {

    /**
     * The name of the plugin.
     */
    public static final String PLUGIN_NAME = "DrawPlugin";
    private Outputable mOutputFormat = null;

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
    private Length mWorldUnits = Length.DEFEAULT_WORLD_UNIT;

    /**
     * Stores the drawing units.
     */
    private Length mDrawingUnits = Length.DEFEAULT_DRAWING_UNIT;

    /**
     * Stores the stroke units.
     */
    private Length mStrokeUnits = Length.DEFEAULT_STROKE_UNIT;

    /**
     * Stores the angle units.
     */
    private Angle mAngleUnits = Angle.DEFAULT;

    /**
     * Stores the viewport.
     */
    private Shape mViewportShape = null;

 
    private AffineTransformBuilder transformBuilder = new AffineTransformBuilder();
    
    Canvas(Length worldUnits, Length drawingUnits, Length strokeUnits,
            Angle angleUnits) {
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

    public final SetAreaOfInterestOrDrawOrWriteable worldUnits(Length worldUnits) {
        this.mWorldUnits = worldUnits;
        return this;
    }

    /**
     * {@inheritDoc}
     */
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

    public final Angle getAngleUnits() {
        return this.mAngleUnits;
    }

    @Override
    public final Shape getShape() {
        return this.mViewportShape;
    }

    /**
     * Sets the shape of the canvas viewport.
     *
     * @param viewPortShape The shape of the viewport.
     * @return Fluent interface pattern.
     */
    public SetAreaOfInterestOrDrawOrWriteable size(Shape viewPortShape) {
        this.mViewportShape = viewPortShape;
        return this;
    }

    /**
     * Sets the shape of the canvas viewport as rectangle.
     *
     * @param width The width of the viewport in drawing units.
     * @param height The height of the viewport in drawing units.
     * @return Fluent interface pattern.
     */
    public SetAreaOfInterestOrDrawOrWriteable size(double width, double height) {
        return size(new Rectangle2D.Double(0, 0, width, height));
    }

    @Override
    public SetAreaOfInterestOrDrawOrWriteable scale(double scaleFactor) {
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
    public SetAreaOfInterestOrDrawOrWriteable scale(double scaleXFactor,
            double scaleYFactor) {
    	 this.transformBuilder.scaleX(scaleXFactor).scaleY(scaleYFactor);
        return this;
    }

    @Override
    public SetAreaOfInterestOrDrawOrWriteable center(Point point) {
        this.transformBuilder.translate(point.x,point.y);
        return this;
    }

    @Override
    public SetAreaOfInterestOrDrawOrWriteable rotate(double rotation) {
       this.transformBuilder.rotate( getAngleUnits().convert(rotation));
        return this;
    }

    @Override
    public <T extends Outputable> Canvas outputFormat(Class<T> outputFormat) {
        this.mOutputFormat = Util.get().getPlugin(outputFormat);
        return this;
    }





    @Override
    public void write(Path out) throws IOException {
        write(Files.newOutputStream(out));
    }

    @Override
    public void write(String first, String... more) throws IOException {
        write(FileSystems.getDefault().getPath(first, more));
    }

	@Override
	public <T extends ImageBuilder<T>> DrawOrWriteable draw(
			ImageBuilder<T> imageBuilder) {
		this.mOutputFormat.drawImage(imageBuilder.build());
		return this;
	}

	@Override
	public <T extends TextBuilder<T>> DrawOrWriteable draw(
			TextBuilder<T> textBuilder) {
		this.mOutputFormat.drawText(textBuilder.build());
		return this;
	}

	@Override
	public <T extends LineStringBuilder<T>> DrawOrWriteable draw(
			LineStringBuilder<T> lineStringBuilder) {
		this.mOutputFormat.drawLineString(lineStringBuilder.build());
		return this;
	}

	@Override
	public <T extends ShapeBuilder<T>> DrawOrWriteable draw(
			ShapeBuilder<T> shapeBuilder) {
		this.mOutputFormat.drawShape(shapeBuilder.build());
		return this;
	}



	@Override
	public Angle getAngularUnits() {
		// TODO Auto-generated method stub
		return null;
	}

}
