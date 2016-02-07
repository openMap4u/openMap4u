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

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKBWriter;
import com.vividsolutions.jts.io.WKTReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.Feature;

/**
 *
 * @author Michael Hadrbolec
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
        for (Country country : ITERABLE_COUNTRIES) {
            geoms.add(country.getGeomAsJTS());
        }
        BOUNDINGBOX_COUNTRIES = getBBox(geoms);

        
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
     * Creates random double values.
     *
     * @param lowerBound The lower bound for random double values.
     * @param upperBound The upper bound for random values.
     * @param steps The number of steps.
     * @return The values.
     */
    public final List<Double> getRandom(double lowerBound, double upperBound, int steps) {
        List<Double> values = new ArrayList<>();
        double delta = upperBound - lowerBound;
        for (int i = 0; i < steps; i++) {
            values.add(lowerBound + delta * Math.random());
        }
        return values;
    }

    public final List<Entry<Double, Double>> getProperties(double lowerBoundX, double upperBoundX, int stepsX, double lowerBoundY, double upperBoundY) {
        List<Entry<Double, Double>> entries = new ArrayList<>();
        HashMap hm = null;
        List<Double> values = getRange(lowerBoundX, upperBoundX, stepsX);
        for (Double value : values) {
            entries.add(new EntryImpl<Double, Double>(value, getRandom(lowerBoundY, upperBoundY)));
        }
        return entries;
    }

    public final double getRandom(double lowerBound, double upperBound) {
        return Math.random() * (upperBound - lowerBound) + lowerBound;
    }

    /**
     * Creates random double values.
     *
     * @param lowerBound The lower bound for random double values.
     * @param upperBound The upper bound for random values.
     * @param steps The number of steps.
     * @return The values.
     */
    public final List<Data<Double, Double[]>> getRandom(double lowerBound, double upperBound, int xTimes, int steps) {
        List<Data<Double, Double[]>> values = new ArrayList<>();
        double delta = upperBound - lowerBound;
        for (int i = 0; i < steps; i++) {
            Double[] vals = new Double[xTimes];
            for (int j = 0; j < xTimes; j++) {
                vals[j] = lowerBound + delta * Math.random();
            }
            values.add(new Data<Double, Double[]>(Double.valueOf(i), vals));
        }
        return values;
    }

    /**
     * Creates a range beginning with the default value 0, the given stop value
     * and the default step width of 1. <br/>
     * Example: <code>10</code> would result in a list containing
     * <code>0,1,2,3,4,5,6,7,8,9</code>
     *
     * @param stop The stop value of the range.
     * @return The resulting range.
     */
    public final List<Double> getRange(double stop) {
        return getRange(stop, 1);
    }

    /**
     * Creates a range beginning with the default value 0.<br/>
     * Example: <code>100,10</code> would result in a list containing
     * <code>0,10,20,30,40,50,60,70,80,90</code>
     *
     * @param stop The stop value of the range.
     * @param step The step width of the range.
     * @return The resulting range.
     */
    public final List<Double> getRange(double stop, double step) {
        return getRange(0, stop, step);
    }

    /**
     * Creates a range.
     *
     * @param start The start value of the range.
     * @param stop The stop value of the range which is not included.
     * @param step The step width. Example: <code>10,100,10</code> would result
     * in a list containing <code>10,20,30,40,50,60,70,80,90</code>
     * @return The resulting range.
     */
    public final List<Double> getRange(double start, double stop,
            double step) {
        List<Double> list = new ArrayList<Double>();
        if (step > 0) {
            for (double x = start; x < stop; x += step) {
                list.add(x);
            }
        } else {
            for (double x = start; x > stop; x += step) {
                list.add(x);
            }
        }
        return list;
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
     * Gets the countries.
     *
     * @return The countries.
     */
    public final List<Country> getCountries() {
        return ITERABLE_COUNTRIES;
    }

}
