package org.openmap4u.primitive;

import java.awt.Shape;

public interface ShapeBuildable<T extends LineStringBuildable<T>> extends
		LineStringBuildable<T> {

	/**
	 * Adds the provided shape to the primitive.
	 *
	 * @param shape
	 *            The shape to add.<br>
	 * <br>
	 *            Example:<br>
	 *            <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).add(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_add.png"></code>
	 * @return The builder itself (method chaining pattern).
	 */
	T add(Shape shape);

	/**
	 * Intersects the primitive with the provided shape.
	 *
	 * @param shape
	 *            The shape to intersect.<br>
	 * <br>
	 *            Example:<br>
	 *            <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).intersect(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_intersect.png"></code>
	 * @return The builder itself (method chaining pattern).
	 */
	T intersect(Shape shape);

	/**
	 * Subtracts the primitive with the provided shape.
	 *
	 * @param shape
	 *            The shape to subtract.<br>
	 * <br>
	 *            Example:<br>
	 *            <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).subtract(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_subtract.png"></code>
	 * @return The builder itself (method chaining pattern).
	 */
	T subtract(Shape shape);

	/**
	 * Exclusive or the primitive with the given shape.
	 *
	 * @param shape
	 *            The shape to exclusive or. <br>
	 * <br>
	 *            Example:<br>
	 *            <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).eclusiveOr.(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_exclusiveOr.png"></code>
	 * @return The builder itself (method chaining pattern).
	 */
	T exclusiveOr(Shape shape);

}
