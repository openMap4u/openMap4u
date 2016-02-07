/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.geom;

import java.util.ArrayList;
import java.util.List;
import org.openmap4u.builder.Buildable;

/**
 *
 * @author zwotti
 */
public class Path2DBuilder implements Buildable<List<Path2DFragment>> {

    private List<Path2DFragment> path2D = new ArrayList<>();

    Path2DBuilder add(Path2DFragment path2DFragment) {
        this.path2D.add(path2DFragment);
        return this;
    }

    @Override
    public List<Path2DFragment> build() {
        return path2D;
    }

}
