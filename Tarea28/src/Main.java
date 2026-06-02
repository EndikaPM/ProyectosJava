//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Enum.Tipo;
public class Main {
    public static void main(String[] args) {
        Alfanumerico alf1 = new Alfanumerico(Tipo.Numero);
        Alfanumerico alf2 = new Alfanumerico(Tipo.Letra);

        Thread th1 = new Thread(alf1);
        Thread th2 = new Thread(alf2);

        th1.start();
        th2.start();
    }
}