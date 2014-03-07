/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import org.openmap4u.commons.SIPrefix;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 *
 * @author zwotti
 */
public class SIPrefixTest {

    /**
     * Test of values method, of class SIPrefix.
     */
    @Test
    public void testValues() {
        assertThat(SIPrefix.values().length, is(21));
    }

    /**
     * Test of getMultiplicationFactor method, of class SIPrefix.
     */
    @Test
    public void testGetMultiplicationFactor() {
        assertThat(SIPrefix.CENTI.getMultiplicationFactor2SI(), is(1 / 100d));
        assertThat(SIPrefix.KILO.getMultiplicationFactor2SI(), is(1000d));

    }

    /**
     * Test of getSymbol method, of class SIPrefix.
     */
    @Test
    public void testGetSymbol() {
        assertThat(SIPrefix.CENTI.getSymbol(), is("c"));
        assertThat(SIPrefix.KILO.getSymbol(), is("k"));
        assertThat(SIPrefix.NONE.getSymbol(), is(""));

    }

    /**
     * Test of getPrefix method, of class SIPrefix.
     */
    @Test
    public void testGetPrefix() {
        assertThat(SIPrefix.CENTI.getPrefix(), is("centi"));
        assertThat(SIPrefix.KILO.getPrefix(), is("kilo"));
        assertThat(SIPrefix.NONE.getPrefix(), is(""));
    }

    /**
     * Test of parse method, of class SIPrefix.
     */
    @Test
    public void testParse() {
        assertThat(SIPrefix.parse("mm"), is(SIPrefix.MILLI));
        assertThat(SIPrefix.parse("km"), is(SIPrefix.KILO));
        assertThat(SIPrefix.parse("m"), is(SIPrefix.NONE));
    }
}