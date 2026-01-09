package org.openmap4u;

import java.awt.geom.Line2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.openmap4u.builder.TextOnPathBuilder;
import org.openmap4u.commons.Globals;

public class TextAlongLineTest {

    @Test
    public void testTextAlongLine() throws IOException {
        Path output = Paths.get("target/textAlongLine.png");
        Files.createDirectories(output.getParent());

        // Use default globals to avoid NPE
        Canvas canvas = new Canvas(Globals.DEFEAULT_WORLD_UNIT, Globals.DEFEAULT_DRAWING_UNIT, Globals.DEFEAULT_STROKE_UNIT, Globals.DEFAULT_ANGLE_UNIT);
        canvas.size(400, 400);

        TextOnPathBuilder builder = new TextOnPathBuilder();
        builder.text("Hello World Along A Line")
               .path(new Line2D.Double(50, 50, 350, 350))
               .size(20);

        canvas.draw(builder);

        canvas.write(output);
    }
}
