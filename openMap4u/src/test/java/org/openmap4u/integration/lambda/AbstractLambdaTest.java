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
import org.openmap4u.OpenMap4u;
import org.openmap4u.plugin.builder.chart.PieChart;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.DrawOrWrite;
import org.openmap4u.commons.Position;
import org.openmap4u.plugin.builder.chart.BarChart;
import org.openmap4u.plugin.builder.symbol.Circle;
import org.openmap4u.plugin.builder.symbol.Rectangle;
import org.openmap4u.commons.Angle;

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
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeFill(Color.RED);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* 3. draw your primitive(s). */
        getData().map(value -> oM4u.getBuilder(Polygon.class).moveTo(0, 0).lineTo(10, value)).forEach(primitive -> draw.draw(primitive));
        /* Yes your can repeat this multiple times. Like here with a circle */
        draw.draw(oM4u.getBuilder(Circle.class).diameter(2).point(5, 4));
        /* An Yes another time , .... */
        getData().map(value -> oM4u.getBuilder(Rectangle.class).point(value, 0.5).setSize(.5, Math.random() * 8.0).align(Position.CenterBottom)).forEach(primitive -> draw.draw(primitive));

        /* persist your result */
        draw.write(this.getPackagePath( "myTemp.png"));
    }

  

    /**
     *
     * @throws IOException
     */
    @Test
    public void testBarChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        getData().map(value -> oM4u.getBuilder(BarChart.class).fill(getColor()).point(value, 0.5).setSize(.5, Math.random() * 3 + 1).align(Position.CenterBottom)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uBarChart.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testRoundedBarChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        getData().map(value -> oM4u.getBuilder(BarChart.class).point(value, 0.5).setSize(.5, Math.random() * 3 + 1).align(Position.CenterBottom).radius(.2)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uRoundedBarChart.png"));
    }

 
    
    
   
}
