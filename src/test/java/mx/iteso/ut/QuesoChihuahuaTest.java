package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito.*;

public class QuesoChihuahuaTest {
    QuesoChihuahua quesoChihuahua;

    @Before
    public void SetUp(){
        quesoChihuahua = new QuesoChihuahua();
    }

    @Test
    public void testCurrentTemperature(){
        quesoChihuahua.setTemp(21);
        assertEquals(21,quesoChihuahua.getCurrentTemp());
    }
    @Test
    public void testFalseMelt(){
        quesoChihuahua.melt(false);
        assertFalse(quesoChihuahua.isMelted());
    }
    @Test
    public void testTrueMelt(){
        quesoChihuahua.melt(true);
        assertTrue(quesoChihuahua.isMelted());
    }
    @Test
    public void testMelting(){
        assertEquals(20,quesoChihuahua.getMeltingTemp());
    }
}
