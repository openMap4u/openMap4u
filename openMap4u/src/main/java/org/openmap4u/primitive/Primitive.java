package org.openmap4u.primitive;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Set;

import org.openmap4u.interact.Interactable;
import org.openmap4u.style.Styleable;

/**
 * All drawable primitives are derived from this interface.
 * 
 * @author Michael Hadrbolec
 * 
 * @param <T>
 *            The type of the primitive.
 * @param <S>
 *            The type of the primitive style.
 */
public interface Primitive<T, S extends Styleable<S>  > {

    /**
     * Gets the individual transformation.
     * 
     * @return The individual transformation.
     */
    AffineTransform getIndividualTransform();

    /**
     * Gets the interaction.
     * 
     * @return The interaction.
     */
    Interactable getInteract();

    /**
     * Gets the primitive.
     * 
     * @return The primitive.
     */
    T getPrimitive();

    /**
     * Gets the style.
     * 
     * @return The style.
     */
    S getStyle();

    /**
     * Sets the interaction.
     * 
     * @param interact
     *            The interaction.
     */
    void setInteract(Interactable interact);

    /**
     * Sets the primitive.
     * 
     * @param primitive
     *            The primitive.
     */
    void setPrimitive(T primitive);

    /**
     * Sets the style.
     * 
     * @param style
     *            The style.
     */
    void setStyle(S style);

    /**
     * Determines whether it is a point based primitive.
     * 
     * @return <code>true</code> it is a point based primitive,
     *         <code>false</code> it is not a point based primitive.
     */
    boolean isPoint();

    /**
     * Gets the points (if there are some).
     * 
     * @return The points.
     */
    Set<Point2D.Double> getPoints();

    /**
     * Adds a new point.
     * 
     * @param x
     *            The x coordinate of the point.
     * @param y
     *            The y coordinate of the point.
     */
    void addPoint(double x, double y);

}
