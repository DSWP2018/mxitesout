package mx.iteso.ut;

/**
 * Quesadilla Class.
 */
public class Quesadilla {
    /**
     * Instance Variable Queso for making the quesadilla.
     */
    private Queso queso;
    /**
     * Instance Variable Tortilla for making the quesadilla.
     */
    private Tortilla tortilla;
    /**
     * Instance Variable Tortilla2 for making the DoubleQuesadilla.
     */
    private Tortilla tortilla2;
    /**
     * Member Variable for tracking the heatLevel
     * at wiche our ingredients are beign cook.
     */
    private int heatLevel;


    /**
     * Instance method for cooking one quesadilla.
     * @return string value
     */
    public final String prepareSingle() {
        queso = getQueso();
        tortilla = getTortilla();
        while (queso.getCurrentTemp() < queso.getMeltingTemp()
                && tortilla.getCurrentTemp() < tortilla.getToastTemp()) {
            tortilla.setTemp(tortilla.getCurrentTemp() + getHeatLevel());
            queso.setTemp(queso.getCurrentTemp() + getHeatLevel());

            if (tortilla.getCurrentTemp() >= tortilla.getToastTemp()) {
                tortilla.toast(true);
            }
            if (queso.getCurrentTemp() >= queso.getMeltingTemp()) {
                queso.melt(true);
            }
        }

        if (queso.isMelted() && tortilla.isToasted()) {
            return "Perfect quesadilla";
        }
        if (queso.isMelted() && !tortilla.isToasted()) {
            return "Good quesadilla";
        }
        if (!queso.isMelted() && tortilla.isToasted()) {
            return "Terrible quesadilla";
        } else {
            return "You ran out of gas";
        }
    }

    /**
     * Instance method for cooking a double quesadilla.
     * @return string value
     */
    public final String prepareDouble() {
        queso = getQueso();
        tortilla = getTortilla();
        tortilla2 = getTortilla2();
        while (queso.getCurrentTemp() < queso.getMeltingTemp()
                && tortilla.getCurrentTemp() < tortilla.getToastTemp()
                && tortilla2.getCurrentTemp() < tortilla2.getToastTemp()) {
            tortilla2.setTemp(tortilla2.getCurrentTemp() + getHeatLevel());
            tortilla.setTemp(tortilla.getCurrentTemp() + getHeatLevel());
            queso.setTemp(queso.getCurrentTemp() + getHeatLevel());
            if (tortilla2.getCurrentTemp() >= tortilla2.getToastTemp()) {
                tortilla2.toast(true);
            }
            if (tortilla.getCurrentTemp() >= tortilla.getToastTemp()) {
                tortilla.toast(true);
            }
            if (queso.getCurrentTemp() >= queso.getMeltingTemp()) {
                queso.melt(true);
            }
        }

        if (queso.isMelted() && tortilla.isToasted()
                && tortilla2.isToasted()) {
            return "Tortilla 1 tostada, "
                    + "tortilla 2 tostada, queso derretido.";
        } else if (queso.isMelted() && tortilla.isToasted()
                && !tortilla2.isToasted()) {
            return "Tortilla 1 tostada, "
                    + "tortilla 2 no tostada, queso derretido.";
        } else if (queso.isMelted()
                && !tortilla.isToasted() && tortilla2.isToasted()) {
            return "Tortilla 1 no tostada, "
                   + "tortilla 2 tostada, queso derretido.";
        } else if (queso.isMelted()
                && !tortilla.isToasted() && !tortilla2.isToasted()) {
            return "Tortilla 1 no tostada, "
                   + "tortilla 2 no tostada, queso derretido.";
        } else if (!queso.isMelted()
                && tortilla.isToasted() && tortilla2.isToasted()) {
            return "Tortilla 1 tostada, "
                   + "tortilla 2 tostada, queso no derretido.";
        } else if (!queso.isMelted()
                && !tortilla.isToasted() && tortilla2.isToasted()) {
            return "Tortilla 1 no tostada, "
                   + "tortilla 2 tostada, queso no derretido.";
        } else if (!queso.isMelted()
                && tortilla.isToasted() && !tortilla2.isToasted()) {
            return "Tortilla 1 tostada, "
                   + "tortilla 2 no tostada, queso no derretido.";
        } else {
            return "You ran out of gas";
        }
    }

    /**
     * Getter for queso.
     * @return Queso value
     */
    public final Queso getQueso() {
        return queso;
    }

    /**
     * Setter for queso.
     * @param q **Set member variable queso**
     */
    public final void setQueso(final Queso q) {
        this.queso = q;
    }

    /**
     * Getter for tortilla.
     * @return Tortilla value
     */
    public final Tortilla getTortilla() {
        return tortilla;
    }

    /**
     * Setter for tortilla.
     * @param t **Set member variable tortilla**
     */
    public final void setTortilla(final Tortilla t) {
        this.tortilla = t;
    }
    /**
     * Getter for tortilla.
     * @return Tortilla value
     */
    public final Tortilla getTortilla2() {
        return tortilla2;
    }

    /**
     * Setter for tortilla.
     * @param t **Set member variable tortilla**
     */
    public final void setTortilla2(final Tortilla t) {
        this.tortilla2 = t;
    }
    /**
     * Getter for heat level.
     * @return int value
     */
    public final int getHeatLevel() {
        return heatLevel;
    }

    /**
     * Setter for heat level.
     * @param hl **Set member variable heat level**
     */
    public final void setHeatLevel(final int hl) {
        this.heatLevel = hl;
    }

}
