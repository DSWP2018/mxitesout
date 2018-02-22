package mx.iteso.ut;

/** Class QuesoManchego. /*
 *
 */
public class QuesoManchego implements Queso {
    /**Declare variables.*/

    private boolean melted; /** Boolean melted.*/
    static final int MT = 80; /**Melting temperature.*/
    static final int CT = 25; /**Current temperature.*/
    private int meltingTemperature = MT; /** Int meltingTemp.*/
    private int currentTemperature = CT; /** Int currentTemp.*/

    /** Constructor QuesoManchego. /*
     *
     */
    public QuesoManchego() {
        melted = false;
    }

    /** Method isMelted. /*
     *
     * @return if the Queso is melted.
     */
    public final boolean isMelted() {
        return melted;
    }

    /**Method getCurrentTemperature. /*
     *
     * @return the current temperature.
     */
    public final int getCurrentTemperature() {
        return currentTemperature;
    }

    /** Method getMeltingTemperature. /*
     *
     * @return the melting temperature.
     */
    public final int getMeltingTemperature() {
        return meltingTemperature;
    }

    /**Method setCurrentTemperature. /*
     *
     * @param temp set the new temperature.
     */
    public final void setCurrentTemperature(final int temp) {
        this.currentTemperature = temp;
    }

    /**Method melt. /*
     *
     * @param ifmelted set when is melted.
     */
    public final void melt(final boolean ifmelted) {
        this.melted = ifmelted;
    }
}
