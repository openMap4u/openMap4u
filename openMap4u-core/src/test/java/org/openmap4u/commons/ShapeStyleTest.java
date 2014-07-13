/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import org.openmap4u.commons.ShapeStyleable;
import org.openmap4u.commons.ShapeStyle;
import java.awt.Color;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Hadrbolec
 */
public class ShapeStyleTest {

    private ShapeStyleable mS = null;
    private ShapeStyleable mSD = null;

    /**
     *
     */
    @Before
    public void setUp() {
        mS = new ShapeStyle();
        mSD = new ShapeStyle().strokeColor(Color.GREEN).strokeFill(Color.YELLOW).strokeSize(3).alpha(.5).visible(false);
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of clone method, of class ShapeStyle.
     * @throws java.lang.Exception
     */
    @Test
    public void testClone() throws Exception {
        ShapeStyleable cloned = mSD.clone();
        assertThat(cloned.isVisible(), is(mSD.isVisible()));
        assertThat(cloned.getAlpha(), is(mSD.getAlpha()));
        assertThat(cloned.getStrokeColor(), is(mSD.getStrokeColor()));
        assertThat(cloned.getStrokeFill(), is(mSD.getStrokeFill()));
        assertThat(cloned.getStrokeSize(), is(mSD.getStrokeSize()));
        System.out.println(mSD);

        System.out.println(cloned);
        /* change the cloned values */
        cloned.visible(true).alpha(.6).strokeColor(Color.BLACK).strokeFill(Color.BLUE).strokeSize(7);
        System.out.println(mSD);
        System.out.println(cloned);
        assertThat(cloned.isVisible(), not(mSD.isVisible()));
        assertThat(cloned.getAlpha(), not(mSD.getAlpha()));
        assertThat(cloned.getStrokeColor(), not(mSD.getStrokeColor()));
        assertThat(cloned.getStrokeFill(), not(mSD.getStrokeFill()));
        assertThat(cloned.getStrokeSize(), not(mSD.getStrokeSize()));

    }

}
