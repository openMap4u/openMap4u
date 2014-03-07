package org.openmap4u.integration.nashorn;

import java.io.Reader;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import org.junit.BeforeClass;

/**
 *
 * @author zwotti
 */
public abstract class AbstractNashornTest {

    private static Compilable engine;
    private static NashornScriptEngineFactory engineFactory = new NashornScriptEngineFactory();

    /**
     *
     */
    @BeforeClass
    public static void beforeClass() {
        engine = (Compilable) engineFactory.getScriptEngine();
    }

    /**
     *
     * @return
     */
    protected final Compilable getEngine() {
        return engine;
    }

    protected CompiledScript compile(Reader reader) throws ScriptException {
        return engine.compile(reader);
    }

    protected Object eval(Reader reader) throws ScriptException {
        return compile(reader).eval();
    }
}
