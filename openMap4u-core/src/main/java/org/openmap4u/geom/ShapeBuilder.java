/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.geom;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.util.LinkedList;

/**
 *
 * @author Michael Hadrbolec
 */
public class ShapeBuilder extends LinkedList<PathFragment> {

	/**
	 * The generated serialVersionUID.
	 */
	private static final long serialVersionUID = -4401254286140045853L;

	public ShapeBuilder move2(double toX, double toY) {
		this.add(new PathFragment.Move2(toX, toY));
		return this;
	}

	@SuppressWarnings("null")
	public ShapeBuilder shape(Shape shape) {
		PathIterator iterator = shape.getPathIterator(null);
		double[] coords = null;
		while (!iterator.isDone()) {
			int fragType = iterator.currentSegment(coords);
			if (fragType == PathIterator.SEG_MOVETO) {
				move2(coords[0],coords[1]);
			} else if (fragType == PathIterator.SEG_LINETO) {
				line2(coords[0],coords[1]);
			} else if (fragType == PathIterator.SEG_QUADTO) {
				quad2(coords[0],coords[1],coords[2],coords[3]);
			} else if (fragType == PathIterator.SEG_CUBICTO) {
				bezier2(coords[0],coords[1],coords[2],coords[3],coords[3],coords[4]);
			} else {
				throw new IllegalArgumentException("Unsupported path fragment "+fragType);
			}
			iterator.next();
		}
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

	public ShapeBuilder bezier2(double cp1X, double cp1Y, double cp2X,
			double cp2Y, double toX, double toY) {
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
				path.quadTo(item.points[1].getX(), item.points[1].getY(),
						item.points[0].getX(), item.points[0].getY());
			} else if (item.type == FragmentType.BEZIER2) {
				path.curveTo(item.points[1].getX(), item.points[1].getY(),
						item.points[2].getX(), item.points[2].getY(),
						item.points[0].getX(), item.points[0].getY());
			} else {
				throw new java.lang.IllegalArgumentException(new StringBuilder(
						item.getClass().getName()).append(" is not supported.")
						.toString());
			}
		}
		return path;
	}

}
