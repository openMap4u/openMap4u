/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import org.junit.*;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWrite;
import org.openmap4u.plugin.builder.core.*;

import java.awt.*;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import static org.junit.Assert.*;
import org.openmap4u.commons.Position;

/**
 *
 * @author hadrbolec
 */
public class BuildableTest extends AbstractOpenMap4uTest {

    public BuildableTest() {
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
    public void testInitial() throws IOException {
        write(this.getPolygon(), "b_initial.png");
    }

    @Test
    public void testScale() throws IOException {
        write(getPolygon().scale(1.7), "b_scale.png");
    }

    @Test
    public void testScaleXY() throws IOException {
        write(getPolygon().scale(1.7, 2.8), "b_scaleXY.png");
    }

    @Test
    public void testScaleX() throws IOException {
        write(getPolygon().scaleX(1.7), "b_scaleX.png");
    }

    @Test
    public void testScaleY() throws IOException {
        write(getPolygon().scaleY(1.7), "b_scaleY.png");
    }

    @Test
    public void testRotate30() throws IOException {
        write(getPolygon().rotate(30), "b_rotate30Degrees.png");
    }

    @Test
    public void testRotate70() throws IOException {
        write(getPolygon().rotate(70), "b_rotate70Degrees.png");
    }

    @Test
    public void tesOffsetX() throws IOException {
        write(getPolygon().offsetX(.25), "b_offsetX.png");
    }

    @Test
    public void tesOffsetY() throws IOException {
        write(getPolygon().offsetY(.5), "b_offsetY.png");
    }

    @Test
    public void tesOffsetXY() throws IOException {
        write(getPolygon().offset(.25, .5), "b_offsetXY.png");
    }

    @Test
    public void tesAlignLeftTop() throws IOException {
        write(getPolygon().align(Position.LeftTop), "b_alignLeftTop.png");
    }

    @Test
    public void tesAlignLeftMiddle() throws IOException {
        write(getPolygon().align(Position.LeftMiddle), "b_alignLeftMiddle.png");
    }

    @Test
    public void tesAlignLeftBottom() throws IOException {
        write(getPolygon().align(Position.LeftBottom), "b_alignLeftBottom.png");
    }

    @Test
    public void tesAlignCenterTop() throws IOException {
        write(getPolygon().align(Position.CenterTop), "b_alignCenterTop.png");
    }

    @Test
    public void tesAlignCenterMiddle() throws IOException {
        write(getPolygon().align(Position.CenterMiddle), "b_alignCenterMiddle.png");
    }

    @Test
    public void tesAlignCenterBottom() throws IOException {
        write(getPolygon().align(Position.CenterBottom), "b_alignCenterBottom.png");
    }

    @Test
    public void tesAlignRightTop() throws IOException {
        write(getPolygon().align(Position.RightTop), "b_alignRightTop.png");
    }

    @Test
    public void tesAligRightMiddle() throws IOException {
        write(getPolygon().align(Position.RightMiddle), "b_alignRightMiddle.png");
    }

    @Test
    public void tesAlignRightBottom() throws IOException {
        write(getPolygon().align(Position.RightBottom), "b_alignRightBottom.png");
    }

    @Test
    public void tesOffsetRotate() throws IOException {
        write(getPolygon().offset(.25, .5).rotate(30), "b_offsetRoate.png");
    }

    @Test
    public void tesOffsetRotateScale() throws IOException {
        write(getPolygon().offset(.25, .5).rotate(30).scale(1), "b_offsetRoateScale.png");
    }

    @Test
    public void tesOffsetRotateScaleAlign() throws IOException {
        write(getPolygon().offset(.25, .5).rotate(30).scale(1).align(Position.LeftBottom), "b_offsetRoateScaleAlign.png");
    }

    org.openmap4u.plugin.builder.core.Polygon getPolygon() {
        return this.getDefaultOpenMap4u().getBuilder(org.openmap4u.plugin.builder.core.Polygon.class).color(Color.BLACK).size(.5).fill(Color.LIGHT_GRAY).shape(new Rectangle2D.Double(-.5, -.25, 1, .5)).subtract(new Rectangle2D.Double(0.1, -.1, .2, .2)).point(1.1, 1).transparence(30);
    }

    Polyline getBackground() {
        return this.getDefaultOpenMap4u().getBuilder(Polyline.class).color(Color.GRAY).size(0.35).moveTo(0, 1).lineTo(2, 1).moveTo(1.1, 0).lineTo(1.1, 2);
    }

    public void write(org.openmap4u.plugin.builder.core.Polygon polygonBuilder, String fileName) throws IOException {
        getCanvas().draw(getBackground()).draw(polygonBuilder).write(this.getPackagePath(fileName));
    }

    SetAreaOfInterestOrDrawOrWrite getCanvas() {
        return this.getDefaultOpenMap4u().getCanvas().size(2.2, 2);
    }

}
