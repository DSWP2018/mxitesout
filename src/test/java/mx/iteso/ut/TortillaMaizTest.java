package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito.*;

public class TortillaMaizTest {
    TortillaMaiz tortillaMaiz;

    @Before
    public void Setup() {
        tortillaMaiz = new TortillaMaiz();
    }

    @Test
    public void testCurrentTemperature(){
        tortillaMaiz.setTemp(30);
        assertEquals(30, tortillaMaiz.getCurrentTemp());
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
    public void testToasted(){
        assertEquals(15, tortillaMaiz.getToastTemp());
    }
}
