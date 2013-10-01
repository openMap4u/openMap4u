/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.openmap4u.canvas.SetAreaOfInterestOrDrawOrWrite;
import org.openmap4u.outputformat.OutputableFormat;
import org.openmap4u.plugin.outputformat.graphics2d.PngPlugin;
import org.openmap4u.plugin.outputformat.svg.SvgPlugin;
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
@ContextConfiguration( locations = "/spring-test.xml")
 public abstract class AbstractOpenMap4uTest {

	@Autowired
	private OpenMap4u defaultOpenMap4u =new OpenMap4u();;

	@Autowired
	private OpenMap4u overriddenOpenMap4u=new OpenMap4u();;

	public List<OutputFormat> getOutputFormats() {
		List<OutputFormat> outputFormats = new ArrayList<>();
		outputFormats.add(new OutputFormat(PngPlugin.class, "png"));
		outputFormats.add(new OutputFormat(SvgPlugin.class, "svg"));
		return outputFormats;
	}

	public OpenMap4u getDefaultOpenMap4u() {
		return this.defaultOpenMap4u;
	}

	public SetAreaOfInterestOrDrawOrWrite getCanvas(Length worldUnits,
			Length drawingUnits, Length strokeUnits,
			Class<? extends OutputableFormat> outputFromat, double width,
			double height) {
		return defaultOpenMap4u.getCanvas().setWorldUnits(worldUnits)
				.setDrawingUnits(drawingUnits).setStrokeUnits(strokeUnits)
				.setOutputFormat(outputFromat).setSize(width, height);
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
}
