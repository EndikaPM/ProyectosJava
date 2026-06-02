import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main_Scanner {
    public static void main(String[] args) {

       //numeros octal, decimal y binario
        int numDecimal = 500;//cogenmos el 500 como referencia se puede coger cualquiera
        String mensajeBinario = "numero binario de " + numDecimal + " = " + Integer.toBinaryString(numDecimal);
        int numBinario = 0b111110100;
        String mensajeOctal = "numero octal de " + numBinario + " = " + Integer.toOctalString(numBinario);
        int numrOctal = 0764;
        String mensajeHexadecimal = "numero Hexadecimal de "+ numBinario + " = " + Integer.toHexString(numrOctal);


        // --------------------Ventanas de usuario---------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        //String numStr = sc.nextLine();
        int numireoDialogo;
        try{
            numireoDialogo = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Error debe ingresar un numero entero");
            main(args);
            System.exit(0); // es necesario para que termina de ejecutar al llamar al main si no sale un mensaje mas que no debe
        }
        String mensaje = mensajeBinario + System.lineSeparator();
        mensaje += mensajeOctal + System.lineSeparator();
        mensaje += mensajeHexadecimal + System.lineSeparator();
        System.out.println(mensaje);
    }
}