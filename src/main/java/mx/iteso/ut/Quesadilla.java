package mx.iteso.ut;

/**
 * @author Mariana Sierra Vega
 *
 */

/**Class Quesadilla. */
public class Quesadilla {

    /**Declare variables. */
    private Queso queso; /**Queso.*/
    private Tortilla tortilla_1; /**Tortilla.*/
    private Tortilla tortilla_2;
    private int heatLevel; /**Heat Level.*/

    /** @return String with the preparation result of the quesadilla */
    final String prepareSingle() {


        while (getQueso().getCurrentTemperature()
                < getQueso().getMeltingTemperature()
                && getTortilla_1().getCurrentTemperature()
                < getTortilla_1().getToastTemperature()) {
            getTortilla_1().setCurrentTemperature(
                    getTortilla_1().getCurrentTemperature()
                            + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature()
                    + getHeatLevel());
            if (getTortilla_1().getCurrentTemperature()
                    >= getTortilla_1().getToastTemperature()) {
                getTortilla_1().toast(true);
            }
            if (getQueso().getCurrentTemperature()
                    >= getQueso().getMeltingTemperature()) {
                getQueso().melt(true);
            }
        }

        if (getQueso().isMelted() && getTortilla_1().isToasted()) {
            return "Perfect quesadilla";
        }
        if (getQueso().isMelted() && !getTortilla_1().isToasted()) {
            return "Good quesadilla";
        }
        if (!getQueso().isMelted() && getTortilla_1().isToasted()) {
            return "Terrible quesadilla";
        } else {
            return "You ran out of gas";
        }
    }

    /** @return String with the preparation of a double Quesadilla */
    final String prepareDouble() {
        while (getQueso().getCurrentTemperature()
                < getQueso().getMeltingTemperature()
                && getTortilla_1().getCurrentTemperature()
                < getTortilla_1().getToastTemperature()
                && getTortilla_2().getCurrentTemperature()
                < getTortilla_2().getToastTemperature()) {
            getTortilla_1().setCurrentTemperature(
                    getTortilla_1().getCurrentTemperature()
                            + getHeatLevel());
            getTortilla_2().setCurrentTemperature(
                    getTortilla_2().getCurrentTemperature()
                            + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature()
                    + getHeatLevel());
            if (getTortilla_1().getCurrentTemperature()
                    >= getTortilla_1().getToastTemperature()) {
                getTortilla_1().toast(true);
            }
            if (getQueso().getCurrentTemperature()
                    >= getQueso().getMeltingTemperature()) {
                getQueso().melt(true);
            }
            if (getTortilla_2().getCurrentTemperature()
                    >= getTortilla_2().getToastTemperature()) {
                getTortilla_2().toast(true);
            }
        }

        if (getQueso().isMelted() && getTortilla_1().isToasted() && getTortilla_2().isToasted() ) {
            return "Perfect quesadilla";
        }
        if (getQueso().isMelted() && !getTortilla_1().isToasted() && !getTortilla_2().isToasted()) {
            return "Both tortillas not toasted but queso melted";
        }
        if (!getQueso().isMelted() && getTortilla_1().isToasted() && getTortilla_2().isToasted()) {
            return "Tortillas toasted but queso not melted";
        }
        if (getQueso().isMelted() && getTortilla_1().isToasted() && !getTortilla_2().isToasted() ) {
            return "Queso melted and tortilla 1 toasted but tortilla 2 not toasted";
        }
        if (getQueso().isMelted() && !getTortilla_1().isToasted() && getTortilla_2().isToasted() ) {
            return "Queso melted and tortilla 2 toasted but tortilla 1 not toasted";
        }
        if (!getQueso().isMelted() && !getTortilla_1().isToasted() && getTortilla_2().isToasted() ) {
            return "Queso not melted and tortilla 2 not toasted but tortilla 1 toasted";
        }
        else {
            return "You ran out of gas";
        }
    }

    /** Method getQueso/*.
     *  @return Get the Queso inside the Quesadilla.
     */

    public final Queso getQueso() {
        return queso;
    }

    /**Method setQueso/*.
     *
     * @param newQueso the Queso to set to the Quesadilla.
     *
     */
    public final void setQueso(final Queso newQueso) {
        this.queso = newQueso;
    }

    /**Method getTortilla_1/*.
     *
     * @return Get the Tortilla of the Quesadilla.
     */
    public final Tortilla getTortilla_1() {
        return tortilla_1;
    }

    /** Method setTortilla_1/*.
     *
      * @param newTortilla the Tortilla to set to the Quesadilla.
     */
    public final void setTortilla_1(final Tortilla newTortilla) {
        this.tortilla_1 = newTortilla;
    }

    /**Method getTortilla_2/*.
     *
     * @return Get the Tortilla of the Quesadilla.
     */
    public final Tortilla getTortilla_2() {
        return tortilla_2;
    }

    /** Method setTortilla_2/*.
     *
     * @param newTortilla the Tortilla to set to the Quesadilla.
     */
    public final void setTortilla_2(final Tortilla newTortilla) {
        this.tortilla_2 = newTortilla;
    }



    /** Method getHeatLevel/*.
     *
     * @return Get the actual heat level.
     */
    public final int getHeatLevel() {
        return heatLevel;
    }

    /**Method setHeatLevel/*.
     *
     * @param newHeatLevel the new heat level.
     */
    public final void setHeatLevel(final int newHeatLevel) {
        this.heatLevel = newHeatLevel;
    }
}
