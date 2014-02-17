package org.openmap4u;

import java.io.Serializable;
import org.openmap4u.builder.Buildable;
import org.openmap4u.builder.ImageBuilder;
import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.builder.TextBuilder;

import org.openmap4u.commons.Util;
import org.openmap4u.commons.ImageStyleable;
import org.openmap4u.commons.ShapeStyleable;
import org.openmap4u.commons.Styleable;
import org.openmap4u.commons.TextStyleable;

/**
 * The openMap4u API.
 *
 * @author Michael Hadrbolec
 */
public final class OpenMap4u implements Serializable {

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
     * Creates a new builder of the given class and initializes it with the
     * in ({@link org.openmap4u.OpenMap4u#getDefaults()}) provided values.
     *
     * @param <S> The style type.
     * @param <B> The primitive type.
     * @param builderClass The builder class e.g.:
     * {@link org.openmap4u.plugin.builder.core.Line},{@link org.openmap4u.plugin.builder.core.Polyline}, {@link org.openmap4u.plugin.builder.core.Polygon}, {@link org.openmap4u.plugin.builder.core.Image}, {@link org.openmap4u.plugin.builder.core.Text}, {@link org.openmap4u.plugin.builder.core.Line},
     * ...).
     * @return The with default styles and units (the in the
     * {@link org.openmap4u.OpenMap4u#getDefaults()} initialized builder
     * instance.
     */
    public  <S extends Styleable<S>, B extends Buildable<S, B>> B get(
            Class<B> builderClass) {
        B builder = Util.get().getPlugin(builderClass);
        try {
            if (builder instanceof ShapeBuilder) {
                ((ShapeBuilder) builder).setStyle(((ShapeStyleable) getDefaults()
                        .getShapeStyle()).clone());
            } else if (builder instanceof ImageBuilder) {
                ((ImageBuilder) builder).setStyle(((ImageStyleable) getDefaults()
                        .getImageStyle()).clone());
            } else if (builder instanceof TextBuilder) {
                ((TextBuilder) builder).
                        setStyle(((TextStyleable) getDefaults()
                                .getTextStyle()).clone());
            }
        } catch (CloneNotSupportedException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
        return builder;
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
     * @param defaultValues The default configuration values.
     */
    public void setDefaults(Defaults defaultValues) {
        this.mDefaultConfiguration = defaultValues;
    }

    /**
     * Creates a new drawing canvas instance. The instance is based on the
     * preconfigured {@link org.openmap4u.OpenMap4u#getDefaults()} values.
     *
     * @param width The canvas width in drawing units.
     * @param height The canvas height in drawing units.
     * @return A new drawing canvas instance based on the preconfigured values.
     */
     public OverrideDrawOrWriteable getCanvas(double width,double height) {
       return new Canvas(this.mDefaultConfiguration.getWorldUnits(),this.mDefaultConfiguration.getDrawingUnits(),this.mDefaultConfiguration.getStrokeUnits(),this.mDefaultConfiguration.getAngleUnits()).size(width,height);
    }
}
