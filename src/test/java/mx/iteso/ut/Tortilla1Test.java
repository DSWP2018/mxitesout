package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class Tortilla1Test {
    Tortilla1 mockedTortilla1;
    Tortilla2 mockedTortilla2;


    @Before
    public void setUp() throws Exception{

        mockedTortilla1 = mock(Tortilla1.class);
        mockedTortilla2 = mock(Tortilla2.class);

    }

    @Test
    public void tortillaPerfecta() throws Exception{

    }

    @Test
    public void tortillaBuena() throws Exception{

    }

    @Test
    public void tortillaTerrible() throws Exception{

    }

    @Test
    public void noHayGas() throws Exception{

    }


    private boolean toasted = false;
    /**
     * Info about this package doing something for package-info.java file.
     */
    private static final Integer TOAST_TEMPERATURE = 40;
    /**
     * Info about this package doing something for package-info.java file.
     */
    private static final Integer DEFAULT_TEMPERATURE = new Integer(40);
    /**
     * Info about this package doing something for package-info.java file.
     */
    private int currentTemperature = DEFAULT_TEMPERATURE;
    /**
     *metodo para verificar si ya se tosto.
     *@return false
     * */
    public final boolean isToasted() {
        return false;
    }
    /**
     *metodo para verificar temperatura de tostado.
     *@return toastTemperature
     * */
    public final int getToastTemp() {
        return TOAST_TEMPERATURE;
    }
    /**
     *metodo para verificar temperatura actual.
     *@return currentTemperature
     * */
    public final int getCurrentTemp() {
        return currentTemperature;
    }
    /**
     *@param temp
     *metodo para verificar temperatura actual.
     * */
    public final void setCurrentTemp(final int temp) {
        this.currentTemperature = temp;
    }
    /**
     *@param toastTortilla
     *metodo para verificar temperatura actual.
     * */
    public final void toast(final boolean toastTortilla) {
        this.toasted = toastTortilla;
    }
}
