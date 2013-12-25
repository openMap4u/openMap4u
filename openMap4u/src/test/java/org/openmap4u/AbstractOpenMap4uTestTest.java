/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import java.io.File;
import java.nio.file.Path;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests the abstract AbstractOpenMap4uTest functionality.
 *
 * @author Michael Hadrbolec
 */
public class AbstractOpenMap4uTestTest {

    AbstractOpenMap4uTest aOM4uTest = new AbstractOpenMap4uTest() {
    };

    public AbstractOpenMap4uTestTest() {
    }

    @Test
    public void testGetPath() {
        String path = aOM4uTest.getPackagePath("hello.txt").toUri().toString();
        System.out.println(path);
        assertTrue(path.contains("target"));
        assertTrue(path.contains("test-classes"));
        assertTrue(path.contains("hello.txt"));
    }

    @Test
    public void testGetPackagePath() {
        String path = aOM4uTest.getPackagePath("hello.txt").toUri().toString();
        assertTrue(path.contains("target"));
        assertTrue(path.contains("test-classes"));
        assertTrue(path.contains("org"));
        assertTrue(path.contains("openmap4u"));
        assertTrue(path.contains("hello.txt"));
    }

}
