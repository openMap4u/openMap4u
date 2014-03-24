/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.core;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.nio.file.FileSystems;
import org.junit.*;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OverrideDrawOrWriteable;
import org.openmap4u.plugin.builder.chart.LineChart;
import org.openmap4u.plugin.builder.symbol.Rectangle;
import org.openmap4u.commons.Length;

/**
 *
 * @author hadrbolec
 */
public class PolylineTest extends AbstractOpenMap4uTest {

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
     * @param from
     * @param cp1
     * @param cp2
     * @param to
     * @param outputFile
     * @throws IOException
     */
    public void drawBezier(Point2D.Double from, Point2D.Double cp1, Point2D.Double cp2, Point2D.Double to, String outputFile) throws IOException {
        getCanvas(1.4)
                .draw(getDefaultOpenMap4u().get(LineChart.class).from(from.x, from.y).to(cp1.x, cp1.y).color(Color.GRAY))
                .draw(getDefaultOpenMap4u().get(LineChart.class).from(to.x, to.y).to(cp2.x, cp2.y).color(Color.GRAY)).draw(getDefaultOpenMap4u().get(Polyline.class).moveTo(from.x, from.y).bezierTo(cp1.x, cp1.y, cp2.x, cp2.y, to.x, to.y).color(Color.BLACK).size(.5))
                .draw(fromMarker(from.x, from.y)).draw(toMarker(to.x, to.y))
                .draw(cp1Marker(cp1.x, cp1.y)).draw(cp2Marker(cp2.x, cp2.y)).write(getPackagePath( outputFile));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testBezierTo1() throws IOException {
        drawBezier(new Point2D.Double(.125, 0.875), new Point2D.Double(0.75, 1.375), new Point2D.Double(1, .125), new Point2D.Double(1.25, 0.75), "bezier1.png");
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testBezierTo2() throws IOException {
        drawBezier(new Point2D.Double(.125, 1), new Point2D.Double(1.375, 0.125), new Point2D.Double(.75,1.25), new Point2D.Double(0.375,0.375), "bezier2.png");

    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testBezierTo3() throws IOException {
        drawBezier(new Point2D.Double(.125, .5), new Point2D.Double(1.375, 0.375), new Point2D.Double(.125, 1.25), new Point2D.Double(1, 0.875), "bezier3.png");
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testQuadTo() throws IOException {
        Point2D.Double from = new Point2D.Double(.125, .125);
        Point2D.Double to = new Point2D.Double(.85, .5);
        Point2D.Double cp = new Point2D.Double(.5, 0.85);
        getCanvas(1).draw(getDefaultOpenMap4u().get(LineChart.class).from(from.x, from.y).to(cp.x, cp.y).color(Color.GRAY))
                .draw(getDefaultOpenMap4u().get(LineChart.class).from(to.x, to.y).to(cp.x, cp.y).color(Color.GRAY)).draw(getDefaultOpenMap4u().get(Polyline.class).moveTo(from.x, from.y).quadTo(cp.x, cp.y, to.x, to.y).color(Color.BLACK).size(.5))
      
                .draw(fromMarker(from.x, from.y)).draw(toMarker(to.x, to.y)).draw(cpMarker(cp.x, cp.y)).write(getPackagePath( "quadTo.png"));

    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testLineTo() throws IOException {
        Point2D.Double from = new Point2D.Double(.125, .125);
        Point2D.Double to = new Point2D.Double(0.75, 0.75);
         getCanvas(1)    .draw(getDefaultOpenMap4u().get(LineChart.class).from(from.x, from.y).to(to.x, to.y).color(Color.BLACK).size(.5))
                 .draw(fromMarker(from.x, from.y)).draw(toMarker(to.x, to.y)).write(getPackagePath("lineTo.png"));

    }

    Rectangle fromMarker(double x, double y) {
        return super.getPointMarker(x, y, Color.RED,Color.GRAY);
    }

    org.openmap4u.plugin.builder.symbol.Rectangle toMarker(double x, double y) {
        return super.getPointMarker(x, y, Color.BLUE, Color.GRAY);
    }

    Rectangle cp1Marker(double x, double y) {
        return super.getPointMarker(x, y, Color.RED, Color.WHITE);
    }
    
      Rectangle cpMarker(double x, double y) {
        return super.getPointMarker(x, y, Color.GRAY, Color.WHITE);
    }

    Rectangle cp2Marker(double x, double y) {
        return super.getPointMarker(x, y, Color.BLUE, Color.WHITE);
    }

    OverrideDrawOrWriteable getCanvas() {
        return this.getDefaultOpenMap4u().getCanvas(3, 3);
    }
    
     OverrideDrawOrWriteable getCanvas(double size) {
        return this.getDefaultOpenMap4u().getCanvas(size, size);
    }

}
