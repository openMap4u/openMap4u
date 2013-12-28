package org.openmap4u.integration.el3;

import javax.el.ELProcessor;
import org.junit.BeforeClass;
import org.openmap4u.OpenMap4u;

/**
 *
 * @author zwotti
 */
public class AbstractEl3Test {

	private static ELProcessor mElProcessor;

    /**
     *
     */
    @BeforeClass
	public static void beforeClass() {
		mElProcessor = new ELProcessor();
		/* add a bean named "oM4u" */
		mElProcessor.defineBean("oM4u", new OpenMap4u());
	}

    /**
     *
     * @return
     */
    protected ELProcessor getELProcessor() {
		return mElProcessor;
	}

    /**
     *
     * @param expression
     */
    protected void eval(String expression) {
		mElProcessor.eval(expression);
	}

}
