package mx.iteso.ut;
/**
 * Clase que implementa a a interfaz queso y establece los métodos al trabajar.
 * Queso del tipo mozarella
 * @version 1.0 12/02/18
 * @author Mariana Salas
 */
public class QuesoMozarella implements Queso {
    /**
     * Determina si está derretido o no el queso.
     */
    private boolean  melt;
    /**
     * La temperatura de cocción actual.
     * La temperatura de derretimiento
     */
    private int currentTemperature, meltTemp;

    /**
     * Método para construir el queso.
     * Inicializa las variables
     */
    public QuesoMozarella() {
        this.melt = false;
        this.currentTemperature = 0;
        this.meltTemp = 0;
    }

    /**
     * Método para conocer si el queso esta derretido.
     * @return si esta derretido o no
     */
    public final boolean isMelted() {
        return melt;
    }
    /**
     * Método para obtener la temperatura actual de cocción.
     * @return la temperatura actual
     */
    public final int getCurrentTemperature() {
        return this.currentTemperature;
    }

    /**
     * Método para establecer la temperatura de cocción.
     * @param newTemp nueva temperatura
     */
    public final void setCurrentTemperature(final int newTemp) {
        this.currentTemperature = newTemp;
    }

    /**
     * Método para obtener la temperatura de derretimiento.
     * @return la temperatura guardada e la que el queso se derrite.
     */
    public final int getMeltingTemperature() {
        return this.meltTemp;
    }

    /**
     * Método para establecer si está derretido el queso.
     * @param m status de derretimiento
     */
    public final void melt(final boolean m) {
        this.melt = m;
    }


}
