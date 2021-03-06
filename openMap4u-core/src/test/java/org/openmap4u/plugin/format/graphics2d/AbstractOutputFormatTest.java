/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.format.graphics2d;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.openmap4u.commons.Length;
import org.openmap4u.format.OutputableFormatTest;

/**
 *
 * @author Michael Hadrbolec
 */
public abstract class AbstractOutputFormatTest extends OutputableFormatTest {

    /**
     *
     * @param imageFile
     * @return
     * @throws IOException
     */
    protected final BufferedImage read(File imageFile) throws IOException {
        BufferedImage image = ImageIO.read(imageFile);
        return image;
    }

    /**
     *
     */
    @Test
    public void testDrawSimpleSymbols() {
    }
    
    
   
}
