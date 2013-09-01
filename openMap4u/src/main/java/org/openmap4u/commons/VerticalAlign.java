package org.openmap4u.commons;

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
 * The alignment in y axis direction (=vertical). <img
 * src="doc-files/VerticalAlign-1.png"/>
 * 
 * @author Michael Hadrbolec.
 * 
 */
public enum VerticalAlign implements Align {
    /**
     * y (= vertical) alignment on the top position.<br/>
     * <img src="doc-files/VerticalAlign_top.png"/>
     */
    TOP,
    /**
     * y (= vertical) alignment on the middle position.<br/>
     * <img src="doc-files/VerticalAlign_middle.png"/>
     */
    MIDDLE,
    /**
     * y (= vertical) alignment on the bottom position.<br/>
     * <img src="doc-files/VerticalAlign_bottom.png"/>
     */
    BOTTOM,
    /**
     * No y(=vertical) alignment at all (= default value which means it is drawn
     * as it is).
     */
    NONE;
}
