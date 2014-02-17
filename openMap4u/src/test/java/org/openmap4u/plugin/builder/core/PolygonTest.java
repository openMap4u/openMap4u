/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.core;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OverrideDrawOrWriteable;

/**
 *
 * @author hadrbolec
 */
public class PolygonTest extends AbstractOpenMap4uTest {

    /**
     *
     */
    public PolygonTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {

    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testAdd() throws IOException {
        write(this.getPolygon().add(getCircle()), "c_add.png");
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testWritePolygon() throws IOException {
        write(this.getDefaultOpenMap4u().get(Polygon.class).color(Color.BLACK).size(.35).fill(Color.LIGHT_GRAY).shape(getCircle()), "c_circle.png");
        write(this.getPolygon(), "c_rectangle.png");
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSubtract() throws IOException {
        write(this.getPolygon().subtract(getCircle()), "c_subtract.png");
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testIntersect() throws IOException {
        write(this.getPolygon().intersect(getCircle()), "c_intersect.png");
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testExclusiveOr() throws IOException {
        write(this.getPolygon().exclusiveOr(getCircle()), "c_exclusiveOr.png");
    }

    /**
     *
     * @param polygonBuilder
     * @param fileName
     * @throws IOException
     */
    public void write(Polygon polygonBuilder, String fileName) throws IOException {
       getCanvas().draw(polygonBuilder).write(this.getPackagePath( fileName));
    }

    OverrideDrawOrWriteable getCanvas() {
        return this.getDefaultOpenMap4u().getCanvas(1, 1);
    }

    Polygon getPolygon() {
        return this.getDefaultOpenMap4u().get(Polygon.class).color(Color.BLACK).size(.35).fill(Color.LIGHT_GRAY).shape(getRectangle());
    }

    Shape getRectangle() {
        return new Rectangle2D.Double(0.125, .125, .5, .5);
    }

    Shape getCircle() {
        return new Ellipse2D.Double(0.355, .355, .5, .5);
    }

    private void write(String addPolygonpng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
