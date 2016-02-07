package org.openmap4u.primitive;

import java.awt.Shape;

public interface Shapeable extends Primitiveable {
	
	Shape getPath2D();

}
