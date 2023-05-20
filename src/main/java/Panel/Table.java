package Panel;


import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import underHood.TypeClass;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ahmed
 */
public class Table extends JTable {
// Classe Made for Student Dashboard
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 5) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultEditor(Object.class, new CustomCellEditor(new JTextField()));
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                int columnCount = jtable.getColumnCount();
                if (i1 != columnCount - 1) {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                    com.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);
                    if (selected) {
                        com.setForeground(new Color(15, 89, 140));
                    } else {
                        com.setForeground(new Color(102, 102, 102));
                    }
                    return com;
                } else {
                    TypeClass type = (TypeClass) o;
                    int idE = 0;
                        if (jtable.getValueAt(i, 1) != null) {
                    Object idMValue = jtable.getValueAt(i, 1);
                    if (idMValue instanceof Integer) {
                        idE = (int) idMValue;
                    } else if (idMValue instanceof String) {
                        try {
                            idE = Integer.parseInt((String) idMValue);
                        } catch (NumberFormatException e) {
                            // Handle the case when the value cannot be parsed as an integer
                        }
                    }
                }
                    CellStatus cell = new CellStatus(type, idE);
                    return cell;
                }
            }
        });
        DefaultTableModel model = new DefaultTableModel(0, getColumnCount());
        setModel(model);
    }

    public void setRowCount(int rowCount) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.setRowCount(rowCount);
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    private class CustomCellEditor extends DefaultCellEditor {

        public CustomCellEditor(JTextField textField) {
            super(textField);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (column == getColumnCount() - 1) {
                //CellStatus cell = (CellStatus) value;
                TypeClass type = (TypeClass) value;
           int idE = 0;
                           if (table.getValueAt(row, 1) != null) {
                    Object idMValue = table.getValueAt(row, 1);
                    if (idMValue instanceof Integer) {
                        idE = (int) idMValue;
                    } else if (idMValue instanceof String) {
                        try {
                            idE = Integer.parseInt((String) idMValue);
                        } catch (NumberFormatException e) {
                            // Handle the case when the value cannot be parsed as an integer
                        }
                    }
                }
                CellStatus cell = new CellStatus(type, idE);
                /*JButton button1 = cell.getButton1();
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("hello2");
                    }
                });*/
                return cell;
            } else {
                return super.getTableCellEditorComponent(table, value, isSelected, row, column);
            }
        }

    }

}
