package org.openmap4u;

import java.io.Serializable;
import java.util.Locale;

import org.openmap4u.style.ImageStyle;
import org.openmap4u.style.ImageStyleable;
import org.openmap4u.style.ShapeStyle;
import org.openmap4u.style.ShapeStyleable;
import org.openmap4u.style.TextStyle;
import org.openmap4u.style.TextStyleable;
import org.openmap4u.unit.Length;

/**
 * Contains the default values. It also allows to override the defaults with
 * user defined custom values (if necessary).
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
	private Length mDefaultWorldUnits = Length.M;

	/**
	 * Stores the default drawing units.
	 */
	private Length mDefaultDrawingUnits = Length.CM;

	/**
	 * Stores the default stroke units.
	 */
	private Length mDefaultStrokeUnits = Length.MM;

	/**
	 * Stores the default image style.
	 */
	private ImageStyleable mDefaultImageStyle = new ImageStyle();
	/**
	 * Stores the default shape style.
	 */
	private ShapeStyleable mDefaultShapeStyle = new ShapeStyle().setStrokeSize(
			Globals.DEFAULT_STROKE_SIZE).setStrokeColor(
			Globals.DEFAULT_STROKE_COLOR);
	/**
	 * Stores the default text style.
	 */
	private TextStyleable mDefaultTextStyle = new TextStyle().setFontSize(
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
	public ImageStyleable getImageStyle() {
		return this.mDefaultImageStyle;
	}

	/**
	 * Gets the default shape style.
	 * 
	 * @return The default shape style.
	 */
	public ShapeStyleable getShapeStyle() {
		return this.mDefaultShapeStyle;
	}

	/**
	 * Gets the default text style.
	 * 
	 * @return The default text style.
	 */
	public TextStyleable getTextStyle() {
		return this.mDefaultTextStyle;
	}

	/**
	 * Gets the default value for drawing units (see {@link Length}).
	 * 
	 * @return The default value for drawing units.
	 */
	public Length getDrawingUnits() {
		return mDefaultDrawingUnits;
	}

	/**
	 * Sets the default value for drawing units (see {@link Length}).
	 * 
	 * @param drawingUnits
	 *            The default value for drawing units.
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
		return mDefaultStrokeUnits;
	}

	/**
	 * Sets the default value for stroke units (see {@link Length}).
	 * 
	 * @param strokeUnits
	 *            The default value for stroke units.
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
		return mDefaultWorldUnits;
	}

	/**
	 * Sets the default value for world units (see {@link Length}). .
	 * 
	 * @param worldUnits
	 *            The default value for world units.
	 */
	public void setWorldUnits(Length worldUnits) {
		this.mDefaultWorldUnits = worldUnits;
	}

	/**
	 * Sets the default image style.
	 * 
	 * @param defaultImageStyle
	 *            The default image style.
	 */
	public void setImageStyle(ImageStyleable defaultImageStyle) {
		this.mDefaultImageStyle = defaultImageStyle;
	}

	/**
	 * Sets the default shape style.
	 * 
	 * @param defaultShapeStyle
	 *            The default shape style.
	 */
	public void setShapeStyle(ShapeStyleable defaultShapeStyle) {
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
	 * @param locale
	 *            The locale.
	 */
	public void setLocale(Locale locale) {
		this.mDefaultLocale = locale;
	}

}
