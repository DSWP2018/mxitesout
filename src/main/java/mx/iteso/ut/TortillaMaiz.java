package mx.iteso.ut;
/**Implementacion.*/
public class TortillaMaiz implements Tortilla {
/**VAR.*/
private int cTemperature;
/**VAR.*/
private static final int TTEMPERATURE = 30;
/**VAR.*/
private boolean toast = false;
/**@return boolean*/
final boolean gettoa() {
return toast;
}
/**@param t int*/
final void settoa(final boolean t) {
toast = t;
}
/**@return int*/
final int getmtemp() {
return TTEMPERATURE;
}

/**@return int*/
final int getctemp() {
return cTemperature;
}
/**@param t int*/
final void setct(final int t) {
cTemperature = t;
}
/**@return boolean*/
public final boolean isToasted() {
return toast;
}
/**@return int*/
public final int getToastTemperature() {
return TTEMPERATURE;
}
/**@return int*/
public final int getCurrentTemperature() {
return cTemperature;
}
/**@param temp int*/
public final void setCurrentTemperature(final int temp) {
cTemperature = temp;
}
/**@param toasted boolean*/
public final void toast(final boolean toasted) {
toast = toasted;
}

}
