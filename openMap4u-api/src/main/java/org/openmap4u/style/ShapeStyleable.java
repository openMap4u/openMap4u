package org.openmap4u.style;

import java.awt.Paint;

public interface ShapeStyleable extends LineStringStyleable {

	/**
	 * Gets the fill color.
	 *
	 * @return The fill color.
	 */
	Paint getStrokeFill();

}
