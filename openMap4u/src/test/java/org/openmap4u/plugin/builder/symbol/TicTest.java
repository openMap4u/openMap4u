package org.openmap4u.plugin.builder.symbol;

import java.awt.Color;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OpenMap4u;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.commons.Position;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.plugin.builder.core.Text;
import java.util.List;

/**
 *
 * @author Michael Hadrbolec
 */
public class TicTest extends AbstractOpenMap4uTest {

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
    public void testSimpleHorizontalTic() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(2, 8);
        /* 3. draw your primitive(s). */
        /* 3. draw your primitive(s). */
        Tic.Horizontal tic = oM4u.create(Tic.Horizontal.class).length(0.5).color(Color.BLACK);
        MockupData.get().getValues(0, 8, 16).forEach(value -> tic.point(1, value));
        draw.draw(tic);
        /* persist your result */
        draw.write(getPackagePath("simpleHorizontalTic.png"));

    }

    @Test
    public void testSimpleHorizontalTicWithLabel() throws IOException {
        List<Double> values = MockupData.get().getValues(0, 8, 16);
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(4, 8);
        /* 3. draw your primitive(s). */
        /* 3. draw your primitive(s). */
        Tic.Horizontal tic = oM4u.create(Tic.Horizontal.class).length(0.5).color(Color.BLACK);
       
        values.stream().forEach(value -> tic.point(3, value));
              draw.draw(tic);
   
        /* draw labels */
        values.stream().map(value -> oM4u.create(Text.class).point(2, value).align(Position.RightMiddle).text("%1$2.1f", value)).forEach(label -> draw.draw(label));
        /* persist your result */
        draw.write(getPackagePath("simpleHorizontalTic.png"));

    }

    @Test
    public void testVerticalHorizontalTic() throws IOException {
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.BLACK);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable draw = oM4u.getCanvas(10, 2);
        /* 3. draw your primitive(s). */
        Tic.Vertical tic = oM4u.create(Tic.Vertical.class).length(0.5).color(Color.BLACK);
        MockupData.get().getValues(0, 10, 20).forEach(value -> tic.point(value, 1));
        draw.draw(tic);
        /* persist your result */
        draw.write(getPackagePath("simpleVerticalTic.png"));
    }

}
