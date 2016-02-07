package org.openmap4u.primitive;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
public class ImagePrimitiveTest {
	
	ImagePrimitive imagePrimitive=null;
	Path path=null;
	Path pathArray = null;
	URI uriPath = null;
	
	@Before
	public void before() {
		imagePrimitive = new ImagePrimitive();
		path = FileSystems.getDefault().getPath("/start");
		pathArray = FileSystems.getDefault().getPath("start","one","two");
		uriPath =  path.toUri() ; 
	}

	@Test
	public void testPathPath() {
		assertThat(imagePrimitive.path(path).getPath(), is(path));
	}

	@Test
	public void testPathStringStringArray() {
		assertThat(imagePrimitive.path("start","one","two").getPath(), is(pathArray));
	}

	@Test
	public void testPathURI() {
		assertThat(imagePrimitive.path(uriPath).getPath(), is(Paths.get(path.toUri() )));
	}
	
	@Test
	public void testClone() throws CloneNotSupportedException {
		 imagePrimitive.path(uriPath);
		 ImagePrimitive clonedImagePrimitive = (ImagePrimitive) imagePrimitive.clone();
		 clonedImagePrimitive.path("start", "one","two");
		 assertThat(imagePrimitive.getPath(),not(clonedImagePrimitive.getPath()));
 	}

}
