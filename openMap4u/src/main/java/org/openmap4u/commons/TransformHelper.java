/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.commons;

/**
 * 
 * @author Michael Hadrbolec
 */
public final class TransformHelper {

    private double x = Double.NaN;
    private double y = Double.NaN;
    private double scaleX = 1;
    private double scaleY = 1;
    private double rotate = 0;

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x
     *            the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the scaleX
     */
    public double getScaleX() {
        return scaleX;
    }

    /**
     * @param scaleX
     *            the scaleX to set
     */
    public void setScaleX(double scaleX) {
        this.scaleX = scaleX;
    }

    /**
     * @return the scaleY
     */
    public double getScaleY() {
        return scaleY;
    }

    /**
     * @param scaleY
     *            the scaleY to set
     */
    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
    }

    /**
     * @return the rotate
     */
    public double getRotate() {
        return rotate;
    }

    /**
     * @param rotate
     *            the rotate to set
     */
    public void setRotate(double rotate) {
        this.rotate = rotate;
    }
}
