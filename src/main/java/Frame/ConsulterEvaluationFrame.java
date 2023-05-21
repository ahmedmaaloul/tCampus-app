/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import management.Evaluation;

/**
 *
 * @author Ahmed
 */
public class ConsulterEvaluationFrame extends javax.swing.JFrame {
    Evaluation Ev;
    /**
     * Creates new form ConsulterEvaluationFrame
     */
    public ConsulterEvaluationFrame(Evaluation Ev) {
        initComponents();
        this.Ev = Ev;
        IdE.setText(Ev.getIdE());
        IdM.setText(Integer.toString(Ev.getIdM()));
        TypeNote.setText(Ev.getType());
        Note.setText(Float.toString(Ev.getNote()));
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
        IdELabel = new javax.swing.JLabel();
        IdE = new javax.swing.JTextField();
        IdM = new javax.swing.JTextField();
        IdCLabel2 = new javax.swing.JLabel();
        TypeNote = new javax.swing.JTextField();
        TypeNoteLabel = new javax.swing.JLabel();
        message2 = new javax.swing.JLabel();
        gererJus2 = new javax.swing.JButton();
        SuppBtn2 = new javax.swing.JButton();
        Note = new javax.swing.JTextField();
        NoteLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(22, 129, 255));
        jPanel3.setForeground(new java.awt.Color(22, 129, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tCampus-125.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Consulter une Evaluation");

        IdELabel.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        IdELabel.setForeground(new java.awt.Color(255, 255, 255));
        IdELabel.setText("Identifiant de l'Etudiant (CIN/Passport)");

        IdE.setBackground(new java.awt.Color(138, 192, 255));
        IdE.setBorder(null);

        IdM.setBackground(new java.awt.Color(138, 192, 255));
        IdM.setBorder(null);

        IdCLabel2.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        IdCLabel2.setForeground(new java.awt.Color(255, 255, 255));
        IdCLabel2.setText("Identifiant de la Matière");

        TypeNote.setBackground(new java.awt.Color(138, 192, 255));
        TypeNote.setBorder(null);

        TypeNoteLabel.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        TypeNoteLabel.setForeground(new java.awt.Color(255, 255, 255));
        TypeNoteLabel.setText("Type de la Note");

        message2.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        message2.setForeground(new java.awt.Color(255, 255, 255));

        gererJus2.setBackground(new java.awt.Color(138, 192, 255));
        gererJus2.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        gererJus2.setForeground(new java.awt.Color(18, 66, 129));
        gererJus2.setText("Modifier");
        gererJus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gererJus2ActionPerformed(evt);
            }
        });

        SuppBtn2.setBackground(new java.awt.Color(138, 192, 255));
        SuppBtn2.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        SuppBtn2.setForeground(new java.awt.Color(18, 66, 129));
        SuppBtn2.setText("Supprimer");
        SuppBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppBtn2ActionPerformed(evt);
            }
        });

        Note.setBackground(new java.awt.Color(138, 192, 255));
        Note.setBorder(null);

        NoteLabel.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        NoteLabel.setForeground(new java.awt.Color(255, 255, 255));
        NoteLabel.setText("Note");

        IdE.setEditable(false);
        IdM.setEditable(false);
        TypeNote.setEditable(false);
        Note.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 90, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IdELabel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdE, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(IdCLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdM)
                            .addComponent(TypeNoteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TypeNote)
                            .addComponent(NoteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Note))
                        .addGap(152, 152, 152))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(gererJus2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(SuppBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addComponent(message2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(IdELabel)
                .addGap(5, 5, 5)
                .addComponent(IdE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(IdCLabel2)
                .addGap(5, 5, 5)
                .addComponent(IdM, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(TypeNoteLabel)
                .addGap(5, 5, 5)
                .addComponent(TypeNote, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(NoteLabel)
                .addGap(5, 5, 5)
                .addComponent(Note, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(message2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SuppBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gererJus2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gererJus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gererJus2ActionPerformed
    new EditEvaluationFrame(Ev);
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
            Ev.supprimer();
            this.dispose();
        }
    }//GEN-LAST:event_SuppBtn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdCLabel2;
    private javax.swing.JTextField IdE;
    private javax.swing.JLabel IdELabel;
    private javax.swing.JTextField IdM;
    private javax.swing.JTextField Note;
    private javax.swing.JLabel NoteLabel;
    private javax.swing.JButton SuppBtn2;
    private javax.swing.JTextField TypeNote;
    private javax.swing.JLabel TypeNoteLabel;
    private javax.swing.JButton gererJus2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel message2;
    // End of variables declaration//GEN-END:variables
}
