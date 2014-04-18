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

import static org.openmap4u.commons.HorizontalAlign.CENTER;
import static org.openmap4u.commons.HorizontalAlign.LEFT;
import static org.openmap4u.commons.HorizontalAlign.RIGHT;
import static org.openmap4u.commons.VerticalAlign.BOTTOM;
import static org.openmap4u.commons.VerticalAlign.MIDDLE;
import static org.openmap4u.commons.VerticalAlign.TOP;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.OpenMap4u;
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
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(LEFT,TOP));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(CENTER,TOP));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(RIGHT,TOP));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(LEFT,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(RIGHT,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(LEFT,BOTTOM));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(CENTER,BOTTOM));
        canvas.draw(oM4u.get(Rectangle.class).width(1).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Rectangle.class).width(0.4).point(RIGHT,BOTTOM));
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
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("LT").point(LEFT,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("CT").point(CENTER,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("RT").point(RIGHT,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("LM").point(LEFT,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("CM").point(CENTER,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("RM").point(RIGHT,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("LB").point(LEFT,BOTTOM).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("CB").point(CENTER,BOTTOM).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Text.class).size(4).text("RB").point(RIGHT,BOTTOM).align(CENTER,MIDDLE));
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
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(LEFT,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(CENTER,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(RIGHT,TOP).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(LEFT,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(CENTER,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(RIGHT,MIDDLE).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(LEFT,BOTTOM).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(CENTER,BOTTOM).align(CENTER,MIDDLE));
        canvas.draw(oM4u.get(Rectangle.class).width(2).size(1).point(1.5, 1.5).color(Color.GRAY)).draw(oM4u.get(Image.class).path(path).point(RIGHT,BOTTOM).align(CENTER,MIDDLE));
        /* write the result */
        canvas.write(getPackagePath("realtiveAlignImage.png"));
    }
  

}
