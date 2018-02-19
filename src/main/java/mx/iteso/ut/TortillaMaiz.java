package mx.iteso.ut;
/** Clase que implementa a Tortilla. */
public class TortillaMaiz implements Tortilla {
/** ¿Está tostada?  */
private boolean toasted;
/** Temperatura de tostado. */
private int toastTemp;
/** Temperatura actual. */
private int currentTemp;
/** Constructor de la clase. */
public TortillaMaiz() {
this.toasted = true;
this.currentTemp = 0;
}
/** Constructor con valores.
 * @param istoasted .
 * @param thetoastTemp .
 * @param thecurrentTemp .*/
public TortillaMaiz(final boolean istoasted,
final int thetoastTemp, final int thecurrentTemp) {
this.toasted = istoasted;
this.toastTemp = thetoastTemp;
this.currentTemp = thecurrentTemp;
}
/** Devuelve boolean de si está tostada.
* @return toasted . */
public final boolean isToasted() {
return toasted;
}
/** Devuelve la temperatura con que se tuesta.
 * @return toastTemp . */
public final int getToastTemperature() {
return toastTemp;
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
 * @param istoasted . */
public final void toast(final boolean istoasted) {
this.toasted = istoasted;
}
}
