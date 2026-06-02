package PruebaStatic;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente c [] = new Cliente[5];
        c[0] = new Cliente("Leon");
        c[1] = new Cliente("Ada");
        c[2] = new Cliente("Ashley");
        c[3] = new Cliente("Chris");
        c[4] = new Cliente("Jessica");

        System.out.println(Arrays.toString(c));

        c = Arrays.copyOf(c, c.length - 1);
        System.out.println(Arrays.toString(c));

        Cliente n = new Cliente("Mizu");
        n.setId();

        System.out.println("\n" + n);

        Cliente c2 [] = new Cliente[2];
        c2[0] = new Cliente("Pedro");
        c2[1] = new Cliente("Luis");

        System.out.println(Arrays.toString(c2));
    }
}