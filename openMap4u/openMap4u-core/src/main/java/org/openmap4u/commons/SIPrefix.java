/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

/**
 * Enumeration containing all valid SI prefixes.
 * 
 * @author Michael Hadrbolec.
 */
 enum SIPrefix {

    /**
     * yotta.
     */
    YOTTA("Y", "yotta", 24),

    /**
     * zetta
     */
    ZETTA("Z", "zetta", 21),

    /**
     * exa
     */
     EXA("E", "exa", 18),

    /**
     * peta
     */
    PETA(
            "P", "peta", 15),

    /**
     * terra
     */
    TERRA("T", "tera", 12),

    /**
     * giga
     */
    GIGA("G", "giga", 9),

    /**
     * mega
     */
    MEGA(
            "M", "mega", 6),

    /**
     * kilo
     */
    KILO("k", "kilo", 3),

    /**
     * hecto
     */
    HECTO("h", "hecto", 2),

    /**
     * deca
     */
    DECA(
            "da", "deca", 1),

    /**
     * deci
     */
     DECI("d", "deci", -1),

    /**
     * centi
     */
    CENTI("c", "centi", -2),

    /**
     * milli
     */
    MILLI(
            "m", "milli", -3),

    /**
     * micro
     */
     MICRO("µ", "micro", -6),

    /**
     * nao
     */
     NANO("n", "nano", -9),

    /**
     * pico
     */
     PICO(
            "p", "pico", -12),

    /**
     * femto
     */
     FEMTO("f", "femto", -15),

    /**
     * atto
     */
    ATTO("a", "atto", -18),

    /**
     * zepto
     */
     ZEPTO(
            "z", "zepto", -21),

    /**
     * yocto
     */
    YOCTO("y", "yocto", -24),

    /**
     * none
     */
     NONE("", "", 1);
  
    private static final double TEN = 10;
    private double mFactor;
    private String mPrefix;
    private String mSymbol;

    /**
     * INternal constructor for creating a SI prefix.
     * 
     * @param symbol
     *            The SI symbol.
     * @param prefix
     *            The SI prefix.
     * @param factor
     *            The SI factor(Math.pow(10, factor)).
     */
    private SIPrefix(String symbol, String prefix, double factor) {
        this.mSymbol = symbol;
        this.mPrefix = prefix;
        this.mFactor = Math.pow(TEN, factor);
    }

    /**
     * Gets the SI prefix multiplication factor.
     * 
     * @return Gets the SI prefix multiplication factor.
     */
    public double getMultiplicationFactor2SI() {
        return this.mFactor;
    }

    /**
     * Gets the SI prefix symbol.
     * 
     * @return The SI prefix symbol.
     */
    public String getSymbol() {
        return this.mSymbol;
    }

    /**
     * Gets the human readable SI Prefix.
     * 
     * @return The human readable SI prefix.
     */
    public String getPrefix() {
        return this.mPrefix;
    }

    /**
     * Parses the SI prefix (if any).
     * 
     * @param unit2parse
     *            The SI unit to parse.
     * @return The SI prefix.
     */
    public static SIPrefix parse(String unit2parse) {
        for (SIPrefix prefix : SIPrefix.values()) {
            /*
             * in the case the prefix symbol matches and the tola length is
             * grater than the prefix symbol length.
             */
            if (unit2parse.startsWith(prefix.getSymbol())
                    && unit2parse.length() > prefix.getSymbol().length()) {
                return prefix;
            }
        }
        return SIPrefix.NONE;
    }
}
