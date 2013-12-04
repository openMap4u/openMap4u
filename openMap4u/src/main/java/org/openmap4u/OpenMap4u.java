package org.openmap4u;

import java.beans.Transient;
import java.io.Serializable;
import org.openmap4u.builder.Buildable;
import org.openmap4u.builder.ImageBuilder;
import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.builder.TextBuilder;

import org.openmap4u.canvas.Canvas;
import org.openmap4u.canvas.SetUp;
import org.openmap4u.commons.Util;
import org.openmap4u.style.ImageStyle;
import org.openmap4u.style.ShapeStyle;
import org.openmap4u.style.Style;
import org.openmap4u.style.TextStyle;

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
     * Gets the builder and initializes it with the konfigured default values.
      * @param builderClass The builder class.
     * @return  The builder.
     */
    public <T, S extends Style<S>, B extends Buildable<T, S, B>> B getBuilder(
            Class<B> builderClass) {
        B builder = Util.get().getPlugin(builderClass);
        try {
            if (builder instanceof ShapeBuilder) {
                ((ShapeBuilder) builder).
                        getPrimitive().setStyle(((ShapeStyle) getDefaults()
                                .getShapeStyle()).clone());
            } else if (builder instanceof ImageBuilder) {
                ((ImageBuilder) builder).
                        getPrimitive().setStyle(((ImageStyle) getDefaults()
                                .getImageStyle()).clone());
            } else if (builder instanceof TextBuilder) {
                ((TextBuilder) builder).
                        getPrimitive().setStyle(((TextStyle) getDefaults()
                                .getTextStyle()).clone());
            }
        } catch (CloneNotSupportedException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
        return builder;
    }
    
    /**
     * Allows to configure and / or to override the default configuration.
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
     * Gets a new drawing canvas instance. The instance is based on the
     * preconfigured default values.
     *
     * @return A new drawing canvas instance.
     */
    public SetUp getCanvas() {
          return Canvas.create().worldUnits(this.mDefaultConfiguration.getWorldUnits()).drawingUnits(this.mDefaultConfiguration.getDrawingUnits()).
                strokeUnits(this.mDefaultConfiguration.getStrokeUnits());
     } 
}
