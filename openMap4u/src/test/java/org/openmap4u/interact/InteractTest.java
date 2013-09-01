/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.interact;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author zwotti
 */
public class InteractTest {

    private Interactable mI = null;
    private static final String INTERACTION = "do it";

    @Before
    public void setUp() {
        this.mI = new Interact();
    }

    /**
     * Test of getMouseDown method, of class Interact.
     */
    @Test
    public void testSetAndGetMouseDown() {
        assertThat(mI.getMouseDown(), nullValue());
        mI.setMouseDown(INTERACTION);
        assertThat(mI.getMouseDown(), is(INTERACTION));
    }

    /**
     * Test of getMouseUp method, of class Interact.
     */
    @Test
    public void testSetAndGetMouseUp() {
        assertThat(mI.getMouseUp(), nullValue());
        mI.setMouseUp(INTERACTION);
        assertThat(mI.getMouseUp(), is(INTERACTION));
    }

    /**
     * Test of getMouseOver method, of class Interact.
     */
    @Test
    public void testSetAndGetMouseOver() {
        assertThat(mI.getMouseOver(), nullValue());
        mI.setMouseOver(INTERACTION);
        assertThat(mI.getMouseOver(), is(INTERACTION));
    }

    /**
     * Test of getMouseOut method, of class Interact.
     */
    @Test
    public void testSetAndGetMouseOut() {
        assertThat(mI.getMouseOut(), nullValue());
        mI.setMouseOut(INTERACTION);
        assertThat(mI.getMouseOut(), is(INTERACTION));
    }

    /**
     * Test of getClick method, of class Interact.
     */
    @Test
    public void testSetAndGetClick() {
        assertThat(mI.getClick(), nullValue());
        mI.setClick(INTERACTION);
        assertThat(mI.getClick(), is(INTERACTION));
    }

    /**
     * Test of getDblClick method, of class Interact.
     */
    @Test
    public void testSetAndGetDblClick() {
        assertThat(mI.getDblClick(), nullValue());
        mI.setDblClick(INTERACTION);
        assertThat(mI.getDblClick(), is(INTERACTION));
    }

    /**
     * Test of getTouchStart method, of class Interact.
     */
    @Test
    public void testSetAndGetTouchStart() {
        assertThat(mI.getTouchStart(), nullValue());
        mI.setTouchStart(INTERACTION);
        assertThat(mI.getTouchStart(), is(INTERACTION));
   }

    

    /**
     * Test of getTouchEnd method, of class Interact.
     */
    @Test
    public void testSetAndGetTouchEnd() {
        assertThat(mI.getTouchEnd(), nullValue());
        mI.setTouchEnd(INTERACTION);
        assertThat(mI.getTouchEnd(), is(INTERACTION));
   }

   

    /**
     * Test of getTouchEnter method, of class Interact.
     */
    @Test
    public void testSetAndGetTouchEnter() {
        assertThat(mI.getTouchEnter(), nullValue());
        mI.setTouchEnter(INTERACTION);
        assertThat(mI.getTouchEnter(), is(INTERACTION));
   }

  

    /**
     * Test of getTouchLeave method, of class Interact.
     */
    @Test
    public void testSetAndGetTouchLeave() {
        assertThat(mI.getTouchLeave(), nullValue());
        mI.setTouchLeave(INTERACTION);
        assertThat(mI.getTouchLeave(), is(INTERACTION));
   }

    

    /**
     * Test of getTouchCancel method, of class Interact.
     */
    @Test
    public void testSetAndGetTouchCancel() {
          assertThat(mI.getTouchCancel(), nullValue());
        mI.setTouchCancel(INTERACTION);
        assertThat(mI.getTouchCancel(), is(INTERACTION));
 }

  
}