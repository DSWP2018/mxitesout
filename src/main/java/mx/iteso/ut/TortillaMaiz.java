package mx.iteso.ut;

/**
 * Clase Tortilla Maiz.
 */
public class TortillaMaiz implements Tortilla {
    /**Atributo para indicar temperatura.*/
    private int temp;
    /**Atributo para indicar si está tostada o no.*/
    private boolean toasted;
    /**Atributo para indicar temperatura a la que se tuesta.*/
    private int toastTemp;

    /**Constructor de la clase.*/
    public TortillaMaiz() {
        this.temp = 0;
        this.toasted = false;
        this.toastTemp = 0;
    }

    /**Método que nos dice el estado de la tortilla.
     * @return boolean, para saber si está o no tostada.*/
    public final boolean isToasted() {
        return this.toasted;
    }

    /**Permite obtener la temperatura a la que se tuesta la tortilla.
     * @return int, con la temperatura.*/
    public final int getToastTemperature() {
        return this.toastTemp;
    }

    /**Permite obtener la temperatura a la que se encuentra la tortilla.
     * @return int, con la temperatura.*/
    public final int getCurrentTemperature() {
        return this.temp;
    }

    /**Permite indicar a qué temperatura se encuentra.
     * @param newtemp para establecer la temperatura.*/
    public final void setCurrentTemperature(final int newtemp) {
        this.temp = newtemp;
    }

    /**Permite establecer si la tortilla está tostada o no.
     * @param istoasted verdadero o falso.*/
    public final void toast(final boolean istoasted) {
        this.toasted = istoasted;
    }

}
