package mx.iteso.ut;

public interface Tortilla {
    boolean isToasted();
    int getToastTemperature();
    int getCurrentTemperature();
    void setCurrentTemperature(int temp);
    void toast(boolean toasted);
}
