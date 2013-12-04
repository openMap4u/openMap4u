/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.experimental;

import java.awt.Stroke;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

class DoubleStroke implements Stroke
{
	private Stroke stroke;
	private float dist;

	public DoubleStroke(Stroke stroke, float dist)
	{
		this.stroke = stroke;
		this.dist = dist;
	}

	public java.awt.Shape createStrokedShape(java.awt.Shape shape)
	{
		// todo: set smaller flatness if drawing curves
		PathIterator it = new FlatteningPathIterator(shape.getPathIterator(null), 1);
		
		// collect path points
		ArrayList<ArrayList<Point2D>> openFigures = new ArrayList<ArrayList<Point2D>>();
		ArrayList<ArrayList<Point2D>> closedFigures = new ArrayList<ArrayList<Point2D>>();
		ArrayList<Point2D> currentFigure = null;

		float[] segmentPoints = new float[6];
		float moveX = 0, moveY = 0;
		float thisX = 0, thisY = 0;
		int type = 0;

		while (!it.isDone())
		{
			type = it.currentSegment(segmentPoints);
			switch(type)
			{
			case PathIterator.SEG_MOVETO:
				moveX = segmentPoints[0];
				moveY = segmentPoints[1];

				if (currentFigure != null)
					openFigures.add(currentFigure);
				currentFigure = null;
				break;

			case PathIterator.SEG_CLOSE:
				if (currentFigure.get(0).equals(currentFigure.get(currentFigure.size() - 1)))
					currentFigure.remove(currentFigure.size() - 1);
				closedFigures.add(currentFigure);
				currentFigure = null;
				break;

			case PathIterator.SEG_LINETO:
				if (currentFigure == null)
				{
					currentFigure = new ArrayList<Point2D>();
					addNoRepeat(currentFigure, new Point2D.Float(moveX, moveY));
				}
				thisX = segmentPoints[0];
				thisY = segmentPoints[1];
				addNoRepeat(currentFigure, new Point2D.Float(thisX, thisY));
				break;
			}
			it.next();
		}
		if (currentFigure != null)
			openFigures.add(currentFigure);

		GeneralPath result = new GeneralPath();
		
		// for closed figures, create inner and outer polygons
		for (ArrayList<Point2D> closedFigure : closedFigures)
			createInnerAndOuterShapes(closedFigure, result, dist);
		for (ArrayList<Point2D> openFigure : openFigures)
			addPolygon(openFigure, result, false);
		return stroke.createStrokedShape(result);
	}
	
	private void addNoRepeat(ArrayList<Point2D> points, Point2D p)
	{
		if (points.size() == 0 || !points.get(points.size() - 1).equals(p))
			points.add(p);
	}
	
	private void createInnerAndOuterShapes(ArrayList<Point2D> points, GeneralPath result, float dist)
	{
		GeneralPath path = new GeneralPath();
		addPolygon(points, path, true);

		ArrayList<Point2D> inner = new ArrayList<Point2D>();
		ArrayList<Point2D> outer = new ArrayList<Point2D>();

		int last = points.size() - 1;
		for (int i = 0; i < points.size(); i++)
		{
			Point2D prev = points.get(i == 0 ? last : i - 1);
			Point2D curr = points.get(i);
			Point2D next = points.get(i == last ? 0 : i + 1);
			
			double dx1 = curr.getX() - prev.getX();
			double dy1 = curr.getY() - prev.getY();
			double len1 = Math.sqrt(dx1 * dx1 + dy1 * dy1);
			
			double dx2 = curr.getX() - next.getX();
			double dy2 = curr.getY() - next.getY();
			double len2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);
			
			double dxm = (dx1 / len1 + dx2 / len2) / 2;
			double dym = (dy1 / len1 + dy2 / len2) / 2;
			
			double dotProduct = dx1 * dx2 + dy1 * dy2; 
			double angle = Math.acos(dotProduct / (len1 * len2));
			double dist2 = Math.abs(dist / Math.sin(angle / 2));
			
			double len = Math.sqrt(dxm * dxm + dym * dym);
			dxm *= dist2 / len;
			dym *= dist2 / len;
			
			Point2D p1 = new Point2D.Double(curr.getX() - dxm, curr.getY() - dym);
			Point2D p2 = new Point2D.Double(curr.getX() + dxm, curr.getY() + dym);
			
			if (path.contains(p1))
			{
				inner.add(p1);
				outer.add(p2);
			}
			else
			{
				outer.add(p1);
				inner.add(p2);
			}
		}
		
		// todo: could use the outer path according to
		// some inset/center/outset path for the double stroke
		addPolygon(points, result, true);
		addPolygon(inner, result, true);
	}
	
	private Rectangle2D fromPoints(ArrayList<Point2D> points)
	{
		Point2D p1 = points.get(0);
		Rectangle2D r = new Rectangle2D.Double(p1.getX(), p1.getY(), 0, 0);
		for (Point2D p : points)
			r.add(p);
		return r;
	}
	
	private void addPolygon(ArrayList<Point2D> points, GeneralPath result, boolean close)
	{
		Point2D p = points.get(0);
		result.moveTo((float)p.getX(), (float)p.getY());
		for (int i = 1; i < points.size(); i++)
		{
			p = points.get(i);
			result.lineTo((float)p.getX(), (float)p.getY());
		}
		
		result.closePath();
	}
}