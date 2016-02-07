package org.openmap4u.common;

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
 * Represents the supported SI units.
 * 
 * @author Michael Hadrbolec
 * 
 */
public enum Length implements Convertable<Length> {

    /**
     * Kilometer
     */
    KM(1000.0),
    /**
     * Meter
     */
    M(1d),
    /**
     * Centimeter
     */
    CM(0.01),
    /**
     * Milimeter
     */
    MM(0.001),

    /**
     * Inch
     */
    INCH(0.0254),

    /**
     * Pixel
     */
    PIXEL_96DPI(Length.INCH2M_FACTOR / 96),

    /**
     * Point (= point is the smallest whole unit of measure in typography). It is used for font measuring.
     */
    POINT(0.00035278);
    
    
    /**
     * Stores the multiplication factor to convert the given unit into SI m
     * units.
     */
    private double mFactor2M = 1;
    
    private static final  double INCH2M_FACTOR = 0.0254;

 
 
	public static final Length DEFEAULT_DRAWING_UNIT = Length.CM;
	public static final Length DEFEAULT_STROKE_UNIT = Length.MM;
	public static final Length DEFEAULT_WORLD_UNIT= Length.M;
	public static final Length DEFEAULT_PIXEL= Length.PIXEL_96DPI;



    private Length(double mFactor2M) {
        this.mFactor2M = mFactor2M;
    }

    /**
     * Converts the value from the given units into SI m units.
     * 
     * @param value2convert
     *            The value toconvert.
     * @return The converted value in SI m units.
     */
    @Override
    public final double convert(double value2convert) {
        return mFactor2M * value2convert;
    }

    /**
     * Converts the given value from this SI m into units.
     * 
     * @param value2convert
     *            The value to convert.
     * @return The convertet value in units.
     */
    @Override
    public final double convertFromSI(double value2convert) {
        return value2convert / this.mFactor2M;
    }

    /**
     * Converts a value into the given units.
     * 
     * @param value2convert
     *            The value to convert.
     * @param targetUnit
     *            The units into which the value will be converted.
     * @return The converted value.
     */
    @Override
    public final double convert(double value2convert, Length targetUnit) {
        return targetUnit.convertFromSI(convert(value2convert));
    }
}
