/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.core;

/**
 * Draws a line.
 *
 * @author Michel Hadrbolec
 */
public class Line extends AbstractLine<Line> {

    /**
     * Draws a line
     *
     * @param fromX The x start coordinate.
     * @param fromY The y start coordinate.
     * @param toX The x end coordinate.
     * @param toY The y end coordinate.
     * @return The line itself (fluent interface pattern).
     */
    public Line line(double fromX, double fromY, double toX, double toY) {
        super.moveTo(fromX, fromY).lineTo(toX, toY);
        return this;
    }

    /**
     * Convenience class to draw a vertical line.
     */
    public static class Vertical extends AbstractLine<Vertical> {

        /**
         * Draws a vertical line from "x, fromY" to "x, toY". <img src="doc-files/verticalLine.png"  alt="">
         *
         * @param x The x coordinate.
         * @param fromY The y start coordinate.
         * @param toY The y end coordinate.
         * @return The vertical itself (fluent interface pattern).
         */
        public Vertical line(double x, double fromY, double toY) {
            super.moveTo(x, fromY).lineTo(x, toY);
            return this;
        }

        /**
         * Draws a vertical line at a given point with the provided length.
         * <img src="doc-files/verticalLineLength.png"  alt="">
         * @param length The length.
         * @return The vertical itself (fluent interface pattern).
         */
        public Vertical length(double length) {
            double dL = length / 2;
            return line(0, -dL, dL);
        }
    }

    /**
     * Convenience class to draw a horizontal line.
     */
    public static class Horizontal extends AbstractLine<Horizontal> {

        /**
         * Draws a horizontal line from "fromX, y" to "toX, y". <img src="doc-files/horizontalLine.png" alt="">
         *
         * @param fromX The start x coordinate.
         * @param toX The end x coordinate.
         * @param y The y end coordinate.
         * @return The horizontal itself (fluent interface pattern).
         */
        public Horizontal line(double fromX, double toX, double y) {
            super.moveTo(fromX, y).lineTo(toX, y);
            return this;
        }

        /**
         * Draws a horizontal line at a given point with the provided length.
         *
         * @param length The length. <img src="doc-files/horizontalLineLength.png"  alt="">
         * @return The vertical itself (fluent interface pattern).
         */
        public Horizontal length(double length) {
            double dL = length / 2;
            return line(  -dL, dL,0);
        }

    }

}
