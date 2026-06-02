package arrays;

import java.util.Arrays;

public class numeroMasAlta {
    public static void main(String[] args) {
        int [] numero = new int[7];
        int max = 0, tama = numero.length;

        for (int i = 0; i < tama; i++) {
            numero[i] = (int)(Math.random() * (99-11)) + 11;
            if (max < numero[i]){
                max = numero[i];
            }
        }
        System.out.println(Arrays.toString(numero));
        System.out.println("max = " + max);
    }
}
