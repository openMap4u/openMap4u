/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.geom;

import java.awt.geom.Point2D;

/**
 *
 * @author zwotti
 */
abstract class ShapeItem {

    ShapeItem(double x, double y) {
        this.to = new Point2D.Double(x, y);
    }
    public Point2D.Double to;

}
