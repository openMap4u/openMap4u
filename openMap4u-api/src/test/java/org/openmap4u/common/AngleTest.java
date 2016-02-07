package org.openmap4u.common;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AngleTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { Angle.DEGREE, 2*Math.PI/360 },   { Angle.RADIANT, 1 } });
	}

	private Angle angularUnit;

	private double expected;

	public AngleTest(Angle angularUnit , double expected) {
		this.angularUnit = angularUnit ;
		this.expected = expected;
	}

	@Test
	public void testConvert() {
		assertThat(angularUnit.name(), angularUnit.convert(1), is(expected));
	}

}
