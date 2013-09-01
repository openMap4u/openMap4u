/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openmap4u.builder.Action.MockupAction;

/**
 *
 * @author Michael Hadrbolec
 */
public class Actions {

    private List<Action<?>> mActions = new ArrayList<>();
    private String mDescription = null;

    Actions(String description, Action<?>... actions2BePerformed) {
        this.mDescription = description;
        for (Action<?> action : actions2BePerformed) {
            this.mActions.add(action);
        }
    }

    public List<Action<?>> getActions() {
        return this.mActions;
    }

    public boolean contains(MockupAction action) {
        for (Action act : mActions) {
            if (act.getDescription() == action) {
                return true;
            }
        }
        return false;
    }

    public Object[] getValues(MockupAction action) {
        for (Action act : mActions) {
            if (act.getDescription() == action) {
                return act.getValues();
            }
        }
        return null;
    }

    public String getDescription() {
        return this.mDescription;
    }
}
