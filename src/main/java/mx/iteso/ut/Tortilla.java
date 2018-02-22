package mx.iteso.ut;

/**
 * .
 */
public interface Tortilla {
    /**
     * .
     * @return devuelve el estado de la tortilla.
     */
    boolean isToasted();
    /**
     * .
     * @return devuelve temp de tostado.
     */
    int getToastTemperature();
    /**
     * .
     * @return regresa temperatura actual.
     */
    int getCurrentTemperature();
    /**
     * .
     * @param temp temperatura a fijarle a la tortilla.
     */
    void setCurrentTemperature(int temp);

    /**
     * .
     * @param toasted fija el estado de la tortilla.
     */
    void toast(boolean toasted);
}
