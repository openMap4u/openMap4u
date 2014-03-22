/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import java.awt.geom.Point2D;
import org.openmap4u.commons.Angle;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Globals;
import org.openmap4u.commons.Point.Align;
import org.openmap4u.commons.Position;

/**
 *
 * @author Michael Hadrbolec
 */
final class DrawTransform implements DrawableTransformable {

    private Angle mAngleUnits = Globals.DEFAULT_ANGLE_UNIT;

    private double mRotate = 0;

    private double mScaleX = 1;

    private double mScaleY = 1;

    /**
     * Stores the offset.
     */
    private Point2D mOffset = null;

    /**
     * Stores the alignment.
     */
    private Align mAlign = null;

    @Override
    public double getRotate() {
        return this.mRotate;
    }

    @Override
    public double getScaleX() {
        return this.mScaleX;
    }

    @Override
    public double getScaleY() {
        return this.mScaleY;
    }

    public void setScaleX(double scaleX) {
        this.mScaleX = scaleX;
    }

    public void setScaleY(double scaleY) {
        this.mScaleY = scaleY;
    }

    public void setRotate(double angle) {
        this.mRotate = angle;
    }

    @Override
    public Point2D getOffset() {
        if (this.mOffset == null) {
            this.mOffset = new Point2D.Double();
        }
        return this.mOffset;
    }

    @Override
    public void setOffset(Point2D offset) {
        this.mOffset = offset;
    }

    @Override
    public Align getAlign() {
        return this.mAlign;
    }

    @Override
    public void setAlign(Align align) {
        this.mAlign = align;
    }

    @Override
    public Angle getAngleUnits() {
        return mAngleUnits;
    }

    public void setAngleUnits(Angle angleUnits) {
        this.mAngleUnits = angleUnits;
    }

}
