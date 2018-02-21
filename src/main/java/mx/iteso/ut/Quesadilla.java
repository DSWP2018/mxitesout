package mx.iteso.ut;

/**
 * @author  Francisco Camacho
 * @version 1.0
 * @since   02-08-2018
 */
public class Quesadilla {
    /**
     * @param variable de tipo Queso
     */
    private Queso queso;
    /**
     * @param variable de tipo Tortilla
     */
    private Tortilla tortilla;
    /**
     * @param variable para el heatLevel
     */
    private int heatLevel;
    /**
     * @return se ejecuta prepare single para preparar qusadillas
     * con cierto queso y tortilla
     */
    public final String prepareSingle() {
        while (getQueso().getCurrentTemp()
                < getQueso().getMeltingTemp()
                && getTortilla().getCurrentTemp()
                < getTortilla().getToastTemp()) {
            getTortilla().setCurrentTemp(getTortilla().getCurrentTemp()
                    + getHeatLevel());
            getQueso().setCurrentTemp(getQueso().getCurrentTemp()
                    + getHeatLevel());
            if (getTortilla().getCurrentTemp()
                    >= getTortilla().getToastTemp()) {
                getTortilla().toast(true);
            }
            if (getQueso().getCurrentTemp()
                    >= getQueso().getMeltingTemp()) {
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
    /**
     * @return se ejecuta prepare double para preparar qusadillas
     * con cierto queso y tortilla
     */
    public final String prepareDouble() {
        // tortilla 1 tostada, tortilla 2 tostada, queso derretido
        // tortilla 1 no tostada, tortilla 2 tostada, queso derretido
        // tortilla 1 no tostada, tortilla 2 tostada, queso no derretido
        // tortilla 1 no tostada, tortilla 2 no tostada, queso no derretido
        // tortilla 1 no tostada, tortilla 2 no tostada, queso derretido
        // tortilla 1 tostada, tortilla 2 tostada, queso no derretido
        return " ";
    }
    /**
     * @return regresa el queso
     */
    public final Queso getQueso() {
        return queso;
    }
    /**
     * @param elqueso es pasado como parametro
     */
    public final void setQueso(final Queso elqueso) {
        this.queso = elqueso;
    }
    /**
     * @return regresa tortilla
     */
    public final Tortilla getTortilla() {
        return tortilla;
    }
    /**
     * @param latortilla es pasado como parametro
     */
    public final void setTortilla(final Tortilla latortilla) {
        this.tortilla = latortilla;
    }
    /**
     * @return regresa el heatLevel
     */
    public final int getHeatLevel() {
        return heatLevel; // toasting temperature
    }
    /**
     * @param theheatLevel es pasado como parametro
     */
    public final void setHeatLevel(final int theheatLevel) {
        this.heatLevel = theheatLevel;
    }
}
