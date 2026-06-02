package arrays;

import java.util.Arrays;

public class MayorOcurrencia {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int contador, max = 0, num = 0;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random() * 8) + 1;
        }
        System.out.println(Arrays.toString(numeros));

        for (int i = 0; i < numeros.length; i++) {
            contador = 0;
            for (int j = i; j < numeros.length; j++) {
              if (numeros[i] == numeros[j]) {
                  contador ++;
              }
              if (contador > max){
                  max = contador;
                  num = numeros[i];
              }
            }
        }
        System.out.println("El numero con mas ocurrencias es " + num + " que aparece " + max + " veces.");
    }
}
