/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.format.graphics2d;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

import org.junit.Test;
import org.openmap4u.commons.Length;
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
    
    
    @Test
    public void testGetCanvasSize() {
    	AbstractJava2dPlugin aj2dp = new  Png()  ;
    	Dimension canvasSize = aj2dp.getCanvasSize(new Rectangle2D.Double(10,20,1.5,.5),Length.CM);
    	assertThat("Check width",canvasSize.getWidth(),is(56d));
    	assertThat("Check height",canvasSize.getHeight(),is(18d));
    }
}