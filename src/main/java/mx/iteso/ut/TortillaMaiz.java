package mx.iteso.ut;

/**
 * Clase que implementa la interfaz Tortilla.
 * Tortilla de tipo maíz
 * @version 1.0 12/02/18
 * @author Mariana Salas
 */
public class TortillaMaiz implements Tortilla {

    /**
     * Determina si está tostada la tortilla.
     */
    private boolean toast;
    /**
     * Temperatura actual de la tortilla.
     * Temperatura de tostado.
     */
    private int currentTemp, toastTemp;

    /**
     * Método constructor.
     * Inicializa las variables.
     */
    public TortillaMaiz() {
        this.toast = false;
        this.currentTemp = 0;
        this.toastTemp = 0;
    }

    /**
     * Método para saber si la tortilla está tostada.
     * @return toast
     */
    public final boolean isToasted() {
        return  toast;
    }

    /**
     * Método para obtener la temperatura de tostado.
     * @return temperatura de tostado
     */
    public final int getToastTemperature() {
        return this.toastTemp;
    }

    /**
     * Método para obtener la temperatura actual de la tortilla.
     * @return temperatura actual
     */
    public final int getCurrentTemperature() {
        return this.currentTemp;
    }

    /**
     * Método para establecer la temperatura actual.
     * @param temp temperatura que se va a establecer
     */
    public final void setCurrentTemperature(final int temp) {
        this.currentTemp = temp;

    }

    /**
     * Método para saber si la tortilla está tostada.
     * @param toasted boolean que establece si está tostado o no.
     */
    public final void toast(final boolean toasted) {
        this.toast = toasted;
    }

}
