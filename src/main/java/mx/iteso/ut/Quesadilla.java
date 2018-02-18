package mx.iteso.ut;

/**
 * Hello world!
 *
 */

public class Quesadilla {
    /** Variable de tipo Queso con nombre de queso.*/
    private Queso queso;
    /**Variable de tipo Tortilla.*/
    private Tortilla tortilla;
    /**Variable de tipo Tortilla.*/
    private Tortilla tortilla2;
    /**Nivel de calor que, 0 es default.*/
    private final int heatLevel = 0;

    /**Metodo que hace una sola quesadila.
     * @return un string con el estado de la quesadilla.*/
    public final String prepareSingle() {


        while (queso.getCurrentTemp() < queso.getMeltingTemperature()
                && tortilla.getCurrentTemp() < tortilla.getToastTem()) {
            tortilla.setCurrentTemp(tortilla.getCurrentTemp() + heatLevel);
            queso.setCurrentTemp(queso.getCurrentTemp() + heatLevel);
            if (tortilla.getCurrentTemp() >= tortilla.getToastTem()) {
                tortilla.toast(true);
            }
            if (queso.getCurrentTemp() >= queso.getMeltingTemperature()) {
                queso.melt(true);
            }
        }

        if (queso.isMelted() && tortilla.isToasted()) {
            return "Perfect quesadilla";
        }
        if (queso.isMelted() && !tortilla.isToasted()) {
            return "Good quesadilla";
        }
            if (!queso.isMelted() && tortilla.isToasted()) {
                return "Terrible quesadilla";
            } else {
                return "You ran out of gas";
            }
    }

    /**
     * Metodo para crear una quesadilla doble (dos tortillas, un solo queso)
     * @return string con el estado de la quesadilla
     * */

    public final String prepareDouble() {

        String result = "Go get UberEats, please!";

        while(queso.getCurrentTemp() < queso.getMeltingTemperature() &&
                tortilla.getCurrentTemp() < tortilla.getToastTem()  &&
                tortilla2.getCurrentTemp() < tortilla2.getToastTem()) {

            tortilla.setCurrentTemp(tortilla.getCurrentTemp() + heatLevel);
            tortilla2.setCurrentTemp(tortilla2.getCurrentTemp() + heatLevel);
            queso.setCurrentTemp(queso.getCurrentTemp() + heatLevel);

            if (tortilla.getCurrentTemp() >= tortilla.getToastTem()) {
                tortilla.toast(true);
            }
            if (tortilla2.getCurrentTemp() >= tortilla2.getToastTem()) {
                tortilla2.toast(true);
            }
            if (queso.getCurrentTemp() >= queso.getMeltingTemperature()) {
                queso.melt(true);
            }

        }

        // tortilla 1 tostada, tortilla 2 tostada, queso derretido

        if(tortilla.isToasted() && tortilla2.isToasted() && queso.isMelted()) {
            result = "Spledid double quesadilla";
        } else if((tortilla.isToasted() || tortilla2.isToasted()) && queso.isMelted()) {
            result = "Just a good  double quesadilla";
        } else if(tortilla.isToasted() && tortilla2.isToasted() && !queso.isMelted()) {
            result = "Weak double quesadilla";
        } else if((tortilla.isToasted() || tortilla2.isToasted()) && !queso.isMelted()) {
            result = "Notoriously bad quesadilla";
        }



        return result;
    }


/*
    public final void setHeatLevel(int heatLevel) {

        this.heatLevel = heatLevel;
    }
*/

    public void setQueso(Queso queso) {
        this.queso = queso;
    }


    public void setTortilla(Tortilla tortilla) {
        this.tortilla = tortilla;
    }

    public void setTortilla2(Tortilla tortilla2) {
        this.tortilla2 = tortilla2;
    }
}
