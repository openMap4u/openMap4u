package org.openmap4u;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.openmap4u.plugin.format.graphics2d.Png;

/**
 *
 * @author Michael Hadrbolec
 */
public class OutputFormatTest {

	private OutputFormat oF = null;

    /**
     *
     */
    @Before
	public void setUp() {
		oF = new OutputFormat(Png.class, "png");
	}

    /**
     *
     */
    @Test
	public void test() {
		assertThat(oF, notNullValue());
	}

    /**
     *
     */
    @Test
	public void testGetFileExtension() {
		assertThat(oF.getFileExtension(), is("png"));
	}

    /**
     *
     */
    @Test
	public void testGeOutputFormat() {
		assertThat(oF.getOutputableFormat().getName(),
				is(Png.class.getName()));
	}

    /**
     *
     */
    @Test
	public void testGetSimpleFileName() {
		assertThat(oF.getFileneame("test"), is("test.png"));
	}

    /**
     *
     */
    @Test
	public void testGetComplexFileName() {
		assertThat(oF.getFileneame("1", "2", "3"), is("1_2_3.png"));
	}

}
