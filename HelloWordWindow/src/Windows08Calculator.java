import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windows08Calculator extends JFrame implements ActionListener {
    Container container;
    JTextField numberA, numberB, resu;

    public static final String CALCULATOR_ADD = "Suma";
    public static final String CALCULATOR_SUBT = "Resta";
    public static final String CALCULATOR_MULT = "Multi";
    public static final String CALCULATOR_DIV = "Divi";
    public static final String CALCULATOR_CLOSE = "Exit";

    public Windows08Calculator() throws HeadlessException {
        super("Calculadora");
        container = getContentPane();
        container.setLayout(new BorderLayout());
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu menu = new JMenu("Operaciones");
        JMenuItem itemAdd = new JMenuItem(CALCULATOR_ADD);
        JMenuItem itemSubt = new JMenuItem(CALCULATOR_SUBT);
        JMenuItem itemMul = new JMenuItem(CALCULATOR_MULT);
        JMenuItem itemDiv = new JMenuItem(CALCULATOR_DIV);

        menu.add(itemAdd);
        menu.add(itemSubt);
        menu.add(itemDiv);
        menu.add(itemMul);

        JMenu closeMenu = new JMenu("Cerrar");
        JMenuItem itemClose = new JMenuItem(CALCULATOR_CLOSE);
        closeMenu.add(itemClose);

        bar.add(menu);
        bar.add(closeMenu);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new Label("Numero 1"));
        panel.add(numberA = new JTextField(3));
        panel.add(new Label("Numero 2"));
        panel.add(numberB = new JTextField(3));
        panel.add(new Label("Resultado"));
        panel.add(resu = new JTextField(5));
        resu.setEditable(false);

        container.add(panel, BorderLayout.CENTER);

        itemAdd.addActionListener(this);
        itemSubt.addActionListener(this);
        itemMul.addActionListener(this);
        itemDiv.addActionListener(this);
        itemClose.addActionListener(this);


        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opereration = e.getActionCommand();
        float a = Float.parseFloat(numberA.getText().trim());
        float b = Float.parseFloat(numberB.getText().trim());
        float reul = 0;
        switch (opereration){
            case CALCULATOR_ADD -> reul = a + b;
            case CALCULATOR_SUBT-> reul = a - b;
            case CALCULATOR_MULT-> reul = a * b;
            case CALCULATOR_DIV-> {
                if(b == 0){
                    resu.setText("Err imposible div por 0");
                    throw new ArithmeticException("No se puede dividir por \"0\"");
                }
                reul = a / b;
            }
            case  CALCULATOR_CLOSE-> System.exit(0);
        }
        resu.setText(String.valueOf(reul));
    }

    public static void main(String[] args) {
        new Windows08Calculator();
    }
}
