/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.core;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.canvas.Canvas;
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWrite;

/**
 *
 * @author hadrbolec
 */
public class PolygonTest extends AbstractOpenMap4uTest {

    public PolygonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testAdd() throws IOException {
        write(this.getPolygon().add(getCircle()), "AddPolygon.png");
    }

    @Test
    public void testStart() throws IOException {
        write(this.getDefaultOpenMap4u().getBuilder(Polygon.class).color(Color.BLACK).size(.25).fill(Color.GRAY).shape(getCircle()), "Circle.png");

        write(this.getPolygon(), "Polygon.png");
    }

    @Test
    public void testSubtract() throws IOException {
        write(this.getPolygon().subtract(getCircle()), "SubtractPolygon.png");
    }

    @Test
    public void testIntersect() throws IOException {
        write(this.getPolygon().intersect(getCircle()), "IntersectPolygon.png");
    }

    @Test
    public void testExclusiveOr() throws IOException {
        write(this.getPolygon().exclusiveOr(getCircle()), "ExclusiveOrPolygon.png");
    }

    public void write(Polygon polygonBuilder, String fileName) throws IOException {

        getCanvas().draw(polygonBuilder).write(FileSystems.getDefault().getPath(
                ".\\target\\test-classes", fileName));
    }

    SetAreaOfInterestOrDrawOrWrite getCanvas() {
        return this.getDefaultOpenMap4u().getCanvas().size(1, 1);
    }

    Polygon getPolygon() {
        return this.getDefaultOpenMap4u().getBuilder(Polygon.class).color(Color.BLACK).size(.25).fill(Color.GRAY).shape(getRectangle());
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
