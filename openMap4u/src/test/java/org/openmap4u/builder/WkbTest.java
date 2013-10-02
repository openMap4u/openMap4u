package org.openmap4u.builder;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.openmap4u.canvas.DrawOrWrite;
import org.openmap4u.data.Country;
import org.openmap4u.data.MockupData;
import org.openmap4u.plugin.builder.symbol.Cross;

public class WkbTest extends AbstractSpatialTest {
	
	@Override
	String getName() {
		return "wkb";
	}
	
	protected void process(DrawOrWrite draw, String outputFileName) throws IOException {
		for (Country country : MockupData.ITERABLE_COUNTRIES) {
			/* draw a cross in each center */
			draw.draw(this.getDefaultOpenMap4u().getBuilder().getWkb()
					.setStrokeColor(Color.BLACK).setStrokeSize(.25).setStrokeFill(Color.LIGHT_GRAY)
					.setWkb(country.getGeomAsWkb()));

		}
	 	for (Country country : MockupData.ITERABLE_COUNTRIES) {
			/* draw a cross in each center */
			draw.draw(this.getDefaultOpenMap4u().getBuilder()
					.getCustomBuilder(Cross.class)
					.setPoint(country.getX(), country.getY())
					.setStrokeColor(Color.GREEN).setStrokeSize(1));
		} 
		/* write the result into the given */
		  draw.write(FileSystems.getDefault().getPath(
				".\\target\\test-classes", outputFileName));


	}

}
