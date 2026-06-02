import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windows02LayouFlow extends JFrame implements ActionListener {
    public windows02LayouFlow() {
        super("Ejemplo de botones y eventos");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Aceptar".concat(String.valueOf(i)));
            button.addActionListener(this);
            button.addActionListener(e -> System.out.println("Boton Pulsado Funcion Lambda"));
            button.addActionListener(new BotonClickListtener());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Boton pulsado Clase anonima");
                }
            });
            panel.add(button);
            //button.setSize(200, 100);
            button.setPreferredSize(new Dimension(200,100));
        }
        setContentPane(panel);
        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new windows02LayouFlow();
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
