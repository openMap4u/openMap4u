package org.openmap4u.style;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class LineStringStyleTest {
	
	private LineStringStyle  lineStringStyle = null;
	private LineStringStyle  clonedLineStringStyle = null;

	@Before 
	public void before()   {
		lineStringStyle = new LineStringStyle().alpha(0.3).visible(false).strokeColor(Color.BLACK).strokeSize(3);
		clonedLineStringStyle = (LineStringStyle)lineStringStyle.clone();
		clonedLineStringStyle.alpha(0.4).visible(true).strokeColor(Color.RED).strokeSize(5);
	}
	
	@Test
	public void testCloneVisible() {
		assertThat("visible property ",clonedLineStringStyle.isVisible(), is(true));
		assertThat("visible property ",lineStringStyle.isVisible(), is(false));
	}
	
	@Test
	public void testCloneAlpha() {
		assertThat("alpha property ",clonedLineStringStyle.getAlpha(), is(0.4));
		assertThat("alpha property ",lineStringStyle.getAlpha(), is(0.3));
	}
	
	@Test
	public void testStrokeColor() {
		assertThat("strokeColor property ",clonedLineStringStyle.getStrokeColor(), is(Color.RED));
		assertThat("strokeColor property ",lineStringStyle.getStrokeColor(), is(Color.BLACK));
	}
	
	@Test
	public void testStrokeSize() {
		assertThat("strokeSize property ",clonedLineStringStyle.getStrokeSize(), is(5d));
		assertThat("strokeSize property ",lineStringStyle.getStrokeSize(), is(3d));
	}
	
	public void testEquals() {
		assertThat("equals ",lineStringStyle.equals(clonedLineStringStyle), is(false));
		assertThat("equals ",lineStringStyle.equals(lineStringStyle), is(true));
	}

}
