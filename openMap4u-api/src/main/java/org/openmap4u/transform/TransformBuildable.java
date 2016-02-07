package org.openmap4u.transform;

import java.awt.geom.AffineTransform;

import org.openmap4u.builder.Buildable;
import org.openmap4u.geom.BBox;

public interface TransformBuildable<T extends TransformBuildable<T>> {

	/**
	 * The default scale factor.
	 */
	double DEFAULT_SCALE = 1;

	/**
	 * The default rotation angle..
	 */
	double DEFAULT_ROTATION = 0;

	/**
	 * Sets the rotation in the configured angular units.
	 *
	 * @param rotation
	 *            The rotation in angle units.<br>
	 * <br>
	 *            Example:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/initial.png"> myBuilder.rotate(30) = <img alt="" src="./doc-files/rotate30Degrees.png"></code>
	 * <br>
	 * @return The builder itself (fluent interface pattern).
	 */
	T rotate(double rotation);

	/**
	 * Scales the primitive with the given scale factor in x and y direction.
	 *
	 * @param scaleFactor
	 *            The scale factor. <br>
	 * <br>
	 *            Example:<br>
	 *            original primitive
	 *            <code><img alt="" src="doc-files/initial.png"> myBuilder.scale(1.7) = <img alt="" src="doc-files/scaleXY.png"></code>
	 * @return The builder itself (fluent interface pattern).
	 */
	T scale(double scaleFactor);

	/**
	 * Scales the primitive with the given scale factor in x direction.
	 *
	 * @param scaleX
	 *            The scale factor in x direction.<br>
	 * <br>
	 *            Example:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/initial.png"> myBuilder.scaleX(1.7) = <img alt="" src="./doc-files/scaleX.png"></code>
	 * @return The builder itself (method chaining pattern).
	 */
	T scaleX(double scaleX);

	/**
	 * Scales the primitive with the given scale factor in y direction.
	 *
	 * @param scaleY
	 *            The scale factor in y direction <br>
	 * <br>
	 *            Example:<br>
	 *            original primitive
	 *            <code><img alt="" src="./doc-files/initial.png"> myBuilder.scaleX(1.7) = <img alt="" src="./doc-files/scaleY.png"></code>
	 * @return The builder itself (fluent interface pattern).
	 */
	T scaleY(double scaleY);
	
	T bBox(BBox bBox);

}
