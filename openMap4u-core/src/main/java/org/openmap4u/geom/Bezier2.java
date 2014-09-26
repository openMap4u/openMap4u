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
 class Bezier2 extends ShapeItem {

    Bezier2(double cp1X, double cp1Y, double cp2X, double cp2Y,double toX, double toY) {
        super(toX, toY);
        this.cp1 = new Point2D.Double(cp1X, cp1Y);
       this.cp2 = new Point2D.Double(cp2X, cp2Y);
    }
    public Point2D.Double cp1;
    
      public Point2D.Double cp2;

}
