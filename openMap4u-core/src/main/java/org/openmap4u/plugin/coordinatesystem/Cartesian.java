package org.openmap4u.plugin.coordinatesystem;

import org.openmap4u.coordinatesystem.CoordinateSystem;

public final class Cartesian extends CoordinateSystem {

	@Override
	protected double transformX(double x, double y) {
		return x;
	}

	@Override
	protected double transformY(double x, double y) {
		return y;
	}

}
