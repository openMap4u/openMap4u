/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.unit;

/**
 * Enumeration containing all valid SI prefixes.
 * 
 * @author Michael Hadrbolec.
 */
public enum SIPrefix {

    /**
     *
     */
    YOTTA("Y", "yotta", 24),

    /**
     *
     */
    ZETTA("Z", "zetta", 21),

    /**
     *
     */
    EXA("E", "exa", 18),

    /**
     *
     */
    PETA(
            "P", "peta", 15),

    /**
     *
     */
    TERRA("T", "tera", 12),

    /**
     *
     */
    GIGA("G", "giga", 9),

    /**
     *
     */
    MEGA(
            "M", "mega", 6),

    /**
     *
     */
    KILO("k", "kilo", 3),

    /**
     *
     */
    HECTO("h", "hecto", 2),

    /**
     *
     */
    DECA(
            "da", "deca", 1),

    /**
     *
     */
    DECI("d", "deci", -1),

    /**
     *
     */
    CENTI("c", "centi", -2),

    /**
     *
     */
    MILLI(
            "m", "milli", -3),

    /**
     *
     */
    MICRO("µ", "micro", -6),

    /**
     *
     */
    NANO("n", "nano", -9),

    /**
     *
     */
    PICO(
            "p", "pico", -12),

    /**
     *
     */
    FEMTO("f", "femto", -15),

    /**
     *
     */
    ATTO("a", "atto", -18),

    /**
     *
     */
    ZEPTO(
            "z", "zepto", -21),

    /**
     *
     */
    YOCTO("y", "yocto", -24),

    /**
     *
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
