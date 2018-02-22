package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuesoOaxacaTest {
    QuesoOaxaca quesoOaxaca;

    @Before
    public void setUp(){
        quesoOaxaca = new QuesoOaxaca(25);
    }

    @Test
    public void testCurrentTemperature(){
        quesoOaxaca.setCurrentTemperature(21);
        assertEquals(21, quesoOaxaca.getCurrentTemperature());
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
        assertEquals(25, quesoOaxaca.getMeltingTemperature());
    }
}
