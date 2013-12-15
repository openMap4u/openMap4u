/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Color;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openmap4u.OpenMap4u;
import org.openmap4u.unit.Angle;

/**
 *
 * @author hadrbolec
 */
public class PieTest {

    private Pie pie = null;

    @Before
    public void setUp() {
        pie = new OpenMap4u().getBuilder(Pie.class);
    }

    /**
     * Test of getEnd method, of class Pie.
     */
    @Test
    public void testEnd() {
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.DEGREE));
        assertThat(pie.getExtent(), is(Math.PI*2));
        pie.end(180);
        assertThat(pie.getExtent(), is(Math.PI));
    }

    /**
     * Test of getStart method, of class Pie.
     */
    @Test
    public void testStart() {
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.DEGREE));
        assertThat(pie.getStart(), is(0d));
        pie.start(90);
        assertThat(pie.getStart(), is(Math.PI/2d));
    }

    /**
     * Test of color method, of class Pie.
     */
    @Test
    public void testStrokeColor() {
        pie.color(Color.CYAN);
        assertThat(pie.getStyle().getStrokeColor(), is(Color.CYAN));
    }

    /**
     * Test of fill method, of class Pie.
     */
    @Test
    public void testStrokeFill() {
        pie.fill(Color.RED);
        assertThat(pie.getStyle().getStrokeFill(), is(Color.RED));
    }

    /**
     * Test of size method, of class Pie.
     */
    @Test
    public void testStrokeSize() {
        pie.size(5d);
        assertThat(pie.getStyle().getStrokeSize(), is(5d));
    }

    /**
     * Test of radius method, of class Pie.
     */
    @Test
    public void testRadius() {
        pie.radius(5);
        assertThat(pie.getOuterRadius(), is(5d));

    }

    /**
     * Test of innerRadius method, of class Pie.
     */
    @Test
    public void testInnerRadius() {
        assertTrue(Double.isNaN(pie.getInnerRadius()));
        pie.innerRadius(3);
        assertThat(pie.getInnerRadius(), is(3d));
    }

    /**
     * Test of outerRadius method, of class Pie.
     */
    @Test
    public void testOuterRadius() {
        assertTrue(pie.getOuterRadius() > 0);
        pie.outerRadius(3);
        assertThat(pie.getOuterRadius(), is(3d));

    }

    /**
     * Test of diameter method, of class Pie.
     */
    @Test
    public void testDiameter() {
        pie.diameter(10);
        assertThat(pie.getOuterRadius(), is(5d));
    }

    /**
     * Test of unit method, of class Pie.
     */
    @Test
    public void testUnit() {
        pie.unit(Angle.DEGREE);
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.DEGREE));
        pie.unit(Angle.RADIANT);
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.RADIANT));
    }

    /**
     * Test of add method, of class Pie.
     */
    @Test
    public void testAdd() {
        pie.start(90);
        assertThat(pie.getStart(), is(Math.PI/2d));
        assertThat(pie.getExtent(), is(2*Math.PI));
        pie.add(45);
        assertThat(pie.getExtent(), is(Math.PI*1/4));
    }

    /**
     * Test of getAngularUnit method, of class Pie.
     */
    @Test
    public void testGetAngularUnit() {
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.DEGREE));
        pie.unit(Angle.PERCENT);
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.PERCENT));
    }

    /**
     * Test of getPrimitive method, of class Pie.
     */
    @Test
    public void testGetPrimitive() {
        pie.start(0.3).end(.5).radius(2);
        assertThat(pie.getShape(), notNullValue());
    }

    /**
     * Test of getControlPoint method, of class Pie.
     */
    @Test
    public void testGetControlPoint() {

    }

}
