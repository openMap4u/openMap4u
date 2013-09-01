package org.openmap4u.builder;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OutputFormat;
import org.openmap4u.canvas.Draw;
import org.openmap4u.canvas.Write;
import org.openmap4u.data.Country;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.symbol.Cross;
import org.openmap4u.unit.Length;

public abstract class AbstractSpatialTest extends AbstractOpenMap4uTest {

	@Test
	public void testDefault() throws IOException {
		for (OutputFormat outputFormat : getOutputFormats()) {
			process(this.getCanvas(Length.CM, Length.CM, Length.MM, outputFormat.getOutputableFormat(), 36,
					18), getNameWithSuffix("default",outputFormat));
		}
	}

	@Test
	public void testCenter() throws IOException {
		for (OutputFormat outputFormat : getOutputFormats()) {
			process(this.getCanvas(Length.CM, Length.CM, Length.MM, outputFormat.getOutputableFormat(), 36,
					18).setCenter(0, 0), getNameWithSuffix("center",outputFormat));
		}
	}

	@Test
	public void testCenterScale() throws IOException {
		for (OutputFormat outputFormat : getOutputFormats()) {
			process(this
					.getCanvas(Length.CM, Length.CM, Length.MM,
							outputFormat.getOutputableFormat(), 36, 18)
					.setCenter(0, 0).setScale(0.1),
					getNameWithSuffix("center_scale",outputFormat));
		}
	}

	@Test
	public void testCenterScaleRotate() throws IOException {
		for (OutputFormat outputFormat : getOutputFormats()) {
			process(this
					.getCanvas(Length.CM, Length.CM, Length.MM,
							outputFormat.getOutputableFormat(), 36, 18)
					.setCenter(0, 0).setScale(.1).setRotate(30),
					getNameWithSuffix("center_scale_rotate",outputFormat));
		}
	}

	abstract String getName();

	String getNameWithSuffix(String prefix, OutputFormat outputFormat) {
		return outputFormat.getFileneame("spatial",prefix,getName());
	}

	protected abstract void process(Draw draw, String outputFileName) throws IOException ;
}
