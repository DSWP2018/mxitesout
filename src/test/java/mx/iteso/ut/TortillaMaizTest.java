package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TortillaMaizTest {
    TortillaMaiz tortillaMaiz;

    @Before
    public void setUp(){
        tortillaMaiz = new TortillaMaiz();
    }
    @Test
    public void testCurrentTemperature(){
        tortillaMaiz.setCurrentTemperature(20);
        assertEquals(20, tortillaMaiz.getCurrentTemperature());
    }
    @Test
    public void testTrueToast(){
        tortillaMaiz.toast(true);
        assertTrue(tortillaMaiz.isToasted());
    }
    @Test
    public void testFalseToast(){
        tortillaMaiz.toast(false);
        assertFalse(tortillaMaiz.isToasted());
    }
    @Test
    public void testToasting(){
        assertEquals(25, tortillaMaiz.getToastTemperature());
    }
}
