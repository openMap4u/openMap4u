/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.primitive;

import java.nio.file.Path;
import org.openmap4u.style.ImageStyleable;

/**
 * A raster image primitive.
 * @author Michael Hadrbolec.
 */
public interface ImageDrawable extends Drawable<ImageStyleable> {
    
    /**
     * Gets the path to the image.
     * @return The path to the image.
     */
    Path getPath();
    
}
