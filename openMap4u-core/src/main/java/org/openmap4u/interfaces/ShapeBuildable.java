package org.openmap4u.interfaces;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public interface ShapeBuildable<B extends ShapeBuildable<B>> extends LineBuildable<B> {
	

    /**
     * Sets the primitive shape (and overrides every already existing shapes).
     *
     * @param shape The awt shape geometry.<br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">) = <img alt="" src="./doc-files/c_rectangle.png"></code>
     * @return The Shape itself (method chaining pattern).
     */
 B shape(Shape shape);

    /**
     * Adds the provided shape to the primitive.
     *
     * @param shape The shape to add.<br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).add(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_add.png"></code>
     * @return The builder itself (method chaining pattern).
     */
     B add(Shape shape);

    /**
     * Intersects the primitive with the provided shape.
     *
     * @param shape The shape to intersect.<br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).intersect(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_intersect.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    B intersect(Shape shape);

    /**
     * Subtracts the primitive with the provided shape.
     *
     * @param shape The shape to subtract.<br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).subtract(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_subtract.png"></code>
     * @return The builder itself (method chaining pattern).
     */

   B subtract(Shape shape) ;

    /**
     * Exclusive or the primitive with the given shape.
     *
     * @param shape The shape to exclusive or. <br>
     * <br>
     * Example:<br>
     * <code>... myBuilder.shape(<img alt="" src="./doc-files/c_rectangle.png">).eclusiveOr.(<img alt="" src="./doc-files/c_circle.png">) = <img alt="" src="./doc-files/c_exclusiveOr.png"></code>
     * @return The builder itself (method chaining pattern).
     */
  B exclusiveOr(Shape shape);

}
