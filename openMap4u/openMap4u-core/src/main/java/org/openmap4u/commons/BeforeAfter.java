package org.openmap4u.commons;

/**
 * 
 * @author hadrbolec
 * 
 */
public interface BeforeAfter {

    /**
     * Is called before each individual entry is processed. It can be used for
     * individual setup code.
     */
    void before();

    /**
     * Is called after each individual element is processed. It can be used for
     * individual cleanup code.
     */
    void after();

}
