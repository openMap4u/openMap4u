/**
 * This file is part of openMap4u java 8 integration examples.
 *
 * openMap4u java 8 integration examples is free software: you can redistribute
 * it and/or modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * openMap4u java 8 integration examples is distributed in the hope that it will
 * be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with openMap4u java 8 integration examples. If not, see
 * <http://www.gnu.org/licenses/>.
 */
/**
 * This file is part of openMap4u Spatial Plugin.
 *
 * openMap4u Spatial Plugin is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * openMap4u Spatial Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with openMap4u Spatial Plugin. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.openmap4u.plugin.builder.spatial;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.OpenMap4u;
import org.openmap4u.commons.HorizontalAlign;
import static org.openmap4u.commons.HorizontalAlign.CENTER;
import org.openmap4u.commons.VerticalAlign;
import static org.openmap4u.commons.VerticalAlign.BOTTOM;
import static org.openmap4u.commons.VerticalAlign.TOP;
import org.openmap4u.data.Country;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.chart.BarChart;
import org.openmap4u.plugin.builder.chart.LineChart;
import org.openmap4u.plugin.builder.chart.PieChart;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.plugin.builder.core.Text;

/**
 *
 * @author Michael Hadrbolec
 */
public class MapTest extends AbstractOpenMap4uTest {

    @Test
    public void testSimpleMap() throws IOException {

        List<Country> data = MockupData.ITERABLE_COUNTRIES;

        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* optional override default styling (for the created instance) */
        oM4u.getDefaults().getShapeStyle().setAlpha(.5).setStrokeColor(Color.GRAY);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = oM4u.getCanvas(7, 7).scale(.5).center(14, 45);
        /* 3. draw your primitive(s). */
        data.stream().forEach(e -> canvas.draw(oM4u.get(Wkb.class).wkb(e.getGeomAsWkb()).color(Color.BLACK).size(.25).fill(Color.LIGHT_GRAY)));

        data.stream().forEach(e -> canvas.draw(oM4u.get(Text.class).center(e.getX(), e.getY()).color(Color.DARK_GRAY).align(HorizontalAlign.CENTER, VerticalAlign.MIDDLE).size(2.5).text(e.getName()).visible(e.getGeomAsJTS().getArea() > 8)));

        data.stream().forEach(e -> {
            for (int i = 0; i < 3; i++) {
                canvas.draw(oM4u.get(BarChart.class).width(.3).height(Math.random() * .5+.35).align(CENTER, BOTTOM).center(e.getX(), e.getY()).offset(-.6 + i * .4, .2).fill(Color.WHITE).color(Color.BLACK).visible(e.getGeomAsJTS().getArea() > 8).transparence(0));
            }
            PieChart pie = oM4u.get(PieChart.class).innerRadius(.1).outerRadius(0.35).start(0).center(e.getX(), e.getY()).offset(.9, .55).visible(e.getGeomAsJTS().getArea() > 8).transparence(0);
            for (int i = 0; i < 3; i++) {
               canvas.draw(pie.add(180*Math.random()).fill(Color.WHITE).color(Color.DARK_GRAY));
            }
            

            List<Double> values = MockupData.get().getRange(10);
            Polygon lc = oM4u.get(Polygon.class).color(Color.RED).size(1).visible(e.getGeomAsJTS().getArea() > 8).transparence(0);
            values.stream().forEach(v -> lc.lineTo(v / 10, Math.random() * .3 + .1));
            canvas.draw(lc.center(e.getX() - 1.5, e.getY()+.3));

        });

        /* persist your result */
        canvas.write(getPackagePath("simpleMap.png"));

    }

}
