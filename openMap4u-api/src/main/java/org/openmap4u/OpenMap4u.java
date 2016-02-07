package org.openmap4u;

import java.io.Serializable;

import org.openmap4u.builder.DrawableBuilder;
import org.openmap4u.builder.ImageBuilder;
import org.openmap4u.builder.LineStringBuilder;
import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.builder.TextBuilder;
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWriteable;
import org.openmap4u.common.Util;
import org.openmap4u.draw.Drawable;
import org.openmap4u.draw.ImageDrawable;
import org.openmap4u.draw.LineStringDrawable;
import org.openmap4u.draw.ShapeDrawable;
import org.openmap4u.draw.TextDrawable;
import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Style;

/**
 * The openMap4u API.
 *
 * @author Michael Hadrbolec
 */
public class OpenMap4u implements Serializable {

	/**
	 * The generated serialVersionUID.
	 */
	private static final long serialVersionUID = 7003870457791602481L;

	private Defaults mDefaultConfiguration = null;

	/**
	 * Creates a new OpenMap4u instance.
	 */
	public OpenMap4u() {
		this.mDefaultConfiguration = new Defaults();
	}

	/**
	 * Creates a new builder of the given class and initializes it with the in (
	 * {@link org.openmap4u.OpenMap4u#getDefaults()}) provided values.
	 *
	 * @param <S>
	 *            The style type.
	 * @param <B>
	 *            The primitive type.
	 * @param builderClass
	 *            The builder class e.g.:
	 *            {@link org.openmap4u.plugin.builder.core.Line},
	 *            {@link org.openmap4u.plugin.builder.core.Polyline},
	 *            {@link org.openmap4u.plugin.builder.core.Polygon},
	 *            {@link org.openmap4u.plugin.builder.core.Image},
	 *            {@link org.openmap4u.plugin.builder.core.Text},
	 *            {@link org.openmap4u.plugin.builder.core.Line}, ...).
	 * @return
	 * @return The with default styles and units (the in the
	 *         {@link org.openmap4u.OpenMap4u#getDefaults()} initialized builder
	 *         instance.
	 */
	public <B extends DrawableBuilder<D, P, S>, D extends Drawable<P, S>, P extends Primitive<P>, S extends Style<S>> B get(
			Class<B> drawableBuilderClass) {
		B drawBuildable = Util.get().getPlugin(drawableBuilderClass);
		try {
			initalizeWithDefaultStyle(drawBuildable);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drawBuildable;
	}

	/**
	 * Initializes it with the default style.
	 * 
	 * @param drawBuildable
	 *            The darwBuildable to be initialized with.
	 * @throws CloneNotSupportedException
	 */
	<B extends DrawableBuilder<D, P, S>, D extends Drawable<P, S>, P extends Primitive<P>, S extends Style<S>> void initalizeWithDefaultStyle(
			B drawBuildable) throws CloneNotSupportedException {
		if (drawBuildable instanceof ShapeBuilder) {
			((ShapeDrawable) drawBuildable.build()).setStyle(this.getDefaults().getShapeStyle());
		} else if (drawBuildable instanceof LineStringBuilder) {
			((LineStringDrawable) drawBuildable.build()).setStyle(this.getDefaults().getLineStringStyle());
		} else if (drawBuildable instanceof TextBuilder) {
			((TextDrawable) drawBuildable.build()).setStyle(this.getDefaults().getTextStyle());
		} else if (drawBuildable instanceof ImageBuilder) {
			((ImageDrawable) drawBuildable.build()).setStyle(this.getDefaults().getImageStyle());
		} else {
			throw new java.lang.IllegalArgumentException("unsupported type " + drawBuildable.getClass().getName());
		}
	}

	/**
	 * Allows to get and / or change the default configuration values.
	 *
	 * @return The default configuration values.
	 */
	public Defaults getDefaults() {
		return this.mDefaultConfiguration;
	}

	/**
	 * Allows to set the default values at once.
	 *
	 * @param defaultValues
	 *            The default configuration values.
	 */
	public void setDefaults(Defaults defaultValues) {
		this.mDefaultConfiguration = defaultValues;
	}

	/**
	 * Creates a new drawing canvas instance. The instance is based on the
	 * preconfigured {@link org.openmap4u.OpenMap4u#getDefaults()} values.
	 *
	 * @param width
	 *            The canvas width in drawing units.
	 * @param height
	 *            The canvas height in drawing units.
	 * @return A new drawing canvas instance based on the preconfigured values.
	 */
	public SetAreaOfInterestOrDrawOrWriteable getCanvas(double width, double height) {
		return null;// new
					// Canvas(this.mDefaultConfiguration.getWorldUnits(),this.mDefaultConfiguration.getDrawingUnits(),this.mDefaultConfiguration.getStrokeUnits(),this.mDefaultConfiguration.getAngleUnits()).size(width,height);
	}
}
