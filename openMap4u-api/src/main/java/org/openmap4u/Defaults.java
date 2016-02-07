package org.openmap4u;

import java.io.Serializable;
import java.util.Locale;

import org.openmap4u.common.Angle;
import org.openmap4u.common.Length;
import org.openmap4u.style.ImageStyle;
import org.openmap4u.style.LineStringStyle;
import org.openmap4u.style.ShapeStyle;
import org.openmap4u.style.TextStyle;

/**
 * Is a bean that contains all default values like units, styles, ... . It
 * allows to override the defaults with user defined custom values (if
 * necessary).<br>
 * <br>
 * <code>OpenMap4u om4u = new OpenMap4u();<br>om4u.getDefaults().setWorldUnits(Length.M);<br>om4u.getDefaults().setDrawingUnits(Length.CM);<br>...</code>
 * <br>
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
	private Locale locale;

	/**
	 * Stores the default world units.
	 */
	private Length worldUnits = null;

	/**
	 * Stores the default drawing units.
	 */
	private Length drawingUnits = null;

	/**
	 * Stores the default stroke units.
	 */
	private Length strokeUnits = null;

	/**
	 * Stores the default image style.
	 */
	private ImageStyle imageStyle = new ImageStyle();
	/**
	 * Stores the default shape style.
	 */
	private ShapeStyle shapeStyle = null;

	private LineStringStyle lineStringStyle = null;

	/**
	 * Stores the default text style.
	 */
	private TextStyle textStyle = null;

	private Angle mAngleUnits = Angle.DEGREE;

	/**
	 * Gets the default image style.
	 *
	 * @return The default image style.
	 */
	public ImageStyle getImageStyle() {
		if (this.imageStyle == null) {
			setImageStyle(new ImageStyle());
		}
		return (ImageStyle) this.imageStyle.clone();
	}

	/**
	 * Sets the default style for image primitives.
	 *
	 * @param defaultImageStyle
	 *            The default style for image primitives.
	 */
	public void setImageStyle(ImageStyle defaultImageStyle) {
		this.imageStyle = defaultImageStyle;
	}

	public LineStringStyle getLineStringStyle() {
		if (this.lineStringStyle == null) {
			setLineStringStyle(new LineStringStyle());
		}
		return (LineStringStyle) this.lineStringStyle.clone();
	}

	public void setLineStringStyle(LineStringStyle defaultLIneStringStyle) {
		this.lineStringStyle = defaultLIneStringStyle;
	}

	/**
	 * Gets the default style for shape primitives.
	 *
	 * @return The default style for shape primitives.
	 */
	public ShapeStyle getShapeStyle() {
		if (this.shapeStyle == null) {
			setShapeStyle(new ShapeStyle());
		}
		return (ShapeStyle) this.shapeStyle.clone();
	}

	/**
	 * Sets the default style for shape primitives.
	 *
	 * @param defaultShapeStyle
	 *            The default style for shape primitives.
	 */
	public void setShapeStyle(ShapeStyle defaultShapeStyle) {
		this.shapeStyle = defaultShapeStyle;
	}

	/**
	 * Gets the default style for text primitives.
	 *
	 * @return The default style for text primitives.
	 */
	public TextStyle getTextStyle() {
		if (this.textStyle == null) {
			setTextStyle(new TextStyle());
		}
		return (TextStyle) this.textStyle.clone();
	}

	/**
	 * Sets the default style for text primitives.
	 *
	 * @param defaultTextStyle
	 *            The default style for text primitives.
	 */
	public void setTextStyle(TextStyle defaultTextStyle) {
		this.textStyle = defaultTextStyle;
	}

	/**
	 * Gets the default value for drawing units (see {@link Length}).
	 *
	 * @return The default value for drawing units.
	 */
	public Length getDrawingUnits() {
		if (this.drawingUnits == null) {
			setDrawingUnits(Length.DEFEAULT_DRAWING_UNIT);
		}
		return drawingUnits;
	}

	/**
	 * Sets the default value for drawing units (see {@link Length}).
	 *
	 * @param drawingUnits
	 *            The default value for drawing units.
	 */
	public void setDrawingUnits(Length drawingUnits) {
		this.drawingUnits = drawingUnits;
	}

	/**
	 * Gets the default value for stroke units (see {@link Length}).
	 *
	 * @return The default value for stroke units.
	 */
	public Length getStrokeUnits() {
		if (this.strokeUnits == null) {
			setStrokeUnits(Length.DEFEAULT_STROKE_UNIT);
		}
		return strokeUnits;
	}

	/**
	 * Sets the default value for stroke units (see {@link Length}).
	 *
	 * @param strokeUnits
	 *            The default value for stroke units.
	 */
	public void setStrokeUnits(Length strokeUnits) {
		this.strokeUnits = strokeUnits;
	}

	/**
	 * Gets the default value for world units (see {@link Length}).
	 *
	 * @return The default value for world units.
	 */
	public Length getWorldUnits() {
		if (this.worldUnits == null) {
			setWorldUnits(Length.DEFEAULT_WORLD_UNIT);
		}
		return worldUnits;
	}

	/**
	 * Sets the default value for world units (see {@link Length}).
	 *
	 * @param worldUnits
	 *            The default value for world units.
	 */
	public void setWorldUnits(Length worldUnits) {
		this.worldUnits = worldUnits;
	}

	public Angle getAngleUnits() {
		if (this.mAngleUnits == null) {
			setAngleUnits(Angle.DEFAULT);
		}
		return this.mAngleUnits;
	}

	public void setAngleUnits(Angle angleUnits) {
		this.mAngleUnits = angleUnits;
	}

	/**
	 * Gets the locale. If no locale was set, the default locale is returned.
	 *
	 * @return The locale.
	 */
	public Locale getLocale() {
		if (this.locale == null) {
			setLocale(Locale.getDefault());
		}
		return this.locale;
	}

	/**
	 * Sets the locale.
	 *
	 * @param locale
	 *            The locale.
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
