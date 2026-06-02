package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class tarea1Array {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int [] a = new int[10];
       int [] b = new int[10];
       int tamano = a.length -1;
        for (int i = 0; i < tamano +1
                ; i++) {
            System.out.print("Dime el numero de la posicion " + i +": ");
            a[i] = sc.nextInt();
        }
        int aux =0;
        for (int i = 0; i < tamano - i; i++) {
            b[aux ++] = a[tamano -i];
            b[aux ++] = a[i];
        }
        System.out.println(Arrays.toString(b));
    }
}
