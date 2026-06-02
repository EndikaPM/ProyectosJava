package arrays;

import java.util.Arrays;

public class Histograma {
    public static void main(String[] args) {
        int [] histo = new int[12];
        int tam = histo.length;
        int [] repe = new int[6];

        for (int i = 0; i < tam ; i++) {
            histo[i] = (int)(Math.random() * 6) + 1;
            switch (histo[i]){
                case 1 -> repe[0]++;
                case 2 -> repe[1]++;
                case 3 -> repe[2]++;
                case 4 -> repe[3]++;
                case 5 -> repe[4]++;
                case 6 -> repe[5]++;
            }
        }
        System.out.println("-------------ARRAY ----------- \n" +
                "=" + Arrays.toString(histo));
        for (int i = 0; i < 6; i++) {
            System.out.print((i+1) + ": ");
            for (int j = 0; j < repe[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
