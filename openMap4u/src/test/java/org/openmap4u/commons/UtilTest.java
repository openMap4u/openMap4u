/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

/*
 * #%L
 * t4u-core
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2012 VillaBunterHund
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.awt.geom.AffineTransform;

import javax.activation.MimeType;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Utility Tests
 *
 * @author Michael Hadrbolec
 */
public class UtilTest {

    private static Util mUtility = null;

    @BeforeClass
    public static void setUpClass() {
        try {
            mUtility = Util.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of get method, of class ServiceLocator.
     */
    @Test
    public void testGet() {
        assertThat("ServiceLocator get() not null", mUtility, notNullValue());
    }

    /**
     * Test of getMessage method, of class ServiceLocator.
     */
    @Test
    public void testGetMessage_String_ObjectArr() {
        assertThat("Message with args []", mUtility.getMessage("info.script.engine", "1", "2", "3"), is("Engine: 1 Language:2 Version:3"));
    }

    /**
     * Test of getMessage method, of class ServiceLocator.
     */
    @Test
    public void testGetMessage_String() {
        assertThat("Message with args []", mUtility.getMessage("info.script.engine"), is("Engine: {0} Language:{1} Version:{2}"));
    }

//    @Test
//    public void testGetTranslate() {
//        assertThat(mUtility.getTranslate(20, 10, 2), is(20d - 10d / 2d / 2d));
//    }

//    @Test
//    public void testGetIndividualTransform() {
//        assertThat(mUtility.getIndividualTransform(new TransformHelper()), is(new AffineTransform()));
//    }
    
    
    @Test
    public void testGetMimeType() {
    	MimeType mimeType = mUtility.getMimeType("image","png");
      	assertThat(mimeType, notNullValue());
    	assertThat(mimeType.getPrimaryType(),is("image"));
    	assertThat(mimeType.getSubType(),is("png"));
    }
    
   
}
