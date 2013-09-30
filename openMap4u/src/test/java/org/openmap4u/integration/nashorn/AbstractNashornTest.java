package org.openmap4u.integration.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.BeforeClass;

public abstract class AbstractNashornTest {
	
	private static ScriptEngine mScriptEngine;
	
	@BeforeClass
	public static void beforeClass() {
		ScriptEngineManager manager = new ScriptEngineManager();
		mScriptEngine = manager.getEngineByName("nashorn");
	}
	
	protected ScriptEngine getEngine() {
		return mScriptEngine;
	}
        
        protected

}
