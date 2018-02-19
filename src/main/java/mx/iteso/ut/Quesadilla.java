package mx.iteso.ut;

/**
 *
 */
public class Quesadilla {
    private Queso queso;
    private Tortilla tortilla1;
    private Tortilla tortilla2;
    private int heatLevel;

    // REMOVÍ LAS MODIFICACIONES QUE TUVE QUE HACER PARA EL CHECKSTYLE PORQUE NO ME GUSTA EL CÓDIGO ASÍ
    public final String prepareSingle() {
        while (getQueso().getCurrentTemperature() < getQueso().getMeltingTemperature() &&
                getTortilla1().getCurrentTemperature() < getTortilla1().getToastTemperature()) {

            getTortilla1().setCurrentTemperature(getTortilla1().getCurrentTemperature() + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature() + getHeatLevel());

            if (getTortilla1().getCurrentTemperature() >= getTortilla1().getToastTemperature())
                getTortilla1().toast(true);

            if (getQueso().getCurrentTemperature() >= getQueso().getMeltingTemperature())
                getQueso().melt(true);
        }

        if (getQueso().isMelted() && getTortilla1().isToasted())
            return "Perfect quesadilla";
        if (getQueso().isMelted() && !getTortilla1().isToasted())
            return "Good quesadilla";
        if (!getQueso().isMelted() && getTortilla1().isToasted())
            return "Terrible quesadilla";
        else
            return "You ran out of gas";

    }

    public final String prepareDouble() {
        while (getQueso().getCurrentTemperature() < getQueso().getMeltingTemperature() &&
                getTortilla1().getCurrentTemperature() < getTortilla1().getToastTemperature() &&
                getTortilla2().getCurrentTemperature() < getTortilla2().getToastTemperature()){

            getTortilla1().setCurrentTemperature(getTortilla1().getCurrentTemperature() + getHeatLevel());
            getTortilla2().setCurrentTemperature(getTortilla2().getCurrentTemperature() + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature() + getHeatLevel());

            if (getTortilla1().getCurrentTemperature() >= getTortilla1().getToastTemperature())
                getTortilla1().toast(true);

            if (getTortilla2().getCurrentTemperature() >= getTortilla2().getToastTemperature())
                getTortilla2().toast(true);

            if (getQueso().getCurrentTemperature() >= getQueso().getMeltingTemperature())
                getQueso().melt(true);
        }


        // tortilla 1 tostada, tortilla 2 tostada, queso derretido
        if(getTortilla1().isToasted() && getTortilla2().isToasted() && getQueso().isMelted())
            return "Perfect double";
        // tortilla 1 no tostada, tortilla 2 tostada, queso derretido
        if(!getTortilla1().isToasted() && getTortilla2().isToasted() && getQueso().isMelted())
            return "Almost a perfect double";
        // tortilla 1 no tostada, tortilla 2 tostada, queso no derretido
        if(!getTortilla1().isToasted() && getTortilla2().isToasted() && !getQueso().isMelted())
            return "Terrible double";
        // tortilla 1 no tostada, tortilla 2 no tostada, queso no derretido
        if(!getTortilla1().isToasted() && !getTortilla2().isToasted() && !getQueso().isMelted())
            return "You ran out of gas";
        // tortilla 1 no tostada, tortilla 2 no tostada, queso derretido
        if(!getTortilla1().isToasted() && !getTortilla2().isToasted() && getQueso().isMelted())
            return "Good double";
        // tortilla 1 tostada, tortilla 2 tostada, queso no derretido
        if(getTortilla1().isToasted() && getTortilla2().isToasted() && !getQueso().isMelted())
            return "Bad double";
        else
            return "The taste could be good...";
    }

    public Queso getQueso() {
        return queso;
    }

    public void setQueso(Queso queso) {
        this.queso = queso;
    }

    public Tortilla getTortilla1() {
        return tortilla1;
    }

    public void setTortilla1(Tortilla tortilla1) {
        this.tortilla1 = tortilla1;
    }

    public Tortilla getTortilla2() {
        return tortilla2;
    }

    public void setTortilla2(Tortilla tortilla2) {
        this.tortilla2 = tortilla2;
    }

    public int getHeatLevel() {
        return heatLevel;
    }

    public void setHeatLevel(int heatLevel) {
        this.heatLevel = heatLevel;
    }

}
