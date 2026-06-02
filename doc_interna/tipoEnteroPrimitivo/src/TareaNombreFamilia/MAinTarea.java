package TareaNombreFamilia;

import java.util.Scanner;

public class MAinTarea {
    public static void main(String[] args) {
        String[] nombres = new String[3];

        for (int i = 0; i < nombres.length ; i++){
            System.out.print("Dime el nombre del " + i + " familiar");
            nombres[i] = new Scanner(System.in).nextLine();
        }
        String imprimir = "";
        for (int i = 0; i < nombres.length; i++) {
            char aux = nombres[i].toUpperCase().charAt(1);
            if (i!= 2){
                imprimir += aux + "." + nombres[i].substring(nombres[i].length()-2).toLowerCase() + "_";
            }else{
                imprimir += aux + "." + nombres[i].substring(nombres[i].length()-2).toLowerCase();
            }

        }
        System.out.println(imprimir);
    }
}
