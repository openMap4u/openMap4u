package org.openmap4u.geom;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public abstract class PathFragment {
	
	FragmentType type;
	
	Point2D[] points;

	PathFragment(FragmentType type, Point2D.Double ... points) {
		this.type = type;
		this.points = points;
	}
	
	/**
	 * Represents a move2 path fragment.
	 * @author Michael Hadrbolec
	 */
	public static class Move2 extends PathFragment {

	    Move2(double x, double y) {
	        super(FragmentType.MOVE2, new Point2D.Double(x,y));
	    }
	  

	}
	
	/**
	 * Represents a line2 path fragment.
	 * @author Michael Hadrbolec
	 */
	public static class Line2 extends PathFragment {

	    public Line2(double x, double y) {
	        super(FragmentType.LINE2, new Point2D.Double(x,y));
	    }
	  

	}
	
	/**
	 * Represents a bezier2 path fragment.
	 * @author Michael Hadrbolec
	 */
	 public static class Bezier2 extends PathFragment {

	    public Bezier2(double cp1X, double cp1Y, double cp2X, double cp2Y,double toX, double toY) {
	        super(FragmentType.BEZIER2, new Point2D.Double(cp1X,cp1Y),new Point2D.Double(cp2X,cp2Y), new Point2D.Double(toX,toY)  );
	    }
	  
	}
	
	 
	 /**
	 * Represents a quad2 path fragment.
	 * @author Michael Hadrbolec
	 */
	public static class Quad2 extends PathFragment {

	    public Quad2(double cpX, double cpY, double toX, double toY) {
	        super(FragmentType.QUAD2,new  Double(cpX, cpY),new  Point2D.Double(toX,toY));
	    }
	    
	    
	    

	}
}
