package mx.iteso.ut;

/**
 * Tortilla de harina class.
 */
public class TortillaHarina implements Tortilla {
    /**
     * Instance Variable toasted.
     */
    private boolean toasted;
    /**
     * Instance Variable temperature.
     */
    private int temperature;
    /**
     * Instance Variable toast temperature.
     */
    private int toastTemp;
    /**
     * Instance method for checking if the instance is melted.
     * @return boolean value
     */
    public final boolean isToasted() {
        return this.toasted;
    }
    /**
     * Getter for current temperature.
     * @return int value
     */
    public final int getCurrentTemp() {
        return this.temperature;
    }
    /**
     * Getter for melting temperature.
     * @return int value
     */
    public final int getToastTemp() {
        return this.toastTemp;
    }
    /**
     * Setter for temperature.
     * @param temp **name of variable**
     */
    public final void setTemp(final int temp) {
        this.temperature = temp;
    }
    /**
     * Instance method for melting the instance.
     * @param toasting **name of variable**
     */
    public final void toast(final boolean toasting) {
        this.toasted = toasting;
    }
}
