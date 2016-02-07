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
import java.awt.geom.Point2D;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
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
import org.openmap4u.plugin.builder.chart.LineChart;
import org.openmap4u.plugin.builder.core.Line.Horizontal;
import org.openmap4u.plugin.builder.core.Line.Vertical;
import org.openmap4u.plugin.builder.symbol.Rectangle;

/**
 *
 * @author hadrbolec
 */
public class RelativeAlignTest extends AbstractOpenMap4uTest {

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
    public void testRealtiveAlignShape() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(3, 3);
        /* draw the line */
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).center(LEFT,TOP));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).center(CENTER,TOP));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).center(RIGHT,TOP));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).center(LEFT,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).center(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).center(RIGHT,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).center(LEFT,BOTTOM));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).center(CENTER,BOTTOM));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).center(RIGHT,BOTTOM));
        /* write the result */
        canvas.write(getPackagePath("realtiveAlignShape.png"));
    }
    
     @Test
    public void testRealtiveAlignText() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(3, 3);
        /* draw the line */
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("LT").center(LEFT,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("CT").center(CENTER,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("RT").center(RIGHT,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("LM").center(LEFT,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("CM").center(CENTER,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("RM").center(RIGHT,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("LB").center(LEFT,BOTTOM).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("CB").center(CENTER,BOTTOM).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("RB").center(RIGHT,BOTTOM).align(CENTER,MIDDLE));
        /* write the result */
        canvas.write(getPackagePath("realtiveAlignText.png"));
    }
    
       @Test
    public void testRealtiveAlignImage() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(3, 3);
        /* draw the line */ 
        Path path = FileSystems.getDefault().getPath("target","test-classes","image","image.png");
       /* draw the line */
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).center(LEFT,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).center(CENTER,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).center(RIGHT,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).center(LEFT,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).center(CENTER,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).center(RIGHT,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).center(LEFT,BOTTOM).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).center(CENTER,BOTTOM).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).center(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).center(RIGHT,BOTTOM).align(CENTER,MIDDLE));
        /* write the result */
        canvas.write(getPackagePath("relativeAlignImage.png"));
    }
  

}
