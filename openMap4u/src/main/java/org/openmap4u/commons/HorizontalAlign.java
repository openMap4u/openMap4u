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
 * The alignment in x axis direction (=horizontal).<br>
 * <img src="doc-files/HorizontalAlign-1.png" alt="horizontal alignment">
 * 
 * @author Michael Hadrbolec.
 * 
 */

public enum HorizontalAlign implements Align {
    /**
     * x (= horizontal) alignment on the left position.<br>
     * <img src="doc-files/HorizontalAlign_left.png" alt="left">
     */
    LEFT,
    /**
     * x (= horizontal) alignment on the center position.<br>
     * <img src="doc-files/HorizontalAlign_center.png" alt="center">
     */
    CENTER,
    /**
     * x (= horizontal) alignment on the right position. <br>
     * <img src="doc-files/HorizontalAlign_right.png" alt="right">.
     */
    RIGHT,
    /**
     * No x (= horizontal) alignment (= default value which means it is drawn as
     * it is).
     */
    NONE;
}
