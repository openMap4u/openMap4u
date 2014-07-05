/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.format.graphics2d;

import org.openmap4u.commons.Util;

/**
 * The PNG output format implementation.
 * 
 * @author Michael Hadrbolec
 */
public final class Png extends AbstractJava2dPlugin {

    /**
     * Creates a new PngPlugin instance.
     */
    public Png() {
        super(Util.get().getMimeType("image", "png"));

    }
}
