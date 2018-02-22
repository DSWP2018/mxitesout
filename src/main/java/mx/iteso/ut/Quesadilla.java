/**
 * Hello world!
 *
 * @author Julián
 */
package mx.iteso.ut;

/** Clase quesadilla.*/
public class Quesadilla {

    /**Declaracion de variables. */
    private Queso queso; /** Queso.*/
    private Tortilla tortilla; /**Tortilla.*/
    private Tortilla tortilla2; /**Tortilla2.*/
    private int heatLevel; /**Heat level.*/
    /**@return */
    final String prepareSingle() { /**metodo prepareSingle.*/

    //Se cambia el || por &&
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
         }  else {
             getTortilla().toast(false);
         }
         if (getQueso().getCurrentTemperature()
                 >= getQueso().getMeltingTemperature()) {
             getQueso().melt(true);
         } else {
             getQueso().melt(false);
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

    /**@return */
    final String prepareDouble() { /**metodo prepareSingle.*/

        //Se cambia el || por &&
        while (getQueso().getCurrentTemperature()
                < getQueso().getMeltingTemperature()
                && getTortilla().getCurrentTemperature()
                < getTortilla().getToastTemperature()
                && getTortilla2().getCurrentTemperature()
                < getTortilla2().getToastTemperature()) {
            getTortilla().setCurrentTemperature(
                    getTortilla().getCurrentTemperature() + getHeatLevel());
            getQueso().setCurrentTemperature(
                    getQueso().getCurrentTemperature() + getHeatLevel());
            getTortilla2().setCurrentTemperature(
                    getTortilla2().getCurrentTemperature() + getHeatLevel());
            if (getTortilla().getCurrentTemperature()
                    >= getTortilla().getToastTemperature()) {
                getTortilla().toast(true);
            }  else {
                getTortilla().toast(false);
            }
            if (getQueso().getCurrentTemperature()
                    >= getQueso().getMeltingTemperature()) {
                getQueso().melt(true);
            } else {
                getQueso().melt(false);
            }
            if (getTortilla2().getCurrentTemperature()
                    >= getTortilla2().getToastTemperature()) {
                getTortilla2().toast(true);
            } else {
                getTortilla2().toast(false);
            }
        }

        if (getQueso().isMelted() && getTortilla().isToasted()
                && getTortilla2().isToasted()) {
            return "Perfect quesadilla doble";
        }
        if (getQueso().isMelted() && !getTortilla().isToasted()
                && getTortilla2().isToasted()) {
            return "Very Good quesadilla doble";
        }
        if (getQueso().isMelted() && getTortilla().isToasted()
                && !getTortilla2().isToasted()) {
            return "Good quesadilla doble";
        }
        if (getQueso().isMelted() && !getTortilla().isToasted()
                && !getTortilla2().isToasted()) {
            return "Bad quesadilla doble";
        }
        if (!getQueso().isMelted() && getTortilla().isToasted()
                && getTortilla2().isToasted()) {
            return "Very Bad quesadilla doble";
        }
        if (!getQueso().isMelted() && !getTortilla().isToasted()
                && getTortilla2().isToasted()) {
            return "Terrible quesadilla doble";
        } else {
            return "You ran out of gas on quesadilla doble";
        }
    }


    /**Metodo getQueso. */
    /** @return */
    public final Queso getQueso() {
        return queso;
    }

    /**Metodo setQueso.
     * @param quesoa  define el queso de la quesadilla. */
    public final void setQueso(final Queso quesoa) {
        this.queso = quesoa;
    }

    /**Metodo getTortilla. */
    /** @return */
    public final Tortilla getTortilla() {
        return tortilla;
    }

    /**Metodo getTortilla2*/
    /**@return */
    public final Tortilla getTortilla2() {
        return tortilla2;
    }

    /**Metodo setTortilla.
     * @param tortillaa define la tortilla de la quesadilla. */
    public final void setTortilla(final Tortilla tortillaa) {
        this.tortilla = tortillaa;
    }

    /**Metodo setTortilla2*/
    /**@param tortillaa2  define la segunda tortilla*/
    public final void setTortilla2(final Tortilla tortillaa2) {
        this.tortilla2 = tortillaa2;
    }

    /**Metodo getHeatLevel. */
    /** @return */
    public final int getHeatLevel() {
        return heatLevel;
    }

    /**Metodo setHeatLevel.
     * @param heatLevela define el heatlevet del fuego. */
    public final void setHeatLevel(final int heatLevela) {
        this.heatLevel = heatLevela;
    }
}

