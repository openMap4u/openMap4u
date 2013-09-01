package org.openmap4u.builder;

import java.awt.geom.AffineTransform;

import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.TransformHelper;
import org.openmap4u.commons.Util;
import org.openmap4u.commons.VerticalAlign;
import org.openmap4u.primitive.AbstractPrimitive;
import org.openmap4u.style.Styleable;
import org.openmap4u.unit.Transparence;

/**
 * 
 * @author Michael Hadrbolec
 */
 abstract class AbstractBuilderPlugin<T, S extends Styleable<S>, B extends AbstractBuilderPlugin<T, S, B>>
        extends AbstractPrimitive<T, S> implements Buildable<T, S, B> {

    private boolean mVisible = true;
    private TransformHelper mTransformHelper = new TransformHelper();
    private Transparence mTransparence = Transparence.PERCENT;

    /**
     * Constant which indicates tranparence (which means it is not visible at
     * all).
     */
    private static final double TRANSPARENT = 100;

    @Override
    public B setVisible(boolean isVisible) {
        this.mVisible = isVisible;
        return (B) this;
    }

    @Override
    public final boolean isVisible() {
        return this.mVisible && getStyle().getAlpha() >= TRANSPARENT;
    }

    @Override
    public B setTransparence(double tranparence) {
        this.getStyle().setAlpha(mTransparence.convert(tranparence));
        return (B) this;
    }

    @Override
    public B setAlign(HorizontalAlign horizontalAlign,
            VerticalAlign verticalAlign) {
        setHorizontalAlign(horizontalAlign);
        setVerticalAlign(verticalAlign);
        return (B) this;
    }

    @Override
    public B setVerticalAlign(VerticalAlign verticalAlign) {
        this.getStyle().setVerticalAlign(verticalAlign);
        return (B) this;
    }

    @Override
    public B setHorizontalAlign(HorizontalAlign horizontalAlign) {
        this.getStyle().setHorizontalAlign(horizontalAlign);
        return (B) this;
    }

    @Override
    public final B setOffset(double offsetX, double offsetY) {
        setOffsetX(offsetX);
        setOffsetY(offsetY);
        return (B) this;
    }

    @Override
    public final B setOffsetX(double offsetX) {
        this.mTransformHelper.setX(offsetX);
        return (B) this;
    }

    @Override
    public final B setOffsetY(double offsetY) {
        this.mTransformHelper.setY(offsetY);
        return (B) this;
    }

    @Override
    public final B setScale(double scaleFactor) {
        return setScale(scaleFactor, scaleFactor);
    }

    @Override
    public final B setScale(double scaleX, double scaleY) {
        setScaleX(scaleX);
        setScaleY(scaleY);
        return (B) this;
    }

    @Override
    public final B setScaleX(double scaleX) {
        this.mTransformHelper.setScaleX(scaleX);
        return (B) this;
    }

    @Override
    public final B setScaleY(double scaleY) {
        this.mTransformHelper.setScaleY(scaleY);
        return (B) this;
    }

    @Override
    public final B setRotation(double angle) {
        this.mTransformHelper.setRotate(angle);
        return (B) this;
    }

    @Override
    public final B setMouseOver(String mouseOver) {
        this.getInteract().setMouseOver(mouseOver);
        return (B) this;
    }

    @Override
    public final B setMouseOut(String mouseOut) {
        this.getInteract().setMouseOut(mouseOut);
        return (B) this;
    }

    @Override
    public final B setMouseDown(String mouseDown) {
        this.getInteract().setMouseDown(mouseDown);
        return (B) this;
    }

    @Override
    public final B setMouseUp(String mouseUp) {
        this.getInteract().setMouseUp(mouseUp);
        return (B) this;
    }

    @Override
    public final B setClick(String click) {
        this.getInteract().setClick(click);
        return (B) this;
    }

    @Override
    public final B setDblClick(String dblClick) {
        this.getInteract().setDblClick(dblClick);
        return (B) this;
    }

    @Override
    public B setPoint(double x, double y) {
        this.addPoint(x, y);
        return (B) this;
    }

    @Override
    public AffineTransform getIndividualTransform() {
        return Util.get().getIndividualTransform(this.mTransformHelper);
    }
}
