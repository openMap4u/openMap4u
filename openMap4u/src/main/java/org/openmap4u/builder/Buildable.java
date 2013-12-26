package org.openmap4u.builder;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Plugable;
import org.openmap4u.commons.Position;
import org.openmap4u.primitive.Drawable;
import org.openmap4u.style.Styleable;

import org.openmap4u.unit.Angle;
import org.openmap4u.unit.Transparence;

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
    public Set<Object> getPoints();

    /**
     * Is called before the drawable is drawn.
     *
     * @param previousDrawnShape The previous drawn shape (or in the case it is
     * the first primitive a new Rectangle2D.Double() instance).
     */
    public void setUp(Shape previousDrawnShape);

    /**
     * Sets whether the primitive is drawn (is visible = true) or not (is
     * not visible = false).
     *
     * @param isVisible The visibility.
     * @return The builder itself.
     */
    public B visible(boolean isVisible);

    /**
     * Sets the transparence.
     *
     * @param tranparence The transparence.<br>
     * <code>myBuilder.transparence(0)=<img alt="" src="./doc-files/b_transparence0.png"></code><br>
     * <code>myBuilder.transparence(25)=<img alt="" src="./doc-files/b_transparence25.png"></code><br>
     * <code>myBuilder.transparence(50)=<img alt="" src="./doc-files/b_transparence50.png"></code><br>
     * <code>myBuilder.transparence(75)=<img alt="" src="./doc-files/b_transparence75.png"></code><br>
     * <code>myBuilder.transparence(100)=<img alt="" src="./doc-files/b_transparence100.png"></code><br>
     * @return The builder itself (method chaining pattern).
     */
    public B transparence(double tranparence);

    /**
     * Aligns the primitive (shape, text or image).
     *
     * @param align How to align the primitive <br>
     * <code>myBuilder.align(Position.LeftTop) = <img alt="" src="./doc-files/b_alignLeftTop.png"></code><br>
     * <code>myBuilder.align(Position.CenterTop) = <img alt="" src="./doc-files/b_alignCenterTop.png"></code><br>
     * <code>myBuilder.align(Position.RightTop) = <img alt="" src="./doc-files/b_alignRightTop.png"></code><br>
     * <code>myBuilder.align(Position.LeftMiddle) = <img alt="" src="./doc-files/b_alignLeftMiddle.png"></code><br>
     * <code>myBuilder.align(Position.CenterMiddle) = <img alt="" src="./doc-files/b_alignCenterMiddle.png"></code><br>
     * <code>myBuilder.align(Position.RightMiddle) = <img alt="" src="./doc-files/b_alignRightMiddle.png"></code><br>
     * <code>myBuilder.align(Position.LeftBottom) = <img alt="" src="./doc-files/b_alignLeftBottom.png"></code><br>
     * <code>myBuilder.align(Position.CenterBottom) = <img alt="" src="./doc-files/b_alignCenterBottom.png"></code><br>
     * <code>myBuilder.align(Position.RightBottom) = <img alt="" src="./doc-files/b_alignRightBottom.png"></code><br>
     * @return The builder itself (method chaining pattern).
     */
    B align(Position align);

    /**
     * Sets the offset in darwing units <img alt=""
     * src="./doc-files/ShapeBuilder_offset.png">.
     *
     * @param offsetX The x offset in drawing units <img alt=""
     * src="./doc-files/ShapeBuilder_translate_x.png">.
     * @param offsetY The y offset in drawing units <img alt=""
     * src="./doc-files/ShapeBuilder_translate_y.png">.
     * @return The builder itself (method chaining pattern).
     */
    B offset(double offsetX, double offsetY);

    /**
     * Sets the x offset in drawing units.
     *
     * @param offsetX The x offset in drawing units <img alt="" 
     * src="./doc-files/ShapeBuilder_translate_x.png">.
     * @return The builder itself (method chaining pattern).
     */
    B offsetX(double offsetX);

    /**
     * Sets the y offset in drawing units.
     *
     * @param offsetY The y offset in drawing units <img alt=""
     * src="./doc-files/ShapeBuilder_translate_y.png">.
     * @return The builder itself (method chaining pattern).
     */
    B offsetY(double offsetY);

    /**
     * Sets the sacle factor. This means the same scala factor is set for x and
     * y direction.
     *
     * @param scaleFactor The scale factor.
     * @return The builder itself (method chaining pattern).
     */
    B scale(double scaleFactor);

    /**
     * Scales the primitive in x and y direction <img alt=""
     * src="./doc-files/ShapeBuilder_scale.png">
     *
     * @param scaleX The scale factor in x direction.
     * @param scaleY The scale factor in y direction.
     * @return The builder itself (method chaining pattern).
     */
    B scale(double scaleX, double scaleY);

    /**
     * Sets the scale factor in x direction.
     *
     * @param scaleX The scale factor in x direction.
     * @return The builder itself (method chaining pattern).
     */
    B scaleX(double scaleX);

    /**
     * Sets the scale factor in y direction.
     *
     * @param scaleY The scale factor in y direction <img alt=""
     * src="./doc-files/ShapeBuilder_initial.png"><img alt=""
     * src="./doc-files/ShapeBuilder_scale_y.png">.
     * @return The builder itself (method chaining pattern).
     */
    B scaleY(double scaleY);

    /**
     * Sets the angle units. It allows to override individual the default angle
     * units.
     *
     * @param angleUnits The angle units.
     * @return The builder itself (method chaining pattern).
     */
    B unit(Angle angleUnits);

    /**
     * Sets the transparence units. It allows to override the default
     * transparence units.
     *
     * @param transparenceUnits The transparence units.
     * @return The builder itself (method chaining pattern).
     */
    B unit(Transparence transparenceUnits);

    /**
     * Sets the rotation in angle units.
     *
     * @param rotation The rotation in angle units. e.g. 30 degrees <img alt=""
     * src="./doc-files/ShapeBuilder_rotate">.
     * @return The builder itself (method chaining pattern).
     */
    B rotate(double rotation);

    /**
     * Sets the x and y coordinate of the point. If this method is called mutliple times the primitive represents a multipoint.
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
    * @return The builder itself (method chaining pattern).
     */
    B point(double x, double y);

   /**
     * Sets the x and y coordinate of the point relative to the previous drawn shape.
     * @param position The relative position to the previous drawn shape.
    * @return The builder itself (method chaining pattern).
     */
    B point(Position position);

    /**
     * Wheter it is a point (=true) or not (=false).
     *
     * @return Wheter it is a point (=true) or not (=false).
     */
    boolean isPoint();

    /**
     * Cleanup code.
     */
    public void tearDown();

}
