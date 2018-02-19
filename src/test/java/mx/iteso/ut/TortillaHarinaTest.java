package mx.iteso.ut;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TortillaHarinaTest {
    TortillaHarina miTortilla = new TortillaHarina();

    @Before
    public void setUp(){
        miTortilla.setCurrentTemperature(0);
        miTortilla.setToastTemperature(20);
        miTortilla.toast(true);
    }

    @Test
    public void getCurrentTemperature() {
        Assert.assertEquals(0, miTortilla.getCurrentTemperature());
    }

    @Test
    public void getToastTemperature(){
        Assert.assertEquals(20, miTortilla.getToastTemperature());
    }

    @Test
    public void trueToast(){
        Assert.assertEquals(true, miTortilla.isToasted());
    }

    @Test
    public void flaseToast(){
        miTortilla.toast(false);
        Assert.assertEquals(false, miTortilla.isToasted());
    }
}
