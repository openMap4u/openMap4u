package org.openmap4u.plugin.builder.core;

import java.awt.Paint;

import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.geom.Point;
import org.openmap4u.primitive.ShapeBuildable;
import org.openmap4u.style.ShapeStyleBuildable;

public class Shape extends ShapeBuilder<Shape> implements ShapeStyleBuildable<Shape>,ShapeBuildable<Shape> {

	@Override
	public Shape bezierTo(Point controlPoint1, Point controlPoint2,
			 Point toPoint) {
		this.getDrawable().getPrimitive().bezierTo(controlPoint1, controlPoint2, toPoint);
		return this;
	}

	@Override
	public Shape lineTo( Point toPoint) {
		this.getDrawable().getPrimitive().lineTo(toPoint);
		return this;
	}

	@Override
	public Shape moveTo( Point toPoint) {
		this.getDrawable().getPrimitive().moveTo(toPoint);

		return this;
	}

	@Override
	public Shape quadTo(Point controlPoint,  Point toPoint) {
		this.getDrawable().getPrimitive().quadTo(controlPoint, toPoint);
		return this;
	}

	@Override
	public Shape shape(java.awt.Shape shape) {
		this.getDrawable().getPrimitive().shape(shape);
		return this;
	}

	@Override
	public Shape add(java.awt.Shape shape) {
		this.getDrawable().getPrimitive().add(shape);
		return this;
	}

	@Override
	public Shape intersect(java.awt.Shape shape) {
		this.getDrawable().getPrimitive().intersect(shape);
		return this;
	}

	@Override
	public Shape subtract(java.awt.Shape shape) {
		this.getDrawable().getPrimitive().subtract(shape);
		return this;
	}

	@Override
	public Shape exclusiveOr(java.awt.Shape shape) {
		this.getDrawable().getPrimitive().exclusiveOr(shape);
		return this;
	}

	@Override
	public Shape strokeColor(Paint color) {
		this.getDrawable().getStyle().strokeColor(color);
		return this;
	}

	@Override
	public Shape strokeSize(double strokeSize) {
		this.getDrawable().getStyle().strokeSize(strokeSize);
		return this;
	}

	@Override
	public Shape strokeFill(Paint fill) {
		this.getDrawable().getStyle().strokeFill(fill);
		return this;
	}

}
