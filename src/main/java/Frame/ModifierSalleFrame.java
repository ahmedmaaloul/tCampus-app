package Frame;

import javax.swing.JFrame;
import management.Salle;


public class ModifierSalleFrame extends javax.swing.JFrame {
  
private int id,capacite;
private String type;
private Boolean contientProjecteur;

    public ModifierSalleFrame(int idSalle,int capacite,String type,Boolean contientProjecteur) {
        initComponents();
        this.setResizable(false);
        id=idSalle;
        this.capacite=capacite;
        this.type=type;
        this.contientProjecteur=contientProjecteur;
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                id_JField.setText( Integer.toString(idSalle) );
                capacite_JFIELD.setText(Integer.toString(capacite));
                Type_JFIELD.setText(type);
                if(contientProjecteur){
                    
                    contientProjecteur_JFIELD.setSelected(true);
                }else{
                    
                       contientPasProjecteur_JFIELD.setSelected(true);
                }
        
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
        capacite_JFIELD = new javax.swing.JTextField();
        Type_JFIELD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Modifier_ROLE = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        contientProjecteur_JFIELD = new javax.swing.JRadioButton();
        contientPasProjecteur_JFIELD = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setForeground(new java.awt.Color(60, 63, 65));
        kGradientPanel1.setkEndColor(new java.awt.Color(98, 156, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(16, 58, 171));

        jLabel1.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modifier une Salle");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("identifiant :");

        id_JField.setEditable(false);
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
        jLabel3.setText("capacité");

        capacite_JFIELD.setBackground(new java.awt.Color(187, 206, 255));
        capacite_JFIELD.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        capacite_JFIELD.setForeground(new java.awt.Color(0, 0, 0));
        capacite_JFIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capacite_JFIELDActionPerformed(evt);
            }
        });

        Type_JFIELD.setBackground(new java.awt.Color(187, 206, 255));
        Type_JFIELD.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        Type_JFIELD.setForeground(new java.awt.Color(0, 0, 0));
        Type_JFIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Type_JFIELDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type");

        Modifier_ROLE.setBackground(new java.awt.Color(0, 102, 153));
        Modifier_ROLE.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        Modifier_ROLE.setForeground(new java.awt.Color(255, 255, 255));
        Modifier_ROLE.setText("Modifier");
        Modifier_ROLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 163, 255)));
        Modifier_ROLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modifier_ROLEActionPerformed(evt);
            }
        });

        Annuler.setBackground(new java.awt.Color(0, 102, 153));
        Annuler.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        Annuler.setForeground(new java.awt.Color(255, 255, 255));
        Annuler.setText("Annuler");
        Annuler.setToolTipText("");
        Annuler.setBorder(null);
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Contient Projecteur");

        buttonGroup1.add(contientProjecteur_JFIELD);
        contientProjecteur_JFIELD.setText("OUI");
        contientProjecteur_JFIELD.setFocusable(false);

        buttonGroup1.add(contientPasProjecteur_JFIELD);
        contientPasProjecteur_JFIELD.setText("NON");

        id_JField.setEditable(false);
        capacite_JFIELD.setEditable(false);
        Type_JFIELD.setEditable(false);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(Modifier_ROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_JField, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(capacite_JFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Type_JFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(contientProjecteur_JFIELD)
                                .addGap(18, 18, 18)
                                .addComponent(contientPasProjecteur_JFIELD)))))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_JField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(contientProjecteur_JFIELD)
                        .addComponent(contientPasProjecteur_JFIELD)))
                .addGap(12, 12, 12)
                .addComponent(capacite_JFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Type_JFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modifier_ROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Modifier_ROLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modifier_ROLEActionPerformed
        
              id=Integer.parseInt(id_JField.getText()   )   ;
         capacite=Integer.parseInt(capacite_JFIELD.getText());
         type=Type_JFIELD.getText();
         contientProjecteur=false;
        if(contientProjecteur_JFIELD.isSelected()==true){
            contientProjecteur=true;
        }
        Salle tempSalle=new Salle(id,capacite,type,contientProjecteur);
        tempSalle.modifier(capacite, type, contientProjecteur);
        
        
    }//GEN-LAST:event_Modifier_ROLEActionPerformed

    private void Type_JFIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Type_JFIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Type_JFIELDActionPerformed

    private void capacite_JFIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capacite_JFIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capacite_JFIELDActionPerformed

    private void id_JFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_JFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_JFieldActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed

dispose();

    }//GEN-LAST:event_AnnulerActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Modifier_ROLE;
    private javax.swing.JTextField Type_JFIELD;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField capacite_JFIELD;
    private javax.swing.JRadioButton contientPasProjecteur_JFIELD;
    private javax.swing.JRadioButton contientProjecteur_JFIELD;
    private javax.swing.JTextField id_JField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables

    
}
