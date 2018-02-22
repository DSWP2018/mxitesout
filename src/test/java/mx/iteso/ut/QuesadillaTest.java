package mx.iteso.ut;

import org.junit.Assert;
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
    Tortilla mockedExtraTortilla;

    @Before
    public void setUp(){
        quesadilla = new Quesadilla();
        mockedQueso = mock(Queso.class);
        mockedTortilla = mock(Tortilla.class);
        mockedExtraTortilla = mock(Tortilla.class);
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setExtraTortilla(mockedExtraTortilla);


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

    @Test
    public void perfectDoubleQuesadilla(){

        when(mockedQueso.getMeltingTemperature()).thenReturn(15);
        when(mockedQueso.getCurrentTemperature()).thenReturn(5,10,15);

        when(mockedTortilla.getToastTemperature()).thenReturn( 30);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 20,30);

        when(mockedExtraTortilla.getToastTemperature()).thenReturn(30);
        when(mockedExtraTortilla.getCurrentTemperature()).thenReturn(10,20,30);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedExtraTortilla.isToasted()).thenReturn(true);

        Assert.assertEquals("Perfect double quesadilla uwu", quesadilla.prepareDouble());

        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedExtraTortilla, atLeastOnce()).toast(true);
    }

    @Test
    public void GoodDoubleQuesadilla(){

        when(mockedQueso.getMeltingTemperature()).thenReturn(15);
        when(mockedQueso.getCurrentTemperature()).thenReturn(5,15,22);

        when(mockedTortilla.getToastTemperature()).thenReturn( 30);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 20,30);

        when(mockedExtraTortilla.getToastTemperature()).thenReturn(30);
        when(mockedExtraTortilla.getCurrentTemperature()).thenReturn(10,20,25);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedExtraTortilla.isToasted()).thenReturn(false);

        Assert.assertEquals("Good double quesadilla", quesadilla.prepareDouble());

        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedExtraTortilla, never()).toast(true);

    }

    @Test
    public void AlmostGood(){

        when(mockedQueso.getMeltingTemperature()).thenReturn(15);
        when(mockedQueso.getCurrentTemperature()).thenReturn(5,10,15);

        when(mockedTortilla.getToastTemperature()).thenReturn( 30);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 20,25);

        when(mockedExtraTortilla.getToastTemperature()).thenReturn(30);
        when(mockedExtraTortilla.getCurrentTemperature()).thenReturn(10,20,30);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedExtraTortilla.isToasted()).thenReturn(true);

        Assert.assertEquals("Almost a good double quesadilla", quesadilla.prepareDouble());

        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedExtraTortilla, atLeastOnce()).toast(true);

    }

    @Test
    public void YouCouldDoABetterTry(){

        when(mockedQueso.getMeltingTemperature()).thenReturn(15);
        when(mockedQueso.getCurrentTemperature()).thenReturn(5,10,15);

        when(mockedTortilla.getToastTemperature()).thenReturn( 30);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 20,25);

        when(mockedExtraTortilla.getToastTemperature()).thenReturn(30);
        when(mockedExtraTortilla.getCurrentTemperature()).thenReturn(10,20,25);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedExtraTortilla.isToasted()).thenReturn(false);

        Assert.assertEquals("you could do it better, dude", quesadilla.prepareDouble());

        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedExtraTortilla, never()).toast(true);
    }

    @Test
    public void ADoubleQuesadillaWithoutMeltedCheese(){

        when(mockedQueso.getMeltingTemperature()).thenReturn(25);
        when(mockedQueso.getCurrentTemperature()).thenReturn(5,10,15);

        when(mockedTortilla.getToastTemperature()).thenReturn( 30);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 20,30);

        when(mockedExtraTortilla.getToastTemperature()).thenReturn(30);
        when(mockedExtraTortilla.getCurrentTemperature()).thenReturn(10,20,30);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedExtraTortilla.isToasted()).thenReturn(true);

        Assert.assertEquals("Srsly, dude?", quesadilla.prepareDouble());

        verify(mockedQueso, never()).melt(true);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedExtraTortilla, atLeastOnce()).toast(true);
    }


    @Test
    public void ProblemWithDoubleQuesadillas(){

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(5,10,15);

        when(mockedTortilla.getToastTemperature()).thenReturn( 30);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 15,20);

        when(mockedExtraTortilla.getToastTemperature()).thenReturn(30);
        when(mockedExtraTortilla.getCurrentTemperature()).thenReturn(10,20,30);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedExtraTortilla.isToasted()).thenReturn(true);

        Assert.assertEquals("I really think you have a problem", quesadilla.prepareDouble());

        verify(mockedQueso, never()).melt(true);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedExtraTortilla, atLeastOnce()).toast(true);

    }

    public void IsThisPossible() {

        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(5,10,15);

        when(mockedTortilla.getToastTemperature()).thenReturn( 30);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(10, 15,30);

        when(mockedExtraTortilla.getToastTemperature()).thenReturn(30);
        when(mockedExtraTortilla.getCurrentTemperature()).thenReturn(10,20,20);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedExtraTortilla.isToasted()).thenReturn(false);

        Assert.assertEquals("How is this possible?", quesadilla.prepareDouble());

        verify(mockedQueso, never()).melt(true);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedExtraTortilla, never()).toast(true);
    }

    @Test
    public void TerribleCookingDoubleQuesadillas() {

        when(mockedQueso.getMeltingTemperature()).thenReturn(15);
        when(mockedQueso.getCurrentTemperature()).thenReturn(20);

        when(mockedTortilla.getToastTemperature()).thenReturn(10);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(20);

        when(mockedExtraTortilla.getToastTemperature()).thenReturn(10);
        when(mockedExtraTortilla.getCurrentTemperature()).thenReturn(20);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedExtraTortilla.isToasted()).thenReturn(false);

        Assert.assertEquals("WTF?", quesadilla.prepareDouble());
        
        verify(mockedQueso, never()).melt(true);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedExtraTortilla, never()).toast(true);

    }
}