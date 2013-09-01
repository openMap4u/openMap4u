package org.openmap4u.plugin.builder.symbol;

import java.util.List;

import org.openmap4u.builder.AbstractShapeBuilderTest;
 
public class CircleTest extends AbstractShapeBuilderTest {

   

    @Override
    protected Circle getBuilder() {
       return this.getDefaultOpenMap4u().getBuilder().getCustomBuilder(Circle.class);
    }

    @Override
    protected List getActions() {
        return super.getActions();
    }
}
