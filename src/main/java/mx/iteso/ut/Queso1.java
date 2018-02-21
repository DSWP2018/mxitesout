/**
 * Clase Queso1 que implementa interfaz Queso.
 * @author Francisco Camacho
 * @since 02-08-2018
 * @version 1.0
 * */
package mx.iteso.ut;
/**
 * clase que implementa interfaz queso.
 */
public class Queso1 implements Queso {
    /**
     * Info about this package doing something for package-info.java file.
     */
    private boolean melted = false;
    /**
     * Info about this package doing something for package-info.java file.
     */
    private static final Integer MELTING_TEMPERATURE = 20;
    /**
     * Info about this package doing something for package-info.java file.
     */
    private static final Integer DEFAULT_TEMPERATURE = new Integer(20);
    /**
     * Info about this package doing something for package-info.java file.
     */
    private int currentTemperature = DEFAULT_TEMPERATURE;
    /**
     *metodo para verificar si ya se derritio.
     *@return isMelted
     * */
    public final boolean isMelted() {
        return melted;
    }
    /**
     * metodo saber la temperatura de derretido.
     * @return MeltingTemp
     * */
    public final int getCurrentTemp() {
        return currentTemperature;
    }
    /**
     * metodo saber la temperatura de derretido.
     * @return MeltingTemp
     * */
    public final int getMeltingTemp() {
        return MELTING_TEMPERATURE;
    }
    /**
     * @param temp
     * metodo para saber temperatura actual.
     * */
    public final void setCurrentTemp(final int temp) {
        this.currentTemperature = temp;
    }
    /**
     * @param melting
     * metodo que para definir derretido.
     */
    public final void melt(final boolean melting) {
        this.melted = melting;
    }
}
