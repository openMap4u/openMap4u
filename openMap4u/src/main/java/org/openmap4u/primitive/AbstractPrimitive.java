/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.primitive;

import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

import org.openmap4u.interact.Interactable;
import org.openmap4u.style.Styleable;

/**
 * All primitive types can be derived from this base abstract class.
 * 
 * @author Michael Hadrbolec
 * @param <T> The primitive type.
 * @param <S> The primitive style.
 */
public abstract class AbstractPrimitive<T, S extends Styleable<S>> implements
        Primitive<T, S> {

    /**
     * Stores the style.
     */
    private S mStyle = null;
    /**
     * Stores the primitive type.
     */
    private T mPrimitive;
    /**
     * Stores the interactions.
     */
    private Interactable mInteract;

    /**
     * Stores the point (for a (multi) pointprimitive).
     */
    private Set<Point2D.Double> mPoints = null;

    /**
     * Gets the style.
     * 
     * @return The style.
     */
    @Override
    public final S getStyle() {
        return (S) this.mStyle;
    }

    /**
     * Sets the style.
     * 
     * @param style
     *            The style.
     */
    @Override
    public final void setStyle(S style) {
        this.mStyle = style;
    }

    /**
     * Gets the primitive.
     * 
     * @return The primitive.
     */
    @Override
    public T getPrimitive() {
        return this.mPrimitive;
    }

    /**
     * Sets the primitive.
     * 
     * @param primitive
     *            The primitive.
     */
    @Override
    public final void setPrimitive(T primitive) {
        this.mPrimitive = primitive;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Interactable getInteract() {
        return this.mInteract;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setInteract(Interactable interact) {
        this.mInteract = interact;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Set<Point2D.Double> getPoints() {
        return this.mPoints;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void addPoint(double x, double y) {
        if (getPoints() == null) {
            this.mPoints = new HashSet<>();
        }
        this.mPoints.add(new Point2D.Double(x, y));
    }

    /**
     * Checks whether it is a point or multipoint.
     * 
     * @return <code>true</code> in the case it is a point or * multipoint,
     *         <code>false</code> if not.
     */
    public final boolean isPoint() {
        return this.getPoints() != null && this.mPoints.size() > 0;
    }
}
