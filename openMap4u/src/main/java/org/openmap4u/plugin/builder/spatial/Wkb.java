package org.openmap4u.plugin.builder.spatial;

import org.openmap4u.commons.Util;

import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBReader;

/**
 * Supports the well known binary geometry format.
 * 
 * @author Michael Hadrbolec
 */
public final class Wkb extends AbstractJts<Wkb> {

    /**
     * Stores the wkb reader .
     */
    private WKBReader mWkbReader = null;

    /**
     * Sets the WKB (Well Known Binary) geometry.
     * 
     * @param wkbGeometry
     *            The WKB (Well Known Binary) geometry.
     * @return The Shape itself (method chaining pattern).
     */
    public Wkb wkb(byte[] wkbGeometry) {
        if (this.mWkbReader == null) {
            this.mWkbReader = new WKBReader();
        }
        try {
            setJTS(this.mWkbReader.read(wkbGeometry));
        } catch (ParseException e) {
            throw new IllegalArgumentException(Util.get().getMessage(
                    "error.api.canvas.invalid.wkt"), e);
        }
        return this;
    }

}
