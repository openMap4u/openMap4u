package org.openmap4u.builder;

import java.awt.Paint;

import org.openmap4u.primitive.TextPrimitive;
import org.openmap4u.style.TextStyleable;

/**
 * All text builder plugins are derifed from this abstract base class.
 * 
 * @author Michael Hadrbolec
 * @param <B>
 */
public abstract class TextBuilder<B extends TextBuilder<B>> extends
        AbstractBuilderPlugin<String, TextStyleable, B> implements
        TextPrimitive {

    B setFontColor(Paint fontColor) {
        this.getStyle().setFontColor(fontColor);
        return (B) this;
    }
}
