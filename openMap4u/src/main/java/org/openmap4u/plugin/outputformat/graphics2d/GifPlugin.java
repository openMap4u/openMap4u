/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.outputformat.graphics2d;

import org.openmap4u.commons.Util;

/**
 * The GIF output format implementation.
 * 
 * @author Michael Hadrbolec
 */
public final class GifPlugin extends AbstractJava2dPlugin {

    /**
     * Creates a new GifPlugin instance.
     */
    public GifPlugin() {
        super(Util.get().getMimeType("image", "gif"));
    }
}
