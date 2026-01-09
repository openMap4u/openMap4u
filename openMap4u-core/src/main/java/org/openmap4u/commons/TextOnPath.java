package org.openmap4u.commons;

import java.awt.Shape;

/**
 * A primitive representing text drawn along a path (shape).
 */
public class TextOnPath {

    private final String text;
    private final Shape path;

    /**
     * Creates a new TextOnPath instance.
     *
     * @param text The text to draw.
     * @param path The path along which to draw the text.
     */
    public TextOnPath(String text, Shape path) {
        this.text = text;
        this.path = path;
    }

    /**
     * Gets the text.
     *
     * @return The text.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the path.
     *
     * @return The path.
     */
    public Shape getPath() {
        return path;
    }
}
