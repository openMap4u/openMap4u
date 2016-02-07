package org.openmap4u.primitive;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TextPrimitiveTest {
	
	private TextPrimitive textPrimitive = null;
	 	
	@Before
	public void test() {
		textPrimitive=new TextPrimitive();
	}

 

	@Test
	public void testTextStringObjectArray() {
		assertThat(textPrimitive.text("hello %s", "world").getText(),is("hello world"));
	}

	@Test
	public void testGetText() {
		assertThat(textPrimitive.text("hello world").getText(),is("hello world"));
	}
	
	
	@Test
	public void testClone() throws CloneNotSupportedException {
		 textPrimitive.text("hello world") ;
		 TextPrimitive clonedTextPrimitive =  (TextPrimitive) textPrimitive.clone();
		 clonedTextPrimitive.text("42");
		 assertThat(textPrimitive.getText(),not(clonedTextPrimitive.getText()));
 	}

}
