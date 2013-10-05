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

    @Test
    public void testProcessor() {
        assertThat(getELProcessor(), notNullValue());
    }

    @Test
    public void testSinglePrimitive() {
        getELProcessor().eval("n=4+3");
        getELProcessor().eval("oM4u.getCanvas().size(10,8)");
        getELProcessor().eval("oM4u.getCanvas().size(10,8).draw(oM4u.getBuilder().getShape().moveTo(1,3).lineTo(7,3)).write(new java.nio.file.FileSystems.FileSystems.getDefault().getPath(\"temp\", \"myTemp.png\"))");
    }
}
