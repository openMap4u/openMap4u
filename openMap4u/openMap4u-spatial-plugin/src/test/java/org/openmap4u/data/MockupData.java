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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.Feature;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKBWriter;
import com.vividsolutions.jts.io.WKTReader;
import java.util.Map.Entry;
 
/**
 *
 * @author zwotti
 */
public class MockupData {

    private static MockupData mD = new MockupData();

    /**
     * The image url.
     */
    public static String IMAGE_URL = null;

    /**
     * The iterable countries.
     */
    public static List<Country> ITERABLE_COUNTRIES;
    /**
     * The bounding box of all countries.
     */
    public static Envelope BOUNDINGBOX_COUNTRIES;

    static {

        WKTReader reader = new WKTReader();
        WKBWriter writer = new WKBWriter();

        try {
            readShapeFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            ITERABLE_COUNTRIES = readShapeFile();
        } catch (Exception e) {
            e.printStackTrace();

        }


        /* set the bounding box */
        List<Geometry> geoms = new ArrayList<Geometry>();
        for (Country country :ITERABLE_COUNTRIES) {
        geoms.add(country.getGeomAsJTS());
        }
        BOUNDINGBOX_COUNTRIES = getBBox(geoms);

        try {
            IMAGE_URL = Thread.currentThread().getContextClassLoader()
                    .getResource("image/image.png").toURI().toString();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ;
    }

    /**
     * Singleton pattern.
     */
    private MockupData() {
    }

    /**
     * Singleton pattern.
     *
     * @return The single MockupData instance.
     */
    public static MockupData get() {
        return mD;
    }

    /**
     * Renders the x and y coordinate.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return The x an y coordinate.
     */
    static String getXY(double x, double y) {
        return new StringBuilder().append(x).append(" ").append(y).toString();
    }

    /**
     * Gets the overall enclosing envelope of all given geometries.
     *
     * @param values The geometries whose overall envelope should be retrieved.
     * @return The overall enclosing envelope of all given geometries.
     */
    static final Envelope getBBox(List<Geometry> values) {
        final Envelope bBox = new Envelope();
        values.forEach(value -> {
            bBox.expandToInclude(value.getEnvelopeInternal());

        });

        return bBox;
    }

    static ZipFile getZipFile(String zipResource) throws IOException {
        return new ZipFile(Thread.currentThread().getContextClassLoader()
                .getResource(zipResource).getFile());
    }

    static void readZipFile() {
        try {

            ZipFile zip = getZipFile("world_development_indicators/WDI_csv.zip");
            InputStream in = zip.getInputStream(new ZipEntry("WDI_Data.csv"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            String[] split = null;
            int tokenNumber = 0;
            br.readLine();
            while ((line = br.readLine()) != null) {
                // break comma separated line using ","
                split = line.split(",");
                // display csv values
                tokenNumber++;

                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Set<String> readProps() {
        Set<String> props = new HashSet<String>();

        try {
            ZipFile zip = getZipFile("world_development_indicators/WDI_csv.zip");
            InputStream in = zip.getInputStream(new ZipEntry("WDI_Data.csv"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            String[] split = null;
            int tokenNumber = 0;
            br.readLine();
            while ((line = br.readLine()) != null) {
                // break comma separated line using ","
                split = line.split(",");
                // display csv values
                props.add(convertProp(split[2]));
                tokenNumber++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String prop : props) {
            System.out.println("double " + prop + "= Double.NaN; ");
        }
        System.out.println("\n" + props.size());
        return props;
    }

    static String convertProp(String prop) {
        return prop.trim().replaceAll("\"", "").replaceAll(" ", "_")
                .replaceAll("\\(", "").replaceAll("\\)", "")
                .replaceAll("%", "percent").replaceAll("\\&", "")
                .replaceAll("-", "_").replaceAll("\\+", "_")
                .replaceAll(":", "").replaceAll("=", "_")
                .replaceAll("\\.", "_").replaceAll("\\'", "")
                .replaceAll(";", "_").replaceAll("/", "_");
    }

    static List<Country> readShapeFile() throws IOException {
        List<Country> countries = new ArrayList<Country>();
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("spatial/tm_world_borders_v0_3/TM_WORLD_BORDERS_SIMPL-0.3.shp"));
        map.put("url", Thread.currentThread().getContextClassLoader().getResource("spatial/tm_world_borders_v0_3/TM_WORLD_BORDERS_SIMPL-0.3.shp"));
        DataStore dataStore = DataStoreFinder.getDataStore(map);
        String typeName = dataStore.getTypeNames()[0];

        FeatureSource source = dataStore.getFeatureSource(typeName);

        FeatureCollection collection = source.getFeatures();
        FeatureIterator iterator = collection.features();
        try {
            while (iterator.hasNext()) {
                Feature feature = (Feature) iterator.next();
                countries.add(new Country((Geometry) feature.getDefaultGeometryProperty().getValue(), feature.getProperty("FIPS").getValue().toString(), feature.getProperty("ISO2").getValue().toString(), feature.getProperty("ISO3").getValue().toString(), feature.getProperty("NAME").getValue().toString(), Integer.valueOf(feature.getProperty("REGION").getValue().toString()), Integer.valueOf(feature.getProperty("SUBREGION").getValue().toString()), Integer.valueOf(feature.getProperty("UN").getValue().toString())));

            }
        } finally {

        }
        return countries;
    }

    /**
     * Creates the values .
     *
     * @param start
     * @param stop
     * @param steps The number of steps.
     * @return The values.
     */
    public final List<Double> getValues(double start, double stop, int steps) {
        List<Double> values = new ArrayList<>();
        double delta = (stop - start) / (steps - 1);
        for (int i = 0; i < steps; i++) {
            values.add(start + i * delta);
        }
        return values;
    }



  
    /**
     * Gets the countries.
     *
     * @return The countries.
     */
    public final List<Country> getCountries() {
        return ITERABLE_COUNTRIES;
    }

  
   
   

}