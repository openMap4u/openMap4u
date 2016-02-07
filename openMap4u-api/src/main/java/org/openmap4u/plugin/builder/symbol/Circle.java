package org.openmap4u.plugin.builder.symbol;

import java.awt.Paint;
import java.awt.geom.Ellipse2D;

import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.style.ShapeStyleBuildable;

/**
 * Circle symbol.
 *
 * @author Michael Hadrbolec
 */
public class Circle extends ShapeBuilder<Circle>implements ShapeStyleBuildable<Circle>, Symbol {

	private static final Ellipse2D.Double DEFAULT_ELLIPSE_SYMBOL = getEllipse(DEFAULT_SYMBOL_SIZE, DEFAULT_SYMBOL_SIZE);

	/**
	 * Creates a new circle symbol.
	 */
	public Circle() {
		this.getDrawable().getPrimitive().shape(DEFAULT_ELLIPSE_SYMBOL);
	}

	/**
	 * Sets the diameter of the circle.
	 *
	 * @param diameter
	 *            The diameter of the circle symbol.
	 * @return The Buildable itself (method chaining pattern).
	 */
	public Circle diameter(double diameter) {
		this.getDrawable().getPrimitive().shape(getEllipse(diameter, diameter));
		return this;
	}

	/**
	 * Sets the radius of the circle symbol.
	 *
	 * @param radius
	 *            The radius of the circle symbol.
	 * @return The Buildable itself (method chaining pattern).
	 */
	public Circle radius(double radius) {
		return this.diameter(radius * 2);
	}

	public Circle strokeColor(Paint strokeColor) {
		getDrawable().getStyle().strokeColor(strokeColor);
		return this;
	}

	@Override
	public Circle strokeFill(Paint strokeFill) {
		getDrawable().getStyle().strokeFill(strokeFill);
		return this;
	}

	@Override
	public Circle strokeSize(double strokeSize) {
		getDrawable().getStyle().strokeSize(strokeSize);
		return this;
	}

	/**
	 * Internal Helper to create a ellipse.
	 *
	 * @param width
	 *            The width.
	 * @param height
	 *            The height.
	 * @return The ellipse.
	 */
	static Ellipse2D.Double getEllipse(double width, double height) {
		return new Ellipse2D.Double(-width / 2, -height / 2, width, height);
	}
}
