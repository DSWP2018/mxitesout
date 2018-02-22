package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class QuesadillaDobleTest {
    Queso       mockedQueso;
    Tortilla    mockedTortilla;
    Tortilla    mockedSecondTortilla;
    Quesadilla  quesadillaDoble;

    @Before
    public void setUp(){
        quesadillaDoble     = new Quesadilla();
        mockedQueso         = mock(Queso.class);
        mockedTortilla      = mock(Tortilla.class);
        mockedSecondTortilla = mock(Tortilla.class);

        quesadillaDoble.setQueso(mockedQueso);
        quesadillaDoble.setTortilla(mockedTortilla);
        quesadillaDoble.setSecondTortilla(mockedSecondTortilla);
    }

    @Test
    public void quesadillaPerfecta(){
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(2,8,14);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedSecondTortilla.isToasted()).thenReturn(true);

        assertEquals("Quesadilla doble perfecta", quesadillaDoble.prepareDouble());
        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, times(2)).toast(true);
        //verify(mockedSecondTortilla, times(1)).toast(true);
    }

    @Test
    public void quesadillaBuena(){
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(2,8,14);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedSecondTortilla.isToasted()).thenReturn(true);

        assertEquals("Quesadilla doble buena", quesadillaDoble.prepareDouble());
        verify(mockedQueso, never()).melt(true);
        verify(mockedTortilla, times(2)).toast(true);
        //verify(mockedSecondTortilla, times(1)).toast(true);
    }
    @Test
    public void quesadillaDecente(){
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedSecondTortilla.getToastTemperature()).thenReturn(20);

        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(2,8,14);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedSecondTortilla.isToasted()).thenReturn(false);

        assertEquals("Quesadilla doble decente", quesadillaDoble.prepareDouble());
        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, times(1)).toast(true);
        //verify(mockedSecondTortilla, times(1)).toast(true);
    }
    @Test
    public void quesadillaPasable(){
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedSecondTortilla.getToastTemperature()).thenReturn(20);

        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(2,8,14);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedSecondTortilla.isToasted()).thenReturn(false);

        assertEquals("Quesadilla doble pasable", quesadillaDoble.prepareDouble());
        verify(mockedQueso, never()).melt(true);
        verify(mockedTortilla, times(1)).toast(true);
        //verify(mockedSecondTortilla, times(1)).toast(true);
    }
    @Test
    public void quesadillaMala(){
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedSecondTortilla.getToastTemperature()).thenReturn(20);

        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,14);
        when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(2,8,8,14);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedSecondTortilla.isToasted()).thenReturn(false);

        assertEquals("Quesadilla doble mala", quesadillaDoble.prepareDouble());
        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, never()).toast(true);
        //verify(mockedSecondTortilla, times(1)).toast(true);


    }
    @Test
    public void outOfGas(){
        when(mockedQueso.getMeltingTemperature()).thenReturn(1);
        when(mockedTortilla.getToastTemperature()).thenReturn(1);
        when(mockedSecondTortilla.getToastTemperature()).thenReturn(1);

        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,14);
        when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(2,8,14);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedSecondTortilla.isToasted()).thenReturn(false);

        assertEquals("Se acabó el gas", quesadillaDoble.prepareDouble());
        verify(mockedQueso, never()).melt(true);
        verify(mockedTortilla, never()).toast(true);
        //verify(mockedSecondTortilla, times(1)).toast(true);
    }
}
