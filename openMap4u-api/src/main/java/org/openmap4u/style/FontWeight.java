package org.openmap4u.style;


/**
 * Enumeration, that contains the font weight values.
 *
 * @author Michael Hadrbolec.
 *
 */
public enum FontWeight {

    /**
     * Defines normal characters (This is default).
     */
    NORMAL,
    /**
     * Defines thick characters.
     */
    BOLD,
    /**
     * Defines thicker characters.
     */
    BOLDER,
    /**
     * Defines lighter characters
     */
    LIGHTER;
    
    /**
     * Default fontWeight.
     */
    public static final FontWeight DEFAULT = NORMAL;

}
