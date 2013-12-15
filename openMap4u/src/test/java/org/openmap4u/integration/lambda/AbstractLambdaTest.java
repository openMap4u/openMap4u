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
import org.openmap4u.plugin.builder.chart.Pie;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.canvas.DrawOrWrite;
import org.openmap4u.commons.Position;
import org.openmap4u.plugin.builder.chart.Bar;
import org.openmap4u.plugin.builder.symbol.Circle;
import org.openmap4u.plugin.builder.symbol.Rectangle;
import org.openmap4u.unit.Angle;

/**
 *
 * @author zwotti
 */
public class AbstractLambdaTest {

    Stream<Double> getData() {
        return Stream.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d);
    }

    Stream<Double> getPieData() {
        return Stream.of(36d, 2*36d, 3*36d, 4*36d);
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
        getData().map(value -> oM4u.getBuilder(Polygon.class).moveTo(0, 0).lineTo(10, value)).forEach(primitive -> draw.draw(primitive));
        /* Yes your can repeat this multiple times. Like here with a circle */
        draw.draw(oM4u.getBuilder(Circle.class).diameter(2).point(5, 4));
        /* An Yes another time , .... */
        getData().map(value -> oM4u.getBuilder(Rectangle.class).point(value, 0.5).setSize(.5, Math.random() * 8.0).align(Position.CenterBottom)).forEach(primitive -> draw.draw(primitive));

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
        Polygon shape = oM4u.getBuilder(Polygon.class);
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
        getData().map(value -> oM4u.getBuilder(Bar.class).fill(getColor()).point(value, 0.5).setSize(.5, Math.random() * 3 + 1).align(Position.CenterBottom)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uBarChart.png"));
    }

    @Test
    public void testRoundedBarChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        getData().map(value -> oM4u.getBuilder(Bar.class).point(value, 0.5).setSize(.5, Math.random() * 3 + 1).align(Position.CenterBottom).radius(.2)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uRoundedBarChart.png"));
    }

    @Test
    public void testPieChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        draw.draw(oM4u.getBuilder(Pie.class).point(5, 4).unit(Angle.PERCENT).start(.20).end(0.75).radius(2).fill(Color.GREEN));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uPieChart.png"));
    }

    @Test
    public void testPieChart1() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        Pie pie = oM4u.getBuilder(Pie.class).point(5, 4).start(0).radius(2);
        /* Draw the pies */
        getPieData().map(value -> pie.add(value )).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uPieChart1.png"));
    }

    @Test
    public void testPieChart4() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        Pie pie = oM4u.getBuilder(Pie.class).point(5, 4).start(0).radius(2).unit(Angle.DEGREE);
        /* Draw the pies */
        getPieData().map(value -> pie.add(value).fill(getColor()).transparence(Math.random()).radius(2)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uPieChart4.png"));
    }

    @Test
    public void testPieChart3() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        Pie pie = oM4u.getBuilder(Pie.class).point(5, 4).start(0).radius(2);

        /* Draw the pies */
        getData().map(value -> pie.add(value * .1).transparence(1 / value / 10)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uPieChart1.png"));
    }

    @Test
    public void testPieChart2() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        Pie pie = oM4u.getBuilder(Pie.class).point(5, 4).start(0).radius(2);

        /* Draw the bars */
        draw.draw(pie.add(.05).fill(Color.RED)).draw(pie.add(0.05).fill(Color.GREEN)).draw(pie.add(0.05).fill(Color.YELLOW)).draw(pie.add(0.05).fill(Color.GRAY));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uPieChart2.png"));
    }

    @Test
    public void testDonutChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* Draw the bars */
        draw.draw(oM4u.getBuilder(Pie.class).point(5, 4).start(.05).end(0.35).innerRadius(2).outerRadius(3).fill(Color.GREEN));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uDonutChart.png"));
    }

    @Test
    public void testDonutChart1() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        Pie donut = oM4u.getBuilder(Pie.class).point(5, 4).innerRadius(1).outerRadius(2).start(0.0000001);
        /* Draw the bars */
        draw.draw(donut.add(.1).fill(Color.YELLOW)).draw(donut.add(.2).fill(Color.GREEN));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uDonutChart1.png"));
    }

    @Test
    public void testDonutChart2() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        Pie donut = oM4u.getBuilder(Pie.class).point(5, 4).innerRadius(1).outerRadius(2).start(0.0000001);
        /* Draw the bars */
        Pie pie = oM4u.getBuilder(Pie.class).point(5, 4).start(0).radius(2);
        /* Draw the pies */
        getPieData().map(value -> pie.add(value ).fill(getColor()).transparence(Math.random()).outerRadius(2+ Math.random()).innerRadius(1+ Math.random())).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "openMap4uDonutChart2.png"));
    }
    
    
    Color getColor() {
    return new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }
}
