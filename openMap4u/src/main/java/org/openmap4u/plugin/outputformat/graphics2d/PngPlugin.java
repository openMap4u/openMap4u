/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.outputformat.graphics2d;

import org.openmap4u.commons.Util;

/**
 * The PNG output format implementation.
 * 
 * @author Michael Hadrbolec
 */
public final class PngPlugin extends AbstractJava2dPlugin {

    /**
     * Creates a new PngPlugin instance.
     */
    public PngPlugin() {
        super(Util.get().getMimeType("image", "png"));

    }
}
