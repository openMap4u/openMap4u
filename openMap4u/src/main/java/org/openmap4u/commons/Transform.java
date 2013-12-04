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
public class Transform implements Transformable {

    private double mRotate = 0;

    private double mScaleX = 1;

    private double mScaleY = 1;

    @Override
    public double getRotate() {
        return this.mRotate;
    }

    @Override
    public double getScaleX() {
        return this.mScaleX;
    }

    @Override
    public double getScaleY() {
        return this.mScaleX;
    }

    public void setScaleX(double scaleX) {
        this.mScaleX = scaleX;
    }

    public void setScaleY(double scaleY) {
        this.mScaleX = scaleY;
    }

    public void setRotate(double angle) {
        this.mRotate = angle;
    }

}
