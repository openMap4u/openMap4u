/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

/**
 *
 * @author hadrbolec
 */
public abstract class Point<T, V> {

    private T x;

    private V y;

    Point(T x, V y) {
        setX(x);
        setY(y);
    }

    /**
     * @return the x
     */
    public final T getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public final void setX(T x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public final V getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public final void setY(V y) {
        this.y = y;
    }

    /**
     * Horizontal and vertical aligned point.
     */
    public static class Align extends Point<org.openmap4u.commons.HorizontalAlign, org.openmap4u.commons.VerticalAlign> {

        public Align(org.openmap4u.commons.HorizontalAlign x, org.openmap4u.commons.VerticalAlign y) {
            super(x, y);
        }

    }

    /**
     * Not at all aligne point.
     */
    public static class Coord extends Point<Double, Double> {

        public Coord(Double x, Double y) {
            super(x, y);
        }
    }

    /**
     * Only horizontal aligned point.
     */
    public static class HorizontalAlign extends Point<org.openmap4u.commons.HorizontalAlign, Double> {

        public HorizontalAlign(org.openmap4u.commons.HorizontalAlign x, Double y) {
            super(x, y);
        }

    }

    /**
     * Only vertical aligned point.
     */
    public static class VerticalAlign extends Point<Double, org.openmap4u.commons.VerticalAlign> {

        /**
         * Creates a new only vertical aligned point.
         * @param x The x coordinate.
         * @param y The vertical alignment.
         */
        public VerticalAlign(Double x, org.openmap4u.commons.VerticalAlign y) {
            super(x, y);
        }

    }

}
