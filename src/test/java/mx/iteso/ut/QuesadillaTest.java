package mx.iteso.ut;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;*/

/**
 * Unit test for simple Quesadilla.
 *
 *
**/

public class QuesadillaTest{
    /*public Tortilla mock_tortilla= mock(Tortilla.class);
    public Queso mock_queso = mock(Queso.class);
    public Quesadilla quesadilla = new Quesadilla();*/
    @Mock
    Quesadilla quesadilla;
    Queso mockedQueso;
    Tortilla mockedTortilla;
    Tortilla mockedTortilla_2;


    @Before
    public void setUp (){
        /*quesadilla.setQueso(mock_queso);
        quesadilla.setTortilla_1(mock_tortilla);*/
        quesadilla = new Quesadilla();
        mockedTortilla = mock(Tortilla.class);
        mockedTortilla_2 = mock(Tortilla.class);
        mockedQueso = mock(Queso.class);
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla_1(mockedTortilla);
        quesadilla.setTortilla_2(mockedTortilla_2);
    }

    @Test
    public void perfectQuesadilla(){
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10,10,20);

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(10,10,20);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        Assert.assertEquals("Perfect quesadilla", quesadilla.prepareSingle());

        verify(quesadilla.getQueso(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(3)).getCurrentTemperature();

        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, times(1)).toast(true);

    }

    @Test
    public void goodQuesadilla(){
        when(mockedTortilla.getToastTemperature()).thenReturn(30);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10,10,20);

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(10,20,20);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        Assert.assertEquals("Good quesadilla", quesadilla.prepareSingle());

        verify(quesadilla.getQueso(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(3)).getCurrentTemperature();

        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, times(0)).toast(true);
    }


    @Test
    public void terribleQuesadilla(){
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10,10,20);

        when(mockedQueso.getMeltingTemperature()).thenReturn(30);
        when(mockedQueso.getCurrentTemperature()).thenReturn(10,20,20);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        Assert.assertEquals("Terrible quesadilla", quesadilla.prepareSingle());

        verify(quesadilla.getQueso(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(4)).getCurrentTemperature();

        verify(mockedQueso, times(0)).melt(true);
        verify(mockedTortilla, times(1)).toast(true);
    }

    @Test
    public void noQuesadilla(){
        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(20);

        when(mockedQueso.getMeltingTemperature()).thenReturn(10);
        when(mockedQueso.getCurrentTemperature()).thenReturn(20);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        Assert.assertEquals("You ran out of gas", quesadilla.prepareSingle());

        verify(quesadilla.getQueso(), times(1)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(0)).getCurrentTemperature();

        verify(mockedQueso, times(0)).melt(true);
        verify(mockedTortilla, times(0)).toast(true);
    }

    @Test
    public void perfectDoubleQuesadilla(){
        when(mockedTortilla.getToastTemperature()).thenReturn( 20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 15,20);

        when(mockedTortilla_2.getToastTemperature()).thenReturn(20);
        when(mockedTortilla_2.getCurrentTemperature()).thenReturn(10,15,20);

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(10,15,20);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla_2.isToasted()).thenReturn(true);

        Assert.assertEquals("Perfect quesadilla", quesadilla.prepareDouble());

        verify(quesadilla.getQueso(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(3)).getCurrentTemperature();
        verify(quesadilla.getTortilla_2(), times(3)).getCurrentTemperature();

        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, times(1)).toast(true);
        verify(mockedTortilla_2, times(1)).toast(true);
    }

    @Test
    public void quesoMeltedNoBothTortilla(){
        when(mockedTortilla.getToastTemperature()).thenReturn( 20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 12,14);

        when(mockedTortilla_2.getToastTemperature()).thenReturn(20);
        when(mockedTortilla_2.getCurrentTemperature()).thenReturn(10,12,14);

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(10,15,20);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla_2.isToasted()).thenReturn(false);

        Assert.assertEquals("Both tortillas not toasted but queso melted", quesadilla.prepareDouble());

        verify(quesadilla.getQueso(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(3)).getCurrentTemperature();
        verify(quesadilla.getTortilla_2(), times(3)).getCurrentTemperature();

        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, times(0)).toast(true);
        verify(mockedTortilla_2, times(0)).toast(true);
    }

    @Test
    public void toastedTortillaNoQueso(){
        when(mockedTortilla.getToastTemperature()).thenReturn( 20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 15,20);

        when(mockedTortilla_2.getToastTemperature()).thenReturn(20);
        when(mockedTortilla_2.getCurrentTemperature()).thenReturn(10,15,20);

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(10,12,14);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla_2.isToasted()).thenReturn(true);

        Assert.assertEquals("Tortillas toasted but queso not melted", quesadilla.prepareDouble());

        verify(quesadilla.getQueso(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_2(), times(3)).getCurrentTemperature();

        verify(mockedQueso, times(0)).melt(true);
        verify(mockedTortilla, times(1)).toast(true);
        verify(mockedTortilla_2, times(1)).toast(true);
    }

    @Test
    public void tortilla1Queso(){
        when(mockedTortilla.getToastTemperature()).thenReturn( 20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 15,22);

        when(mockedTortilla_2.getToastTemperature()).thenReturn(20);
        when(mockedTortilla_2.getCurrentTemperature()).thenReturn(10,12,14);

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(10,15,22);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla_2.isToasted()).thenReturn(false);

        Assert.assertEquals("Queso melted and tortilla 1 toasted but tortilla 2 not toasted", quesadilla.prepareDouble());

        verify(quesadilla.getQueso(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(3)).getCurrentTemperature();
        verify(quesadilla.getTortilla_2(), times(3)).getCurrentTemperature();

        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, times(1)).toast(true);
        verify(mockedTortilla_2, times(0)).toast(true);

    }

    @Test
    public void tortilla2Queso(){
        when(mockedTortilla.getToastTemperature()).thenReturn( 20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 12,14);

        when(mockedTortilla_2.getToastTemperature()).thenReturn(20);
        when(mockedTortilla_2.getCurrentTemperature()).thenReturn(10,15,22);

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(10,15,22);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla_2.isToasted()).thenReturn(true);

        Assert.assertEquals("Queso melted and tortilla 2 toasted but tortilla 1 not toasted", quesadilla.prepareDouble());

        verify(quesadilla.getQueso(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(3)).getCurrentTemperature();
        verify(quesadilla.getTortilla_2(), times(3)).getCurrentTemperature();

        verify(mockedQueso, times(1)).melt(true);
        verify(mockedTortilla, times(0)).toast(true);
        verify(mockedTortilla_2, times(1)).toast(true);

    }

    @Test
    public void justTortilla2(){
        when(mockedTortilla.getToastTemperature()).thenReturn( 20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 12,14);

        when(mockedTortilla_2.getToastTemperature()).thenReturn(20);
        when(mockedTortilla_2.getCurrentTemperature()).thenReturn(10,15,22);

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(10,12,14);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla_2.isToasted()).thenReturn(true);

        Assert.assertEquals("Queso not melted and tortilla 2 not toasted but tortilla 1 toasted", quesadilla.prepareDouble());

        verify(quesadilla.getQueso(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(4)).getCurrentTemperature();
        verify(quesadilla.getTortilla_2(), times(4)).getCurrentTemperature();

        verify(mockedQueso, times(0)).melt(true);
        verify(mockedTortilla, times(0)).toast(true);
        verify(mockedTortilla_2, times(1)).toast(true);

    }

    @Test
    public void YouSuckAtCooking(){
        when(mockedTortilla.getToastTemperature()).thenReturn(1);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(20);

        when(mockedTortilla_2.getToastTemperature()).thenReturn(1);
        when(mockedTortilla_2.getCurrentTemperature()).thenReturn(20);

        when(mockedQueso.getMeltingTemperature()).thenReturn(1);
        when(mockedQueso.getCurrentTemperature()).thenReturn(20);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla_2.isToasted()).thenReturn(false);

        Assert.assertEquals("You ran out of gas", quesadilla.prepareDouble());

        verify(quesadilla.getQueso(), times(1)).getCurrentTemperature();
        verify(quesadilla.getTortilla_1(), times(0)).getCurrentTemperature();
        verify(quesadilla.getTortilla_2(), times(0)).getCurrentTemperature();

        verify(mockedQueso, times(0)).melt(true);
        verify(mockedTortilla, times(0)).toast(true);
        verify(mockedTortilla_2, times(0)).toast(true);

    }

}



