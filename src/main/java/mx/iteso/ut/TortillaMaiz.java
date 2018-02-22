package mx.iteso.ut;

/** Class TortillaMaiz. /*
 *
 */
public class TortillaMaiz implements Tortilla {
    /** Declare variables. */
    private boolean toasted; /** Boolean toasted. */
    static final int TT = 70; /** Toasted temperature. */
    static final int CT = 25; /** Current temperature. */
    private int toastTemperature = TT; /** int ToastTemperature. */
    private int currentTemperature = CT; /**int currentTemperature. */

    /**Constructor TortillaMaiz. /*
     *
     */
    public TortillaMaiz() {
        toasted = false;
    }

    /** Method isToasted. /*
     *
     * @return if the tortilla isToasted.
     */
    public final boolean isToasted() {
        return toasted;
    }

    /** Method getToastTemperature. /*
     *
     * @return Toast temperature.
     */
    public final int getToastTemperature() {
        return toastTemperature;
    }

    /** Method getCurrentTemperature. /*
     *
     * @return Current temperature.
     */
    public final int getCurrentTemperature() {
        return currentTemperature;
    }

    /** Method setCurrentTemperature. /*
     *
     * @param temp the new actual temperature.
     */
    public final void setCurrentTemperature(final int temp) {
        currentTemperature = temp;
    }

    /** Method toast. /*
     *
     * @param iftoast if the Tortilla is toasted.
     */
    public final void toast(final boolean iftoast) {
        this.toasted = iftoast;
    }
}

