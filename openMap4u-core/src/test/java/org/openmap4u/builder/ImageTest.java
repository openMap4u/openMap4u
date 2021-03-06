/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.builder;

import org.openmap4u.plugin.builder.core.Image;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;

 
/**
 *
 * @author hadrbolec
 */
public class ImageTest extends AbstractImageBuilderTest<Image> {

    private Path mImage = null;

    /**
     *
     */
    @Before
    public void setUp() {
        this.mImage = Paths.get("/image/image.png").getFileName();
    }
    
    

   
    void setBuilder(List<Actions> props2beSet, Image builder, double percent) {
        setBuilder(props2beSet, builder, percent);
    }

    @Override
    protected Image getBuilder() {
       return  this.getDefaultOpenMap4u().get(Image.class).path(mImage);
    }

    /**
     *
     * @return
     */
    @Override
    protected List<Actions> getActions() {
        return super.getActions();
    }
}