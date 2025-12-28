package org.openmap4u.builder;

import java.awt.geom.Point2D;

import org.openmap4u.commons.Angle;
import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.Point;
import org.openmap4u.commons.Point.Align;
import org.openmap4u.commons.Styleable;
import org.openmap4u.commons.Transparence;
import org.openmap4u.commons.VerticalAlign;
import org.openmap4u.interfaces.Drawable;

/**
 * All builders are derived from this base class.
 *
 * @author Michael Hadrbolec
 * @param <S> The style type.
 * @param <B> The builder type.
 */
abstract class Builder<S extends Styleable<S>, B extends Builder<S, B, P>, P> implements BuildablePrimitive<S, B, P> {

    /**
     * Stores the transparence units.
     */
    private Transparence mTransparence = Transparence.PERCENT;

    private Drawable<S, P> drawable = new Draw<S,P>();

   

    protected Drawable<S, P> getDrawable() {
        return this.drawable;
    }

    /**
     * Returns the builder instance (self-type idiom).
     * @return The builder instance.
     */
    protected abstract B self();

	public B style(S style) {
    	this.getDrawable().setStyle(style);
	return self();
    }
    
	@Override
    public B visible(boolean isVisible) {
        getDrawable().getStyle().visible(isVisible);
        return self();
    }

	@Override
    public B transparence(double tranparence) {
        getDrawable().getStyle().alpha(mTransparence.convert(tranparence));
        return self();
    }

	@Override
    public B align(HorizontalAlign horizontalAlign, VerticalAlign verticalAlign) {
        getDrawable().getTransform().setAlign(new Align(horizontalAlign, verticalAlign));
        return self();
    }

	@Override
    public final B offset(double offsetX, double offsetY) {
        getDrawable().getTransform().setOffset(new Point2D.Double(offsetX, offsetY));
        return self();
    }

    @Override
    public final B offsetX(double offsetX) {
        return offset(offsetX, this.getDrawable().getTransform().getOffset().getY());
    }

    @Override
    public final B offsetY(double offsetY) {
        return offset(this.getDrawable().getTransform().getOffset().getX(), offsetY);
    }

    @Override
    public final B scale(double scaleFactor) {
        return scale(scaleFactor, scaleFactor);
    }

	@Override
    public final B scale(double scaleX, double scaleY) {
        scaleX(scaleX);
        scaleY(scaleY);
        return self();
    }

	@Override
    public final B scaleX(double scaleX) {
        this.getDrawable().getTransform().setScaleX(scaleX);
        return self();
    }

	@Override
    public final B scaleY(double scaleY) {
        this.getDrawable().getTransform().setScaleY(scaleY);
        return self();
    }

	@Override
    public final B unit(Angle angleUnits) {
        this.getDrawable().getTransform().setAngleUnits(angleUnits);
        return self();
    }

	@Override
    public final B unit(Transparence transparenceUnits) {
        mTransparence = transparenceUnits;
        return self();
    }

	@Override
    public final B rotate(double rotation) {
        this.getDrawable().getTransform().setRotate(this.getDrawable().getTransform().getAngleUnits().convert(rotation));
        return self();
    }

	@Override
    public final B center(double x, double y) {
        this.getDrawable().addPoint(new Point.Coord(x, y));
        return self();
    }

	@Override
    public B center(HorizontalAlign x, VerticalAlign y) {
        this.getDrawable().addPoint(new Align(x, y));
        return self();
    }

	@Override
    public B center(HorizontalAlign x, double y) {
        this.getDrawable().addPoint(new Point.HorizontalAlign(x, y));
        return self();
    }

	@Override
    public B center(double x, VerticalAlign y) {
        this.getDrawable().addPoint(new Point.VerticalAlign(x, y));
        return self();
    }

    /**
     * Adds a new child builder.
     *
     * @param builder The child builder to add.
     */
	protected B add(BuildablePrimitive builder) {
        this.getDrawable().addChild(builder.build());
        return self();
    }

    @Override
    public Drawable<S, P> build() {
        return getDrawable();
    }

}
