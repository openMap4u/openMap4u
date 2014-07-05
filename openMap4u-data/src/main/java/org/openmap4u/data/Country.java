/**
 * This file is part of openMap4u-data.
 *
 * openMap4u-data is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * openMap4u-data is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with openMap4u-data. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openmap4u.data;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKBWriter;
import com.vividsolutions.jts.io.WKTWriter;

/**
 *
 * @author Michael Hadrbolec
 */
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

    /**
     *
     * @return
     */
    public byte[] getGeomAsWkb() {
        return writerWkb.write(getGeomAsJTS());
    }

    /**
     *
     * @return
     */
    public String getGeomAsWkt() {
        return writerWkt.write(getGeomAsJTS());
    }

    /**
     *
     * @return
     */
    public String getName() {
        return NAME;
    }

    /**
     *
     * @return
     */
    public int getUn() {
        return this.UN;
    }

    /**
     *
     * @return
     */
    public int getRegion() {
        return this.REGION;
    }

    /**
     *
     * @return
     */
    public int getSubregion() {
        return this.SUBREGION;
    }

    /**
     *
     * @return
     */
    public String getISO2() {
        return this.ISO2;
    }

    /**
     *
     * @return
     */
    public String getISO3() {
        return this.ISO3;
    }

    /**
     *
     * @return
     */
    public String getFIPS() {
        return this.FIPS;
    }

    /**
     *
     * @return
     */
    public double getArea() {
        return this.mGeom.getArea();
    }
    
      /**
     *
     * @return
     */
    public double getLenght() {
        return this.mGeom.getLength();
    }

    /**
     *
     * @return
     */
    public double getX() {
        return this.mGeom.getCentroid().getX();
    }

    /**
     *
     * @return
     */
    public double getY() {
        return this.mGeom.getCentroid().getY();
    }

}
