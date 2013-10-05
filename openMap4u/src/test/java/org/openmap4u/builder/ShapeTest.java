/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hadrbolec
 */
public class ShapeTest extends AbstractShapeBuilderTest<Shape> {

    private Shape mShape = null;

    @Before
    public void setUp() {
        this.mShape = this.getDefaultOpenMap4u().getBuilder().getShape();
    }

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
     * Test of setMoveTo method, of class Shape.
     */
    @Test
    public void testSetMoveTo() {
        this.mShape.moveTo(1, 2);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    /**
     * Test of setLineTo method, of class Shape.
     */
    @Test
    public void testSetLineTo() {
        this.mShape.moveTo(1, 2).lineTo(4, 5);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    /**
     * Test of setQuadTo method, of class Shape.
     */
    @Test
    public void testSetQuadTo() {
        this.mShape.moveTo(1, 2).quadTo(2, 3, 4, 5);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    /**
     * Test of seBezierTo method, of class Shape.
     */
    @Test
    public void testSeBezierTo() {
        this.mShape.moveTo(1, 2).bezierTo(1.2, 1.4, 2, 3, 4, 5);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    @Override
    protected Shape getBuilder() {
        Shape shapeBuilder = this.getDefaultOpenMap4u().getBuilder().getShape();
        shapeBuilder.moveTo(-.5, -.5).quadTo(1, .25, 0, .5).bezierTo(-.5, 0.5, -1, .25, -.5, -.5).moveTo(-.25, -.25).lineTo(.25, -.25).lineTo(0, .25).lineTo(-.25, -.25);
        return shapeBuilder;
    }

}
