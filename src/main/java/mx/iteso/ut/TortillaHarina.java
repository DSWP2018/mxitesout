package mx.iteso.ut;

public class TortillaHarina implements Tortilla {
    boolean toasted;
    int temperature;
    int toastTemp = 9;

    public boolean isToasted() {
        return this.toasted;
    }

    public int getCurrentTemp() {
        return this.temperature;
    }

    public int getToastTemp() {
        return this.toastTemp;
    }

    public void setTemp(int temp) {
        this.temperature = temp;
    }

    public void toast(boolean toasting) {
        this.toasted = toasting;
    }
}