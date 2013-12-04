/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.builder;

import java.awt.geom.Point2D;
import java.util.Set;
import org.openmap4u.commons.Position;

/**
 *
 * @author hadrbolec
 */
public interface BuildableI {
    
      /**
     * 
     * @param point 
     */
    void addPoint(Point2D point);

    /**
     * Adds an anchor point relative to the last drawn primitive. Or in the case
     * nothing has been previosly drawn the coordinate center (0,0).
     *
     * @param point The anchor point to be added.
     */
    void addPoint(Position point);
    
    /**
     * Gets the points (or null) in the case it is not a point primitive.
     * @return The points (which can be either a Point2D or an AnchorPoint).
     */
    Set<Object> getPoints();

    
}
