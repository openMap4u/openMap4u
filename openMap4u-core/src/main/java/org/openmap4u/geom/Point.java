package org.openmap4u.geom;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openmap4u.commons.Globals;

/**
 * All point geometries are derived from this base class.
 * 
 * @author Michael Hadrbolec
 *
 * @param <X>
 *            The type of the x coordinate.
 * @param <Y>
 *            The type of the y coordinate.
 */
public abstract class Point<X, Y> implements Serializable {

	private static final String REL_PREFIX = "@";

	/**
	 * The generated serialVersionUID.
	 */
	private static final long serialVersionUID = 2466678006106266542L;

	/**
	 * The logger.
	 */
	private static Logger LOG = Logger.getLogger(Point.class.getName(),
			Globals.DEFAULT_RESSOURCE_BUNDLE);

	/**
	 * Creates a new point.
	 * 
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 */
	public Point(X x, Y y) {
		if (x != null && y != null) {
			this.x = x;
			this.y = y;
		} else {
			LOG.log(Level.SEVERE, "x_and_y_not_null", new Object[] { x, y });
		}
	}

	static double convert(String relCoord2Convert, double previousCoord) {
		if (relCoord2Convert.startsWith(REL_PREFIX)) {
			return previousCoord
					+ java.lang.Double.valueOf(relCoord2Convert.substring(1));
		} else {
			throw new java.lang.IllegalArgumentException(
					"Invalid relative coordinate format: " + relCoord2Convert
							+ ". Examples '@123.45' '@-124.56'");
		}
	}

	/**
	 * The x coordinate.
	 */
	public X x = null;

	/**
	 * The Y coordinate.
	 */
	public Y y = null;

	/**
	 * Converts a relative point into an absolute point based on the previous drawn point.
	 * @author Michael Hadrbolec
	 *
	 */
	interface RelativeConvertable {
		/**
		 * Convert the relative with the absolute previous point into an absolute point.
		 * @param previousPoint The previous point.
		 * @return The into an absolute point converted relative point.
		 */
		Absolute convert(Absolute previousPoint);
	}

	public final static class Absolute extends Point<Double, Double> {

		/**
		 * The generated serialVersionUID.
		 */
		private static final long serialVersionUID = 3395754332719378084L;

		public Absolute(Double x, Double y) {
			super(x, y);
		}
	}

	/**
	 * Represents a point based on a relative x and relative y coordinate.
	 * 
	 * @author Michael Hadrbolec
	 *
	 */
	public final static class Relative extends Point<String, String> implements
			RelativeConvertable {

		/**
		 * The generated serialVersionUID.
		 */
		private static final long serialVersionUID = 1122133039400834373L;

		/**
		 * Creates new point based on a relative x and a relative y coordinate.
		 * 
		 * @param x
		 *            The absolute x coordinate (e.g. 123.76 or -255.34)
		 * @param y
		 *            The relative y coordinate (e.g. @123.76 or @-255.34)
		 */
		public Relative(String x, String y) {
			super(x, y);
		}

		/**
		 * {@inheritDoc}
		 */
		public Absolute convert(Absolute previousPoint) {
			return new Absolute(convert(x, previousPoint.x), convert(y,
					previousPoint.y));
		}
	}

	/**
	 * Represents a point based on an absolute x and relative y coordinate.
	 * 
	 * @author Michael Hadrbolec
	 *
	 */
	public final static class RelativeX extends Point<String, Double> implements
			RelativeConvertable {

		/**
		 * The generated serialVersionUID.
		 */
		private static final long serialVersionUID = -5877709545004884230L;

		/**
		 * Creates new point based on a relative x and an absolute y coordinate.
		 * 
		 * @param x
		 *            The relative x coordinate (e.g. @123.76 or @-255.34)
		 * @param y
		 *            The absolute y coordinate (e.g. 123.76 or -255.34)
		 */
		public RelativeX(String x, Double y) {
			super(x, y);
		}

		/**
		 * {@inheritDoc}
		 */
		public Absolute convert(Absolute previousPoint) {
			return new Absolute(convert(x, previousPoint.x), y);
		}

	}

	/**
	 * Represents a point based on a relative x and an absolute y coordinate.
	 * 
	 * @author Michael Hadrbolec
	 *
	 */
	public static final class RelativeY extends Point<Double, String> implements
			RelativeConvertable {

		/**
		 * The generated serialVersionUID.
		 */
		private static final long serialVersionUID = -6481642941112430219L;

		/**
		 * Creates new point based on an absolute x and a relative y coordinate.
		 * 
		 * @param x
		 *            The absolute x coordinate (e.g. 123.76 or -255.34)
		 * @param y
		 *            The relative y coordinate (e.g. @123.76 or @-255.34)
		 */
		public RelativeY(Double x, String y) {
			super(x, y);
		}

		/**
		 * {@inheritDoc}
		 */
		public Absolute convert(Absolute previousPoint) {
			return new Absolute(x, convert(y, previousPoint.y));
		}

	}

}
