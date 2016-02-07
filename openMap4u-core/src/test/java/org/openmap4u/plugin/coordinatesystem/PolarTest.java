package org.openmap4u.plugin.coordinatesystem;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import org.openmap4u.plugin.coordinatesystem.Cartesian;

public class PolarTest {
	
	private static final double TOLERANCE = 0.000001; 
	
	private Polar polar1 = null;
	private Polar polar2 = null;
 
	@Before
	public void beforeClass() {
		polar1 = new Polar();
		polar2 = new Polar();
		polar2.convert(10,90);
	}

	@Test
	public void testConvertDoubleDouble() {
		assertTrue(Math.abs(polar1.convert(10, 0).distance(10,0))<TOLERANCE);
		assertTrue(Math.abs(polar2.convert(10, 90).distance(0,10))<TOLERANCE);
	}

/*	@Test
	public void testConvertStringDouble() {
		assertTrue(Math.abs(polar1.convert("@10", 0).distance(10,0))<TOLERANCE);
		System.out.println(polar2.convert("@10", 0));
		assertTrue(Math.abs(polar2.convert("@10", 0).distance(0,20))<TOLERANCE);
	}
*/
/*	@Test
	public void testConvertDoubleString() {
		assertThat(polar1.convert(23, "@24"),is(new Point.Double(23,24)));
		assertThat(polar2.convert(23, "@24"),is(new Point.Double(23,38)));
	} */

/*	@Test
	public void testConvertStringString() {
		assertThat(polar1.convert("@23", "@24"),is(new Point.Double(23,24)));
		assertThat(polar2.convert("@23", "@24"),is(new Point.Double(35,38)));
	}
*/
	 

}
