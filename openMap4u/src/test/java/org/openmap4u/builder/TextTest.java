/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import org.openmap4u.plugin.builder.core.Text;
import java.awt.Paint;
import java.util.List;

import org.junit.Before;
import org.openmap4u.builder.Action.MockupAction;
import org.openmap4u.style.FontStyle;

/**
 *
 * @author hadrbolec
 */
public class TextTest extends AbstractTextBuilderTest<Text> {

    private Text mText = null;

    /**
     *
     */
    @Before
    public void setUp() {
        this.mText = this.getDefaultOpenMap4u().getBuilder(Text.class);

    }

    /**
     *
     * @param actions
     * @param builder
     * @param index
     */
    @Override
    protected void setBuilder(Actions actions, Text builder, int index) {
        super.setBuilder(actions, builder, index);
        if (actions.contains(MockupAction.FONT_COLOR)) {
            builder.setFontColor((Paint) actions.getValues(MockupAction.FONT_COLOR)[index]);
        }
        if (actions.contains(MockupAction.FONT_SIZE)) {
            builder.setFontSize(Double.valueOf(actions.getValues(MockupAction.FONT_SIZE)[index].toString()));
        }
        if (actions.contains(MockupAction.FONT_STYLE)) {
            builder.setFontStyle((FontStyle) actions.getValues(MockupAction.FONT_STYLE)[index]);
        }
      if (actions.contains(MockupAction.FONT_FAMILY)) {
            builder.setFontFamily(  actions.getValues(MockupAction.FONT_FAMILY)[index].toString());
        }
     }

    @Override
    protected Text getBuilder() {
        return this.getDefaultOpenMap4u().getBuilder(Text.class).text("Äg").setFontSize(7);
    }

    /**
     *
     * @return
     */
    @Override
    protected List<Actions> getActions() {
        super.getActions().add(new Actions("font color", FONT_COLOR));
        super.getActions().add(new Actions("font size", FONT_SIZE));
        super.getActions().add(new Actions("font style", FONT_STYLE));
        super.getActions().add(new Actions("font family", FONT_FAMILY));
        return super.getActions();
    }
}