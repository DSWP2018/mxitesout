package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TortillaHarinaTest {
    TortillaHarina tortillaHarina;

    @Before
    public void setUp(){
        tortillaHarina = new TortillaHarina();
}
    @Test
    public void testCurrentTemperature(){
        tortillaHarina.setCurrentTemperature(20);
        assertEquals(20, tortillaHarina.getCurrentTemperature());
    }
    @Test
    public void testTrueToast(){
        tortillaHarina.toast(true);
        assertTrue(tortillaHarina.isToasted());
    }
    @Test
    public void testFalseToast(){
        tortillaHarina.toast(false);
        assertFalse(tortillaHarina.isToasted());
    }
    @Test
    public void testToasting(){
        assertEquals(30, tortillaHarina.getToastTemperature());
    }
}
