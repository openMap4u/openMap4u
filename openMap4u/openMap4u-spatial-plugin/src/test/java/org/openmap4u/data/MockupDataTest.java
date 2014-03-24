package org.openmap4u.data;

/*
 * #%L
 * m4u the ultimative visulisation library
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
 
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
 
import java.io.IOException;
import java.util.zip.ZipFile;

import org.junit.Test;

import com.vividsolutions.jts.geom.Geometry;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;

/**
 *
 * @author zwotti
 */
public class MockupDataTest {

    private static MockupData mD = null;

    /**
     * 
     */
    @BeforeClass
    public static void beforeClass() {
        mD =  MockupData.get();
    }

    /**
     *
     */
    @Test
    public void testITERABLE_COUNTRIES() {
        assertThat("Countries", MockupData.ITERABLE_COUNTRIES.iterator().next(), instanceOf(Country.class));
        assertThat("Number of Countries", MockupData.ITERABLE_COUNTRIES.size(), is(246));
    }

    /**
     *
     * @throws IOException
     */
    @Test(expected = NullPointerException.class)
    public void testInvalidGetZipFile() throws IOException {
        assertThat(MockupData.getZipFile("test"), instanceOf(ZipFile.class));
    }

 
    
 
}