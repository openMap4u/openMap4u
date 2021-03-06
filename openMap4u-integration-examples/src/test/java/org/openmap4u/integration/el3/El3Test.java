/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.integration.el3;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Hadrbolec
 */
public class El3Test extends AbstractEl3Test {

    /**
     *
     */
    @Test
    public void testProcessor() {
        assertThat(getELProcessor(), notNullValue());
    }

    /**
     *
     */
    @Test
    public void testSimpleExpression() {
        getELProcessor().eval("n=4+3");
    }

    @Test
    public void testSinglePrimitive() {
        try {
            getELProcessor().eval("n=4+3");
            getELProcessor().eval("oM4u.getCanvas(10,8)");
           // getELProcessor().eval("oM4u.getCanvas(10,8).draw(oM4u.get(Line.class).line(1,3,7,3)).write(new java.nio.file.FileSystems.getDefault().getPath('target', 'myTemp.png'))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCanvas() {
        getELProcessor().eval("oM4u.getCanvas(10,8)");
    }

   

 

/*    @Test
    public void testGetDrawLine() {
        try {
            getELProcessor().eval("oM4u.getCanvas(10,8).draw(oM4u.get(Line.class).line(1,3,7,3))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */
}
