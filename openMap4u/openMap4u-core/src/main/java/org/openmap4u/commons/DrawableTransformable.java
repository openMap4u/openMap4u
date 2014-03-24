/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import java.awt.geom.Point2D;
import org.openmap4u.commons.Point.Align;

/**
 *
 * @author Michae Hadrbolec
 */
public interface DrawableTransformable extends Transformable {

    /**
     * Gets the the canvas center.
     *
     * @return The canvas center.
     */
    Point2D getOffset();

    /**
     * Sets the offset.
     *
     * @param offset The offset.
     */
    void setOffset(Point2D offset);

    /**
     * Gets the alignment.
     *
     * @return The alignment.
     */
     Align getAlign();

    /**
     * Sets the alignment.
     *
     * @param align The alignment.
     */
    void setAlign(Align align);

    void setScaleX(double scaleX);

    void setScaleY(double scaleY);

    void setAngleUnits(Angle angleUnits);

    void setRotate(double convert);

}
