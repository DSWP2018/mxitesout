/**
 * El paquete que contiene las clases e interfaces de Quesadilla.
 */
package mx.iteso.ut;


/**
 * Una clase  para representar Quesadillas.
 * Cada Quesadilla se determina por su Queso y Tortilla
 * @version 1.2 12/02/18
 * @author Mariana Salas
 */
    public class Quesadilla {
    /**
     * Ingrediente principal de la quesadilla.
     */
    private Queso queso;
    /**
     * Ingrediente que envuelve al queso.
     */
    private Tortilla tortilla, tortilla1;
    /**
     * Temperatura de cocción.
     */
    private int heatLevel;

    /**
     * Método para preparar una quesadilla, revisa si la tortilla está tostada
     * y si el queso esta derretida y determina que tipo de queadilla se preparó
     * En caso de que no haya gas, lo marca.
     * @return El tipo de Quesadilla (Perfecta, Buena, Terrible o en su caso
     * si no hay Gas)
     */
     public final String prepareSingle() {
     while (getQueso().getCurrentTemperature()
            < getQueso().getMeltingTemperature()
             && getTortilla().getCurrentTemperature()
              < getTortilla().getToastTemperature()) {
                  getTortilla().setCurrentTemperature(
                      getTortilla().getCurrentTemperature()
         + getHeatLevel());
         getQueso().setCurrentTemperature(getQueso().getCurrentTemperature()
         + getHeatLevel());
         if (getTortilla().getCurrentTemperature()
         >= getTortilla().getToastTemperature()) {
             getTortilla().toast(true);
         }
         if (getQueso().getCurrentTemperature()
         >= getQueso().getMeltingTemperature()) {
             getQueso().melt(true);
         }
     }
     if (getQueso().isMelted() && getTortilla().isToasted()) {
         return "Perfect quesadilla";
     }
     if (getQueso().isMelted() && !getTortilla().isToasted()) {
         return "Good quesadilla";
     }
     if (!getQueso().isMelted() && getTortilla().isToasted()) {
         return "Terrible quesadilla";
     }  else {
         return "You ran out of gas";
     }

    }

    /**
     * Método para preparar una quesadilla doble.
     * @return Un string dependiendo del tipo de quesadilla que resultó
     */
    public final String prepareDouble() {
        while (getQueso().getCurrentTemperature()
                < getQueso().getMeltingTemperature()
                && getTortilla().getCurrentTemperature()
                < getTortilla().getToastTemperature()
                && getTortilla1().getCurrentTemperature()
                < getTortilla1().getToastTemperature()) {

           getTortilla().setCurrentTemperature(
                    getTortilla().getCurrentTemperature()
                            + getHeatLevel());
            getTortilla1().setCurrentTemperature(
                    getTortilla1().getCurrentTemperature()
                            + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature()
                    + getHeatLevel());

            if (getTortilla().getCurrentTemperature()
                    >= getTortilla().getToastTemperature()) {
              getTortilla().toast(true);
            }
            if (getTortilla1().getCurrentTemperature()
                    >= getTortilla1().getToastTemperature()) {
               getTortilla1().toast(true);
            }
            if (getQueso().getCurrentTemperature()
                    >= getQueso().getMeltingTemperature()) {
                getQueso().melt(true);
            }
        }

        //tortillas tostadas queso derretido
        if (getQueso().isMelted() && getTortilla().isToasted()
                && getTortilla().isToasted()) {
            return "Excelent double";
        }
        //1 tortilla no tostada, queso derretido
        if (getQueso().isMelted() && !getTortilla().isToasted()
                && getTortilla1().isToasted()) {
            return "Good double";
        }
        //1 tortilla no tostada queso no derretido
        if (!getQueso().isMelted() && !getTortilla().isToasted()
                && getTortilla1().isToasted()) {
            return "Horrible double";
        }
        //2 tortillas no tostadas, queso derretido.
        if (getQueso().isMelted() && !getTortilla().isToasted()
                && !getTortilla1().isToasted()) {
            return "Almost good double";
        }
        //tortillas tostadas, queso no derretido
        if (!getQueso().isMelted() && getTortilla().isToasted()
                && getTortilla1().isToasted()) {
            return "Bad double";
        } else {
                return "Turn the stove on";
        }
    }
    /**
     * Método para obtener el queso que se utiliza.
     * @return el queso que tiene la quesadilla
     */
    public final Queso getQueso() {
        return queso;
    }

    /**
     * Asigna al queso de la quesadilla el queso que se está.
     * utilizando
     * @param myqueso el queso que el usuario utilice
     */
    public final void setQueso(final Queso myqueso) {
        this.queso = myqueso;
    }

    /**
     * Método para obtener la tortilla que se utiliza.
     * @return la tortilla que tiene la quesadilla
     */
    public final Tortilla getTortilla() {
        return tortilla;
    }

    /**
     * Método para obtener la segunda tortilla que se utiliza.
     * @return la tortilla que tiene la quesadilla
     */
    public final Tortilla getTortilla1() {
        return tortilla1;
    }

    /**
     * Método que asigna el tipo de tortilla que el usuario utiliza.
     * a la tortilla de la quesadilla
     * @param mytortilla la tortilla que el usuario utilice
     */
    public final void setTortilla(final Tortilla mytortilla) {
        this.tortilla = mytortilla;
    }

    /**
     * Método que asigna el tipo de tortilla que el usuario utiliza.
     * a la tortilla de la quesadilla
     * @param mytortilla la tortilla que el usuario utilice
     */
    public final void setTortilla1(final Tortilla mytortilla) {
        this.tortilla1 = mytortilla;
    }


    /**
     * Método para obtener el nivel de temperatura de cocción.
     * @return heatLevel
     */
    public final int getHeatLevel() {
        return heatLevel;
    }

    /**
     * Método para asignar el nivel de temperatura de cocción.
     * @param myheatLevel la temperatura que se va a establecer
     */
    public final void setHeatLevel(final int myheatLevel) {
        this.heatLevel = myheatLevel;
    }
}
