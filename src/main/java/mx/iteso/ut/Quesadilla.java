package mx.iteso.ut;

/**
 * Hello world!
 *
 */
public class Quesadilla {
    /**
     * queso.
     */
    private Queso queso;
    /**
     * tortilla.
     */
    private Tortilla tortilla;
    /**
     * heat level.
     */
    private int heatLevel;

    /**
     *
     * @return the string for you quesadillita
     */
    public final String prepareSingle() {

        while (getQueso().getCurrentTemperature()
                 < getQueso().getMeltingTemperature()
                && getTortilla().getCurrentTemperature()
                 < getTortilla().getToastTemperature()) {
                    getTortilla().setCurrentTemperature(
                            getTortilla().getCurrentTemperature()
                                    + getHeatLevel()
                    );
                    getQueso().setCurrentTemperature(
                        getQueso().getCurrentTemperature() + getHeatLevel()
                    );
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

    /**
     *
     * @return string for a double quesadilla
     */
    public final String prepareDouble() {
        // tortilla 1 tostada, tortilla 2 tostada, queso derretido
        // tortilla 1 no tostada, tortilla 2 tostada, queso derretido
        // tortilla 1 no tostada, tortilla 2 tostada, queso no derretido
        // tortilla 1 no tostada, tortilla 2 no tostada, queso no derretido
        // tortilla 1 no tostada, tortilla 2 no tostada, queso derretido
        // tortilla 1 tostada, tortilla 2 tostada, queso no derretido

        return "";
    }

    /**
     *
     * @return get the cheese
     */
    public final Queso getQueso() {
        return queso;
    }

    /**
     *
     * @param pQueso to set it.
     */
    public final void setQueso(final Queso pQueso) {
        this.queso = pQueso;
    }


    /**
     *
     * @return the tortillita
     */
    public final Tortilla getTortilla() {
        return tortilla;
    }

    /**
     *
     * @param pTortilla give me the tortilla
     */
    public final void setTortilla(final Tortilla pTortilla) {
        this.tortilla = pTortilla;
    }

    /**
     *
     * @return the heat level lol
     */
    public final int getHeatLevel() {
        return heatLevel;
    }

    /**
     *
     * @param pHeatLevel set the heat level jiji
     */
    public final void setHeatLevel(final int pHeatLevel) {
        this.heatLevel = pHeatLevel;
    }
}
