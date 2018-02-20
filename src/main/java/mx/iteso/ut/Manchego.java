package mx.iteso.ut;

/**
 *
 */
public class Manchego implements Queso {
    /**
     * melted.
     */
    private boolean melted;
    /**
     * current temperature.
     */
    private int currentTemperature;
    /**
     * melting temperature.
     */
    private final int meltingTemperature;

    /**
     * constructor.
     */
    public Manchego() {
        melted = false;
        currentTemperature = 0;
        meltingTemperature = 0;
    }


    /**
     *
     * @return melted
     */
    public final boolean isMelted() {
        return melted;
    }

    /**
     *
     * @return current temperature
     */
    public final int getCurrentTemperature() {
        return currentTemperature;
    }

    /**
     *
     * @return melting temp
     */
    public final int getMeltingTemperature() {
        return meltingTemperature;
    }

    /**
     *
     * @param temp New temperature
     */
    public final void setCurrentTemperature(final int temp) {
        currentTemperature = temp;
    }

    /**
     *
     * @param sMelted true or false if queso is melted or not
     */
    public final void melt(final boolean sMelted) {
        this.melted = sMelted;
    }
}
