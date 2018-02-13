package mx.iteso.ut;

/**
 * Clase Quesadilla.
 */
public class Quesadilla {
/**Atributo tipo Queso para preparar quesadilla.*/
private Queso queso;
/**Atributo del tipo Tortilla para preparar quesadilla.*/
private Tortilla tortilla;
/**Variable para indicar nivel de calor.*/
private int heatLevel;

/**Método para preparar una quesadilla.
 * @return String con el status de la quesadilla preparada .*/
public final String prepareSingle() {

while (getQueso().getCurrentTemperature()
< getQueso().getMeltingTemperature()
&& getTortilla().getCurrentTemperature()
< getTortilla().getToastTemperature()) {
getTortilla().setCurrentTemperature(getTortilla()
.getCurrentTemperature() + getHeatLevel());
getQueso().setCurrentTemperature(getQueso()
.getCurrentTemperature() + getHeatLevel());
if (getTortilla().getCurrentTemperature()
>= getTortilla()
.getToastTemperature()) {
getTortilla().toast(true);
}
if (getQueso().getCurrentTemperature()
>= getQueso().getMeltingTemperature()) {
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

/**Permite obtener el queso utilizado para la quesadilla.
 * @return queso utilizado.*/
public final Queso getQueso() {
return queso;
}

/**Permite establecer el queso utilizado para la quesadilla.
 * @param newqueso del tipo Queso.*/
public final void setQueso(final Queso newqueso) {
this.queso = newqueso;
}

/**Permite obtener la tortilla utilizada para la quesadilla.
 * @return tortilla utilizada.*/
public final Tortilla getTortilla() {
return tortilla;
}

/**Permite establecer la tortilla utilizada para la quesadilla.
 * @param newtortilla del tipo Tortilla.*/
public final void setTortilla(final Tortilla newtortilla) {
this.tortilla = newtortilla;
}

/**Permite obtener el nivel de calor actual.
 * @return entero con la temperatura actual.*/
public final int getHeatLevel() {
return heatLevel;
}

/**Permite establecer el nuevo nivel de calor para la quesadilla.
 * @param newheatLevel temperatura nueva.*/
public final void setHeatLevel(final int newheatLevel) {
this.heatLevel = newheatLevel;
}
}
