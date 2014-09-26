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
class Quad2 extends ShapeItem {

    Quad2(double cpX, double cpY, double toX, double toY) {
        super(toX, toY);
        this.cp = new Point2D.Double(cpX, cpY);
    }
    public Point2D.Double to;

    public Point2D.Double cp;

}
