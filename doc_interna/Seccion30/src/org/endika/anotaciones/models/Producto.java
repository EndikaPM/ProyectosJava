package org.endika.anotaciones.models;

import org.endika.anotaciones.ejemplo.JsonArtributo;

import java.time.LocalDate;

public class Producto {
    @JsonArtributo(capitalizar = true)
    private String nombre;


    @JsonArtributo(nombre = "costo")
    private long precio;


    private LocalDate fecha;

    public Producto(String nombre, long precio) {
        this.nombre = nombre;
        this.fecha = LocalDate.now();
        this.precio = precio;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }
}
