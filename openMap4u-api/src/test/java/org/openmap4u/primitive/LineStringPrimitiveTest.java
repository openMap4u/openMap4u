package org.openmap4u.primitive;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.openmap4u.primitive.Path2DMatcher.isPath2D;

import java.awt.geom.Path2D;

import org.junit.Before;
import org.junit.Test;
import org.openmap4u.geom.Point;

public class LineStringPrimitiveTest {

	private LineStringPrimitive lineStringPrimitive = null;
	private Path2D path2D = null;

	@Before
	public void before() {
		lineStringPrimitive = new LineStringPrimitive();
		lineStringPrimitive.moveTo(new Point(20d, 30d));
		path2D = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path2D.moveTo(20, 30);
	}

	@Test
	public void testBezierTo() {
		lineStringPrimitive.bezierTo(new Point(56, 67),new Point( 93, 76),new Point( 37, 42));
		path2D.curveTo(56, 67, 93, 76, 37, 42);
		assertThat(lineStringPrimitive.getPath2D(), isPath2D(path2D));
	}

	@Test
	public void testLineTo() {
		lineStringPrimitive.lineTo(new Point(25, 35));
		path2D.moveTo(25, 35);
		assertThat(lineStringPrimitive.getPath2D(), isPath2D(path2D));
	}

	@Test
	public void testMoveTo() {
		lineStringPrimitive.moveTo(new Point(40, 70));
		path2D.moveTo(40, 70);
		assertThat(lineStringPrimitive.getPath2D(), isPath2D(path2D));
	}

	@Test
	public void testQuadTo() {
		lineStringPrimitive.quadTo(new Point(40, 50), new Point(60, 70));
		path2D.quadTo(40, 50, 60, 70);
		assertThat(lineStringPrimitive.getPath2D(), isPath2D(path2D));

	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		lineStringPrimitive.quadTo(new Point(40, 50),new Point( 60, 70));
		LineStringPrimitive clonedLineStringPrimitive = (LineStringPrimitive) lineStringPrimitive
				.clone();
		clonedLineStringPrimitive.lineTo(new Point(23, 57));
		assertThat(lineStringPrimitive.getPath2D(),
				not(clonedLineStringPrimitive.getPath2D()));
	}

}
