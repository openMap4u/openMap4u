/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.format.graphics2d;

import org.openmap4u.plugin.format.graphics2d.Gif;


/**
 *
 * @author Michael Hadrbolec
 */
public class GifTest extends AbstractOutputFormatTest {

  

    @Override
    protected Class<Gif> getOutputFormat() {
        return Gif.class;
    }

    @Override
    protected String getFileExtension() {
        return "gif";
    }
}