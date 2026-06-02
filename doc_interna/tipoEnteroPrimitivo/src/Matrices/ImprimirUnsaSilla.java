package Matrices;

import java.util.Scanner;

public class ImprimirUnsaSilla {
    public static void main(String[] args) {
        int tamano = 0;
        System.out.print("Dime el tamaño de el arrays: ");
        tamano = new Scanner(System.in).nextInt();
        if (tamano == 0) {
            System.err.println("ERROR");
            System.exit(1);
        }
        int matriz[][] = new int[tamano][tamano];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == 0 || i == matriz.length /2 || (j == matriz.length -1 && i> matriz.length/2)) {
                    matriz[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}
