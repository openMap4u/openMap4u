/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.symbol;

import java.awt.Paint;
import org.openmap4u.builder.ShapeBuilder;

/**
 *
 * @author Michael Hadrbolec
 */
public class Pie extends ShapeBuilder<Pie> {

    @Override
    public Pie strokeColor(Paint strokeColor) {
        return super.strokeColor(strokeColor);
    }

    @Override
    public Pie strokeFill(Paint strokeFill) {
        return super.strokeFill(strokeFill);
    }

    @Override
    public Pie strokeSize(double strokeSize) {
        return super.strokeSize(strokeSize);
    }

    public Pie radius(double radius, double start, double end) {
        return radius(0,radius,start,end);
    }
    
    public Pie radius(double innerRadius, double outerRadius, double start, double end) {
        return this;
    }

}
