package org.openmap4u.primitive;

 import java.util.Set;

import org.openmap4u.geom.Point;

public interface Primitiveable extends Cloneable  {
	
	boolean isPoint();
	
	
	Set<Point> getPoints();
	
	

}
