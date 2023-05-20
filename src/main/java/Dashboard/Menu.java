package Dashboard;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

        private EventMenuSelected event;
    public void addEventMenuSelected( EventMenuSelected event){
        this.event=event;
        listMenu1.addEventMenuSelected(event);
        
        
    };
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {
        listMenu1.addItem(new Model_Menu("1", "Accueil", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Classes", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Groupes", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Etudiants", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Groupe Modules", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Stages", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Matieres", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Departement", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Enseignants", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Evaluations", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Cours", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Salles", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Absences", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Utilisateurs", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("Groupes", "Roles", Model_Menu.MenuType.MENU));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        listMenu1 = new Dashboard.ListMenu<>();

        panelMoving.setOpaque(false);

        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tCampus.png"))); // NOI18N

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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
}