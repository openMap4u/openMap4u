package org.openmap4u.geom;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class GeomUtilTest {
	
	private GeomUtil gu1 = null;
	private GeomUtil gu2 = null;
 
	@Before
	public void beforeClass() {
		gu1 = new GeomUtil();
		gu2 = new GeomUtil();
		gu2.convert(12,14);
	}

	@Test
	public void testConvertDoubleDouble() {
		assertThat(gu1.convert(23, 24),is(new Point.Double(23,24)));
		assertThat(gu2.convert(23, 24),is(new Point.Double(23,24)));

	}

	@Test
	public void testConvertStringDouble() {
		assertThat(gu1.convert("@23", 24),is(new Point.Double(23,24)));
		assertThat(gu2.convert("@23", 24),is(new Point.Double(35,24)));
	}

	@Test
	public void testConvertDoubleString() {
		assertThat(gu1.convert(23, "@24"),is(new Point.Double(23,24)));
		assertThat(gu2.convert(23, "@24"),is(new Point.Double(23,38)));
	}

	@Test
	public void testConvertStringString() {
		assertThat(gu1.convert("@23", "@24"),is(new Point.Double(23,24)));
		assertThat(gu2.convert("@23", "@24"),is(new Point.Double(35,38)));
	}

	 

}
