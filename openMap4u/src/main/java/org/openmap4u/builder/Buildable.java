package org.openmap4u.builder;

import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.Plugable;
import org.openmap4u.commons.VerticalAlign;
import org.openmap4u.primitive.Primitive;
import org.openmap4u.style.Styleable;

/**
 * All builders are derived from this base interface.
 * 
 * @author Michael Hadrbolec
 * @param <T> The type of the primitive.
 * @param <S> The type of the primitive style.
 * @param <B> The type of the builder.
 */
public interface Buildable<T, S extends Styleable<S>, B extends Buildable<T, S,B >>
        extends Primitive<T, S>,Plugable  {

    /**
     * Sets whether the primitive is visible or not. It is an optional property,
     * whose default value is <code>true</code>.
     * 
     * @param isVisible
     *            Whether the primitive is visible (<code>true</code>) or not (
     *            <code>false</code>).
     * @return The Buildable itself (method chaining pattern).
     */
    B visible(boolean isVisible);

    /**
     * Checks whether the primitive is visible (which means either the
     * visibility is set to <code>false</code> or the primitive is complete
     * transparent).
     * 
     * @return <ul>
     *         <li><code>true</code> ... the primitive is visible.</li>
     *         <li><code>false</code> ... the primitive is not visible.</li>
     *         </ul>
     */
    boolean isVisible();

    /**
     * Sets the transparency of the primitive ( <code>0</code> is complete solid
     * [=not transparent at all], <code>100</code> is complete transparent [=not
     * visible at all]).
     * 
     * @param tranparence
     *            The transparency of the primitive (in percent).
     *            <ul>
     *            <li><img src="doc-files/transparency_100_percent.png"/> ...
     *            <code>100</code> (=complete) transparent, which means the
     *            primitive is not drawn. But keep in mind although you don't
     *            see the element it has to be drawn anyway.</li>
     *            <li><img src="doc-files/transparency_66_percent.png"/>...
     *            <code>66</code> transparent.</li>
     *            <li><img src="doc-files/transparency_33_percent.png"/>...
     *            <code>33</code>% transparent.</li>
     * 
     *            <li><img
     *            src="doc-files/transparency_0_percent.png"/>... <code>0</code>% transparent
     *            (=solid), which means the primitive is drawn complete solid
     *            (not transparent at all).</li></ul>
     * @return The Buildable itself (method chaining pattern).
     */
    B transparence(double tranparence);

    /**
     * Sets the offset of the primitive drawing units.<br/>
     * <span>Primitive <img src="doc-files/ShapeBuilder_translate_initial.png"/>
     * + offsetX <img src="doc-files/ShapeBuilder_translate_x.png"/> +offsetY
     * <img src="doc-files/ShapeBuilder_translate_y.png"/> = <img
     * src="doc-files/ShapeBuilder_scale_result.png"/></span>
     * 
     * @param offsetX
     *            The offset in x axis direction. <img
     *            src="doc-files/ShapeBuilder_translate_initial.png"/> offsetX
     *            <img src="doc-files/ShapeBuilder_translate_x.png"/>
     * 
     * @param offsetY
     *            The offset in y axis direction. <img
     *            src="doc-files/ShapeBuilder_translate_initial.png"/> offsetX
     *            <img src="doc-files/ShapeBuilder_translate_y.png"/>
     * 
     * @return The Buildable itself (method chaining pattern).
     */
    B offset(double offsetX, double offsetY);

    /**
     * Sets the  x offset of the primitive drawing units.<br/>
     * <span>Primitive <img src="doc-files/ShapeBuilder_translate_initial.png"/>
     * + offsetX  = <img src="doc-files/ShapeBuilder_translate_x.png"/> </span>
     * 
      * @param offsetX
     *            The offset in x axis direction. <img
     *            src="doc-files/ShapeBuilder_translate_initial.png"/> offsetX
     *            <img src="doc-files/ShapeBuilder_translate_x.png"/>
     * 
      * @return The Buildable itself (method chaining pattern).
     */
    B offsetX(double offsetX);

    /**
     * Sets the y offset of the primitive drawing units.<br/>
     * <span>Primitive <img src="doc-files/ShapeBuilder_translate_initial.png"/>
     *  + offsetY = 
     * <img src="doc-files/ShapeBuilder_translate_y.png"/> </span>
     * 
     * @param offsetY
     *            The offset in y axis direction. <img
     *            src="doc-files/ShapeBuilder_translate_initial.png"/> offsetX
     *            <img src="doc-files/ShapeBuilder_translate_y.png"/>
     * 
     * @return The Buildable itself (method chaining pattern).
     */
    B offsetY(double offsetY);

    /**
     * Sets a constant scale factor for x as well as for y axis direction.<br/>
     * <span>Primitive <img src="doc-files/ShapeBuilder_scale_initial.png"/> +
     * scaleX (=scaleY) <img src="doc-files/ShapeBuilder_scale_x.png"/> + scaleY
     * (=scaleX) <img src="doc-files/ShapeBuilder_scale_y.png"/> = <img
     * src="doc-files/ShapeBuilder_scale_result.png"/></span>
     * 
     * <ul>
     * <li><code>0.5</code>... means half size.</li>
     * <li><code>1</code>... means no scaling at all (is default value).</li>
     * <li><code>2</code>... means double size.</li> </u>
     * 
     * @param scaleFactor
     *            The constant scale factor for x as well as for y axis
     *            direction.
     * @return The Buildable itself (method chaining pattern).
     */
    B scale(double scaleFactor);

    /**
     * Sets the scale factor in x and y axis direction.<br/>
     * <span>Primitive <img src="doc-files/ShapeBuilder_scale_initial.png"/> +
     * scaleX <img src="doc-files/ShapeBuilder_scale_x.png"/> + scaleY <img
     * src="doc-files/ShapeBuilder_scale_y.png"/> = <img
     * src="doc-files/ShapeBuilder_scale_result.png"/></span>
     * <ul>
     * <li><code>0.5</code>... means half size.</li>
     * <li><code>1</code>... means no scaling at all (is default value).</li>
     * <li><code>2</code>... means double size.</li> </u> </u>
     * 
     * @param scaleX
     *            The scale factor in x axis direction. <img
     *            src="doc-files/ShapeBuilder_scale_initial.png"/> scaleX <img
     *            src="doc-files/ShapeBuilder_scale_x.png"/>
     * @param scaleY
     *            The scale factor in y axis direction. <img
     *            src="doc-files/ShapeBuilder_scale_initial.png"/> scaleX <img
     *            src="doc-files/ShapeBuilder_scale_y.png"/>
     * @return The Buildable itself (method chaining pattern).
     */
    B scale(double scaleX, double scaleY);

    /**
     * Sets the scale factor in x axis direction.
     * 
     * @param scaleX
     *            The scale factor in x axis direction. <img
     *            src="doc-files/ShapeBuilder_scale_initial.png"/> scaleX <img
     *            src="doc-files/ShapeBuilder_scale_x.png"/>
     * @return The Buildable itself (method chaining pattern).
     */
    B scaleX(double scaleX);

    /**
     * Sets the scale factor in x axis direction.
     * 
     * @param scaleY
     *            The scale factor in y axis direction. <img
     *            src="doc-files/ShapeBuilder_scale_initial.png"/> scaleY <img
     *            src="doc-files/ShapeBuilder_scale_y.png"/>
     * @return The Buildable itself (method chaining pattern).
     */
    B scaleY(double scaleY);

    /**
     * Sets the primitives alignment in horizontal (= x axis) and vertical(= y
     * axis) direction.
     * 
     * @param horizontalAlign
     *            The horizontal alignment (= x axis direction).
     * @param verticalAlign
     *            The vertical alignment (= y axis direction).
     * @return The ShapeBuilder itself (method chaining pattern).
     */
    B setAlign(HorizontalAlign horizontalAlign, VerticalAlign verticalAlign);

    /**
     *
     * @param verticalAlign
     * @return
     */
    B verticalAlign(VerticalAlign verticalAlign);

    /**
     *
     * @param verticalAlign
     * @return
     */
    B setHorizontalAlign(HorizontalAlign verticalAlign);

    /**
     * Rotates the primitive anti clockwise in degrees. <br/>
     * <span style="vertical-align:middle;height:80px;"><img
     * src="doc-files/ShapeBuilder_initial.png"/>+ rotate 30 degrees <img
     * src="doc-files/ShapeBuilder_rotate.png"/> = <img
     * src="doc-files/ShapeBuilder_rotate_result.png"/></span>
     * 
     * @param angle
     *            The anti clockwise rotation of the primitive in degrees. Valid
     *            values are 0 ... 360 degrees.
     * @return The Buildable itself (method chaining pattern).
     */
    B setRotation(double angle);

    /**
     * Sets the interaction for the onMouseOver event.
     * 
     * @param mouseOver
     *            The interaction for the onMouseOver event.
     * @return The Buildable itself (method chaining pattern).
     */
    B setMouseOver(String mouseOver);

    /**
     * Sets the interaction for the onMouseOut event.
     * 
     * @param mouseOut
     *            The interaction for the onMouseOut event.
     * @return The Buildable itself (method chaining pattern).
     */
    B setMouseOut(String mouseOut);

    /**
     * Sets the interaction for the onMouseDown event.
     * 
     * @param mouseDown
     *            The interaction for the onMouseDown event.
     * @return The Buildable itself (method chaining pattern).
     */
    B setMouseDown(String mouseDown);

    /**
     * Sets the interaction for the onMouseUp event.
     * 
     * @param mouseUp
     *            The interaction for the onMouseUp event.
     * @return The Buildable itself (method chaining pattern).
     */
    B setMouseUp(String mouseUp);

    /**
     * Sets the interaction for the onClick event.
     * 
     * @param click
     *            The interaction for the onClick event.
     * @return The Buildable itself (method chaining pattern).
     */
    B setClick(String click);

    /**
     * Sets the interaction for the onDblClick event.
     * 
     * @param dblClick
     *            The interaction for the onDblClick event.
     * @return The Buildable itself (method chaining pattern).
     */
    B setDblClick(String dblClick);

    /**
     * Sets the point (or in the case of an mutipoint adds another point).
     * 
     * @param x
     *            The x coordinate of the point.
     * @param y
     *            The y coordinate of the point.
     * @return The method chaing pattern.
     */
    B setPoint(double x, double y);
}
