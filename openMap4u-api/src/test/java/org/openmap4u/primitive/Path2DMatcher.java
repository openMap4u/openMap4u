package org.openmap4u.primitive;

import java.awt.Shape;
import java.awt.geom.PathIterator;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class Path2DMatcher extends TypeSafeMatcher<Shape> {

	private final Shape expected;

	public Path2DMatcher(Shape expected) {
		this.expected = expected;
	}

	@Override
	public boolean matchesSafely(Shape actual) {
		PathIterator expectedPathIterator = expected.getPathIterator(null);
		PathIterator actualPathIterator = actual.getPathIterator(null);
		double[] expectedCoords = null;
		double[] actualCoords = null;
		while (expectedPathIterator.isDone()) {
			try {
				int expectedType = expectedPathIterator
						.currentSegment(expectedCoords);
				int actualType = actualPathIterator
						.currentSegment(actualCoords);
				if (actualType != expectedType
						|| actualCoords != expectedCoords) {
					return false;
				}
				expectedPathIterator.next();
				actualPathIterator.next();

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	@Override
	public void describeTo(Description descr) {
		descr.appendText("expected result from isPath2D(): ").appendValue("--");
	}

	@Factory
	public static Path2DMatcher isPath2D(Shape expected) {
		return new Path2DMatcher(expected);
	}
}
