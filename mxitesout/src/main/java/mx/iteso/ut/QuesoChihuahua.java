package mx.iteso.ut;

public class QuesoChihuahua implements Queso {

    private boolean melted;
    private int temperature;
    private int meltingt;

    public final boolean isMelted() {
        return this.melted;
    }

    public final int getCurrentTemperature() {
        return this.temperature;
    }

    public final int getMeltingTemperature() {
        return this.meltingt;
    }

    public final void setCurrentTemperature(final int temp) {
        this.temperature = temp;
    }

    public final void melt(final boolean melts) {
        this.melted = melts;
    }
}
