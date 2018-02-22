package mx.iteso.ut;
/**Clase QuesoOaxaca. */
public class QuesoOaxaca implements Queso { /**Clase Oaxaca.*/
    private boolean melted; /**melted. */
    static final int CTEMPERATUREC = 25; /**Constante ctemperature.*/
    static final int MTEMPERATUREC = 40; /**Constante mtemperature. */
    private int cTemperature = CTEMPERATUREC; /**ctemperature. */
    private int mTemperature = MTEMPERATUREC; /**mTemperature. */
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
    /**@param cTemp */
    public final void setCurrentTemperature(final int cTemp) {
        cTemperature = cTemp;
    }
    /**@param meltedd */
    public final void melt(final boolean meltedd) {
        this.melted = meltedd;
    }
}
