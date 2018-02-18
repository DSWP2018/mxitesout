package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class QuesoOaxacaTest {
    QuesoOaxaca quesoOaxaca;

    @Before
    public void setUp(){
        quesoOaxaca = new QuesoOaxaca();
    }

    @Test
    public void testCurrentTemperature(){
        quesoOaxaca.setCurrentTemperature(23);
        assertEquals(23,quesoOaxaca.getCurrentTemperature());
    }

    @Test
    public void testFalseMelt(){
        quesoOaxaca.melt(false);
        assertFalse(quesoOaxaca.isMelted());
    }

    @Test
    public void testTrueMelt(){
        quesoOaxaca.melt(true);
        assertTrue(quesoOaxaca.isMelted());
    }
    @Test
    public void testMelting(){
        assertEquals(22, quesoOaxaca.getMeltingTemperature());
    }
}
