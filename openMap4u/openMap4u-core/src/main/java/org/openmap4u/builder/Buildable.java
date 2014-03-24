package org.openmap4u.builder;

import java.awt.Shape;
import java.util.Set;
import org.openmap4u.commons.Angle;
import org.openmap4u.commons.Drawable;
import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.Plugable;
import org.openmap4u.commons.Point;

import org.openmap4u.commons.Styleable;
import org.openmap4u.commons.Transparence;
import org.openmap4u.commons.VerticalAlign;

/**
 * All builders are derived from this base class.
 *
 * @author Michael Hadrbolec
 * @param <S> The style type.
 * @param <B> The builder type.
 */
public interface Buildable<S extends Styleable<S>, B extends Buildable<S, B>> extends Drawable<S>, Plugable {

    /**
     * Gets the points (in the case the pimitives represents one or more
     * point(s)) or null in the case the primitive is not a point.
     *
     * @return The points.
     */
    Set<Point<?, ?>> getPoints();

    Shape getPreviousShape();

    /**
     * Is called before the drawable is drawn.
     *
     * @param previousDrawnShape The previous drawn shape (or in the case it is
     * the first primitive a new Rectangle2D.Double() instance).
     */
    void setUp(Shape previousDrawnShape);

    /**
     * Sets whether the primitive is drawn (is visible = true) or not (is not
     * visible = false).
     *
     * @param isVisible The visibility.
     * @return The builder itself.
     */
    B visible(boolean isVisible);

    /**
     * Sets the transparence.
     *
     * @param tranparence The transparence.<br>
     * <code>myBuilder.transparence(0)=<img alt="" src="./doc-files/b_transparence0.png"></code>,
     * <code>myBuilder.transparence(25)=<img alt="" src="./doc-files/b_transparence25.png"></code>,
     * <code>myBuilder.transparence(50)=<img alt="" src="./doc-files/b_transparence50.png"></code>,
     * <code>myBuilder.transparence(75)=<img alt="" src="./doc-files/b_transparence75.png"></code>,
     * <code>myBuilder.transparence(100)=<img alt="" src="./doc-files/b_transparence100.png"></code>.
     * @return The builder itself (fluent interface pattern).
     */
    B transparence(double tranparence);

    /**
     * Aligns the primitive (shape, text or image) relative to its enclosing
     * bounding box..
     *
     * @param horizontalAlign The horizontal alignment.
     * @param verticalAlign The vertical alignment.
     * <code>myBuilder.align(LEFT, TOP) = <img alt="" src="./doc-files/b_alignLeftTop.png"></code>,
     * <code>myBuilder.align(CENTER, TOP) = <img alt="" src="./doc-files/b_alignCenterTop.png"></code>,
     * <code>myBuilder.align(RIGHT, TOP) = <img alt="" src="./doc-files/b_alignRightTop.png"></code><br>,
     * <code>myBuilder.align(LEFT, MIDDLE) = <img alt="" src="./doc-files/b_alignLeftMiddle.png"></code>,
     * <code>myBuilder.align(CENTER, MIDDLE) = <img alt="" src="./doc-files/b_alignCenterMiddle.png"></code>,
     * <code>myBuilder.align(RIGHT, MIDDLE) = <img alt="" src="./doc-files/b_alignRightMiddle.png"></code>,
     * <code>myBuilder.align(LEFT, BOTTOM) = <img alt="" src="./doc-files/b_alignLeftBottom.png"></code>,
     * <code>myBuilder.align(CENTER, BOTTOM) = <img alt="" src="./doc-files/b_alignCenterBottom.png"></code>,
     * <code>myBuilder.align(RIGHT, BOTTOM) = <img alt="" src="./doc-files/b_alignRightBottom.png"></code>.
     * @return The builder itself (fluent interface pattern).
     */
    B align(HorizontalAlign horizontalAlign, VerticalAlign verticalAlign);

    /**
     * Sets the offset in darwing units in x and y direction.<br>
     * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.offset(.25, .5) = <img alt="" src="./doc-files/b_offsetXY.png"></code>
     *
     * @param offsetX The x offset in drawing units.
     * @param offsetY The y offset in drawing units.
     * @return The builder itself (fluent interface pattern).
     */
    B offset(double offsetX, double offsetY);

