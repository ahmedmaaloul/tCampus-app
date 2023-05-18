/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import management.Classe;

/**
 *
 * @author Ahmed
 */
public class ConsulterClasseFrame extends javax.swing.JFrame {

    Classe c;

    /**
     * Creates new form ConsulterClasseFrame
     */
    public ConsulterClasseFrame(Classe c) {
        initComponents();
        this.c = c;
        IdC.setText(Integer.toString(c.getId()));
        Nom.setText(c.getNom());
        Specialite.setText(c.getSpecialite());
        Diplome.setText(c.getDiplome());
        Niveau.setText(c.getNiveau());
        AnneeUni.setText(c.getAnneeUni());
        IdDept.setText(Integer.toString(c.getIdDept()));
        this.fetchGroupes();
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
        gererJus2 = new javax.swing.JButton();
        SuppBtn2 = new javax.swing.JButton();
        Diplome = new javax.swing.JTextField();
        IdClabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEG = new Panel.TableEG();
        headerEG = new Panel.HeaderEG();
        SearchBtn = new javax.swing.JButton();
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
        jLabel6.setText("Consulter une Classe");

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

        gererJus2.setBackground(new java.awt.Color(204, 204, 204));
        gererJus2.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        gererJus2.setForeground(new java.awt.Color(18, 66, 129));
        gererJus2.setText("Modifier");
        gererJus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gererJus2ActionPerformed(evt);
            }
        });

        SuppBtn2.setBackground(new java.awt.Color(204, 204, 204));
        SuppBtn2.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        SuppBtn2.setForeground(new java.awt.Color(18, 66, 129));
        SuppBtn2.setText("Supprimer");
        SuppBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppBtn2ActionPerformed(evt);
            }
        });

        Diplome.setBackground(new java.awt.Color(204, 204, 204));
        Diplome.setBorder(null);

        IdClabel.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        IdClabel.setForeground(new java.awt.Color(255, 255, 255));
        IdClabel.setText("Diplôme");

        tableEG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "nom", "num"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableEG);

        SearchBtn.setBackground(new java.awt.Color(204, 204, 204));
        SearchBtn.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        SearchBtn.setForeground(new java.awt.Color(0, 102, 51));
        SearchBtn.setText("Rechercher");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

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

        IdGLabel3.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        IdGLabel3.setForeground(new java.awt.Color(255, 255, 255));
        IdGLabel3.setText("Identifiant Departement");

        IdC.setEditable(false);
        Nom.setEditable(false);
        Specialite.setEditable(false);
        Diplome.setEditable(false);
        Niveau.setEditable(false);
        AnneeUni.setEditable(false);
        IdDept.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(message2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdGLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Niveau, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdGLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AnneeUni, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdDept, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdGLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gererJus2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SuppBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(IdGLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(NomGRPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NumGRPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(IdC, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Specialite, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(Diplome, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(IdClabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(headerEG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(84, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(gererJus2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuppBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdGLabel)
                    .addComponent(NomGRPLabel)
                    .addComponent(NumGRPLabel)
                    .addComponent(IdClabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Specialite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Diplome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(IdGLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IdDept, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdGLabel2)
                            .addComponent(IdGLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AnneeUni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Niveau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerEG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Diplome, IdC, Nom, Specialite});

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

    private void gererJus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gererJus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gererJus2ActionPerformed

    private void SuppBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppBtn2ActionPerformed
        int result = JOptionPane.showOptionDialog(null,
                "Voulez-vous continuer ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Oui", "Non"},
                "Non");

        if (result == JOptionPane.YES_OPTION) {
            c.supprimer();
            this.dispose();
        }
    }//GEN-LAST:event_SuppBtn2ActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        this.fetchGroupes();
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void IdCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdCActionPerformed

    private void NiveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NiveauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NiveauActionPerformed

    private void AnneeUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnneeUniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnneeUniActionPerformed

    private void IdDeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdDeptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdDeptActionPerformed

    private void fetchGroupes() {
        // instance mil classe
        //instance.consulter 
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String search = headerEG.getText();
            System.out.println(search);
            String query = "SELECT id,nom,num FROM Groupe WHERE idClasse=" + c.getId();

            if (!search.isEmpty()) {

                query += " AND  nom LIKE '%" + search + "%' OR num LIKE '%" + search + "%'  ";
            }

            ResultSet resultSet = statement.executeQuery(query);

            tableEG.setRowCount(0);
            while (resultSet.next()) {
                Object[] rowData = new Object[6];
                rowData[0] = resultSet.getString("id");
                rowData[1] = resultSet.getString("nom");
                rowData[2] = resultSet.getString("num");
                tableEG.addRow(rowData);
                System.out.println(rowData);
            }

            resultSet.close();
        } catch (SQLException e) {

            e.printStackTrace();

        }

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
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField Specialite;
    private javax.swing.JButton SuppBtn2;
    private javax.swing.JButton gererJus2;
    private Panel.HeaderEG headerEG;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel message2;
    private Panel.TableEG tableEG;
    // End of variables declaration//GEN-END:variables
}
