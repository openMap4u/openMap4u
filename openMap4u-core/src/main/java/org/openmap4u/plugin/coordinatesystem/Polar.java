package org.openmap4u.plugin.coordinatesystem;

import org.openmap4u.commons.Angle;
import org.openmap4u.commons.Globals;
import org.openmap4u.coordinatesystem.CoordinateSystem;

/**
 * Polar coodinate System.
 * @author Michael Hadrbolec.
 *
 */
public class Polar extends CoordinateSystem {

	private Angle mAngularUnit= Globals.DEFAULT_ANGLE_UNIT;
	
	@Override
	protected double transformX(double x, double y) {
		return x * Math.cos(mAngularUnit.convert(y));
	}

	@Override
	protected double transformY(double x, double y) {
		return x* Math.sin(mAngularUnit.convert(y));
	}

}
