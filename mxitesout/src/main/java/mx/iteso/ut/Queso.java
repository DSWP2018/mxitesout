package mx.iteso.ut;

public interface Queso {
    public boolean isMelted();
    public int getCurrentTemperature();
    public int getMeltingTemperature();
    public void setCurrentTemperature(int temp);
    public void melt(boolean melted);
}
