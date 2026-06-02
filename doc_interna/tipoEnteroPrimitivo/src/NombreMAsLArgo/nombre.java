package NombreMAsLArgo;

import javax.swing.*;

public class nombre {
    public static void main(String[] args) {
        String nombre1 = JOptionPane.showInputDialog(null, "Dime el Primer nombre");
        String nombre2 = JOptionPane.showInputDialog(null, "Dime el Segundo nombre");
        String nombre3 = JOptionPane.showInputDialog(null, "Dime el Ultimo nombre");
        if (nombre1.length() > nombre2.length() && nombre1.length() > nombre3.length()){
            JOptionPane.showMessageDialog(null,nombre1 +" tiene el nombre mas largo");
        } else if (nombre2.length() > nombre1.length() && nombre2.length() > nombre3.length()) {
            JOptionPane.showMessageDialog(null,nombre2 +" tiene el nombre mas largo");
        }else {
            JOptionPane.showMessageDialog(null,nombre3 +" tiene el nombre mas largo");
        }
        
    }
}
