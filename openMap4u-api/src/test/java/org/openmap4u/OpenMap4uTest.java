package org.openmap4u;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.openmap4u.builder.ImageBuilder;
import org.openmap4u.builder.TextBuilder;
import org.openmap4u.builder.LineStringBuilder;
import org.openmap4u.builder.ShapeBuilder;
import org.openmap4u.builder.UnsupportedBuilder;
import org.openmap4u.plugin.builder.core.Image;
import org.openmap4u.plugin.builder.core.Text;
import org.openmap4u.plugin.builder.core.LineString;
import org.openmap4u.plugin.builder.core.Shape;
 
public class OpenMap4uTest {
	
	private OpenMap4u openMap4u = null;
	
	 	
	@Before
	public void before() {
		openMap4u = new OpenMap4u();
	}

	@Test
	public void testInitalizeImageBuilderWithDefaultStyle() {
		ImageBuilder<Image> imageBuilder = openMap4u.get(Image.class);
		assertThat(imageBuilder.getDrawable().getStyle(),is(openMap4u.getDefaults().getImageStyle()));
	}
	

	@Test
	public void testInitalizeTextBuilderWithDefaultStyle() {
		TextBuilder<Text> textBuilder = openMap4u.get(Text.class);
		assertThat(textBuilder.getDrawable().getStyle(), is(openMap4u.getDefaults().getTextStyle()));
	}
	

	@Test
	public void testInitalizeLineStringBuilderWithDefaultStyle() {
		LineStringBuilder<LineString> lineStringBuilder = openMap4u.get(LineString.class);
		assertThat(lineStringBuilder.getDrawable().getStyle(),is(openMap4u.getDefaults().getLineStringStyle()));
	}
	

	@Test
	public void testInitalizeShapeBuilderWithDefaultStyle() {
		ShapeBuilder<Shape> shapeBuilder = openMap4u.get(Shape.class);
		assertThat(shapeBuilder.getDrawable().getStyle(),is(openMap4u.getDefaults().getShapeStyle()));
	}
	
	@Test(expected=IllegalArgumentException.class)
 	public void testInitalizeUnsupportedBuilderWithDefaultStyle() {
		UnsupportedBuilder unsupportedBuilder = openMap4u.get(UnsupportedBuilder.class);
		assertThat(unsupportedBuilder.getDrawable().getStyle(),is(openMap4u.getDefaults().getShapeStyle()));
	 
	}
	

	 

	@Test
	public void testGetDefaultsNotNull() {
		assertThat(openMap4u.getDefaults(), notNullValue());
	}

}
