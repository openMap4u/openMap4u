package org.openmap4u;

import java.beans.Transient;
import java.io.Serializable;

import org.openmap4u.canvas.CanvasPlugin;
import org.openmap4u.canvas.SetUp;
import org.openmap4u.commons.Util;

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

    /**
     * Stores the builder.
     */
    private transient Builder mBuilder = null;

    private Defaults mDefaultConfiguration = null;

    /**
     * Constructor.
     */
    public OpenMap4u() {
        this.mDefaultConfiguration = new Defaults();
    }

    /**
     * Gets a builder.
     * 
     * @return The builder.
     */
    @Transient
    public Builder getBuilder() {
        if (this.mBuilder == null) {
            this.mBuilder = new Builder(mDefaultConfiguration);
        }
        return this.mBuilder;
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
     * @param defaultValues
     *            The default configuration values.
     */
    public void setDefaults(Defaults defaultValues) {
        this.mDefaultConfiguration = defaultValues;
    }

    /**
     * Gets a drawing canvas.
     * 
     * @return A drawing canvas.
     */
    public SetUp getCanvas() {
        return Util.get().getPlugin(CanvasPlugin.class);
    }
}
