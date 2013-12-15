/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import com.google.common.collect.Lists;

import java.awt.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWrite;
import org.openmap4u.format.Outputable;
import org.openmap4u.plugin.builder.symbol.Rectangle;
import org.openmap4u.plugin.format.graphics2d.Png;
import org.openmap4u.plugin.format.svg.Svg;
import org.openmap4u.unit.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

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
        entries.add(0, OUTPUT);
          entries.add(0, TARGET);
      
        String[] entr = entries.toArray(new String[entries.size()]);
        return FileSystems.getDefault().getPath(".", entr);
    }

    protected final static Path getPath(String... entries) {
        return getPath(Lists.newArrayList(entries));
    }

    protected final Path getPackagePath(String filename) {
        ArrayList<String> entries = Lists.newArrayList(this.getClass().getPackage().getName().split("\\."));
        entries.add(filename);
         return getPath(entries);
    }


    /**
     * Creates a quadratic point marker.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param strokeColor The stroke color.
     * @param fillColor The fill color.
     * @return The quadratic point marker.
     */
    protected Rectangle getPointMarker(double x, double y,Paint strokeColor, Paint fillColor) {
        return this.getDefaultOpenMap4u().getBuilder(Rectangle.class).color(strokeColor).fill(fillColor).setSize(.25).point(x,y);
    }



}
