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
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zwotti
 */
public class TransformUtilTest {

    TransformUtil tu = null;
    AffineTransform transform = null;

    @Before
    public void setUp() {
        tu = new TransformUtil();
        transform = new AffineTransform(2, 0, 0, 3, 0, 0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPoint method, of class TransformUtil.
     */
    @Test
    public void testGetPoint() {
        Shape shape = new Rectangle2D.Double(20, 30, 400, 300);
        assertThat(tu.getPoint(Position.LeftTop, shape), is(new Point2D.Double(20, 330)));
        assertThat(tu.getPoint(Position.CenterTop, shape), is(new Point2D.Double(220, 330)));
        assertThat(tu.getPoint(Position.RightTop, shape), is(new Point2D.Double(420, 330)));
        assertThat(tu.getPoint(Position.LeftMiddle, shape), is(new Point2D.Double(20, 180)));
        assertThat(tu.getPoint(Position.CenterMiddle, shape), is(new Point2D.Double(220, 180)));
        assertThat(tu.getPoint(Position.RightMiddle, shape), is(new Point2D.Double(420, 180)));
        assertThat(tu.getPoint(Position.LeftBottom, shape), is(new Point2D.Double(20, 30)));
        assertThat(tu.getPoint(Position.CenterBottom, shape), is(new Point2D.Double(220, 30)));
        assertThat(tu.getPoint(Position.RightBottom, shape), is(new Point2D.Double(420, 30)));
    }

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
        assertThat(tu.transform(new Point2D.Double(3, 4), transform), is(new Point2D.Double(6, 12)));
    }

    /**
     * Test of transform method, of class TransformUtil.
     */
    @Test
    public void testInversTransform() throws NoninvertibleTransformException {
        assertThat(tu.inverseTransform(new Point2D.Double(6, 12), transform), is(new Point2D.Double(3, 4)));
    }

}
