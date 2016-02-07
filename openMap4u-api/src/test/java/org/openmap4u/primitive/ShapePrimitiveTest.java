package org.openmap4u.primitive;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.openmap4u.primitive.Path2DMatcher.isPath2D;

import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import org.junit.Before;
import org.junit.Test;
import org.openmap4u.geom.Point;

public class ShapePrimitiveTest {


	private ShapePrimitive shapePrimitive = null;
	private Area area = null;
	private Rectangle2D.Double rectangleA = null;
	private Rectangle2D.Double rectangleB = null;

	@Before
	public void before() {
		shapePrimitive = new ShapePrimitive();
		rectangleA = new Rectangle2D.Double(10,20,50,40);
		rectangleB = new Rectangle2D.Double(20,30,50,40);
		
		shapePrimitive.shape(rectangleA);
		area = new Area(rectangleA);
	}
	
	 
	@Test
	public void testAdd() {
		shapePrimitive.add(rectangleB);
		area.add(new Area(rectangleB));
		assertThat(shapePrimitive.getPath2D(),  isPath2D(area));
	}

 

	@Test
	public void testIntersect() {
		shapePrimitive.intersect(rectangleB);
		area.intersect(new Area(rectangleB));
		assertThat(shapePrimitive.getPath2D(),  isPath2D(area));
		 
	}

	@Test
	public void testSubtract() {
		shapePrimitive.subtract(rectangleB);
		area.subtract(new Area(rectangleB));
		assertThat(shapePrimitive.getPath2D(),  isPath2D(area));
	}

	@Test
	public void testExclusiveOr() {
		shapePrimitive.exclusiveOr(rectangleB);
		area.exclusiveOr(new Area(rectangleB));
		assertThat(shapePrimitive.getPath2D(),  isPath2D(area));
	}
	
	@Test
	public void testClone() throws CloneNotSupportedException {
		shapePrimitive.quadTo(new Point(40, 50),new Point( 60, 70));
		 ShapePrimitive clonedShapePrimitive =  (ShapePrimitive) shapePrimitive.clone();
		 clonedShapePrimitive.lineTo(new Point(23,57));
		 assertThat(shapePrimitive.getPath2D(),not(clonedShapePrimitive.getPath2D()));
 	}

}
