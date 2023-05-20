package Frame;

import java.awt.*;
import javax.swing.*;
import management.Role;


public class AjouterRoleFrame extends javax.swing.JFrame {

  
    public AjouterRoleFrame() {
        initComponents();
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public class GradientPanel extends JPanel {

        private Color startColor;
        private Color endColor;

        public GradientPanel() {
            this(Color.red, Color.blue);
        }

        public GradientPanel(Color startColor, Color endColor) {
            this.startColor = startColor;
            this.endColor = endColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            GradientPaint gp = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Nom_Role = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CheckBox_GClasse = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        CheckBox_GGrp = new javax.swing.JCheckBox();
        CheckBox_GEtu = new javax.swing.JCheckBox();
        CheckBox_GGM = new javax.swing.JCheckBox();
        CheckBox_GStag = new javax.swing.JCheckBox();
        CheckBox_GMat = new javax.swing.JCheckBox();
        CheckBox_GDept = new javax.swing.JCheckBox();
        CheckBox_GENS = new javax.swing.JCheckBox();
        CheckBox_GEva = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        CheckBox_GAbs = new javax.swing.JCheckBox();
        CheckBox_GSalle = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        CheckBox_GCours = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        Submit_Role = new javax.swing.JToggleButton();
        CheckBox_GUti = new javax.swing.JCheckBox();
        CheckBox_GRole = new javax.swing.JCheckBox();
        Submit_Role1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        Id_Role = new javax.swing.JTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(24, 119, 242));
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(98, 156, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 153, 153));
        kGradientPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ajouter un Role");
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(32, 43, 364, 45);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nom :");
        kGradientPanel1.add(jLabel2);
        jLabel2.setBounds(240, 110, 180, 35);

        Nom_Role.setBackground(new java.awt.Color(187, 206, 255));
        Nom_Role.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        Nom_Role.setForeground(new java.awt.Color(0, 0, 0));
        Nom_Role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nom_RoleActionPerformed(evt);
            }
        });
        kGradientPanel1.add(Nom_Role);
        Nom_Role.setBounds(240, 140, 179, 27);

        jLabel6.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gestion Groupes");
        kGradientPanel1.add(jLabel6);
        jLabel6.setBounds(240, 190, 120, 35);

        jLabel8.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gestion Classes");
        kGradientPanel1.add(jLabel8);
        jLabel8.setBounds(32, 200, 197, 19);

        CheckBox_GClasse.setForeground(new java.awt.Color(255, 255, 255));
        CheckBox_GClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox_GClasseActionPerformed(evt);
            }
        });
        kGradientPanel1.add(CheckBox_GClasse);
        CheckBox_GClasse.setBounds(30, 230, 19, 19);

        jLabel11.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gestion Etudiants");
        kGradientPanel1.add(jLabel11);
        jLabel11.setBounds(430, 200, 168, 19);

        jLabel12.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gestion GroupeModule");
        kGradientPanel1.add(jLabel12);
        jLabel12.setBounds(30, 260, 197, 19);

        jLabel13.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Gestion Matieres");
        kGradientPanel1.add(jLabel13);
        jLabel13.setBounds(430, 260, 171, 19);

        jLabel14.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Gestion Stages");
        kGradientPanel1.add(jLabel14);
        jLabel14.setBounds(240, 260, 191, 19);

        jLabel15.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gestion Departement");
        kGradientPanel1.add(jLabel15);
        jLabel15.setBounds(30, 330, 197, 19);

        jLabel16.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Gestion Enseignants");
        kGradientPanel1.add(jLabel16);
        jLabel16.setBounds(240, 330, 146, 19);

        jLabel17.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Gestion Evaluations");
        kGradientPanel1.add(jLabel17);
        jLabel17.setBounds(430, 330, 171, 19);

        jLabel18.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Gestion Cours");
        kGradientPanel1.add(jLabel18);
        jLabel18.setBounds(30, 390, 197, 19);

        jLabel20.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Gestion Salles");
        kGradientPanel1.add(jLabel20);
        jLabel20.setBounds(240, 390, 146, 19);

        CheckBox_GGrp.setForeground(new java.awt.Color(255, 255, 255));
        CheckBox_GGrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox_GGrpActionPerformed(evt);
            }
        });
        kGradientPanel1.add(CheckBox_GGrp);
        CheckBox_GGrp.setBounds(240, 230, 19, 19);

        CheckBox_GEtu.setForeground(new java.awt.Color(255, 255, 255));
        CheckBox_GEtu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox_GEtuActionPerformed(evt);
            }
        });
        kGradientPanel1.add(CheckBox_GEtu);
        CheckBox_GEtu.setBounds(430, 230, 19, 19);

        CheckBox_GGM.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(CheckBox_GGM);
        CheckBox_GGM.setBounds(30, 300, 19, 19);

        CheckBox_GStag.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(CheckBox_GStag);
        CheckBox_GStag.setBounds(240, 300, 19, 19);

        CheckBox_GMat.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(CheckBox_GMat);
        CheckBox_GMat.setBounds(430, 300, 19, 19);

        CheckBox_GDept.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(CheckBox_GDept);
        CheckBox_GDept.setBounds(30, 360, 19, 19);

        CheckBox_GENS.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(CheckBox_GENS);
        CheckBox_GENS.setBounds(240, 360, 19, 19);

        CheckBox_GEva.setForeground(new java.awt.Color(255, 255, 255));
        CheckBox_GEva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox_GEvaActionPerformed(evt);
            }
        });
        kGradientPanel1.add(CheckBox_GEva);
        CheckBox_GEva.setBounds(430, 360, 19, 19);

        jLabel21.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Gestion Absences");
        kGradientPanel1.add(jLabel21);
        jLabel21.setBounds(430, 390, 171, 19);

        CheckBox_GAbs.setForeground(new java.awt.Color(255, 255, 255));
        CheckBox_GAbs.setToolTipText("");
        CheckBox_GAbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox_GAbsActionPerformed(evt);
            }
        });
        kGradientPanel1.add(CheckBox_GAbs);
        CheckBox_GAbs.setBounds(430, 420, 19, 19);

        CheckBox_GSalle.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(CheckBox_GSalle);
        CheckBox_GSalle.setBounds(240, 420, 19, 19);

        jLabel22.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Gestion Utilisateurs");
        kGradientPanel1.add(jLabel22);
        jLabel22.setBounds(30, 450, 166, 19);

        CheckBox_GCours.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(CheckBox_GCours);
        CheckBox_GCours.setBounds(30, 420, 19, 19);

        jLabel23.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Gestion Roles");
        kGradientPanel1.add(jLabel23);
        jLabel23.setBounds(240, 450, 153, 19);

        Submit_Role.setText("Annuler");
        Submit_Role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit_RoleActionPerformed(evt);
            }
        });
        kGradientPanel1.add(Submit_Role);
        Submit_Role.setBounds(660, 580, 160, 50);
        kGradientPanel1.add(CheckBox_GUti);
        CheckBox_GUti.setBounds(30, 480, 19, 19);
        kGradientPanel1.add(CheckBox_GRole);
        CheckBox_GRole.setBounds(240, 480, 19, 19);

        Submit_Role1.setText("Ajouter");
        Submit_Role1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit_Role1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(Submit_Role1);
        Submit_Role1.setBounds(470, 580, 160, 50);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Identifiant :");
        kGradientPanel1.add(jLabel3);
        jLabel3.setBounds(30, 110, 180, 35);

        Id_Role.setBackground(new java.awt.Color(187, 206, 255));
        Id_Role.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        Id_Role.setForeground(new java.awt.Color(0, 0, 0));
        Id_Role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_RoleActionPerformed(evt);
            }
        });
        kGradientPanel1.add(Id_Role);
        Id_Role.setBounds(30, 140, 179, 27);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Submit_RoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_RoleActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_Submit_RoleActionPerformed

    private void CheckBox_GAbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox_GAbsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBox_GAbsActionPerformed

    private void CheckBox_GEvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox_GEvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBox_GEvaActionPerformed

    private void CheckBox_GEtuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox_GEtuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBox_GEtuActionPerformed

    private void CheckBox_GGrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox_GGrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBox_GGrpActionPerformed

    private void CheckBox_GClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox_GClasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBox_GClasseActionPerformed

    private void Nom_RoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nom_RoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nom_RoleActionPerformed

    @SuppressWarnings("empty-statement")
    private void Submit_Role1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_Role1ActionPerformed
        int  id=Integer.parseInt(Id_Role.getText()   )   ;
        String nom=Nom_Role.getText();
        String Description = "";

        if (CheckBox_GAbs.isSelected()) {
            Description += "G_ABS";
        };  
        if (CheckBox_GClasse.isSelected()) {
            Description += "G_CLASSE";
        };
        if (CheckBox_GCours.isSelected()) {
            Description += "G_COURS";
        };
        if (CheckBox_GDept.isSelected()) {
            Description += "G_DEPT";
        };
        if (CheckBox_GENS.isSelected()) {
            Description += "G_ENS";
        };
        if (CheckBox_GEva.isSelected()) {
            Description += "G_EVA";
        };
        if (CheckBox_GGM.isSelected()) {
            Description += "G_GM";
        };
        if (CheckBox_GGrp.isSelected()) {
            Description += "G_GRP";
        };
        if (CheckBox_GMat.isSelected()) {
            Description += "G_MAT";
        };
        if (CheckBox_GStag.isSelected()) {
            Description += "G_STG";
        };
        if (CheckBox_GRole.isSelected()) {
            Description += "G_ROLE";
        };
        if (CheckBox_GSalle.isSelected()) {
            Description += "G_SAL";
        };
        if (CheckBox_GUti.isSelected()) {
            Description += "G_UTI";
        };
        if (CheckBox_GEtu.isSelected()) {
            Description += "G_ETU";
        };
        Role temp_role=new Role();
        temp_role.ajouter(id, nom, Description);
        dispose();
    }//GEN-LAST:event_Submit_Role1ActionPerformed

    private void Id_RoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_RoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_RoleActionPerformed

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
            java.util.logging.Logger.getLogger(AjouterRoleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterRoleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterRoleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterRoleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterRoleFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBox_GAbs;
    private javax.swing.JCheckBox CheckBox_GClasse;
    private javax.swing.JCheckBox CheckBox_GCours;
    private javax.swing.JCheckBox CheckBox_GDept;
    private javax.swing.JCheckBox CheckBox_GENS;
    private javax.swing.JCheckBox CheckBox_GEtu;
    private javax.swing.JCheckBox CheckBox_GEva;
    private javax.swing.JCheckBox CheckBox_GGM;
    private javax.swing.JCheckBox CheckBox_GGrp;
    private javax.swing.JCheckBox CheckBox_GMat;
    private javax.swing.JCheckBox CheckBox_GRole;
    private javax.swing.JCheckBox CheckBox_GSalle;
    private javax.swing.JCheckBox CheckBox_GStag;
    private javax.swing.JCheckBox CheckBox_GUti;
    private javax.swing.JTextField Id_Role;
    private javax.swing.JTextField Nom_Role;
    private javax.swing.JToggleButton Submit_Role;
    private javax.swing.JToggleButton Submit_Role1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
