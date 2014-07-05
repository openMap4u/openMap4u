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
import java.util.Map;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.OpenMap4u;
import static org.openmap4u.commons.HorizontalAlign.CENTER;
import static org.openmap4u.commons.HorizontalAlign.LEFT;
import static org.openmap4u.commons.HorizontalAlign.RIGHT;
import static org.openmap4u.commons.VerticalAlign.BOTTOM;
import static org.openmap4u.commons.VerticalAlign.MIDDLE;
import static org.openmap4u.commons.VerticalAlign.TOP;
import org.openmap4u.data.Data;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.core.Line;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.plugin.builder.core.Text;
import org.openmap4u.plugin.builder.symbol.Circle;

/**
 *
 * @author Michael Hadrbolec
 */
public class BarChartTest extends AbstractOpenMap4uTest {

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
    public void testSimpleBarChart() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(10, 8);
        /* 3. draw your primitive(s). */
        getData().map(value -> oM4u.get(BarChart.class).width(.2).height(value).fill(Color.GRAY)).forEach(e -> canvas.draw(e));
        /* persist your result */
        canvas.write(getPackagePath("simpleBarChart.png"));
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
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        /* Draw the bars */
        getData().map(value -> oM4u.get(BarChart.class).fill(getColor()).center(value, 0.5).setSize(.5, Math.random() * 3 + 1).align(CENTER, BOTTOM)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(this.getPackagePath("openMap4uBarChart.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testBarChartAdvanced() throws IOException {
        List<Data<Double, Double[]>> data = MockupData.get().getRandom(2, 5, 1, 9);
        List<Double> vScale = MockupData.get().getValues(0, 6, 7);
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(11, 8).center(3.5, 3);

        /* Draw the bars */
        data.stream().map(value -> oM4u.get(BarChart.class).color(Color.RED).fill(Color.LIGHT_GRAY).center(value.getKey(), 0.0).setSize(.5, value.getValue()[0]).align(CENTER, BOTTOM)).forEach(primitive -> canvas.draw(primitive));

        /* draw horizontal lines */
        MockupData.get().getValues(1, 6, 6).forEach(value -> canvas.draw(oM4u.get(Line.class).color(Color.WHITE).line(-.5, value, 8.5, value)));

         /* label y axis */
        vScale.stream().forEach(value -> canvas.draw(oM4u.get(Line.class).color(Color.DARK_GRAY).line(-.7, value, -.5, value)));

        vScale.stream().forEach(value -> canvas.draw(oM4u.get(Text.class).color(Color.DARK_GRAY).center(-.7, value).align(RIGHT, MIDDLE).offset(-.5, 0).size(2.5).text("%2.0f", value)));

        /* label values with two digits after the deciaml seperator */
        data.stream().forEach(value -> canvas.draw(oM4u.get(Text.class).color(Color.BLACK).center(value.getKey(), value.getValue()[0]).offset(0, 0.35).rotate(75).size(2.5).align(LEFT, BOTTOM).text("%2.2f", value.getValue()[0])));
   /* label x axis */
        data.stream().forEach(value -> canvas.draw(oM4u.get(Text.class).color(Color.BLACK).center(value.getKey(), 0).align(CENTER, TOP).offset(0, -.25).size(2.5).text(value.getKey())));
    
        /* persist your result */
        canvas.write(this.getPackagePath("advancedBarChart.png"));
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
        DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        /* Draw the bars */
        getData().map(value -> oM4u.get(BarChart.class).center(value, 0.5).setSize(.5, Math.random() * 3 + 1).align(CENTER, BOTTOM).radius(.2)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(this.getPackagePath("openMap4uRoundedBarChart.png"));
    }
    
     /**
     *
     * @throws IOException
     */
 /*   @Test
    public void testRoundedBarChartWDI() throws IOException {
        Map<String, Map<Integer, Double>> data =  MockupData.get().getContriesIndicator(new String[]{"AUT","DEU","CHE"},"SI.POV.GINI");
         OpenMap4u oM4u = new OpenMap4u();
         DrawOrWriteable draw = oM4u.getCanvas(10, 8);
        data.get("AUT").entrySet().stream().map(value -> oM4u.get(BarChart.class).center((value.getKey()-1960), 0.5).setSize(.5, value.getValue()).align(CENTER, BOTTOM).radius(.2)).forEach(primitive -> draw.draw(primitive));
         draw.write(this.getPackagePath("openMap4uRoundedBarChartWDI.png"));
    } */

}
