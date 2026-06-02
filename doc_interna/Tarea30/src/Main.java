import java.util.Arrays;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] almacen = new int[100];
        for (int i = 0; i < almacen.length; i++) {
            almacen[i] = i + 1;
        }
    /*para ver el fintro que se ejecuta abaja con los numeros que se queda
            int[] ver = Arrays.stream(almacen).filter(r->r%10 != 0).toArray();
            System.out.println(Arrays.toString(ver));
    */
        double resultado = Arrays.stream(almacen).filter(r -> r % 10 != 0)
                .mapToDouble(r -> (double) r / 2).reduce(0, (r, re) -> r + re);

        System.out.println("resultado = " + resultado);
    }
}