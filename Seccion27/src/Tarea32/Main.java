package Tarea32;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Integer [] arrayNumeros = {0,2,3,6,4,7,30,9,15,85,96,13,10};

        Function<Integer[], Integer> max=  array-> Arrays.stream(array)
            .reduce(0,(maxi,comprobar)
                    ->maxi > comprobar ? maxi : comprobar);
        Integer resu = max.apply(arrayNumeros);
        System.out.println("resultado = " + resu);
        //=============================Solucion con Stream=============================
        /*Stream<Integer> numeros = Stream.of(0,2,3,6,4,7,300,9,15,85,96,13,10);

        Integer resultado = numeros.reduce(0,(a,b)-> a > b ? a : b);
        System.out.println("resultado = " + resultado);*/
        // la función lambda que obtiene el numero mayor del arreglo usando api stream en su implementación

    }
}