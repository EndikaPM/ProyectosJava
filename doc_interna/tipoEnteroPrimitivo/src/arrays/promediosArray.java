package arrays;

import java.util.Scanner;

public class promediosArray {
    public static void main(String[] args) {
        int [] numeros = new int[7];
        int pos = 0, neg = 0, cero = 0, sumaPos = 0, sumaNeg = 0;
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Dime el numero " + (i+1) +": ");
            numeros[i] = new Scanner(System.in).nextInt();
            if (numeros[i] > 0){
                pos++;
                sumaPos += numeros[i];
            } else if (numeros[i]< 0) {
                neg ++;
                sumaNeg += numeros[i];
            }else {cero ++;}
        }
        float promedioPos = (float) sumaPos/pos;
        float promedioNeg = (float) sumaNeg/neg;
        System.out.println("El promedio de los numeros Positivos es " + promedioPos +
                "\n El promedio de los numeros negativo es " + promedioNeg +
                "\n El numero de cerso que hay son " + cero);
    }
}
