package com.endika.persona;

public class Persona {
    private String nombre;
    private String apelliado;
    private String numFical;
    private String direccion;

    public Persona() {}

    public Persona(String nombre, String apelliado, String numFical, String direccion) {
        this.nombre = nombre;
        this.apelliado = apelliado;
        this.numFical = numFical;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelliado() {
        return apelliado;
    }

    public void setApelliado(String apelliado) {
        this.apelliado = apelliado;
    }

    public String getNumFical() {
        return numFical;
    }

    public void setNumFical(String numFical) {
        this.numFical = numFical;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre +
                ", apelliado= " + apelliado +
                ", numFical= " + numFical +
                ", direccion= " + direccion;
    }
}
