/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.canvas;

import org.openmap4u.commons.Plugable;

/**
 * 
 * @author Michael Hadrbolec
 */
public interface Canvas  extends Plugable, SetUp, DrawOrWrite,
        SetAreaOfInterestOrDraw   {

}
