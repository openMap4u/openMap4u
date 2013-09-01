package org.openmap4u.builder;

import java.awt.geom.Path2D;

import com.vividsolutions.jts.awt.IdentityPointTransformation;
import com.vividsolutions.jts.awt.ShapeWriter;
import com.vividsolutions.jts.geom.Geometry;

/**
 * The abstract base classs from which the WKB and WKT implementations are
 * derived.
 *
 * @author Michael Hadrbolec
 */
abstract class AbstractJts<T extends AbstractJts<T>> extends ShapeBuilder<T> {

    /**
     * Stores the shape writer.
     */
    private ShapeWriter mShapeWriter = null;

    /**
     * Sets a JTS geometry.
     *
     * @param jtsGeometry The JTS geometry.
     * @return The Shape itself (method chaining pattern).
     */
    protected AbstractJts<T> setJTS(Geometry jtsGeometry) {
        if (this.mShapeWriter == null) {
            this.mShapeWriter = new ShapeWriter(
                    new IdentityPointTransformation());
        }
        setPrimitive(new Path2D.Double(this.mShapeWriter.toShape(jtsGeometry)));
        return this;
    }

}
