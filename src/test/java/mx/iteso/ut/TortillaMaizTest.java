package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TortillaMaizTest {
    TortillaMaiz tortillaMaiz;

    @Before
    public void setUp(){
        tortillaMaiz = new TortillaMaiz(50);
    }

    @Test
    public void testCurrentTemperature(){
        tortillaMaiz.setCurrentTemperature(25);
        assertEquals(25, tortillaMaiz.getCurrentTemperature());
    }
    @Test
    public void testFalseToast(){
        tortillaMaiz.toast(false);
        assertFalse(tortillaMaiz.isToasted());
    }
    @Test
    public void testTrueToast(){
        tortillaMaiz.toast(true);
        assertTrue(tortillaMaiz.isToasted());
    }
    @Test
    public void testToasted(){
        assertEquals(50, tortillaMaiz.getToastTemperature());
    }
}
