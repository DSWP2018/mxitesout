/**
 * Clase de Quesadilla.
 * @since 1.0
 * @version 1.1
 * @author luisacfl
 */

package mx.iteso.ut;

/**
 * Clase de Quesadilla.
 */
public class Quesadilla {
    /**
     *  Objeto Queso instanciado.
     */
    private Queso queso;
    /**
     *  Objeto Tortilla instanciado.
     */
    private Tortilla tortilla;
    /**
     *  Objeto Tortilla 2 instanciado.
     */
    private Tortilla tortilla2;
    /**
     *  Variable del nivel del calor.
     */
    private int heatLevel;

    /**
     * Metodo para hacer quesadilla.
     * @return Regresa una cadena de texto
     * indicando el tipo de quesadilla
     */
    public final String prepareSingle() {
     while (getQueso().getCurrentTemperature()
             < getQueso().getMeltingTemperature()
             && getTortilla().getCurrentTemperature()
             < getTortilla().getToastTemperature()) {

         getTortilla().setCurrentTemperature(
                 getTortilla().getCurrentTemperature() + getHeatLevel());
         getQueso().setCurrentTemperature(
                 getQueso().getCurrentTemperature() + getHeatLevel());
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
     } else {
         return "You ran out of gas";
        }

    }

    public String prepareDouble(){
        while(getQueso().getCurrentTemperature()<getQueso().getMeltingTemperature() &&
                getTortilla().getCurrentTemperature()<getTortilla().getToastTemperature() &&
                getTortilla2().getCurrentTemperature()<getTortilla2().getToastTemperature()){
            getTortilla().setCurrentTemperature(
                    getTortilla().getCurrentTemperature() + getHeatLevel());
            getQueso().setCurrentTemperature(
                    getQueso().getCurrentTemperature() + getHeatLevel());
            if (getTortilla().getCurrentTemperature()
                    >= getTortilla().getToastTemperature()) {
                getTortilla().toast(true);
            }
            if (getTortilla2().getCurrentTemperature()
                    >= getTortilla2().getToastTemperature()) {
                getTortilla2().toast(true);
            }
            if (getQueso().getCurrentTemperature()
                    >= getQueso().getMeltingTemperature()) {
                getQueso().melt(true);
            }
        }
        //tortilla 1 tostada, tortilla 2 tostada, queso derretido (1, 1, 1)
        if (getQueso().isMelted() && getTortilla().isToasted() && getTortilla2().isToasted()) {
            return "Perfect double quesadilla";
        }
        //tortilla 1 tostada, tortilla 2 tostada, queso no derretido (1, 1, 0)
        if (!getQueso().isMelted() && getTortilla().isToasted() && getTortilla2().isToasted()) {
            return "Terrible double quesadilla";
        }
        //tortilla 1 no tostada, tortilla 2 tostada, queso derretido (0, 1, 1)
        if (getQueso().isMelted() && (!getTortilla().isToasted() && getTortilla2().isToasted() ||
                getTortilla().isToasted() && !getTortilla2().isToasted())) {
            return "Fair double quesadilla";
        }
        //tortilla 1 no tostada, tortilla 2 tostada, queso no derretido (0, 1, 0)
        if (!getQueso().isMelted() && (!getTortilla().isToasted() && getTortilla2().isToasted() ||
                getTortilla().isToasted() && !getTortilla2().isToasted())) {
            return "Mediocre double quesadilla";
        }
        //tortilla 1 no tostada, tortilla 2 no tostada, queso derretido (0, 0, 1)
        if (getQueso().isMelted() && !getTortilla().isToasted() && !getTortilla2().isToasted()) {
            return "Good double quesadilla";
        } else {
            return "You ran out of gas";
        }

    }

    /**
     * @return Regresa el objeto del Queso utilizado
     */
    public final Queso getQueso() {
        return this.queso;
    }

    /**
     *  @param  quesoNuevo que se va a utilizar
     */
    public final void setQueso(final Queso quesoNuevo) {
        this.queso = quesoNuevo;
    }

    /**
     * @return Objeto de la Tortilla utilizada
     */
    public final Tortilla getTortilla() {
        return this.tortilla;
    }

    /**
     * @return Objeto de la Tortilla2 utilizada
     */
    public final Tortilla getTortilla2() {
        return this.tortilla2;
    }

    /**
     *  @param  tortillaNueva que se va a utilizar
     */
    public final void setTortilla(final Tortilla tortillaNueva) {
        this.tortilla = tortillaNueva;
    }

    /**
     * @return Nivel de calor
     */
    public final int getHeatLevel() {
        return this.heatLevel;
    }

    /**
     *  @param  heatLevelNew que se va a establecer
     */
    public final void setHeatLevel(final int heatLevelNew) {
        this.heatLevel = heatLevelNew;
    }
}
