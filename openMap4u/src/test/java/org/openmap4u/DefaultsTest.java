package org.openmap4u;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.openmap4u.unit.Length;

/**
 *
 * @author zwotti
 */
public class DefaultsTest {

	private Defaults mDefaults = null;

    /**
     *
     */
    @Before
	public void setUp() {
		this.mDefaults = new Defaults();
	}

    /**
     *
     */
    @Test
	public void testGetDrawingUnits() {
		assertThat(this.mDefaults.getDrawingUnits(), notNullValue());

	}

    /**
     *
     */
    @Test
	public void testSetDrawingUnits() {
		this.mDefaults.setDrawingUnits(Length.INCH);
		assertThat(this.mDefaults.getDrawingUnits(), is(Length.INCH));
		this.mDefaults.setDrawingUnits(Length.MM);
		assertThat(this.mDefaults.getDrawingUnits(), is(Length.MM));
	}

    /**
     *
     */
    @Test
	public void testGetStrokeUnits() {
		assertThat(this.mDefaults.getStrokeUnits(), notNullValue());

	}

    /**
     *
     */
    @Test
	public void testSetStrokeUnits() {
		this.mDefaults.setStrokeUnits(Length.INCH);
		assertThat(this.mDefaults.getStrokeUnits(), is(Length.INCH));
		this.mDefaults.setStrokeUnits(Length.MM);
		assertThat(this.mDefaults.getStrokeUnits(), is(Length.MM));

	}

    /**
     *
     */
    @Test
	public void testGetWorldUnits() {
		assertThat(this.mDefaults.getWorldUnits(), notNullValue());

	}

    /**
     *
     */
    @Test
	public void testSetWorldUnits() {
		this.mDefaults.setWorldUnits(Length.INCH);
		assertThat(this.mDefaults.getWorldUnits(), is(Length.INCH));
		this.mDefaults.setWorldUnits(Length.MM);
		assertThat(this.mDefaults.getWorldUnits(), is(Length.MM));

	}

    /**
     *
     */
    @Test
	public void testGetLocale() {
		assertThat(mDefaults.getLocale(), is(Locale.getDefault()));
	}

    /**
     *
     */
    @Test
	public void testSetLocale() {
		this.mDefaults.setLocale(Locale.JAPANESE);
		assertThat(mDefaults.getLocale(), is(Locale.JAPANESE));
		this.mDefaults.setLocale(Locale.GERMAN);
		assertThat(mDefaults.getLocale(), is(Locale.GERMAN));

	}

}
