package org.openmap4u.builder;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.openmap4u.canvas.DrawOrWrite;
import org.openmap4u.data.Country;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.symbol.Cross;

public class WktTest extends AbstractSpatialTest {

	@Override
	String getName() {
		return "wkt";
	}
	
	protected void process(DrawOrWrite  draw, String outputFileName) throws IOException {
		for (Country country : MockupData.ITERABLE_COUNTRIES) {
			/* draw a cross in each center */
			draw.draw(this.getDefaultOpenMap4u().getBuilder().getWkt()
					.strokeColor(Color.BLACK).strokeSize(.25).strokeFill(Color.LIGHT_GRAY)
					.setWkt(country.getGeomAsWkt()));

		}
	 	for (Country country : MockupData.ITERABLE_COUNTRIES) {
			/* draw a cross in each center */
			draw.draw(this.getDefaultOpenMap4u().getBuilder()
					.getCustomBuilder(Cross.class)
					.setPoint(country.getX(), country.getY())
					.strokeColor(Color.GREEN).strokeSize(1));
		} 
		/* write the result into the given */
		  draw.write(FileSystems.getDefault().getPath(
				".\\target\\test-classes", outputFileName));


	}

}
