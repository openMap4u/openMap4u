/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.integration.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystems;
import javax.script.ScriptException;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Hadrbolec
 */
public class NashornTest extends AbstractNashornTest {

    /**
     *
     */
    @Test
    public void testScriptEngine() {
        assertThat(getEngine(), notNullValue());
    }
    
    @Test
    public void testEval() throws ScriptException, FileNotFoundException {
    super.eval(new FileReader(FileSystems.getDefault().getPath(".","target","test-classes","nashorn","simple.js").toFile()));
    assertTrue(true);
    }
    
      @Test
    public void testSimpleOpenMap4u() throws ScriptException, FileNotFoundException {
    super.eval(new FileReader(FileSystems.getDefault().getPath(".","target","test-classes","nashorn","simpleOpenMap4u.js").toFile()));
    assertTrue(true);
    }

}
