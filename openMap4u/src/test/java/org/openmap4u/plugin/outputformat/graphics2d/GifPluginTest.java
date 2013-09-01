/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.outputformat.graphics2d;


/**
 *
 * @author Michael Hadrbolec
 */
public class GifPluginTest extends AbstractOutputFormatTest {

  

    @Override
    protected Class<GifPlugin> getOutputFormat() {
        return GifPlugin.class;
    }

    @Override
    protected String getFileExtension() {
        return "gif";
    }
}