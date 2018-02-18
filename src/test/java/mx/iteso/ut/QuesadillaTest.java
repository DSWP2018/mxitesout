package mx.iteso.ut;


import org.junit.Test;
import org.junit.Before;
/**
 * Son estaticos para poder accederlos
 * sin hacer una instancia.
 */
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class QuesadillaTest
{
    Quesadilla quesadilla;
    Queso mockedQueso;
    Tortilla mockedTortilla;
    Tortilla mockedTortilla2;

    @Before
    public void setUp(){
        quesadilla = new Quesadilla();
        mockedQueso = mock(Queso.class);
        mockedTortilla = mock(Tortilla.class);
        mockedTortilla2 = mock(Tortilla.class);
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
    }
    @Test
    public void quesadillaPerfecta(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        assertEquals("Perfect quesadilla", quesadilla.prepareSingle());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }
    @Test
    public void quesadillaBuena(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        assertEquals("Good quesadilla", quesadilla.prepareSingle());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }
    @Test
    public void quesadillaTerrible(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedQueso,never()).melt(true);
    }
    @Test
    public void noHayGas(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(0,0,0,0,0);
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 0,0,0,0);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        assertEquals("You ran out of gas", quesadilla.prepareSingle());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void quesadillaDoblePerfecta(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        assertEquals("Perfect double quesadilla", quesadilla.prepareDouble());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }

    //tortilla 1 tostada, tortilla 2 tostada, queso no derretido (1, 1, 0).
    @Test
    public void quesadillaDobleTerrible(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        assertEquals("Terrible double quesadilla", quesadilla.prepareDouble());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

    //tortilla 1 no tostada, tortilla 2 tostada, queso derretido (0, 1, 1).
    @Test
    public void quesadillaDobleAceptable(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        assertEquals("Fair double quesadilla", quesadilla.prepareDouble());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }

    //tortilla 1 no tostada, tortilla 2 tostada, queso no derretido.
    @Test
    public void quesadillaDobleMediocre(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        assertEquals("Mediocre double quesadilla", quesadilla.prepareDouble());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

    //tortilla 1 no tostada, tortilla 2 no tostada, queso derretido
    @Test
    public void quesadillaDobleBuena(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        assertEquals("Good double quesadilla", quesadilla.prepareDouble());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedTortilla2,never()).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }
    @Test
    public void quesadillaDobleNoHayGas(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(0,0,0,0,0);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,0,0,0,0);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(0, 0,0,0,0);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        assertEquals("You ran out of gas", quesadilla.prepareDouble());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedTortilla2,never()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }
}

