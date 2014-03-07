/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.core;

import java.awt.Color;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OpenMap4u;
import org.openmap4u.DrawOrWriteable;
import static org.openmap4u.commons.Position.LeftBottom;
import static org.openmap4u.commons.Position.RightBottom;
import static org.openmap4u.commons.Position.RightTop;
import org.openmap4u.plugin.builder.symbol.Rectangle;

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
        DrawOrWriteable canvas = oM4u.getCanvas(10, 2);
        canvas.draw(oM4u.get(Text.class).text("Hello World").size(3).point(.5, .5));
        canvas.draw(oM4u.get(Text.class).text(true).size(3).point(4, .5));
        canvas.draw(oM4u.get(Text.class).text(1f).size(3).point(7, .5));
        canvas.draw(oM4u.get(Text.class).text(1d).size(3).point(8, .5));
        canvas.draw(oM4u.get(Text.class).text(1).size(3).point(9, .5));
        /* write the result */
        canvas.write(getPackagePath("simpleText.png"));
    }

    @Test
    public void testTextLayout() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();

        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(5, 4);
        canvas.draw(oM4u.get(Rectangle.class).width(1).point(1, 1));
        canvas.draw(oM4u.get(Text.class).text("Äg").size(7).offset(1, .5).rotate(30).scale(1.5).point(RightTop));
        /* write the result */
        canvas.draw(oM4u.get(Line.class).line(1.5, 1.5, 2.5, 2).size(1).transparence(.5));
        canvas.draw(getPointMarker(1.5, 1.5, Color.BLUE, Color.GRAY));
        canvas.draw(getPointMarker(2.5, 2, Color.RED, Color.GRAY));

        canvas.write(getPackagePath("textLayout.png"));
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
