package org.openmap4u.style;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class TextStyleTest {
	
	private TextStyle  textStyle = null;
	private TextStyle  clonedTextStyle = null;
	
	@Before 
	public void before()   {
		textStyle = new TextStyle().alpha(0.3).visible(false).fontColor(Color.BLACK).fontFamily("myFamily").fontSize(3).fontStyle(FontStyle.NORMAL).fontWeight(FontWeight.NORMAL);
		clonedTextStyle = (TextStyle)textStyle.clone();
		clonedTextStyle.alpha(0.4).visible(true).fontColor(Color.RED).fontFamily("yourFamily").fontSize(5).fontStyle(FontStyle.ITALIC).fontWeight(FontWeight.BOLD);
	}
	
	@Test
	public void testCloneVisible() {
		assertThat("visible property ",clonedTextStyle.isVisible(), is(true));
		assertThat("visible property ",textStyle.isVisible(), is(false));
	}
	
	@Test
	public void testCloneAlpha() {
		assertThat("alpha property ",clonedTextStyle.getAlpha(), is(0.4));
		assertThat("alpha property ",textStyle.getAlpha(), is(0.3));
	}
	
	@Test
	public void testCloneFontColor() {
		assertThat("fontColor property ",clonedTextStyle.getFontColor(), is(Color.RED));
		assertThat("fontColor property ",textStyle.getFontColor(), is(Color.BLACK));
	}
	
	@Test
	public void testCloneFontFamily() {
		assertThat("fontFamily property ",clonedTextStyle.getFontFamily(), is("yourFamily"));
		assertThat("fontFamily property ",textStyle.getFontFamily(), is("myFamily"));
	}
	
	@Test
	public void testCloneFontSize() {
		assertThat("fontSize property ",clonedTextStyle.getFontSize(), is(5d));
		assertThat("fontSize property ",textStyle.getFontSize(), is(3d));
	}
	
	@Test
	public void testCloneFontStyle() {
		assertThat("fontStyle property ",clonedTextStyle.getFontStyle(), is(FontStyle.ITALIC));
		assertThat("fontStyle property ",textStyle.getFontStyle(), is(FontStyle.NORMAL));
	}
	
	@Test
	public void testCloneFontWeight() {
		assertThat("fontWeight property ",clonedTextStyle.getFontWeight(), is(FontWeight.BOLD));
		assertThat("fontWeight property ",textStyle.getFontWeight(), is(FontWeight.NORMAL));
	}
	
	public void testEquals() {
		assertThat("equals ",textStyle.equals(clonedTextStyle), is(false));
		assertThat("equals ",textStyle.equals(textStyle), is(true));
	}


}
