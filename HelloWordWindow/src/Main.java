import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    createAndShowWindow();
    }
    public static void createAndShowWindow(){


       JFrame frame = new JFrame("Hola Mundo Swing!");
       JLabel text= new JLabel("Hola Mundo !");

       //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cerrando ventana con exito !...");
                System.exit(0);
            }
        });
       frame.getContentPane().add(text);
       frame.setVisible(true);
       frame.pack();
    }
}