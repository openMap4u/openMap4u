package org.openmap4u.plugin.format.svg;

import java.awt.Color;
import java.awt.Paint;

import org.openmap4u.style.FontStyle;
import org.openmap4u.commons.Position;

/**
 *
 * @author zwotti
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

    private StringBuilder mSb = new StringBuilder();

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public StyleBuilder write(String key, Object value) {
        if (key != null && value != null) {
            this.mSb.append(key).append(":").append(value).append(";");
        }
        return this;
    }

    /**
     *
     * @param paint
     * @return
     */
    public StyleBuilder writeFill(Paint paint) {
        return write("fill", getPaint(paint));
    }

    /**
     *
     * @param paint
     * @return
     */
    public StyleBuilder writeStroke(Paint paint) {
        return write("stroke", getPaint(paint));
    }

    /**
     *
     * @param strokeWidth
     * @return
     */
    public StyleBuilder writeStrokeWidth(double strokeWidth) {
        return write("stroke-width", String.valueOf(strokeWidth));
    }

    /**
     *
     * @param opacity
     * @return
     */
    public StyleBuilder writeOpacity(double opacity) {
        return write("opacity", String.valueOf(opacity));
    }

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

    public String toString() {
        return this.mSb.toString();
    }

    /**
     *
     * @param fontSize
     * @return
     */
    public StyleBuilder setFontSize(double fontSize) {
        write(CONSTANTS.FONT_SIZE,
                new StringBuilder().append(fontSize).append("pt").toString());
        return this;
    }

    /**
     *
     * @param fontColor
     * @return
     */
    public StyleBuilder setTextColor(Paint fontColor) {
        write(CONSTANTS.TEXT_COLOR, getPaint(fontColor));
        return this;
    }

    /**
     *
     * @param fontStyle
     * @return
     */
    public StyleBuilder setFontStyle(FontStyle fontStyle) {
        return this;

    }

    /**
     *
     * @param fontStyle
     * @return
     */
    public StyleBuilder setFontWeight(FontStyle fontStyle) {
        return this;

    }

    /**
     *
     * @param fontFamily
     * @return
     */
    public StyleBuilder setFontFamily(String fontFamily) {
        return this;

    }

}
