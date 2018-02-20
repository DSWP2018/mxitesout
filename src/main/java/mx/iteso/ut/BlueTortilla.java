package mx.iteso.ut;

/**
 *
 */
public class BlueTortilla implements Tortilla {
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
    public BlueTortilla() {
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
     * @return toast temperature
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
     * @param sToasted toasted
     */
    public final void toast(final boolean sToasted) {
        this.toasted = sToasted;
    }
}
