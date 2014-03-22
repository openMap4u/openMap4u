/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

/*
 * #%L
 * t4u-core
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2012 VillaBunterHund
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.imageio.ImageIO;


/**
 * Commonly used helper methods which is needed multiple across the api.
 * 
 * @author Michael Hadrbolec
 */
public final class Util {

    private static final String PROPERTIES=".properties"; 
    
    /**
     * The logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Util.class.getName(),
            Globals.DEFAULT_RESSOURCE_BUNDLE);

   
    /**
     * Stores the message properties.
     */
    private Properties properties = null;
    /**
     * Single utility instance.
     */
    private static final Util UTIL = new Util();

    /**
     * Singleton pattern constructor.
     */
    private Util() {
        properties = new Properties();
        try {
            properties.load(Thread
                    .currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(
                            new StringBuilder(Globals.DEFAULT_RESSOURCE_BUNDLE)
                                    .append(PROPERTIES).toString()));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,new StringBuilder(
                    "Unable to read the resource bundle. ")
                    .append(Globals.DEFAULT_RESSOURCE_BUNDLE)
                    .append(PROPERTIES).toString(),e);
        }
    }

    /**
     * Gets the utility instance (singleton pattern).
     * 
     * @return The single utility instance.
     */
    public static Util get() {
        return UTIL;
    }

    /**
     * Gets the message from the resource bundle with the incorporated provided
     * parameters.
     * 
     * @param property
     *            The resource bundle property.
     * @param params
     *            The parameters.
     * @return The for the property corresponding message from the resource
     *         bundle with the incorporated provided parameters.
     */
    public String getMessage(String property, Object... params) {
        return new MessageFormat(properties.getProperty(property))
                .format(params);
    }

    /**
     * Gets the message from the resource bundle without any properties.
     * 
     * @param property
     *            The property of the resource bundle.
     * @return The for the property corresponding message from the resource
     *         bundle.
     */
    public String getMessage(String property) {
        return properties.getProperty(property);
    }

    /**
     * Gets the plugin with the matching unique plugin name and the matching
     * plugin class, that has been registered in the META-INF/services Folder
     * under the fully qualified interface or class name.
     * 
     * @param <T>
     *            The data type of the plugin.
      * @param pluginClass
     *            The registered plugin class.
     * @return The matching plugin.
     * @throws java.lang.IllegalArgumentException
     *             Is thrown if no correspondending plugin is found.
     */
    public <T extends Plugable> T getPlugin(Class<T> pluginClass) {
        try {
            return pluginClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
    
    
   
    /**
     * Gets the mime type.
     * 
     * @param name
     *            The name.
     * @param subtype
     *            The subtype.
     * @return The mime type.
     */
    public MimeType getMimeType(String name, String subtype) {
        MimeType mimeType = new MimeType();
        try {
            mimeType = new MimeType(name, subtype);
        } catch (MimeTypeParseException e) {
            LOGGER.log(Level.WARNING, "", e);
        }

        return mimeType;
    }

    /**
     * Gets a buffered image from the given path.
     * 
     * @param path2Image
     *            The path to the image.
     * @return The image.
     * @throws IOException
     *             Is thrown in the case an error occurs.
     */
    public BufferedImage getImage(Path path2Image) throws IOException {
        return ImageIO.read(Files.newInputStream(path2Image));
    }

    /**
     * Gets the size of the image in pixel.
     * 
     * @param path2Image
     *            The path to the image.
     * @return The image.
     * @throws IOException
     *             Is thrown in the case an error occurs.
     */
    public Rectangle2D.Double getImageSize(Path path2Image) throws IOException {
        BufferedImage image = getImage(path2Image);
        return new Rectangle2D.Double(0, 0, image.getWidth(), image.getHeight());
    }

    
}
