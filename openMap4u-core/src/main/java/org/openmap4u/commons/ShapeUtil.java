/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import java.awt.Shape;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hadrbolec
 */
public class ShapeUtil {

    Point2D.Double getFirst(Shape shape) {
        return getVertices(shape).get(0);
    }

    Point2D.Double getLastPoint(Shape shape) {
        List<Point2D.Double> vertices = getVertices(shape);
        return getVertices(shape).get(vertices.size() - 1);
    }

    List<Point2D.Double> getVertices(Shape shape) {
        List<Point2D.Double> vertices = new ArrayList<>();
        PathIterator pI = shape.getPathIterator(null);
        double [] coords  = null;
        while (pI.isDone()) {
            int type = pI.currentSegment(coords);
            switch (type) {
                case PathIterator.SEG_MOVETO:
                    vertices.add(new Point2D.Double(coords[0],coords[1]));
                    break;
                case PathIterator.SEG_LINETO:
                    vertices.add(new Point2D.Double(coords[0],coords[1]));
                    break;
                case PathIterator.SEG_QUADTO:
                    vertices.add(new Point2D.Double(coords[2],coords[3]));
                    break;
                case PathIterator.SEG_CUBICTO:
                    vertices.add(new Point2D.Double(coords[4],coords[5]));
                    break;
                default:
                	break;
            }
           pI.next();
        }
        return vertices;
    }
}
