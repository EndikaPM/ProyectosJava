import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windows05CopyText extends JFrame {

    private JTextField fielvalue, result;

    public Windows05CopyText() throws HeadlessException {
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Valor: "));
        fielvalue = new JTextField(5);
        panel.add(fielvalue);

        JButton button = new JButton("Copiar");
        button.addActionListener(new CopyTextActionListener());
        panel.add(button);

        result = new JTextField(5);
        panel.add(result);

        setSize(400, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame frame = new Windows05CopyText();
    }

    private static class CopyTextActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
