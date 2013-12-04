/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.openmap4u.unit.Length;

/**
 *
 * @author Michael Hadrbolec
 */
public class TransformUtilBackup {

    private static final double FULL_CIRCLE = 360;
    private static final double ZERO = 360;

    public final Point2D getPoint(Position position, Shape shape, AffineTransform transform) throws NoninvertibleTransformException {
        return inversTransform(getPoint(position, shape), transform);
    }

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
                return new Point2D.Double();
        }
    }

    public Point2D getTranslation(Position position, Shape shape) {
        return null;
    }

    /**
     * Transform the given point with the provided global transformation.
     *
     * @param point2Transform
     * @param transform
     * @return The resulting point.
     */
    public final Point2D transform(Point2D point2Transform, AffineTransform transform) {
        return transform.transform(point2Transform, new Point2D.Double());
    }

    /**
     * Transform the given point with the provided global transformation.
     *
     * @param point2Transform
     * @param transform
     * @return The resulting point.
     */
    public final Point2D inversTransform(Point2D point2Transform, AffineTransform transform) throws NoninvertibleTransformException {
        return transform.inverseTransform(point2Transform, new Point2D.Double());
    }

    /**
     *
     * @param position The alignment.
     * @param shape2Align
     * @return The align offset.
     */
    public Point2D getAlignOffset(Position position, Shape shape2Align) {
        Rectangle2D bounds = shape2Align.getBounds2D();
        switch (position) {
            case LeftTop:
                return new Point2D.Double(-bounds.getMinX(), -bounds.getMaxY());
            case CenterTop:
                return new Point2D.Double(-bounds.getCenterX(), -bounds.getMaxY());
            case RightTop:
                return new Point2D.Double(-bounds.getMaxX(), -bounds.getMaxY());
            case LeftMiddle:
                return new Point2D.Double(-bounds.getMinX(), -bounds.getCenterY());
            case CenterMiddle:
                return new Point2D.Double(-bounds.getCenterX(), -bounds.getCenterY());
            case RightMiddle:
                return new Point2D.Double(-bounds.getMaxX(), -bounds.getCenterY());
            case LeftBottom:
                return new Point2D.Double(-bounds.getMinX(), -bounds.getMinY());
            case CenterBottom:
                return new Point2D.Double(-bounds.getCenterX(), -bounds.getMinY());
            case RightBottom:
                return new Point2D.Double(-bounds.getMaxX(), -bounds.getMinY());
            default:
                return null;
        }
    }

    AffineTransform getTransform(Position align, Shape shape) {
        Point2D alignOffset = getAlignOffset(align, shape);
        return new AffineTransform(1, 0, 0, 1, alignOffset.getX(), alignOffset.getY());
    }

    /**
     *
     * @param globalTransform
     * @param point
     * @param individualTransform
     * @return
     */
    public AffineTransform getTransform(AffineTransform globalTransform,
            Point2D point, AffineTransform individualTransform) {
        /* first get teh global transformation */
        AffineTransform transform = (AffineTransform) globalTransform.clone();
        double scaleX = transform.getScaleX();
        double scaleY = transform.getScaleY();
        /* translate inf necessary */
        if (point != null) {
            transform.translate(point.getX(), point.getY());
            /* compensate world units */
            individualTransform.preConcatenate(new AffineTransform(1 / scaleX,
                    0, 0, -1 / scaleY, 0, 0));
        }
        transform.concatenate(individualTransform);
        return transform;

    }

    /**
     *
     * @param globalTransform
     * @param point
     * @param individualTransform
     * @param align
     * @param shape
     * @return
     */
    public AffineTransform getTransform(AffineTransform globalTransform,
            Point2D point, AffineTransform individualTransform,
            Position align,
            Shape shape) {
        AffineTransform transform = getTransform(globalTransform, point,
                individualTransform);
        transform.concatenate(getTransform(align, shape));
        return transform;
    }

    /**
     * Gets the global transformation.
     *
     * @param width The width of the drawing canvas in drawing units.
     * @param height The height of the drawing canvas in drawing units.
     * @param globalTransformParams The
     * @param worldUnits The world units.
     * @param drawingUnits The drawing units.
     * @return The resulting global transformation.
     */
    public AffineTransform getGlobalTransform(double width, double height,
            TransformHelper globalTransformParams, Length worldUnits,
            Length drawingUnits) {
        /* perform the scalign */
        AffineTransform global = new AffineTransform(
                globalTransformParams.getScaleX(), 0, 0,
                globalTransformParams.getScaleX(), 0, 0);
        /* perform the translation */
        if (globalTransformParams.getPoint()!=null) {
            global.translate(
                    -getGlobalTransformTranslate(globalTransformParams.getPoint().getX(),
                            drawingUnits.convert(width, worldUnits),
                            globalTransformParams.getScaleX()),
                    -getGlobalTransformTranslate(globalTransformParams.getPoint().getY(),
                            drawingUnits.convert(height, worldUnits),
                            globalTransformParams.getScaleY()));
        }
        /* perform the rotation */
        if (globalTransformParams.getRotate() != ZERO
                && globalTransformParams.getRotate() != FULL_CIRCLE) {
            double rotateCenterX = globalTransformParams.getPoint().getX();
            double rotateCenterY = globalTransformParams.getPoint().getY();
            if (Double.isNaN(rotateCenterX)) {
                rotateCenterX = 0;
            }
            if (Double.isNaN(rotateCenterY)) {
                rotateCenterY = 0;
            }
            global.rotate(Math.toRadians(globalTransformParams.getRotate()),
                    worldUnits.convert(rotateCenterX, drawingUnits),
                    worldUnits.convert(rotateCenterY, drawingUnits));

        }
        return global;
    }



    /**
     * Gets the individual transform.
     *
     * @param individualTransformParams The individual transformation parameter.
     * @return The resulting individual transformation.
     */
    public AffineTransform getIndividualTransform(
            TransformHelper individualTransformParams) {
        AffineTransform individual = new AffineTransform();
        if (individualTransformParams.getPoint() != null) {
            individual.translate(individualTransformParams.getPoint().getX(), individualTransformParams.getPoint().getY());
        }
        if (!Double.isNaN(individualTransformParams.getRotate())) {
            individual.rotate(Math.toRadians(individualTransformParams
                    .getRotate()));
        }
        if (!Double.isNaN(individualTransformParams.getScaleX())
                && !Double.isNaN(individualTransformParams.getScaleY())) {
            individual.scale(individualTransformParams.getScaleX(),
                    individualTransformParams.getScaleY());
        }
        return individual;
    }

}