    /**
     * Sets the x offset in drawing units.
     *
     * @param offsetX The x offset in drawing units.<br>
     * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.offsetX(0.25) = <img alt="" src="./doc-files/b_offsetX.png"></code>
     * @return The builder itself (fluent interface pattern).
     */
    B offsetX(double offsetX);

    /**
     * Sets the y offset in drawing units.
     *
     * @param offsetY The y offset in drawing units.<br>
     * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.offsetY(.25) = <img alt="" src="./doc-files/b_offsetY.png"></code>
     * @return The builder itself (fluent interface pattern).
     */
    B offsetY(double offsetY);

    /**
     * Sets the sacle factor. This means the same scale factor in x and y
     * direction.
     *
     * @param scaleFactor The scale factor. <br>
     * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.scale(1.7) = <img alt="" src="./doc-files/b_scale.png"></code>
     * @return The builder itself (fluent interface pattern).
     */
    B scale(double scaleFactor);

    /**
     * Allows to scale the primitive with a different factor in x and y
     * direction.<br>
     * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.scaleX(1.7,2.8) = <img alt="" src="./doc-files/b_scaleXY.png"></code>
     *
     * @param scaleX The scale factor in x direction.
     * @param scaleY The scale factor in y direction.
     * @return The builder itself (fluent interface pattern).
     */
    B scale(double scaleX, double scaleY);

    /**
     * Sets the scale factor in x direction.
     *
     * @param scaleX The scale factor in x direction.<br>
     * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.scaleX(1.7) = <img alt="" src="./doc-files/b_scaleX.png"></code>
     * @return The builder itself (method chaining pattern).
     */
    B scaleX(double scaleX);

    /**
     * Sets the scale factor in y direction.
     *
     * @param scaleY The scale factor in y direction <br>
     * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.scaleX(1.7) = <img alt="" src="./doc-files/b_scaleY.png"></code>
     * @return The builder itself (fluent interface pattern).
     */
    B scaleY(double scaleY);

    /**
     * Sets the angle units. It allows to override individual the default angle
     * units.
     *
     * @param angleUnits The angle units.
     * @return The builder itself (fluent interface pattern).
     */
    B unit(Angle angleUnits);

    /**
     * Sets the transparence units. It allows to override the default
     * transparence units.
     *
     * @param transparenceUnits The transparence units.
     * @return The builder itself (fluent interface pattern).
     */
    B unit(Transparence transparenceUnits);

    /**
     * Sets the rotation in angle units.
     *
     * @param rotation The rotation in angle units.<br>
     * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.rotate(30) = <img alt="" src="./doc-files/b_rotate30Degrees.png"></code><br>
     * <code><img alt="" src="./doc-files/b_initial.png"> myBuilder.roate(70) = <img alt="" src="./doc-files/b_rotate70Degrees.png"></code>
     * @return The builder itself (fluent interface pattern).
     */
    B rotate(double rotation);

    /**
     * Sets the x and y coordinate of the point. If this method is called
     * mutliple times the primitive represents a multipoint.
     *
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @return The builder itself (fluent interface pattern).
     */
    B point(double x, double y);

    /**
     * Sets the x and y coordinate of the point relative to the previous drawn
     * shape.
     *
     * @param x The horizontal coordinate relative to the last previous drawn primitive.
    * @param y The vertical coordinate relative to the last previous drawn primitive.
      * @return The builder itself (fluent interface pattern).
     */
    B point(HorizontalAlign x, VerticalAlign y);

    /**
     * Sets the x and y coordinate of the point relative to the previous drawn
     *
     * @param x The horizontal coordinate relative to the last previous drawn primitive.
     * @param y The y coordinate of the point in map units.
     * @return The builder itself (fluent interface pattern).
     */
    B point(HorizontalAlign x, double y);

    /**
     * Sets the point relative to the last previous drawn primitive.
     *
     * @param x The x coordinate of the point in map units.
     * @param y The vertical coordinate relative to the last previous drawn
     * shape.
     * @return The builder itself (fluent interface pattern).
     */
    B point(double x, VerticalAlign y);

    /**
     * Wheter it is a point (=true) or not (=false).
     *
     * @return Wheter it is a point (=true) or not (=false).
     */
    boolean isPoint();

    /**
     * Cleanup code.
     */
    void tearDown();

}
