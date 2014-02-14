package org.openmap4u.plugin.builder.symbol;

import java.util.List;

import org.openmap4u.builder.AbstractShapeBuilderTest;
 
/**
 *
 * @author zwotti
 */
public class CrossTest extends AbstractShapeBuilderTest {

     @Override
    protected Cross getBuilder() {
       return this.getDefaultOpenMap4u().get(Cross.class).setSize(1, .5);
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
