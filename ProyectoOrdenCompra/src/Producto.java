public class Producto {

    private String fabricante;
    private String nombreProducto;
    private int precio;

    public Producto(String fabricante, String nombreProducto, int precio) {
        this.fabricante = fabricante;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getPrecio() {
        return precio;
    }
}
