package org.openmap4u.builder;

import org.openmap4u.plugin.builder.spatial.Wkt;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.openmap4u.DrawOrWriteable;
import org.openmap4u.data.Country;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.symbol.Cross;

/**
 *
 * @author zwotti
 */
public class WktTest extends AbstractSpatialTest {

	@Override
	String getName() {
		return "wkt";
	}

    /**
     *
     * @param draw
     * @param outputFileName
     * @throws IOException
     */
    protected void process(DrawOrWriteable  draw, String outputFileName) throws IOException {
		for (Country country : MockupData.ITERABLE_COUNTRIES) {
			/* draw a cross in each center */
			draw.draw(this.getDefaultOpenMap4u().get(Wkt.class)
					.color(Color.BLACK).size(.25).fill(Color.LIGHT_GRAY)
					.wkt(country.getGeomAsWkt()));

		}
	 	for (Country country : MockupData.ITERABLE_COUNTRIES) {
			/* draw a cross in each center */
			draw.draw(this.getDefaultOpenMap4u()
					.get(Cross.class)
					.point(country.getX(), country.getY())
					.color(Color.GREEN).size(1));
		} 
		/* write the result into the given */
		  draw.write(FileSystems.getDefault().getPath(
				".\\target\\test-classes", outputFileName));


	}

}
