/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.outputformat.graphics2d;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.openmap4u.outputformat.OutputableFormatTest;

/**
 *
 * @author Michael Hadrbolec
 */
public abstract class AbstractOutputFormatTest extends OutputableFormatTest {

  
    protected final BufferedImage read(File imageFile) throws IOException {
        BufferedImage image = ImageIO.read(imageFile);
        return image;
    }
    
  
    @Test
    public void testDrawSimpleSymbols() {
    }
    
}
