package mx.iteso.ut;

/**Class Queso Adobera. */
public class QuesoAdobera implements Queso {
    /**Declare Variables. */
    private boolean melted; /**Melted.*/
    static final int MT = 60; /**constante mT.*/
    static final int CT = 25;  /**constante cT.*/
    private static int meltingTemperature = MT; /**Melting Temperature.*/
    private static int currentTemperature = CT; /**Current Temperature.*/


    /** Method isMelted. /*
     *
     * @return if the queso isMelted.
     */
    public final boolean isMelted() {
        return melted;
    }

    /** Method getCurrentTemperature. /*
     *
     * @return the current temperature.
     */
    public final int getCurrentTemperature() {
        return currentTemperature;
    }

    /** Method getMeltingTemperature. /*
     *
     * @return getting the melting temperature.
     */
    public final int getMeltingTemperature() {
        return meltingTemperature;
    }

    /** Method setCurrentTemperature. /*
     *
     * @param temp set the new temperature.
     */
    public final void setCurrentTemperature(final int temp) {
        this.currentTemperature = temp;
    }

    /** Method mel. /*
     *
     * @param ifmelted Set if is melted.
     */
    public final void melt(final boolean ifmelted) {
        this.melted = ifmelted;
    }
}
