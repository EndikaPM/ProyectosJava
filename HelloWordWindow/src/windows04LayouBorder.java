import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windows04LayouBorder extends JFrame implements ActionListener {
    public windows04LayouBorder() {
        super("Ejemplo de botones y eventos");

        JPanel panel = new JPanel(new BorderLayout( 8,4));

            JButton button = new JButton("Aceptar");
            button.addActionListener(this);
            button.addActionListener(e -> System.out.println("Boton Pulsado Funcion Lambda"));
            button.addActionListener(new BotonClickListtener());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Boton pulsado Clase anonima");
                }
            });
            panel.add(button, BorderLayout.CENTER);
            panel.add(new Button("North"), BorderLayout.NORTH);
            panel.add(new Button("South"), BorderLayout.SOUTH);
            panel.add(new Button("West"), BorderLayout.WEST);
            panel.add(new Button("East"), BorderLayout.EAST);
            //button.setSize(200, 100);
            button.setPreferredSize(new Dimension(200,100));

        setContentPane(panel);
        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new windows04LayouBorder();
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
