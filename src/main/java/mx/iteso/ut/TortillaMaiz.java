package mx.iteso.ut;

/**
 * .
 */
public class TortillaMaiz implements Tortilla {

    /**
     * .
     */
    private boolean toasted;
    /**
     * .
     */
    private int temperature;
    /**
     * .
     */
    private int toastingt;

    /**
     * .
     * @return devuelve estado de la tortilla.
     */
    public final boolean isToasted() {
        return this.toasted;
    }

    /**
     * .
     * @return devuelve temp de tostado.
     */
    public final int getToastTemperature() {
        return this.toastingt;
    }

    /**
     *
     * @return devuelve temp actual
     */
    public final int getCurrentTemperature() {
        return this.temperature;
    }

    /**
     * .
     * @param temp temperatura a fijarle a la tortilla.
     */
    public final void setCurrentTemperature(final int temp) {
        this.temperature = temp;
    }

    /**
     * .
     * @param toasts fija el estado de la tortilla.
     */
    public final void toast(final boolean toasts) {
        this.toasted = toasts;
    }
}
