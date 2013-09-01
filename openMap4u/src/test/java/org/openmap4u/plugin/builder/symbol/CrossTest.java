package org.openmap4u.plugin.builder.symbol;

import java.util.List;

import org.openmap4u.builder.AbstractShapeBuilderTest;
 
public class CrossTest extends AbstractShapeBuilderTest {

     @Override
    protected Cross getBuilder() {
       return this.getDefaultOpenMap4u().getBuilder().getCustomBuilder(Cross.class).setSize(1, .5);
    }

    @Override
    protected List getActions() {
       return super.getActions();
    }

}
