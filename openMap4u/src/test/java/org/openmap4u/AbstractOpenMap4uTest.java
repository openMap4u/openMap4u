/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import java.awt.*;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWrite;
import org.openmap4u.format.Outputable;
import org.openmap4u.plugin.builder.symbol.Rectangle;
import org.openmap4u.plugin.format.graphics2d.Png;
import org.openmap4u.plugin.format.svg.Svg;
import org.openmap4u.unit.Length;
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

    public List<OutputFormat> getOutputFormats() {
        List<OutputFormat> outputFormats = new ArrayList<>();
        outputFormats.add(new OutputFormat(Png.class, "png"));
        outputFormats.add(new OutputFormat(Svg.class, "svg"));
        return outputFormats;
    }

    public OpenMap4u getDefaultOpenMap4u() {
        return this.defaultOpenMap4u;
    }
    
   

    public SetAreaOfInterestOrDrawOrWrite getCanvas(Length worldUnits,
            Length drawingUnits, Length strokeUnits,
            Class<? extends Outputable> outputFromat, double width,
            double height) {
        return defaultOpenMap4u.getCanvas().worldUnits(worldUnits)
                .drawingUnits(drawingUnits).strokeUnits(strokeUnits)
                .outputFormat(outputFromat).size(width, height);
    }

    public OpenMap4u getOverriddenOpenMap4u() {
        return this.overriddenOpenMap4u;
    }

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
        return this.getDefaultOpenMap4u().getBuilder(Rectangle.class).color(strokeColor).fill(fillColor).size(.25).width(.125).point(x, y);
    }

    /**
     * Gets a random color.
     *
     * @return A random color (based on random RGB values).
     */
    protected final Color getColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }

}
