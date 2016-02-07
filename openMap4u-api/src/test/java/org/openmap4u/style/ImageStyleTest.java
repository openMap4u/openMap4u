package org.openmap4u.style;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ImageStyleTest {
	
	private ImageStyle  imageStyle = null;
	private ImageStyle  clonedImageStyle = null;

	@Before 
	public void before()   {
		imageStyle = new ImageStyle().alpha(0.3).visible(false);
		clonedImageStyle = (ImageStyle)imageStyle.clone();
		clonedImageStyle.alpha(0.4).visible(true);
	}
	
	@Test
	public void testCloneVisible() {
		assertThat("visible property ",clonedImageStyle.isVisible(), is(true));
		assertThat("visible property ",imageStyle.isVisible(), is(false));
	}
	
	@Test
	public void testCloneAlpha() {
		assertThat("alpha property ",clonedImageStyle.getAlpha(), is(0.4));
		assertThat("alpha property ",imageStyle.getAlpha(), is(0.3));
	}
	
	public void testEquals() {
		assertThat("equals ",clonedImageStyle.equals(imageStyle), is(false));
		assertThat("equals ",imageStyle.equals(imageStyle), is(true));
	}
	 

}
