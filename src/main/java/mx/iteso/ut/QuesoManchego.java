package mx.iteso.ut;

public class QuesoManchego implements Queso {
    boolean melted;
    int temperature;
    int melting = 10;

    public boolean isMelted() {
        return this.melted;
    }

    public int getCurrentTemp() {
        return this.temperature;
    }

    public int getMeltingTemp() {
        return this.melting;
    }

    public void setTemp(int temp) {
        this.temperature = temp;
    }

    public void melt(boolean melted) {
        this.melted = melted;

    }
}
