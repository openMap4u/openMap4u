/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.integration.lambda;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.stream.Stream;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.OpenMap4u;
import static org.openmap4u.commons.HorizontalAlign.CENTER;
import static org.openmap4u.commons.VerticalAlign.BOTTOM;
import org.openmap4u.plugin.builder.chart.BarChart;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.plugin.builder.symbol.Circle;
import org.openmap4u.plugin.builder.symbol.Rectangle;

/**
 *
 * @author zwotti
 */
public class AbstractLambdaTest extends AbstractOpenMap4uTest {

    Stream<Double> getData() {
        return Stream.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d);
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSimpleLambda() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().alpha(.5).strokeFill(Color.RED);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        /* 3. draw your primitive(s). */
        getData().map(value -> oM4u.get(Polygon.class).moveTo(0, 0).lineTo(10, value)).forEach(primitive -> draw.draw(primitive));
        /* Yes your can repeat this multiple times. Like here with a circle */
        draw.draw(oM4u.get(Circle.class).diameter(2).center(5, 4));
        /* An Yes another time , .... */
        getData().map(value -> oM4u.get(Rectangle.class).center(value, 0.5).setSize(.5, Math.random() * 8.0).align(CENTER,BOTTOM)).forEach(primitive -> draw.draw(primitive));

        /* persist your result */
        draw.write(this.getPackagePath( "myTemp.png"));
    }

  



 
    
    
   
}
