package org.openmap4u;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.plugin.builder.core.Text;

public class FillPolygonWithTextTest extends AbstractOpenMap4uTest {

    @Test
    public void testFillPolygonWithText() {
        OpenMap4u openMap4u = getDefaultOpenMap4u();

        // Create a canvas
        DrawOrWriteable canvas = openMap4u.getCanvas(200, 200);

        // Create polygon builder
        Polygon polygon = openMap4u.get(Polygon.class);
        polygon.moveTo(0, 0).lineTo(100, 0).lineTo(100, 100).lineTo(0, 100).lineTo(0, 0);

        // Create text builder
        Text text = openMap4u.get(Text.class).text("Test");

        // Call fillPolygonWithText
        canvas.fillPolygonWithText(polygon, text);

        // If no exception, test passed (basic smoke test)
        assertThat(canvas, notNullValue());
    }
}
