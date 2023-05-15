import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Role extends JPanel implements ActionListener {
    private JTable dataTable;
    private JTextField searchInput;
    private JButton searchButton, addButton, prevButton, nextButton;
    private JLabel pageLabel;
    private int currentPage = 1;

    public JPanel getInterface() {
        setLayout(null);
        setBackground(new Color(0xFFFFFF));
        // Title
        JLabel titleLabel = new JLabel("Gestion des Roles");
        
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        titleLabel.setVerticalAlignment(SwingConstants.TOP);
        titleLabel.setFont(new Font("Inter", Font.BOLD, 32));
        titleLabel.setBounds(50, 50, 300, 100);
        add(titleLabel);

        // Search Field
        searchInput = new JTextField(100);
        searchInput.setBounds(10, 250, 500, 35);
        add(searchInput);

        // Search Button
        searchButton = new JButton("Rechercher");
        searchButton.setBounds(520, 250, 150, 35);
        searchButton.setBackground(new Color(0x1681FF));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.addActionListener(this);
        add(searchButton);

        // Add Button
        addButton = new JButton("Ajouter");
        addButton.setBounds(680, 250, 150, 35);
        addButton.setBackground(new Color(0x95D36F));
        addButton.setForeground(new Color(0x231F20));
        addButton.setFocusPainted(false);
        addButton.addActionListener(this);
        add(addButton);

        // Data Table
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Identifiant");
        tableModel.addColumn("Nom");
        tableModel.addColumn("Description");
        tableModel.addColumn("Actions");
        dataTable = new JTable(tableModel); 
        dataTable.setShowVerticalLines(false); // Remove column lines

        
        // IMPORTANT 
         dataTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setFont(new Font("Inter", Font.BOLD, 16));
        setPreferredSize(new Dimension(200, 75)); 
                setHorizontalAlignment(SwingConstants.CENTER); 


                return this;
            }
        });
         
           dataTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
         //
         
         fetchDataRoles();
         
        JScrollPane scrollPane = new JScrollPane(dataTable);

        scrollPane.setBounds(10, 300, 1080, 200);
        add(scrollPane);

        // Pagination Components
        JPanel Table_pages = new JPanel(new BorderLayout());

        
        pageLabel = new JLabel((""+ currentPage));
       
        prevButton = new JButton("<");
         prevButton.setBorderPainted(false); 
        prevButton.setContentAreaFilled(false); 
        nextButton = new JButton(">");
         nextButton.setBorderPainted(false); 
        nextButton.setContentAreaFilled(false); 
        Table_pages.add(prevButton, BorderLayout.WEST);
        Table_pages.add(pageLabel, BorderLayout.CENTER);
        Table_pages.add(nextButton, BorderLayout.EAST);
        Table_pages.setBounds(400, 510, 90, 40);
        add(Table_pages);

        return this;
    }

    
      //-------------------------------------ACTION LISTENERS-------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==searchButton){
                fetchDataRoles();
            }
            else if (e.getSource()==addButton){
                System.out.println("wouiw");
                 AddRoleWindow addForm = new AddRoleWindow();
                 addForm.setVisible(true);
            }


    }
  //-------------------------------------FETCH DATA-------------------------------------------------------

    private void fetchDataRoles()  {
        
        
        
        try ( 
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {
       
            Statement statement = connection.createStatement();
            String search=searchInput.getText();
            
              String query = "SELECT * FROM role";
              
             if (!search.isEmpty()) {
            
            query += " WHERE nom LIKE '%" + search + "%'    OR id LIKE '%"+search+"%' "   ;
        }
            
            ResultSet resultSet = statement.executeQuery(query);
            
            
            DefaultTableModel tableModel = (DefaultTableModel) dataTable.getModel();
            
            
           tableModel.setRowCount(0);
            
            
            while (resultSet.next()) {
                Object[] rowData = new Object[4];
                rowData[0] = resultSet.getString("id");
                rowData[1] = resultSet.getString("nom");
                rowData[2] = resultSet.getString("description");
                rowData[3] = "         !!!!! not done yet :(   !!!!!     ";
                tableModel.addRow(rowData);
            }
            
            
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            
                        e.printStackTrace();

        }
}
    
  //------------------------------------TABLE CELLS DESIGN--------------------------------------------------------

private class CustomTableCellRenderer extends DefaultTableCellRenderer  {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            
            Font font = new Font("Inter", Font.ITALIC, 14);
            setHorizontalAlignment(SwingConstants.CENTER); 
            component.setFont(font);

            return component;
        }
    }
//----------------------------------------ADD NEW ROLE ----------------------------------------


private  class AddRoleWindow extends JFrame implements ActionListener {
    private JTextField IdField, NomField,DescField;
    private JButton submitButton, cancelButton;

    public AddRoleWindow() {
        setTitle("Add Role");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6,1));


        IdField = new JTextField(20);
        
        NomField = new JTextField(20);
            DescField = new JTextField(20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        cancelButton = new JButton("Cancel");
submitButton.addActionListener(this);



    add(IdField);
        add(NomField);
        add(DescField);
        add(submitButton);
        add(cancelButton);

        
                    setSize(720,720);
        setLocationRelativeTo(null); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==submitButton){
                System.out.println("in submit section");

            }
            else if(e.getSource()==cancelButton){
       
            }
    
    
    
}

}

}
