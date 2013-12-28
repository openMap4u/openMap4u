/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.unit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Michael Hadrbolec
 */
public class LengthTest {

	private Length mKM = null;
	private Length mM = null;
	private Length mCM = null;
	private Length mMM = null;
	private Length mInch = null;
	private Length mPixel = null;
	private Length mPoint = null;

    /**
     *
     */
    @Before
	public void setUp() {
		mKM = Length.KM;
		mM = Length.M;
		mCM = Length.CM;
		mMM = Length.MM;
		mInch = Length.INCH;
		mPixel = Length.PIXEL;
		mPoint = Length.POINT;
	}

	/**
	 * Test of convert2M method, of class Unit.
	 */
	@Test
	public void testConvert2M() {
		assertThat(mKM.convert(1), is(1000d));
		assertThat(mM.convert(1), is(1d));
		assertThat(mCM.convert(1), is(1 / 100d));
		assertThat(mMM.convert(1), is(1 / 1000d));
		assertThat(mInch.convert(1), is(0.0254));
	}

	/**
	 * Test of convertM2Unit method, of class Unit.
	 */
	@Test
	public void testConvertM2Unit() {
		assertThat(mKM.convertFromSI(1), is(1 / 1000d));
		assertThat(mM.convertFromSI(1), is(1d));
		assertThat(mCM.convertFromSI(1), is(100d));
		assertThat(mMM.convertFromSI(1), is(1000d));
		assertThat(mInch.convertFromSI(1), is(100 / 2.54));
	}

	/**
	 * Test of convert method, of class Unit.
	 */
	@Test
	public void testConvert() {
		assertThat(mM.convert(1, Length.KM), is(1 / 1000d));
		assertThat(mM.convert(1, Length.CM), is(100d));
		assertThat(mM.convert(1, Length.MM), is(1000d));
	}

    /**
     *
     */
    @Test
	public void testConvertInch() {
		assertThat(mInch.convert(1, Length.CM), is(2.54));

	}

    /**
     *
     */
    @Test
	public void testConvertCm() {
		assertEquals(mCM.convert(1, Length.INCH), 1 / 2.54, 0.000001);

	}

    /**
     *
     */
    @Test
	public void testConvertCssUnits() {
		assertEquals(mPixel.convert(1, Length.MM), .264583333333, 0.000001);
		assertEquals(mPoint.convert(1, Length.PIXEL), 96.0 / 72.0, 0.0000001);
		assertEquals(mPixel.convert(1, Length.POINT), 72.0 / 96.0, 0.000001);
	}
}