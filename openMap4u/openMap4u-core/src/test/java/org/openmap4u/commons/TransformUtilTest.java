/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openmap4u.commons.Point.Align;
import static org.openmap4u.commons.HorizontalAlign.CENTER;
import static org.openmap4u.commons.HorizontalAlign.LEFT;
import static org.openmap4u.commons.HorizontalAlign.RIGHT;
import static org.openmap4u.commons.VerticalAlign.BOTTOM;
import static org.openmap4u.commons.VerticalAlign.MIDDLE;
import static org.openmap4u.commons.VerticalAlign.TOP;

import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author zwotti
 */
public class TransformUtilTest {

    TransformUtil tu = null;
    AffineTransform transform = null;

    private static Rectangle2D BOUNDS = new Rectangle2D.Double(0, 0, 3, 2);

    AreaOfInterestDebug scale = new AreaOfInterestDebug(BOUNDS, null, 0.75, null);
    AreaOfInterestDebug rotate = new AreaOfInterestDebug(BOUNDS, null, null, 30d);
    AreaOfInterestDebug center = new AreaOfInterestDebug(BOUNDS, new Point2D.Double(), null, null);
    AreaOfInterestDebug scaleCenter = new AreaOfInterestDebug(BOUNDS, null, 0.75, null);
    AreaOfInterestDebug scaleCenterRotate = new AreaOfInterestDebug(BOUNDS, null, 0.75, null);
    Point2D.Double point2Tranform = new Point2D.Double(0.5, .5);

    /**
     *
     */
    @Before
    public void setUp() {
        tu = new TransformUtil();
        transform = new AffineTransform(2, 0, 0, 3, 0, 0);
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getPoint method, of class TransformUtil.
     */
    @Test
    public void testGetPoint() {
        Shape shape = new Rectangle2D.Double(20, 30, 400, 300);
        assertThat((Point2D.Double) tu.getPoint(new Point.Align(LEFT, TOP), shape), is(new Point2D.Double(20, 330)));
        assertThat((Point2D.Double) tu.getPoint(new Point.Align(CENTER, TOP), shape), is(new Point2D.Double(220, 330)));
        assertThat((Point2D.Double) tu.getPoint(new Point.Align(RIGHT, TOP), shape), is(new Point2D.Double(420, 330)));
        assertThat((Point2D.Double) tu.getPoint(new Point.Align(LEFT, MIDDLE), shape), is(new Point2D.Double(20, 180)));
        assertThat((Point2D.Double) tu.getPoint(new Point.Align(CENTER, MIDDLE), shape), is(new Point2D.Double(220, 180)));
        assertThat((Point2D.Double) tu.getPoint(new Point.Align(RIGHT, MIDDLE), shape), is(new Point2D.Double(420, 180)));
        assertThat((Point2D.Double) tu.getPoint(new Point.Align(LEFT, BOTTOM), shape), is(new Point2D.Double(20, 30)));
        assertThat((Point2D.Double) tu.getPoint(new Point.Align(CENTER, BOTTOM), shape), is(new Point2D.Double(220, 30)));
        assertThat((Point2D.Double) tu.getPoint(new Point.Align(RIGHT, BOTTOM), shape), is(new Point2D.Double(420, 30)));
    }

    /**
     * Test of getPoint method, of class TransformUtil.
     */
    @Test
    public void testGetInversPoint() {
        Shape shape = new Rectangle2D.Double(20, 30, 400, 300);
        assertThat((Point2D.Double) tu.getPointInvers(new Point.Align(LEFT, TOP), shape), is(new Point2D.Double(20, 30)));
        assertThat((Point2D.Double) tu.getPointInvers(new Point.Align(CENTER, TOP), shape), is(new Point2D.Double(220, 30)));
        assertThat((Point2D.Double) tu.getPointInvers(new Point.Align(RIGHT, TOP), shape), is(new Point2D.Double(420, 30)));
        assertThat((Point2D.Double) tu.getPointInvers(new Point.Align(LEFT, MIDDLE), shape), is(new Point2D.Double(20, 180)));
        assertThat((Point2D.Double) tu.getPointInvers(new Point.Align(CENTER, MIDDLE), shape), is(new Point2D.Double(220, 180)));
        assertThat((Point2D.Double) tu.getPointInvers(new Point.Align(RIGHT, MIDDLE), shape), is(new Point2D.Double(420, 180)));
        assertThat((Point2D.Double) tu.getPointInvers(new Point.Align(LEFT, BOTTOM), shape), is(new Point2D.Double(20, 330)));
        assertThat((Point2D.Double) tu.getPointInvers(new Point.Align(CENTER, BOTTOM), shape), is(new Point2D.Double(220, 330)));
        assertThat((Point2D.Double) tu.getPointInvers(new Point.Align(RIGHT, BOTTOM), shape), is(new Point2D.Double(420, 330)));
    }

    /**
     *
     */
    @Test
    public void testIsRotate() {
        assertThat(tu.isRotate(0), is(false));
        assertThat(tu.isRotate(Math.PI), is(true));
        assertThat(tu.isRotate(2 * Math.PI), is(false));
        assertThat(tu.isRotate(4 * Math.PI), is(false));
    }

    /**
     * Test of transform method, of class TransformUtil.
     */
    @Test
    public void testTransform() {
        assertThat((Point2D.Double) tu.transform(new Point2D.Double(3, 4), transform), is(new Point2D.Double(6, 12)));
    }

    /**
     * Test of transform method, of class TransformUtil.
     *
     * @throws java.awt.geom.NoninvertibleTransformException
     */
    @Test
    public void testInversTransform() throws NoninvertibleTransformException {
        assertThat((Point2D.Double) tu.inverseTransform(new Point2D.Double(6, 12), transform), is(new Point2D.Double(3, 4)));
    }

    @Test
    public void testGetGlobalTransformScale() {
        assertThat(tu.getGlobalTransform(scale).transform(point2Tranform, new Point2D.Double()), is((Point2D) new Point2D.Double(0.75, 0.625)));
    }

    @Test
    public void testGetGlobalTransformCenter() {
        assertThat(tu.getGlobalTransform(center).transform(point2Tranform, new Point2D.Double()), is((Point2D) new Point2D.Double(2, 1.5)));

    }

    @Test
    public void testGetGlobalTransformRotate() {
        Point2D transformed = tu.getGlobalTransform(rotate).transform(point2Tranform, new Point2D.Double());
        assertEquals(transformed.getX(), 0.883974, 0.0001);
        assertEquals(transformed.getY(), 0.0669872, 0.0001);

    }
    
     @Test
    public void testGetGlobalTransformScaleCenter() {
         assertThat(tu.getGlobalTransform(scaleCenter).transform(point2Tranform, new Point2D.Double()), is((Point2D) new Point2D.Double(.75, 0.625)));

    }
    
     @Test
    public void testGetGlobalTransformScaleCenterRotate() {
        Point2D transformed = tu.getGlobalTransform(scaleCenterRotate).transform(point2Tranform, new Point2D.Double());
        assertEquals(transformed.getX(), 0.75, 0.0001);
        assertEquals(transformed.getY(), 0.625, 0.0001);

    }

}
