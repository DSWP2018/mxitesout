package mx.iteso.ut;

/**
 *
 */
public class YellowTortilla implements Tortilla {
    /**
     * toasted.
     */
    private boolean toasted;
    /**
     * toast temperature.
     */
    private final int toastTemperature;
    /**
     * current temperature.
     */
    private int currentTemperature;

    /**
     * constructor.
     */
    public YellowTortilla() {
        toasted = false;
        toastTemperature = 0;
        currentTemperature = 0;
    }

    /**
     *
     * @return toasted
     */
    public final boolean isToasted() {
        return toasted;
    }

    /**
     *
     * @return toast temperatyure
     */
    public final int getToastTemperature() {
        return toastTemperature;
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
     * @param temp New temperature
     */
    public final void setCurrentTemperature(final int temp) {
        currentTemperature = temp;
    }

    /**
     *
     * @param sToasted True or false if the tortilla is toasted or not
     */
    public final void toast(final boolean sToasted) {
        this.toasted = sToasted;
    }
}
