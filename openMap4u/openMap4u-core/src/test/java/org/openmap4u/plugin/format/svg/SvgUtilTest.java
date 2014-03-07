package org.openmap4u.plugin.format.svg;

 import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;
import java.awt.geom.AffineTransform;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author zwotti
 */
public class SvgUtilTest {
	
	private SvgUtil sU = null;

    /**
     *
     */
    @Before
	public void setUp() {
		sU = new SvgUtil();
	}

    /**
     *
     */
    @Test
	public void testGetTransform() {
		assertThat(sU.getTransform(new AffineTransform(1,0,0,2,0,0)),is ("matrix(1.0,0.0,0.0,2.0,0.0,0.0)"));
 		assertThat(sU.getTransform(new AffineTransform(0,1,2,0,0,0)),is ("matrix(0.0,1.0,2.0,0.0,0.0,0.0)"));
	 		assertThat(sU.getTransform(new AffineTransform(0,0,0,0,1,2)),is ("matrix(0.0,0.0,0.0,0.0,1.0,2.0)"));
	}

    /**
     *
     */
    @Test
	public void testGetColor() {
		assertThat(sU.getColor(Color.RED),is("#ff0000"));
		assertThat(sU.getColor(Color.GREEN),is("#00ff00"));
		assertThat(sU.getColor(Color.BLUE),is("#0000ff"));
	}
	
	
	 


}
