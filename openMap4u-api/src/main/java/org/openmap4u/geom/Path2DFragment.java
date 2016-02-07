package org.openmap4u.geom;


public abstract class Path2DFragment {
	
	Path2DFragmentType type;
	
	Point[] points;

	Path2DFragment(Path2DFragmentType type, Point ... points) {
		this.type = type;
		this.points = points;
	}
	
	/**
	 * Represents a move2 path fragment.
	 * @author Michael Hadrbolec
	 */
	public static class Move2 extends Path2DFragment {

	    Move2(Point move2Point) {
	        super(Path2DFragmentType.MOVE2, move2Point);
	    }
	  

	}
	
	/**
	 * Represents a line2 path fragment.
	 * @author Michael Hadrbolec
	 */
	public static class Line2 extends Path2DFragment {

	    public Line2(Point line2Point) {
	        super(Path2DFragmentType.LINE2, line2Point);
	    }
	  

	}
	
	/**
	 * Represents a bezier2 path fragment.
	 * @author Michael Hadrbolec
	 */
	 public static class Bezier2 extends Path2DFragment {

	    public Bezier2(Point controlPoint1, Point controlPoint2,Point toPoint) {
	        super(Path2DFragmentType.BEZIER2, controlPoint1,controlPoint2,toPoint);
	    }
	  
	}
	
	 
	 /**
	 * Represents a quad2 path fragment.
	 * @author Michael Hadrbolec
	 */
	public static class Quad2 extends Path2DFragment {

	    public Quad2(Point controlPoint, Point toPoint) {
	        super(Path2DFragmentType.QUAD2,controlPoint,toPoint);
	    }
	    
	    
	    

	}
}
