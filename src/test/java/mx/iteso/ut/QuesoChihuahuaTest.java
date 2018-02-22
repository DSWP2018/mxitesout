package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class QuesoChihuahuaTest {
    QuesoChihuahua quesoChihuahua;

    @Before
    public void setUp(){
        quesoChihuahua = new QuesoChihuahua();
    }

    @Test
    public void testCurrentTemperature(){
        quesoChihuahua.setCurrentTemperature(21);
        assertEquals(21,quesoChihuahua.getCurrentTemperature());
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
        assertEquals(20,quesoChihuahua.getMeltingTemperature());
    }

}