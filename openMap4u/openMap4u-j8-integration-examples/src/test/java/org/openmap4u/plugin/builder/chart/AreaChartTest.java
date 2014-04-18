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

import static org.openmap4u.commons.HorizontalAlign.CENTER;
import static org.openmap4u.commons.HorizontalAlign.LEFT;
import static org.openmap4u.commons.HorizontalAlign.RIGHT;
import static org.openmap4u.commons.VerticalAlign.BOTTOM;
import static org.openmap4u.commons.VerticalAlign.MIDDLE;
import static org.openmap4u.commons.VerticalAlign.TOP;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.OpenMap4u;
import org.openmap4u.data.Data;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.core.Line;
import org.openmap4u.plugin.builder.core.Text;
import org.openmap4u.plugin.builder.symbol.Rectangle;

/**
 *
 * @author Michael Hadrbolec
 */
public class AreaChartTest extends AbstractOpenMap4uTest {

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
    public void testSimpleVerticalAreaChart() throws IOException {
        List<Double> data = MockupData.get().getValues(0.5, 9.5, 10);
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.BLACK).setStrokeFill(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8).center(5, 3);
        /* 3. draw your primitive(s). */
        AreaChart verticalAreaChart = oM4u.get(AreaChart.Vertical.class).fill(Color.lightGray).color(Color.darkGray).size(1);
        data.stream().forEach(value -> verticalAreaChart.lineTo(value, Math.random() * 3 + 1));
        /* 4. draw the line primitve */
        draw.draw(verticalAreaChart);
        /* persist your result */
        draw.write(getPackagePath("simpleVerticalAreaChart.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testSimpleHorizontalAreaChart() throws IOException {
        List<Double> data = MockupData.get().getValues(0.5, 7.5, 10);
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.BLACK).setStrokeFill(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 8).center(4, 4);
        /* 3. draw your primitive(s). */
        AreaChart.Horizontal horizontalAreaChart = oM4u.get(AreaChart.Horizontal.class).fill(Color.lightGray).color(Color.darkGray).size(1);
        data.stream().forEach(value -> horizontalAreaChart.lineTo(Math.random() * 3 + 1, value));
        /* 4. draw the line primitve */
        draw.draw(horizontalAreaChart);
        /* persist your result */
        draw.write(getPackagePath("simpleHorizontalAreaChart.png"));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testVertcialAreaChart() throws IOException {
        List<Data<Double, Double[]>> data = MockupData.get().getRandom(2, 5, 1, 9);
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setStrokeColor(Color.BLACK).setStrokeFill(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(10, 8).center(4, 3);
        /* 3. draw your primitive(s). */
        AreaChart.Vertical horizontalAreaChart = oM4u.get(AreaChart.Vertical.class).fill(Color.lightGray).color(Color.darkGray).size(1);
        data.stream().forEach(value -> horizontalAreaChart.lineTo(value.getKey(), value.getValue()[0]));
                
        /* 4. draw the line primitve */
        canvas.draw(horizontalAreaChart);
         /* draw horizontal lines */
        data.stream().forEach(value -> canvas.draw(oM4u.get(Line.class).color(Color.WHITE).line(0, value.getKey(), 8, value.getKey())));
       /* draw vertical lines */
        data.stream().map(value -> canvas.draw( oM4u.get(Line.class).line(value.getKey(), 0, value.getKey(), value.getValue()[0])));
        /* label x axis */
        data.stream().forEach(value -> canvas.draw(oM4u.get(Text.class).color(Color.BLACK).point(value.getKey(), 0).align(CENTER,TOP).offset(0, -.25).size(2.5).text(value.getKey())));
        /* label y axis */
        MockupData.get().getValues(1, 4, 4).stream().forEach(value -> canvas.draw(oM4u.get(Text.class).color(Color.DARK_GRAY).point(0, value).align(RIGHT,MIDDLE).offset(-.5, 0).size(2.5).text("%2.0f",value)));

        /* add symbols */
        data.stream().forEach(value -> canvas.draw(oM4u.get(Rectangle.class).color(Color.RED).fill(Color.WHITE).point(value.getKey(), value.getValue()[0]).width(0.25)));
        /* label values with two digits after the deciaml seperator */
        data.stream().forEach(value -> canvas.draw(oM4u.get(Text.class).color(Color.BLACK).point(value.getKey(), value.getValue()[0]).offset(0, 0.35).rotate(75).size(2.5).align(LEFT,BOTTOM).text("%2.2f", value.getValue()[0])));

        /* persist your result */
        canvas.write(getPackagePath("horizontalAreaChart.png"));
    }

}
