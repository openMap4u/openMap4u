/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.awt.Paint;
import org.openmap4u.builder.ShapeBuilder;

/**
 *
 * @author Michael Hadrbolec
 */
public class LineChart extends ShapeBuilder<LineChart> {

  
    /**
     * Sets the stroke color.
     *
     * @param strokeColor The stroke color.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public LineChart color(Paint strokeColor) {
        return super.color(strokeColor);
    }
 
    /**
     * Sets the stroke size in stroke units.
     *
     * @param strokeSize The stroke size in stroke units.
     * @return The builder itself (method chaining pattern).
     */
    @Override
    public LineChart size(double strokeSize) {
        return super.size(strokeSize);
    }

   
    /**
     * Sets the end point of the line.
     *
     * @param toX The line end point x coordinate.
     * @param toY The lien end point y coordinate.
     * @return The builder itself (method chaining pattern).
     */
    public LineChart to(double toX, double toY) {
        return super.lineTo(toX, toY);
    }
    
      /**
     * Sets the end point of the line.
     *
     * @param fromX The line start point x coordinate.
     * @param fromY The line start point y coordinate.
     * @return The builder itself (method chaining pattern).
     */
    public LineChart from(double fromX, double fromY) {
        return super.moveTo(fromX, fromY);
    }

    public final LineChart lineTo(double toX, double toY) {
        return super.lineTo(toX, toY);
    }
    
     public final LineChart lineTo(double toX, double [] toY) {
        return null;// super.lineTo(toX, toY);
    }
     
      public final LineChart lineTo(double [] toX, double toY) {
        return null;// super.lineTo(toX, toY);
    }
     
   

    

}
