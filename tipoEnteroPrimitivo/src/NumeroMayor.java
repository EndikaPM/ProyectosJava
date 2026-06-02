import javax.swing.*;
import java.util.Scanner;

public class NumeroMayor {
    public static void main(String[] args) {
        System.out.println("Dime un numero: ");
        int num1 = new Scanner(System.in).nextInt();
        System.out.println("Dime otro numero: ");
        int num2 = new Scanner(System.in).nextInt();
        System.out.println("EL numro maximo es " + ((num1 > num2)? num1 + " > " + num2 : num2 +" > " + num1) );


        /*int num0 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un número"));
        int num3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce otro número"));

        JOptionPane.showMessageDialog(null, num1 > num2 ? num1 + " > " + num2 : num2 + " > " + num1);*/
        //idea de maria jose
    }
}
