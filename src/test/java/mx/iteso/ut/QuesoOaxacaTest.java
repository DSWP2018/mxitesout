package mx.iteso.ut;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuesoOaxacaTest {
    QuesoOaxaca miQueso= new QuesoOaxaca();

    @Before
    public void setUp(){
        miQueso.setCurrentTemperature(0);
        miQueso.setMeltingTemperature(20);
        miQueso.melt(true);
    }

    @Test
    public void getCurrentTemperature(){
        Assert.assertEquals(0, miQueso.getCurrentTemperature());
    }

    @Test
    public void getMeltingTemperature(){
        Assert.assertEquals(20, miQueso.getMeltingTemperature());
    }

    @Test
    public void trueMelt(){
        Assert.assertEquals(true, miQueso.isMelted());
    }

    @Test
    public void falseMelt(){
        miQueso.melt(false);
        Assert.assertEquals(false, miQueso.isMelted());
    }
}