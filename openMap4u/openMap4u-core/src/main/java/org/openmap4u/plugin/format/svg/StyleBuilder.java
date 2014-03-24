package org.openmap4u.plugin.format.svg;

import java.awt.Color;
import java.awt.Paint;
import org.openmap4u.commons.FontStyle;
import org.openmap4u.commons.FontWeight;
import org.openmap4u.commons.HorizontalAlign;
import static org.openmap4u.commons.HorizontalAlign.CENTER;
import static org.openmap4u.commons.HorizontalAlign.LEFT;
import static org.openmap4u.commons.HorizontalAlign.RIGHT;
import org.openmap4u.commons.Point.Align;
import org.openmap4u.commons.VerticalAlign;

/**
 *
 * @author Michael Hadrbolec
 */
class StyleBuilder {

    private static final String TEXT_ANCHOR = "text-anchor";
    private static final String START = "start";
    private static final String MIDDLE = "middle";
    private static final String END = "end";
    private static final String ALIGNMENT_BASELINE = "baseline-shift";
    private static final String TOP = "-100%";
    private static final String BOTTOM = "bottom";
    private static final String FONT_SIZE = "font-size";
    private static final String TEXT_COLOR = "fill";

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

    public double getDy(VerticalAlign align) {
        double dy = 0;
        if (align != null) {
            if (align == VerticalAlign.TOP) {
                dy= 1;
            } else if (align == VerticalAlign.MIDDLE) {
            dy= 0.5;
            } else if (align == VerticalAlign.BOTTOM) {
            dy=0;
            }
            /*   switch (position) {
             case LEFT_TOP:
             dy = 1;
             break;
             case CENTER_TOP:
             dy = 1;
             break;
             case RIGHT_TOP:
             dy = 1;
             break;
             case LEFT_MIDDLE:
             dy = 0.5;
             break;
             case CENTER_MIDDLE:
             dy = 0.5;
             break;
             case RIGHT_MIDDLE:
             dy = 0.5;
             break;
             case LEFT_BOTTOM:
             dy = 0;
             break;
             case CENTER_BOTTOM:
             dy = 0;
             break;
             case RIGHT_BOTTOM:
             dy = 0;
             break;
             default:
             dy = 0;
             break;
             } */
        }
        return dy;
    }

    /**
     * Gets the paint.
     *
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
    public StyleBuilder setTextAlign(Align align) {
        if (align != null) {
            if (align.getX() == HorizontalAlign.LEFT) {
                write(TEXT_ANCHOR, START);

            } else if (align.getX() == HorizontalAlign.CENTER) {
                write(TEXT_ANCHOR, MIDDLE);

            } else if (align.getX() == HorizontalAlign.RIGHT) {
                write(TEXT_ANCHOR, END);

            }

            if (align.getY() == VerticalAlign.TOP) {
                write(ALIGNMENT_BASELINE, TOP);

            } else if (align.getY() == VerticalAlign.MIDDLE) {
                write(ALIGNMENT_BASELINE, MIDDLE);

            } else if (align.getY() == VerticalAlign.BOTTOM) {
                write(ALIGNMENT_BASELINE, BOTTOM);

            }

            /*    case LEFT_TOP:
             write(ALIGNMENT_BASELINE, TOP);
             write(TEXT_ANCHOR, START);
             break;
             case CENTER_TOP:
             write(ALIGNMENT_BASELINE, TOP);
             write(TEXT_ANCHOR, MIDDLE);
             break;
             case RIGHT_TOP:
             write(ALIGNMENT_BASELINE, TOP);
             write(TEXT_ANCHOR, END);
             break;
             case LEFT_MIDDLE:
             write(ALIGNMENT_BASELINE, MIDDLE);
             write(TEXT_ANCHOR, START);
             break;
             case CENTER_MIDDLE:
             write(ALIGNMENT_BASELINE, MIDDLE);
             write(TEXT_ANCHOR, MIDDLE);
             break;
             case RIGHT_MIDDLE:
             write(ALIGNMENT_BASELINE, MIDDLE);
             write(TEXT_ANCHOR, END);
             break;
             case LEFT_BOTTOM:
             write(ALIGNMENT_BASELINE, BOTTOM);
             write(TEXT_ANCHOR, START);
             break;
             case CENTER_BOTTOM:
             write(ALIGNMENT_BASELINE, BOTTOM);
             write(TEXT_ANCHOR, MIDDLE);
             break;
             case RIGHT_BOTTOM:
             write(ALIGNMENT_BASELINE, BOTTOM);
             write(TEXT_ANCHOR, END);
             break;
             default:
             break;
             }*/
        }

        return this;
    }

    @Override
    public String toString() {
        return this.mSb.toString();
    }

    /**
     * Writes the font size.
     *
     * @param fontSize The font size.
     * @return The style builder.
     */
    public StyleBuilder setFontSize(double fontSize) {
        write(FONT_SIZE,
                new StringBuilder().append(fontSize).append("pt").toString());
        return this;
    }

    /**
     * Writes the font color.
     *
     * @param fontColor The font color.
     * @return The style builder.
     */
    public StyleBuilder setTextColor(Paint fontColor) {
        write(TEXT_COLOR, getPaint(fontColor));
        return this;
    }

    /**
     * Writes the font style.
     *
     * @param fontStyle The font style.
     * @return The style builder.
     */
    public StyleBuilder setFontStyle(FontStyle fontStyle) {
        return this;

    }

    /**
     * Writes the font weight.
     *
     * @param fontWeight The font weight.
     * @return The style builder.
     */
    public StyleBuilder setFontWeight(FontWeight fontWeight) {
        return this;

    }

    /**
     * Writes the font family.
     *
     * @param fontFamily The font family.
     * @return The style builder.
     */
    public StyleBuilder setFontFamily(String fontFamily) {
        return this;

    }

}
