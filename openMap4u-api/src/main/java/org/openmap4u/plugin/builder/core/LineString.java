package org.openmap4u.plugin.builder.core;

import java.awt.Paint;
import java.awt.Shape;

import org.openmap4u.builder.LineStringBuilder;
import org.openmap4u.geom.Point;
import org.openmap4u.primitive.LineStringBuildable;
import org.openmap4u.style.LineStringStyleBuildable;

public class LineString extends LineStringBuilder<LineString> implements LineStringBuildable<LineString>,LineStringStyleBuildable<LineString> {

	@Override
	public LineString strokeColor(Paint color) {
		this.getDrawable().getStyle().strokeColor(color);
 		return this;
	}

	@Override
	public LineString strokeSize(double strokeSize) {
		this.getDrawable().getStyle().strokeSize(strokeSize);
 		return this;
	}

	@Override
	public LineString bezierTo(Point controlPoint1, Point controlPoint2, Point toPoint) {
		this.getDrawable().getPrimitive().bezierTo(controlPoint1, controlPoint2, toPoint);
		return this;
	}

	@Override
	public LineString lineTo( Point toPoint) {
		this.getDrawable().getPrimitive().lineTo(toPoint);
		return this;
	}

	@Override
	public LineString moveTo( Point toPoint) {
		this.getDrawable().getPrimitive().moveTo(toPoint);
		return this;
	}

	@Override
	public LineString quadTo(Point controlPoint,  Point toPoint) {
		this.getDrawable().getPrimitive().quadTo(controlPoint, toPoint);
		return this;
	}

	@Override
	public LineString shape(Shape shape) {
		this.getDrawable().getPrimitive().shape(shape);
		return this;
	}

}
