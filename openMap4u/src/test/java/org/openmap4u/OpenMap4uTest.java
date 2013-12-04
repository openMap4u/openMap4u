/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openmap4u.plugin.builder.core.Polygon;

/**
 *
 * @author Michael Hadrbolec
 */
public class OpenMap4uTest extends AbstractOpenMap4uTest {

    @Test
    public void testDefaultOpenMap4uNotNull() {
        assertThat("default OpenMap4u mockup not null", getDefaultOpenMap4u(), notNullValue());
        assertThat("default OpenMap4u mockup not null", getDefaultOpenMap4u().getBuilder(Polygon.class), notNullValue());
        assertThat("default OpenMap4u mockup not null", getDefaultOpenMap4u().getCanvas(), notNullValue());
    }

    @Test
    public void testOverridenOpenMap4uNotNull() {
        assertThat("overridden OpenMap4u mockup not null", getOverriddenOpenMap4u(), notNullValue());

    }

   
}