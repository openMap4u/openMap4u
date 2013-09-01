/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

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

    /**
     * Test of setMoveTo method, of class Shape.
     */
    @Test
    public void testSetMoveTo() {
        this.mShape.setMoveTo(1, 2);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    /**
     * Test of setLineTo method, of class Shape.
     */
    @Test
    public void testSetLineTo() {
        this.mShape.setMoveTo(1, 2).setLineTo(4, 5);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    /**
     * Test of setQuadTo method, of class Shape.
     */
    @Test
    public void testSetQuadTo() {
        this.mShape.setMoveTo(1, 2).setQuadTo(2, 3, 4, 5);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    /**
     * Test of seBezierTo method, of class Shape.
     */
    @Test
    public void testSeBezierTo() {
        this.mShape.setMoveTo(1, 2).setBezierTo(1.2, 1.4, 2, 3, 4, 5);
        assertThat(this.mShape.getPrimitive(), notNullValue());
    }

    @Override
    protected Shape getBuilder() {
        Shape shapeBuilder = this.getDefaultOpenMap4u().getBuilder().getShape();
        shapeBuilder.setMoveTo(-.5, -.5).setLineTo(.5, -.5).setQuadTo(1, .25, 0, .5).setBezierTo(-.5, 0.5, -1, .25, -.5, -.5).setMoveTo(-.25, -.25).setLineTo(.25 ,- .25).setLineTo(0, .25).setLineTo(-.25, -.25);
        return shapeBuilder;
    }

 
}