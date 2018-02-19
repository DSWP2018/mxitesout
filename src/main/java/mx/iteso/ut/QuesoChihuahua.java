package mx.iteso.ut;

public class QuesoChihuahua implements Queso {

    private int temperature;
    private boolean melted;
    private int meltingTemperature = 20;

    public boolean isMelted() {
        return melted;
    }

    public int getCurrentTemperature() {
        return temperature;
    }

    public int getMeltingTemperature() {
        return meltingTemperature;
    }

    public void setCurrentTemperature(int temp) {
        temperature = temp;
    }

    public void melt(boolean melted) {
        this.melted = melted;
    }
}
