/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.format.graphics2d;

import org.openmap4u.commons.Util;

/**
 * The GIF output format implementation.
 * 
 * @author Michael Hadrbolec
 */
public final class Gif extends AbstractJava2dPlugin {

    /**
     * Creates a new GifPlugin instance.
     */
    public Gif() {
        super(Util.get().getMimeType("image", "gif"));
    }
}
