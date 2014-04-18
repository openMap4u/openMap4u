/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.openmap4u.builder.Buildable;
import org.openmap4u.commons.Length;
import org.openmap4u.format.Outputable;
import org.openmap4u.plugin.builder.symbol.Rectangle;
import org.openmap4u.plugin.format.graphics2d.Png;
import org.openmap4u.plugin.format.svg.Svg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Michael Hadrbolec
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-test.xml")
public abstract class AbstractOpenMap4uTest {

    private static final String TARGET = "target";
    private static final String OUTPUT = "output";

    @Autowired
    private OpenMap4u defaultOpenMap4u = new OpenMap4u();

    @Autowired
    private OpenMap4u overriddenOpenMap4u = new OpenMap4u();

    /**
     *
     * @return
     */
    public List<OutputFormat> getOutputFormats() {
        List<OutputFormat> outputFormats = new ArrayList<>();
        outputFormats.add(new OutputFormat(Png.class, "png"));
        outputFormats.add(new OutputFormat(Svg.class, "svg"));
        return outputFormats;
    }

    /**
     *
     * @return
     */
    public OpenMap4u getDefaultOpenMap4u() {
        return this.defaultOpenMap4u;
    }

    /**
     *
     * @param worldUnits
     * @param drawingUnits
     * @param strokeUnits
     * @param outputFromat
     * @param width
     * @param height
     * @return
     */
    public OverrideDrawOrWriteable getCanvas(Length worldUnits,
            Length drawingUnits, Length strokeUnits,
            Class<? extends Outputable> outputFromat, double width,
            double height) {
        defaultOpenMap4u.getDefaults().setWorldUnits(worldUnits);
        defaultOpenMap4u.getDefaults().setDrawingUnits(drawingUnits);
        defaultOpenMap4u.getDefaults().setStrokeUnits(strokeUnits);
        return defaultOpenMap4u.getCanvas(width, height).outputFormat(outputFromat);
    }

    /**
     *
     * @return
     */
    public OpenMap4u getOverriddenOpenMap4u() {
        return this.overriddenOpenMap4u;
    }

    /**
     *
     * @param filename
     * @param ouputFormat
     * @return
     */
    protected final Path getPath(String filename, OutputFormat ouputFormat) {
        List<String> path = new ArrayList<>();
        path.add("target");
        path.add("ouputFormat");
        for (Package javaPackage : this.getClass().getPackage().getPackages()) {
            path.add(javaPackage.toString());
        }
        path.add(filename);
        Paths.get("src", path.toArray(new String[path.size()]));
        return null;
    }

    /**
     * Gets a path based on a list of Strings in the "target/output" section of
     * the maven layout.
     *
     * @param entries The path entries.
     * @return The path.
     */
    final static Path getPath(List<String> entries) {
        entries.add(0, "test-classes");

        String[] entr = entries.toArray(new String[entries.size()]);
        return FileSystems.getDefault().getPath(TARGET, entr);
    }

    /**
     *
     * @param entries
     * @return
     * @throws IOException
     */
    protected final static Path getPath(String... entries) throws IOException {
        List<String> pathEntries = new ArrayList();
        for (String entry : entries) {
            pathEntries.add(entry);
        }
        Path path = getPath(pathEntries);
        /* in the case the directory does not exist create it */
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        return path;
    }

    /**
     *
     * @param filename
     * @return
     */
    protected final Path getPackagePath(String filename) {

        List<String> pathEntries = new ArrayList();
        String[] packageEntries = this.getClass().getPackage().getName().split("\\.");
        for (String entry : packageEntries) {
            pathEntries.add(entry);
        }
        pathEntries.add(filename);
        return getPath(pathEntries);
    }

    /**
     * Creates a quadratic point marker.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param strokeColor The stroke color.
     * @param fillColor The fill color.
     * @return The quadratic point marker.
     */
    protected Rectangle getPointMarker(double x, double y, Paint strokeColor, Paint fillColor) {
        return this.getDefaultOpenMap4u().get(Rectangle.class).color(strokeColor).fill(fillColor).size(.25).width(.125).point(x, y);
    }

    /**
     * Gets a random color.
     *
     * @return A random color (based on random RGB values).
     */
    protected final Color getColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }

    /**
     * Gets the canvas with the given width and height.
     *
     * @param width The width of the canvas.
     * @param height The height of the canvas.
     * @return The canvas.
     */
    protected final OverrideDrawOrWriteable getCanvas(double width, double height) {
        return this.getDefaultOpenMap4u().getCanvas(width, height);
    }

    /**
     * Gets the canvas with the given width and height.
     *
     * @param width The width of the canvas.
     * @param height The height of the canvas.
     * @param fileName
     * @param primitives2Draw
     * @throws java.io.IOException
     */
    protected final void drawOnCanvas(double width, double height, String fileName, Buildable... primitives2Draw) throws IOException {
        OverrideDrawOrWriteable canvas = getCanvas(width, height);
        for (Buildable primitive2Draw : primitives2Draw) {
            canvas.draw(primitive2Draw);
        }
        canvas.write(getPackagePath(fileName));
    }

}
