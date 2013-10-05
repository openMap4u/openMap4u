/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import java.awt.Paint;
import java.util.List;

import org.openmap4u.builder.Action.MockupAction;

/**
 *
 * @author hadrbolec
 */
public abstract class AbstractShapeBuilderTest<T extends ShapeBuilder> extends AbstractBuilderTest<T> {

    @Override
    protected void setBuilder(Actions actions, T builder, int index) {
        super.setBuilder(actions, builder, index);
        if (actions.contains(MockupAction.STROKE_SIZE)) {
            builder.strokeSize((double)actions.getValues(MockupAction.STROKE_SIZE)[index]);
        }
        if (actions.contains(MockupAction.STROKE_COLOR)) {
            builder.strokeColor((Paint)actions.getValues(MockupAction.STROKE_COLOR)[index]);
        }
        if (actions.contains(MockupAction.STROKE_FILL)) {
            builder.strokeFill((Paint)actions.getValues(MockupAction.STROKE_FILL)[index]);
        }
    }

    @Override
    protected List<Actions> getActions() {
        super.getActions().add(new Actions("stroke size", STROKE_SIZE));
        super.getActions().add(new Actions("stroke color", STROKE_COLOR));
        super.getActions().add(new Actions("stroke fill", STROKE_FILL));
        return super.getActions();
    }
}
