package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito.*;

public class QuesadillaTest {
    Quesadilla quesadilla;
    Queso mockedQueso;
    Tortilla mockedTortilla;
    Tortilla mockedTortilla2;

    @Before
    public void setUp() {
        quesadilla = new Quesadilla();
        mockedQueso = mock(Queso.class);
        mockedTortilla = mock(Tortilla.class);
        mockedTortilla2 = mock(Tortilla.class);
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setTortilla2(mockedTortilla2);
    }

    @Test
    public void quesadillaDoblePerfecta() {
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Quesadilla Perfecta", quesadilla.prepareDouble());
        verify(mockedTortilla, times(1)).toast(true);
        verify(mockedTortilla2, times(1)).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }

    @Test
    public void quesadillaDobleNadaLogrado() {
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(14);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Nada logrado", quesadilla.prepareDouble());
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla2, never()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

    @Test
    public void quesadillaDobleTortillasSinTostar() {
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(1,2);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(1,2);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(8, 10);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Ninguna tortilla tostada", quesadilla.prepareDouble());
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla2, never()).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }

    @Test
    public void quesadillaDobleTortillas1yQueso() {
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(1,2);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(8,10);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(8, 9);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Tortilla 1 sin tostar y queso sin derretir",
            quesadilla.prepareDouble());
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla2,  times(1)).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

    public void quesadillaDobleTortillas2yQueso() {
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(false);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(8,10);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(4,5);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(8, 9);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Tortilla 2 sin tostar y queso sin derretir",
            quesadilla.prepareDouble());
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla2,  times(1)).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

    public void quesadillaDobleTortilla2() {
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(false);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(8,10);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(8,9);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(8, 10);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Tortilla 2 sin tostar",
            quesadilla.prepareDouble());
        verify(mockedTortilla, times(1)).toast(true);
        verify(mockedTortilla2,  never()).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }

    public void quesadillaDobleTortilla1() {
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(8,9);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(8,10);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(8, 10);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Tortilla 1 sin tostar",
            quesadilla.prepareDouble());
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla2,  times(1)).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }

    public void quesadillaDobleQueso() {
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(8,10);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(8,10);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(8, 9);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Queso sin derretir",
            quesadilla.prepareDouble());
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla2,  times(1)).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }


    
    @Test
    public void quesadillaPerfecta(){
       when(mockedQueso.isMelted()).thenReturn(true);
       when(mockedTortilla.isToasted()).thenReturn(true);
       when(mockedTortilla.getCurrentTemperature()).thenReturn(2,8,8,8,14);
       when(mockedTortilla.getToastTemperature()).thenReturn(10);
       when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
       when(mockedQueso.getMeltingTemperature()).thenReturn(10);
       assertEquals("Perfect quesadilla",quesadilla.prepareSingle());
       verify(mockedTortilla,times(1)).toast(true);
       verify(mockedQueso,times(1)).melt(true);
    }
    @Test
    public void quesadillaBuena(){
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
    public void quesadillaTerrible(){
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
    public void noHayGas(){
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
