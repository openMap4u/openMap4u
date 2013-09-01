/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.interact;

/**
 * 
 * @author hadrbolec
 */
public interface Interactable {

    /**
     * @return the click
     */
    String getClick();

    /**
     * @return the dblClick
     */
    String getDblClick();

    /**
     * @return the mouseDown
     */
    String getMouseDown();

    /**
     * @return the mouseOut
     */
    String getMouseOut();

    /**
     * @return the mouseOver
     */
    String getMouseOver();

    /**
     * @return the mouseUp
     */
    String getMouseUp();

    /**
     * @return the touchCancel
     */
    String getTouchCancel();

    /**
     * @return the touchEnd
     */
    String getTouchEnd();

    /**
     * @return the touchEnter
     */
    String getTouchEnter();

    /**
     * @return the touchLeave
     */
    String getTouchLeave();

    /**
     * @return the touchStart
     */
    String getTouchStart();

    /**
     * @param click
     *            the click to set
     */
    void setClick(String click);

    /**
     * @param dblClick
     *            the dblClick to set
     */
    void setDblClick(String dblClick);

    /**
     * @param mouseDown
     *            the mouseDown to set
     */
    void setMouseDown(String mouseDown);

    /**
     * @param mouseOut
     *            the mouseOut to set
     */
    void setMouseOut(String mouseOut);

    /**
     * @param mouseOver
     *            the mouseOver to set
     */
    void setMouseOver(String mouseOver);

    /**
     * @param mouseUp
     *            the mouseUp to set
     */
    void setMouseUp(String mouseUp);

    /**
     * @param touchCancel
     *            the touchCancel to set
     */
    void setTouchCancel(String touchCancel);

    /**
     * @param touchEnd
     *            the touchEnd to set
     */
    void setTouchEnd(String touchEnd);

    /**
     * @param touchEnter
     *            the touchEnter to set
     */
    void setTouchEnter(String touchEnter);

    /**
     * @param touchLeave
     *            the touchLeave to set
     */
    void setTouchLeave(String touchLeave);

    /**
     * @param touchStart
     *            the touchStart to set
     */
    void setTouchStart(String touchStart);

}
