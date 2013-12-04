/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.format;

import org.openmap4u.format.Outputable;
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

    protected final SetAreaOfInterestOrDrawOrWrite getDraw(Class<? extends Outputable> outputableFormat) throws IOException {
        return this.getDefaultOpenMap4u().getCanvas().outputFormat(outputableFormat).drawingUnits(Length.CM).worldUnits(Length.CM).size(2, 2);
    }

    Circle getCircle() {
        return this.getDefaultOpenMap4u().getBuilder(Circle.class).diameter(1).point(1, 1);
    }

  

   

    /**
     * Gets the class of the output format plugin.
     *
     * @param <>> The type of the output format plugin.
     * @return The output format plugin class.
     */
    protected abstract <T extends Outputable> Class<T> getOutputFormat();

    /**
     * Gets the file extension.
     *
     * @return The file extension.
     */
    protected abstract String getFileExtension();
}