package mx.iteso.ut;

public class TortillaMaiz implements Tortilla {
    boolean toasted;
    int temperature;
    int toastTemp = 15;

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