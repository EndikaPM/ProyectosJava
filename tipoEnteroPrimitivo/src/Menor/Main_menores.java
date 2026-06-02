package Menor;
import java.util.Scanner;
public class Main_menores {
    public static void main(String[] args) {
       int [] numeros = new int[10];
       int tama = numeros.length;
       //int min = 2147483647;
        int min = 0;
        for (int i = 0; i < tama; i++) {
            System.out.println("Dime el numero " + (i+1));
            numeros[i] = new Scanner(System.in).nextInt();
            if (i == 0){
                min = numeros[i];
            }
            if (min > numeros[i]){
                min = numeros[i];
            }
        }
        if (min < 10 ){
            System.out.println("El número menor es menor que 10!");
        }else{
            System.out.println("El numero menor es igual o mayor que 10!");
        }
        System.out.println("El numero meno es = "+ min);
    }
}
