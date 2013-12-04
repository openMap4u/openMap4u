/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.plugin.builder.chart;

import java.util.stream.Stream;
import org.openmap4u.OpenMap4u;

/**
 *
 * @author Michael Hadrbolec.
 */
class AbstractPrimitiveBuilderTest {

    protected Stream<Double> getData() {
        return Stream.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d);
    }

    protected Stream<Double> getPieData() {
        return Stream.of(.1, .2, 0.3, 0.4);
    }

    /* 1. get an instance */
    protected static OpenMap4u oM4u = new OpenMap4u();

}
