package mx.iteso.ut;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


/**
 * Unit test for simple Quesadilla.
 */
public class QuesadillaTest {
    Quesadilla quesadilla;
    Queso mockedQueso;
    Tortilla mockedTortilla, mockedTortilla1;

@Before
public void SetUp(){
    //estas variables van a ser mockeadas, usando la clase Tortilla que es una interfaz
    quesadilla = new Quesadilla();
    mockedTortilla = Mockito.mock(Tortilla.class);
    mockedTortilla1 = Mockito.mock(Tortilla.class);
    mockedQueso = Mockito.mock(Queso.class);
    quesadilla.setQueso(mockedQueso);
    quesadilla.setTortilla(mockedTortilla);
    quesadilla.setTortilla1(mockedTortilla1);
}

@Test
public void quesadillaPerfecta(){
    when(mockedTortilla.getToastTemperature()).thenReturn(20);
    when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
    when(mockedQueso.getMeltingTemperature()).thenReturn(20);
    when(mockedQueso.getCurrentTemperature()).thenReturn(2,10,14,18,22,30);

    Mockito.when(mockedTortilla.isToasted()).thenReturn(true);
    Mockito.when(mockedQueso.isMelted()).thenReturn(true);

    Assert.assertEquals("Perfect quesadilla", quesadilla.prepareSingle());
    verify(mockedQueso,atLeastOnce()).melt(true);
    verify(mockedTortilla, atLeastOnce()).toast(true);

}

@Test
public void quesadillaBuena() {
    when(mockedTortilla.getToastTemperature()).thenReturn(25);
    when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
    when(mockedQueso.getMeltingTemperature()).thenReturn(20);
    when(mockedQueso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);


    Mockito.when(mockedTortilla.isToasted()).thenReturn(false);
    Mockito.when(mockedQueso.isMelted()).thenReturn(true);

    Assert.assertEquals("Good quesadilla", quesadilla.prepareSingle());
    verify(mockedQueso, atLeastOnce()).melt(true);
    verify(mockedTortilla, never()).toast(true);
}

@Test
public void quesadillaTerrible(){

    when(mockedTortilla.getToastTemperature()).thenReturn(20);
    when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18, 22);
    when(mockedQueso.getMeltingTemperature()).thenReturn(25);
    when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

    Mockito.when(mockedTortilla.isToasted()).thenReturn(true);
    Mockito.when(mockedQueso.isMelted()).thenReturn(false);

    Assert.assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
    verify(mockedQueso,never()).melt(true);
    verify(mockedTortilla, atLeastOnce()).toast(true);
}

@Test
public void SinGas(){

    when(mockedTortilla.getToastTemperature()).thenReturn(20);
    when(mockedTortilla.getCurrentTemperature()).thenReturn(25);
    when(mockedQueso.getMeltingTemperature()).thenReturn(20);
    when(mockedQueso.getCurrentTemperature()).thenReturn(25);

    Mockito.when(mockedTortilla.isToasted()).thenReturn(false);
    Mockito.when(mockedQueso.isMelted()).thenReturn(false);

    Assert.assertEquals("You ran out of gas", quesadilla.prepareSingle());
    verify(mockedQueso,never()).melt(true);
    verify(mockedTortilla, never()).toast(true);
}

    @Test
    public void excelentDouble(){
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedTortilla1.getToastTemperature()).thenReturn(20);
        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,10,14,18,22,30);

        Mockito.when(mockedTortilla.isToasted()).thenReturn(true);
        Mockito.when(mockedTortilla1.isToasted()).thenReturn(true);
        Mockito.when(mockedQueso.isMelted()).thenReturn(true);

        Assert.assertEquals("Excelent double", quesadilla.prepareDouble());
        verify(mockedQueso,atLeastOnce()).melt(true);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedTortilla1, atLeastOnce()).toast(true);
    }

    @Test
    public void goodDouble(){
        when(mockedTortilla.getToastTemperature()).thenReturn(25);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
        when(mockedTortilla1.getToastTemperature()).thenReturn(22);
        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);

        Mockito.when(mockedTortilla.isToasted()).thenReturn(false);
        Mockito.when(mockedTortilla1.isToasted()).thenReturn(true);
        Mockito.when(mockedQueso.isMelted()).thenReturn(true);

        Assert.assertEquals("Good double", quesadilla.prepareDouble());
        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla1, atLeastOnce()).toast(true);
    }

    @Test
    public void horribleDouble(){
        when(mockedTortilla.getToastTemperature()).thenReturn(25);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18, 22);
        when(mockedTortilla1.getToastTemperature()).thenReturn(20);
        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,6,10,14,18, 22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(25);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

        Mockito.when(mockedTortilla.isToasted()).thenReturn(false);
        Mockito.when(mockedTortilla1.isToasted()).thenReturn(true);
        Mockito.when(mockedQueso.isMelted()).thenReturn(false);

        Assert.assertEquals("Horrible double", quesadilla.prepareDouble());
        verify(mockedQueso,never()).melt(true);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla1, atLeastOnce()).toast(true);
    }

    @Test
    public void almostGoodDouble(){
        when(mockedTortilla.getToastTemperature()).thenReturn(25);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18, 22);
        when(mockedTortilla1.getToastTemperature()).thenReturn(25);
        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,6,10,14,18, 22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

        Mockito.when(mockedTortilla.isToasted()).thenReturn(false);
        Mockito.when(mockedTortilla1.isToasted()).thenReturn(false);
        Mockito.when(mockedQueso.isMelted()).thenReturn(true);

        Assert.assertEquals("Almost good double", quesadilla.prepareDouble());
        verify(mockedQueso,times(1)).melt(true);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla1, never()).toast(true);
    }

    @Test
    public void badDouble(){
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18, 22);
        when(mockedTortilla1.getToastTemperature()).thenReturn(20);
        when(mockedTortilla1.getCurrentTemperature()).thenReturn(2,6,10,14,18, 22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(25);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

        Mockito.when(mockedTortilla.isToasted()).thenReturn(true);
        Mockito.when(mockedTortilla1.isToasted()).thenReturn(true);
        Mockito.when(mockedQueso.isMelted()).thenReturn(false);

        Assert.assertEquals("Bad double", quesadilla.prepareDouble());
        verify(mockedQueso,never()).melt(true);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedTortilla1, atLeastOnce()).toast(true);
    }

    //  //2 tortillas no tostadas , queso no derretido
    //     else {
    //     return "Turn the stove on";
    @Test
    public void turnOn(){
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(25);
        when(mockedTortilla1.getToastTemperature()).thenReturn(20);
        when(mockedTortilla1.getCurrentTemperature()).thenReturn(25);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(25);

        Mockito.when(mockedTortilla.isToasted()).thenReturn(false);
        Mockito.when(mockedTortilla1.isToasted()).thenReturn(false);
        Mockito.when(mockedQueso.isMelted()).thenReturn(false);

        Assert.assertEquals("Turn the stove on", quesadilla.prepareDouble());
        verify(mockedQueso,never()).melt(true);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedTortilla1, never()).toast(true);
    }
}
