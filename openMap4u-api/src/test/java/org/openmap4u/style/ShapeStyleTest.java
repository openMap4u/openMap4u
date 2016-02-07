package org.openmap4u.style;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class ShapeStyleTest {
	
	private ShapeStyle  shapeStyle = null;
	private ShapeStyle  clonedShapeStyle = null;

	@Before 
	public void before()   {
		shapeStyle = new ShapeStyle().alpha(0.3).visible(false).strokeColor(Color.BLACK).strokeSize(3).strokeFill(Color.GRAY);
		clonedShapeStyle = (ShapeStyle)shapeStyle.clone();
		clonedShapeStyle.alpha(0.4).visible(true).strokeColor(Color.RED).strokeSize(5).strokeFill(Color.GREEN);
	}
	
	@Test
	public void testCloneVisible() {
		assertThat("visible property ",clonedShapeStyle.isVisible(), is(true));
		assertThat("visible property ",shapeStyle.isVisible(), is(false));
	}
	
	@Test
	public void testCloneAlpha() {
		assertThat("alpha property ",clonedShapeStyle.getAlpha(), is(0.4));
		assertThat("alpha property ",shapeStyle.getAlpha(), is(0.3));
	}
	
	@Test
	public void testStrokeColor() {
		assertThat("strokeColor property ",clonedShapeStyle.getStrokeColor(), is(Color.RED));
		assertThat("strokeColor property ",shapeStyle.getStrokeColor(), is(Color.BLACK));
	}
	
	@Test
	public void testStrokeSize() {
		assertThat("strokeSize property ",clonedShapeStyle.getStrokeSize(), is(5d));
		assertThat("strokeSize property ",shapeStyle.getStrokeSize(), is(3d));
	}
	
	@Test
	public void testFillColor() {
		assertThat("strokeFill property ",clonedShapeStyle.getStrokeFill(), is(Color.GREEN));
		assertThat("strokeFill property ",shapeStyle.getStrokeFill(), is(Color.GRAY));
	}
	
	public void testEquals() {
		assertThat("equals ",shapeStyle.equals(clonedShapeStyle), is(false));
		assertThat("equals ",shapeStyle.equals(shapeStyle), is(true));
	}
	
	 

}
