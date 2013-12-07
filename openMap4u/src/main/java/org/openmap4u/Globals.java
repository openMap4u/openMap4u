package org.openmap4u;

import java.awt.Color;
import java.awt.Paint;
import java.awt.geom.Point2D;

import org.openmap4u.canvas.Canvas;
import org.openmap4u.style.FontStyle;
import org.openmap4u.plugin.format.graphics2d.Png;
import org.openmap4u.unit.Angle;
import org.openmap4u.unit.Length;

/*
 * #%L
 * m4u the ultimative visulisation library
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

/**
 * Contains all global default values.
 * 
 * @author Michael Hadrbolec
 * 
 */
public interface Globals {
    
    double ZERO =0;
    
    public static Angle DEFAULT_ANGLE_UNIT = Angle.DEGREE;
    public static Point2D DEFAULT_VIEWPORT_CENTER= new Point2D.Double(ZERO,ZERO );

    /**
     * The dfeault drawing plugin name.
     */
    String DEFAULT_DRAWING_PLUGIN_NAME = Canvas.PLUGIN_NAME;

    /**
     * The default symbol size.
     */
    double DEFAULT_SYMBOL_SIZE = 1;

    /**
     * The default output format plugin.
     */
    Class<Png> DEFAULT_OUTPUTFORMAT_PLUGIN_NAME = Png.class;

    /**
     * The default builder plugin name.
     */
    String DEFAULT_BUILDER_PLUGIN_NAME = "";

    /**
     * The default font type.
     */
    String DEFAULT_FONT_TYPE = "";

    /**
     * The default font size.
     */
    double DEFAULT_FONT_SIZE = 5;

    /**
     * The default resource bundle (which is used for error and logging
     * messages).
     */
    String DEFAULT_RESSOURCE_BUNDLE = "org/openmap4u/resource/messages";

    /**
     * The default stroke unit is mm. 
       */
    Length DEFEAULT_STROKE_UNIT = Length.MM;

    /**
     * The default drawing unit is m. It is used
     * for drawing on the "virtual" paper.
     */
    Length DEFEAULT_DRAWING_UNIT = Length.CM;

    /**
     * The default world unit is m.
     */
    Length DEFEAULT_WORLD_UNIT = Length.CM;

    /**
     * The default font style.
     */
    FontStyle DEFAULT_FONT_STYLE = FontStyle.NORMAL;

    /**
     * The default alpha (= transparency) value.
     */
    double DEFAULT_ALPHA = 1;

    /**
     * The default stroke color.
     */
    Color DEFAULT_STROKE_COLOR = Color.BLACK;

    /**
     * The default fill (is null ... no fill).
     */
    Paint DEFAULT_FILL = null;


    /**
     * The default scale factor in x an y axis direction is <code>1</code>.
     */
    double DEFAULT_SCALE = 1;

    /**
     * The default offset in x and y axis direction is <code>0</code> (= no
     * offset).
     */
    double DEFAULT_OFFSET = 0;

    /**
     * The default rotation angle is <code>0</code> degrees (= no rotation at
     * all).
     */
    double DEFAULT_ROTATE = 0;

    /**
     * The default stroke size.
     */
    double DEFAULT_STROKE_SIZE = 0.5;

    /**
     * The default visibility of a primitive is <code>true</code>.
     */
    boolean DEFAULT_VISIBILITY = true;

    /**
     * The dfeault dpi resolution for raster images.
     */
    int DEFAULT_DPI = 96;
    
    /**
     * The default dot resolution.
     */
    int DEFAULT_DOTS = 72;
    
    /**
     * Conversion factor inch to cm.
     */
    double INCH2M_FACTOR = 0.0254;

}
