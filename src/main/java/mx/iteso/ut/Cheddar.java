package mx.iteso.ut;

/**
 *
 */
public class Cheddar implements Queso {
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
    public Cheddar() {
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
     * @return melting temperature
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
     * @param sMelted melted
     */
    public final void melt(final boolean sMelted) {
        this.melted = sMelted;
    }
}
