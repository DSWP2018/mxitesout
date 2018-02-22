package mx.iteso.ut;

/**
 *
 */
public class TortillaMaiz implements Tortilla {
    /**
     *
     */
    private boolean toasted;
    /**
     *
     */
    private int temperature;
    /**
     *
     */
    private int toastTemperature;

    /**
     *
     * @param toastTemp the toast temp
     */
    public TortillaMaiz(final int toastTemp) {
        this.toastTemperature = toastTemp;
    }
    /**
     *
     * @return a boolean value if the tortilla is toasted
     */
    public final boolean isToasted() {
        return toasted;
    }

    /**
     *
     * @return an int value with the temperature
     * in which the tortilla gets toasted
     */
    public final int getToastTemperature() {
        return toastTemperature;
    }

    /**
     *
     * @return an int value with the current tortilla temperature
     */
    public final int getCurrentTemperature() {
        return temperature;
    }

    /**
     *
     * @param  temp set the current temperature of the tortilla
     */
    public final void setCurrentTemperature(final int temp) {
        this.temperature = temp;
    }

    /**
     *
     * @param pToasted indicates if the tortilla is toasted lol
     */
    public final void toast(final boolean pToasted) {
        this.toasted = pToasted;
    }
}
