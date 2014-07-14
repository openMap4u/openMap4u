package org.openmap4u.plugin.builder.spatial;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OutputFormat;
import org.openmap4u.DrawOrWriteable;
import org.openmap4u.data.Country;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.symbol.Cross;
import org.openmap4u.commons.Length;

/**
 *
 * @author Michael Hadrbolec
 */
public abstract class AbstractSpatialTest extends AbstractOpenMap4uTest {

    /**
     *
     * @throws IOException
     */
    @Test
	public void testDefault() throws IOException {
		for (OutputFormat outputFormat : getOutputFormats()) {
			process(this.getCanvas(Length.CM, Length.CM, Length.MM, outputFormat.getOutputableFormat(), 36,
					18), getNameWithSuffix("default",outputFormat));
		}
	}

    /**
     *
     * @throws IOException
     */
    @Test
	public void testCenter() throws IOException {
		for (OutputFormat outputFormat : getOutputFormats()) {
			process(this.getCanvas(Length.CM, Length.CM, Length.MM, outputFormat.getOutputableFormat(), 36,
					18).center(0, 0), getNameWithSuffix("center",outputFormat));
		}
	}

    /**
     *
     * @throws IOException
     */
    @Test
	public void testCenterScale() throws IOException {
		for (OutputFormat outputFormat : getOutputFormats()) {
			process(this
					.getCanvas(Length.CM, Length.CM, Length.MM,
							outputFormat.getOutputableFormat(), 36, 18)
					.center(0, 0).scale(0.1),
					getNameWithSuffix("center_scale",outputFormat));
		}
	}

    /**
     *
     * @throws IOException
     */
    @Test
	public void testCenterScaleRotate() throws IOException {
		for (OutputFormat outputFormat : getOutputFormats()) {
			process(this
					.getCanvas(Length.CM, Length.CM, Length.MM,
							outputFormat.getOutputableFormat(), 36, 18)
					.center(0, 0).scale(.1).rotate(30),
					getNameWithSuffix("center_scale_rotate",outputFormat));
		}
	}

	abstract String getName();

	String getNameWithSuffix(String prefix, OutputFormat outputFormat) {
		return outputFormat.getFileneame("spatial",prefix,getName());
	}

    /**
     *
     * @param draw
     * @param outputFileName
     * @throws IOException
     */
    protected abstract void process(DrawOrWriteable draw, String outputFileName) throws IOException ;
}
