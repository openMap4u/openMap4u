package org.openmap4u.style;

public final class ImageStyle extends Style<ImageStyle> implements ImageStyleable,  ImageStyleBuildable<ImageStyle> {
	
	public ImageStyle() {
		super();
	}

	
	public boolean equals(Object object) {
		boolean equals = false;
		if(object instanceof ImageStyle ) {
			return super.equals(object);
		}
		return equals;
 		
	}
	
	
}
