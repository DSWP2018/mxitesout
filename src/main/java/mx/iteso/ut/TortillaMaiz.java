package mx.iteso.ut;
/**Clase tortillaMaiz. */
public class TortillaMaiz implements  Tortilla {
    /**Declaración de variables. */
    private boolean toasted; /**boolean toasted. */
    static final int CTEMPERATURE = 20; /**constante cctemp. */
    static final int TTEMPERATURE = 5; /**Constantes para ctemp. */
    private int tTemperature = CTEMPERATURE; /**int ctemperature. */
    private int cTemperature = TTEMPERATURE; /**int ctemperature. */
    /**@return */
    public final boolean isToasted() {
        return this.toasted;
    }
    /**@return */
    public final int getToastTemperature() {
        return this.tTemperature;
    }
    /**@return */
    public final int getCurrentTemperature() {
        return this.cTemperature;
    }
    /**@param temp */
    public final void setCurrentTemperature(final int temp) {
        this.cTemperature = temp;
    }
    /**@param toastedd */
    public final void toast(final boolean toastedd) {
        this.toasted = toasted;
    }
}
