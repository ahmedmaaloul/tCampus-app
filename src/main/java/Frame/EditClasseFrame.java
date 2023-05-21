/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import management.Classe;

/**
 *
 * @author Ahmed
 */
public class EditClasseFrame extends javax.swing.JFrame {

    Classe c;

    /**
     * Creates new form EditClasseFrame
     */
    public EditClasseFrame(Classe c) {
        initComponents();
        this.c = c;
        IdC.setText(Integer.toString(c.getId()));
        Nom.setText(c.getNom());
        Specialite.setText(c.getSpecialite());
        Diplome.setText(c.getDiplome());
        Niveau.setText(c.getNiveau());
        AnneeUni.setText(c.getAnneeUni());
        IdDept.setText(Integer.toString(c.getIdDept()));
                   this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        IdGLabel = new javax.swing.JLabel();
        IdC = new javax.swing.JTextField();
        Nom = new javax.swing.JTextField();
        NomGRPLabel = new javax.swing.JLabel();
        Specialite = new javax.swing.JTextField();
        NumGRPLabel = new javax.swing.JLabel();
        message2 = new javax.swing.JLabel();
        SaveBtn = new javax.swing.JButton();
        Diplome = new javax.swing.JTextField();
        IdClabel = new javax.swing.JLabel();
        IdGLabel1 = new javax.swing.JLabel();
        Niveau = new javax.swing.JTextField();
        IdGLabel2 = new javax.swing.JLabel();
        AnneeUni = new javax.swing.JTextField();
        IdDept = new javax.swing.JTextField();
        IdGLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(80, 107, 208));
        jPanel3.setForeground(new java.awt.Color(22, 129, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tCampus-125.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modifier une Classe");

        IdGLabel.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        IdGLabel.setForeground(new java.awt.Color(255, 255, 255));
        IdGLabel.setText("Identifiant Classe");

        IdC.setBackground(new java.awt.Color(204, 204, 204));
        IdC.setForeground(new java.awt.Color(0, 0, 0));
        IdC.setBorder(null);
        IdC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdCActionPerformed(evt);
            }
        });
        IdC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdCKeyTyped(evt);
            }
        });

        Nom.setBackground(new java.awt.Color(204, 204, 204));
        Nom.setBorder(null);

        NomGRPLabel.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        NomGRPLabel.setForeground(new java.awt.Color(255, 255, 255));
        NomGRPLabel.setText("Nom ");

        Specialite.setBackground(new java.awt.Color(204, 204, 204));
        Specialite.setBorder(null);

        NumGRPLabel.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        NumGRPLabel.setForeground(new java.awt.Color(255, 255, 255));
        NumGRPLabel.setText("Specialité");

        message2.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        message2.setForeground(new java.awt.Color(255, 255, 255));

        SaveBtn.setBackground(new java.awt.Color(204, 204, 204));
        SaveBtn.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        SaveBtn.setForeground(new java.awt.Color(18, 66, 129));
        SaveBtn.setText("Enregistrer");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        Diplome.setBackground(new java.awt.Color(204, 204, 204));
        Diplome.setBorder(null);

        IdClabel.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        IdClabel.setForeground(new java.awt.Color(255, 255, 255));
        IdClabel.setText("Diplôme");

        IdGLabel1.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        IdGLabel1.setForeground(new java.awt.Color(255, 255, 255));
        IdGLabel1.setText("Niveau");

        Niveau.setBackground(new java.awt.Color(204, 204, 204));
        Niveau.setForeground(new java.awt.Color(0, 0, 0));
        Niveau.setBorder(null);
        Niveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NiveauActionPerformed(evt);
            }
        });

        IdGLabel2.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        IdGLabel2.setForeground(new java.awt.Color(255, 255, 255));
        IdGLabel2.setText("Année Universitaire");

        AnneeUni.setBackground(new java.awt.Color(204, 204, 204));
        AnneeUni.setForeground(new java.awt.Color(0, 0, 0));
        AnneeUni.setBorder(null);
        AnneeUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnneeUniActionPerformed(evt);
            }
        });

        IdDept.setBackground(new java.awt.Color(204, 204, 204));
        IdDept.setForeground(new java.awt.Color(0, 0, 0));
        IdDept.setBorder(null);
        IdDept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdDeptActionPerformed(evt);
            }
        });
        IdDept.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdDeptKeyTyped(evt);
            }
        });

        IdGLabel3.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        IdGLabel3.setForeground(new java.awt.Color(255, 255, 255));
        IdGLabel3.setText("Identifiant Departement");

        IdC.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(IdC, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(IdGLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomGRPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdGLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Specialite, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(NumGRPLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Diplome, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(IdClabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(message2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IdGLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(Niveau, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(AnneeUni, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(IdGLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(IdDept, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(21, 21, 21))))
                        .addGap(0, 103, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(95, 95, 95)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdClabel)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IdGLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NomGRPLabel)
                        .addComponent(NumGRPLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IdC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Specialite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Diplome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdGLabel1)
                    .addComponent(IdGLabel2)
                    .addComponent(IdGLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Niveau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnneeUni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdDept, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(message2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IdCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdCActionPerformed

    private void IdCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdCKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_IdCKeyTyped

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        if (this.verifCoordonnees() == -1) {
            return;
        }
        String NomIn = Nom.getText().trim();
        String SpecialiteIn = Specialite.getText();
        String DiplomeIn = Diplome.getText();
        String NiveauIn = Niveau.getText();
        String AnneeUniIn = AnneeUni.getText();
        int IdDeptIn = Integer.valueOf(IdDept.getText());
        c.modifier(NomIn, SpecialiteIn, DiplomeIn, NiveauIn, AnneeUniIn, IdDeptIn);
        c.Consulter(c.getId());
        this.dispose();
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void NiveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NiveauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NiveauActionPerformed

    private void AnneeUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnneeUniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnneeUniActionPerformed

    private void IdDeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdDeptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdDeptActionPerformed

    private void IdDeptKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdDeptKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_IdDeptKeyTyped

    public int verifCoordonnees() {
        String NomIn = Nom.getText().trim();
        String SpecialiteIn = Specialite.getText();
        String DiplomeIn = Diplome.getText();
        String NiveauIn = Niveau.getText();
        String AnneeUniIn = AnneeUni.getText();
        int IdDeptIn = Integer.valueOf(IdDept.getText());
        if (NomIn.length() == 0) {
            displayError("Vous devez donner un nom");
            return -1;
        }
        if (SpecialiteIn.length() == 0) {
            displayError("Vous devez donner une specialité");
            return -1;
        }
        if (DiplomeIn.length() == 0) {
            displayError("Vous devez donner un diplome");
            return -1;
        }
        if (NiveauIn.length() == 0) {
            displayError("Vous devez donner un niveau");
            return -1;
        }
        if (AnneeUniIn.length() == 0) {
            displayError("Vous devez donner une année universitaire");
            return -1;
        }

        if (IdDeptIn <= 0) {
            displayError("Id du departement doit être strictement positive");
            return -1;
        }

        return 0;
    }

    public void displayError(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnneeUni;
    private javax.swing.JTextField Diplome;
    private javax.swing.JTextField IdC;
    private javax.swing.JLabel IdClabel;
    private javax.swing.JTextField IdDept;
    private javax.swing.JLabel IdGLabel;
    private javax.swing.JLabel IdGLabel1;
    private javax.swing.JLabel IdGLabel2;
    private javax.swing.JLabel IdGLabel3;
    private javax.swing.JTextField Niveau;
    private javax.swing.JTextField Nom;
    private javax.swing.JLabel NomGRPLabel;
    private javax.swing.JLabel NumGRPLabel;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField Specialite;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel message2;
    // End of variables declaration//GEN-END:variables
}
