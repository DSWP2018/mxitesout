/**
 * Paquete.
 */
package mx.iteso.ut;

/**
 * clase quesadilla. comida.
 */
public class Quesadilla {
    /**
     * queso para la quesadilla.
     */
    private Queso queso;
    /**
     * tortilla para las quesadillas.
     */
    private Tortilla tortilla;
    /**
     * tortilla para quesadillas dobles.
     */
    private Tortilla secondTortilla;
    /**
     * cambio de temperatura.
     */
    private int heatLevel;

    /**
     * Prepara una quesadilla con una sola tortilla.
     * @return devuelve una cadena que describe el tipo de quesadilla.
     */
    public final String prepareSingle() {
         while (getQueso().getCurrentTemperature()
                 < getQueso().getMeltingTemperature() && //queso sigue sólido
                 getTortilla().getCurrentTemperature()
                 < getTortilla().getToastTemperature()) {    //no está tostada

             getTortilla().setCurrentTemperature(
                     getTortilla().getCurrentTemperature() + getHeatLevel());
                    //poner tempteratura a tortilla
             getQueso().setCurrentTemperature(
                     getQueso().getCurrentTemperature() + getHeatLevel());
                    //poner temperatura a tortilla
             if (getTortilla().getCurrentTemperature()
                     >= getTortilla().getToastTemperature()) {
                 getTortilla().toast(true);
             }

             if (getQueso().getCurrentTemperature()
                     >= getQueso().getMeltingTemperature()) {
                 getQueso().melt(true);
             }
             //poner si tostado o derretido al superarlo
         }

         if (getQueso().isMelted() && getTortilla().isToasted()) {
             return "Perfect quesadilla";
         }
         if (getQueso().isMelted()
                 && !getTortilla().isToasted()) {   //derrietido, no tostada
             return "Good quesadilla";
         }
         if (!getQueso().isMelted()
                 && getTortilla().isToasted()) {   //no derretida, sí tostada
             return "Terrible quesadilla";

         } else {
             return "You ran out of gas";
         }
    }

    /**
     * Prepara una quesadilla con dos tortillas.
     * @return devuelve una cadena del tipo de quesadilla.
     */
    public final String prepareDouble() {
        while (getQueso().getCurrentTemperature()
                < getQueso().getMeltingTemperature()
                && getTortilla().getCurrentTemperature()
                < getTortilla().getToastTemperature() //tortilla 1
                && getSecondTortilla().getCurrentTemperature()
                < getSecondTortilla().getToastTemperature()) {   //tortilla 2

            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature()
                    + getHeatLevel());
            getTortilla().setCurrentTemperature(
                    getTortilla().getCurrentTemperature() + getHeatLevel());
            getSecondTortilla().setCurrentTemperature(
                    getSecondTortilla().getCurrentTemperature()
                            + getHeatLevel());

            if (getQueso().getCurrentTemperature()
                    >= getQueso().getMeltingTemperature()) {
                getQueso().melt(true);
            }
            if (getTortilla().getCurrentTemperature()
                    >= getTortilla().getToastTemperature()) {
                getTortilla().toast(true);
            }
            if (getSecondTortilla().getCurrentTemperature()
                    >= getSecondTortilla().getToastTemperature()) {
                getSecondTortilla().toast(true);
            }

        }

            //Ambas tortillas tostadas, queso derretido
        if (tortilla.isToasted() && secondTortilla.isToasted()
                && queso.isMelted()) {
            return "Quesadilla doble perfecta";
        }
            //Ambas tortillas tostadas, queso no derretido
        if (tortilla.isToasted() && secondTortilla.isToasted()
                && !queso.isMelted()) {
            return "Quesadilla doble buena";
        }
            //Una tortilla tostada, una sin tostar, queso derretido
        if ((tortilla.isToasted()
                && !secondTortilla.isToasted()
                || !tortilla.isToasted() && secondTortilla.isToasted())
                && queso.isMelted()) {
            return "Quesadilla doble decente";
        }
            //Una tortilla tostada, una sin tostar, queso no derretido
        if ((tortilla.isToasted() && !secondTortilla.isToasted()
                || !tortilla.isToasted() && secondTortilla.isToasted())
                && !queso.isMelted()) {
            return "Quesadilla doble pasable";
        }
            //Ambas sin tostar, queso derretido
        if (!tortilla.isToasted() && !secondTortilla.isToasted()
                && queso.isMelted()) {
            return "Quesadilla doble mala";
            //Ambas sin tostar, queso no derretido
        } else {
            return "Se acabó el gas";
        }
    }

    /**
     * Getter del Queso.
     * @return devuelve el queso de la quesadilla.
     */
    public final Queso getQueso() {
        return queso;
    }

    /**
     * Setter del queso.
     * @param ques : fija el queso para la quesadilla.
     */
    public final void setQueso(final Queso ques) {
        this.queso = ques;
    }

    /**
     * Getter de tortilla.
     * @return devuelve la tortilla de la quesadilla.
     */
    public final Tortilla getTortilla() {
        return tortilla;
    }

    /**
     * Getter de la segunda tortilla.
     * @return devuelve la tortilla de la segunda quesadilla.
     */
    public final Tortilla getSecondTortilla() {
        return secondTortilla;
    }

    /**
     * Setter de tortilla.
     * @param tort : manda una tortilla para dejarla fija a la quesadilla.
     */
    public final void setTortilla(final Tortilla tort) {
        this.tortilla = tort;
    }

    /**
     * Setter de la segunda tortilla.
     * @param tort : manda una segundatortilla
     *             para dejarla fija a la quesadilla.
     */
    public final void setSecondTortilla(final Tortilla tort) {
        this.secondTortilla = tort;
    }

    /**
     * Getter del nivel de calor.
     * @return devuelve un entero. es el cambio de temperatura.
     */
    public final int getHeatLevel() {
        return heatLevel;
    }

    /**
     * Setter del nivel de calor.
     * @param hl : es el número que se introduce como cambio de temperatura.
     */
    public final void setHeatLevel(final int hl) {
        this.heatLevel = hl;
    }
}
