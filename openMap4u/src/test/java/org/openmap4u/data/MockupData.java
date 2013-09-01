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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBWriter;
import com.vividsolutions.jts.io.WKTReader;

public class MockupData {

	public static final String WKT_LINESTRING = "LINESTRING(-.4 -.4, 0 0.4,.4 -.4)";
	public static final String WKT_MULTILINESTRING = "MULTILINESTRING((-.2 -.2, 0 0.2,.2 -.2), (-.4 -.4, 0 0.4,.4 -.4))";
	public static final String WKT_POINT = "POINT(0 0)";
	public static final String WKT_MULTIPOINT = "MULTIPOINT(-.3 .3,0 0.3,.3 -.3)";
	public static final String WKT_POLYGON = "POLYGON((-0.4 -0.4, 0  0.4, 0.4  -.4 ,-.4 -.4))";
	public static final String WKT_POLYGON_ISLAND = "POLYGON((-0.4 -0.4, 0  0.4, 0.4  -.4, -.4 -.4 ), (-0.2 -0.2, 0  0.2, 0.2  -.2,-.2 -.2 ))";
	public static final String WKT_MULTIPOLYGON = "MULTIPOLYGON(((-0.4 -0.4, 0  0.4, 0.4 -.4,-0.4 -0.4 )), ((0.2 0.4, 0.4  0.4, 0.4  0,0.2 0.4 )) )";
	public static final String WKT_MULTIPOLYGON_ISLAND = "MULTIPOLYGON(((-0.4 -0.4, 0  0.4, 0.4  -.4,-0.4 -0.4 ), (-0.2 -0.2, 0  0.2, 0.2  -.2,-0.2 -0.2 )) , ((0.2 0.4, 0.4  0.4, 0.4  0 ,0.2 0.4)) )";
	public static byte[] WKB_LINESTRING;
	public static byte[] WKB_MULTILINESTRING;
	public static byte[] WKB_POINT;
	public static byte[] WKB_MULTIPOINT;
	public static byte[] WKB_POLYGON;
	public static byte[] WKB_POLYGON_ISLAND;
	public static byte[] WKB_MULTIPOLYGON;
	public static byte[] WKB_MULTIPOLYGON_ISLAND;
	public static Geometry JTS_LINESTRING;
	public static Geometry JTS_MULTILINESTRING;
	public static Geometry JTS_POINT;
	public static Geometry JTS_MULTIPOINT;
	public static Geometry JTS_POLYGON;
	public static Geometry JTS_POLYGON_ISLAND;
	public static Geometry JTS_MULTIPOLYGON;
	public static Geometry JTS_MULTIPOLYGON_ISLAND;
	public static final Double[] ARRAY_DOUBLE_0_9 = new Double[] { 0d, 1d, 2d,
			3d, 4d, 5d, 6d, 7d, 8d, 9d };
	public static final String[] ARRAY_ALPHABET_a_z = { "a", "b", "c", "d",
			"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z" };
	public static final Iterable<Double> ITERABLE_DOUBLE_0_9 = Arrays
			.asList(ARRAY_DOUBLE_0_9);
	public static final Iterable<String> ITERABLE_ALPHABET_a_z = Arrays
			.asList(ARRAY_ALPHABET_a_z);
	public static final Integer[] ARRAY_VALUE_GERADE = new Integer[] { 1, 2, 4,
			5, 18 };
	public static final Iterable<Integer> ITERABLE_VALUE_GERADE = Arrays
			.asList(ARRAY_VALUE_GERADE);
	public static final Integer[] ARRAY_VALUE_UNGERADE = new Integer[] { 1, 1,
			2, 3, 4, 37 };
	public static final Iterable<Integer> ITERABLE_VALUE_UNGERADE = Arrays
			.asList(ARRAY_VALUE_UNGERADE);
	public static String IMAGE_URL = null;
	public static Iterable<Country> ITERABLE_COUNTRIES;
	public static Iterable<Geometry> ITERABLE_COUNTRY_JTS_GEOMETRY;
	public static Iterable<Geometry> ITERABLE_JTS_RECTANGLES;
	/**
	 * The bounding box of all countries.
	 */
	public static Envelope BOUNDINGBOX_COUNTRIES;
	public static Envelope BOUNDINGBOX_RECTANGLES;

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
			ITERABLE_COUNTRY_JTS_GEOMETRY = Iterables.transform(
					ITERABLE_COUNTRIES, new Function<Country, Geometry>() {
						public Geometry apply(final Country country) {
							try {
								return country.getGeomAsJTS();
							} catch (Exception e) {
								throw new IllegalArgumentException(
										"error.api.processor.wrapExpr2Iterable",
										e);
							}
						}
					});
	 

