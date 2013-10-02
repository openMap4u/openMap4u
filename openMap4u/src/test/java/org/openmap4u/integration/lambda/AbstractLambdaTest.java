/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.integration.lambda;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.stream.Stream;
import org.junit.Test;
import org.openmap4u.OpenMap4u;
import org.openmap4u.canvas.DrawOrWrite;

/**
 *
 * @author zwotti
 */
public class AbstractLambdaTest {

    Stream<Double> getData() {
        return Stream.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d);
    }

    @Test
    public void testSimpleLambda() throws IOException { 
        /* 1. get an instance */
        OpenMap4u oM4u = new OpenMap4u();
        /* 2. get an canvas on which you want to draw */
        DrawOrWrite draw = oM4u.getCanvas().size(10, 8);
        /* 3. draw your primitive(s). Yes your can repeat this multiple times */
        getData().map(value -> oM4u.getBuilder().getShape().moveTo(value + 3, value - 1).lineTo(value-2,value+2)).forEach(primitive -> draw.draw(primitive));
        /* persist your result */
        draw.write(FileSystems.getDefault().getPath("temp", "myTemp.png")); 
    }
}
