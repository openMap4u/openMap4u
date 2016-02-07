package org.openmap4u.common;

/**
 * Angular unit.
 * @author Michael Hadrbolec
 */
public enum Angle implements Convertable<Angle> {
	

    /**
     * Deegree
     */
    DEGREE(Math.toRadians(1)),

    /**
     * Radiant (0 = 0 degrees, 2PI = 360 degrees).
     */
    RADIANT(1);
    
     
    /* stores the conversion factor */
    private final double mConversionFactor2SI;

    Angle(double conversionFactor2SI) {
        this.mConversionFactor2SI = conversionFactor2SI;
    }

    @Override
    public double convert(double value2Convert) {
        return this.mConversionFactor2SI * value2Convert;
    }

    @Override
    public double convertFromSI(double value2Convert) {
        return value2Convert / this.mConversionFactor2SI;
    }

    @Override
    public double convert(double value2Convert, Angle targetUnit) {
        return targetUnit.convertFromSI(convert(value2Convert));
    }
    
	public static final Angle DEFAULT = DEGREE;

}
