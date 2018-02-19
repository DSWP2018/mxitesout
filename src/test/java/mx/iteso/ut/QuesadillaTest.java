package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito.*;

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
        quesadilla.setTortilla2(mockedTortilla2);
    }
    @Test
    public void quesadillaPerfecta(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(10);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(10);
        assertEquals("Perfect quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }
    @Test
    public void quesadillaBuena(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(20);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(10);
        assertEquals("Good quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }
    @Test
    public void quesadillaTerrible(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(10);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(20);
        assertEquals("Terrible quesadilla",quesadilla.prepareSingle());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedQueso,never()).melt(true);
    }
    @Test
    public void noHayGas(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(1);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(1);
        assertEquals("You ran out of gas",quesadilla.prepareSingle());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void quesadillaDoblePlusA(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(10);
        when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemp()).thenReturn(10);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(10);
        assertEquals("Tortilla 1 tostada, tortilla 2 tostada, queso derretido."
                ,quesadilla.prepareDouble());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void quesadillaDobleA(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(10);
        when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemp()).thenReturn(20);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(10);
        assertEquals("Tortilla 1 tostada, tortilla 2 no tostada, queso derretido."
                ,quesadilla.prepareDouble());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedTortilla2,never()).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void quesadillaDoblePlusB(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(20);
        when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemp()).thenReturn(10);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(10);
        assertEquals("Tortilla 1 no tostada, tortilla 2 tostada, queso derretido."
                ,quesadilla.prepareDouble());
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void quesadillaDobleB(){
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(20);
        when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemp()).thenReturn(20);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(10);
        assertEquals("Tortilla 1 no tostada, tortilla 2 no tostada, queso derretido."
                ,quesadilla.prepareDouble());
        verify(mockedTortilla2,never()).toast(true);
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,times(1)).melt(true);
    }

    @Test
    public void quesadillaDoblePlusC(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(10);
        when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemp()).thenReturn(10);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(20);
        assertEquals("Tortilla 1 tostada, tortilla 2 tostada, queso no derretido."
                ,quesadilla.prepareDouble());
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void quesadillaDobleC(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(20);
        when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemp()).thenReturn(10);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(20);
        assertEquals("Tortilla 1 no tostada, tortilla 2 tostada, queso no derretido."
                ,quesadilla.prepareDouble());
        verify(mockedTortilla2,times(1)).toast(true);
        verify(mockedTortilla,never()).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void quesadillaDoblePlusD(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(10);
        when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemp()).thenReturn(20);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(20);
        assertEquals("Tortilla 1 tostada, tortilla 2 no tostada, queso no derretido."
                ,quesadilla.prepareDouble());
        verify(mockedTortilla,times(1)).toast(true);
        verify(mockedTortilla2,never()).toast(true);
        verify(mockedQueso,never()).melt(true);
    }

    @Test
    public void quesadillaDobleSinGas(){
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla.getToastTemp()).thenReturn(0);
        when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedTortilla2.getToastTemp()).thenReturn(0);
        when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
        when(mockedQueso.getMeltingTemp()).thenReturn(0);
        assertEquals("You ran out of gas"
                ,quesadilla.prepareDouble());
        verify(mockedTortilla,never()).toast(true);
        verify(mockedTortilla2,never()).toast(true);
        verify(mockedQueso,never()).melt(true);
    }
}