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


        while(getQueso().getCurrentTemperature()< getQueso().getMeltingTemperature() && getTortilla().getCurrentTemperature()< getTortilla().getToastTemperature()){
            getTortilla().setCurrentTemperature(getTortilla().getCurrentTemperature() + getHeatLevel());
            getQueso().setCurrentTemperature(getQueso().getCurrentTemperature() + getHeatLevel());
            if (getTortilla().getCurrentTemperature() >= getTortilla().getToastTemperature())
                getTortilla().toast(true);
            if (getQueso().getCurrentTemperature() >= getQueso().getMeltingTemperature())
                getQueso().melt(true);
        }

        if(getQueso().isMelted() && getTortilla().isToasted())
            return "Perfect quesadilla";
        if(getQueso().isMelted() && !getTortilla().isToasted())
            return "Good quesadilla";
        if(!getQueso().isMelted() && getTortilla().isToasted())
            return "Terrible quesadilla";
        else
            return "You ran out of gas";

    }

    public String prepareDouble(){
        // tortilla 1 tostada, tortilla 2 tostada, queso derretido
        // tortilla 1 no tostada, tortilla 2 tostada, queso derretido
        // tortilla 1 no tostada, tortilla 2 tostada, queso no derretido
        // tortilla 1 no tostada, tortilla 2 no tostada, queso no derretido
        // tortilla 1 no tostada, tortilla 2 no tostada, queso derretido
        // tortilla 1 tostada, tortilla 2 tostada, queso no derretido

        int currentTempTortilla1, currentTempTortilla2, currentTempQueso;
        int toastTempTortilla1, toastTempTortilla2;
        int meltingTempQueso;

        Tortilla tortilla1 = getTortilla();
        Tortilla tortilla2 = getSecondTortilla();
        Queso queso1 = getQueso();

        toastTempTortilla1 = tortilla1.getToastTemperature();
        toastTempTortilla2 = tortilla2.getToastTemperature();
        meltingTempQueso = queso1.getMeltingTemperature();

        currentTempTortilla1 = tortilla1.getCurrentTemperature();
        currentTempTortilla2 = tortilla2.getCurrentTemperature();
        currentTempQueso = queso1.getCurrentTemperature();

        while (currentTempTortilla1 < toastTempTortilla1
                && currentTempTortilla2 < toastTempTortilla2
                && currentTempQueso < meltingTempQueso) {
            tortilla1.setCurrentTemperature(currentTempTortilla1 + heatLevel);
            tortilla2.setCurrentTemperature(currentTempTortilla2 + heatLevel);
            queso1.setCurrentTemperature(currentTempQueso
                    + currentTempQueso + heatLevel);

            currentTempTortilla1 = tortilla1.getCurrentTemperature();
            currentTempTortilla2 = tortilla2.getCurrentTemperature();
            currentTempQueso = queso1.getCurrentTemperature();

            tortilla1.toast(currentTempTortilla1 >= toastTempTortilla1);
            tortilla2.toast(currentTempTortilla2 >= toastTempTortilla2);
            queso1.melt(currentTempQueso >= meltingTempQueso);

        }

        boolean toastedT1, toastedT2, meltedQueso;
        toastedT1 = tortilla1.isToasted();
        toastedT2 = tortilla2.isToasted();
        meltedQueso = queso1.isMelted();

        if (toastedT1 && toastedT2 && meltedQueso) {
            return "Quesadilla Perfecta";
        } else if (!toastedT1 && !toastedT2 && !meltedQueso) {
            return "Falló todo";
        } else if (!toastedT1 && !toastedT2) {
            return "No se tostó ninguna tortilla";
        } else if (!toastedT1 && !meltedQueso) {
            return "Tortilla 1 sin tostar y queso sin derretir";
        } else if (!toastedT2 && !meltedQueso) {
            return "No se derritió el queso y la segunda tortilla no se tostó";
        } else if (!toastedT1) {
            return "La primera tortilla no se tostó";
        } else if (!toastedT2) {
            return "La segunda tortilla no se tostó";
        } else {
            return "No se derritió el queso";
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

    public Tortilla getSecondTortilla() {
        return tortilla2;
    }

    public void setSecondTortilla(Tortilla tortilla) {
        this.tortilla2 = tortilla;
    }

    public int getHeatLevel() {
        return heatLevel;
    }

    public void setHeatLevel(int heatLevel) {
        this.heatLevel = heatLevel;
    }
}