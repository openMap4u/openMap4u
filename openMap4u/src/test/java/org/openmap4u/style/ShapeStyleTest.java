/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.style;

import java.awt.Color;
import java.awt.Paint;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openmap4u.commons.HorizontalAlign;
import org.openmap4u.commons.VerticalAlign;

/**
 *
 * @author zwotti
 */
public class ShapeStyleTest {

    private ShapeStyleable mS = null;
    private ShapeStyleable mSD = null;

    @Before
    public void setUp() {
        mS = new ShapeStyle();
        mSD = new ShapeStyle().setStrokeColor(Color.GREEN).setStrokeFill(Color.YELLOW).setStrokeSize(3).setAlpha(.5).setHorizontalAlign(HorizontalAlign.LEFT).setVerticalAlign(VerticalAlign.TOP).setVisible(false);
    }

    @After
    public void tearDown() {
    }


    /**
     * Test of clone method, of class ShapeStyle.
     */
    @Test
    public void testClone() throws Exception {
        ShapeStyleable cloned = mSD.clone();
        assertThat(cloned.isVisible(), is(mSD.isVisible()));
        assertThat(cloned.getAlpha(), is(mSD.getAlpha()));
        assertThat(cloned.getHorizontalAlign(), is(mSD.getHorizontalAlign()));
        assertThat(cloned.getVerticalAlign(), is(mSD.getVerticalAlign()));
        assertThat(cloned.getStrokeColor(), is(mSD.getStrokeColor()));
        assertThat(cloned.getStrokeFill(), is(mSD.getStrokeFill()));
        assertThat(cloned.getStrokeSize(), is(mSD.getStrokeSize()));
        System.out.println(mSD);
       
        System.out.println(cloned);
        /* change the cloned values */
        cloned.setVisible(true).setAlpha(.6).setHorizontalAlign(HorizontalAlign.RIGHT).setVerticalAlign(VerticalAlign.BOTTOM).setStrokeColor(Color.BLACK).setStrokeFill(Color.BLUE).setStrokeSize(7);
        System.out.println(mSD);
        System.out.println(cloned);
       assertThat(cloned.isVisible(), not(mSD.isVisible()));
        assertThat(cloned.getAlpha(), not(mSD.getAlpha()));
        assertThat(cloned.getHorizontalAlign(), not(mSD.getHorizontalAlign()));
        assertThat(cloned.getVerticalAlign(), not(mSD.getVerticalAlign()));
        assertThat(cloned.getStrokeColor(), not(mSD.getStrokeColor()));
        assertThat(cloned.getStrokeFill(), not(mSD.getStrokeFill()));
        assertThat(cloned.getStrokeSize(), not(mSD.getStrokeSize()));

    }

}
