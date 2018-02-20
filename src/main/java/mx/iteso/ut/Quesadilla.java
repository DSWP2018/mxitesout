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
     * Tortilla 1 for quesadilla.
     */
    private Tortilla tortilla1;
    /**
     * Tortilla 2 for quesadilla.
     */
    private Tortilla tortilla2;
    /**
     * Heatlevel.
     */
    private int heatLevel;

    /**
     *
     * @return Single status
     */
    public final String prepareSingle() {
        while (getQueso().getCurrentTemperature()
                < getQueso().getMeltingTemperature()
                && getTortilla1().getCurrentTemperature()
                < getTortilla1().getToastTemperature()) {

            getTortilla1().setCurrentTemperature(getTortilla1()
                    .getCurrentTemperature() + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso()
                    .getCurrentTemperature() + getHeatLevel());

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

    /**
     *
     * @return Double status
     */
    public final String prepareDouble() {
        while (getQueso().getCurrentTemperature()
                < getQueso().getMeltingTemperature()
                && getTortilla1().getCurrentTemperature()
                < getTortilla1().getToastTemperature()
                && getTortilla2().getCurrentTemperature()
                < getTortilla2().getToastTemperature()) {

            getTortilla1().setCurrentTemperature(getTortilla1()
                    .getCurrentTemperature() + getHeatLevel());
            getTortilla2().setCurrentTemperature(getTortilla2()
                    .getCurrentTemperature() + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso()
                    .getCurrentTemperature() + getHeatLevel());

            if (getTortilla1().getCurrentTemperature()
                    >= getTortilla1().getToastTemperature()) {
                getTortilla1().toast(true);
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


        // tortilla 1 tostada, tortilla 2 tostada, queso derretido
        if (getTortilla1().isToasted() && getTortilla2().isToasted()
                && getQueso().isMelted()) {
            return "Perfect double";
        }
        // tortilla 1 no tostada, tortilla 2 tostada, queso derretido
        if (!getTortilla1().isToasted() && getTortilla2().isToasted()
                && getQueso().isMelted()) {
            return "Almost a perfect double";
        }
        // tortilla 1 no tostada, tortilla 2 tostada, queso no derretido
        if (!getTortilla1().isToasted() && getTortilla2().isToasted()
                && !getQueso().isMelted()) {
            return "Terrible double";
        }
        // tortilla 1 no tostada, tortilla 2 no tostada, queso no derretido
        if (!getTortilla1().isToasted() && !getTortilla2().isToasted()
                && !getQueso().isMelted()) {
            return "You ran out of gas";
        }
        // tortilla 1 no tostada, tortilla 2 no tostada, queso derretido
        if (!getTortilla1().isToasted() && !getTortilla2().isToasted()
                && getQueso().isMelted()) {
            return "Good double";
        }
        // tortilla 1 tostada, tortilla 2 tostada, queso no derretido
        if (getTortilla1().isToasted() && getTortilla2().isToasted()
                && !getQueso().isMelted()) {
            return "Bad double";
        } else {
            return "The taste could be good...";
        }
    }

    /**
     *
     * @return queso
     */
    public final Queso getQueso() {
        return queso;
    }

    /**
     *
     * @param cheese queso
     */
    public final void setQueso(final Queso cheese) {
        this.queso = cheese;
    }

    /**
     *
     * @return tortilla1
     */
    public final Tortilla getTortilla1() {
        return tortilla1;
    }

    /**
     *
     * @param sTortilla1 tortilla1
     */
    public final void setTortilla1(final Tortilla sTortilla1) {
        this.tortilla1 = sTortilla1;
    }

    /**
     *
     * @return tortilla2
     */
    public final Tortilla getTortilla2() {
        return tortilla2;
    }

    /**
     *
     * @param sTortilla2 tortilla2
     */
    public final void setTortilla2(final Tortilla sTortilla2) {
        this.tortilla2 = sTortilla2;
    }

    /**
     *
     * @return heatlevel
     */
    public final int getHeatLevel() {
        return heatLevel;
    }

    /**
     *
     * @param temp temperature
     */
    public final void setHeatLevel(final int temp) {
        this.heatLevel = temp;
    }

}
