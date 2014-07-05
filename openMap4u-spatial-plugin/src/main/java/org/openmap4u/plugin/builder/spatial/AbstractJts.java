/**
 * This file is part of openMap4u Spatial Plugin.
 *
 * openMap4u Spatial Plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * openMap4u Spatial Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with openMap4u Spatial Plugin. If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * This file is part of openMap4u Spatial Plugin.
 *
 * openMap4u Spatial Plugin is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * openMap4u Spatial Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with openMap4u Spatial Plugin. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.openmap4u.plugin.builder.spatial;

import java.awt.geom.Path2D;

import com.vividsolutions.jts.awt.IdentityPointTransformation;
import com.vividsolutions.jts.awt.ShapeWriter;
import com.vividsolutions.jts.geom.Geometry;
import java.awt.Paint;
import org.openmap4u.builder.ShapeBuilder;

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
    protected T setJTS(Geometry jtsGeometry) {
        if (this.mShapeWriter == null) {
            this.mShapeWriter = new ShapeWriter(
                    new IdentityPointTransformation());
        }
        shape(new Path2D.Double(this.mShapeWriter.toShape(jtsGeometry)));
        return (T)this;
    }

    @Override
    public T color(Paint strokeColor) {
        return (T) super.color(strokeColor);
    }

    @Override
    public T size(double strokeSize) {
        return (T) super.size(strokeSize);
    }

    @Override
    public T fill(Paint fill) {
        return (T) super.fill(fill);
    }

}
