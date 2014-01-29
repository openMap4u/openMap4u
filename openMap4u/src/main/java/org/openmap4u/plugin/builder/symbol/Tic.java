/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.symbol;

import java.awt.Color;
import java.awt.Shape;
import org.openmap4u.builder.ShapeBuilder;

/**
 *
 * @author Michael Hadrbolec
 */
public abstract class Tic<T extends Tic<T>> extends ShapeBuilder<T> {

    protected double mLength = 1;

    public T color(Color color) {
        super.color(color);
        return (T)this;
    }

   /**
    * Sets the tic length in drawing units.
    * @param ticLength The tic length in darwing units.
    * @return 
    */
    public T length(double ticLength) {
        this.mLength = ticLength;
        return (T)this;
    }

    /**
     * 
     * @param ticSize
     * @return 
     */
    @Override
    public T size(double ticSize) {
        super.size(ticSize);
        return (T)this;
    }

    public static class Vertical extends Tic<Vertical> {

        @Override
        public Shape getShape() {
            double l = mLength / 2;
            this.moveTo(0, -l).lineTo(0, l);
            return super.getShape();
        }

    }

    public static class Horizontal extends Tic<Horizontal> {

        @Override
        public Shape getShape() {
            double l = mLength / 2;
            this.moveTo(-l, 0).lineTo(l, 0);
           return super.getShape();
        }

    }

}
