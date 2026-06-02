//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EjemplosOrdenes {
    public static void main(String[] args) {
        OrdenCompra orden1 = new OrdenCompra ("Compra del Mercadona");
        orden1.setCliente(new Cliente("Eloisa", "Peréz"));
        orden1.setFecha("08/07/2025");
        orden1.addProducto(new Producto("Manzanas Sara", "Manzana", 2));
        orden1.addProducto(new Producto("Frutas Carmen", "Melocotón", 3));
        orden1.addProducto(new Producto("Hacendado", "Harina", 5));
        orden1.addProducto(new Producto("Don Simón", "Zumo de naranja", 4));

        OrdenCompra orden2 = new OrdenCompra ("Compra del Carrafour");
        orden2.setCliente(new Cliente("Maria", "Peréz"));
        orden2.setFecha("06/07/2025");
        orden2.addProducto(new Producto("Manzanas Grani", "Manzana", 2));
        orden2.addProducto(new Producto("Frutas Carmen", "Melocotón", 3));
        orden2.addProducto(new Producto("Hacendado", "Harina", 5));
        orden2.addProducto(new Producto("Don Simón", "Zumo de naranja", 4));

        OrdenCompra orden3 = new OrdenCompra ("Compra del Media Marckt");
        orden3.setCliente(new Cliente("Cristian", "Domingez"));
        orden3.setFecha("05/07/2025");
        orden3.addProducto(new Producto("Apple", "MacBoock", 1500));
        orden3.addProducto(new Producto("Logiteck", "tecladoL542", 150));
        orden3.addProducto(new Producto("MSI", "Raton Y456", 50));
        orden3.addProducto(new Producto("Delux", "Alfombrilla pad", 10));

        System.out.println("-----ORDEN1-----\n"+orden1);
        System.out.println("-----ORDEN1-----\n"+orden2);
        System.out.println("-----ORDEN1-----\n"+orden3);
    }
}