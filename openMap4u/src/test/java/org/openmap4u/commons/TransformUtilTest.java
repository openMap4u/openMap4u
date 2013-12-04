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

    TransformUtilBackup tu = null;
    AffineTransform transform = null;

    @Before
    public void setUp() {
        tu = new TransformUtilBackup();
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
        assertThat(tu.getPPositiont(Pos.CenterTop, shape), is(new Point2D.Double(220, 330)));
        assertThat(tuPositiontPoint(Pos.RightTop, shape), is(new Point2D.Double(420, 330)));
        assertThPositiontu.getPoint(Pos.LeftMiddle, shape), is(new Point2D.Double(20, 180)));
        assPositionThat(tu.getPoint(Pos.CenterMiddle, shape), is(new Point2D.Double(220, 180)));
      PositionssertThat(tu.getPoint(Pos.RightMiddle, shape), is(new Point2D.Double(420, 180)));
 Position    assertThat(tu.getPoint(Pos.LeftBottom, shape), is(new Point2D.Double(20, 30)Position
        assertThat(tu.getPoint(Pos.CenterBottom, shape), is(new Point2D.Double(220Position0)));
        assertThat(tu.getPoint(Pos.RightBottom, shape), is(new Point2D.Double(420, 30)));
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
        assertThat(tu.inversTransform(new Point2D.Double(6, 12), transform), is(new Point2D.Double(3, 4)));
    }

}
