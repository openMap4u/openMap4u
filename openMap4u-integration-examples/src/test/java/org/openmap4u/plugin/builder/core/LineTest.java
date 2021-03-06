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
import java.util.List;
import java.util.stream.Stream;
import org.junit.*;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.OpenMap4u;
import static org.openmap4u.commons.HorizontalAlign.CENTER;
import static org.openmap4u.commons.HorizontalAlign.LEFT;
import static org.openmap4u.commons.HorizontalAlign.RIGHT;
import static org.openmap4u.commons.VerticalAlign.BOTTOM;
import static org.openmap4u.commons.VerticalAlign.MIDDLE;
import static org.openmap4u.commons.VerticalAlign.TOP;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.core.Line.Horizontal;
import org.openmap4u.plugin.builder.core.Line.Vertical;

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
    public void testDrawLineSize() throws IOException {
        OpenMap4u oM4u = new OpenMap4u();
        
        for (int i=1;i<4;i++) {
             /* 2. get an canvas and specify the size which you want to draw */
            DrawOrWriteable canvas = oM4u.getCanvas(1d,.25d);
            /* draw the line */
            canvas.draw(oM4u.get(Line.class).line(0,.125,1,.125).size(i*.5).color(Color.BLACK));
            /* write the result */
            canvas.write(getPackagePath("lineSize_"+i+".png"));	
        }
    }
    
    @Test
    public void testDrawLineColor() throws IOException {
        OpenMap4u oM4u = new OpenMap4u();
        
               /* 2. get an canvas and specify the size which you want to draw */
            DrawOrWriteable canvas = oM4u.getCanvas(.7, .25);
            /* draw the line */
            canvas.draw(oM4u.get(Line.class).line(0,.125,.7,.125).size(0.5).color(Color.RED));
            /* write the result */
            canvas.write(getPackagePath("lineColor_red.png"));	
            canvas = oM4u.getCanvas(.7, .25);
            /* draw the line */
            canvas.draw(oM4u.get(Line.class).line(0,.125,.7,.125).size(.5).color(Color.GREEN));
            /* write the result */
            canvas.write(getPackagePath("lineColor_green.png"));	
            canvas = oM4u.getCanvas(.7, .25);
            /* draw the line */
            canvas.draw(oM4u.get(Line.class).line(0,.125,.7,.125).size(.5).color(Color.BLUE));
            /* write the result */
            canvas.write(getPackagePath("lineColor_blue.png"));	
   
    }
    
    @Test
    public void testDrawSimpleLine() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(10, 1);
        /* draw the line */
        canvas.draw(oM4u.get(Line.class).line(1, .25, 9, .75).size(1).color(Color.GRAY));
        /* write the result */
        canvas.write(getPackagePath("simpleLine.png"));
    }

    @Test
    public void testDrawSimpleVerticalLines() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(10, 8);
        Vertical line = oM4u.get(Vertical.class).line(0, 1, 7).size(1).color(Color.GRAY);
        /* draw the line */
        getData().forEach(value -> line.center(value, 0));
        canvas.draw(line);
        /* write the result */
        canvas.write(getPackagePath("simpleVerticalLines.png"));

    }

    @Test
    public void testDrawSimpleVerticalLinesWithLabel() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(10, 8);
        Line line = oM4u.get(Line.class).line(0, 1, 0, 7).size(1).color(Color.GRAY);
        /* draw the line */
        getData().forEach(value -> line.center(value, 0));
        canvas.draw(line);

        /* draw the line */
        getData().forEach(value -> canvas.draw(oM4u.get(Text.class).text(value).center(value, 1).size(3.5).align(CENTER, TOP).offset(0, 2)));

        /* write the result */
        canvas.write(getPackagePath("simpleVerticalLinesWithLabel.png"));
    }

    @Test
    public void testSimpleHorizontalTic() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().alpha(.5).strokeColor(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(2, 8);
        /* 3. draw your primitive(s). */
        /* 3. draw your primitive(s). */
        Line.Horizontal tic = oM4u.get(Line.Horizontal.class).length(0.5).color(Color.BLACK);
        MockupData.get().getValues(0, 8, 16).forEach(value -> tic.center(1, value));
        draw.draw(tic);
        /* persist your result */
        draw.write(getPackagePath("simpleHorizontalTic.png"));

    }

    @Test
    public void testSimpleHorizontalTicWithLabel() throws IOException {
        List<Double> values = MockupData.get().getValues(0, 8, 16);
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().alpha(.5).strokeColor(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(4, 8);
        /* 3. draw your primitive(s). */
        /* 3. draw your primitive(s). */

        values.stream().forEach(value -> draw.draw(oM4u.get(Line.Horizontal.class).length(0.5).color(Color.BLACK).center(3, value)).draw(oM4u.get(Text.class).center(LEFT, MIDDLE).align(RIGHT, MIDDLE).text("%1$2.1f", value)));
        /* persist your result */
        draw.write(getPackagePath("simpleHorizontalTic.png"));

    }

    @Test
    public void testVerticalHorizontalTic() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().alpha(.5).strokeColor(Color.BLACK);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 2);
        /* 3. draw your primitive(s). */
        Line.Vertical tic = oM4u.get(Line.Vertical.class).length(0.5).color(Color.BLACK);
        MockupData.get().getValues(0, 10, 20).forEach(value -> tic.center(value, 1));
        draw.draw(tic);
        /* persist your result */
        draw.write(getPackagePath("simpleVerticalTic.png"));
    }

    @Test
    public void testVerticalLineLength() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().strokeColor(Color.BLACK);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(2, 1);
        canvas.draw(oM4u.get(Vertical.class).length(.8).center(1, .5));
        canvas.draw(oM4u.get(Text.class).center(1, .5).align(CENTER, BOTTOM).size(2.5).offsetX(-.2).rotate(90).text("length"));
        canvas.draw(oM4u.get(Text.class).center(1, .5).align(LEFT, MIDDLE).size(2.5).offsetX(.2).text("point"));
        canvas.draw(getPointMarker(1, 0.5, Color.WHITE, Color.GRAY)).draw(getPointMarker(1, 0.9, Color.BLUE, Color.WHITE)).
                draw(getPointMarker(1, .1, Color.BLUE, Color.WHITE));
        canvas.write(getPackagePath("verticalLineLength.png"));
    }

    @Test
    public void testHorizontalLineLength() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().strokeColor(Color.BLACK);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(2, 1);
        canvas.draw(oM4u.get(Horizontal.class).length(.8).center(1, .5));
        canvas.draw(oM4u.get(Text.class).center(1, .5).align(CENTER, BOTTOM).size(2.5).offsetY(.2).text("length"));
        canvas.draw(oM4u.get(Text.class).center(1, .5).align(CENTER, TOP).size(2.5).offsetY(-.2).text("point"));
        canvas.draw(getPointMarker(1, 0.5, Color.WHITE, Color.GRAY)).draw(getPointMarker(0.6, 0.5, Color.BLUE, Color.WHITE)).
                draw(getPointMarker(1.4, .5, Color.BLUE, Color.WHITE));
        canvas.write(getPackagePath("horizontalLineLength.png"));
    }

    @Test
    public void testHorizontalLine() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().strokeColor(Color.BLACK);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(2, 1);
        canvas.draw(oM4u.get(Horizontal.class).line(-.4, .4, .0).center(1, .5));
        canvas.draw(oM4u.get(Text.class).center(.6, .5).align(CENTER, BOTTOM).size(2.5).offsetY(.2).text("fromX"));
        canvas.draw(oM4u.get(Text.class).center(1.4, .5).align(CENTER, BOTTOM).size(2.5).offsetY(.2).text("toX"));
        canvas.draw(oM4u.get(Text.class).center(1.4, .5).align(LEFT, MIDDLE).size(2.5).offsetX(.2).text("y"));
        canvas.draw(getPointMarker(0.6, 0.5, Color.BLUE, Color.GRAY)).
                draw(getPointMarker(1.4, .5, Color.RED, Color.GRAY));
        canvas.write(getPackagePath("horizontalLine.png"));
    }

    @Test
    public void testVerticalLine() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().strokeColor(Color.BLACK);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(2.1, 1);
        canvas.draw(oM4u.get(Vertical.class).line(0, -.4, .4).center(1, .5));
        canvas.draw(oM4u.get(Text.class).center(1, .1).align(RIGHT, BOTTOM).size(2.5).offsetX(-.2).text("x"));
        canvas.draw(oM4u.get(Text.class).center(1, .9).align(LEFT, TOP).size(2.5).offsetX(.2).text("toY"));
        canvas.draw(oM4u.get(Text.class).center(1, .1).align(LEFT, BOTTOM).size(2.5).offsetX(.2).text("fromY"));
        canvas.draw(getPointMarker(1, 0.1, Color.BLUE, Color.GRAY)).
                draw(getPointMarker(1, .9, Color.RED, Color.GRAY));
        canvas.write(getPackagePath("verticalLine.png"));
    }

}
