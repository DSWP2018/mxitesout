package mx.iteso.ut;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class QuesadillaImplementsTest {
    QuesoManchego manchego;
    QuesoAdobera adobera;
    TortillaMaiz maiz;
    TortillaHarina harina;
    Quesadilla quesadilla;

    @Before
    public void setUp(){
        manchego = new QuesoManchego();
        adobera = new QuesoAdobera();
        maiz = new TortillaMaiz();
        harina = new TortillaHarina();
        quesadilla = new Quesadilla();
    }

    @Test
    public void perfectQuesadillaTest(){
        quesadilla.setQueso(adobera);
        quesadilla.setTortilla_1(harina);
        quesadilla.setHeatLevel(5);

        Assert.assertEquals("Perfect quesadilla", quesadilla.prepareSingle());
    }

    @Test
    public void goodQuesadillaTest(){
        quesadilla.setQueso(adobera);
        quesadilla.setTortilla_1(maiz);
        quesadilla.setHeatLevel(5);

        Assert.assertEquals("Good quesadilla", quesadilla.prepareSingle());
    }


    @Test
    public void terribleQuesadillaTest(){
        quesadilla.setQueso(manchego);
        quesadilla.setTortilla_1(harina);
        quesadilla.setHeatLevel(5);

        Assert.assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
    }

    @Test
    public void noQuesadillaTest(){
        quesadilla.setQueso(manchego);
        quesadilla.setTortilla_1(maiz);
        quesadilla.setHeatLevel(5);
        quesadilla.getQueso().setCurrentTemperature(85);
        quesadilla.getTortilla_1().setCurrentTemperature(85);

        Assert.assertEquals("You ran out of gas", quesadilla.prepareSingle());
    }

}
