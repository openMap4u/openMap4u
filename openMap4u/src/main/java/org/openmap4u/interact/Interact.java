/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.interact;

/**
 * 
 * @author Michael Hadrbolec
 */
public class Interact implements Interactable {

    private String mMouseDown = null;
    private String mMouseUp = null;
    private String mMouseOver = null;
    private String mMouseOut = null;
    private String mClick = null;
    private String mDblClick = null;
    private String mTouchStart = null;
    private String mTouchEnd = null;
    private String mTouchEnter = null;
    private String mTouchLeave = null;
    private String mTouchCancel = null;

    /**
     * @return the mouseDown
     */
    @Override
    public String getMouseDown() {
        return mMouseDown;
    }

    /**
     * @param mouseDown
     *            the mouseDown to set
     */
    @Override
    public void setMouseDown(String mouseDown) {
        this.mMouseDown = mouseDown;
    }

    /**
     * @return the mouseUp
     */
    @Override
    public String getMouseUp() {
        return mMouseUp;
    }

    /**
     * @param mouseUp
     *            the mouseUp to set
     */
    @Override
    public void setMouseUp(String mouseUp) {
        this.mMouseUp = mouseUp;
    }

    /**
     * @return the mouseOver
     */
    @Override
    public String getMouseOver() {
        return mMouseOver;
    }

    /**
     * @param mouseOver
     *            the mouseOver to set
     */
    @Override
    public void setMouseOver(String mouseOver) {
        this.mMouseOver = mouseOver;
    }

    /**
     * @return the mouseOut
     */
    @Override
    public String getMouseOut() {
        return mMouseOut;
    }

    /**
     * @param mouseOut
     *            the mouseOut to set
     */
    @Override
    public void setMouseOut(String mouseOut) {
        this.mMouseOut = mouseOut;
    }

    /**
     * @return the click
     */
    @Override
    public String getClick() {
        return mClick;
    }

    /**
     * @param click
     *            the click to set
     */
    @Override
    public void setClick(String click) {
        this.mClick = click;
    }

    /**
     * @return the dblClick
     */
    @Override
    public String getDblClick() {
        return mDblClick;
    }

    /**
     * @param dblClick
     *            the dblClick to set
     */
    @Override
    public void setDblClick(String dblClick) {
        this.mDblClick = dblClick;
    }

    /**
     * @return the touchStart
     */
    @Override
    public String getTouchStart() {
        return mTouchStart;
    }

    /**
     * @param touchStart
     *            the touchStart to set
     */
    @Override
    public void setTouchStart(String touchStart) {
        this.mTouchStart = touchStart;
    }

    /**
     * @return the touchEnd
     */
    @Override
    public String getTouchEnd() {
        return mTouchEnd;
    }

    /**
     * @param touchEnd
     *            the touchEnd to set
     */
    @Override
    public void setTouchEnd(String touchEnd) {
        this.mTouchEnd = touchEnd;
    }

    /**
     * @return the touchEnter
     */
    @Override
    public String getTouchEnter() {
        return mTouchEnter;
    }

    /**
     * @param touchEnter
     *            the touchEnter to set
     */
    @Override
    public void setTouchEnter(String touchEnter) {
        this.mTouchEnter = touchEnter;
    }

    /**
     * @return the touchLeave
     */
    @Override
    public String getTouchLeave() {
        return mTouchLeave;
    }

    /**
     * @param touchLeave
     *            the touchLeave to set
     */
    @Override
    public void setTouchLeave(String touchLeave) {
        this.mTouchLeave = touchLeave;
    }

    /**
     * @return the touchCancel
     */
    @Override
    public String getTouchCancel() {
        return mTouchCancel;
    }

    /**
     * @param touchCancel
     *            the touchCancel to set
     */
    @Override
    public void setTouchCancel(String touchCancel) {
        this.mTouchCancel = touchCancel;
    }
}
