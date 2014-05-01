/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import org.openmap4u.commons.Transparence;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author Michael Hadrbolec
 */
public class TransparenceTest {

    /**
     * Test of convert2SI method, of class Transparence.
     */
    @Test
    public void testConvert2SI() {
        assertEquals(Transparence.ALPHA.convertTo(1), 1, 0.0001);
        assertEquals(Transparence.ALPHA.convertTo(0), 0, 0.0001);
        assertEquals(Transparence.PERCENT.convertTo(0), 1, 0.0001);
        assertEquals(Transparence.PERCENT.convertTo(100), 0, 0.0001);
    }

    /**
     * Test of convertFromSI method, of class Transparence.
     */
    @Test
    public void testConvertFromSI() {
        assertEquals(Transparence.ALPHA.convertFrom(1), 1, 0.0001);
        assertEquals(Transparence.ALPHA.convertFrom(0), 0, 0.0001);
        assertEquals(Transparence.PERCENT.convertFrom(1), 0, 0.0001);
        assertEquals(Transparence.PERCENT.convertFrom(0), 100, 0.0001);
    }

    /**
     * Test of convert method, of class Transparence.
     */
    @Test
    public void testConvert() {
        assertEquals(Transparence.PERCENT.convertTo(100, Transparence.ALPHA), 0, 0.0001);
        assertEquals(Transparence.PERCENT.convertTo(0, Transparence.ALPHA), 1, 0.0001);
        assertEquals(Transparence.ALPHA.convertTo(0, Transparence.PERCENT), 100, 0.0001);
        assertEquals(Transparence.ALPHA.convertTo(1, Transparence.PERCENT), 0, 0.0001);

    }
}