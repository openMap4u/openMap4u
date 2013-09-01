/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.outputformat.graphics2d;

import org.openmap4u.commons.Util;

/**
 * The JPEG output format implementation.
 * 
 * @author Michael Hadrbolec
 */
public final class JpgPlugin extends AbstractJava2dPlugin {

    /**
     * The unique name of the JpgPlugin.
     */
    public static final String PLUGIN_NAME = "JpgPlugin";

    /**
     * Creates a new JpgPlugin instance.
     */
    public JpgPlugin() {
        super(Util.get().getMimeType("image", "jpg"));
    }
}
