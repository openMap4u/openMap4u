package org.openmap4u.style;

import java.awt.Paint;

public interface LineStringStyleable extends Styleable  {
	
	  /**
     * Gets the stroke color.
     *
     * @return The stroke color.
     */
    Paint getStrokeColor();

    /**
     * Gets the stroke size in stroke units.
     *
     * @return The stroke size in stroke units.
     */
    double getStrokeSize();

}
