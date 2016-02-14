package org.openmap4u.builder;

import java.awt.Shape;
import java.util.List;
import java.util.Set;

import org.openmap4u.commons.Angle;
import org.openmap4u.interfaces.Drawable;
import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.Plugable;
import org.openmap4u.commons.Point;
import org.openmap4u.commons.Styleable;
import org.openmap4u.commons.Transparence;
import org.openmap4u.commons.VerticalAlign;
import org.openmap4u.interfaces.Buildable;

/**
 * All builders are derived from this base class. It uses the fluent builder
 * pattern.
 *
 * @author Michael Hadrbolec
 * @param <S>
 *            The style type.
 * @param <B>
 *            The builder type.
 */
public interface BuildablePrimitive<S extends Styleable<S>, B extends BuildablePrimitive<S, B, P>, P>
		extends Buildable<Drawable<S, P>>, Plugable {

	/**
	 * Sets the style at once.
	 * 
	 * @param style
	 *            The style.
	 * @return The builder itself.
	 */
	B style(S style);

	/**
	 * Sets whether the primitive is drawn (is visible = true) or not (is not
	 * visible = false). The default value is <code>true</code>.
	 *
	 * @param isVisible
	 *            The visibility.
	 * @return The builder itself.
	 */
	B visible(boolean isVisible);

	/**
	 * Sets the primitives transparency.
	 *
	 * @param tranparence
	 *            The primitives transparency.<br>
	 *            <br>
	 *            Examples:<br>
	 *            <table summary="">
	 *            <tr>
	 *            <td><code>myBuilder.transparence(0)</code></td>
	 *            <td><img alt="" src="./doc-files/b_transparence0.png"></td>
	 * 
	 *            <td><code>myBuilder.transparence(25)</code></td>
	 *            <td><img alt="" src="./doc-files/b_transparence25.png"></td>
	 * 
	 *            <td><code>myBuilder.transparence(50)</code></td>
	 *            <td><img alt="" src="./doc-files/b_transparence50.png"></td>
	 *            </tr>
	 *            <tr>
	 *            <td><code>myBuilder.transparence(75)</code></td>
	 *            <td><img alt="" src="./doc-files/b_transparence75.png"></td>
	 * 
	 *            <td><code>myBuilder.transparence(100)</code></td>
	 *            <td><img alt="" src="./doc-files/b_transparence100.png"></td>
	 *            <td colspan="2">-</td>
	 *            </tr>
	 *            </table>
	 * @return The builder itself (fluent interface pattern).
	 */
	B transparence(double tranparence);

	/**
	 * Aligns the primitive (shape, text or image) relative to its enclosing
	 * bounding box.
	 *
	 * @param horizontalAlign
	 *            The horizontal alignment.
	 * @param verticalAlign
	 *            The vertical alignment.<br>
	 *            <br>
	 *            <br>
	 *            Examples:<br>
	 *            <table summary="">
	 *            <tr>
	 *            <td><code>myBuilder.align(LEFT, TOP) </code></td>
	 *            <td><img alt="" src="./doc-files/b_alignLeftTop.png"></td>
	 *            <td><code>myBuilder.align(CENTER, TOP)</code></td>
	 *            <td><img alt="" src="./doc-files/b_alignCenterTop.png"></td>
	 *            <td><code>myBuilder.align(RIGHT, TOP) </code></td>
	 *            <td><img alt="" src="./doc-files/b_alignRightTop.png"></td>
	 *            </tr>
	 *            <tr>
	 *            <td>
	 * 
	 *            <code>myBuilder.align(LEFT, MIDDLE)</code></td>
	 *            <td><img alt="" src="./doc-files/b_alignLeftMiddle.png"></td>
	 *            <td><code>myBuilder.align(CENTER, MIDDLE) </code></td>
	 *            <td><img alt="" src="./doc-files/b_alignCenterMiddle.png">
	 *            </td>
	 *            <td><code>myBuilder.align(RIGHT, MIDDLE) </code></td>
	 *            <td><img alt="" src="./doc-files/b_alignRightMiddle.png"></td>
	 *            </tr>
	 *            <tr>
	 *            <td><code>myBuilder.align(LEFT, BOTTOM) </code></td>
	 *            <td><img alt="" src="./doc-files/b_alignLeftBottom.png"></td>
	 *            <td><code>myBuilder.align(CENTER, BOTTOM) </code></td>
	 *            <td><img alt="" src="./doc-files/b_alignCenterBottom.png">
	 *            </td>
	 *            <td><code>myBuilder.align(RIGHT, BOTTOM) </code></td>
	 *            <td><img alt="" src="./doc-files/b_alignRightBottom.png"></td>
	 *            </tr>
	 *            </table>
	 * @return The builder itself (fluent interface pattern).
	 */
	B align(HorizontalAlign horizontalAlign, VerticalAlign verticalAlign);

	/**
	 * Offsets the primitive in x as well as in y axis direction.<br>
	 * <br>
	 * Example:<br>
	 * original primitive
	 * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.offset(.25, .5) = <img alt="" src="./doc-files/b_offsetXY.png"></code>
	 *
	 * @param offsetX
	 *            The x offset in drawing units.
	 * @param offsetY
	 *            The y offset in drawing units.
	 * @return The builder itself (fluent interface pattern).
	 */
	B offset(double offsetX, double offsetY);

	/**
	 * Offsets the primitive in x axis direction.
	 *
	 * @param offsetX
	 *            The x offset in drawing units.<br>
	 *            <br>
	 *            Example:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.offsetX(0.25) = <img alt="" src="./doc-files/b_offsetX.png"></code>
	 * @return The builder itself (fluent interface pattern).
	 */
	B offsetX(double offsetX);

	/**
	 * Offsets the primitive in y axis direction.
	 *
	 * @param offsetY
	 *            The y offset in drawing units.<br>
	 *            <br>
	 *            Example:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.offsetY(.25) = <img alt="" src="./doc-files/b_offsetY.png"></code>
	 * @return The builder itself (fluent interface pattern).
	 */
	B offsetY(double offsetY);

	/**
	 * Scales the primitive with the given scale factor in x and y direction.
	 * direction.
	 *
	 * @param scaleFactor
	 *            The scale factor. <br>
	 *            <br>
	 *            Example:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.scale(1.7) = <img alt="" src="./doc-files/b_scale.png"></code>
	 * @return The builder itself (fluent interface pattern).
	 */
	B scale(double scaleFactor);

	/**
	 * Scales the primitive with the given scale factor in x and y direction.
	 * direction.<br>
	 * <br>
	 * Example:<br>
	 * original primitive
	 * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.scaleX(1.7,2.8) = <img alt="" src="./doc-files/b_scaleXY.png"></code>
	 *
	 * @param scaleX
	 *            The scale factor in x direction.
	 * @param scaleY
	 *            The scale factor in y direction.
	 * @return The builder itself (fluent interface pattern).
	 */
	B scale(double scaleX, double scaleY);

	/**
	 * Scales the primitive with the given scale factor in x direction.
	 *
	 * @param scaleX
	 *            The scale factor in x direction.<br>
	 *            <br>
	 *            Example:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.scaleX(1.7) = <img alt="" src="./doc-files/b_scaleX.png"></code>
	 * @return The builder itself (method chaining pattern).
	 */
	B scaleX(double scaleX);

	/**
	 * Scales the primitive with the given scale factor in y direction.
	 *
	 * @param scaleY
	 *            The scale factor in y direction <br>
	 *            <br>
	 *            Example:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.scaleX(1.7) = <img alt="" src="./doc-files/b_scaleY.png"></code>
	 * @return The builder itself (fluent interface pattern).
	 */
	B scaleY(double scaleY);

	/**
	 * Sets the angle units. It allows to override individual the default angle
	 * units.
	 *
	 * @param angleUnits
	 *            The angle units.
	 * @return The builder itself (fluent interface pattern).
	 */
	B unit(Angle angleUnits);

	/**
	 * Sets the transparency units. It allows to override individual the default
	 * transparency units.
	 *
	 * @param transparenceUnits
	 *            The transparency units.
	 * @return The builder itself (fluent interface pattern).
	 */
	B unit(Transparence transparenceUnits);

	/**
	 * Sets the rotation in the configured angular units.
	 *
	 * @param rotation
	 *            The rotation in angle units.<br>
	 *            <br>
	 *            Example 1:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.rotate(30) = <img alt="" src="./doc-files/b_rotate30Degrees.png"></code>
	 *            <br>
	 *            <br>
	 *            Example 2:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.roate(70) = <img alt="" src="./doc-files/b_rotate70Degrees.png"></code>
	 * @return The builder itself (fluent interface pattern).
	 */
	B rotate(double rotation);

	/**
	 * Sets the x and y coordinate of the point(s) center in map units. If this
	 * method is called more than once the primitive represents a multipoint.
	 *
	 * @param x
	 *            The x coordinate of the point in map units.
	 * @param y
	 *            The y coordinate of the point in map units.
	 * @return The builder itself (fluent interface pattern).
	 */
	B center(double x, double y);

	/**
	 * Sets the x and y coordinate of the point(s) center relative to the
	 * previous drawn primitive. If this method is called more than once the
	 * primitive represents a multipoint.
	 *
	 *
	 * @param x
	 *            The horizontal coordinate relative to the last previous drawn
	 *            primitive.
	 * @param y
	 *            The vertical coordinate relative to the last previous drawn
	 *            primitive.
	 * @return The builder itself (fluent interface pattern).
	 */
	B center(HorizontalAlign x, VerticalAlign y);

	/**
	 * Sets the x and y coordinate of the point(s) center relative to the
	 * previous drawn. If this method is called more than once the primitive
	 * represents a multipoint.
	 *
	 * @param x
	 *            The horizontal coordinate relative to the last previous drawn
	 *            primitive.
	 * @param y
	 *            The y coordinate of the point in map units.
	 * @return The builder itself (fluent interface pattern).
	 */
	B center(HorizontalAlign x, double y);

	/**
	 * Sets the point(s) center relative to the last previous drawn primitive.
	 * If this method is called more than once the primitive represents a
	 * multipoint.
	 *
	 * @param x
	 *            The x coordinate of the point in map units.
	 * @param y
	 *            The vertical coordinate relative to the last previous drawn
	 *            shape.
	 * @return The builder itself (fluent interface pattern).
	 */
	B center(double x, VerticalAlign y);

	@Override
	Drawable<S, P> build();

}
