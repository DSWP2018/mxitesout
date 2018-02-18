package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class QuesoAdoberaTest {
    QuesoAdobera quesoAdobera;

    @Before
    public void setUp(){
       quesoAdobera = new QuesoAdobera();
    }

    @Test
    public void testCurrentTemperature(){
        quesoAdobera.setCurrentTemperature(21);
        assertEquals(21,quesoAdobera.getCurrentTemperature());
    }

    @Test
    public void testFalseMelt(){
        quesoAdobera.melt(false);
        assertFalse(quesoAdobera.isMelted());
    }

    @Test
    public void testTrueMelt(){
        quesoAdobera.melt(true);
        assertTrue(quesoAdobera.isMelted());
    }
    @Test
    public void testMelting(){
        assertEquals(20, quesoAdobera.getMeltingTemperature());
    }
}
