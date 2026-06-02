package org.endika.java.jdbc.org.endika.java;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class jdbc extends JFrame {

    private Container p;
    private JTextField nameField = new JTextField();
    private JTextField priceField = new JTextField();
    private JTextField quantityField = new JTextField();
    private ProductTableModel tableModel = new ProductTableModel();

    private long id;
    private int row;

    public jdbc() {
        super("Swing: GUI con base de Datos MySQL! ");
        p = getContentPane();
        p.setLayout(new BorderLayout(20, 10));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 20, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton buttonSave = new JButton("Guardar");

        formPanel.add(new JLabel("Nombre: "));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Precio: "));
        formPanel.add(priceField);

        formPanel.add(new JLabel("Canidad: "));
        formPanel.add(quantityField);

        formPanel.add(new JLabel());
        formPanel.add(buttonSave);
        buttonSave.addActionListener(e -> {
            String name = nameField.getText();
            int price = Integer.parseInt(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            if(id == 0){
            Object[] producto = new Object[]{System.currentTimeMillis(), name, price, quantity};
            tableModel.getRows().add(producto);
            tableModel.fireTableDataChanged();
            System.out.println(producto[1]);
            System.out.println(producto[2]);
            System.out.println(producto[3]);
            }else if(id>0){
                tableModel.setValueAt(id, row, 0);
                tableModel.setValueAt(name, row, 1);
                tableModel.setValueAt(price, row, 2);
                tableModel.setValueAt(quantity, row, 3);
            }
            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");

        });

        JPanel tablePanel = new JPanel(new FlowLayout());

        JTable jTable = new JTable();
        jTable.setModel(this.tableModel);
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = jTable.rowAtPoint(e.getPoint());
                int column = jTable.columnAtPoint(e.getPoint());

                if(row > -1 && column > -1){
                    id = (long)tableModel.getValueAt(row, 0);
                    nameField.setText(tableModel.getValueAt(row, 1).toString());
                    priceField.setText(tableModel.getValueAt(row, 2).toString());
                    quantityField.setText(tableModel.getValueAt(row, 3).toString());
                }
            }
        });

        JScrollPane scroll = new JScrollPane(jTable);
        tablePanel.add(scroll);

        p.add(formPanel, BorderLayout.NORTH);
        p.add(tablePanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new jdbc();
    }


    private class ProductTableModel extends AbstractTableModel {

        private String[] columns = {"id", "Nombre", "Precio", "Cantidad"};
        private List<Object[]> rows = new ArrayList<>();

        public List<Object[]> getRows() {
            return rows;
        }

        @Override
        public int getRowCount() {
            return this.rows.size();
        }

        @Override
        public int getColumnCount() {
            return this.columns.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rows.get(rowIndex)[columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return this.columns[column];
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            rows.get(rowIndex)[columnIndex] = aValue;
        }
    }
}
