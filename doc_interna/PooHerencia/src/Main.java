import com.endika.persona.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("German", "Gonzalez", "45659874L",
                "direcionGerente 4", 1540.4, 10, 15450.65);
        System.out.println("----------------------------------------------------\n"+gerente);

        gerente.setPresupuesto(17459.95);
        gerente.aumentarRemuneracion(10);
        System.out.println("-------------Aumentado los parametros--------------\n" + gerente);
    }
}