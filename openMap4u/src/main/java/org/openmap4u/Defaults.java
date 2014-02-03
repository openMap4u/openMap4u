package org.openmap4u;

import org.openmap4u.commons.Globals;
import java.io.Serializable;
import java.util.Locale;

import org.openmap4u.commons.ImageStyle;
import org.openmap4u.commons.ShapeStyle;
import org.openmap4u.commons.TextStyle;
import org.openmap4u.commons.Length;

/**
 * Is a bean that contains all default values like units, styles, ... . It allows to override the defaults with
 * user defined custom values (if necessary).<br><br>
 * <code>OpenMap4u om4u = new OpenMap4u();<br>om4u.getDefaults().setWorldUnits(Length.M);<br>om4u.getDefaults().setDrawingUnits(Length.CM);<br>...</code><br>
 *
 * @author Michael Hadrbolec
 *
 */
public final class Defaults implements Serializable {

    /**
     * The generated serialVersionUID.
     */
    private static final long serialVersionUID = 1132509856218705667L;

    /**
     * Stores the default locale.
     */
    private Locale mDefaultLocale;

    /**
     * Stores the default world units.
     */
    private Length mDefaultWorldUnits = null;

    /**
     * Stores the default drawing units.
     */
    private Length mDefaultDrawingUnits = null;

    /**
     * Stores the default stroke units.
     */
    private Length mDefaultStrokeUnits = null;

    /**
     * Stores the default image style.
     */
    private ImageStyle mDefaultImageStyle = new ImageStyle();
    /**
     * Stores the default shape style.
     */
    private ShapeStyle mDefaultShapeStyle = null;
    /**
     * Stores the default text style.
     */
    private TextStyle mDefaultTextStyle = new TextStyle().setFontSize(
            Globals.DEFAULT_FONT_SIZE).setFontColor(
                    Globals.DEFAULT_STROKE_COLOR);

    /**
     * Creates a new instance.
     */
    Defaults() {
    }

    /**
     * Gets the default image style.
     *
     * @return The default image style.
     */
    public ImageStyle getImageStyle() {
        return this.mDefaultImageStyle;
    }

    /**
     * Gets the default style for shape primitives.
     *
     * @return The default style for shape primitives.
     */
    public ShapeStyle getShapeStyle() {
        if (this.mDefaultShapeStyle == null) {
            this.mDefaultShapeStyle = new ShapeStyle().setStrokeSize(
                    Globals.DEFAULT_STROKE_SIZE).setStrokeColor(
                            Globals.DEFAULT_STROKE_COLOR);
        }
        return this.mDefaultShapeStyle;
    }

    /**
     * Gets the default style for text primitives.
     *
     * @return The default style for text primitives.
     */
    public TextStyle getTextStyle() {
        return this.mDefaultTextStyle;
    }

    /**
     * Gets the default value for drawing units (see {@link Length}).
     *
     * @return The default value for drawing units.
     */
    public Length getDrawingUnits() {
        if (this.mDefaultDrawingUnits == null) {
            this.mDefaultDrawingUnits = Globals.DEFEAULT_DRAWING_UNIT;
        }
        return mDefaultDrawingUnits;
    }

    /**
     * Sets the default value for drawing units (see {@link Length}).
     *
     * @param drawingUnits The default value for drawing units.
     */
    public void setDrawingUnits(Length drawingUnits) {
        this.mDefaultDrawingUnits = drawingUnits;
    }

    /**
     * Gets the default value for stroke units (see {@link Length}).
     *
     * @return The default value for stroke units.
     */
    public Length getStrokeUnits() {
        if (this.mDefaultStrokeUnits == null) {
            this.mDefaultStrokeUnits = Globals.DEFEAULT_STROKE_UNIT;
        }
        return mDefaultStrokeUnits;
    }

    /**
     * Sets the default value for stroke units (see {@link Length}).
     *
     * @param strokeUnits The default value for stroke units.
     */
    public void setStrokeUnits(Length strokeUnits) {
        this.mDefaultStrokeUnits = strokeUnits;
    }

    /**
     * Gets the default value for world units (see {@link Length}).
     *
     * @return The default value for world units.
     */
    public Length getWorldUnits() {
        if (this.mDefaultWorldUnits == null) {
            this.mDefaultWorldUnits = Globals.DEFEAULT_WORLD_UNIT;
        }
        return mDefaultWorldUnits;
    }

    /**
     * Sets the default value for world units (see {@link Length}). 
     *
     * @param worldUnits The default value for world units.
     */
    public void setWorldUnits(Length worldUnits) {
        this.mDefaultWorldUnits = worldUnits;
    }

    /**
     * Sets the default style for image primitives.
     *
     * @param defaultImageStyle The default style for image primitives.
     */
    public void setImageStyle(ImageStyle defaultImageStyle) {
        this.mDefaultImageStyle = defaultImageStyle;
    }

    /**
     * Sets the default style for shape primitives.
     *
     * @param defaultShapeStyle The default style for shape primitives.
     */
    public void setShapeStyle(ShapeStyle defaultShapeStyle) {
        this.mDefaultShapeStyle = defaultShapeStyle;
    }

    /**
     * Gets the locale. If no locale was set, the default locale is returned.
     *
     * @return The locale.
     */
    public Locale getLocale() {
        if (this.mDefaultLocale == null) {
            return Locale.getDefault();
        } else {
            return mDefaultLocale;
        }
    }

    /**
     * Sets the locale.
     *
     * @param locale The locale.
     */
    public void setLocale(Locale locale) {
        this.mDefaultLocale = locale;
    }

}
