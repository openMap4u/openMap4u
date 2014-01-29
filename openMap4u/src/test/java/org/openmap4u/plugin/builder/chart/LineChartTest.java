/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OpenMap4u;
import org.openmap4u.canvas.DrawOrWrite;
import org.openmap4u.commons.Position;
import org.openmap4u.data.Data;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.plugin.builder.core.Text;
import org.openmap4u.plugin.builder.symbol.Circle;

/**
 *
 * @author Michael Hadrbolec
 */
public class LineChartTest extends AbstractOpenMap4uTest {

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

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSimpleLineChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* 3. draw your primitive(s). */
        getData().map(value -> oM4u.getBuilder(LineChart.class).from(0, value).to(value, value)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(getPackagePath("line.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSimpleStackedLineChart() throws IOException {
        /* get the data */
        List<Data<Double, Double[]>> values = MockupData.get().getRandom(0.5, 2, 3, 10);
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.GRAY).setStrokeSize(2);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* 3. draw your primitive(s). */
        /* first start with the base line */
        LineChart shape1 = oM4u.getBuilder(LineChart.class).color(Color.RED);
        values.stream().forEach(value -> shape1.lineTo(value.getKey(), value.getValue()[0]));
        draw.draw(shape1);
        /* stack the second line */
        LineChart shape2 = oM4u.getBuilder(LineChart.class).color(Color.green);
        values.stream().forEach(value -> shape2.lineTo(value.getKey(), value.getValue()[0] + value.getValue()[1]));
        draw.draw(shape2);
        /* stack the second line */
        LineChart shape3 = oM4u.getBuilder(LineChart.class).color(Color.BLUE);
        values.stream().forEach(value -> shape3.lineTo(value.getKey(), value.getValue()[0] + value.getValue()[1] + value.getValue()[2]));
        draw.draw(shape3);
       /* persist your result */
        draw.write(getPackagePath("simpleStackedLineChartBottom.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSimpleLineRaster() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.GRAY);
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /*  draw the horizontal raster lines */
        getData().map(value -> oM4u.getBuilder(LineChart.class).from(0, value).to(10, value)).forEach(primitive -> draw.draw(primitive));
        /* draw the vertical raster lines */
        getData().map(value -> oM4u.getBuilder(LineChart.class).from(value, 0).to(value, 8)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "simpleLineRaster.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSimpleLineRasterWithLabel() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.GRAY);
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /*  draw the horizontal raster lines */
        draw.draw(oM4u.getBuilder(LineChart.class).from(0, 4).to(8, 4)).draw(oM4u.getBuilder(Text.class).point(Position.CenterMiddle).text("HelloWorld"));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "simpleLineRasterWithLabel.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testLineRasterWithHighightedRowsAndColumns() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /*  draw the horizontal raster lines */
        getData().map(value -> oM4u.getBuilder(LineChart.class).from(0, value).to(10, value).size((value % 2 == 0) ? 1 : 0.5).color((value % 2 == 0) ? Color.BLACK
                : Color.GRAY)).forEach(primitive -> draw.draw(primitive));
        /* draw the vertical raster lines */
        getData().map(value -> oM4u.getBuilder(LineChart.class).from(value, 0).to(value, 8).size((value % 2 == 0) ? 1 : 0.5).color((value % 2 == 0) ? Color.BLACK
                : Color.GRAY)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "LineRasterWithHighightedRowsAndColumns.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSimpleCircleRaster() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /*  draw the horizontal raster lines */
        Stream.of(1, 2, 3).map(value -> oM4u.getBuilder(Circle.class).point(5, 4).radius(value).size((value % 2 == 0) ? 0.5 : 1).color((value % 2 == 0) ? Color.GRAY
                : Color.BLACK)).forEach(primitive -> draw.draw(primitive));
        /* draw the vertical raster lines */
        Stream.of(0d, 45d, 90d, 135d).map(value -> oM4u.getBuilder(LineChart.class).point(5, 4).from(-3.5, 0).to(3.5, 0).size((value % 2 == 0) ? 1 : 0.5).color((value % 2 == 0) ? Color.BLACK
                : Color.GRAY).rotate(value)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "SimpleCircleRaster.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testCircleRasterWithHighightedRowsAndColumns() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /*  draw the horizontal raster lines */
        Stream.of(1, 2, 3).map(value -> oM4u.getBuilder(Circle.class).point(5, 4).color(Color.GRAY).radius(value)).forEach(primitive -> draw.draw(primitive));
        /* draw the vertical raster lines */
        Stream.of(0d, 45d, 90d, 135d).map(value -> oM4u.getBuilder(LineChart.class).point(5, 4).from(-3.5, 0).to(3.5, 0).color(Color.GRAY).rotate(value)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "CircleRasterWithHighightedRowsAndColumns.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /*  draw the horizontal raster lines */
        Stream.of(1, 2, 3).map(value -> oM4u.getBuilder(Circle.class).point(5, 4).color(Color.GRAY).radius(value)).forEach(primitive -> draw.draw(primitive));
        /* draw the vertical raster lines */
        Stream.of(0d, 45d, 90d, 135d).map(value -> oM4u.getBuilder(LineChart.class).point(5, 4).from(-3.5, 0).to(3.5, 0).color(Color.GRAY).rotate(value)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("/temp", "CircleRasterWithHighightedRowsAndColumns.png"));
    }

    /**
     *
     * @throws IOException
     */
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
        draw.write(this.getPackagePath("openMap4uLineChart.png"));
    }

}