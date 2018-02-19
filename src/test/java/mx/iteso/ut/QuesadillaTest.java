package mx.iteso.ut;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.*;

public class QuesadillaTest
{
    Quesadilla quesadilla;
    Queso mockedQueso;
    Tortilla mockedTortilla;
    Tortilla mockedSecodTortilla;

    @Before
    public void setUp(){
        quesadilla = new Quesadilla();
        mockedTortilla = mock(Tortilla.class);
        mockedQueso = mock(Queso.class);
        quesadilla.setQueso(mockedQueso);
        quesadilla.setTortilla(mockedTortilla);
        mockedSecodTortilla = mock(Tortilla.class);
        quesadilla.setSecondTortilla(mockedSecodTortilla);
    }
    @Test
    public void quesadillaPerfecta(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(true);

        //Se ejecuta la accion
        String result = quesadilla.prepareSingle();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla perfecta", "Perfect quesadilla", result);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(true);
    }
    @Test
    public void quesadillaBuena(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(true);

        //Se ejecuta la accion
        String result = quesadilla.prepareSingle();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla buena", "Good quesadilla", result);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(true);
    }
    @Test
    public void quesadillaTerrible(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(false);

        //Se ejecuta la accion
        String result = quesadilla.prepareSingle();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla terrible", "Terrible quesadilla", result);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }
    @Test
    public void noHayGas(){
//Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(22);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(false);

        //Se ejecuta la accion
        String result = quesadilla.prepareSingle();

        //Se revisa los resultados
        Assert.assertEquals("Se espera que te quedes sin gas :(", "You ran out of gas", result);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

    @Test
    public void quesadillaDoublePerfecta(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedSecodTortilla.getToastTemperature()).thenReturn(20);
        when(mockedSecodTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedSecodTortilla.isToasted()).thenReturn(true);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(true);

        //Se ejecuta la accion
        String result = quesadilla.prepareDoubleQuesadilla();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla perfecta", "Perfect double quesadilla", result);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(true);
        verify(mockedSecodTortilla, atLeastOnce()).toast(true);
    }
    @Test
    public void quesadillaDoubleTerrible(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(22);
        when(mockedSecodTortilla.getToastTemperature()).thenReturn(20);
        when(mockedSecodTortilla.getCurrentTemperature()).thenReturn(22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(22);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedSecodTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(false);

        //Se ejecuta la accion
        String result = quesadilla.prepareDoubleQuesadilla();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla terrible", "Terrible double quesadilla", result);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedSecodTortilla, never()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

    @Test
    public void quesadillaDoubleBuena(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedSecodTortilla.getToastTemperature()).thenReturn(20);
        when(mockedSecodTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedSecodTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(true);

        //Se ejecuta la accion
        String result = quesadilla.prepareDoubleQuesadilla();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla buena", "Good double quesadilla", result);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedSecodTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(true);
    }

    @Test
    public void quesadillaDoubleOk(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedSecodTortilla.getToastTemperature()).thenReturn(20);
        when(mockedSecodTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedSecodTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(true);

        //Se ejecuta la accion
        String result = quesadilla.prepareDoubleQuesadilla();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla ok", "Ok double quesadilla", result);
        verify(mockedTortilla,  atLeastOnce()).toast(true);
        verify(mockedSecodTortilla, never()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(true);
    }

    @Test
    public void quesadillaDoubleMeh(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedSecodTortilla.getToastTemperature()).thenReturn(20);
        when(mockedSecodTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedSecodTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(true);

        //Se ejecuta la accion
        String result = quesadilla.prepareDoubleQuesadilla();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla meh", "Meh double quesadilla", result);
        verify(mockedTortilla,  never()).toast(true);
        verify(mockedSecodTortilla, never()).toast(true);
        verify(mockedQueso, atLeastOnce()).melt(true);
    }

    @Test
    public void quesadillaDoubleBad(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedSecodTortilla.getToastTemperature()).thenReturn(20);
        when(mockedSecodTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedSecodTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(false);

        //Se ejecuta la accion
        String result = quesadilla.prepareDoubleQuesadilla();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla bad", "Bad double quesadilla", result);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedSecodTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

    @Test
    public void quesadillaDoubleSad(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedSecodTortilla.getToastTemperature()).thenReturn(20);
        when(mockedSecodTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedTortilla.isToasted()).thenReturn(false);
        when(mockedSecodTortilla.isToasted()).thenReturn(true);
        when(mockedQueso.isMelted()).thenReturn(false);

        //Se ejecuta la accion
        String result = quesadilla.prepareDoubleQuesadilla();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla sad", "Sad double quesadilla", result);
        verify(mockedTortilla, never()).toast(true);
        verify(mockedSecodTortilla, atLeastOnce()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }

    @Test
    public void quesadillaDoubleHorrible(){
        //Estableces los metodos necesarios con sus valores
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);
        when(mockedSecodTortilla.getToastTemperature()).thenReturn(20);
        when(mockedSecodTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedQueso.getMeltingTemperature()).thenReturn(20);
        when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,19);
        when(mockedTortilla.isToasted()).thenReturn(true);
        when(mockedSecodTortilla.isToasted()).thenReturn(false);
        when(mockedQueso.isMelted()).thenReturn(false);

        //Se ejecuta la accion
        String result = quesadilla.prepareDoubleQuesadilla();

        //Se revisa los resultados
        Assert.assertEquals("Se espera una quesadilla horrible", "Horrible double quesadilla", result);
        verify(mockedTortilla, atLeastOnce()).toast(true);
        verify(mockedSecodTortilla, never()).toast(true);
        verify(mockedQueso, never()).melt(true);
    }
}
