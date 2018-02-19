package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple Quesadilla.
 */
public class QuesadillaTest{
    Quesadilla quesadilla;
    Queso mockedQueso;
    Tortilla mockedTortilla;

    // Preparar la clase para el test
    @Before
    public void setUp(){
        quesadilla = new Quesadilla();
        mockedTortilla = mock(Tortilla.class);
        mockedQueso = mock(Queso.class);
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setHeatLevel(4);
    }

    @Test
    public void perfectQuesadilla(){
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(true);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Perfect quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void goodQuesadilla(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Good quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void terribleQuesadilla(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);

        assertEquals("Terrible quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void noGas(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(1);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(1);

        assertEquals("You ran out of gas",quesadilla.prepareSingle());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

}
