package org.openmap4u.transform;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AffineTransformBuilderTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { {"scale",2,3,0,0,0,new Point2D.Double(10*2,5*3)   } , {"translate",1,1,15,25,0,new Point2D.Double(10+15,5+25)   } , {"rotate",1,1,0,0,Math.PI,new Point2D.Double(-10,-5)   }, {"scaletranslate",2,3,15,25,0,new Point2D.Double(10*2+15*2,5*3+25*3)   },{"scalerotate",2,3,0,0,Math.PI,new Point2D.Double(-10*2,-5*3)   }   ,{"translaterotate",1,1,15,25,Math.PI,new Point2D.Double(-(10-15),-(5-25))   } ,{"alltogether",2,3,15,25,Math.PI,new Point2D.Double(-(10-15)*2,-(5-25)*3)   }  });
	}

	private  AffineTransformBuilder transformBuilder;

	private static final Point2D  pointBeforeTransformation = new Point2D.Double(10, 5);
	
	private Point2D expected;
	
	private Point2D transformed;
	
	private String message;

	public AffineTransformBuilderTest(String message,double scaleX, double scaleY, double translateX, double translateY,double rotate, Point2D expected) {
		transformBuilder = new AffineTransformBuilder() ;
		this.message=message;
		this.expected=expected;
		this.transformed = new Point2D.Double();
		transformBuilder.scaleX(scaleX).scaleY(scaleY).translate(translateX,translateY).rotate(rotate);
		transformBuilder.build().transform(pointBeforeTransformation, transformed);
		
	}

	@Test
	public void testConvert() {
		assertThat(message,transformed, is(expected) );
	}

}
