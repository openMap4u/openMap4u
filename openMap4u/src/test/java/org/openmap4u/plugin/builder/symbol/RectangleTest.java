package org.openmap4u.plugin.builder.symbol;

import java.util.List;

import org.openmap4u.builder.AbstractShapeBuilderTest;

public class RectangleTest extends AbstractShapeBuilderTest {

    @Override
    protected Rectangle getBuilder() {
        return this.getDefaultOpenMap4u().getBuilder().getCustomBuilder(Rectangle.class).setSize(1, .5);
    }

    @Override
    protected List getActions() {
        return super.getActions();
    }
}
