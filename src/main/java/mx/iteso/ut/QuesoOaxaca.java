package mx.iteso.ut;
/**Implementacion.*/

public class QuesoOaxaca implements Queso {
/**VAR.*/
private int cTemperature;
/**VAR.*/
private static int mTemperature = 14;
/**VAR.*/
private boolean melt = false;
/**@return boolean*/
final boolean getmel() {
return melt;
}
/**@param m boolean*/
final void settoa(final boolean m) {
melt = m;
}
/**@return int*/
final int getmtemp() {
return mTemperature;
}
/**@param t int*/
final void setmt(final int t) {
mTemperature = t;
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
public final boolean isMelted() {
return melt;
}
/**@return int*/
public final int getCurrentTemperature() {
return cTemperature;
}
/**@return int*/
public final int getMeltingTemperature() {
return mTemperature;
}
/**@param temp int*/
public final void setCurrentTemperature(final int temp) {
cTemperature = temp;
}
/**@param melted boolean*/
public final void melt(final boolean melted) {
melt = melted;
}
}
