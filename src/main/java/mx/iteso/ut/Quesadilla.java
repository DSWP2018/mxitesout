package mx.iteso.ut;

/**
 * Hello world!
 *
 */
public class Quesadilla {
    /**
     *
     */
    private Queso queso;
    /**
     *
     */
    private Tortilla tortilla;
    /**
     *
     */
    private Tortilla tortillaB;
    /**
     *
     */
    private int heatLevel;

    /**
     * just for the checkpoint.
     * @return String
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

    /**
     * @return String
     */
    public final String prepareDouble() {
        // tortilla 1 tostada, tortilla 2 tostada, queso derretido
        // tortilla 1 no tostada, tortilla 2 tostada, queso derretido
        // tortilla 1 no tostada, tortilla 2 tostada, queso no derretido
        // tortilla 1 no tostada, tortilla 2 no tostada, queso no derretido
        // tortilla 1 no tostada, tortilla 2 no tostada, queso derretido
        // tortilla 1 tostada, tortilla 2 tostada, queso no derretido
        int currentTempTortilla1, currentTempTortilla2, currentTempQueso;
        int toastTempTortilla1, toastTempTortilla2;
        int meltingTempQueso;

        Tortilla tortilla1 = getTortilla();
        Tortilla tortilla2 = getTortilla2();
        Queso queso1 = getQueso();

        toastTempTortilla1 = tortilla1.getToastTemperature();
        toastTempTortilla2 = tortilla2.getToastTemperature();
        meltingTempQueso = queso1.getMeltingTemperature();

        currentTempTortilla1 = tortilla1.getCurrentTemperature();
        currentTempTortilla2 = tortilla2.getCurrentTemperature();
        currentTempQueso = queso1.getCurrentTemperature();

        while (currentTempTortilla1 < toastTempTortilla1
                && currentTempTortilla2 < toastTempTortilla2
                && currentTempQueso < meltingTempQueso) {
            tortilla1.setCurrentTemperature(currentTempTortilla1 + heatLevel);
            tortilla2.setCurrentTemperature(currentTempTortilla2 + heatLevel);
            queso1.setCurrentTemperature(currentTempQueso
                    + currentTempQueso + heatLevel);

            currentTempTortilla1 = tortilla1.getCurrentTemperature();
            currentTempTortilla2 = tortilla2.getCurrentTemperature();
            currentTempQueso = queso1.getCurrentTemperature();

            tortilla1.toast(currentTempTortilla1 >= toastTempTortilla1);
            tortilla2.toast(currentTempTortilla2 >= toastTempTortilla2);
            queso1.melt(currentTempQueso >= meltingTempQueso);

        }

        boolean toastedT1, toastedT2, meltedQueso;
        toastedT1 = tortilla1.isToasted();
        toastedT2 = tortilla2.isToasted();
        meltedQueso = queso1.isMelted();

        if (toastedT1 && toastedT2 && meltedQueso) {
            return "Quesadilla Perfecta";
        } else if (!toastedT1 && !toastedT2 && !meltedQueso) {
            return "Nada logrado";
        } else if (!toastedT1 && !toastedT2) {
            return "Ninguna tortilla tostada";
        } else if (!toastedT1 && !meltedQueso) {
            return "Tortilla 1 sin tostar y queso sin derretir";
        } else if (!toastedT2 && !meltedQueso) {
            return "Tortilla 2 sin tostar y queso sin derretir";
        } else if (!toastedT1) {
            return "Tortilla 1 sin tostar";
        } else if (!toastedT2) {
            return "Tortilla 2 sin tostar";
        } else {
            return "Queso sin derretir";
        }
    }

    /**
     * @return Queso
     */
    public final Queso getQueso() {
        return queso;
    }

    /**
     * @param q q
     */
    public final void setQueso(final Queso q) {
        this.queso = q;
    }

    /**
     * @return Tortilla
     */
    public final Tortilla getTortilla() {
        return tortilla;
    }

    /**
     * @param t t
     */
    public final void setTortilla(final Tortilla t) {
        this.tortilla = t;
    }

    /**
     * @return Tortilla
     */
    public final Tortilla getTortilla2() {
        return tortillaB;
    }

    /**
     * @param t t
     */
    public final void setTortilla2(final Tortilla t) {
        this.tortillaB = t;
    }

    /**
     * @return int
     */
    public final int getHeatLevel() {
        return heatLevel;
    }

    /**
     * @param h h
     */
    public final void setHeatLevel(final int h) {
        this.heatLevel = h;
    }
}
