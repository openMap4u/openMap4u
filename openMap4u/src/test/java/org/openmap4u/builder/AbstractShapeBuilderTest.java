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
 * @param <T>
 */
public abstract class AbstractShapeBuilderTest<T extends ShapeBuilder> extends AbstractBuilderTest<T> {

    /**
     *
     * @param actions
     * @param builder
     * @param index
     */
    @Override
    protected void setBuilder(Actions actions, T builder, int index) {
        super.setBuilder(actions, builder, index);
        if (actions.contains(MockupAction.STROKE_SIZE)) {
            builder.size((double)actions.getValues(MockupAction.STROKE_SIZE)[index]);
        }
        if (actions.contains(MockupAction.STROKE_COLOR)) {
            builder.color((Paint)actions.getValues(MockupAction.STROKE_COLOR)[index]);
        }
        if (actions.contains(MockupAction.STROKE_FILL)) {
            builder.fill((Paint)actions.getValues(MockupAction.STROKE_FILL)[index]);
        }
    }

    /**
     *
     * @return
     */
    @Override
    protected List<Actions> getActions() {
        super.getActions().add(new Actions("stroke size", STROKE_SIZE));
        super.getActions().add(new Actions("stroke color", STROKE_COLOR));
        super.getActions().add(new Actions("stroke fill", STROKE_FILL));
        return super.getActions();
    }
}
