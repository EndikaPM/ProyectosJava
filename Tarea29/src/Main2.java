import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Main2 {
    public static void main(String[] args) {
        Map<String, Integer> contador = new HashMap<>();

        Function<String, Map<String,Integer>> limpiar = paramentro ->{
            String[]pala = paramentro.replace(",","")
                    .replace(".","").split(" ");
            int max = 0;
            String palabra = "";
            for (int i = 0; i < pala.length; i++) {
                int cantidad = 0;
                for (int j = 0; j < pala.length; j++) {
                    if (pala[i].equalsIgnoreCase(pala[j])){
                        cantidad++;
                    }
                }
                if (cantidad > max){
                    max = cantidad;
                    palabra = pala[i];
                }
            }
            contador.put(palabra,max);
            return contador;
        };

        Map<String, Integer> res = limpiar.apply("Endika, prueba de repeticion. Endika, Endika Endika, repeticion");
        System.out.println(res);
    }
    //-----------------------MANERA DE MARIA JOSE---------------------------------------------
    /*Function<String, Map <String, Integer>> contador = frase ->
    {
        List<String> palabras = Arrays.stream(frase.replaceAll("[,.]","").split(" ")).toList();
        Map<String, Integer> resultado = new HashMap();
        String p = "";
        int max = 0;

        for (int i = 0; i < palabras.size(); i++)
        {
            int numRepe = Collections.frequency(palabras, palabras.get(i));

            if (max < numRepe)
            {
                p = palabras.get(i);
                max = numRepe;
            }
        }

        resultado.put(p, max);

        return resultado;
    };

        System.out.println(contador.apply("HOLA CARACOLA HOLA HOLA BUENAS CARACOLA " +
                "BUENAS CARACOLA CARACOLA HOLA HOLA CARACOLA CARACOLA"));*/
}
