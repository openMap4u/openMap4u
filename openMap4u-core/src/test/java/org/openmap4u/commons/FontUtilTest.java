package org.openmap4u.commons;

import org.junit.jupiter.api.Test;
import java.awt.Font;
import java.awt.FontMetrics;
import java.net.URI;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class FontUtilTest {

    @Test
    public void testLoadFont() throws Exception {
        URI fontUri = Paths.get("src/test/resources/fonts/DejaVuSans.ttf").toUri();
        Font font = FontUtil.loadFont(fontUri);
        assertNotNull(font);
        assertEquals("DejaVu Sans", font.getFamily());
    }

    @Test
    public void testGetFontMetrics() throws Exception {
        URI fontUri = Paths.get("src/test/resources/fonts/DejaVuSans.ttf").toUri();
        Font font = FontUtil.loadFont(fontUri);
        Font sizedFont = font.deriveFont(12f);

        FontMetrics fm = FontUtil.getFontMetrics(sizedFont);
        assertNotNull(fm);
        assertTrue(fm.getHeight() > 0);
        assertEquals(sizedFont, fm.getFont());
    }
}
