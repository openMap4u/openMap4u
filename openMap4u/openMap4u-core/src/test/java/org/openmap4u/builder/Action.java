/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

/**
 *
 * @author Michael Hadrbolec
 * @param <T>
 */
public class Action<T> {

    /**
     *
     */
    public enum MockupAction {

        /**
         *
         */
        OFFSET_X,

        /**
         *
         */
        OFFSET_Y,

        /**
         *
         */
        SCALE_X,

        /**
         *
         */
        SCALE_Y,

        /**
         *
         */
        ROTATE,

        /**
         *
         */
        OPACITY,

        /**
         *
         */
        ALIGN,

        /**
         *
         */
        STROKE_COLOR,

        /**
         *
         */
        STROKE_SIZE,

        /**
         *
         */
        STROKE_FILL,

        /**
         *
         */
        FONT_SIZE,

        /**
         *
         */
        FONT_STYLE,

        /**
         *
         */
        FONT_FAMILY,

        /**
         *
         */
        FONT_COLOR,

        /**
         *
         */
        VISIBILITY
    };
    /**
     * Stores the values.
     */
    private T[] mValues;
    
    /**
     * Stored the human readable description.
     */
    private MockupAction mDescription = null;

    Action(MockupAction description, T... values) {
        this.mDescription = description;
        this.mValues = values;
    }

    /**
     *
     * @return
     */
    public MockupAction getDescription() {
        return this.mDescription;
    }

    /**
     *
     * @return
     */
    public T[] getValues() {
        return this.mValues;
    }
}
