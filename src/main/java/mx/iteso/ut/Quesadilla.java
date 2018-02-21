package mx.iteso.ut;
/**
 *  Clase publica quesadilla.
 *  @type
 */
public class Quesadilla {
/** VAR queso.*/
private Queso queso;
/** VAR tortilla.*/
private Tortilla tortilla, tortilla1;
/** VAR heatlevel.*/
private int heatLevel;
/**@return string*/
public final String prepareSingle() {
while (getQueso().getCurrentTemperature() < getQueso().getMeltingTemperature()
&&
getTortilla().getCurrentTemperature() < getTortilla().getToastTemperature()) {
getTortilla().setCurrentTemperature(getTortilla().getCurrentTemperature()
+ getHeatLevel());
getQueso().setCurrentTemperature(getQueso().getCurrentTemperature()
+ getHeatLevel());
if (getTortilla().getCurrentTemperature()
>= getTortilla().getToastTemperature()) {
getTortilla().toast(true);
}
if (getQueso().getCurrentTemperature() >= getQueso().getMeltingTemperature()) {
getQueso().melt(true);
}
}
if (getQueso().isMelted() && getTortilla().isToasted()) {
return "Perfect quesadilla";
}
if (getQueso().isMelted() && !getTortilla().isToasted()) {
return "Good quesadilla";
}
if (!getQueso().isMelted() && getTortilla().isToasted()) {
return "Terrible quesadilla";
} else {
return "You ran out of gas";
}
}
/**@return string*/
public final String prepareDouble() {
while (getTortilla1().getCurrentTemperature()
<
getTortilla1().getToastTemperature()
&&
getQueso().getCurrentTemperature() < getQueso().getMeltingTemperature()
&&
getTortilla().getCurrentTemperature() < getTortilla().getToastTemperature()) {
getTortilla().setCurrentTemperature(getTortilla().getCurrentTemperature()
+ getHeatLevel());
getTortilla1().setCurrentTemperature(getTortilla1().getCurrentTemperature()
+ getHeatLevel());
getQueso().setCurrentTemperature(getQueso().getCurrentTemperature()
+ getHeatLevel());
if (getTortilla1().getCurrentTemperature()
>= getTortilla1().getToastTemperature()) {
getTortilla1().toast(true);
}
if (getQueso().getCurrentTemperature()
>= getQueso().getMeltingTemperature()) {
getQueso().melt(true);
}
if (getTortilla().getCurrentTemperature()
>= getTortilla().getToastTemperature()) {
getTortilla().toast(true);
}
}
if (getTortilla().isToasted()
&& getTortilla1().isToasted() && getQueso().isMelted()) {
return "Perfect quesadilla double";
}
if (!getTortilla().isToasted()
&& getTortilla1().isToasted() && getQueso().isMelted()) {
return "Almost Perfect quesadilla double";
}
if (!getTortilla().isToasted()
&& getTortilla1().isToasted() && !getQueso().isMelted()) {
return "Almost Good quesadilla double";
}
if (!getTortilla().isToasted()
&& !getTortilla1().isToasted() && getQueso().isMelted()) {
return "Good quesadilla double";
}
if (getTortilla().isToasted()
&& getTortilla1().isToasted() && !getQueso().isMelted()) {
return "Terrible quesadilla double";
} else {
return "You ran out of gas double";
}
}
/** @return Queso*/
public final Queso getQueso() {
return queso;
}

/**@param queso1 */
public final void setQueso(final Queso queso1) {
this.queso = queso1;
}

/** @return Tortilla*/
public final Tortilla getTortilla() {
return this.tortilla;
}

/** @param tortilla2 */
public final void setTortilla(final Tortilla tortilla2) {
this.tortilla = tortilla2;
}
/** @return Tortilla*/
public final Tortilla getTortilla1() {
return this.tortilla1;
}

/** @param tortilla3 */
public final void setTortilla1(final Tortilla tortilla3) {
this.tortilla1 = tortilla3;
}

/** @return int*/
public final int getHeatLevel() {
return this.heatLevel;
}

/** @param heatLevel1 */
public final void setHeatLevel(final int heatLevel1) {
this.heatLevel = heatLevel1;
}
}
