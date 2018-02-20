package mx.iteso.ut;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.*;
/*
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Quesadilla.
*/
public class QuesadillaTest
  //  extends TestCase
{
    private Quesadilla quesadilla;
    private Queso mockedQueso;
    private Tortilla mockedTortilla;
    private Tortilla mockedTortilla2;
    private QuesoOaxaca quesoOa;
    private QuesoManchego quesoM;
    private TortillaHarina tortillaH;
    private TortillaMaiz tortillaM;

    @Before//Cambien el setUp porque me dio hueva crear mas quesadillas asi que seteo el queso y tortilla n cada una de las funciones
    public void setUp(){
        quesadilla = new Quesadilla();
        mockedTortilla = mock(Tortilla.class);
        mockedQueso = mock(Queso.class);
        quesoOa = new QuesoOaxaca();
        quesoM = new QuesoManchego();
        tortillaH = new TortillaHarina();
        tortillaM = new TortillaMaiz();
        mockedTortilla2 = mock(Tortilla.class);
    }

    @Test
    public void quesoMan(){
        quesadilla.setQueso(quesoM);
        quesadilla.setTortilla(tortillaM);

        quesadilla.setHeatLevel(10);
/*
        when(quesoM.getCurrentTemperature()).thenReturn(quesoM.getCurrentTemperature());//10
        when(quesoM.getMeltingTemperature()).thenReturn(quesoM.getMeltingTemperature());//45

        when(tortillaM.getCurrentTemperature()).thenReturn(tortillaM.getCurrentTemperature());//5
        when(tortillaM.getToastTemperature()).thenReturn(tortillaM.getToastTemperature());//20

        when(quesoM.isMelted()).thenReturn(quesoM.isMelted());
        when(tortillaM.isToasted()).thenReturn(tortillaM.isToasted());*/
        Assert.assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
      /*  verify(tortillaM, atLeastOnce()).toast(true);
        verify(quesoM, atLeastOnce()).melt(false);*/
    }

    @Test
    public void tortillaHa(){
        quesadilla.setTortilla(tortillaM);
        quesadilla.setQueso(quesoOa);
        quesadilla.setHeatLevel(5);

        Assert.assertEquals("Perfect quesadilla", quesadilla.prepareSingle());
    }

    @Test
    public void perfectQuesadilla(){
        //Me dio hueva crear mas quesadillas
        //Comentario 2
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);

        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedQueso.getMeltingTemperature()).thenReturn(8);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(6, 8, 8);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        Assert.assertEquals("Perfect quesadilla", quesadilla.prepareSingle());
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(true);

    }
    @Test
    public void goodQuesadilla(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedQueso.getMeltingTemperature()).thenReturn(8);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(6, 8, 8);
        when(mockedTortilla.getToastTemperature()).thenReturn(10);


        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(true);
        Assert.assertEquals("Good quesadilla", quesadilla.prepareSingle());
        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla, atLeastOnce()).toast(false);
    }
    @Test
    public void terribleQuesadilla(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(4,4, 8);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(4, 4, 8);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        Assert.assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(false);
    }
    @Test
    public void noGas(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setHeatLevel(4);
    //No entran desde el inicio
        when(mockedQueso.getCurrentTemperature()).thenReturn(11);
        when(mockedQueso.getMeltingTemperature()).thenReturn(10);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(9);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(false);
        Assert.assertEquals("You ran out of gas", quesadilla.prepareSingle());

    }
    @Test
    public void perfectQuesadillaDobele(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setTortilla2(mockedTortilla2);

        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedQueso.getMeltingTemperature()).thenReturn(8);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(6, 8, 8);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedTortilla2.getToastTemperature()).thenReturn(8);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        Assert.assertEquals("Perfect quesadilla doble", quesadilla.prepareDouble());
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla2, atLeastOnce()).toast(true);
    }
    @Test
    public void veryGoodQuesadillaDoble(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setTortilla2(mockedTortilla2);

        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedQueso.getMeltingTemperature()).thenReturn(8);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(6, 4, 4);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedTortilla2.getToastTemperature()).thenReturn(8);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        Assert.assertEquals("Very Good quesadilla doble", quesadilla.prepareDouble());
        verify(mockedTortilla, atLeastOnce()).toast(false);
        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla2, atLeastOnce()).toast(true);
    }
    @Test
    public void gooQuesadillaDoble(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setTortilla2(mockedTortilla2);

        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedQueso.getMeltingTemperature()).thenReturn(8);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(6, 8, 8);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,4,4);
        when(mockedTortilla2.getToastTemperature()).thenReturn(8);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        Assert.assertEquals("Good quesadilla doble", quesadilla.prepareDouble());
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla2, atLeastOnce()).toast(false);
    }
    @Test
    public void badQuesadillaDoble(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setTortilla2(mockedTortilla2);

        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedQueso.getMeltingTemperature()).thenReturn(8);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(6, 4, 4);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,4,4);
        when(mockedTortilla2.getToastTemperature()).thenReturn(8);

        when(mockedQueso.isMelted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        Assert.assertEquals("Bad quesadilla doble", quesadilla.prepareDouble());
        verify(mockedTortilla, atLeastOnce()).toast(false);
        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedTortilla2, atLeastOnce()).toast(false);
    }
    @Test
    public void veryBadQuesadillaDoble(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setTortilla2(mockedTortilla2);

        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(6,4,4);
        when(mockedQueso.getMeltingTemperature()).thenReturn(8);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(6, 6, 8);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedTortilla2.getToastTemperature()).thenReturn(8);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        Assert.assertEquals("Very Bad quesadilla doble", quesadilla.prepareDouble());
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(false);
        verify(mockedTortilla2, atLeastOnce()).toast(true);
    }
    @Test
    public void terribleQuesadillaDoble(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setTortilla2(mockedTortilla2);

        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(6,4,4);
        when(mockedQueso.getMeltingTemperature()).thenReturn(8);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(6, 4, 4);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,6,8);
        when(mockedTortilla2.getToastTemperature()).thenReturn(8);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(true);
        Assert.assertEquals("Terrible quesadilla doble", quesadilla.prepareDouble());
        verify(mockedTortilla, atLeastOnce()).toast(false);
        verify(mockedQueso, atLeastOnce()).melt(false);
        verify(mockedTortilla2, atLeastOnce()).toast(true);
    }
    @Test
    public void ranOutGasQuesadillaDoble(){
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        quesadilla.setTortilla2(mockedTortilla2);

        quesadilla.setHeatLevel(4);

        when(mockedQueso.getCurrentTemperature()).thenReturn(9);
        when(mockedQueso.getMeltingTemperature()).thenReturn(8);

        when(mockedTortilla.getCurrentTemperature()).thenReturn(9);
        when(mockedTortilla.getToastTemperature()).thenReturn(8);

        when(mockedTortilla2.getCurrentTemperature()).thenReturn(9);
        when(mockedTortilla2.getToastTemperature()).thenReturn(8);

        when(mockedQueso.isMelted()).thenReturn(false);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedTortilla2.isToasted()).thenReturn(false);
        Assert.assertEquals("You ran out of gas on quesadilla doble", quesadilla.prepareDouble());
        //verify(mockedTortilla, atLeastOnce()).toast(false);
        //verify(mockedQueso, atLeastOnce()).melt(false);
        //verify(mockedTortilla2, atLeastOnce()).toast(false);
    }
}