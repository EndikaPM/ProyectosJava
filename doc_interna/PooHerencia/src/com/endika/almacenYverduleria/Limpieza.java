package com.endika.almacenYverduleria;

public class Limpieza extends Producto{
    private String componentes;
    private double litos;

    public Limpieza(String nombre, double precio, String componentes, double litos) {
        super(nombre, precio);
        this.componentes = componentes;
        this.litos = litos;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public double getLitos() {
        return litos;
    }

    public void setLitos(double litos) {
        this.litos = litos;
    }

    @Override
    public String toString() {
        return super.toString() +
                " componentes= " + componentes +
                ", litos=" + litos + " l";
    }
}
