package mx.iteso.ut;

/**
 * léase QuesoChihuahua.
 */
public class QuesoManchego implements Queso {

    /**
     * .
     */
    private boolean melted;
    /**
     * .
     */
    private int temperature;
    /**
     * .
     */
    private int meltingt;

    /**
     * .
     * @return devuelve el estado del queso.
     */
    public final boolean isMelted() {
        return this.melted;
    }

    /**
     * .
     * @return devuelve temp del queso.
     */
    public final int getCurrentTemperature() {
        return this.temperature;
    }

    /**
     * .
     * @return devuelve temp de derretimiento.
     */
    public final int getMeltingTemperature() {
        return this.meltingt;
    }

    /**
     * .
     * @param temp : entero para fijar tempteratura actual.
     */
    public final void setCurrentTemperature(final int temp) {
        this.temperature = temp;
    }

    /**
     * .
     * @param melts fija el estado del queso no/derretido.
     */
    public final void melt(final boolean melts) {
        this.melted = melts;
    }
}
