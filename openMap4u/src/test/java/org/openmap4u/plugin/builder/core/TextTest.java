/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.core;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OpenMap4u;
import org.openmap4u.canvas.DrawOrWrite;
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWrite;
import org.openmap4u.commons.Position;

/**
 *
 * @author hadrbolec
 */
public class TextTest extends AbstractOpenMap4uTest {

    /**
     *
     */
    public TextTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testSimpleText() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite canvas = oM4u.getCanvas().size(10, 2);
        canvas.draw(oM4u.getBuilder(Text.class).text("Hello World").size(3).point(.5, .5));
        canvas.draw(oM4u.getBuilder(Text.class).text(true).size(3).point(4, .5));
        canvas.draw(oM4u.getBuilder(Text.class).text(1f).size(3).point(7, .5));
        canvas.draw(oM4u.getBuilder(Text.class).text(1d).size(3).point(8, .5));
        canvas.draw(oM4u.getBuilder(Text.class).text(1).size(3).point(9, .5));
        /* write the result */
        canvas.write(getPackagePath("simpleText.png"));

    }

    @Test
    public void testSimpleFormatedText() {
    }

    @Test
    public void testSimpleFormatedNumber() {
    }

    @Test
    public void testSimpleFormatedDate() {
    }

    @Test
    public void testFormatMultipleObjectsIntoAText() {
    }

}
