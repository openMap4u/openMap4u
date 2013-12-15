/*
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
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWrite;
import org.openmap4u.plugin.builder.chart.Line;
import org.openmap4u.plugin.builder.symbol.Rectangle;
import org.openmap4u.unit.Length;

/**
 *
 * @author hadrbolec
 */
public class PolylineTest extends AbstractOpenMap4uTest {

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

    public void drawBezier(Point2D.Double from, Point2D.Double cp1, Point2D.Double cp2, Point2D.Double to, String outputFile) throws IOException {
        getCanvas()
                .draw(getDefaultOpenMap4u().getBuilder(Line.class).from(from.x, from.y).to(cp1.x, cp1.y).color(Color.GRAY))
                .draw(getDefaultOpenMap4u().getBuilder(Line.class).from(to.x, to.y).to(cp2.x, cp2.y).color(Color.GRAY)).draw(getDefaultOpenMap4u().getBuilder(Polyline.class).moveTo(from.x, from.y).bezierTo(cp1.x, cp1.y, cp2.x, cp2.y, to.x, to.y).color(Color.BLACK).size(.75))
                .draw(fromMarker(from.x, from.y)).draw(toMarker(to.x, to.y))
                .draw(cp1Marker(cp1.x, cp1.y)).draw(cp2Marker(cp2.x, cp2.y)).write(FileSystems.getDefault().getPath(
                                ".\\target\\test-classes", outputFile));
    }

    @Test
    public void testBezierTo1() throws IOException {
        drawBezier(new Point2D.Double(.25, 1.75), new Point2D.Double(1.5, 2.75), new Point2D.Double(2, .25), new Point2D.Double(2.5, 1.5), "bezier1.png");
    }

    @Test
    public void testBezierTo2() throws IOException {
        drawBezier(new Point2D.Double(.25, 2), new Point2D.Double(2.75, 0.25), new Point2D.Double(1.5,2.5), new Point2D.Double(0.75,0.75), "bezier2.png");

    }

    @Test
    public void testBezierTo3() throws IOException {
        drawBezier(new Point2D.Double(.25, 1), new Point2D.Double(2.75, 0.75), new Point2D.Double(.25, 2.5), new Point2D.Double(2, 1.75), "bezier3.png");
    }

    @Test
    public void testQuadTo() throws IOException {
        Point2D.Double from = new Point2D.Double(.5, .5);
        Point2D.Double to = new Point2D.Double(2.5, 1);
        Point2D.Double cp = new Point2D.Double(1.5, 2.5);
        getCanvas()    .draw(getDefaultOpenMap4u().getBuilder(Line.class).from(from.x, from.y).to(cp.x, cp.y).color(Color.GRAY))
                .draw(getDefaultOpenMap4u().getBuilder(Line.class).from(to.x, to.y).to(cp.x, cp.y).color(Color.GRAY)).draw(getDefaultOpenMap4u().getBuilder(Polyline.class).moveTo(from.x, from.y).quadTo(cp.x, cp.y, to.x, to.y).color(Color.BLACK).size(.75))
      
                .draw(fromMarker(from.x, from.y)).draw(toMarker(to.x, to.y))           .draw(cpMarker(cp.x, cp.y)).write(FileSystems.getDefault().getPath(
                                ".\\target\\test-classes", "quadTo.png"));

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

    SetAreaOfInterestOrDrawOrWrite getCanvas() {
        return this.getDefaultOpenMap4u().getCanvas().size(3, 3);
    }

}
