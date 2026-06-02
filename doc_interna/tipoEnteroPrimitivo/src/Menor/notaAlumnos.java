package Menor;

import java.util.Locale;
import java.util.Scanner;

public class notaAlumnos {
    public static void main(String[] args) {
        double [] notas = new double[20];
        int tama = notas.length;
        double mayor5 = 0.0;
        double inferio4 = 0.0;
        int unos = 0;
        int contadorMaror5 = 0;
        int contadorMenor4 = 0;
        double promedio = 0.0;

        for (int i = 0; i < tama; i++) {
            do {
                System.out.println("Dime la nota del alumno " + (i+1));
                notas[i] = new Scanner(System.in).useLocale(Locale.US).nextDouble();
            }while(notas[i] > 7);

            if (notas[i] == 0) {
                System.err.println("No es posible que la nota sea \"0\"");
                break;
            }
            if (notas[i] >= 5){
               mayor5 += notas[i];
               contadorMaror5++;
            }
            if (notas[i] <= 4) {
                inferio4 += notas[i];
                contadorMenor4++;
            }
            if (notas[i] == 1) {
                unos++;
            }
            promedio += notas[i];
        }
        System.out.println("Las notas mayores a 5 son " + mayor5 / contadorMaror5);
        System.out.println("Las notas menores a 4 son " + inferio4 / contadorMenor4);
        System.out.println("La cantidad de 1 son " + unos);
        System.out.println("El promedio de las notas es " + promedio / tama);
    }
}
