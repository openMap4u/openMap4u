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
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
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

import org.openmap4u.defaults.Globals;
import org.openmap4u.unit.Length;

/**
 * Commonly used helper methods which is needed multiple across the api.
 * 
 * @author Michael Hadrbolec
 */
public final class Util {

    /**
     * The logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Util.class.getName(),
            Globals.DEFAULT_RESSOURCE_BUNDLE);

    private static final double FULL_CIRCLE = 360;
    private static final double ZERO = 360;

    /**
     * Stores the message properties.
     */
    private Properties properties = null;
    /**
     * Single utility instance.
     */
    private static Util mUtility = new Util();

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
                                    .append(".properties").toString()));
        } catch (IOException e) {
            LOGGER.severe(new StringBuilder(
                    "Unable to read the resource bundle. ")
                    .append(Globals.DEFAULT_RESSOURCE_BUNDLE)
                    .append(".properties").toString());
        }
    }

    /**
     * Gets the utility instance (singleton pattern).
     * 
     * @return The single utility instance.
     */
    public static Util get() {
        return mUtility;
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
     * Gets the global transformation.
     * 
     * @param width
     *            The width of the drawing canvas in drawing units.
     * @param height
     *            The height of the drawing canvas in drawing units.
     * @param globalTransformParams
     *            The
     * @param worldUnits
     *            The world units.
     * @param drawingUnits
     *            The drawing units.
     * @return The resulting global transformation.
     */
    public AffineTransform getGlobalTransform(double width, double height,
            TransformHelper globalTransformParams, Length worldUnits,
            Length drawingUnits) {
        /* perform the scalign */
        AffineTransform global = new AffineTransform(
                globalTransformParams.getScaleX(), 0, 0,
                globalTransformParams.getScaleX(), 0, 0);
        /* perform the translation */
        if (!Double.isNaN(globalTransformParams.getX())
                && !Double.isNaN(globalTransformParams.getY())) {
            global.translate(
                    -getGlobalTransformTranslate(globalTransformParams.getX(),
                            drawingUnits.convert(width, worldUnits),
                            globalTransformParams.getScaleX()),
                    -getGlobalTransformTranslate(globalTransformParams.getY(),
                            drawingUnits.convert(height, worldUnits),
                            globalTransformParams.getScaleY()));
        }
        /* perform the rotation */
        if (globalTransformParams.getRotate() != ZERO
                && globalTransformParams.getRotate() != FULL_CIRCLE) {
            double rotateCenterX = globalTransformParams.getX();
            double rotateCenterY = globalTransformParams.getY();
            if (Double.isNaN(rotateCenterX)) {
                rotateCenterX = 0;
            }
            if (Double.isNaN(rotateCenterY)) {
                rotateCenterY = 0;
            }
            global.rotate(Math.toRadians(globalTransformParams.getRotate()),
                    worldUnits.convert(rotateCenterX, drawingUnits),
                    worldUnits.convert(rotateCenterY, drawingUnits));

        }
        return global;
    }

    /**
     * Gets the translation of the global transformation (for internal use
     * only).
     * 
     * @param center
     *            The center coordinate in world units.
     * @param extent
     *            The extent in world units (e.g. the width or height).
     * @param scaleFactor
     *            The scaleFactor.
     * @return The translation.
     */
    double getGlobalTransformTranslate(double center, double extent,
            double scaleFactor) {
        return center - extent / 2d / scaleFactor;
    }

    /**
     * Gets the individual transform.
     * 
     * @param individualTransformParams
     *            The individual transformation parameter.
     * @return The resulting individual transformation.
     */
    public AffineTransform getIndividualTransform(
            TransformHelper individualTransformParams) {
        AffineTransform individual = new AffineTransform();
        if (!Double.isNaN(individualTransformParams.getX())) {
            individual.translate(individualTransformParams.getX(), 0);
        }
        if (!Double.isNaN(individualTransformParams.getY())) {
            individual.translate(0, individualTransformParams.getY());
        }
        if (!Double.isNaN(individualTransformParams.getRotate())) {
            individual.rotate(Math.toRadians(individualTransformParams
                    .getRotate()));
        }
        if (!Double.isNaN(individualTransformParams.getScaleX())
                && !Double.isNaN(individualTransformParams.getScaleY())) {
            individual.scale(individualTransformParams.getScaleX(),
                    individualTransformParams.getScaleY());
        }
        return individual;
    }

    /**
     * Gets the translation of the global transformation (for internal use
     * only).
     * 
     * @param center
     *            The center coordinate in world units.
     * @param extent
     *            The extent in drawing units (e.g. the width or height).
     * @param scaleFactor
     *            The scaleFactor.
     * @return The translation.
     */
    double getTranslate(double center, double extent, double scaleFactor) {
        return center - extent / 2d / scaleFactor;
    }

    /**
     *
     * @param horizontalAlign
     * @param verticalAlign
     * @param shape2Align
     * @return
     */
    public AffineTransform getAlignTransform(HorizontalAlign horizontalAlign,
            VerticalAlign verticalAlign, Shape shape2Align) {
        double dx = getDeltaHorizontalAlign(horizontalAlign, shape2Align);
        double dy = getDeltaVerticalAlign(verticalAlign, shape2Align);

        if (dx != 0 || dy != 0) {
            return new AffineTransform(1, 0, 0, 1, dx, dy);
        } else {
            return new AffineTransform(1, 0, 0, 1, 0, 0);
        }
    }

    double getDeltaHorizontalAlign(HorizontalAlign horizontalAlign,
            Shape shape2Align) {
        if (horizontalAlign == null) {
            return 0;
        } else {
            switch (horizontalAlign) {
            case LEFT:
                return -shape2Align.getBounds2D().getMinX();
            case CENTER:
                return -shape2Align.getBounds2D().getCenterX();
            case RIGHT:
                return -shape2Align.getBounds2D().getMaxX();
            default:
                return 0;
            }
        }
    }

    double getDeltaVerticalAlign(VerticalAlign verticalAlign, Shape shape2Align) {
        if (verticalAlign == null) {
            return 0;
        } else {

            switch (verticalAlign) {
            case TOP:
                return -shape2Align.getBounds2D().getMaxY();
            case MIDDLE:
                return -shape2Align.getBounds2D().getCenterY();
            case BOTTOM:
                return -shape2Align.getBounds2D().getMinY();
            default:
                return 0;
            }
        }
    }

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

    /**
     *
     * @param globalTransform
     * @param point
     * @param individualTransform
     * @return
     */
    public AffineTransform getTransform(AffineTransform globalTransform,
            Point2D.Double point, AffineTransform individualTransform) {
        /* first get teh global transformation */
        AffineTransform transform = (AffineTransform) globalTransform.clone();
        double scaleX = transform.getScaleX();
        double scaleY = transform.getScaleY();
        /* translate inf necessary */
        if (point != null) {
            transform.translate(point.x, point.y);
            /* compensate world units */
            individualTransform.preConcatenate(new AffineTransform(1 / scaleX,
                    0, 0, -1 / scaleY, 0, 0));
        }
        transform.concatenate(individualTransform);
        return transform;

    }

    /**
     *
     * @param globalTransform
     * @param point
     * @param individualTransform
     * @param horizontalAlign
     * @param verticalAlign
     * @param shape
     * @return
     */
    public AffineTransform getTransform(AffineTransform globalTransform,
            Point2D.Double point, AffineTransform individualTransform,
            HorizontalAlign horizontalAlign, VerticalAlign verticalAlign,
            Shape shape) {
        AffineTransform transform = getTransform(globalTransform, point,
                individualTransform);
        transform.concatenate(Util.get().getAlignTransform(horizontalAlign,
                verticalAlign, shape));
        return transform;
    }
}
