/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.interfaces;

import java.awt.Shape;
import java.util.List;
import java.util.Set;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Point;
import org.openmap4u.commons.Styleable;

/**
 *
 * @author hadrbolec
 * @param <S> The style type for the drawable.
 */
public interface Drawable<S extends Styleable<S>,P> {

    /**
     * Gets the style.
     *
     * @return The style.
     */
    S getStyle();

    /**
     * Sets the style.
     *
     * @param style The style.
     */
    void setStyle(S style);

    /**
     * Gets the individual transformation parameters.
     *
     * @return The individual transformation parameters.
     */
    DrawableTransformable getTransform();

    void setTransform(DrawableTransformable transform);

    /**
     * Gets true if there are childs, or false if there arent any.
     * @return Gets true if there are childs, or false if there arent any.
     */
    boolean hasChilds();
    
    void addChild(Drawable drawable);

    /**
     * Gets the childs or null if there arent any. 
     * @return The childs or null if there arent any. 
     */
    List<Drawable> getChilds();

    boolean isPoint();
    
    void addPoint(Point point);

    /**
     * Gets the point(s) center(s) (in the case the pimitives represents one or
     * more point(s)) or null in the case the primitive is not a point.
     *
     * @return The points.
     */
    @SuppressWarnings("rawtypes")
    Set<Point> getPoints();
    
    /**
     * Gets the primitive.
     * @return The primitive.
     */
    P getPrimitive();
    
    /**
     * Sets the primitive.
     * @param primitive The primitive.
     */
    void setPrimitive(P primitive);

    /**
     * Is called before the drawable is drawn.
     *
     * @param previousDrawnShape The previous drawn shape (or in the case it is
     * the first primitive a new Rectangle2D.Double() instance).
     */
    void setUp(Shape previousDrawnShape);
    
    
	/**
	 * Cleanup code.
	 */
	void tearDown();


}
