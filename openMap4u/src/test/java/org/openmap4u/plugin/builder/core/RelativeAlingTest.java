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
import org.openmap4u.OpenMap4u;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.commons.Position;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.chart.LineChart;
import org.openmap4u.plugin.builder.core.Line.Horizontal;
import org.openmap4u.plugin.builder.core.Line.Vertical;
import org.openmap4u.plugin.builder.symbol.Rectangle;

/**
 *
 * @author hadrbolec
 */
public class RelativeAlingTest extends AbstractOpenMap4uTest {

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
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(Position.LeftTop));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(Position.CenterTop));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(Position.RightTop));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(Position.LeftMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(Position.RightMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(Position.LeftBottom));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(Position.CenterBottom));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(Position.RightBottom));
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
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("LT").point(Position.LeftTop).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("CT").point(Position.CenterTop).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("RT").point(Position.RightTop).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("LM").point(Position.LeftMiddle).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("CM").point(Position.CenterMiddle).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("RM").point(Position.RightMiddle).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("LB").point(Position.LeftBottom).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("CB").point(Position.CenterBottom).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("RB").point(Position.RightBottom).align(Position.CenterMiddle));
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
        Path path = FileSystems.getDefault().getPath("target\\test-classes\\image\\image.png");
       /* draw the line */
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(Position.LeftTop).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(Position.CenterTop).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(Position.RightTop).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(Position.LeftMiddle).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(Position.CenterMiddle).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(Position.RightMiddle).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(Position.LeftBottom).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(Position.CenterBottom).align(Position.CenterMiddle));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(Position.RightBottom).align(Position.CenterMiddle));
        /* write the result */
        canvas.write(getPackagePath("realtiveAlignImage.png"));
    }
  

}
