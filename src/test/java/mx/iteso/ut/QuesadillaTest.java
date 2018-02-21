package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class QuesadillaTest{

    Quesadilla quesadilla,nueva_quesadilla,otra_quesadilla;

    Queso mockedQueso;
    /*Queso1 mockedQueso1;
    Queso2 mockedQueso2;*/

    Tortilla mockedTortilla;
   /* Tortilla1 mockedTortilla1;
    Tortilla2 mockedTortilla2;*/

    /** */
    @Before
    public void setUp() throws Exception {
        quesadilla = new Quesadilla();
       /* nueva_quesadilla = new Quesadilla();
        otra_quesadilla = new Quesadilla();*/

        mockedTortilla = mock(Tortilla.class);
        mockedQueso = mock(Queso.class);


        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
    }
    /** */
    @Test
    public void quesadillaPerfecta() throws Exception {
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(true); //expected melt
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(10);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(10);
        assertEquals("Perfect quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedQueso,times(1)).melt(true);

    }
    /** */
    @Test
    public void quesadillaBuena() throws Exception {
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(true); //expected melt
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(20);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(10);
        assertEquals("Good quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,times(1)).melt(true);

    }
    /** */
    @Test
    public void quesadillaTerrible() throws Exception {
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(false); //expected melt
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(10);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(20);
        assertEquals("Terrible quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedQueso,never()).melt(true);

    }
    /** */
    @Test
    public void noHayGas() throws Exception {
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(false); //expected melt
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(1);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(1);
        assertEquals("You ran out of gas",quesadilla.prepareSingle());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,never()).melt(true);


    }
}