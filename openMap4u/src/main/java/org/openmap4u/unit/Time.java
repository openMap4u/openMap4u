/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.unit;

/**
 * 
 * @author zwotti
 */
public enum Time implements Convertable<Time> {

    /**
     * second
     */
     SECOND,

    /**
     * minute
     */
     MINUTE,

    /**
     * hour
     */
     HOUR,

    /**
     * day
     */
    DAY,

    /**
     * week
     */
     WEEK,

    /**
     * year
     */
    YEAR;
    private String mName = null;
    private String mSymbol = null;

    @Override
    public double convert(double value2Convert, Time unitToConvertInto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double convertFromSI(double value2Convert) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double convert(double value2Convert) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
