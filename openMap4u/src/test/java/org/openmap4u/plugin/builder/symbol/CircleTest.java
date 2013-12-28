package org.openmap4u.plugin.builder.symbol;

import java.util.List;

import org.openmap4u.builder.AbstractShapeBuilderTest;
 
/**
 *
 * @author zwotti
 */
public class CircleTest extends AbstractShapeBuilderTest {

   

    @Override
    protected Circle getBuilder() {
       return this.getDefaultOpenMap4u().getBuilder(Circle.class);
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
