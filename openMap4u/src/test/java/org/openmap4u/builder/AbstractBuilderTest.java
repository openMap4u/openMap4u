/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import org.openmap4u.plugin.builder.core.Polygon;
import org.openmap4u.plugin.builder.core.Text;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openmap4u.AbstractOpenMap4uTest;
import org.openmap4u.OutputFormat;
import org.openmap4u.builder.Action.MockupAction;
import static org.openmap4u.builder.Action.MockupAction.ALIGN;
import org.openmap4u.DrawOrWrite;
import org.openmap4u.commons.FontStyle;
import org.openmap4u.commons.Position;
import org.openmap4u.plugin.builder.symbol.Cross;
import org.openmap4u.commons.Length;

/**
 * Base class for all builder plugin tests.
 *
 * @author Michael Hadrbolec
 * @param <T> The buildable type
 */
public abstract class AbstractBuilderTest<T extends Buildable> extends
        AbstractOpenMap4uTest {

    /**
     *
     */
    public final static Action<Paint> VISIBILITY = new Action(
            MockupAction.VISIBILITY, true, false, true, false, true, false, true, false, true, false, true);

    /**
     *
     */
    public final static Action<Paint> FONT_COLOR = new Action(
            MockupAction.FONT_COLOR, Color.BLACK, Color.BLUE, Color.CYAN,
            Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
            Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED);

    /**
     *
     */
    public final static Action<Double> FONT_SIZE = new Action(
            MockupAction.FONT_SIZE, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

    /**
     *
     */
    public final static Action<Double> OFFSET_X = new Action(
            MockupAction.OFFSET_X, -.5, -.4, -.3, -.2, -.1, 0d, .1, .2, .3, .4,
            .5);

    /**
     *
     */
    public final static Action<Double> OFFSET_Y = new Action(
            MockupAction.OFFSET_Y, -.5, -.4, -.3, -.2, -.1, 0d, .1, .2, .3, .4,
            .5);

    /**
     *
     */
    public final static Action<Double> SCALE_X = new Action(
            MockupAction.SCALE_X, .5, .6, .7, .8, .9, 1d, 1.1, 1.2, 1.3, 1.4,
            1.5);

    /**
     *
     */
    public final static Action<Double> SCALE_Y = new Action(
            MockupAction.SCALE_Y, .5, .6, .7, .8, .9, 1d, 1.1, 1.2, 1.3, 1.4,
            1.5);

    /**
     *
     */
    public final static Action<Double> ROTATE = new Action(MockupAction.ROTATE,
            0d, 36d, 72d, 108d, 144d, 180d, 216d, 252d, 288d, 324d, 360d);

    /**
     *
     */
    public final static Action<Double> TRANSPARENCE = new Action(
            MockupAction.OPACITY, 0d, 10d, 20d, 30d, 40d, 50d, 60d, 70d, 80d,
            90d, 100d);

    /**
     *
     */
    public final static Action<Double> STROKE_SIZE = new Action(
            MockupAction.STROKE_SIZE, .1, .2, .3, .4, .5, .6, .7, 0.8, .9,
            1.00000001, 1.1);

    /**
     *
     */
    public final static Action<Paint> STROKE_COLOR = new Action(
            MockupAction.STROKE_COLOR, Color.BLACK, Color.BLUE, Color.CYAN,
            Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
            Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED);

    /**
     *
     */
    public static final Action<Paint> STROKE_FILL = new Action(
            MockupAction.STROKE_FILL, Color.RED, Color.PINK, Color.ORANGE,
            Color.MAGENTA, Color.LIGHT_GRAY, Color.GREEN, Color.GRAY,
            Color.DARK_GRAY, Color.CYAN, Color.BLUE, Color.BLACK);

    /**
     *
     */
    public static final Action<Position> ALIGN = new Action(
            MockupAction.ALIGN, Position.LeftTop, Position.CenterTop, Position.RightTop,
            Position.LeftMiddle, Position.CenterMiddle, Position.RightMiddle, Position.LeftBottom, Position.CenterBottom, Position.RightBottom,Position.CenterTop, Position.RightTop);

    /**
     *
     */
    public static final Action<FontStyle> FONT_STYLE = new Action(
            MockupAction.FONT_STYLE, FontStyle.NORMAL, FontStyle.ITALIC,
            FontStyle.NORMAL, FontStyle.ITALIC, FontStyle.NORMAL, FontStyle.ITALIC, FontStyle.NORMAL, FontStyle.ITALIC,
            FontStyle.NORMAL, FontStyle.ITALIC, FontStyle.NORMAL);

    /**
     *
     */
    public static final Action<String> FONT_FAMILY = new Action(
            MockupAction.FONT_FAMILY, Font.SANS_SERIF, Font.SERIF, Font.DIALOG,
            MockupAction.FONT_FAMILY, Font.SANS_SERIF, Font.SERIF, Font.DIALOG,
            MockupAction.FONT_FAMILY, Font.SANS_SERIF, Font.SERIF, Font.DIALOG,
            Font.SANS_SERIF);
    private List<Actions> mActions = null;

    AbstractBuilderTest() {
        super();
        mActions = new ArrayList();
        mActions.add(new Actions("none"));
        mActions.add(new Actions("offset x", OFFSET_X));
        mActions.add(new Actions("offset y", OFFSET_Y));
        mActions.add(new Actions("scale x", SCALE_X));
        mActions.add(new Actions("scale y", SCALE_Y));
        mActions.add(new Actions("rotate", ROTATE));
        mActions.add(new Actions("offset scale", OFFSET_X, OFFSET_Y, SCALE_X,
                SCALE_Y));
        mActions.add(new Actions("offset rotate", OFFSET_X, OFFSET_Y, ROTATE));
        mActions.add(new Actions("offset scale rotate", OFFSET_X, OFFSET_Y,
                SCALE_X, SCALE_Y, ROTATE));
        mActions.add(new Actions("visible", VISIBILITY));
        mActions.add(new Actions("transparency", TRANSPARENCE));
        mActions.add(new Actions("align", ALIGN));
      }

    /**
     *
     * @return
     */
    protected List<Actions> getActions() {
        return mActions;
    }

    /**
     *
     * @param actions
     * @param builder
     * @param index
     */
    protected void setBuilder(Actions actions, T builder, int index) {
        if (actions.contains(MockupAction.OFFSET_X)) {
            builder.offsetX((double) actions
                    .getValues(MockupAction.OFFSET_X)[index]);
        }
        if (actions.contains(MockupAction.OFFSET_Y)) {
            builder.offsetY((double) actions
                    .getValues(MockupAction.OFFSET_Y)[index]);
        }
        if (actions.contains(MockupAction.SCALE_X)) {
            builder.scaleX((double) actions.getValues(MockupAction.SCALE_X)[index]);
        }
        if (actions.contains(MockupAction.SCALE_Y)) {
            builder.scaleY((double) actions.getValues(MockupAction.SCALE_Y)[index]);
        }
        if (actions.contains(MockupAction.ROTATE)) {
            builder.rotate((double) actions.getValues(MockupAction.ROTATE)[index]);
        }
        if (actions.contains(MockupAction.OPACITY)) {
            builder.transparence((double) actions
                    .getValues(MockupAction.OPACITY)[index]);
        }
        if (actions.contains(MockupAction.ALIGN)) {
            builder.align((Position) actions
                    .getValues(MockupAction.ALIGN)[index]);
        }
         if (actions.contains(MockupAction.VISIBILITY)) {
            builder.visible((boolean) actions
                    .getValues(MockupAction.VISIBILITY)[index]);
        }

    }

    /**
     * Gets the builder
     *
     * @return The builder.
     */
    protected abstract T getBuilder();

    /**
     * Gets the filename.
     *
     * @return The filename.
     */
    protected String getFileName() {
        return this.getClass().getName();

    }

    /**
     * Tests all configured actions.
     *
     * @throws IOException Is thrown in the case an error occurs.
     */
    @Test
    public void testBuilder() throws IOException {
        process(getActions(), getFileName());
    }

    final void process(List<Actions> actions, DrawOrWrite draw, String outputFileName)
            throws IOException {
        for (int row = 0; row < actions.size() + 1; row++) {
            /* draw horizontal raster line */
            draw.draw(this.getDefaultOpenMap4u().getBuilder(Polygon.class)
                    .color(Color.LIGHT_GRAY)
                    .size(0.3).moveTo(0, row * 2)
                    .lineTo(30, row * 2));
            /* draw the focus of the test */
            if (row < actions.size()) {
                draw.draw(this.getDefaultOpenMap4u().getBuilder(Text.class)
                        .size(5)
                        .point(23, row * 2 + 1)
                        .align(Position.LeftMiddle)
                        .text(actions.get(row).getDescription()));
            }
        }
        for (int column = 0; column < actions.size(); column++) {
            /* draw vertical raster line */
            if (column < 12) {
                draw.draw(this.getDefaultOpenMap4u().getBuilder(Polygon.class)
                        .color(Color.LIGHT_GRAY)
                        .size(0.3).moveTo(column * 2, 0)
                        .lineTo(column * 2, actions.size() * 2));
            }
            for (int row = 0; row < 11; row++) {
                /* draw a cross in each center */
                draw.draw(this.getDefaultOpenMap4u()
                        .getBuilder(Cross.class)
                        .point(row * 2 + 1, column * 2 + 1)
                        .size(0.1).setSize(.3));
                /* draw a cross in each center */

                draw.draw(this
                        .getDefaultOpenMap4u()
                        .getBuilder(Text.class)
                        .setFontColor(Color.GRAY)
                        .size(2.5)
                        .point(row * 2 + 1, column * 2 + 1)
                        .align(Position.LeftTop)
                        .offset(-.9, .9)
                        .text(
                                new StringBuilder().append(row).append("/")
                                .append(column).toString()));

            }
        }
        for (int column = 0; column < actions.size(); column++) {
            for (int row = 0; row < 11; row++) {
                T builder = getBuilder();
                builder.point(row * 2 + 1, column * 2 + 1);
                this.setBuilder(actions.get(column), builder, row);
                draw.draw(builder);
            }
        }
        /* write the result into the given */
        draw.write(getPackagePath( outputFileName));

    }

    /**
     * Internal convenieance method.
     *
     * @param actions The actions to be processed.
     * @param outputFileName The output filename.
     * @param outputFormat The output format.
     */
    final void process(List<Actions> actions, String outputFileName)
            throws IOException {
        double centerX = 6;
        double centerY = actions.size() / 2;
        double rotate = 30;
        double scale = .5;
        /* process initial */
        for (OutputFormat outputFormat : this.getOutputFormats()) {
            process(actions,
                    getCanvas(Length.CM, Length.CM, Length.MM,
                            outputFormat.getOutputableFormat(), 30,
                            (actions.size() + 1) * 2),
                    outputFormat.getFileneame("default", outputFileName));
            /* process new center */
            process(actions,
                    getCanvas(Length.CM, Length.CM, Length.MM,
                            outputFormat.getOutputableFormat(), 30,
                            (actions.size() + 1) * 2).center(centerX,
                            centerY),
                    outputFormat.getFileneame("offset", outputFileName));
            /* process scale */
            process(actions,
                    getCanvas(Length.CM, Length.CM, Length.MM,
                            outputFormat.getOutputableFormat(), 30,
                            (actions.size() + 1) * 2).scale(scale),
                    outputFormat.getFileneame("scale",
                            outputFileName));
            /* process rotate */
            process(actions,
                    getCanvas(Length.CM, Length.CM, Length.MM,
                            outputFormat.getOutputableFormat(), 30,
                            (actions.size() + 1) * 2).rotate(rotate),
                    outputFormat.getFileneame("rotate",
                            outputFileName));
            /* process offset scale */
            process(actions,
                    getCanvas(Length.CM, Length.CM, Length.MM,
                            outputFormat.getOutputableFormat(), 30,
                            (actions.size() + 1) * 2).center(centerX,
                            centerY).scale(scale),
                    outputFormat
                    .getFileneame("offset", "scale", outputFileName));
            /* process offset rotate */
            process(actions,
                    getCanvas(Length.CM, Length.CM, Length.MM,
                            outputFormat.getOutputableFormat(), 30,
                            (actions.size() + 1) * 2).center(centerX,
                            centerY).rotate(rotate),
                    outputFormat
                    .getFileneame("offset", "rotate", outputFileName));
            /* process offset sclae rotate */
            process(actions,
                    getCanvas(Length.CM, Length.CM, Length.MM,
                            outputFormat.getOutputableFormat(), 30,
                            (actions.size() + 1) * 2)
                    .center(centerX, centerY).scale(scale)
                    .rotate(rotate),
                    outputFormat.getFileneame(
                            "offset", "scale", "rotate", outputFileName)
            );
        }
    }
}
