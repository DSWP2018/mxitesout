package mx.iteso.ut;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito.*;

public class QuesadillaTest {
    Quesadilla quesadilla;
    Queso mockedQueso;
    Tortilla mockedTortilla;
    Tortilla mockedSecondTortilla;

    @Before
    public void setUp() {
        quesadilla = new Quesadilla();
        mockedQueso = mock(Queso.class);
        mockedTortilla = mock(Tortilla.class);
        mockedSecondTortilla = mock(Tortilla.class);
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setSecondTortilla(mockedSecondTortilla);


    }

  //  @Ignore
    @Test
    public void dobleQuesadillaPerfecta() {
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedSecondTortilla.isToasted()).thenReturn(true);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
        when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        assertEquals("Quesadilla Perfecta", quesadilla.prepareDouble());

        verify(mockedTortilla, times(1)).toast(true);
        verify(mockedSecondTortilla, times(1)).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }
   // @Ignore
    @Test
    public void quesadillaDobleFailed() {
        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedSecondTortilla.isToasted()).thenReturn(false);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(14);
        when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(14);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(14);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("Falló todo", quesadilla.prepareDouble());
        verify(mockedTortilla, never()).toast(true);
        verify(mockedSecondTortilla, never()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

   //@Ignore
    @Test
    public void quesadillaDobleSinTostar() {
        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedSecondTortilla.isToasted()).thenReturn(false);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(1, 2);
        when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(1, 2);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

        when(mockedQueso.getCurrentTemperature()).thenReturn(8, 10);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        assertEquals("No se tostó ninguna tortilla", quesadilla.prepareDouble());
        verify(mockedTortilla, never()).toast(true);
        verify(mockedSecondTortilla, never()).toast(true);
        verify(mockedQueso, times(1)).melt(true);
    }

    //@Ignore
        @Test
        public void quesadillaDobleTortillaQueso () {
            when(mockedQueso.isMelted()).thenReturn(false);
            when(mockedTortilla.isToasted()).thenReturn(false);
            when(mockedSecondTortilla.isToasted()).thenReturn(true);

            when(mockedTortilla.getCurrentTemperature()).thenReturn(1, 2);
            when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(8, 10);
            when(mockedTortilla.getToastTemperature()).thenReturn(10);
            when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

            when(mockedQueso.getCurrentTemperature()).thenReturn(8, 9);
            when(mockedQueso.getMeltingTemperature()).thenReturn(10);

            assertEquals("Tortilla 1 sin tostar y queso sin derretir",
                    quesadilla.prepareDouble());
            verify(mockedTortilla, never()).toast(true);
            verify(mockedSecondTortilla, times(1)).toast(true);
            verify(mockedQueso, never()).melt(true);
        }

        public void quesadillaDobleSecondTortillaQueso () {
            when(mockedQueso.isMelted()).thenReturn(false);
            when(mockedTortilla.isToasted()).thenReturn(true);
            when(mockedSecondTortilla.isToasted()).thenReturn(false);

            when(mockedTortilla.getCurrentTemperature()).thenReturn(8, 10);
            when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(4, 5);
            when(mockedTortilla.getToastTemperature()).thenReturn(10);
            when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

            when(mockedQueso.getCurrentTemperature()).thenReturn(8, 9);
            when(mockedQueso.getMeltingTemperature()).thenReturn(10);

            assertEquals("No se derritió el queso y la segunda tortilla no se tostó",
                    quesadilla.prepareDouble());
            verify(mockedTortilla, never()).toast(true);
            verify(mockedSecondTortilla, times(1)).toast(true);
            verify(mockedQueso, never()).melt(true);
        }

        public void quesadillaDobleSecondTortilla () {
            when(mockedQueso.isMelted()).thenReturn(true);
            when(mockedTortilla.isToasted()).thenReturn(true);
            when(mockedSecondTortilla.isToasted()).thenReturn(false);

            when(mockedTortilla.getCurrentTemperature()).thenReturn(8, 10);
            when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(8, 9);
            when(mockedTortilla.getToastTemperature()).thenReturn(10);
            when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

            when(mockedQueso.getCurrentTemperature()).thenReturn(8, 10);
            when(mockedQueso.getMeltingTemperature()).thenReturn(10);

            assertEquals("La segunda tortilla no se tostó",
                    quesadilla.prepareDouble());
            verify(mockedTortilla, times(1)).toast(true);
            verify(mockedSecondTortilla, never()).toast(true);
            verify(mockedQueso, times(1)).melt(true);
        }

        public void quesadillaDobleTortilla () {
            when(mockedQueso.isMelted()).thenReturn(true);
            when(mockedTortilla.isToasted()).thenReturn(false);
            when(mockedSecondTortilla.isToasted()).thenReturn(true);

            when(mockedTortilla.getCurrentTemperature()).thenReturn(8, 9);
            when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(8, 10);
            when(mockedTortilla.getToastTemperature()).thenReturn(10);
            when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

            when(mockedQueso.getCurrentTemperature()).thenReturn(8, 10);
            when(mockedQueso.getMeltingTemperature()).thenReturn(10);

            assertEquals("La primera tortilla no se tostó",
                    quesadilla.prepareDouble());
            verify(mockedTortilla, never()).toast(true);
            verify(mockedSecondTortilla, times(1)).toast(true);
            verify(mockedQueso, times(1)).melt(true);
        }

        public void quesadillaConDobleQueso () {
            when(mockedQueso.isMelted()).thenReturn(false);
            when(mockedTortilla.isToasted()).thenReturn(true);
            when(mockedSecondTortilla.isToasted()).thenReturn(true);

            when(mockedTortilla.getCurrentTemperature()).thenReturn(8, 10);
            when(mockedSecondTortilla.getCurrentTemperature()).thenReturn(8, 10);
            when(mockedTortilla.getToastTemperature()).thenReturn(10);
            when(mockedSecondTortilla.getToastTemperature()).thenReturn(10);

            when(mockedQueso.getCurrentTemperature()).thenReturn(8, 9);
            when(mockedQueso.getMeltingTemperature()).thenReturn(10);

            assertEquals("No se derritió el queso",
                    quesadilla.prepareDouble());
            verify(mockedTortilla, never()).toast(true);
            verify(mockedSecondTortilla, times(1)).toast(true);
            verify(mockedQueso, times(1)).melt(true);
        }

   //@Ignore
        @Test
        public void quesadillaPerfecta () {
            when(mockedQueso.isMelted()).thenReturn(true);
            when(mockedTortilla.isToasted()).thenReturn(true);
            when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
            when(mockedTortilla.getToastTemperature()).thenReturn(10);
            when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
            when(mockedQueso.getMeltingTemperature()).thenReturn(10);
            assertEquals("Perfect quesadilla", quesadilla.prepareSingle());
            verify(mockedTortilla, times(1)).toast(true);
            verify(mockedQueso, times(1)).melt(true);
        }

    //@Ignore
        @Test
        public void quesadillaBuena () {
            when(mockedQueso.isMelted()).thenReturn(true);
            when(mockedTortilla.isToasted()).thenReturn(false);
            when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
            when(mockedTortilla.getToastTemperature()).thenReturn(20);
            when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
            when(mockedQueso.getMeltingTemperature()).thenReturn(10);
            assertEquals("Good quesadilla", quesadilla.prepareSingle());
            verify(mockedTortilla, never()).toast(true);
            verify(mockedQueso, times(1)).melt(true);
        }

   // @Ignore
        @Test
        public void quesadillaTerrible () {
            when(mockedQueso.isMelted()).thenReturn(false);
            when(mockedTortilla.isToasted()).thenReturn(true);
            when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
            when(mockedTortilla.getToastTemperature()).thenReturn(10);
            when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
            when(mockedQueso.getMeltingTemperature()).thenReturn(20);
            assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
            verify(mockedTortilla, times(1)).toast(true);
            verify(mockedQueso, never()).melt(true);
        }

        //@Ignore
        @Test
        public void noHayGas () {
            when(mockedQueso.isMelted()).thenReturn(false);
            when(mockedTortilla.isToasted()).thenReturn(false);
            when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
            when(mockedTortilla.getToastTemperature()).thenReturn(1);
            when(mockedQueso.getCurrentTemperature()).thenReturn(2, 8, 8, 8, 14);
            when(mockedQueso.getMeltingTemperature()).thenReturn(1);
            assertEquals("You ran out of gas", quesadilla.prepareSingle());
            verify(mockedTortilla, never()).toast(true);
            verify(mockedQueso, never()).melt(true);
        }
    }
