import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    /*byte numeroByte = 127;
        System.out.println("Valor asignado = " + numeroByte);
        System.out.println("tipo de byte corresponde en bytes a " + Byte.BYTES);// cambiar el tipo byte por Short, integer ó Double...
        System.out.println("tipo de byte corresponde en bites a " + Byte.BYTES);
        System.out.println("El valor maximo de byte es:  " + Byte.MAX_VALUE);
        System.out.println("El valor minimo de byte es:   " + Byte.MIN_VALUE);

        // float anotacion cientifica
        float realFloate = 0.000000015F; // 1.5e-10f
        System.out.println("float= " + realFloate);
        System.out.println("float corresponde en byte a = " + Float.BYTES);
        System.out.println("float corresponde en bites a = " + Float.SIZE);
        System.out.println("maximo valor de float = " + Float.MAX_VALUE);
        System.out.println("minimo valor de float = " + Float.MIN_VALUE);

       //numeros octal, decimal y binario
        int numDecimal = 500;//cogenmos el 500 como referencia se puede coger cualquiera
        //System.out.println("numero decimal es= " + numDecimal);
        String mensajeBinario = "numero binario de " + numDecimal + " = " + Integer.toBinaryString(numDecimal);
        //System.out.println(mensajeBinario);
        //binario
        int numBinario = 0b111110100;
        //System.out.println("numBinario = " + numBinario);
        String mensajeOctal = "numero octal de " + numBinario + " = " + Integer.toOctalString(numBinario);
        //System.out.println(mensajeOctal);
        int numrOctal = 0764;
        //System.out.println("numrOctal = " + numrOctal);
        String mensajeHexadecimal = "numero Hexadecimal de "+ numBinario + " = " + Integer.toHexString(numrOctal);
        //System.out.println(mensajeHexadecimal);
        int numHex = 0x1f4;
        //System.out.println("numHex = " + numHex);
        
        int ejemploMJ = 0xf; // 0-9 ;; a-f
        //System.out.println("ejemploMJ = " + ejemploMJ);

        // --------------------Ventanas de usuario---------------------------------------
        String numStr = JOptionPane.showInputDialog(null, "Ingrese un numero");
        int numireoDialogo;
        try{
            numireoDialogo = Integer.parseInt(numStr);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error debe ingresar un numero entero");
            main(args);
            System.exit(0); // es necesario para que termina de ejecutar al llamar al main si no sale un mensaje mas que no debe
        }
        String mensaje = mensajeBinario + System.lineSeparator();
        mensaje += mensajeOctal + System.lineSeparator();
        mensaje += mensajeHexadecimal + System.lineSeparator();
        JOptionPane.showMessageDialog(null,mensaje);*/


        String archivo = "alguna.imagenes.pdf";
        String [] archivoArr = archivo.split("\\.");
        System.out.println(Arrays.toString(archivoArr));
    }
}