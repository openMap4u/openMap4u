/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.commons;

import java.awt.geom.Dimension2D;

/**
 *
 * @author zwotti
 */
public class SizeImpl extends Dimension2D {
    
    private double mWidth;
    
private double mHeight;



    @Override
    public double getWidth() {
        return this.mWidth;
      }

    @Override
    public double getHeight() {
        return this.mHeight;
      }

    @Override
    public void setSize(double width, double height) {
        this.mWidth=width;
        this.mHeight=height;
      }
    
}
