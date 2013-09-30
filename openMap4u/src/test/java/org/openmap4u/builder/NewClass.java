/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import com.google.common.primitives.Doubles;
import java.util.stream.Stream;
import org.openmap4u.OpenMap4u;
import org.openmap4u.canvas.Canvas;
import org.openmap4u.canvas.Draw;
import org.openmap4u.canvas.SetAreaOfInterestOrDraw;

/**
 *
 * @author zwotti
 */
public class NewClass {

    public void main(String args[]) {
        OpenMap4u om4u = new OpenMap4u();
        Draw draw = om4u.getCanvas().setSize(10, 8);
        Stream<Double> dbls = Doubles.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream();
        draw.setDraw(dbls.map(e -> om4u.getBuilder().getShape().setMoveTo(e, e + 1))).write(null);
    }

}
