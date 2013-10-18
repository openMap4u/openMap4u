package org.openmap4u;

import org.openmap4u.builder.Buildable;
import org.openmap4u.builder.Image;
import org.openmap4u.builder.ImageBuilder;
import org.openmap4u.builder.Shape;
import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.builder.Text;
import org.openmap4u.builder.TextBuilder;
import org.openmap4u.builder.Wkb;
import org.openmap4u.builder.Wkt;
import org.openmap4u.commons.Util;
import org.openmap4u.style.ImageStyleable;
import org.openmap4u.style.ShapeStyleable;
import org.openmap4u.style.Styleable;
import org.openmap4u.style.TextStyleable;

/**
 * Is a helper class, that creates for the openMap4u API on demand different
 * builders.
 * 
 * @author hadrbolec
 */
public final class Builder {

    private Defaults mDefaultConfiguration = null;

    /**
     * Creates a new builder instance.
     * 
     * @param mDefaultConfiguration
     */
    Builder(Defaults configuration) {
        this.mDefaultConfiguration = configuration;
    }

    /**
     * Gets a custom builder plugin.
     * 
     * @param <T> The primitive type.
     * @param <S> The primitive style.
     * @param <B> The builder type.
     * @param builderClass
     *            The class of the custom builder plugin class.
     * @return The custom builder plugin.
     */
    public <T, S extends Styleable<S>, B extends Buildable<T, S, B>> B getCustomBuilder(
            Class<B> builderClass) {
        B builder = Util.get().getPlugin(builderClass);
        try {
            if (builder instanceof ShapeBuilder) {
                ((ShapeBuilder) builder)
                        .setStyle(((ShapeStyleable) this.mDefaultConfiguration
                                .getShapeStyle()).clone());
            } else if (builder instanceof ImageBuilder) {
                ((ImageBuilder) builder)
                        .setStyle(((ImageStyleable) this.mDefaultConfiguration
                                .getImageStyle()).clone());
            } else if (builder instanceof TextBuilder) {
                ((TextBuilder) builder)
                        .setStyle(((TextStyleable) this.mDefaultConfiguration
                                .getTextStyle()).clone());
            }
        } catch (CloneNotSupportedException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
        return builder;
    }

    /**
     * Gets the shape builder plugin.
     * 
     * @return The shape builder plugin.
     */
    public Shape getShape() {
        return getCustomBuilder(Shape.class);
    }

    /**
     * Gets the wkt (Well Known Text) builder.
     * 
     * @return The wkb (Well Known Text) builder.
     */
    public Wkt getWkt() {
        return getCustomBuilder(Wkt.class);
    }

    /**
     * Gets the wkb (Well Known Binary) builder.
     * 
     * @return The wkb (Well Known Binary) builder.
     */
    public Wkb getWkb() {
        return getCustomBuilder(Wkb.class);
    }

    /**
     * Gets the image builder plugin.
     * 
     * @return The image builder plugin.
     */
    public Image getImage() {
        return getCustomBuilder(Image.class);
    }

    /**
     * Gets the text builder plugin.
     * 
     * @return The text builder plugin.
     */
    public Text getText() {
        return getCustomBuilder(Text.class);
    }
}
