/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 *
 * @author Michael Hadrbolec
 */
public class AreaOfInterestDebug implements AreaOfInterestTransformable {

    public AreaOfInterestDebug(Shape shape, Point2D.Double center, Double scale, Double rotate) {
        if (scale != null) {
            this.mScale = scale;
        }
        this.mShape = shape;
        if (center != null) {
            this.mCenter = center;
        }
         if (rotate != null) {
            this.mRotateRad = getAngleUnits().convert(rotate);
        }
    }

    private Point2D.Double mCenter = null;

    private Shape mShape = null;

    private double mScale = 1;

    private double mRotateRad = 0;

    @Override
    public Point2D getCenter() {
        return this.mCenter;
    }

    @Override
    public Shape getShape() {
        return this.mShape;
    }

    @Override
    public Length getWorldUnits() {
        return Length.CM;
    }

    @Override
    public Length getDrawingUnits() {
        return Length.CM;
    }

    @Override
    public Angle getAngleUnits() {
        return Angle.DEGREE;

    }

    @Override
    public double getRotate() {
        return this.mRotateRad;
    }

    @Override
    public double getScaleX() {
        return mScale;
    }

    @Override
    public double getScaleY() {
        return mScale;
    }

}