		/* set the bounding box */
		BOUNDINGBOX_COUNTRIES = getBBox(ITERABLE_COUNTRY_JTS_GEOMETRY);

		try {

		 		ITERABLE_COUNTRY_JTS_GEOMETRY = Iterables.transform(
					ITERABLE_COUNTRIES, new Function<Country, Geometry>() {
						public Geometry apply(final Country country) {
							try {
								return country.getGeomAsJTS();
							} catch (Exception e) {
								throw new IllegalArgumentException(
										"error.api.processor.wrapExpr2Iterable",
										e);
							}
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		/* set the bounding box */
		BOUNDINGBOX_COUNTRIES = getBBox(ITERABLE_COUNTRY_JTS_GEOMETRY);

		try {
			/* initalize JTS */
			JTS_POINT = reader.read(WKT_POINT);
			JTS_MULTIPOINT = reader.read(WKT_MULTIPOINT);
			JTS_LINESTRING = reader.read(WKT_LINESTRING);
			JTS_MULTILINESTRING = reader.read(WKT_MULTILINESTRING);
			JTS_POLYGON = reader.read(WKT_POLYGON);
			JTS_POLYGON_ISLAND = reader.read(WKT_POLYGON_ISLAND);
			JTS_MULTIPOLYGON = reader.read(WKT_MULTIPOLYGON);
			JTS_MULTIPOLYGON_ISLAND = reader.read(WKT_MULTIPOLYGON_ISLAND);
			/* initialize WKB */
			WKB_LINESTRING = writer.write(JTS_LINESTRING);
			WKB_MULTILINESTRING = writer.write(JTS_MULTILINESTRING);
			WKB_POINT = writer.write(JTS_POINT);
			WKB_MULTIPOINT = writer.write(JTS_MULTIPOINT);
			WKB_POLYGON = writer.write(JTS_POLYGON);
			WKB_POLYGON_ISLAND = writer.write(JTS_POLYGON_ISLAND);
			WKB_MULTIPOLYGON = writer.write(JTS_MULTIPOLYGON);
			WKB_MULTIPOLYGON_ISLAND = writer.write(JTS_MULTIPOLYGON_ISLAND);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ITERABLE_JTS_RECTANGLES = new ArrayList<Geometry>();
		try {
			((List<Geometry>) ITERABLE_JTS_RECTANGLES).add(reader
					.read("POLYGON((-5 -2, 5  -2, 5  1 ,-5 1, -5 -2))"));
			((List<Geometry>) ITERABLE_JTS_RECTANGLES).add(reader
					.read("POLYGON((7 7, 9 7, 9 9, 7 9, 7 7))"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BOUNDINGBOX_RECTANGLES = getBBox(ITERABLE_JTS_RECTANGLES);

		try {
			IMAGE_URL = Thread.currentThread().getContextClassLoader()
					.getResource("image/image.png").toURI().toString();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	public static String getPoint_WKT(double x, double y) {
		return new StringBuilder().append("POINT(").append(getXY(x, y))
				.append(")").toString();
	}

	public static String getMultiPoint_WKT(double x, double y) {
		return new StringBuilder().append("MULTIPOINT(")
				.append(getXY(x - .4, y - .4)).append(",")
				.append(getXY(x, y + .4)).append(getXY(x + .4, y - .4))
				.append(")").toString();
	}

	public static String getLineString_WKT(double x, double y) {
		return new StringBuilder().append("LINESTRING(").append(getXY(x, y))
				.append(")").toString();
	}

	public static String getMultiLineString_WKT(double x, double y) {
		return new StringBuilder().append("MULTILINESTRING(")
				.append(getXY(x - .4, y - .4)).append(",")
				.append(getXY(x, y + .4)).append(getXY(x + .4, y - .4))
				.append(")").toString();
	}

	public static String getPolygon_WKT(double x, double y) {
		return new StringBuilder().append("POLYGON(").append(getXY(x, y))
				.append(")").toString();
	}

	public static String getMultiPolygon_WKT(double x, double y) {
		return new StringBuilder().append("MULTILPOLYGON(")
				.append(getXY(x - .4, y - .4)).append(",")
				.append(getXY(x, y + .4)).append(getXY(x + .4, y - .4))
				.append(")").toString();
	}

	public static String getPolygonWithIsland_WKT(double x, double y) {
		return new StringBuilder().append("POLYGON(").append(getXY(x, y))
				.append(")").toString();
	}

	public static String getMultiPolygonWithIsland_WKT(double x, double y) {
		return new StringBuilder().append("MULTIPOLYGON(")
				.append(getXY(x - .4, y - .4)).append(",")
				.append(getXY(x, y + .4)).append(getXY(x + .4, y - .4))
				.append(")").toString();
	}

	/**
	 * Renders the x and y coordinate.
	 * 
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 * @return The x an y coordinate.
	 */
	static String getXY(double x, double y) {
		return new StringBuilder().append(x).append(" ").append(y).toString();
	}

	/**
	 * Gets the overall enclosing envelope of all given geometries.
	 * 
	 * @param values
	 *            The geometries whose overall envelope should be retrieved.
	 * @return The overall enclosing envelope of all given geometries.
	 */
	static final Envelope getBBox(Iterable<Geometry> values) {
		Envelope bBox = null;
		for (Geometry entry : values) {
			if (bBox == null) {
				bBox = entry.getEnvelopeInternal();
			} else {
				bBox.expandToInclude(entry.getEnvelopeInternal());
			}
		}
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
 		Map<String, Object> map = new HashMap<String,Object>();
 		System.out.println(Thread.currentThread().getContextClassLoader().getResource("spatial/tm_world_borders_v0_3/TM_WORLD_BORDERS_SIMPL-0.3.shp") );
		map.put("url", Thread.currentThread().getContextClassLoader().getResource("spatial/tm_world_borders_v0_3/TM_WORLD_BORDERS_SIMPL-0.3.shp") );
		DataStore dataStore = DataStoreFinder.getDataStore(map);
		String typeName = dataStore.getTypeNames()[0];

		FeatureSource source = dataStore.getFeatureSource(typeName);

	 	FeatureCollection collection = source.getFeatures( );
		FeatureIterator iterator = collection.features();
		try {
			while (iterator.hasNext()) {
				Feature feature = (Feature) iterator.next();
			 		countries.add(new Country( (Geometry)feature.getDefaultGeometryProperty().getValue(),feature.getProperty("FIPS").getValue().toString(),feature.getProperty("ISO2").getValue().toString(),feature.getProperty("ISO3").getValue().toString(),feature.getProperty("NAME").getValue().toString(),Integer.valueOf(feature.getProperty("REGION").getValue().toString()), Integer.valueOf(feature.getProperty("SUBREGION").getValue().toString()),Integer.valueOf(feature.getProperty("UN").getValue().toString())));
	 
			}
		} finally {
		 
		}
		return countries;
	}
}
