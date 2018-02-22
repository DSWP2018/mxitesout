package mx.iteso.ut;

/**
 * Clase Queso Cheddar.
 */
public class QuesoCheddar implements Queso {
    /**Atributo para indicar temperatura.*/
    private int temp;
    /**Atributo para indicar si está derrtido o no.*/
    private boolean melted;
    /**Atributo para indicar temperatura a la que se derrite.*/
    private int melTemp;

    /**Constructor de la clase.*/
    public QuesoCheddar() {
        this.temp = 0;
        this.melted = false;
        this.melTemp = 0;
    }

    /**Método que nos dice el estado del queso.
     * @return boolean, para saber si está o no derretido.*/
    public final boolean isMelted() {
        return this.melted;
    }

    /**Permite obtener la temperatura actual del queso.
     * @return int, con la temperatura.*/
    public final int getCurrentTemperature() {
        return this.temp;
    }

    /**Permite obtener la temperatura a la que se derrite el queso.
     * @return int, con la temperatura.*/
    public final int getMeltingTemperature() {
        return this.melTemp;
    }

    /**Permite indicar a qué temperatura se encuentra.
     * @param newtemp para establecer la temperatura.*/
    public final void setCurrentTemperature(final int newtemp) {
        this.temp = newtemp;
    }

    /**Permite establecer si el queso está derretido o no.
     * @param ismelted verdadero o falso.*/
    public final void melt(final boolean ismelted) {
        this.melted = ismelted;
    }

}
