/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.openmap4u.unit.Length;

/**
 *
 * @author Michael Hadrbolec
 */
public class TransformUtil {

    public final Point2D getPoint(Position position, Shape shape) {
        Rectangle2D bounds = shape.getBounds2D();
        switch (position) {
            case LeftTop:
                return new Point2D.Double(bounds.getMinX(), bounds.getMaxY());
            case CenterTop:
                return new Point2D.Double(bounds.getCenterX(), bounds.getMaxY());
            case RightTop:
                return new Point2D.Double(bounds.getMaxX(), bounds.getMaxY());
            case LeftMiddle:
                return new Point2D.Double(bounds.getMinX(), bounds.getCenterY());
            case CenterMiddle:
                return new Point2D.Double(bounds.getCenterX(), bounds.getCenterY());
            case RightMiddle:
                return new Point2D.Double(bounds.getMaxX(), bounds.getCenterY());
            case LeftBottom:
                return new Point2D.Double(bounds.getMinX(), bounds.getMinY());
            case CenterBottom:
                return new Point2D.Double(bounds.getCenterX(), bounds.getMinY());
            case RightBottom:
                return new Point2D.Double(bounds.getMaxX(), bounds.getMinY());
            default:
                return null;
        }
    }

    /**
     * Transform the given point with the provided global transformation.
     * @param point2Transform
     * @param globalTransform
     * @return 
     */
    public final Point2D transform(Point2D point2Transform, AffineTransform globalTransform) {
        return globalTransform.transform(point2Transform, new Point2D.Double());
    }
    
    
    
    public final AffineTransform getGlobalTransfrom(AreaOfInterestTransformable areaOfInterest, Length worldUnits, Length drawingUnits) {
      /* perform the scalign */
        AffineTransform global = new AffineTransform(
                areaOfInterest.getScaleX(), 0, 0,
                areaOfInterest.getScaleX(), 0, 0);
        /* perform the translation */
        if (areaOfInterest.getCenter()!=null) {
            Rectangle2D bounds = areaOfInterest.getShape().getBounds2D();
            global.translate(
                    -getGlobalTransformTranslate(areaOfInterest.getCenter().getX(),
                            drawingUnits.convert(bounds.getWidth(), worldUnits),
                            areaOfInterest.getScaleX()),
                    -getGlobalTransformTranslate(areaOfInterest.getCenter().getY(),
                            drawingUnits.convert(bounds.getHeight(), worldUnits),
                            areaOfInterest.getScaleY()));
        }
        /* perform the rotation */
        if (areaOfInterest.getRotate() != 0
                && areaOfInterest.getRotate() != 360) {
            double rotateCenterX = areaOfInterest.getCenter().getX();
            double rotateCenterY = areaOfInterest.getCenter().getY();
            if (Double.isNaN(rotateCenterX)) {
                rotateCenterX = 0;
            }
            if (Double.isNaN(rotateCenterY)) {
                rotateCenterY = 0;
            }
            global.rotate(Math.toRadians(areaOfInterest.getRotate()),
                    worldUnits.convert(rotateCenterX, drawingUnits),
                    worldUnits.convert(rotateCenterY, drawingUnits));

        }
        return global;
    }
    
        /**
     * Gets the translation of the global transformation (for internal use
     * only).
     *
     * @param center The center coordinate in world units.
     * @param extent The extent in world units (e.g. the width or height).
     * @param scaleFactor The scaleFactor.
     * @return The translation.
     */
    double getGlobalTransformTranslate(double center, double extent,
            double scaleFactor) {
        return center - extent / 2d / scaleFactor;
    }

}
