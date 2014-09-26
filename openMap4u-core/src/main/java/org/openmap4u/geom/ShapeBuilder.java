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
 * @author zwotti
 */
public class ShapeBuilder extends LinkedList<ShapeItem> {

    public ShapeBuilder move2(double toX, double toY) {
        this.add(new Move2(toX, toY));
        return this;
    }

    public ShapeBuilder line2(double toX, double toY) {
        this.add(new Line2(toX, toY));
        return this;
    }

    public ShapeBuilder quad2(double cpX, double cpY, double toX, double toY) {
        this.add(new Quad2(cpX, cpY, toX, toY));
        return this;
    }

    public ShapeBuilder bezier2(double cp1X, double cp1Y, double cp2X, double cp2Y, double toX, double toY) {
        this.add(new Bezier2(cp1X, cp1Y, cp2X, cp2Y, toX, toY));
        return this;
    }

    Path2D.Double build() {
        Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        for (ShapeItem item : this) {
            if (item instanceof Line2) {
                path.lineTo(item.to.x, item.to.y);
            } else if (item instanceof Move2) {
                path.lineTo(item.to.x, item.to.y);
            } else if (item instanceof Quad2) {
                path.quadTo(((Quad2) item).cp.x, ((Quad2) item).cp.y, item.to.x, item.to.y);
            } else if (item instanceof Bezier2) {
                path.curveTo(((Bezier2) item).cp1.x, ((Bezier2) item).cp2.y, ((Bezier2) item).cp1.x, ((Bezier2) item).cp2.y, item.to.x, item.to.y);
            } else {
                throw new java.lang.IllegalArgumentException(new StringBuilder(item.getClass().getName()).append(" is not supported.").toString());
            }
        }
        return path;
    }

}
