package mx.iteso.ut;

public class TortillaHarina implements Tortilla {

    private boolean toasted;
    private int temperature;
    private int toastingt;

    public final boolean isToasted() {
        return this.toasted;
    }

    public final int getToastTemperature() {
        return this.toastingt;
    }

    public final int getCurrentTemperature() {
        return this.temperature;
    }

    public final void setCurrentTemperature(final int temp) {
        this.temperature = temp;
    }

    public final void toast(final boolean toasts) {
        this.toasted = toasts;
    }
}
