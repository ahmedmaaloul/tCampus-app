package Dashboard;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    private String id;
    private String roles="";
    private EventMenuSelected event;    

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);

    }

      public Menu( ) {
        initComponents();

        this.id = id;
        setOpaque(false);
        listMenu1.setOpaque(false);
        fetchRoles();
    
        init();
    }
    public Menu(String id) {
        initComponents();

        this.id = id;
        setOpaque(false);
        listMenu1.setOpaque(false);
        fetchRoles();
    
        init();
    }

    private void init() {
        if (this.roles.contains("G_CLASSE")) {
            listMenu1.addItem(new Model_Menu("1", "Classes", Model_Menu.MenuType.MENU));
        }
        if (this.roles.contains("G_GRP")) {
                    listMenu1.addItem(new Model_Menu("1", "Groupes", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_ETU")) {
                    listMenu1.addItem(new Model_Menu("1", "Etudiants", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_GM")) {
                    listMenu1.addItem(new Model_Menu("1", "Groupe Modules", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_STG")) {
                    listMenu1.addItem(new Model_Menu("1", "Stages", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_MAT")) {
                    listMenu1.addItem(new Model_Menu("1", "Matieres", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_DEPT")) {
                    listMenu1.addItem(new Model_Menu("1", "Departement", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_ENS")) {
                    listMenu1.addItem(new Model_Menu("1", "Enseignants", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_EVA")) {
                    listMenu1.addItem(new Model_Menu("1", "Evaluations", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_COURS")) {
                    listMenu1.addItem(new Model_Menu("1", "Cours", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_SAL")) {
                    listMenu1.addItem(new Model_Menu("1", "Salles", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_ABS")) {
                    listMenu1.addItem(new Model_Menu("1", "Absences", Model_Menu.MenuType.MENU));

        }
        if (this.roles.contains("G_UTI")) {
                    listMenu1.addItem(new Model_Menu("1", "Utilisateurs", Model_Menu.MenuType.MENU));

        }
             if (this.roles.contains("G_ROLE")) {
        listMenu1.addItem(new Model_Menu("1", "Roles", Model_Menu.MenuType.MENU));

        }


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        listMenu1 = new Dashboard.ListMenu<>();

        panelMoving.setOpaque(false);

        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tCampus-125.png"))); // NOI18N

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        listMenu1.setBackground(new java.awt.Color(60, 63, 65));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {

        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#0575E6"), 0, getHeight(), Color.decode("#021B79"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());

        super.paintChildren(grphcs);

    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {

        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();

            }
        }
        );
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent me) {

                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }

        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Dashboard.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    private void fetchRoles() {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = " Select Description from Role where id=( select idRole from utilisateur where CIN_Passport =?    )";
            PreparedStatement statement = connection.prepareStatement(query);
            System.out.println("this id " + this.id);
            statement.setString(1, this.id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.roles = resultSet.getString(1);

            }

            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
