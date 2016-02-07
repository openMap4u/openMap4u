package org.openmap4u.primitive;

import org.openmap4u.geom.Point;

 
public interface PrimitiveBuildable<T extends PrimitiveBuildable<T>> {
	
	
	T center(Point point);

}
