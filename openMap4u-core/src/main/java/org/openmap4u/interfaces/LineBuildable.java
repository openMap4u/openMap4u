package org.openmap4u.interfaces;

public interface LineBuildable<B extends LineBuildable<B>> {

	/**
	 * Draws a bezier curve to the given point based on two control points.
	 *
	 * @param cp1X
	 *            The x coordinate of the first control point (red).
	 * @param cp1Y
	 *            The y coordinate of the first control point (red).
	 * @param cp2X
	 *            The x coordinate of the second control point (blue).
	 * @param cp2Y
	 *            The y coordinate of the second control point (blue).
	 * @param toX
	 *            The x coordinate (blue).
	 * @param toY
	 *            The y coordinate (blue). <br>
	 *            <br>
	 *            Example: Draws from the last point (red) via two controll
	 *            points (red = from, blue = to), to the given point(blue).<br>
	 *            <table summary="">
	 *            <tr>
	 *            <td>
	 *            <code>myBuilder.bezierTo(0.75, 1.375,1.0, .125,1.25, 0.75)</code>
	 *            =</td>
	 *            <td><img alt="" src="./doc-files/bezier1.png"></td>
	 *            <td>... other example
	 *            <img alt="" src="./doc-files/bezier2.png"></td>
	 *            <td>and another example
	 *            <img alt="" src="./doc-files/bezier3.png"></td>
	 *            </tr>
	 *            </table>
	 * @return The builder itself (fluent interface pattern).
	 */
	B bezierTo(double cp1X, double cp1Y, double cp2X, double cp2Y, double toX, double toY);

	/**
	 * Draws a straight line from the last path point to the provided point in
	 * map units.
	 *
	 * @param toX
	 *            The x coordinate where to draw to.
	 * @param toY
	 *            The y coordinate where to draw to.<br>
	 *            <br>
	 *            Example: Draws from the last point (red) to the given
	 *            point(blue).<br>
	 *            <code>myBuilder.lineTo(1.0,1.1)</code>=
	 *            <img alt="" src="./doc-files/lineTo.png">
	 * @return The builder itself (fluent interface pattern).
	 */
	B lineTo(double toX, double toY);

	/**
     * Moves the path to the given point without drawing anything. It is used to
     * move the "pencil" to the point, where you want to start-, or where you
     * want to continue to draw.
     *
     * @param toX The x coordinate, where you start -, or where you continue to
     * draw.
     * @param toY The y coordinate, where you start -, or where you continue to
     * draw.
     * <br><br>Example: <br>
     * <code>myBuilder.moveTo(1.0,1.1)</code>= displays nothing (just moves the
     * pen).
     */
    B moveTo(double toX, double toY);
	/**
     * Draws a quadratic curve from the last drawn (red) -, with the help of a
     * control (gray) -, to the end point (blue).
     *
     * @param cpX The x coordinate of the control point (gray).
     * @param cpY The y coordinate of the control point (gray).
     * @param toX The end x coordinate (blue).
     * @param toY The end y coordinate (blue).
     * <br><br>Example: Draws from the last point (red) to the given point(blue)
     * using te controll point (gray).<br>
     * <code>myBuilder.quadTo(.5,1.0,1.0,0.7)</code>= <img alt=""
     * src="./doc-files/quadTo.png">
     * @return The builder itself (fluent interface pattern).
     */
     B quadTo(double cpX, double cpY, double toX, double toY) ;

}
