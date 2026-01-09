package org.openmap4u.commons;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Utility class for handling fonts.
 */
public final class FontUtil {

    private FontUtil() {
        // Utility class
    }

    /**
     * Loads a font from the given URI.
     *
     * @param uri The URI of the font file.
     * @return The loaded Font.
     * @throws IOException If the font cannot be read.
     * @throws FontFormatException If the font format is invalid.
     */
    public static Font loadFont(URI uri) throws IOException, FontFormatException {
        try (InputStream inputStream = uri.toURL().openStream()) {
            return Font.createFont(Font.TRUETYPE_FONT, inputStream);
        }
    }

    /**
     * Gets the font metrics for the given font.
     *
     * @param font The font.
     * @return The FontMetrics.
     */
    public static FontMetrics getFontMetrics(Font font) {
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        g2d.dispose();
        return fm;
    }
}
