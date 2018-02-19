package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple Quesadilla.
 */
public class QuesadillaTest
{
    Tortilla    mockedTortilla;
    Queso       mockedQueso;
    Quesadilla quesadilla;


    @Before
    public void setUp(){
        quesadilla = new Quesadilla();
        mockedTortilla = mock(Tortilla.class);
        mockedQueso = mock(Queso.class);

        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);

    }
    @Test
    public void quesadillaPerfecta(){
        when(mockedTortilla.getToastTemperature())    .thenReturn(10);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        when(mockedTortilla.getCurrentTemperature())  .thenReturn(2,8,8,8,14);
        when(mockedQueso.getCurrentTemperature()).thenReturn(   2,8,8,8,14);

            when(mockedTortilla.isToasted()).thenReturn(true);
             when(mockedQueso.isMelted()).thenReturn(true);
            //assertTrue(mockedQueso.isMelted() && mockedTortilla.isToasted());

        assertEquals("Perfect quesadilla", quesadilla.prepareSingle());
        verify(mockedTortilla, times(1)).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }
    @Test
    public void quesadillaBuena(){
        when(mockedTortilla.getToastTemperature())    .thenReturn(20);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        when(mockedTortilla.getCurrentTemperature())  .thenReturn(2,8,8,8,14);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);

        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(true);

        //assertTrue(mockedQueso.isMelted());
        //assertFalse(mockedTortilla.isToasted());

        assertEquals("Good quesadilla", quesadilla.prepareSingle());
        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, never()).toast(true);
    }
    @org.junit.Test
    public void quesadillaTerrible(){
        when(mockedTortilla.getToastTemperature())    .thenReturn(10);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);

        when(mockedTortilla.getCurrentTemperature())  .thenReturn(2,8,8,8,14);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);

        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(false);

        //assertTrue(mockedTortilla.isToasted());
        //assertFalse(mockedQueso.isMelted());

        assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
        verify(mockedTortilla, times(1)).toast(true);
        verify(mockedQueso, never()).melt(true);
    }
    @org.junit.Test
    public void noHayGas(){
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(false);

        when(mockedTortilla.getToastTemperature())    .thenReturn(1);
        when(mockedQueso.getMeltingTemperature()).thenReturn(1);
                //no hay manera que entre.
                //sin derretir ni tostar?
                //implementar nivel del gas
        when(mockedTortilla.getCurrentTemperature())  .thenReturn(2,8,8,8,14);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,8,8,8,14);

        //assertFalse(mockedQueso.isMelted() && mockedTortilla.isToasted());

        assertEquals("You ran out of gas", quesadilla.prepareSingle());
        verify(mockedTortilla, never()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

}
