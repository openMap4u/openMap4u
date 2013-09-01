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
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.util.zip.ZipFile;

import org.junit.Test;
import org.openmap4u.data.Country;

import com.google.common.collect.Iterables;
import com.vividsolutions.jts.geom.Geometry;

public class MockupDataTest {

    @Test
    public void testITERABLE_COUNTRIES() {
        assertThat("Countries", MockupData.ITERABLE_COUNTRIES.iterator().next(), instanceOf(Country.class));
        assertThat("Number of Countries", Iterables.size(MockupData.ITERABLE_COUNTRIES), is(246));
    }

    @Test
    public void testITERABLE_COUNTRY_JTS_GEOMETRY() {
        assertThat("Countries", MockupData.ITERABLE_COUNTRY_JTS_GEOMETRY.iterator().next(), instanceOf(Geometry.class));
        assertThat("Number of Countries", Iterables.size(MockupData.ITERABLE_COUNTRIES), is(246));
    }

    @Test
    public void testWKT() {
        assertThat(MockupData.WKT_LINESTRING, notNullValue());
        assertThat(MockupData.WKT_MULTILINESTRING, notNullValue());
        assertThat(MockupData.WKT_POINT, notNullValue());
        assertThat(MockupData.WKT_MULTIPOINT, notNullValue());
        assertThat(MockupData.WKT_POLYGON, notNullValue());
        assertThat(MockupData.WKT_POLYGON_ISLAND, notNullValue());
        assertThat(MockupData.WKT_MULTIPOLYGON, notNullValue());
        assertThat(MockupData.WKT_MULTIPOLYGON_ISLAND, notNullValue());

    }

    @Test
    public void testWKB() {

        assertThat(MockupData.WKB_LINESTRING, notNullValue());
        assertThat(MockupData.WKB_MULTILINESTRING, notNullValue());
        assertThat(MockupData.WKB_POINT, notNullValue());
        assertThat(MockupData.WKB_MULTIPOINT, notNullValue());
        assertThat(MockupData.WKB_POLYGON, notNullValue());
        assertThat(MockupData.WKB_POLYGON_ISLAND, notNullValue());
        assertThat(MockupData.WKB_MULTIPOLYGON, notNullValue());
        assertThat(MockupData.WKB_MULTIPOLYGON_ISLAND, notNullValue());

    }

    @Test
    public void testJTS() {
        assertThat(MockupData.JTS_LINESTRING, notNullValue());
        assertThat(MockupData.JTS_MULTILINESTRING, notNullValue());
        assertThat(MockupData.JTS_POINT, notNullValue());
        assertThat(MockupData.JTS_MULTIPOINT, notNullValue());
        assertThat(MockupData.JTS_POLYGON, notNullValue());
        assertThat(MockupData.JTS_POLYGON_ISLAND, notNullValue());
        assertThat(MockupData.JTS_MULTIPOLYGON, notNullValue());
        assertThat(MockupData.JTS_MULTIPOLYGON_ISLAND, notNullValue());

    }

    @Test(expected = NullPointerException.class)
    public void testInvalidGetZipFile() throws IOException {
        assertThat(MockupData.getZipFile("test"), instanceOf(ZipFile.class));
    }

 /*   @Test
    public void testValidGetZipFile() throws IOException {
        assertThat(MockupData.getZipFile("world_development_indicators/WDI_csv.zip"), instanceOf(ZipFile.class));
    }

    @Test
    public void testValidGetZipEntry() throws IOException {
        MockupData.readProps();
    } */
}
