/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmap4u.primitive;

import java.nio.file.Path;
import org.openmap4u.style.ImageStyleable;

/**
 *
 * @author zwotti
 */
public interface ImageDrawable extends Drawable<ImageStyleable> {
    
    Path getPath();
    
}
