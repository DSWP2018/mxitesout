/*
 * Nombre: Alfonso Cervantes Alonso
 * Asignatura: Diseño de software
 * Profesor: Rodrigo Villalobos
 * Documento: "Tortilla.java"
 * Fecha de entrega: 07/02/2018
 * */

package mx.iteso.ut;

public interface Tortilla {
    public boolean isToasted();
    public int getToastTemperature();
    public int getCurrentTemperature();
    public void setCurrentTemperature(int temp);
    public void toast(boolean toasted);

}
