package mx.iteso.ut;
/**Clase Tortilla. */
public class TortillaHarina implements Tortilla {
    /**Declaración de variabels. */
    private boolean toasted; /**boolean toasted. */
    static final int TTEMPERATURE = 25; /**Constante ttemperature. */
    static final int CTEMPERATURE = 5; /**int cTEMPERATURE. */
    private int tTemperature = TTEMPERATURE; /**int cTemperature. */
    private int cTemperature = CTEMPERATURE; /**int cTemperature.  */
    /**@return */
    public final boolean isToasted() {
        return toasted;
    }
    /**@return */
    public final int getToastTemperature() {
        return tTemperature;
    }
    /**@return */
    public final int getCurrentTemperature() {
        return cTemperature;
    }
    /**@param temp */
    public final void setCurrentTemperature(final int temp) {
        this.cTemperature = temp;
    }
    /**@param toastedd */
    public final void toast(final boolean toastedd) {
        this.toasted = toastedd;
    }
}
