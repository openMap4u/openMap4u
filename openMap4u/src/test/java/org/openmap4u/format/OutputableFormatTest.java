/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.format;

import org.openmap4u.format.Outputable;
import java.io.IOException;

import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OverrideDrawOrWriteable;
import org.openmap4u.plugin.builder.symbol.Circle;
import org.openmap4u.commons.Length;

/**
 *
 * @author Michael Hadrbolec
 */
public abstract class OutputableFormatTest extends AbstractOpenMap4uTest {

    /**
     *
     * @param outputableFormat
     * @return
     * @throws IOException
     */
    protected final OverrideDrawOrWriteable getDraw(Class<? extends Outputable> outputableFormat) throws IOException {
        this.getDefaultOpenMap4u().getDefaults().setWorldUnits(Length.CM);
        this.getDefaultOpenMap4u().getDefaults().setDrawingUnits(Length.CM);
        
        return this.getDefaultOpenMap4u().getCanvas(3,4).outputFormat(outputableFormat);
    }

    Circle getCircle() {
        return this.getDefaultOpenMap4u().create(Circle.class).diameter(1).point(1, 1);
    }

  

   

    /**
     * Gets the class of the output format plugin.
     *
     * @param <T>
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