/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.outputformat.graphics2d;


/**
 *
 * @author Michael Hadrbolec
 */
public class JpgPluginTest extends AbstractOutputFormatTest {
    
     @Override
    protected Class<JpgPlugin> getOutputFormat() {
        return JpgPlugin.class;
    }

    @Override
    protected String getFileExtension() {
        return "jpg";
    }
    
}