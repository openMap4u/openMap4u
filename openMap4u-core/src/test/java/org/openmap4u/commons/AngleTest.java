/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import org.openmap4u.commons.Angle;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author Michael Hadrbolec
 */
public class AngleTest {

   

    /**
     * Test of convert2SI method, of class Angle.
     */
    @Test
    public void testConvert2SI() {
        assertEquals(Angle.DEGREE.convert(0d), Math.toRadians(0), 0.00001);
        assertEquals(Angle.DEGREE.convert(90d), Math.toRadians(90), 0.00001);
        assertEquals(Angle.DEGREE.convert(180d), Math.toRadians(180), 0.00001);
        assertEquals(Angle.DEGREE.convert(270d), Math.toRadians(270), 0.00001);
        assertEquals(Angle.DEGREE.convert(360d), Math.toRadians(360), 0.00001);


    }

    /**
     * Test of convertFromSI method, of class Angle.
     */
    @Test
    public void testConvertFromSI() {
        assertEquals(Angle.DEGREE.convertFromSI(Math.toRadians(0)), 0d, 0.00001);
        assertEquals(Angle.DEGREE.convertFromSI(Math.toRadians(90d)), 90d, 0.00001);
        assertEquals(Angle.DEGREE.convertFromSI(Math.toRadians(180d)), 180d, 0.00001);
        assertEquals(Angle.DEGREE.convertFromSI(Math.toRadians(270d)), 270d, 0.00001);
        assertEquals(Angle.DEGREE.convertFromSI(Math.toRadians(360d)), 360d, 0.00001);
    }

    /**
     * Test of convert method, of class Angle.
     */
    @Test
    public void testConvert() {
        assertEquals(Angle.DEGREE.convert(0d, Angle.RADIANT), Math.toRadians(0), 0.00001);
        assertEquals(Angle.DEGREE.convert(90d, Angle.RADIANT), Math.toRadians(90), 0.00001);
        assertEquals(Angle.DEGREE.convert(180d, Angle.RADIANT), Math.toRadians(180), 0.00001);
        assertEquals(Angle.DEGREE.convert(270d, Angle.RADIANT), Math.toRadians(270), 0.00001);
        assertEquals(Angle.DEGREE.convert(360d, Angle.RADIANT), Math.toRadians(360), 0.00001);
    }
}