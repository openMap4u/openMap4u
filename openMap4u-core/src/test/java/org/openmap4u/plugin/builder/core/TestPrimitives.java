/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.core;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.openmap4u.OpenMap4u;
import org.openmap4u.SetAreaOfInterestOrDrawOrWriteable;

/**
 *
 * @author hadrbolec
 */
public class TestPrimitives {

    @Test
    public void testDrawText() throws IOException {
        OpenMap4u om4u = new OpenMap4u();
       SetAreaOfInterestOrDrawOrWriteable myCanvas =  om4u.getCanvas(4, 1);
       Text myText = om4u.get(Text.class).text("Hello world!").center(.25, 0.125);
       myCanvas.draw(myText);
       myCanvas.write("myText.png");
    }

    @Test
    public void testDrawLine() throws IOException {
         OpenMap4u om4u = new OpenMap4u();
       SetAreaOfInterestOrDrawOrWriteable myCanvas =  om4u.getCanvas(4, 1);
       Line myLine = om4u.get(Line.class).line(.25, .125, 3.75, 0.75);
       myCanvas.draw(myLine);
       myCanvas.write("myLine.png");
  }

    @Test
    public void testDrawPolyline() throws IOException {
       OpenMap4u om4u = new OpenMap4u();
       SetAreaOfInterestOrDrawOrWriteable myCanvas =  om4u.getCanvas(4, 1);
       Polyline myPolyline = om4u.get(Polyline.class).lineTo(0.25,.125).lineTo(1.0, 0.75).lineTo(2.0, 0.125).lineTo(3,0.5).lineTo(3.75,0.15);
       myCanvas.draw(myPolyline);
       myCanvas.write("myPolyline.png");
    }

    @Test
    public void testDrawPolygon() throws IOException {
       OpenMap4u om4u = new OpenMap4u();
       SetAreaOfInterestOrDrawOrWriteable myCanvas =  om4u.getCanvas(4, 1);
       Polygon myPolygon = om4u.get(Polygon.class).lineTo(0.25, 0.125).lineTo(2.0,0.75).lineTo(3.75,0.25).lineTo(0.25,0.125).fill(Color.LIGHT_GRAY);
       myCanvas.draw(myPolygon);
       myCanvas.write("myPolygon.png");
    }

    @Test
    public void testDrawImage() throws IOException {
       OpenMap4u om4u = new OpenMap4u();
       SetAreaOfInterestOrDrawOrWriteable myCanvas =  om4u.getCanvas(4, 1);
       Image myImage = om4u.get(Image.class).path(Paths.get("/image/image.png").getFileName()).center(.25, 0.125);
       myCanvas.draw(myImage);
       myCanvas.write("myImage.png");
    }

}
