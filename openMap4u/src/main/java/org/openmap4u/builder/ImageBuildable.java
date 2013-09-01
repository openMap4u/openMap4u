/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import java.nio.file.Path;
import org.openmap4u.style.ImageStyleable;

/**
 *
 * @author Michael Hadrbolec
 * @param <B>
 */
public interface ImageBuildable<B extends ImageBuildable<B>> extends Buildable<Path,ImageStyleable,B> {
    
}
