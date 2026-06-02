package Gasolina;

import javax.swing.*;

public class Main_gasolina {
    public static void main(String[] args) {
        Double tanque = Double.parseDouble(JOptionPane.showInputDialog(null, "Dime la capacidad del tanque"));

            if (tanque >= 70) {
                JOptionPane.showMessageDialog(null,"Estanque lleno");
            }else if (tanque < 70 && tanque >=60){
                JOptionPane.showMessageDialog(null,"Estanque case lleno");
            }else if (tanque < 60 && tanque >=40){
                JOptionPane.showMessageDialog(null, "Estanque 3/4");
            } else if (tanque < 40 && tanque >=35) {
                JOptionPane.showMessageDialog(null,"Estanque medio lleno");
            } else if (tanque < 35 && tanque >=20 ) {
                JOptionPane.showMessageDialog(null,"Estanque suficiente");
            }else {
                JOptionPane.showMessageDialog(null, "Estanque insuficiente");
            }
    }
}
