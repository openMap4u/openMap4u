/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.outputformat;

import java.io.IOException;

import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWrite;
import org.openmap4u.plugin.builder.symbol.Circle;
import org.openmap4u.unit.Length;

/**
 *
 * @author Michael Hadrbolec
 */
public abstract class OutputableFormatTest extends AbstractOpenMap4uTest {

    protected final SetAreaOfInterestOrDrawOrWrite getDraw(Class<? extends OutputableFormat> outputableFormat) throws IOException {
        return this.getDefaultOpenMap4u().getCanvas().setOutputFormat(outputableFormat).setDrawingUnits(Length.CM).setWorldUnits(Length.CM).setSize(2, 2);
    }

    Circle getCircle() {
        return this.getDefaultOpenMap4u().getBuilder().getCustomBuilder(Circle.class).setDiameter(1).setPoint(1, 1);
    }

  

   

    /**
     * Gets the class of the output format plugin.
     *
     * @param <T> The type of the output format plugin.
     * @return The output format plugin class.
     */
    protected abstract <T extends OutputableFormat> Class<T> getOutputFormat();

    /**
     * Gets the file extension.
     *
     * @return The file extension.
     */
    protected abstract String getFileExtension();
}