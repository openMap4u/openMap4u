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

/**
 *
 * @author zwotti
 */
public class TransformUtilTest {

    TransformUtil tu = null;
    AffineTransform transform = null;

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
        assertThat((Point2D.Double)tu.getPoint(new Point.Align(LEFT,TOP), shape), is(new Point2D.Double(20, 330)));
        assertThat((Point2D.Double)tu.getPoint(new Point.Align(CENTER,TOP), shape), is(new Point2D.Double(220, 330)));
        assertThat((Point2D.Double)tu.getPoint(new Point.Align(RIGHT,TOP), shape), is(new Point2D.Double(420, 330)));
        assertThat((Point2D.Double)tu.getPoint(new Point.Align(LEFT,MIDDLE), shape), is(new Point2D.Double(20, 180)));
        assertThat((Point2D.Double)tu.getPoint(new Point.Align(CENTER,MIDDLE), shape), is(new Point2D.Double(220, 180)));
        assertThat((Point2D.Double)tu.getPoint(new Point.Align(RIGHT,MIDDLE), shape), is(new Point2D.Double(420, 180)));
        assertThat((Point2D.Double)tu.getPoint(new Point.Align(LEFT,BOTTOM), shape), is(new Point2D.Double(20, 30)));
        assertThat((Point2D.Double)tu.getPoint(new Point.Align(CENTER,BOTTOM), shape), is(new Point2D.Double(220, 30)));
        assertThat((Point2D.Double)tu.getPoint(new Point.Align(RIGHT,BOTTOM), shape), is(new Point2D.Double(420, 30)));
    }
    
      /**
     * Test of getPoint method, of class TransformUtil.
     */
    @Test
    public void testGetInversPoint() { 
        Shape shape = new Rectangle2D.Double(20, 30, 400, 300);
        assertThat((Point2D.Double)tu.getPointInvers(new Point.Align(LEFT,TOP), shape), is(new Point2D.Double(20,  30)));
        assertThat((Point2D.Double)tu.getPointInvers(new Point.Align(CENTER,TOP), shape), is(new Point2D.Double(220,  30)));
        assertThat((Point2D.Double)tu.getPointInvers(new Point.Align(RIGHT,TOP), shape), is(new Point2D.Double(420,  30)));
        assertThat((Point2D.Double)tu.getPointInvers(new Point.Align(LEFT,MIDDLE), shape), is(new Point2D.Double(20, 180)));
        assertThat((Point2D.Double)tu.getPointInvers(new Point.Align(CENTER,MIDDLE), shape), is(new Point2D.Double(220, 180)));
        assertThat((Point2D.Double)tu.getPointInvers(new Point.Align(RIGHT,MIDDLE), shape), is(new Point2D.Double(420, 180)));
        assertThat((Point2D.Double)tu.getPointInvers(new Point.Align(LEFT,BOTTOM), shape), is(new Point2D.Double(20, 330)));
        assertThat((Point2D.Double)tu.getPointInvers(new Point.Align(CENTER,BOTTOM), shape), is(new Point2D.Double(220, 330)));
        assertThat((Point2D.Double)tu.getPointInvers(new Point.Align(RIGHT,BOTTOM), shape), is(new Point2D.Double(420, 330)));
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
        assertThat((Point2D.Double)tu.transform(new Point2D.Double(3, 4), transform), is(new Point2D.Double(6, 12)));
    }

    /**
     * Test of transform method, of class TransformUtil.
     * @throws java.awt.geom.NoninvertibleTransformException
     */
    @Test
    public void testInversTransform() throws NoninvertibleTransformException {
        assertThat((Point2D.Double)tu.inverseTransform(new Point2D.Double(6, 12), transform), is(new Point2D.Double(3, 4)));
    }

}
