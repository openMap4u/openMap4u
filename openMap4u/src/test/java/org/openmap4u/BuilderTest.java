/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.openmap4u.builder.Buildable;
import org.openmap4u.builder.Shape;
 

/**
 *
 * @author hadrbolec
 */
public class BuilderTest  extends AbstractOpenMap4uTest {
    
    
    private Builder mBuilder = null;
    
    
    
    
    @Before
    public void setUp() {
        mBuilder = this.getDefaultOpenMap4u().getBuilder();
        Buildable d =null;
      
    }
    
    

    /**
     * Test of getCustomBuilder method, of class Builder.
     */
    @Test
    public void testGetCustomBuilder() {
        assertThat(mBuilder.getCustomBuilder(Shape.class), notNullValue());
     }

    /**
     * Test of getShapeBuilder method, of class Builder.
     */
    @Test
    public void testGetShapeBuilder() {
         assertThat(mBuilder.getShape(), notNullValue());
    }

    /**
     * Test of getImageBuilder method, of class Builder.
     */
    @Test
    public void testGetImageBuilder() {
          assertThat(mBuilder.getImage(), notNullValue());
      
    }

    /**
     * Test of getTextBuilder method, of class Builder.
     */
    @Test
    public void testGetTextBuilder() {
        assertThat(mBuilder.getText(), notNullValue());
        
    }
}