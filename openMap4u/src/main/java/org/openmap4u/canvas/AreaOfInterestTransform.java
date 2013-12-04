/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

import java.awt.Shape;
import java.awt.geom.Point2D;
import org.openmap4u.commons.AreaOfInterestTransformable;
import org.openmap4u.commons.Transform;

/**
 *
 * @author Michael Hadrbolec
 */
class AreaOfInterestTransform extends Transform implements AreaOfInterestTransformable {

    /**
     * Stores the center.
     */
    private Point2D mCenter = null;
    
    private Shape mShape = null;

    @Override
    public Point2D getCenter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCenter(Point2D center) {
        this.mCenter = center;
    }

    @Override
    public Shape getShape() {
        return this.mShape;
    }

    @Override
    public void setShape(Shape shape) {
        this.mShape = shape;
    }

}
