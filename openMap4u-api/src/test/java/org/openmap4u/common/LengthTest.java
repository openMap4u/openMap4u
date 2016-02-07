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
public class LengthTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { Length.MM, 0.001 }, { Length.CM, 0.01 }, { Length.M, 1 },
				{ Length.KM, 1000 }, { Length.INCH, 0.0254 }, { Length.POINT, 3.5278E-4 }, { Length.PIXEL_96DPI, 0.0254/96 } });
	}

	private Length lengthUnit;

	private double expected;

	public LengthTest(Length lengthUnit, double expected) {
		this.lengthUnit = lengthUnit;
		this.expected = expected;
	}

	@Test
	public void testConvert() {
		assertThat(lengthUnit.name(), lengthUnit.convert(1), is(expected));
	}

}
