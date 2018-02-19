package mx.iteso.ut;

/**
 * Hello world!
 *
 */
public class Quesadilla
{
    private Queso queso;
    private Tortilla tortilla;
    private Tortilla secondTortilla;
    private int heatLevel;

    public String prepareSingle(){


         while(getQueso().getCurrentTemperature()< getQueso().getMeltingTemperature() && //queso sigue sólido
                 getTortilla().getCurrentTemperature()< getTortilla().getToastTemperature())    //no está tostada
         {
             getTortilla().setCurrentTemperature(getTortilla().getCurrentTemperature() + getHeatLevel());
                    //poner tempteratura a tortilla
             getQueso().setCurrentTemperature(getQueso().getCurrentTemperature() + getHeatLevel());
                    //poner temperatura a tortilla
             if (getTortilla().getCurrentTemperature() >= getTortilla().getToastTemperature())
                 getTortilla().toast(true);
             if (getQueso().getCurrentTemperature() >= getQueso().getMeltingTemperature())
                 getQueso().melt(true);
             //poner si tostado o derretido al superarlo
         }

         if(getQueso().isMelted() && getTortilla().isToasted())
             return "Perfect quesadilla";
         if(getQueso().isMelted() && !getTortilla().isToasted())    //derrietido, no tostada
             return "Good quesadilla";
         if(!getQueso().isMelted() && getTortilla().isToasted())    //no derretida, sí tostada
             return "Terrible quesadilla";
         else
             return "You ran out of gas";

    }

    public String prepareDouble(){
        while(  (getQueso().getCurrentTemperature()           < getQueso().getMeltingTemperature() ) &&
                (getTortilla().getCurrentTemperature()        < getTortilla().getToastTemperature()) &&  //tortilla 1
                (getSecondTortilla().getCurrentTemperature()  < getSecondTortilla().getToastTemperature()) ){   //tortilla 2

            getQueso()   .setCurrentTemperature       (getQueso()         .getCurrentTemperature()  + getHeatLevel());
            getTortilla().setCurrentTemperature       (getTortilla()      .getCurrentTemperature()  + getHeatLevel());
            getSecondTortilla().setCurrentTemperature (getSecondTortilla().getCurrentTemperature()  + getHeatLevel());

            if(getQueso().getCurrentTemperature() >= getQueso().getMeltingTemperature()){
                getQueso().melt(true);
            }
            if(getTortilla().getCurrentTemperature() >= getTortilla().getToastTemperature()){
                getTortilla().toast(true);
            }
            if(getSecondTortilla().getCurrentTemperature() >= getSecondTortilla().getToastTemperature()){
                getSecondTortilla().toast(true);
            }

        }

            //Ambas tortillas tostadas, queso derretido
        if(tortilla.isToasted() && secondTortilla.isToasted() && queso.isMelted()){
            return "Quesadilla doble perfecta";
        }
            //Ambas tortillas tostadas, queso no derretido
        if(tortilla.isToasted() && secondTortilla.isToasted() && !queso.isMelted()){
            return "Quesadilla doble buena";
        }
            //Una tortilla tostada, una sin tostar, queso derretido
        if( ( (tortilla.isToasted() && !secondTortilla.isToasted() ) || (!tortilla.isToasted() && secondTortilla.isToasted()) ) && queso.isMelted() ){
            return "Quesadilla doble decente";
        }
            //Una tortilla tostada, una sin tostar, queso no derretido
        if( ( (tortilla.isToasted() && !secondTortilla.isToasted() ) || (!tortilla.isToasted() && secondTortilla.isToasted()) ) && !queso.isMelted() ) {
            return "Quesadilla doble pasable";
        }
            //Ambas sin tostar, queso derretido
        if(!tortilla.isToasted() && !secondTortilla.isToasted() && queso.isMelted()) {
            return "Quesadilla doble mala";
        }
            //Ambas sin tostar, queso no derretido
        else {
            return "Se acabó el gas";
        }
    }


    public Queso getQueso() {
        return queso;
    }

    public void setQueso(Queso queso) {
        this.queso = queso;
    }


    public Tortilla getTortilla() {
        return tortilla;
    }

    public Tortilla getSecondTortilla() {
        return tortilla;
    }

    public void setTortilla(Tortilla tortilla) {
        this.tortilla = tortilla;
    }

    public void setSecondTortilla(Tortilla tortilla) {
        this.secondTortilla = tortilla;
    }

    public int getHeatLevel() {
        return heatLevel;
    }

    public void setHeatLevel(int heatLevel) {
        this.heatLevel = heatLevel;
    }
}
