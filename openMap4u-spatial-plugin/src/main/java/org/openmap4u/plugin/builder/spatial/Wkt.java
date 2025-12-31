package org.openmap4u.plugin.builder.spatial;

import org.openmap4u.commons.Util;

import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

/**
 * Supports the well known text format.
 * 
 * @author Michael Hadrbolec
 */
public final class Wkt extends AbstractJts<Wkt> {

    @Override
    protected Wkt self() {
        return this;
    }

    /**
     * Stores the wkb reader .
     */
    private WKTReader mWktReader = null;

    /**
     * Sets the WKB (Well Known Text) geometry.
     * 
     * @param wktGeometry
     *            The WKB (Well Known text) geometry.
     * @return The Wkt itself (method chaining pattern).
     */
    public Wkt wkt(String wktGeometry) {
        if (this.mWktReader == null) {
            this.mWktReader = new WKTReader();
        }
        try {
            setJTS(this.mWktReader.read(wktGeometry));
        } catch (ParseException e) {
            throw new IllegalArgumentException(Util.get().getMessage(
                    "error.api.canvas.invalid.wkt"), e);
        }
        return this;
    }

}
