package mx.iteso.ut;

/**
 *
 */
public class Quesadilla {
    /**
     * Queso.
     */
    private Queso queso;
    /**
     * Tortilla.
     */
    private Tortilla tortilla;
    /**
     * Heatlevel.
     */
    private int heatLevel;

    /**
     *
     * @return Returns quesadilla status
     */
    public final String prepareSingle() {
        while (getQueso().getCurrentTemperature() < getQueso().getMeltingTemperature() && getTortilla().getCurrentTemperature() < getTortilla().getToastTemperature()) {

            getTortilla().setCurrentTemperature(getTortilla().getCurrentTemperature() + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature() + getHeatLevel());


            if (getTortilla().getCurrentTemperature() >= getTortilla().getToastTemperature()) {
                getTortilla().toast(true);
            }

            if (getQueso().getCurrentTemperature() >= getQueso().getMeltingTemperature()) {
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
     * @return Returns queso object
     */
    public final Queso getQueso() {
        return queso;
    }

    /**
     *
     * @param quesoo queso
     */
    public final void setQueso(final Queso quesoo) {
        this.queso = quesoo;
    }

    /**
     *
     * @return Returns tortilla object
     */
    public final Tortilla getTortilla() {
        return tortilla;
    }

    /**
     *
     * @param tortillaa totilla
     */
    public final void setTortilla(final Tortilla tortillaa) {
        this.tortilla = tortillaa;
    }

    /**
     *
     * @return Returns heat level
     */
    public final int getHeatLevel() {
        return heatLevel;
    }

    /**
     *
     * @param heatLevel1 Heatlevel
     */
    public final void setHeatLevel(final int heatLevel1) {
        this.heatLevel = heatLevel1;
    }
}
