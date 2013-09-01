/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.outputformat.graphics2d;


/**
 *
 * @author Michael Hadrbolec
 */
public class PngPluginTest extends AbstractOutputFormatTest {
    
     @Override
    protected Class<PngPlugin> getOutputFormat() {
        return PngPlugin.class;
    }

    @Override
    protected String getFileExtension() {
        return "png";
    }
}