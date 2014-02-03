/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.core;

import java.awt.Color;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.*;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OpenMap4u;
import org.openmap4u.DrawOrWrite;
import org.openmap4u.commons.Position;

/**
 *
 * @author hadrbolec
 */
public class LineTest extends AbstractOpenMap4uTest {

    protected Stream<Double> getData() {
        return Stream.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d);
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
    public void testDrawSimpleLine() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite canvas = oM4u.getCanvas().size(10, 1);
        /* draw the line */
        canvas.draw(oM4u.getBuilder(Line.class).line(1, .25, 9, .75).size(1).color(Color.GRAY));
        /* write the result */
        canvas.write(getPackagePath("simpleLine.png"));
    }

    @Test
    public void testDrawSimpleVerticalLines() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite canvas = oM4u.getCanvas().size(10, 8);
        Line line = oM4u.getBuilder(Line.class).line(0, 1, 0, 7).size(1).color(Color.GRAY);
        /* draw the line */
        getData().forEach(value -> line.point(value,0));
        canvas.draw(line);
        /* write the result */
        canvas.write(getPackagePath("simpleVerticalLines.png"));

    }

    @Test
    public void testDrawSimpleVerticalLinesWithLabel() throws IOException {
     /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite canvas = oM4u.getCanvas().size(10, 8);
        Line line = oM4u.getBuilder(Line.class).line(0, 1, 0, 7).size(1).color(Color.GRAY);
        /* draw the line */
        getData().forEach(value -> line.point(value,0));
        canvas.draw(line);
        
           /* draw the line */
        getData().forEach(value -> canvas.draw(oM4u.getBuilder(Text.class).text(value).point(value,1).size(3.5).align(Position.CenterTop).offset(0, 2)));
        
   
        /* write the result */
        canvas.write(getPackagePath("simpleVerticalLinesWithLabel.png"));
   }

}
