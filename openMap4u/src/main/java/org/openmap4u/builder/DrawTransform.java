/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import java.awt.geom.Point2D;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Position;
import org.openmap4u.commons.Transform;

/**
 *
 * @author Michael Hadrbolec
 */
final class DrawTransform extends Transform implements DrawableTransformable {

    /**
     * Stores the offset.
     */
    private Point2D mOffset = null;

    /**
     * Stores the alignment.
     */
    private Position mAlign = null;

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
    public Position getAlign() {
        return this.mAlign;
    }

    @Override
    public void setAlign(Position align) {
        this.mAlign = align;
    }

}
