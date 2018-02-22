package mx.iteso.ut;

/**
 * Clase Quesadilla: El barquero en mi góndola a mi perdición que es DSW.
 *
 */
public final class Quesadilla {

	/**Referencia al tipo de queso a utilizar en la quesadilla.*/
    private Queso queso;
    /**Referencia al tipo de tortilla a utilizar en la quesadilla.*/
    private Tortilla tortilla;
    /**Atributo que determina la temperatura de cocción.*/
    private int heatLevel;
    /**Referencia a la tortilla interna para prepareDouble.*/
    private Tortilla tortillaInterna;

    /**Determina el terminado de la quesadilla preparada.
     * @return devuelve un String con cuatro posibilidades:
     * Perfect quesadilla, Good quesadilla,
     * Terrible quesadilla o You ran out of gas.*/
    public String prepareSingle() {


     while (getQueso().getCurrentTemperature()
    		< getQueso().getMeltingTemperature()
    		&& getTortilla().getCurrentTemperature()
    		< getTortilla().getToastTemperature()) {

         getTortilla()
         .setCurrentTemperature(getTortilla()
         .getCurrentTemperature() + getHeatLevel());

         getQueso()
         .setCurrentTemperature(getQueso()
         .getCurrentTemperature() + getHeatLevel());

         if (getTortilla().getCurrentTemperature()
        	>= getTortilla().getToastTemperature()) {
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

    /**Determina el terminado de la quesadilla doble.
     *@return String que contiene uno de los seis
     *terminados para la quesadilla doble.*/
    public String prepareDouble() {

        while (getQueso().getCurrentTemperature()
        		< getQueso().getMeltingTemperature()
        		&& getTortilla().getCurrentTemperature()
        		< getTortilla().getToastTemperature()
        		&& getTortillaInterna().getCurrentTemperature()
        		< getTortillaInterna().getToastTemperature()) {

             getTortilla()
             .setCurrentTemperature(getTortilla()
             .getCurrentTemperature() + getHeatLevel());

             getQueso()
             .setCurrentTemperature(getQueso()
             .getCurrentTemperature() + getHeatLevel());

             getTortillaInterna()
             .setCurrentTemperature(
             getTortillaInterna().getCurrentTemperature()
             + getHeatLevel());

             if (getTortilla().getCurrentTemperature()
            	>= getTortilla().getToastTemperature()) {
            	 getTortilla().toast(true);
            }

            if (getQueso().getCurrentTemperature()
            	>= getQueso().getMeltingTemperature()) {
            	getQueso().melt(true);
            }

            if (getTortillaInterna().getCurrentTemperature()
               >= getTortillaInterna().getToastTemperature()) {
            	getTortillaInterna().toast(true);
            }
         }

         if (getQueso().isMelted() && getTortilla().isToasted()
        	&& getTortillaInterna().isToasted()) {
        	 return "Perfect double quesadilla";
         }
         if (getQueso().isMelted() && getTortilla().isToasted()
             	&& !getTortillaInterna().isToasted()) {
             	 return "OK double quesadilla";
         }
         if (!getQueso().isMelted() && getTortilla().isToasted()
        	&& !getTortillaInterna().isToasted()) {
        	 return "Terrible double quesadilla";
         }
         if (!getQueso().isMelted() && !getTortilla().isToasted()
             	&& !getTortillaInterna().isToasted()) {
             	 return "You ran out of gas";
         }
         if (getQueso().isMelted() && !getTortilla().isToasted()
        	&& !getTortillaInterna().isToasted()) {
        	 return "Good double quesadilla";
         }
         if (!getQueso().isMelted() && getTortilla().isToasted()
             	&& getTortillaInterna().isToasted()) {
             	 return "Unholy quesadilla";
         } else {
        	return "You ran out of gas";
         }
    }

    /**Getter del atributo queso.
     * @return referencia al queso utilizado en la quesadilla.*/
    public Queso getQueso() {
        return queso;
    }

    /**Setter del atributo queso.
     * @param quesoRef es la referencia a copiar para queso.*/
    public void setQueso(final Queso quesoRef) {
        queso = quesoRef;
    }

    /**Getter del atributo tortilla.
     * @return referencia a la tortilla utilizada en la quesadilla.*/
    public Tortilla getTortilla() {
        return tortilla;
    }

    /**Setter del atributo tortilla.
     * @param tortillaRef es la referencia a copiar para tortilla.*/
    public void setTortilla(final Tortilla tortillaRef) {
        tortilla = tortillaRef;
    }

    /**Cada día nos alejamos más de la gracia del señor.
     * @return la condena inicial por lo impío de los hombres.*/
    public int getHeatLevel() {
        return heatLevel;
    }

    /**Esto se está volviendo ridículo.
     * @param heatLevelVal plz end me.*/
    public void setHeatLevel(final int heatLevelVal) {
        heatLevel = heatLevelVal;
    }

    /**Getter de la tortilla interna.
     * @return referencia a la tortilla interna.*/
    public Tortilla getTortillaInterna() {
    	return tortillaInterna;
    }

    /**Setter de la tortilla interna.
     * @param tortillaRef es la tortilla nueva.*/
    public void setTortillaInterna(final Tortilla tortillaRef) {
    	tortillaInterna = tortillaRef;
    }
}
