package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuesoManchegoTest {

    QuesoManchego quesoManchego;

    @Before
    public void setUp(){
        quesoManchego = new QuesoManchego();
    }

    @Test
    public void testCurrentTemperature(){
        quesoManchego.setCurrentTemperature(21);
        assertEquals(21, quesoManchego.getCurrentTemperature());
    }
    @Test
    public void testFalseMelt(){
        quesoManchego.melt(false);
        assertFalse(quesoManchego.isMelted());
    }
    @Test
    public void testTrueMelt(){
        quesoManchego.melt(true);
        assertTrue(quesoManchego.isMelted());
    }
    @Test
    public void testMelting(){
        assertEquals(50, quesoManchego.getMeltingTemperature());
    }
}
