import org.endika.anotaciones.ejemplo.JsonArtributo;
import org.endika.anotaciones.models.Producto;
import org.endika.anotaciones.procesador.JsonSerializador;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Producto p = new Producto("mesa de centro roble", 1000L);

        System.out.println("json = " + JsonSerializador.convertirJson(p));
    }
}