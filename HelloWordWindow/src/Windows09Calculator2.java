import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windows09Calculator2 extends JFrame implements ActionListener {

    private Container container;
    String total = "";
    String operation = "";
    int aux = 0;
    JLabel result;
    JLabel view;

    public static final String SUMA = "Suma";
    public static final String RESTA = "Resta";
    public static final String MULT = "Multiplication";
    public static final String DIV = "Division";

    public Windows09Calculator2 () throws HeadlessException {
        super("Calculadora con botones");
        container = getContentPane();
        container.setLayout(new BorderLayout(5,5));

        JPanel panelTop = new JPanel(new GridLayout(2, 1,5,5));
        JPanel panelCenter = new JPanel(new GridLayout(5,3, 5,5));
        JPanel panelRight = new JPanel(new GridLayout(5, 1, 5,5));

        container.add(panelTop, BorderLayout.NORTH);
        container.add(panelCenter, BorderLayout.CENTER);
        container.add(panelRight, BorderLayout.EAST);

        panelTop.add(this.view = new JLabel("", SwingConstants.RIGHT));
        panelTop.add(this.result = new JLabel("0", SwingConstants.RIGHT));
        this.view.setFont(new Font("Serif", Font.PLAIN, 16));
        this.result.setFont(new Font("Serif",Font.BOLD,24));

        Border border = panelTop.getBorder();
        Border margin = new EmptyBorder(15, 15 , 15, 15);
        panelTop.setBorder(new CompoundBorder(border, margin));

        JButton ac = new JButton("AC");
        JButton buttonAdd = new JButton("+");
        JButton buttonSubt = new JButton("-");
        JButton buttonMult = new JButton("X");
        JButton buttonDivi = new JButton("%");
        JButton buttonResul = new JButton("=");


        panelCenter.add(ac);
        panelCenter.add(new JLabel());
        panelCenter.add(new JLabel());
        for (int i = 9; i >= 0 ; i--) {
            JButton button = new JButton(String.valueOf(i));
            if (i== 0){
                panelCenter.add(new JLabel());
                panelCenter.add(button);
            }
            panelCenter.add(button);
            button.addActionListener(e -> {
                String valor = e.getActionCommand();
                total += valor;
                this.view.setText(view.getText().concat(valor));

            });
        }
        panelRight.add(buttonAdd);
        panelRight.add(buttonSubt);
        panelRight.add(buttonMult);
        panelRight.add(buttonDivi);
        panelRight.add(buttonResul);

        buttonAdd.addActionListener(this);
        buttonSubt.addActionListener(this);
        buttonMult.addActionListener(this);
        buttonDivi.addActionListener(this);
        buttonResul.addActionListener(e->{
            int value = 0;
            int a = this.aux;
            int b = Integer.parseInt(this.total);

            value = switch (this.operation){
                case "+" ->  a+b;
                case "-" ->  a-b;
                case "X" ->  a*b;
                case "%" ->  a/b;
                default ->  value;
            };
            this.total = String.valueOf(value);
            this.result.setText(total);
        });
        ac.addActionListener(ev -> {
            this.total = "";
            this.operation = "";
            this.aux = 0;
            this.view.setText("");
            this.result.setText("0");
        });

        pack();
        setVisible(true);
        setSize(400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.operation = e.getActionCommand();
        this.aux = Integer.parseInt(this.total);
        this.total = "";
        this.view.setText(view.getText().concat(operation));
    }

    public static void main(String[] args) {
        new Windows09Calculator2();
    }
}
