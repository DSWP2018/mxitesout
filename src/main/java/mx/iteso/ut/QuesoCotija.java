package mx.iteso.ut;

/** Clase que implementa a Queso. */
public class QuesoCotija implements Queso {
/** ¿Está derretido?  */
private boolean melted;
/** Temperatura de derretido. */
private int meltingTemp;
/** Temperatura actual. */
private int currentTemp;
/** Constructor de la clase. */
public QuesoCotija() {
this.melted = true;
this.currentTemp = 0;
}
/** Constructor con valores.
 * @param ismelted .
 * @param themeltingTemp .
 * @param thecurrentTemp .*/
public QuesoCotija(final boolean ismelted,
final int themeltingTemp, final int thecurrentTemp) {
this.melted = ismelted;
this.meltingTemp = themeltingTemp;
this.currentTemp = thecurrentTemp;
}
/** Devuelve boolean de si está derretido.
 * @return melted . */
public final boolean isMelted() {
return melted;
}
/** Devuelve la temperatura con que se derrite.
 * @return meltingTemp . */
public final int getMeltingTemperature() {
return meltingTemp;
}
/** Devuelve la temperatura actual.
 * @return currentTemp . */
public final int getCurrentTemperature() {
return currentTemp;
}
/** Asigna la temperatura actual.
 * @param temp . */
public final void setCurrentTemperature(final int temp) {
currentTemp = temp;
}
/** Derrite el queso.
 * @param ismelted . */
public final void melt(final boolean ismelted) {
this.melted = ismelted;
}

}
