package Matrices;

import java.util.Scanner;

public class XconFor {
    public static void main(String[] args) {

        int tamano = 0;
        System.out.println("Dime el tamaño de el arrays: ");
        tamano = new Scanner(System.in).nextInt();
        if (tamano == 0) {
            System.err.println("ERROR");
            System.exit(1);
        } else {
            int matriz[][] = new int[tamano][tamano];
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (i == j || (i + j) == tamano - 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }
        }
    }
}
