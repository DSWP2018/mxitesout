package mx.iteso.ut;

public interface Queso {
    boolean isMelted();
    int getCurrentTemperature();
    int getMeltingTemperature();
    void setCurrentTemperature(int temp);
    void melt(boolean melted);
}
