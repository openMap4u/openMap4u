package org.openmap4u.plugin.builder.spatial;

import org.openmap4u.plugin.builder.spatial.Wkb;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.openmap4u.DrawOrWriteable;
import org.openmap4u.data.Country;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.symbol.Cross;

/**
 *
 * @author Michael Hadrbolec
 */
public class WkbTest extends AbstractSpatialTest {
	
	@Override
	String getName() {
		return "wkb";
	}

    /**
     *
     * @param draw
     * @param outputFileName
     * @throws IOException
     */
    protected void process(DrawOrWriteable draw, String outputFileName) throws IOException {
		for (Country country : MockupData.ITERABLE_COUNTRIES) {
			/* draw a cross in each center */
			draw.draw(this.getDefaultOpenMap4u().get(Wkb.class) 
					.color(Color.BLACK).size(.25).fill(Color.LIGHT_GRAY)
					.wkb(country.getGeomAsWkb()));

		}
	 	for (Country country : MockupData.ITERABLE_COUNTRIES) {
			/* draw a cross in each center */
			draw.draw(this.getDefaultOpenMap4u() 
					.get(Cross.class)
					.center(country.getX(), country.getY())
					.color(Color.GREEN).size(1));
		} 
		/* write the result into the given */
		  draw.write(FileSystems.getDefault().getPath(
				".\\target\\test-classes", outputFileName));


	}

}
