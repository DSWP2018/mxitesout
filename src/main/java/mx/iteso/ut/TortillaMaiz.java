package mx.iteso.ut;

public class TortillaMaiz implements Tortilla {
    private int temperature;
    private boolean toast;
    private int toastTemperature = 40;

    public boolean isToasted() {
        return toast;
    }

    public int getToastTemperature() {
        return toastTemperature;
    }

    public int getCurrentTemperature() {
        return temperature;
    }

    public void setCurrentTemperature(int temp) {
        temperature = temp;
    }

    public void toast(boolean toasted) {
        toast = toasted;
    }
}
