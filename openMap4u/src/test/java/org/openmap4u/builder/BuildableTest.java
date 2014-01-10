/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import org.junit.*;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.plugin.builder.core.*;
import org.openmap4u.plugin.builder.symbol.Rectangle;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.openmap4u.commons.Position;
import org.openmap4u.plugin.builder.chart.Line;
import org.openmap4u.plugin.builder.chart.Pie;

/**
 *
 * @author hadrbolec
 */
public class BuildableTest extends AbstractOpenMap4uTest {

    /**
     *
     */
    public BuildableTest() {
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
    public void testInitial() throws IOException {
        write("b_initial.png", this.getPolygon());
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testScale() throws IOException {
        write("b_scale.png", getPolygonTransparent(), getPolygon().scale(1.7));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testFill() throws IOException {
        write("b_fillRed.png", getPolygon().fill(Color.RED));
        write("b_fillGreen.png", getPolygon().fill(Color.GREEN));
        write("b_fillBlue.png", getPolygon().fill(Color.BLUE));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testColor() throws IOException {
        write("b_colorRed.png", getPolygon().color(Color.RED));
        write("b_colorGreen.png", getPolygon().color(Color.GREEN));
        write("b_colorBlue.png", getPolygon().color(Color.BLUE));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testTransparence() throws IOException {
        write("b_transparence100.png", getPolygon().transparence(100));
        write("b_transparence75.png", getPolygon().transparence(75));
        write("b_transparence50.png", getPolygon().transparence(50));
        write("b_transparence25.png", getPolygon().transparence(25));
        write("b_transparence0.png", getPolygon().transparence(0));

    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testScaleXY() throws IOException {
        write("b_scaleXY.png", getPolygonTransparent(), getPolygon().scale(1.7, 2.8));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testScaleX() throws IOException {
        write("b_scaleX.png", getPolygonTransparent(), getPolygon().scaleX(1.7));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testScaleY() throws IOException {
        write("b_scaleY.png", getPolygonTransparent(), getPolygon().scaleY(1.7));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testRotate30() throws IOException {
        write("b_rotate30Degrees.png", getPolygonTransparent(), getAnglePie(30), getPolygon().rotate(30));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testRotate70() throws IOException {
        write("b_rotate70Degrees.png", getPolygonTransparent(), getAnglePie(70), getPolygon().rotate(70));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void tesOffsetX() throws IOException {
        write("b_offsetX.png", getPolygonTransparent(), getPolygon().offsetX(.25), getLine(1.1, 1, 1.35, 1), getRedMarker(1.1, 1), getBlueMarker(1.35, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void tesOffsetY() throws IOException {
        write("b_offsetY.png", getPolygon().offsetY(.5), getLine(1.1, 1, 1.1, 1.5), getRedMarker(1.1, 1), getBlueMarker(1.1, 1.5));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void tesOffsetXY() throws IOException {
        write("b_offsetXY.png", getPolygon().offset(.25, .5), getLine(1.1, 1, 1.35, 1.5), getRedMarker(1.1, 1), getBlueMarker(1.35, 1.5));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void tesAlignLeftTop() throws IOException {
        write("b_alignLeftTop.png", getPolygonTransparent(), getPolygon().align(Position.LeftTop), getRedMarker(1.1, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void tesAlignLeftMiddle() throws IOException {
        write("b_alignLeftMiddle.png", getPolygonTransparent(), getPolygon().align(Position.LeftMiddle), getRedMarker(1.1, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void tesAlignLeftBottom() throws IOException {
        write("b_alignLeftBottom.png", getPolygonTransparent(), getPolygon().align(Position.LeftBottom), getRedMarker(1.1, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void tesAlignCenterTop() throws IOException {
        write("b_alignCenterTop.png", getPolygonTransparent(), getPolygon().align(Position.CenterTop), getRedMarker(1.1, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void tesAlignCenterMiddle() throws IOException {
        write("b_alignCenterMiddle.png", getPolygonTransparent(), getPolygon().align(Position.CenterMiddle), getRedMarker(1.1, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testAlignCenterBottom() throws IOException {
        write("b_alignCenterBottom.png", getPolygonTransparent(), getPolygon().align(Position.CenterBottom), getRedMarker(1.1, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testAlignRightTop() throws IOException {
        write("b_alignRightTop.png", getPolygonTransparent(), getPolygon().align(Position.RightTop), getRedMarker(1.1, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testAligRightMiddle() throws IOException {
        write("b_alignRightMiddle.png", getPolygonTransparent(), getPolygon().align(Position.RightMiddle), getRedMarker(1.1, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void tesAlignRightBottom() throws IOException {
        write("b_alignRightBottom.png", getPolygonTransparent(), getPolygon().align(Position.RightBottom), getRedMarker(1.1, 1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testOffsetRotate() throws IOException {
        write("b_offsetRoate.png", getPolygon().offset(.25, .5).rotate(30));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testOffsetRotateScale() throws IOException {
        write("b_offsetRoateScale.png", getPolygon().offset(.25, .5).rotate(30).scale(1));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testOffsetRotateScaleAlign() throws IOException {
        write("b_offsetRoateScaleAlign.png", getPolygon().offset(.25, .5).rotate(30).scale(1).align(Position.LeftBottom));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testPuttingTransformable2Gether() throws IOException {
        write("b_transform2gether1.png", getPolygon().offset(-.5,-.35), getRedMarker(.6,0.65));
        write("b_transform2gether2.png", getPolygon().offset(-.5,-.35).rotate(30), getRedMarker(.6,0.65));
           write("b_transform2gether3.png", getPolygon().offset(-.5,-.35).rotate(30).scale(1.5), getRedMarker(.6,0.65));
      
        write("b_transform2gether4.png", getPolygon().offset(-.5,-.35).rotate(30).scale(1.5).align(Position.LeftMiddle), getRedMarker(0.6,0.65));
      

    }

    org.openmap4u.plugin.builder.core.Polygon getPolygon() {
        return this.getDefaultOpenMap4u().getBuilder(org.openmap4u.plugin.builder.core.Polygon.class).color(Color.BLACK).size(.5).fill(Color.LIGHT_GRAY).shape(new Rectangle2D.Double(-.5, -.25, 1, .5)).subtract(new Rectangle2D.Double(0.1, -.1, .2, .2)).point(1.1, 1).transparence(40);
    }

    Buildable getPolygonTransparent() {
        return getPolygon().transparence(70);
    }

    Polyline getBackground() {
        return this.getDefaultOpenMap4u().getBuilder(Polyline.class).color(Color.GRAY).size(0.35).moveTo(0, 1).lineTo(2.2, 1).moveTo(1.1, 0).lineTo(1.1, 2);
    }

    /**
     *
     * @param fileName
     * @param primitives
     * @throws IOException
     */
    public void write(String fileName, Buildable... primitives) throws IOException {
        ArrayList<Buildable> builders = new ArrayList<>();
        builders.addAll(Arrays.<Buildable>asList(primitives));
        System.out.println(builders.size());
        builders.add(0, getBackground());
        super.drawOnCanvas(2.2, 2, fileName, builders.toArray(new Buildable[builders.size()]));
    }

    Rectangle getRedMarker(double x, double y) {
        return getDefaultOpenMap4u().getBuilder(Rectangle.class).color(Color.RED).fill(Color.WHITE).size(.35).width(0.1).height(.1).point(x, y);
    }

    Rectangle getBlueMarker(double x, double y) {
        return getDefaultOpenMap4u().getBuilder(Rectangle.class).color(Color.BLUE).fill(Color.WHITE).size(.35).width(0.1).height(.1).point(x, y);
    }

    Line getLine(double fromX, double fromY, double toX, double toY) {
        return getDefaultOpenMap4u().getBuilder(Line.class).color(Color.RED).size(.35).from(fromX, fromY).to(toX, toY);
    }

    Pie getAnglePie(double angle) {
        return getDefaultOpenMap4u().getBuilder(Pie.class).color(Color.GRAY).fill(Color.RED).radius(.85).size(.35).transparence(50).add(angle).point(1.1, 1);
    }

}