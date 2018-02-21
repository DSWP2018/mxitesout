package mx.iteso.ut;

/**
 * Queso chihuahua class.
 */
public class QuesoChihuahua implements Queso {
    /**
     * Instance Variable melted.
     */
    private boolean melted;
    /**
     * Instance Variable temperature.
     */
    private int temperature;
    /**
     * Instance Variable melting.
     */
    private int melting;
    /**
     * Instance method for checking if the instance is melted.
     * @return boolean value
     */
    public final boolean isMelted() {
        return this.melted;
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
    public final int getMeltingTemp() {
        return this.melting;
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
     * @param melt **name of variable**
     */
    public final void melt(final boolean melt) {
        this.melted = melt;
    }
}
