package org.openmap4u.builder;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openmap4u.commons.Angle;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.Point;
import org.openmap4u.commons.Point.Align;
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
class Builder<S extends Styleable<S>, B extends Builder<S, B>> implements Buildable<S, B> {

    /**
     * Stores the transparence units.
     */
    private Transparence mTransparence = Transparence.PERCENT;

    /**
     * Stores the previously drawn shape.
     */
    private Shape mPreviousDrawnShape = new Rectangle2D.Double();

    /**
     * Stores the style.
     */
    private S mStyle = null;

    /**
     * Stores the points.
     */
    private Set<Point> mPoints = null;

    /**
     * Stores the childs.
     */
    private List<Buildable<S,B>> mChilds = null;

    private DrawableTransformable mTransform = new DrawTransform();

    Builder() {
    }

    @Override
    public Set<Point> getPoints() {
        return this.mPoints;
    }

    @Override
    public Shape getPreviousShape() {
        return this.mPreviousDrawnShape;
    }

    @Override
    public void setUp(Shape previousDrawnShape) {
        this.mPreviousDrawnShape = previousDrawnShape;
    }

    @Override
    public B visible(boolean isVisible) {
        getStyle().visible(isVisible);
        return (B) this;
    }

    @Override
    public B transparence(double tranparence) {
        getStyle().alpha(mTransparence.convert(tranparence));
        return (B) this;
    }

    @Override
    public B align(HorizontalAlign horizontalAlign, VerticalAlign verticalAlign) {
        this.getTransform().setAlign(new Align(horizontalAlign, verticalAlign));
        return (B) this;
    }

    @Override
    public final B offset(double offsetX, double offsetY) {
        this.mTransform.setOffset(new Point2D.Double(offsetX, offsetY));
        return (B) this;
    }

    @Override
    public final B offsetX(double offsetX) {
        return offset(offsetX, this.mTransform.getOffset().getY());
    }

    @Override
    public final B offsetY(double offsetY) {
        return offset(this.mTransform.getOffset().getX(), offsetY);
    }

    @Override
    public final B scale(double scaleFactor) {
        return scale(scaleFactor, scaleFactor);
    }

    @Override
    public final B scale(double scaleX, double scaleY) {
        scaleX(scaleX);
        scaleY(scaleY);
        return (B) this;
    }

    @Override
    public final B scaleX(double scaleX) {
        this.mTransform.setScaleX(scaleX);
        return (B) this;
    }

    @Override
    public final B scaleY(double scaleY) {
        this.mTransform.setScaleY(scaleY);
        return (B) this;
    }

    @Override
    public final B unit(Angle angleUnits) {
        this.mTransform.setAngleUnits(angleUnits);
        return (B) this;
    }

    @Override
    public final B unit(Transparence transparenceUnits) {
        this.mTransparence = transparenceUnits;
        return (B) this;
    }

    @Override
    public final B rotate(double rotation) {
        this.mTransform.setRotate(this.mTransform.getAngleUnits().convert(rotation));
        return (B) this;
    }

    /**
     * initializes the points.
     */
    private B addPoint(Point  point2Add) {
        if (this.mPoints == null) {
            this.mPoints = new HashSet<>();
        }
        this.mPoints.add(point2Add);
        return (B) this;
    }

    @Override
    public final B center(double x, double y) {
        return addPoint(new Point.Coord(x, y));
    }

    @Override
    public final S getStyle() {
        return this.mStyle;
    }

    @Override
    public final void setStyle(S style) {
        this.mStyle = style;
    }

    @Override
    public final DrawableTransformable getTransform() {
        return this.mTransform;
    }

    @Override
    public void setTransform(DrawableTransformable transform) {
        this.mTransform = transform;
    }

    @Override
    public boolean isPoint() {
        return this.getPoints() != null && !this.getPoints().isEmpty();
    }

    @Override
    public void tearDown() {
        /* nothing to do */
    }

    @Override
    public B center(HorizontalAlign x, VerticalAlign y) {
        return addPoint(new Align(x, y));
    }

    @Override
    public B center(HorizontalAlign x, double y) {
        return addPoint(new Point.HorizontalAlign(x, y));
    }

    @Override
    public B center(double x, VerticalAlign y) {
        return addPoint(new Point.VerticalAlign(x, y));
    }

    @Override
    public List<Buildable<S,B>> getChilds() {
        return this.mChilds;
    }

    @Override
    public boolean hasChilds() {
        return this.mChilds != null;
    }

    /**
     * Adds a new child builder.
     *
     * @param builder The child builder to add.
     */
    protected B add(Buildable builder) {
        if (!hasChilds()) {
            this.mChilds = new ArrayList<>();
        }
        this.mChilds.add(builder);
        return (B) this;
    }

}
