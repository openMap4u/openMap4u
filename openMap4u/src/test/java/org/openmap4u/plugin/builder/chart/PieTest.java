/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OpenMap4u;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.commons.Angle;

/**
 *
 * @author hadrbolec
 */
public class PieTest extends AbstractOpenMap4uTest {

    Stream<Double> getPieData() {
        return Stream.of(45d,90d,135d,90d);
    }

    private PieChart pie = null;

    /**
     *
     */
    @Before
    public void setUp() {
        pie = new OpenMap4u().create(PieChart.class);
    }

    /**
     * Test of getEnd method, of class Pie.
     */
    @Test
    public void testEnd() {
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.DEGREE));
        assertThat(pie.getExtent(), is(0d));
        pie.end(180);
        assertThat(pie.getExtent(), is(Math.PI));
    }

    /**
     * Test of getStart method, of class Pie.
     */
    @Test
    public void testStart() {
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.DEGREE));
        assertThat(pie.getStart(), is(0d));
        pie.start(90);
        assertThat(pie.getStart(), is(Math.PI / 2d));
    }

    /**
     * Test of color method, of class Pie.
     */
    @Test
    public void testStrokeColor() {
        pie.color(Color.CYAN);
        assertThat(pie.getStyle().getStrokeColor(), is(Color.CYAN));
    }

    /**
     * Test of fill method, of class Pie.
     */
    @Test
    public void testStrokeFill() {
        pie.fill(Color.RED);
        assertThat(pie.getStyle().getStrokeFill(), is(Color.RED));
    }

    /**
     * Test of size method, of class Pie.
     */
    @Test
    public void testStrokeSize() {
        pie.size(5d);
        assertThat(pie.getStyle().getStrokeSize(), is(5d));
    }

    /**
     * Test of radius method, of class Pie.
     */
    @Test
    public void testRadius() {
        pie.radius(5);
        assertThat(pie.getOuterRadius(), is(5d));

    }

    /**
     * Test of innerRadius method, of class Pie.
     */
    @Test
    public void testInnerRadius() {
        assertTrue(Double.isNaN(pie.getInnerRadius()));
        pie.innerRadius(3);
        assertThat(pie.getInnerRadius(), is(3d));
    }

    /**
     * Test of outerRadius method, of class Pie.
     */
    @Test
    public void testOuterRadius() {
        assertTrue(pie.getOuterRadius() > 0);
        pie.outerRadius(3);
        assertThat(pie.getOuterRadius(), is(3d));

    }

    /**
     * Test of diameter method, of class Pie.
     */
    @Test
    public void testDiameter() {
        pie.diameter(10);
        assertThat(pie.getOuterRadius(), is(5d));
    }

    /**
     * Test of unit method, of class Pie.
     */
    @Test
    public void testUnit() {
        pie.unit(Angle.DEGREE);
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.DEGREE));
        pie.unit(Angle.RADIANT);
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.RADIANT));
    }

    /**
     * Test of add method, of class Pie.
     */
    @Test
    public void testAdd() {
        pie.start(90);
        assertThat(pie.getStart(), is(Math.PI / 2d));
        assertThat(pie.getExtent(), is(0d));
        pie.add(45);
        assertThat(pie.getExtent(), is(Math.PI * 1 / 4));
    }

    /**
     * Test of getAngularUnit method, of class Pie.
     */
    @Test
    public void testGetAngularUnit() {
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.DEGREE));
        pie.unit(Angle.PERCENT);
        assertThat(pie.getTransform().getAngleUnits(), is(Angle.PERCENT));
    }

    /**
     * Test of getPrimitive method, of class Pie.
     */
    @Test
    public void testGetPrimitive() {
        pie.start(0.3).end(.5).radius(2);
        assertThat(pie.getShape(), notNullValue());
    }

    /**
     * Test of getControlPoint method, of class Pie.
     */
    @Test
    public void testGetControlPoint() {

    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testPieChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        /* Draw the bars */
        draw.draw(oM4u.create(PieChart.class).point(5, 4).unit(Angle.PERCENT).start(.20).end(0.75).radius(2).fill(Color.GREEN));
        /* persist your result */
        draw.write(this.getPackagePath( "openMap4uPieChart.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testPieChart1() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        /* Draw the bars */
        PieChart pie = oM4u.create(PieChart.class).point(5, 4).start(0).radius(2);
        /* Draw the pies */
        getPieData().map(value -> pie.add(value)).forEach(primitive -> draw.draw(primitive.fill(getColor())));
        /* persist your result */
        draw.write(this.getPackagePath( "openMap4uPieChart1.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testPieChart4() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        /* Draw the bars */
        PieChart pie = oM4u.create(PieChart.class).point(5, 4).start(0).radius(2).unit(Angle.DEGREE);
        /* Draw the pies */
        getPieData().map(value -> pie.add(value).fill(getColor()).transparence(Math.random()).radius(2)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(this.getPackagePath( "openMap4uPieChart4.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testPieChart3() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        /* Draw the bars */
        PieChart pie = oM4u.create(PieChart.class).point(5, 4).start(0).radius(2).fill(Color.DARK_GRAY);

        /* Draw the pies */
        getPieData().map(value -> pie.add(value).transparence(Math.random()*100)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(this.getPackagePath( "openMap4uPieChart3.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testPieChart2() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        /* Draw the bars */
        PieChart pie = oM4u.create(PieChart.class).point(5, 4).start(0).radius(2);

        /* Draw the bars */
        draw.draw(pie.add(15).fill(Color.RED)).draw(pie.add(25).fill(Color.GREEN)).draw(pie.add(15).fill(Color.YELLOW)).draw(pie.add(20).fill(Color.GRAY));
        /* persist your result */
        draw.write(this.getPackagePath( "openMap4uPieChart2.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testDonutChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        /* Draw the bars */
        draw.draw(oM4u.create(PieChart.class).point(5, 4).start(30).add(120).innerRadius(2).outerRadius(3).fill(Color.GREEN));
        /* persist your result */
        draw.write(this.getPackagePath( "openMap4uDonutChart.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testDonutChart1() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        PieChart donut = oM4u.create(PieChart.class).point(5, 4).innerRadius(1).outerRadius(2).start(20).end(90);
        /* Draw the bars */
        draw.draw(donut.add(23).fill(Color.YELLOW)).draw(donut.add(47).fill(Color.GREEN));
        /* persist your result */
        draw.write(this.getPackagePath( "openMap4uDonutChart1.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testDonutChart2() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        PieChart donut = oM4u.create(PieChart.class).point(5, 4).innerRadius(1).outerRadius(2).start(0.0000001);
        /* Draw the bars */
        PieChart pie = oM4u.create(PieChart.class).point(5, 4).start(0).radius(2);
        /* Draw the pies */
        getPieData().map(value -> pie.add(value).fill(getColor()).transparence(Math.random()).outerRadius(2 + Math.random()).innerRadius(1 + Math.random())).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(this.getPackagePath("openMap4uDonutChart2.png"));
    }

}
