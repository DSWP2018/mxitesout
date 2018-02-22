package mx.iteso.ut;

/**
 *
 */
public class QuesoOaxaca implements Queso {

    /**
     *
     */
    private boolean melted;
    /**
     *
     */
    private int temperature;
    /**
     *
     */
    private int meltingTemperature;

    /**
     *
     * @param meltingTemp set the meltingTemperature
     * @param temp set current temp
     */
    public QuesoOaxaca(final int meltingTemp, final int temp) {
        this.meltingTemperature = meltingTemp;
        this.temperature = temp;
        melted = false;
    }

    /**
     *
     * @return a boolean value if the cheese is melted
     */
    public final boolean isMelted() {
        return melted;
    }

    /**
     *
     * @return an integer value that indicates the current
     * temperature of the cheese
     */
    public final int getCurrentTemperature() {
        return temperature;
    }

    /**
     *
     * @return the temperatures in which the cheese gets melted
     */
    public final int getMeltingTemperature() {
        return this.meltingTemperature;
    }

    /**
     *
     * @param temp to set the current temperature of the cheese
     */
    public final void setCurrentTemperature(final int temp) {
        this.temperature = temp;
    }

    /**
     *
     * @param pMelted sets if the cheese is melted
     */
    public final void melt(final boolean pMelted) {
        this.melted = melted;
    }
}
