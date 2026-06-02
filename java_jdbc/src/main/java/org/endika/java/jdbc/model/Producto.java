package org.endika.java.jdbc.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Producto {
    private Long id;
    private String nombre;
    private float precio;
    private LocalDateTime fecha;

    public Producto(){};
    public Producto(Long id, String nombre, float precio, LocalDateTime fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
         this.fecha = fecha;
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + precio + " | " + fecha;
    }
}
