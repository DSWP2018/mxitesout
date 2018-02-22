package mx.iteso.ut;

/**
 * @author Mariana Sierra Vega
 *
 */

/**Class Quesadilla. */
public class Quesadilla {

    /**Declare variables. */
    private Queso queso; /**Queso.*/
    private Tortilla tortilla1; /**Tortilla. 1*/
    private Tortilla tortilla2; /**Tortilla. 2*/
    private int heatLevel; /**Heat Level.*/

    /** @return String with the preparation result of the quesadilla */
    final String prepareSingle() {


        while (getQueso().getCurrentTemperature()
                < getQueso().getMeltingTemperature()
                && getTortilla1().getCurrentTemperature()
                < getTortilla1().getToastTemperature()) {
            getTortilla1().setCurrentTemperature(
                    getTortilla1().getCurrentTemperature()
                            + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature()
                    + getHeatLevel());
            if (getTortilla1().getCurrentTemperature()
                    >= getTortilla1().getToastTemperature()) {
                getTortilla1().toast(true);
            }
            if (getQueso().getCurrentTemperature()
                    >= getQueso().getMeltingTemperature()) {
                getQueso().melt(true);
            }
        }

        if (getQueso().isMelted() && getTortilla1().isToasted()) {
            return "Perfect quesadilla";
        }
        if (getQueso().isMelted() && !getTortilla1().isToasted()) {
            return "Good quesadilla";
        }
        if (!getQueso().isMelted() && getTortilla1().isToasted()) {
            return "Terrible quesadilla";
        } else {
            return "You ran out of gas";
        }
    }

    /** @return String with the preparation of a double Quesadilla */
    final String prepareDouble() {
        while (getQueso().getCurrentTemperature()
                < getQueso().getMeltingTemperature()
                && getTortilla1().getCurrentTemperature()
                < getTortilla1().getToastTemperature()
                && getTortilla2().getCurrentTemperature()
                < getTortilla2().getToastTemperature()) {
            getTortilla1().setCurrentTemperature(
                    getTortilla1().getCurrentTemperature()
                            + getHeatLevel());
            getTortilla2().setCurrentTemperature(
                    getTortilla2().getCurrentTemperature()
                            + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature()
                    + getHeatLevel());
            if (getTortilla1().getCurrentTemperature()
                    >= getTortilla1().getToastTemperature()) {
                getTortilla1().toast(true);
            }
            if (getQueso().getCurrentTemperature()
                    >= getQueso().getMeltingTemperature()) {
                getQueso().melt(true);
            }
            if (getTortilla2().getCurrentTemperature()
                    >= getTortilla2().getToastTemperature()) {
                getTortilla2().toast(true);
            }
        }

        if (getQueso().isMelted() && getTortilla1().isToasted()
                && getTortilla2().isToasted()) {
            return "Perfect quesadilla";
        }
        if (getQueso().isMelted() && !getTortilla1().isToasted()
                && !getTortilla2().isToasted()) {
            return "Both tortillas not toasted but queso melted";
        }
        if (!getQueso().isMelted() && getTortilla1().isToasted()
                && getTortilla2().isToasted()) {
            return "Tortillas toasted but queso not melted";
        }
        if (getQueso().isMelted() && getTortilla1().isToasted()
                && !getTortilla2().isToasted()) {
            return "Queso melted and tortilla 1 toasted but "
                    + "tortilla 2 not toasted";
        }
        if (getQueso().isMelted() && !getTortilla1().isToasted()
                && getTortilla2().isToasted()) {
            return "Queso melted and tortilla 2 toasted but "
                    + "tortilla 1 not toasted";
        }
        if (!getQueso().isMelted() && !getTortilla1().isToasted()
                && getTortilla2().isToasted()) {
            return "Queso not melted and tortilla 2 not toasted "
                   + "but tortilla 1 toasted";
        } else {
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

    /**Method getTortilla1/*.
     *
     * @return Get the Tortilla of the Quesadilla.
     */
    public final Tortilla getTortilla1() {
        return tortilla1;
    }

    /** Method setTortilla1/*.
     *
      * @param newTortilla the Tortilla to set to the Quesadilla.
     */
    public final void setTortilla1(final Tortilla newTortilla) {
        this.tortilla1 = newTortilla;
    }

    /**Method getTortilla2/*.
     *
     * @return Get the Tortilla of the Quesadilla.
     */
    public final Tortilla getTortilla2() {
        return tortilla2;
    }

    /** Method setTortilla2/*.
     *
     * @param newTortilla the Tortilla to set to the Quesadilla.
     */
    public final void setTortilla2(final Tortilla newTortilla) {
        this.tortilla2 = newTortilla;
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
