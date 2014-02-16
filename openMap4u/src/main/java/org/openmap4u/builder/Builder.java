package org.openmap4u.builder;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Position;
import org.openmap4u.commons.Styleable;

import org.openmap4u.commons.Angle;
import org.openmap4u.commons.Transparence;

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
    private Set<Object> mPoints = null;

    @Override
    public Set<Object> getPoints() {
        return this.mPoints;
    }

    private DrawableTransformable mTransform = new DrawTransform();

    Builder() {
    }

    @Override
    public void setUp(Shape previousDrawnShape) {
        this.mPreviousDrawnShape = previousDrawnShape;
    }

    @Override
    public B visible(boolean isVisible) {
        getStyle().setVisible(isVisible);
        return (B) this;
    }

    @Override
    public B transparence(double tranparence) {
        getStyle().setAlpha(mTransparence.convert(tranparence));
        return (B) this;
    }

    @Override
    public B align(Position align) {
        this.getTransform().setAlign(align);
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
    private B addPoint(Object point2Add) {
        if (this.mPoints == null) {
            this.mPoints = new HashSet<>();
        }
        this.mPoints.add(point2Add);
        return (B) this;
    }

    @Override
    public final B point(double x, double y) {
        return addPoint(new Point2D.Double(x, y));
    }

    @Override
    public final B point(Position position) {
        return addPoint(position);
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
    
    public void setTransform(DrawableTransformable transform) {
    this.mTransform = transform;
    }

    @Override
    public boolean isPoint() {
        return this.getPoints() != null && this.getPoints().size() > 0;
    }

    @Override
    public void tearDown() {
    }

}
