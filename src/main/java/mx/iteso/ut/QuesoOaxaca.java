package mx.iteso.ut;

/**
 * Clase tipo Queso.
 */
public class QuesoOaxaca implements Queso {
    /**
     * Variable que indica la temperatura.
     * para derretir el queso oaxaca.
     */
    private static final int MELTING_TEMPERATURE = 22;
    /**
     * Variable que indica si el queso
     * está derretido.
     */
    private boolean melted;
    /**
     * Variable que indica la temp actual.
     */
    private int currentTemperature;

    /**
     * Metodo de construccion.
     */
    public QuesoOaxaca() {
        this.melted = false;
        this.currentTemperature = 0;
    }

    /**
     * @return devuelve verdadero
     * si el queso esta derretido
     * y falso, de lo contrario
     */
    public final boolean isMelted() {
        return melted;
    }

    /**
     * @return regresa la temperatura actual
     */

    public final int getCurrentTemperature() {
        return currentTemperature;
    }

    /**
     * @return regresa la temperatura
     * necesaria para que el queso
     * se derrita
     */
    public final int getMeltingTemperature() {
        return MELTING_TEMPERATURE;
    }

    /**
     * @param temp modifica temp actual
     */

    public final void setCurrentTemperature(final int temp) {
        this.currentTemperature = temp;
    }

    /**
     * @param meltedNew modifica el status
     *                  del queso
     */
    public final void melt(final boolean meltedNew) {
        this.melted = meltedNew;
    }
}

