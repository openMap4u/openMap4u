package org.openmap4u.plugin.builder.symbol;

import java.util.List;

import org.openmap4u.builder.AbstractShapeBuilderTest;

/**
 *
 * @author Michael Hadrbolec
 */
public class RectangleTest extends AbstractShapeBuilderTest {

    @Override
    protected Rectangle getBuilder() {
        return this.getDefaultOpenMap4u().get(Rectangle.class).setSize(1, .5);
    }

    /**
     *
     * @return
     */
    @Override
    protected List getActions() {
        return super.getActions();
    }
}
