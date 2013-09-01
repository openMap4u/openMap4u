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
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKBWriter;
import com.vividsolutions.jts.io.WKTWriter;

public class Country {

    private static WKBWriter writerWkb = new WKBWriter();

    private static WKTWriter writerWkt = new WKTWriter();

    /**
     * String(2) FIPS 10-4 Country Code
     */
    private String FIPS;
    /**
     * String(2) ISO 3166-1 Alpha-2 Country Code
     */
    private String ISO2;
    /**
     * String(3) ISO 3166-1 Alpha-3 Country Code
     */
    private String ISO3;
    /**
     * Short Integer(3) ISO 3166-1 Numeric-3 Country Code
     */
    private int UN;
    /**
     * String(50) Name of country/area
     *
     */
    private String NAME;

    /**
     * Long Integer(7) Land area, FAO Statistics (2002)
     */
    private int AREA;
    /**
     * Short Integer(3) Macro geographical (continental region), UN Statistics
     */
    private int REGION;

    /**
     * Short Integer(3) Geogrpahical sub-region, UN Statistics
     */
    private int SUBREGION;

    private Geometry mGeom;

    /**
     * GEOM;FIPS;ISO2;ISO3;UN;NAME;AREA;POP2005;REGION;SUBREGION;LON;LAT
     *
     * @param GEOM
     * @param FIPS
     * @param ISO2
     * @param ISO3
     * @param name
     * @param region
     * @param subregion
     * @param un
     */
    public Country(Geometry GEOM, String FIPS, String ISO2, String ISO3, String name,
            int region, int subregion, int un) {
        this.NAME = name;
        this.FIPS = FIPS;
        this.ISO2 = ISO2;
        this.ISO3 = ISO3;
        this.REGION = region;
        this.SUBREGION = subregion;
        this.UN = un;
        this.mGeom = GEOM;
    }

    /**
     * @return the geom
     */
    public Geometry getGeomAsJTS() {
        return mGeom;
    }

    public byte[] getGeomAsWkb() {
        return writerWkb.write(getGeomAsJTS());
    }

    public String getGeomAsWkt() {
        return writerWkt.write(getGeomAsJTS());
    }

    public String getName() {
        return NAME;
    }

    public int getUn() {
        return this.UN;
    }

    public int getRegion() {
        return this.REGION;
    }

    public int getSubregion() {
        return this.SUBREGION;
    }

    public String getISO2() {
        return this.ISO2;
    }

    public String getISO3() {
        return this.ISO3;
    }

    public String getFIPS() {
        return this.FIPS;
    }

    public double getArea() {
        return this.AREA;
    }

    public double getX() {
        return this.mGeom.getCentroid().getX();
    }

    public double getY() {
        return this.mGeom.getCentroid().getY();
    }

}
