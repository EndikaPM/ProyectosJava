package Matrices;

public class Pruebas {
    public static void main(String[] args) {
        int[][] numeros = {
                {35, 90, 3, 1978},
                {15, 2020, 10, 5},
                {677, 127, 32767, 1999},
        };

        int elementoBuscado = 32767;
        boolean encontrado = false;
        int i , j = 0;

        salir:
        for (i = 0 ; i < numeros.length; i++) {
            for (j = 0; j < numeros[i].length; j++) {
                if (numeros[i][j] == elementoBuscado) {
                    encontrado = true;
                    break salir;
                }
            }
        }
        if (encontrado) {
            System.out.println("Encontrado " + elementoBuscado + " en las cordenadas =" + i +", "+ j);
        }else {
            System.err.println(elementoBuscado +" no se econtro en la matriz!");
        }
    }
}
