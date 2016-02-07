package org.openmap4u.transform;

import org.openmap4u.geom.Point;

public interface PrimitiveTransformBuildable<T extends PrimitiveTransformBuildable<T >> extends TransformBuildable<T>   {

	T verticalAlign(VerticalAlign verticalAlign);
	
	T horizontalAlign(HorizontalAlign horizontalAlign);

	/**
	 * Offsets the primitive in x as well as in y axis direction.<br>
	 * <br>
	 * Example:<br>
	 * original primitive
	 * <code><img alt="" src="./doc-files/offset.png"> myBuilder.offset(new Point(.25, .5)) = <img alt="" src="./doc-files/b_offsetXY.png"></code>
	 *
	 * @param offset
	 *            The offset in drawing units.
	 * @return The builder itself (fluent interface pattern).
	 */
	T offset(Point offset);

}
