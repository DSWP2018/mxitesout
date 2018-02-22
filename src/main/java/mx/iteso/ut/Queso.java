package mx.iteso.ut;

/**
 * interfaz del queso.
 */
public interface Queso {
    /**
     * estátus del queso.
     * @return devuelve true si está derretido.
     */
    boolean isMelted();

    /**
     * getter de la temperatura.
     * @return valor de la tempteratura actual.
     */
    int getCurrentTemperature();

    /**
     * getter de la temperatura de derretido.
     * @return temperatura de derretido.
     */
    int getMeltingTemperature();

    /**
     *setter de temperatura actual.
     * @param temp : entero para fijar tempteratura actual.
     */
    void setCurrentTemperature(int temp);

    /**
     * cambia el estado a derretido.
     * @param melted : manda el parámetro del derretido.
     */
    void melt(boolean melted);
}
