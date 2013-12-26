package org.openmap4u.plugin.format.svg;

import java.awt.Color;
import java.awt.Paint;

import org.openmap4u.style.FontStyle;
import org.openmap4u.commons.Position;
import org.openmap4u.style.FontWeight;

/**
 *
 * @author Michael Hadrbolec
 */
public class StyleBuilder {

    interface CONSTANTS {

        String TEXT_ANCHOR = "text-anchor";
        String START = "start";
        String MIDDLE = "middle";
        String END = "end";
        String ALIGNMENT_BASELINE = "alignment-baseline";
        String TOP = "top";
        String BOTTOM = "bottom";
        String FONT_SIZE = "font-size";
        String TEXT_COLOR = "fill";

    }
    /**
     * Stores the string builder.
     */
    private StringBuilder mSb = new StringBuilder();

    /**
     * Writes a key value pair.
     *
     * @param key The key.
     * @param value The value.
     * @return The style builder
     */
    public StyleBuilder write(String key, Object value) {
        if (key != null && value != null) {
            this.mSb.append(key).append(":").append(value).append(";");
        }
        return this;
    }

    /**
     * Writes the fill.
     *
     * @param paint The fill.
     * @return The style builder.
     */
    public StyleBuilder writeFill(Paint paint) {
        return write("fill", getPaint(paint));
    }

    /**
     * Writes the stroke.
     *
     * @param paint The sroke.
     * @return The style builder.
     */
    public StyleBuilder writeStroke(Paint paint) {
        return write("stroke", getPaint(paint));
    }

    /**
     * Writes the stroke width.
     *
     * @param strokeWidth The stroke width.
     * @return The style builder.
     */
    public StyleBuilder writeStrokeWidth(double strokeWidth) {
        return write("stroke-width", String.valueOf(strokeWidth));
    }

    /**
     * Writes the opacity.
     *
     * @param opacity The opacity.
     * @return The style builder.
     */
    public StyleBuilder writeOpacity(double opacity) {
        return write("opacity", String.valueOf(opacity));
    }

    /**
     * Gets the paint.
     * @param paint The paint.
     * @return The color as hex code.
     */
    String getPaint(Paint paint) {
        if (paint != null) {
            if (paint instanceof Color) {
                Color color = (Color) paint;
                return String.format("#%02x%02x%02x", color.getRed(),
                        color.getGreen(), color.getBlue());
            } else {
                return "#eaeaea";
            }
        } else {
            return null;
        }
    }

    /**
     * Sets the text align.
     *
     * @param align The align.
     * @return The style builder.
     */
    public StyleBuilder setTextAlign(Position align) {
        if (align != null) {
            switch (align) {
                case LeftTop:
                    write(CONSTANTS.ALIGNMENT_BASELINE, CONSTANTS.TOP);
                    write(CONSTANTS.TEXT_ANCHOR, CONSTANTS.START);
                    break;
                case CenterTop:
                    write(CONSTANTS.ALIGNMENT_BASELINE, CONSTANTS.TOP);
                    write(CONSTANTS.TEXT_ANCHOR, CONSTANTS.MIDDLE);
                    break;
                case RightTop:
                    write(CONSTANTS.ALIGNMENT_BASELINE, CONSTANTS.TOP);
                    write(CONSTANTS.TEXT_ANCHOR, CONSTANTS.END);
                    break;
                case LeftMiddle:
                    write(CONSTANTS.ALIGNMENT_BASELINE, CONSTANTS.MIDDLE);
                    write(CONSTANTS.TEXT_ANCHOR, CONSTANTS.START);
                    break;
                case CenterMiddle:
                    write(CONSTANTS.ALIGNMENT_BASELINE, CONSTANTS.MIDDLE);
                    write(CONSTANTS.TEXT_ANCHOR, CONSTANTS.MIDDLE);
                    break;
                case RightMiddle:
                    write(CONSTANTS.ALIGNMENT_BASELINE, CONSTANTS.MIDDLE);
                    write(CONSTANTS.TEXT_ANCHOR, CONSTANTS.END);
                    break;
                case LeftBottom:
                    write(CONSTANTS.ALIGNMENT_BASELINE, CONSTANTS.BOTTOM);
                    write(CONSTANTS.TEXT_ANCHOR, CONSTANTS.START);
                    break;
                case CenterBottom:
                    write(CONSTANTS.ALIGNMENT_BASELINE, CONSTANTS.BOTTOM);
                    write(CONSTANTS.TEXT_ANCHOR, CONSTANTS.MIDDLE);
                    break;
                case RightBottom:
                    write(CONSTANTS.ALIGNMENT_BASELINE, CONSTANTS.BOTTOM);
                    write(CONSTANTS.TEXT_ANCHOR, CONSTANTS.END);
                    break;
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return this.mSb.toString();
    }

    /**
     * Writes the font size.
     * @param fontSize The font size.
     * @return The style builder. 
     */
    public StyleBuilder setFontSize(double fontSize) {
        write(CONSTANTS.FONT_SIZE,
                new StringBuilder().append(fontSize).append("pt").toString());
        return this;
    }

    /**
     * Writes the font color.
     * @param fontColor The font color.
     * @return The style builder.
     */
    public StyleBuilder setTextColor(Paint fontColor) {
        write(CONSTANTS.TEXT_COLOR, getPaint(fontColor));
        return this;
    }

    /**
     * Writes the font style.
     * @param fontStyle The font style.
     * @return The style builder.
     */
    public StyleBuilder setFontStyle(FontStyle fontStyle) {
        return this;

    }

    /**
     * Writes the font weight.
     * @param fontWeight The font weight.
     * @return The style builder.
     */
    public StyleBuilder setFontWeight(FontWeight fontWeight) {
        return this;

    }

    /**
     * Writes the font family.
     * @param fontFamily The font family.
     * @return The style builder.
     */
    public StyleBuilder setFontFamily(String fontFamily) {
        return this;

    }

}
