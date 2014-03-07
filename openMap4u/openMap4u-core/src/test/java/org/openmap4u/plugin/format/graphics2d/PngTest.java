/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.format.graphics2d;

import org.openmap4u.plugin.format.graphics2d.Png;


/**
 *
 * @author Michael Hadrbolec
 */
public class PngTest extends AbstractOutputFormatTest {
    
     @Override
    protected Class<Png> getOutputFormat() {
        return Png.class;
    }

    @Override
    protected String getFileExtension() {
        return "png";
    }
}