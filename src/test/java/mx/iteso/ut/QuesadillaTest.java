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
    Tortilla mockedTortilla1;
    Tortilla mockedTortilla2;

    // Preparar la clase para el test
    @Before
    public void setUp(){
        quesadilla = new Quesadilla();

        mockedTortilla1 = mock(Tortilla.class);
        mockedTortilla2 = mock(Tortilla.class);
        mockedQueso = mock(Queso.class);

        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla1(mockedTortilla1);
        quesadilla.setTortilla2(mockedTortilla2);
    }

    @Test
    public void perfectQuesadilla(){
        when(mockedTortilla1.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(true);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Perfect quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla1,times(1)).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void goodQuesadilla(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla1.isToasted()).thenReturn(false);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Good quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla1,never()).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void terribleQuesadilla(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla1.isToasted()).thenReturn(true);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);

        assertEquals("Terrible quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla1,times(1)).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void noGas(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla1.isToasted()).thenReturn(false);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(1);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(1);

        assertEquals("You ran out of gas",quesadilla.prepareSingle());
        verify(mockedTortilla1,never()).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void perfectDouble(){
        when(mockedTortilla1.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(true);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(10);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Perfect double",quesadilla.prepareDouble());
        verify(mockedTortilla1,times(1)).toast(true);
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void almostPerfectDouble(){
        when(mockedTortilla1.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(true);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(15);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Almost a perfect double",quesadilla.prepareDouble());
        verify(mockedTortilla1,never()).toast(true);
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void terribleDouble(){
        when(mockedTortilla1.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(false);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(15);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(15);

        assertEquals("Terrible double",quesadilla.prepareDouble());
        verify(mockedTortilla1,never()).toast(true);
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void noGasForDouble(){
        when(mockedTortilla1.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(false);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(1);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(1);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(1);

        assertEquals("You ran out of gas",quesadilla.prepareDouble());
        verify(mockedTortilla1,never()).toast(true);
        verify(mockedTortilla2,never()).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void goodDouble(){
        when(mockedTortilla1.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(true);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(15);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(15);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Good double",quesadilla.prepareDouble());
        verify(mockedTortilla1,never()).toast(true);
        verify(mockedTortilla2,never()).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void badDouble(){
        when(mockedTortilla1.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(false);

        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla1.getToastTemperature()).thenReturn(13);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemperature()).thenReturn(13);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(15);

        assertEquals("Bad double",quesadilla.prepareDouble());
        verify(mockedTortilla1,times(1)).toast(true);
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedQueso,never()).melt(true);
    }



}
