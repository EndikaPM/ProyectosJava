import Mamifero.Canino.*;
import Mamifero.Felino.*;
import Mamifero.Mamifero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<Mamifero> mamifero = new ArrayList<>();
        mamifero.add( new Leon("Sabana Africana", 50.6f, 40.9f, 200.6f, "Leoncio", 60,
                10.6f, 12, 20.6f));
        mamifero.add(new Tigre("Selva asiatica", 40.6f,30.6f,100.6f,"Tigreton",50,
                19.5f,"bengala")) ;
        mamifero.add(new Guepardo("sabana Aficana", 35.4f,25.6f,35.1f,"gerardo",60
                ,9.2f));
        mamifero.add(new Lobo("Sierra Eapañola", 10.5f,9.5f,10.4f,"lovezno", "Gris claro"
                ,2.6f,20,"Iberico")) ;
        mamifero.add(new Perro("Ciudad", 5.3f, 4.6f,20.9f,"Brown", "albero", 1.1f,30));


       //QUITAR ESTE COMENTAR DESPUES DE LAS PRUEBAS DE ABAJO
        //mamifero.forEach(System.out::println);
        //System.out.println("----------------");

        Mamifero mam [] = new Mamifero[8];
        mam[0] = new Perro("Prueba", 1.5f, 1.6f, 5.6f,"Stream", "Verde", 1.5f,5);
        mam[1] = new Lobo();
        mam[2] = new Tigre("Prueba", 1.5f, 1.6f, 5.6f,"Stream", 5, 1.5f,"bengala");
        mam[3] = new Guepardo();
        mam[4] = new Perro("Prueba", 1.5f, 1.6f, 5.6f,"Stream", "Verde", 1.5f,5);
        mam[5] = new Leon();
        mam[6] = new Perro("Prueba", 1.5f, 1.6f, 5.6f,"Stream", "Verde", 1.5f,5);
        mam[7] = new Perro("Prueba", 1.5f, 1.6f, 5.6f,"Stream", "Verde", 1.5f,5);
        /*Stream<Mamifero> pruebaStream = Stream.of(mam); este metodo es mejor para los elementos sueltos es decir en vez de parar el arreglo que
        java es los suficientemente listo pra entenderlo en mejor parar los argumentos separados es decir
         Stream<Mamifero> pruebaStream = Stream.of(leon,tigre,guepardo, lobo, perro) clar esta que te falta instanciar cada clase para pasarlo;*/

        Stream<Mamifero> pruebaStream2 = Arrays.stream(mam);
        pruebaStream2.forEach(System.out::println);
    }
}