/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import java.awt.Color;
import java.io.IOException;
import org.junit.Test;
import org.openmap4u.commons.Angle;
import static org.openmap4u.commons.HorizontalAlign.RIGHT;
import static org.openmap4u.commons.VerticalAlign.TOP;
import org.openmap4u.plugin.builder.chart.PieChart;
import org.openmap4u.plugin.builder.core.Line;
import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.plugin.builder.core.Text;
import org.openmap4u.plugin.builder.symbol.Cross;

/**
 *
 * @author hadrbolec
 */
public class AreaOfInterestTest extends AbstractOpenMap4uTest {

    @Test
    public void testDefault() throws IOException {
        OpenMap4u m4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = m4u.getCanvas(3, 2);
        /* Draw the bars */
        canvas.draw(getPolygon(m4u));
        canvas.draw(getPointMarker(1.5, 1, Color.BLUE, Color.GRAY));

        /* persist your result */
        canvas.write(this.getPackagePath("areaOfInterestInitial.png"));
    }

    @Test
    public void testCenter() throws IOException {
        OpenMap4u m4u = new OpenMap4u();
        m4u.getDefaults().setAngleUnits(Angle.DEGREE);

        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = m4u.getCanvas(3, 2).center(1, 0.75);
        /* Draw the bars */
        canvas.draw(getPolygon(m4u));
        canvas.draw(m4u.get(Line.class).line(1, 0.75, 1.5, 1).color(Color.DARK_GRAY) );

        canvas.draw(getPointMarker(1.5, 1, Color.BLUE, Color.WHITE));
        canvas.draw(getPointMarker(1, 0.75, Color.RED, Color.WHITE));
        canvas.draw(m4u.get(Cross.class).center(1, 0.75).color(Color.RED).scale(3).size(.18));

        /* persist your result */
        canvas.write(this.getPackagePath("areaOfInterestCenter.png"));
    }

    @Test
    public void testScale() throws IOException {
        OpenMap4u m4u = new OpenMap4u();
        /* 2. get an canvas and specify the size which you want to draw */
         DrawOrWriteable canvas = m4u.getCanvas(3, 2).scale(0.75) ;
        /* Draw the bars */
        canvas.draw(getPolygon(m4u));
        canvas.draw(getPointMarker(2, 1.33333333, Color.BLUE, Color.GRAY));
           canvas.draw(getPointMarker(1.5, 1, Color.RED, Color.WHITE));
  
        /* persist your result */
        canvas.write(this.getPackagePath("areaOfInterestScale.png"));
    }

    @Test
    public void testRotate() throws IOException {
        OpenMap4u m4u = new OpenMap4u();
        m4u.getDefaults().setAngleUnits(Angle.DEGREE);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = m4u.getCanvas(3, 2).rotate(30);
        /* Draw the bars */
        canvas.draw(getPolygon(m4u));
        canvas.draw(m4u.get(Cross.class).center(1.5, 1).color(Color.RED).scale(3).size(.18));
       canvas.draw(getPointMarker(1.5, 1, Color.RED, Color.WHITE));
        canvas.draw(getAnglePie(-30, m4u).center(1.5,1));
        /* persist your result */
        canvas.write(this.getPackagePath("areaOfInterestRotate.png"));
    }

    @Test
    public void testCenterScaleRotate() throws IOException {
        OpenMap4u m4u = new OpenMap4u();
        m4u.getDefaults().setAngleUnits(Angle.DEGREE);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = m4u.getCanvas(3, 2).center(1, 0.75).scale(.75).rotate(30);
        /* Draw the bars */
        canvas.draw(getPolygon(m4u));
        /* persist your result */
           canvas.draw(m4u.get(Line.class).line(1, 0.75, 1.5, 1).color(Color.DARK_GRAY) );

        canvas.draw(getPointMarker(1.5, 1, Color.BLUE, Color.GRAY));
        canvas.draw(getPointMarker(1, 0.75, Color.RED, Color.GRAY));
           canvas.draw(m4u.get(Cross.class).center(1, 0.75).color(Color.RED).scale(3).size(.18));
   canvas.draw(getAnglePie(-30, m4u).center(1,0.75));
     
        canvas.write(this.getPackagePath("areaOfInterestCenterScaleRotate.png"));
    }
    
     @Test
    public void testCenterScale() throws IOException {
        OpenMap4u m4u = new OpenMap4u();
        m4u.getDefaults().setAngleUnits(Angle.DEGREE);
        /* 2. get an canvas and specify the size which you want to draw */
        DrawOrWriteable canvas = m4u.getCanvas(3, 2).center(1, 0.75).scale(.75);
        /* Draw the bars */
        canvas.draw(getPolygon(m4u));
        /* persist your result */
           canvas.draw(m4u.get(Line.class).line(1, 0.75, 1.5, 1).color(Color.DARK_GRAY) );

        canvas.draw(getPointMarker(1.5, 1, Color.BLUE, Color.GRAY));
        canvas.draw(getPointMarker(1, 0.75, Color.RED, Color.GRAY));
           canvas.draw(m4u.get(Cross.class).center(1, 0.75).color(Color.RED).scale(3).size(.18));
      
        canvas.write(this.getPackagePath("areaOfInterestCenterScale.png"));
    }

    /**
     * Gets the polygon.
     *
     * @param om4u
     * @return
     */
    Polygon getPolygon(OpenMap4u om4u) {
        return om4u.get(Polygon.class).moveTo(0.5, 0.5).lineTo(0.5, 1.5).lineTo(2.5, 1.5).lineTo(2.5, 0.5).lineTo(0.5, 0.5).moveTo(.5, 1).lineTo(2.5, 1).moveTo(1.5, 1.5).lineTo(1.5, .5).color(Color.LIGHT_GRAY);
    }
    
    PieChart getAnglePie(double angle,  OpenMap4u om4u) {
        return om4u.get(PieChart.class).color(Color.GRAY).fill(Color.RED).radius(.85).size(.35).transparence(50).add(angle) ;
    }

}
