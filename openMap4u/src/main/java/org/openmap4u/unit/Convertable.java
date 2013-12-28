/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.unit;

/**
 * All unit enumerations are derived from this base interface.
 * 
 * @author Michael Hadrbolec
 * @param <T> The convertable type.
 */
public interface Convertable<T extends Convertable> {

    /**
     * Converts the given value into SI units.
     * 
     * @param value2Convert
     *            The value to convert.
     * @return The converted value in SI units.
     */
    double convert(double value2Convert);

    /**
     * Converts the given value from SI units into the provided unit.
     * 
     * @param value2Convert
     *            The value to convert.
     * @return The converted value in units.
     */
    double convertFromSI(double value2Convert);

    /**
     * Converts the given value into to target units.
     * 
     * @param value2Convert
     *            The value to convert.
     * @param targetUnit
     *            The target units.
     * @return The converted value.
     */
    double convert(double value2Convert, T targetUnit);

}
