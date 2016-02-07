package org.openmap4u.plugin.geom;

import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import org.openmap4u.geom.Path2DBuildable;
import org.openmap4u.geom.Point;

public class Path2DBuilderImpl implements Path2DBuildable<Path2DBuilderImpl> {

	/**
	 * Stores a reference to the path.
	 */
	private Path2D.Double mPath;

	public Path2DBuilderImpl() {
		this.mPath = new Path2D.Double(Path2D.WIND_EVEN_ODD);
	}

	@Override
	public Path2D.Double  build() {
		return mPath;
	}

	@Override
	public   Path2DBuilderImpl addPath(Path2DBuildable<Path2DBuilderImpl>  path2DBuilder) {
		this.mPath.append(path2DBuilder.build(), false);
		return this;
	}

	@Override
	public Path2DBuilderImpl closePath() {
		this.mPath.closePath();
		return this;
	}

	@Override
	public Path2DBuilderImpl moveTo(Point toPoint) {
		this.mPath.moveTo(getX(toPoint), getY(toPoint));
		return this;
	}

	@Override
	public Path2DBuilderImpl lineTo(Point toPoint) {
		this.mPath.lineTo(getX(toPoint), getY(toPoint));
		return this;
	}

	@Override
	public Path2DBuilderImpl bezierCurveTo(Point controlPoint1, Point controlPoint2, Point toPoint) {
		this.mPath.curveTo(getX(controlPoint1), getY(controlPoint1), getX(controlPoint2), getY(controlPoint2), getX(toPoint), getY(toPoint));
		return this;
	}

	@Override
	public Path2DBuilderImpl quadraticCurveTo(Point controlPoint, Point toPoint) {
		this.mPath.quadTo(getX(controlPoint), getY(controlPoint), getX(toPoint), getY(toPoint));
		return this;
	}

	@Override
	public Path2DBuilderImpl arc(Point position, double radius, double startAngle, double endAngle) {
		Arc2D arc = new Arc2D.Double();
		arc.setArcByCenter(getX(position), getY(position), radius, startAngle, endAngle, Arc2D.OPEN);
		this.mPath.append(arc, false);
		return this;
	}

	@Override
	public Path2DBuilderImpl arcTo(Point controlPoint1, Point controlPoint2, double radiusX, double radiusY, double rotation) {
		new Arc2D.Double();
		return this;

	}

	@Override
	public Path2DBuilderImpl ellipse(Point position, double radiusX, double radiusY) {
		Ellipse2D.Double ellipse= new Ellipse2D.Double();
		return this;
	}

	@Override
	public Path2DBuilderImpl rect(Point position, double width, double height) {
		new Rectangle2D.Double(getX(position), getY(position), width, height);
		return this;
	}

	double getX(Point point) {
		return 0;
	}

	double getY(Point point) {
		return 0;
	}

}
