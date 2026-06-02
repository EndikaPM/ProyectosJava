package areaCirculo;

import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        System.out.print("Dime el radio del circulo: ");
        double radio = new Scanner(System.in).nextDouble();
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("area = " + area);

    }
    //area = PI*r² (Constante PI multiplicado por el radio al cuadrado).
}
