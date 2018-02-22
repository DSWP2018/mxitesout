package mx.iteso.ut;
/**Clase QuesoManchego.*/
public class QuesoManchego implements Queso { /**clase manchego. */
    private boolean melted; /**Booleano de isMelted. */
    static final int CTEMPERATURE = 10; /**temperatura constante. */
    static final int MTEMPERATUREM = 45; /**mtemperature. */
    private int cTemperature = CTEMPERATURE; /**int temperatura actual.*/
    private int mTemperature = MTEMPERATUREM; /**int temperatura
                                            de derretimiento.*/

    /**@return */
    public final boolean isMelted() {
        return melted;
    }
    /**@return */
    public final int getCurrentTemperature() {
        return cTemperature;
    }
    /**@return */
    public final int getMeltingTemperature() {
        return mTemperature;
    }
    /**@param tempp */
    public final void setCurrentTemperature(final int tempp) {
        this.cTemperature = tempp;
    }
    /**@param meltedd */
    public final void melt(final boolean meltedd) {
        this.melted = meltedd;
    }
}
