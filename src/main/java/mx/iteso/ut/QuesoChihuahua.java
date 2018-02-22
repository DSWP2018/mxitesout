package mx.iteso.ut;

/**
 * Tipo de queso con sus particularidades.
 */
public class QuesoChihuahua implements Queso {

    /**
     * Booleano que cuenta el estado del queso.
     */
    private boolean melted;
    /**
     * Entero con la temp acutal del queso.
     */
    private int temperature;
    /**
     * entero : temp a la que se derrite el queso.
     */
    private int meltingt;

    /**
     * pregunta si esá derretido el queso.
     * @return estado del queso.
     */
    public final boolean isMelted() {
        return this.melted;
    }

    /**
     * getter de temperatura actual.
     * @return temperatura del queso.
     */
    public final int getCurrentTemperature() {
        return this.temperature;
    }

    /**
     * getter de la temp a la que se derrite el queso.
     * @return temp a la que se derrite.
     */
    public final int getMeltingTemperature() {
        return this.meltingt;
    }

    /**
     * setter de la temp actual.
     * @param temp : entero para fijar tempteratura actual.
     */
    public final void setCurrentTemperature(final int temp) {
        this.temperature = temp;
    }

    /**
     * derrite el queso.
     * @param melts : cambia el booleano.
     */
    public final void melt(final boolean melts) {
        this.melted = melts;
    }
}
