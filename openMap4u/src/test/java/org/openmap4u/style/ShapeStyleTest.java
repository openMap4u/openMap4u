/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.style;

import org.openmap4u.style.ShapeStyle;
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
        mSD = new ShapeStyle().setStrokeColor(Color.GREEN).setStrokeFill(Color.YELLOW).setStrokeSize(3).setAlpha(.5).setVisible(false);
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
        cloned.setVisible(true).setAlpha(.6).setStrokeColor(Color.BLACK).setStrokeFill(Color.BLUE).setStrokeSize(7);
        System.out.println(mSD);
        System.out.println(cloned);
        assertThat(cloned.isVisible(), not(mSD.isVisible()));
        assertThat(cloned.getAlpha(), not(mSD.getAlpha()));
        assertThat(cloned.getStrokeColor(), not(mSD.getStrokeColor()));
        assertThat(cloned.getStrokeFill(), not(mSD.getStrokeFill()));
        assertThat(cloned.getStrokeSize(), not(mSD.getStrokeSize()));

    }

}
