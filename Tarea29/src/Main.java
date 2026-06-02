import java.util.function.Function;


public class Main {
    public static void main(String[] args) {

        Function<String, String> eliminaEspacion = parametro -> parametro.replace(" ", "")
                .replace(",","").replace(".","").toUpperCase();
        /*String res = eliminaEspacion.apply("Esto   es, una  prueba.00");
        System.out.println(res);*/
        System.out.println(eliminaEspacion.apply("Esto   es, una  prueba.00"));
    }
}