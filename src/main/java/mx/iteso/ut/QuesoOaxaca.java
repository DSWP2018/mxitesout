package mx.iteso.ut;
/**Clase QuesoOaxaca. */
public class QuesoOaxaca implements Queso {
    private boolean melted;
    private int cTemperature = 25;
    private int mTemperature = 40;

    public boolean isMelted() {
        return melted;
    }

    public int getCurrentTemperature() {
        return cTemperature;
    }

    public int getMeltingTemperature() {
        return mTemperature;
    }

    public void setCurrentTemperature(int cTemp) {
        cTemperature = cTemp;
    }

    public void melt(boolean melted) {
        this.melted = melted;
    }
}
