/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.commons;

import java.awt.geom.Point2D;

/**
 *
 * @author Michae Hadrbolec
 */
public interface DrawableTransformable extends Transformable {
    
    /**
     * Gets the the canvas center.
     * @return The canvas center.
     */
    Point2D getOffset();
    
    /**
     * Sets the offset.
     * @param offset The offset.
     */
    void setOffset(Point2D offset);
    
    /**
     * Gets the alignment.
     * @return The alignment.
     */
    Position getAlign();
    
    /**
     * Sets the alignment.
     * @param align The alignment.
     */
    void setAlign(Position align);

    public void setScaleX(double scaleX);

    public void setScaleY(double scaleY);

    public void setAngleUnits(Angle angleUnits);

    public void setRotate(double convert);
    
}
