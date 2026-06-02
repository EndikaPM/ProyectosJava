package Tarea34;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Tornillo", 10, 1.65));
        productos.add(new Producto("Aspirador",5,50.36));
        productos.add(new Producto("Movil", 20, 1365.65));
        productos.add(new Producto("Baterias",60,13.10));

        Double suma = productos.stream().map(e-> e.getCantidad()*e.getPrecio()).reduce(0.0, (a,b)-> a+b );
        System.out.println("suma = " + suma);
    }
}
