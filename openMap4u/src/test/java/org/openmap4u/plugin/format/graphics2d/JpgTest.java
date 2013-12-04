/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.format.graphics2d;

import org.openmap4u.plugin.format.graphics2d.Jpg;


/**
 *
 * @author Michael Hadrbolec
 */
public class JpgTest extends AbstractOutputFormatTest {
    
     @Override
    protected Class<Jpg> getOutputFormat() {
        return Jpg.class;
    }

    @Override
    protected String getFileExtension() {
        return "jpg";
    }
    
}