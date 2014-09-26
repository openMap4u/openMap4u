/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.geom;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.util.LinkedList;
import org.openmap4u.builder.Buildable;

/**
 *
 * @author Michael Hadrbolec
 */
public class ShapeBuilder extends LinkedList<PathFragment> {

    public ShapeBuilder move2(double toX, double toY) {
        this.add(new PathFragment.Move2(toX, toY));
        return this;
    }

    public ShapeBuilder line2(double toX, double toY) {
        this.add(new PathFragment.Line2(toX, toY));
        return this;
    }

    public ShapeBuilder quad2(double cpX, double cpY, double toX, double toY) {
        this.add(new PathFragment.Quad2(cpX, cpY, toX, toY));
        return this;
    }

    public ShapeBuilder bezier2(double cp1X, double cp1Y, double cp2X, double cp2Y, double toX, double toY) {
        this.add(new PathFragment.Bezier2(cp1X, cp1Y, cp2X, cp2Y, toX, toY));
        return this;
    }

    Path2D.Double build() {
        Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        for (PathFragment item : this) {
            if (item.type == FragmentType.LINE2) {
                path.lineTo(item.points[0].getX(), item.points[0].getY());
            } else if (item.type == FragmentType.MOVE2) {
                path.lineTo(item.points[0].getX(), item.points[0].getY());
            } else if (item.type == FragmentType.QUAD2) {
                path.quadTo(item.points[1].getX(), item.points[1].getY(), item.points[0].getX(), item.points[0].getY());
            } else if (item.type == FragmentType.BEZIER2) {
                path.curveTo(item.points[1].getX(), item.points[1].getY(),item.points[2].getX(), item.points[2].getY(), item.points[0].getX(), item.points[0].getY());
            } else {
                throw new java.lang.IllegalArgumentException(new StringBuilder(item.getClass().getName()).append(" is not supported.").toString());
            }
        }
        return path;
    }

}
