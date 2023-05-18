package interfaces;

import javax.swing.JFrame;
import management.GroupeModule;


public class AjouterGroupeModuleFrame extends javax.swing.JFrame {
  
private int id;
private String nom;
private float coefficient;
private int idClasse;

    public AjouterGroupeModuleFrame(int idGM,String nom,float Coefficient,int idClasse) {
        initComponents();
        this.setResizable(false);
        id=idGM;
        this.nom=nom;
        this.coefficient=Coefficient;
        this.idClasse=idClasse;
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                id_JField.setText( Integer.toString(id) );
                nom_JFIELD.setText(nom);
                coef_JFIELD1.setText(Float.toString(coefficient));

          
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
        jLabel4 = new javax.swing.JLabel();
        Ajouter = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();
        coef_JFIELD1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setForeground(new java.awt.Color(60, 63, 65));
        kGradientPanel1.setkEndColor(new java.awt.Color(98, 156, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(16, 58, 171));

        jLabel1.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ajouter un GroupeModule");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("identifiant :");

        id_JField.setBackground(new java.awt.Color(187, 206, 255));
        id_JField.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        id_JField.setForeground(new java.awt.Color(0, 0, 0));
        id_JField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_JFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("nom :");

        nom_JFIELD.setBackground(new java.awt.Color(187, 206, 255));
        nom_JFIELD.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        nom_JFIELD.setForeground(new java.awt.Color(0, 0, 0));
        nom_JFIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_JFIELDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" coefficient :");

        Ajouter.setBackground(new java.awt.Color(0, 102, 153));
        Ajouter.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        Ajouter.setForeground(new java.awt.Color(255, 255, 255));
        Ajouter.setText("Confirmer");
        Ajouter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 163, 255)));
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

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

        coef_JFIELD1.setBackground(new java.awt.Color(187, 206, 255));
        coef_JFIELD1.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        coef_JFIELD1.setForeground(new java.awt.Color(0, 0, 0));
        coef_JFIELD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coef_JFIELD1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(coef_JFIELD1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_JField, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nom_JFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(434, 434, 434))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_JField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(nom_JFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(coef_JFIELD1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
       
        
        GroupeModule tempGm=new GroupeModule();
        tempGm.ajouter(Integer.parseInt(id_JField.getText()),        nom_JFIELD.getText(),Float.parseFloat(coef_JFIELD1.getText())  );
        dispose();
    }//GEN-LAST:event_AjouterActionPerformed

    private void nom_JFIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_JFIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_JFIELDActionPerformed

    private void id_JFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_JFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_JFieldActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed

        dispose();

    }//GEN-LAST:event_AnnulerActionPerformed

    private void coef_JFIELD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coef_JFIELD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coef_JFIELD1ActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ajouter;
    private javax.swing.JButton Annuler;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField coef_JFIELD1;
    private javax.swing.JTextField id_JField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField nom_JFIELD;
    // End of variables declaration//GEN-END:variables

    
}
