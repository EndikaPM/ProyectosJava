import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windows01button extends JFrame implements ActionListener {
    public windows01button(){
        super("Ejemplo de botones y eventos");

        JButton boton = new JButton("Aceptar");
        boton.addActionListener(this);
        boton.addActionListener(e -> System.out.println("Boton Pulsado Funcion Lambda"));
        boton.addActionListener(new BotonClickListtener());
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton pulsado Clase anonima");
            }
        });
        getContentPane().add(boton);
        boton.setSize(100,50);
        setSize(200,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new windows01button();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("boton pulsado Firma del metodo");

    }

    private static class BotonClickListtener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Pulsando el boton desde una clase interna !! con beep");
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
