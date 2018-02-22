package mx.iteso.ut;

/**
 * Hello world!
 *
 */
public class Quesadilla
{
    private Queso queso;
    private Tortilla tortilla;
    private Tortilla tortilla2;
    private int heatLevel;

    public String prepareSingle(){


     while(getQueso().getCurrentTemperature()< getQueso().getMeltingTemperature() || getTortilla().getCurrentTemperature()< getTortilla().getToastTemperature()){
         getTortilla().setCurrentTemperature(getTortilla().getCurrentTemperature() + getHeatLevel());
         getQueso().setCurrentTemperature(getQueso().getCurrentTemperature() + getHeatLevel());
         if (getTortilla().getCurrentTemperature() >= getTortilla().getToastTemperature())
             getTortilla().toast(true);
         if (getQueso().getCurrentTemperature() >= getQueso().getMeltingTemperature())
             getQueso().melt(true);
     }

     if(getQueso().isMelted() && getTortilla().isToasted())
         return "Quesadilla Doble Perfecta :D";
     if(getQueso().isMelted() && !getTortilla().isToasted())
         return "Quesadilla Doble Buena :)";
     if(!getQueso().isMelted() && getTortilla().isToasted())
         return "Quesadilla Doble Terrible :(";
     else
         return "Se acabo el gas :0";
        public final String prepareDouble() {
            queso = getQueso();
            tortilla = getTortilla();
            tortilla2 = getTortilla2();
            while (queso.getCurrentTemp() < queso.getMeltingTemp()
                    && tortilla.getCurrentTemp() < tortilla.getToastTemp()
                    && tortilla2.getCurrentTemp() < tortilla2.getToastTemp()) {
                tortilla2.setTemp(tortilla2.getCurrentTemp() + getHeatLevel());
                tortilla.setTemp(tortilla.getCurrentTemp() + getHeatLevel());
                queso.setTemp(queso.getCurrentTemp() + getHeatLevel());
                if (tortilla2.getCurrentTemp() >= tortilla2.getToastTemp()) {
                    tortilla2.toast(true);
                }
                if (tortilla.getCurrentTemp() >= tortilla.getToastTemp()) {
                    tortilla.toast(true);
                }
                if (queso.getCurrentTemp() >= queso.getMeltingTemp()) {
                    queso.melt(true);
                }
            }

            if (queso.isMelted() && tortilla.isToasted()
                    && tortilla2.isToasted()) {
                return "Tortilla 1 tostada, "
                        + "tortilla 2 tostada, queso derretido.";
            } else if (queso.isMelted() && tortilla.isToasted()
                    && !tortilla2.isToasted()) {
                return "Tortilla 1 tostada, "
                        + "tortilla 2 no tostada, queso derretido.";
            } else if (queso.isMelted()
                    && !tortilla.isToasted() && tortilla2.isToasted()) {
                return "Tortilla 1 no tostada, "
                        + "tortilla 2 tostada, queso derretido.";
            } else if (queso.isMelted()
                    && !tortilla.isToasted() && !tortilla2.isToasted()) {
                return "Tortilla 1 no tostada, "
                        + "tortilla 2 no tostada, queso derretido.";
            } else if (!queso.isMelted()
                    && tortilla.isToasted() && tortilla2.isToasted()) {
                return "Tortilla 1 tostada, "
                        + "tortilla 2 tostada, queso no derretido.";
            } else if (!queso.isMelted()
                    && !tortilla.isToasted() && tortilla2.isToasted()) {
                return "Tortilla 1 no tostada, "
                        + "tortilla 2 tostada, queso no derretido.";
            } else if (!queso.isMelted()
                    && tortilla.isToasted() && !tortilla2.isToasted()) {
                return "Tortilla 1 tostada, "
                        + "tortilla 2 no tostada, queso no derretido.";
            } else {
                return "You ran out of gas";
            }
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

    public void setTortilla(Tortilla tortilla) {
        this.tortilla = tortilla;
    }

    public final Tortilla getTortilla2() {
        return tortilla2;
    }

    public final void setTortilla2(final Tortilla t) {
        this.tortilla2 = t;
    }

    public int getHeatLevel() {
        return heatLevel;
    }

    public void setHeatLevel(int heatLevel) {
        this.heatLevel = heatLevel;
    }
}
