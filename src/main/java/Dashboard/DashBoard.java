
package Dashboard;

import Panel.AbsencePanel;
import Panel.ClassePanel;
import Panel.CoursPanel;
import Panel.DepartementPanel;
import Panel.EnseignantPanel;
import Panel.EvaluationPanel;
import Panel.GroupeModulePanel;
import Panel.GroupePanel;
import Panel.MatierePanel;
import Panel.RolePanel;
import Panel.SallePanel;
import Panel.StagePanel;
import Panel.StudentPanel;
import Panel.UtilisateurPanel;
import java.awt.Color;
import javax.swing.JComponent;


public class DashBoard extends javax.swing.JFrame {
private String id;
    
    public DashBoard(String id) {
              this.id=id;
    
     initComponents();

    
        setBackground(new Color(0,0,0,0));
        menu.initMoving(DashBoard.this);
        
        menu.addEventMenuSelected((String gestionNom) -> {
            System.out.println("Selected Index :"+gestionNom);
            
         if("Classes".equals(gestionNom)){
                
                setForm(new ClassePanel() );
            }
            else if("Groupes".equals(gestionNom)){
                
                setForm(new GroupePanel() );
            }
            else if("Etudiants".equals(gestionNom)){
                
                setForm(new StudentPanel() );
            }
            else if("Groupe Modules".equals(gestionNom)){
            
                setForm(new GroupeModulePanel() );
                
            }
            else if("Stages".equals(gestionNom)){
                setForm(new StagePanel() );
                
            }
            else if("Matieres".equals(gestionNom)){
                
                setForm(new MatierePanel());
            }
            else if("Departement".equals(gestionNom)){
                setForm(new DepartementPanel());
                
            }else if("Enseignants".equals(gestionNom)){
                
                setForm(new EnseignantPanel());
            }
            else if("Evaluations".equals(gestionNom)){
                setForm(new EvaluationPanel() );
                
            }
            else if("Cours".equals(gestionNom)){
                
                        setForm(new CoursPanel() );
                
                
            }else if("Salles".equals(gestionNom)){
                 setForm(new SallePanel());
                
            }
            else if("Absences".equals(gestionNom)){
                
                                setForm(new AbsencePanel() );

            }
            else if("Utilisateurs".equals(gestionNom)){
                        setForm(new UtilisateurPanel());
                
            }else if("Roles".equals(gestionNom)){
                setForm(new RolePanel());
                
            }
        });
        this.setVisible(true);
    }
private void setForm (JComponent com) {
    mainPanel.removeAll();
    mainPanel.add(com);
    mainPanel.repaint();
    mainPanel.revalidate();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Dashboard.PanelBorder();
        panelBorder2 = new Dashboard.PanelBorder();
        menu = new Dashboard.Menu(this.id);
        mainPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 849, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private Dashboard.Menu menu;
    private Dashboard.PanelBorder panelBorder1;
    private Dashboard.PanelBorder panelBorder2;
    // End of variables declaration//GEN-END:variables
}
