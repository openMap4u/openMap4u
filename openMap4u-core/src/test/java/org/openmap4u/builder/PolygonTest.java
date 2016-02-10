/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import org.openmap4u.plugin.builder.core.Polygon;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hadrbolec
 */
public class PolygonTest extends AbstractShapeBuilderTest<Polygon> {

    private Polygon mShape = null;

    /**
     *
     */
    @Before
    public void setUp() {
        this.mShape = this.getDefaultOpenMap4u().get(Polygon.class);
    }

    /**
     *
     */
    @Test
    public void testIsVisible() {
        /* Test the default value */
        assertThat(mShape.getStyle().isVisible(), is(true));
        mShape.visible(false);
         /* Test the default value */
        assertThat(mShape.getStyle().isVisible(), is(false));
       mShape.visible(true);
        assertThat(mShape.getStyle().isVisible(), is(true));
    }

    

    /**
     * Test of setMoveTo method, of class Polygon.
     */
    @Test
    public void testSetMoveTo() {
        this.mShape.moveTo(1, 2);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    /**
     * Test of setLineTo method, of class Polygon.
     */
    @Test
    public void testSetLineTo() {
        this.mShape.moveTo(1, 2).lineTo(4, 5);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    /**
     * Test of setQuadTo method, of class Polygon.
     */
    @Test
    public void testSetQuadTo() {
        this.mShape.moveTo(1, 2).quadTo(2, 3, 4, 5);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    /**
     * Test of seBezierTo method, of class Polygon.
     */
    @Test
    public void testSeBezierTo() {
        this.mShape.moveTo(1, 2).bezierTo(1.2, 1.4, 2, 3, 4, 5);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    @Override
    protected Polygon getBuilder() {
        Polygon shapeBuilder = this.getDefaultOpenMap4u().get(Polygon.class);
        shapeBuilder.moveTo(-.5, -.5).quadTo(-.5, .5, 0,0.5).bezierTo(.5, 0.5, .5, 0, .5, -.5).lineTo(-.5,-.5).moveTo(-.25, -.25).lineTo(.25, -.25).lineTo(0, .25).lineTo(-.25, -.25);
        return shapeBuilder;
    }

}
