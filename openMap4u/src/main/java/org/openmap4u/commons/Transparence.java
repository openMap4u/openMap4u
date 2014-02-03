/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

import org.openmap4u.commons.Convertable;

/**
 * 
 * @author Michael Hadrbolec
 */
public enum Transparence implements Convertable<Transparence> {

    /* Specifies the opacity. From 0.0 (fully transparent) to 1.0 (fully opaque) */

    /**
     * opacity
     */
    OPACITY ,
    /*
     * Specifies the opacity. From 0.0 (completely transparent) to 1.0 (fully
     * opaque)
     */

    /**
     *alpha
     */
    ALPHA ,
    /*
     * Specifies the opacity. From 0.0 (fully opaque) to 100.0 (fully
     * transparent)
     */

    /**
     * percent
     */
    PERCENT  {
        @Override
        public double convert(double value2Convert) {
            if (value2Convert == 0) {
                return 1;
            } else {
                return 1 - value2Convert / HUNDRED;
            }
        }

        private static final double HUNDRED = 100;

        @Override
        public double convertFromSI(double value2Convert) {
            return (1 - value2Convert) * HUNDRED;
        }
    };
 
  

    @Override
    public double convert(double value2Convert) {
        return value2Convert;
    }

    @Override
    public double convertFromSI(double value2Convert) {
        return value2Convert;
    }

    @Override
    public double convert(double value2Convert, Transparence targetUnit) {
        return targetUnit.convertFromSI(convert(value2Convert));
    }
}
