/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u;

import java.util.function.Function;

/**
 *
 * @author zwotti
 */
public class Test<T> {

    public void functionT(Function<String, Double> function) {
        functionT(3d);
    }

    public void functionT(double function) {
        functionT(  e -> +1d);
   
   }
    
}
