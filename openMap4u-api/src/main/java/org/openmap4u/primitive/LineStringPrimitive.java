package org.openmap4u.primitive;

import java.awt.Shape;



public class LineStringPrimitive extends AbstractLineStringPrimitive<LineStringPrimitive> implements LineStringBuildable<LineStringPrimitive>,LineStringable  {
	
	public Object clone() throws CloneNotSupportedException {
		return new LineStringPrimitive().shape((Shape) this.getPath2D().clone());
	}


	
	 
}
