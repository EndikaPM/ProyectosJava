import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrdenCompra {
    private Integer id = 0;
    private static Integer idIncremente = 0 ;
    private String descripcion;
    private LocalDate fecha;
    private Cliente cliente;
    private Producto [] productos = new Producto[4];
    private int indice;

    public OrdenCompra(String descripcion){
        this.id = ++idIncremente;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setCliente(Cliente cli){
        this.cliente = cli;
    }

    public  void setFecha(String fech){
        DateTimeFormatter formaFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fecha = LocalDate.parse(fech, formaFecha);
    }

    public void addProducto (Producto produ){
        if (productos.length <= 4) {
            productos[indice++] = produ;
        }
    }

    public int sumaPrecios (){
        int sumaPrePro = 0;
        for (int i = 0; i < productos.length; i++) {
            sumaPrePro += productos[i].getPrecio();
        }
        return sumaPrePro;
    }

    @Override
    public String toString(){
        String ticket = "id: " + id + " Descripcion: " + getDescripcion() + " Fecha: " + getFecha() + " Cliente: " + getCliente();
        for (Producto pr: productos){
            ticket += pr.getFabricante() + pr.getPrecio() + pr.getNombreProducto()+"\n";
        }
        ticket += sumaPrecios();
        return ticket;
    }
}
