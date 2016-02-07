package org.openmap4u.plugin.builder.core;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.openmap4u.draw.ImageDrawable;

public class ImageTest {
	
	Image image = null;
	
	@Before
	public void before() {}

	@Test
	public void testBuild() {
		
		assertThat(image.build(),instanceOf(ImageDrawable.class));
	}
	
	
	@Test
	public void testBuildImage() {
		
		assertThat(image.build(),instanceOf(ImageDrawable.class));
	}

}
