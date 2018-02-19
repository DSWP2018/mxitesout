package mx.iteso.ut;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TortillaHarinaTest {

    TortillaHarina tortillaHarina;

    @Before
    public void setUp(){
        tortillaHarina = new TortillaHarina();
    }

    @Test
    public void testCurrentTemperature(){
        tortillaHarina.setCurrentTemperature(21);
        Assert.assertEquals(21, tortillaHarina.getCurrentTemperature());
    }
    @Test
    public void testFalseToast(){
        tortillaHarina.toast(false);
        assertFalse(tortillaHarina.isToasted());
    }
    @Test
    public void testTrueToast(){
        tortillaHarina.toast(true);
        assertTrue(tortillaHarina.isToasted());
    }
    @Test
    public void testToasted(){
        Assert.assertEquals(45, tortillaHarina.getToastTemperature());
    }
}
