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
import org.openmap4u.OpenMap4u;
import org.openmap4u.builder.Shape;
import org.openmap4u.canvas.DrawOrWrite;
import org.openmap4u.commons.VerticalAlign;
import org.openmap4u.plugin.builder.symbol.Circle;
import org.openmap4u.plugin.builder.symbol.Rectangle;
import org.openmap4u.unit.Length;

/**
 *
 * @author zwotti
 */
public class AbstractLambdaTest {

    Stream<Double> getData() {
        return Stream.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d);
    }

    @Test
    public void testSimpleLambda() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeFill(Color.RED);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* 3. draw your primitive(s). */
        getData().map(value -> oM4u.getBuilder().getShape().moveTo(0, 0).lineTo(10, value)).forEach(primitive -> draw.draw(primitive));
        /* Yes your can repeat this multiple times. Like here with a circle */
        draw.draw(oM4u.getBuilder().getCustomBuilder(Circle.class).diameter(2).setPoint(5, 4));
        /* An Yes another time , .... */
        getData().map(value -> oM4u.getBuilder().getCustomBuilder(Rectangle.class).setPoint(value, 0.5).setSize(.5, Math.random() * 8.0).verticalAlign(VerticalAlign.BOTTOM)).forEach(primitive -> draw.draw(primitive));

        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "myTemp.png"));
    }

    @Test
    public void testLineChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* 3. draw your primitive(s). */
        Shape shape = oM4u.getBuilder().getShape();
        getData().forEach(value -> shape.lineTo(value, Math.random() * 3 + 1));
        /* 4. draw the line primitve */
        draw.draw(shape);
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uLineChart.png"));
    }

    @Test
    public void testBarChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        getData().map(value -> oM4u.getBuilder().getCustomBuilder(Rectangle.class).setPoint(value, 0.5).setSize(.5, Math.random() * 3 + 1).verticalAlign(VerticalAlign.BOTTOM)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uBarChart.png"));
    }
    
    @Test
    public void testPieChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        getData().map(value -> oM4u.getBuilder().getCustomBuilder(Rectangle.class).setPoint(value, 0.5).setSize(.5, Math.random() * 3 + 1).verticalAlign(VerticalAlign.BOTTOM)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uPieChart.png"));
    }
    
    @Test
    public void testDonutChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        getData().map(value -> oM4u.getBuilder().getCustomBuilder(Rectangle.class).setPoint(value, 0.5).setSize(.5, Math.random() * 3 + 1).verticalAlign(VerticalAlign.BOTTOM)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uDonutChart.png"));
    }
}
