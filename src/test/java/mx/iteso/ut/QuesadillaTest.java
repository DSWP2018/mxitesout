package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito.*;

/**
 * Unit test for simple Quesadilla.
 */
public class QuesadillaTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

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

    public QuesadillaTest(String testName )
    {
        super( testName );
    }

        @Test
        public void quesadillaDoblePerfecta(){
            when(mockedQueso.isMelted()).thenReturn(true);
            when(mockedTortilla.isToasted()).thenReturn(true);
            when(mockedTortilla2.isToasted()).thenReturn(true);
            when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla.getToastTemp()).thenReturn(10);
            when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla2.getToastTemp()).thenReturn(10);
            when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedQueso.getMeltingTemp()).thenReturn(10);
            assertEquals("Tortilla 1 tostada, tortilla 2 tostada y queso derretido."
                    ,quesadilla.prepareDouble());
            verify(mockedTortilla,times(1)).toast(true);
            verify(mockedTortilla2,times(1)).toast(true);
            verify(mockedQueso,times(1)).melt(true);
        }

        @Test
        public void quesadilla_2Mal(){
            when(mockedQueso.isMelted()).thenReturn(true);
            when(mockedTortilla.isToasted()).thenReturn(true);
            when(mockedTortilla2.isToasted()).thenReturn(false);
            when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla.getToastTemp()).thenReturn(10);
            when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla2.getToastTemp()).thenReturn(20);
            when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedQueso.getMeltingTemp()).thenReturn(10);
            assertEquals("Tortilla 1 tostada, tortilla 2 no tostada y queso derretido."
                    ,quesadilla.prepareDouble());
            verify(mockedTortilla,times(1)).toast(true);
            verify(mockedTortilla2,never()).toast(true);
            verify(mockedQueso,times(1)).melt(true);
        }

        @Test
        public void quesadilla_1Mal(){
            when(mockedQueso.isMelted()).thenReturn(true);
            when(mockedTortilla.isToasted()).thenReturn(false);
            when(mockedTortilla2.isToasted()).thenReturn(true);
            when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla.getToastTemp()).thenReturn(20);
            when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla2.getToastTemp()).thenReturn(10);
            when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedQueso.getMeltingTemp()).thenReturn(10);
            assertEquals("Tortilla 1 no tostada, tortilla 2 tostada y queso derretido."
                    ,quesadilla.prepareDouble());
            verify(mockedTortilla2,times(1)).toast(true);
            verify(mockedTortilla,never()).toast(true);
            verify(mockedQueso,times(1)).melt(true);
        }

        @Test
        public void quesadillaDoble_1_2Mal(){
            when(mockedQueso.isMelted()).thenReturn(true);
            when(mockedTortilla.isToasted()).thenReturn(false);
            when(mockedTortilla2.isToasted()).thenReturn(false);
            when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla.getToastTemp()).thenReturn(20);
            when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla2.getToastTemp()).thenReturn(20);
            when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedQueso.getMeltingTemp()).thenReturn(10);
            assertEquals("Tortilla 1 no tostada, tortilla 2 no tostada y queso derretido."
                    ,quesadilla.prepareDouble());
            verify(mockedTortilla2,never()).toast(true);
            verify(mockedTortilla,never()).toast(true);
            verify(mockedQueso,times(1)).melt(true);
        }

        @Test
        public void quesadilla_3Mal(){
            when(mockedQueso.isMelted()).thenReturn(false);
            when(mockedTortilla.isToasted()).thenReturn(true);
            when(mockedTortilla2.isToasted()).thenReturn(true);
            when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla.getToastTemp()).thenReturn(10);
            when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla2.getToastTemp()).thenReturn(10);
            when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedQueso.getMeltingTemp()).thenReturn(20);
            assertEquals("Tortilla 1 tostada, tortilla 2 tostada y queso no derretido."
                    ,quesadilla.prepareDouble());
            verify(mockedTortilla2,times(1)).toast(true);
            verify(mockedTortilla,times(1)).toast(true);
            verify(mockedQueso,never()).melt(true);
        }

        @Test
        public void quesadillaDoble_1_3Mal(){
            when(mockedQueso.isMelted()).thenReturn(false);
            when(mockedTortilla.isToasted()).thenReturn(false);
            when(mockedTortilla2.isToasted()).thenReturn(true);
            when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla.getToastTemp()).thenReturn(20);
            when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla2.getToastTemp()).thenReturn(10);
            when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedQueso.getMeltingTemp()).thenReturn(20);
            assertEquals("Tortilla 1 no tostada, tortilla 2 tostada y queso no derretido."
                    ,quesadilla.prepareDouble());
            verify(mockedTortilla2,times(1)).toast(true);
            verify(mockedTortilla,never()).toast(true);
            verify(mockedQueso,never()).melt(true);
        }

        @Test
        public void quesadilla_2_3Mal(){
            when(mockedQueso.isMelted()).thenReturn(false);
            when(mockedTortilla.isToasted()).thenReturn(true);
            when(mockedTortilla2.isToasted()).thenReturn(false);
            when(mockedTortilla.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla.getToastTemp()).thenReturn(10);
            when(mockedTortilla2.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedTortilla2.getToastTemp()).thenReturn(20);
            when(mockedQueso.getCurrentTemp()).thenReturn(2,8,8,8,14);
            when(mockedQueso.getMeltingTemp()).thenReturn(20);
            assertEquals("Tortilla 1 tostada, tortilla 2 no tostada y queso no derretido."
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
            assertEquals("Sin gas."
                    ,quesadilla.prepareDouble());
            verify(mockedTortilla,never()).toast(true);
            verify(mockedTortilla2,never()).toast(true);
            verify(mockedQueso,never()).melt(true);
        }
    }
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( QuesadillaTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
