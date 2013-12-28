/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.integration.nashorn;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Hadrbolec
 */
public class NashornTest extends AbstractNashornTest {

    /**
     *
     */
    @Test
    public void testScriptEngine() {
        assertThat(getEngine(), notNullValue());
    }

}
