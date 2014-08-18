/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.builder.projection;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;

/**
 *
 * @author hadrbolec
 */
public class Projection {
	
	
	private Axis mXAxis;
	
	private Axis mYAxis;
	

	public Projection(Axis xAxis, Axis yAxis) {
	}

	Shape getShape(Shape shape) {
		PathIterator pi = shape.getPathIterator(null);
		Path2D.Double path2D = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		float coords[] = new float[6];
		while (!pi.isDone()) {
			switch (pi.currentSegment(coords)) {
			case PathIterator.SEG_MOVETO:
			//	path2D.moveTo(coords, y);
				break;
			case PathIterator.SEG_LINETO:
				//path2D.lineTo(x, y);
				break;
			case PathIterator.SEG_QUADTO:
				//path2D.quadTo(x1, y1, x2, y2);
				break;
			case PathIterator.SEG_CUBICTO:
			//	path2D.curveTo(x1, y1, x2, y2, x3, y3);
				break;
			case PathIterator.SEG_CLOSE:
			//	path2D.closePath();
				break;
			}
			pi.next();
		}
		return null;
	}

	double [] transform(double x, double y) {
		return new double [] {mXAxis.getValue(x, y),mYAxis.getValue(x, y)};
	}

	double [] transform(double [] coords) {
		double [] coords1 = transform(coords[0],coords[1]);
		double [] coords2 = transform(coords[2],coords[3]);
		double [] coords3 = transform(coords[4],coords[5]);
		return new double [] {coords1[0],coords1[1],coords2[0],coords2[1],coords3[0],coords3[1]};

	}

 


	
}
