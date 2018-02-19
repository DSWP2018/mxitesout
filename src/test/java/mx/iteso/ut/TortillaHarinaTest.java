package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito.*;

public class TortillaHarinaTest {
    TortillaHarina tortillaHarina;

    @Before
    public void Setup() {
        tortillaHarina = new TortillaHarina();
    }

    @Test
    public void testCurrentTemperature(){
        tortillaHarina.setTemp(30);
        assertEquals(30, tortillaHarina.getCurrentTemp());
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
    public void testToasted(){
        assertEquals(9, tortillaHarina.getToastTemp());
    }
}
