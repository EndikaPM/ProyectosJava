package Menor;

import java.util.Scanner;

public class MultiplicarDosNUmeros {
    public static void main(String[] args) {
        int resu = 0;
        System.out.print("Dime un numero entero: ");
        int num1 = new Scanner(System.in).nextInt();
        System.out.print("Dime otro numero entero: ");
        int num2 = new Scanner(System.in).nextInt();
    if (num1 > 0) {
        for (int i = 0; i < num1; i++) {
            resu += num2;
        }
    }else{
        for (int i = 0; i > num1; i--) {
            resu -= num2;
        }
    }
        System.out.println(num1 +" X  "+ num2 + "= " + resu);
    }
}
