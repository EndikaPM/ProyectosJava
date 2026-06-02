package Tarea34;

public class Producto {
    private String nombre;
    private Integer cantidad;
    protected double precio;

    public Producto(String nombre, Integer cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return  nombre + ", cantidad= " + cantidad + ", precio= " + precio;
    }
}
