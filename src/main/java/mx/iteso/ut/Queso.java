package mx.iteso.ut;
/**
 * Interfaz de Queso.
 */
public interface Queso {
    /**
     * @return indica si el queso esta derretido
     */
    boolean isMelted();

    /**
     * @return regresa la temp actual
     */
    int getCurrentTemperature();

    /**
     *
     * @return regresa la temp necesaria
     * para que el queso se derrita
     */
    int getMeltingTemperature();

    /**
     * @param temp modifica temp actual
     */
    void setCurrentTemperature(int temp);

    /**
     * @param melted modifica si el queso
     *               está derretido o no
     */
    void melt(boolean melted);
}
