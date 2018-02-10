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
        Queso gqueso = getQueso();
        Tortilla gtortilla = getTortilla();
        boolean tMelting = gqueso.getCurrentTemp() < gqueso.getMeltingTemp();
        boolean tToast = gtortilla.getCurrentTemp() < gtortilla.getToastTemp();

         while (tMelting || tToast) {
             gtortilla.setCurrentTemp(gtortilla.getCurrentTemp()
                     + getHeatLevel());
             getQueso().setCurrentTemp(gqueso.getCurrentTemp()
                     + getHeatLevel());
             if (gtortilla.getCurrentTemp() >= gtortilla.getToastTemp()) {
                 getTortilla().toast(true);
             }
             if (getQueso().getCurrentTemp() >= getQueso().getMeltingTemp()) {
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
