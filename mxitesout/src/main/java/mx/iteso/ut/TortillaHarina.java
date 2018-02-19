package mx.iteso.ut;

public class TortillaHarina implements Tortilla {

    boolean toasted;
    int temperature;
    int toastingt = 20;

    public boolean isToasted() {
        return this.toasted ;
    }

    public int getToastTemperature() {
        return this.toastingt;
    }

    public int getCurrentTemperature() {
        return this.temperature;
    }

    public void setCurrentTemperature(int temp) {
        this.temperature = temp ;
    }

    public void toast(boolean toasted) {
        this.toasted = toasted;
    }
}
