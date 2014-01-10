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

/**
 *
 * @author Michael Hadrbolec
 */
public class TransformUtil {

    /**
     * Gets the point position on a given shape.
     *
     * @param position The position, whose point should be retrieved.
     * @param shape The shape.
     * @return The resulting point.
     */
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

    /**
     * Transform the given point with the provided global transformation.
     *
     * @param point2Transform The point to be tranformed.
     * @param globalTransform The global transformation to be apllied to the
     * point.
     * @return The resulting transfromed point.
     */
    public final Point2D transform(Point2D point2Transform, AffineTransform globalTransform) {
        return globalTransform.transform(point2Transform, new Point2D.Double());
    }

    /**
     * Transforms the given point from the provided global transformation back
     * into the world units.
     *
     * @param point2Transform The point to be transfromed back into world units.
     * @param globalTransform The global transformation.
     * @return The resulting transformed point.
     * @throws NoninvertibleTransformException Is thrown in the case the global
     * trnasformation is not invertable.
     */
    public final Point2D inverseTransform(Point2D point2Transform, AffineTransform globalTransform) throws NoninvertibleTransformException {
        return globalTransform.inverseTransform(point2Transform, new Point2D.Double());
    }

    /**
     * Creates the individual transformation. It is composed of the following
     * transformations in the following fixed order: translation (=offset),
     * rotation, scaling and finally alignment. <br/>
     * e.g.: start <img alt="" src="./doc-files/b_initial.png"> offset <img
     * alt="" src="./doc-files/b_transform2gether1.png"> rotate <img alt=""
     * src="./doc-files/b_transform2gether2.png"> scale <img alt=""
     * src="./doc-files/b_transform2gether3.png"> align <img alt=""
     * src="./doc-files/b_transform2gether4.png">
     *
     * @param individualTransform The individual transformation.
     * @param shape The shape.
     * @return The individual transformation.
     */
    final AffineTransform getIndividualTransform(DrawableTransformable individualTransform, Shape shape) {
        AffineTransform individual = new AffineTransform();
        if (individualTransform.getOffset() != null) {
            individual.translate(individualTransform.getOffset().getX(), individualTransform.getOffset().getY());
        }
        if (isRotate(individualTransform.getRotate())) {
            individual.rotate(individualTransform.getRotate());
        }

        if (individualTransform.getScaleX() != 1 || individualTransform.getScaleY() != 1) {
            individual.scale(individualTransform.getScaleX(), individualTransform.getScaleY());
        }
        if (shape != null && individualTransform.getAlign() != null) {
            Point2D align = getPoint(individualTransform.getAlign(), shape);
            individual.translate(-align.getX(), -align.getY());
        }
        return individual;
    }

    /**
     * Determines whether it is a rotation.
     *
     * @param radiand The angle in radiant.
     * @return true if there is a rotation, false if there is no rotation.
     */
    final boolean isRotate(double radiand) {
        return 0 != radiand % (2d * Math.PI);
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

    /**
     * Gets overall transformation based on the given global trnasformation the
     * point (in the case it is a point) the scale x and scale y factor to
     * adjust to output format units.transformation
     *
     * @param globalTransform The global transformation.
     * @param point The point (in the case it is a point= or null if not.
     * @param scaleX The scaleX factor to adjust to the output format.
     * @param scaleY The scaleY factor to adjust to the output format.
     * @param individualTransform The individual transformation. <br> Remark: It
     * is composed of the following transformations in the following fixed
     * order: translation (=offset), rotation, scaling and finally alignment.
     * <br>
     * e.g.: start <img alt="" src="./doc-files/b_initial.png"> offset <img
     * alt="" src="./doc-files/b_transform2gether1.png"> rotate <img alt=""
     * src="./doc-files/b_transform2gether2.png"> scale <img alt=""
     * src="./doc-files/b_transform2gether3.png"> align <img alt=""
     * src="./doc-files/b_transform2gether4.png">
     * @param shape The shape to draw.
     * @return The resulting transformation.
     */
    public final AffineTransform transform(AffineTransform globalTransform, Point2D point, double scaleX, double scaleY, DrawableTransformable individualTransform, Shape shape) {
        if (point != null) {
            /* translate to the given point in world units */
            globalTransform.translate(point.getX(), point.getY());
            /* take the scale into acount */
            globalTransform.scale(scaleX, scaleY);
        }
        /* if align is provided */
        globalTransform.concatenate(getIndividualTransform(individualTransform, shape));
        return globalTransform;
    }

    public final AffineTransform transform(AffineTransform globalTransform, AffineTransform individualTransform) {
        globalTransform.concatenate(individualTransform);
        return globalTransform;
    }

    /**
     * Gets the global transformation based on the given area of interest.
     *
     * @param areaOfInterest The area of interest.
     * @return The resulting global transform.
     */
    public AffineTransform getGlobalTransform(AreaOfInterestTransformable areaOfInterest) {
        AffineTransform global = new AffineTransform();
        /* perform the scalign */
        global.scale(areaOfInterest.getScaleX(),
                areaOfInterest.getScaleY());
        /* perform the translation */
        Rectangle2D bounds = areaOfInterest.getShape().getBounds2D();
        /* set the center in the case it is null */

        if (areaOfInterest.getCenter() != null) {
            global.translate(
                    -getGlobalTransformTranslate(areaOfInterest.getCenter().getX(),
                            areaOfInterest.getDrawingUnits().convert(bounds.getWidth(), areaOfInterest.getWorldUnits()),
                            areaOfInterest.getScaleX()),
                    -getGlobalTransformTranslate(areaOfInterest.getCenter().getY(),
                            areaOfInterest.getDrawingUnits().convert(bounds.getHeight(), areaOfInterest.getWorldUnits()),
                            areaOfInterest.getScaleY()));
        }
        /* perform the rotation */
        if (isRotate(areaOfInterest.getRotate())) {
            global.rotate(Math.toRadians(areaOfInterest.getRotate()),
                    areaOfInterest.getWorldUnits().convert(areaOfInterest.getCenter().getX(), areaOfInterest.getDrawingUnits()),
                    areaOfInterest.getWorldUnits().convert(areaOfInterest.getCenter().getY(), areaOfInterest.getDrawingUnits()));

        }
        return global;
    }

    /**
     * Transforms the position of the given shape back into a point in world
     * units.
     *
     * @param position The position.
     * @param shape The shape whose position should be retrieved.
     * @param globalTransform The global transformation.
     * @return The position in world units.
     * @throws NoninvertibleTransformException Is thrown in the case the global
     * transformation cannot be inverted.
     */
    public Point2D transform(Position position, Shape shape, AffineTransform globalTransform) throws NoninvertibleTransformException {
        return inverseTransform(getPoint(position, shape), globalTransform);
    }

}
