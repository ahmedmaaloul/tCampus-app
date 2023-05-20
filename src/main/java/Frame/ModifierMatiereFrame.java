package Frame;

import javax.swing.JFrame;
import management.Matiere;

public class ModifierMatiereFrame extends javax.swing.JFrame {

 private Matiere matiere;

    public ModifierMatiereFrame(Matiere matiere) {
        initComponents();
        this.setResizable(false);
           this.matiere=matiere;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        id_JField.setText(Integer.toString(matiere.getId()  ));
        nom_JFIELD.setText(matiere.getNom());
      
           coeff_JFIELD1.setText(Float.toString(matiere.getCoefficient()));
        vhoraire_JFIELD.setText(Float.toString(matiere.getvHoraire()));

        idGM_JFILED.setText(Integer.toString(matiere.getIdGm()));
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id_JField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nom_JFIELD = new javax.swing.JTextField();
        idGM_JFILED = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        coeff_JFIELD1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        vhoraire_JFIELD = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Modifier = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setForeground(new java.awt.Color(60, 63, 65));
        kGradientPanel1.setkEndColor(new java.awt.Color(98, 156, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(16, 58, 171));
        kGradientPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modifier une Matiere");
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(6, 43, 502, 45);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("identifiant :");
        kGradientPanel1.add(jLabel2);
        jLabel2.setBounds(6, 106, 381, 35);

        id_JField.setEditable(false);
        id_JField.setBackground(new java.awt.Color(187, 206, 255));
        id_JField.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        id_JField.setForeground(new java.awt.Color(0, 0, 0));
        id_JField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_JFieldActionPerformed(evt);
            }
        });
        kGradientPanel1.add(id_JField);
        id_JField.setBounds(6, 153, 370, 39);

        jLabel3.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("nom :");
        kGradientPanel1.add(jLabel3);
        jLabel3.setBounds(6, 198, 381, 35);

        nom_JFIELD.setBackground(new java.awt.Color(187, 206, 255));
        nom_JFIELD.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        nom_JFIELD.setForeground(new java.awt.Color(0, 0, 0));
        nom_JFIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_JFIELDActionPerformed(evt);
            }
        });
        kGradientPanel1.add(nom_JFIELD);
        nom_JFIELD.setBounds(6, 239, 371, 42);

        idGM_JFILED.setEditable(false);
        idGM_JFILED.setBackground(new java.awt.Color(187, 206, 255));
        idGM_JFILED.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        idGM_JFILED.setForeground(new java.awt.Color(0, 0, 0));
        idGM_JFILED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idGM_JFILEDActionPerformed(evt);
            }
        });
        kGradientPanel1.add(idGM_JFILED);
        idGM_JFILED.setBounds(432, 153, 320, 39);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("identifiant  du Classe:");
        kGradientPanel1.add(jLabel6);
        jLabel6.setBounds(393, 564, 414, 35);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("identifiant  du Classe:");
        kGradientPanel1.add(jLabel7);
        jLabel7.setBounds(416, 564, 385, 35);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("identifiant  du Classe:");
        kGradientPanel1.add(jLabel8);
        jLabel8.setBounds(393, 564, 414, 35);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("identifiant  du groupe module:");
        kGradientPanel1.add(jLabel9);
        jLabel9.setBounds(430, 110, 385, 35);

        coeff_JFIELD1.setBackground(new java.awt.Color(187, 206, 255));
        coeff_JFIELD1.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        coeff_JFIELD1.setForeground(new java.awt.Color(0, 0, 0));
        coeff_JFIELD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coeff_JFIELD1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(coeff_JFIELD1);
        coeff_JFIELD1.setBounds(6, 328, 369, 39);

        jLabel11.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(" coefficient :");
        kGradientPanel1.add(jLabel11);
        jLabel11.setBounds(6, 287, 381, 35);

        vhoraire_JFIELD.setBackground(new java.awt.Color(187, 206, 255));
        vhoraire_JFIELD.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        vhoraire_JFIELD.setForeground(new java.awt.Color(0, 0, 0));
        vhoraire_JFIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vhoraire_JFIELDActionPerformed(evt);
            }
        });
        kGradientPanel1.add(vhoraire_JFIELD);
        vhoraire_JFIELD.setBounds(10, 420, 369, 39);

        jLabel12.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("volume Horaire  :");
        kGradientPanel1.add(jLabel12);
        jLabel12.setBounds(10, 380, 381, 35);

        Modifier.setBackground(new java.awt.Color(0, 102, 153));
        Modifier.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        Modifier.setForeground(new java.awt.Color(255, 255, 255));
        Modifier.setText("Confirmer");
        Modifier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 163, 255)));
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });
        kGradientPanel1.add(Modifier);
        Modifier.setBounds(610, 510, 102, 39);

        Annuler.setBackground(new java.awt.Color(0, 102, 153));
        Annuler.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        Annuler.setForeground(new java.awt.Color(255, 255, 255));
        Annuler.setText("Annuler");
        Annuler.setBorder(null);
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        kGradientPanel1.add(Annuler);
        Annuler.setBounds(730, 510, 98, 39);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idGM_JFILEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idGM_JFILEDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idGM_JFILEDActionPerformed

    private void nom_JFIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_JFIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_JFIELDActionPerformed

    private void id_JFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_JFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_JFieldActionPerformed

    private void coeff_JFIELD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coeff_JFIELD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coeff_JFIELD1ActionPerformed

    private void vhoraire_JFIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vhoraire_JFIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vhoraire_JFIELDActionPerformed

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed
             
        Matiere tempMatiere=matiere;
        
        tempMatiere.modifier(nom_JFIELD.getText(), Float.parseFloat(coeff_JFIELD1.getText()),Float.parseFloat(vhoraire_JFIELD.getText())    );
        tempMatiere.consulter(tempMatiere.getId());
        this.dispose();

    }//GEN-LAST:event_ModifierActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
this.dispose();
       
    }//GEN-LAST:event_AnnulerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Modifier;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField coeff_JFIELD1;
    private javax.swing.JTextField idGM_JFILED;
    private javax.swing.JTextField id_JField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField nom_JFIELD;
    private javax.swing.JTextField vhoraire_JFIELD;
    // End of variables declaration//GEN-END:variables

}
