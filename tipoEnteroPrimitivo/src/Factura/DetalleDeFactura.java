package Factura;

import java.util.Scanner;

public class DetalleDeFactura {
    public static void main(String[] args) {
        String nombreFactura;
        System.out.println("Dime el nombre de la factura: ");
        nombreFactura = new Scanner(System.in).nextLine();
        System.out.println("Dime el precio del primer articulo: ");
        double articulo1 = new Scanner(System.in).nextDouble();
        System.out.println("Dime el precio del primer articulo: ");
        double articulo2 = new Scanner(System.in).nextDouble();
        double suma = articulo1 + articulo2;

        double impu = suma * 0.19;
        String resultado = " La factura " + nombreFactura + " tiene un total bruto " + suma + " con impuestos de " + impu + "\n y el total con impuestos es de " + (suma + impu);
        System.out.println(resultado);
    }
}
