/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Point;
import org.openmap4u.commons.Styleable;
import org.openmap4u.interfaces.Drawable;

/**
 *
 * @author Michael Hadrbolec
 * @param <S> The style type.
 */
public class Draw<S extends Styleable<S>,P> implements Drawable<S,P> {

    /**
     * Stores the previously drawn shape.
     */
    private Shape mPreviousDrawnShape = new Rectangle2D.Double();

    /**
     * Stores the style.
     */
    private S style = null;
    
    private P primitive = null;

    /**
     * Stores the points.
     */
    private Set<Point> points = null;

    private DrawableTransformable transformable = new DrawTransform();
  
    private List<Drawable> childs = null;

    public Draw( ) {
        
    }
    
   


    @Override
    public S getStyle() {
        return style;
    }

    @Override
    public final void setStyle(S style) {
        this.style = style;
    }

    @Override
    public DrawableTransformable getTransform() {
        return transformable;
    }

    @Override
    public void setTransform(DrawableTransformable transformable) {
        this.transformable = transformable;
    }

    @Override
    public boolean hasChilds() {
        return this.childs != null && this.childs.size() > 0;
    }

    public List<Drawable> getChilds() {
        return this.childs;
    }

    /**
     *
     * @param <S>
     * @param child
     */
    public void addChild(Drawable child) {
        if (this.childs == null) {
            this.childs = new ArrayList<>();
        };
        this.childs.add(child);
    }

    @Override
    public boolean isPoint() {
        return this.getPoints() != null && !this.getPoints().isEmpty();
    }

    public void addPoint(Point point) {
        if (getPoints() == null) {
            this.points = new HashSet<>();
        }
        this.points.add(point);
    }

    @Override
    public Set<Point> getPoints() {
        return this.points;
    }

    public Shape getPreviousShape() {
        return this.mPreviousDrawnShape;
    }

    @Override
    public void setUp(Shape previousDrawnShape) {
        this.mPreviousDrawnShape = previousDrawnShape;
    }

    @Override
    public void tearDown() {
    }

    @Override
    public P getPrimitive() {
   return this.primitive;
    }

    @Override
    public void setPrimitive(P primitive) {
this.primitive= primitive;
    }

}
